package com.izanat.Service;

import com.izanat.Entity.Episode;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nathalie on 19.04.2017.
 */
@Service
public class EmailService {
    @Autowired
    UserService userService;
    @Autowired
    SeriesService seriesService;


    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.enable")
    private String enable;

    /*@Scheduled(cron = "0 48 17 * * *")*/
    public void sendEpisodesEmails() {
        List<User> users = new ArrayList<>(userService.getAllUsers());
        LocalDate today = LocalDate.now();
        for (User u : users) {
            List<Episode> episodes = seriesService.getUserSchedule(u);
            List<Episode> todayEpisodes = new LinkedList<>();
            for (Episode ep : episodes) {
                if (ep.getAirDate().isEqual(today.plusDays(1))) {
                    todayEpisodes.add(ep);
                }
            }
            /*if(!todayEpisodes.isEmpty())*/
            sendEmail(u.getEmail(), todayEpisodes);
        }

    }


    private void send(MimeMessagePreparator mimeMessagePreparator) {
        mailSender.send(mimeMessagePreparator);
    }


    public void sendEmail(String emailAddress, List<Episode> list) {
        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setTo(emailAddress);
                messageHelper.setFrom(new InternetAddress("izanatseries@onet.pl"));
                messageHelper.setSubject("New episodes are waiting for you!");
                String text = "Leave everything and go watch IzaNatSeries!\n Episodes airing today:\n";
                for (Episode ep : list) {
                    text += ep.getSeries().getTitle() + "\n";

                }
                text += "\n \n Happy watching!!! \n IzanatSeries Team";
                text += "\n \n \n--- This message was generated automatically. Please don't reply ---";

                messageHelper.setText(text);
            }
        };
        send(messagePreparator);
    }
}
