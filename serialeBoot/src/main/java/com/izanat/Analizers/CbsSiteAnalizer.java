package com.izanat.Analizers;

import com.izanat.Dao.SeriesDAO.SeriesDao;
import com.izanat.Dao.TvStationDAO.TvStationDao;
import com.izanat.Dao.UserDAO.UserDAO;
import com.izanat.Dao.UserDAO.UserDaoInterface;
import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nathalie on 17.04.2017.
 */
@Component
public class CbsSiteAnalizer implements SiteAnalizer {

    public static final String CBS = "CBS";
    private TvStationDao tvStationDao;
    private SeriesDao seriesDao;
    private UserDAO userDao;

    private List<Series> seriesList;
    private Map<User, LinkedList<Episode>> usersEpisodesMap;

    @Autowired
    public CbsSiteAnalizer(TvStationDao tvStationDao, SeriesDao seriesDao, UserDAO userDao) {
        this.tvStationDao = tvStationDao;
        this.seriesDao = seriesDao;
        this.userDao = userDao;

    }

    @Override
    public List<Series> getAllSeries() {
        if (seriesList == null) {
            seriesList = new LinkedList<>();
            fetchAllSeries();
        }
        return seriesList;
    }

    @Scheduled(cron = "30 58 15 * * *")
    public void fetchAllSeries() {
        seriesList.clear();
        try {
            Document doc = Jsoup.connect(tvStationDao.getStation(CBS).getStationWebsite() + "/shows/").get();
            Elements shows = doc.select("li.showPosterWrapper");
            for (Element show : shows) {
                Element link = show.select("a[href]").first();
                Series serie = new Series();
                serie.setSeriesWebsite(tvStationDao.getStation(CBS).getStationWebsite() + link.attr("href"));
                serie.setStation(CBS);
                Elements img = link.select("img");
                serie.setTitle(img.attr("title"));
                serie.setImageLink(img.attr("src"));
                seriesList.add(serie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


/*    public List<Episode> getNewEpisodes(User user) {
        if (usersEpisodesMap == null) {
            usersEpisodesMap = new HashMap<>();
            getNewEpisodesForAllUsers();
        }
        return usersEpisodesMap.get(user);
    }

//@Scheduled(cron="30 58 15 * * *")
    public void getNewEpisodesForAllUsers() {
        usersEpisodesMap.clear();
        for (User u : userDao.getAllUsers()) {
            usersEpisodesMap.put(u, fetchNewEpisodes(seriesDao.getSeriesWatchedByUser(u)));

        }

    }*/

    @Override
    public LinkedList<Episode> getNewEpisodes(List<Series> seriesList) {
        LinkedList<Episode> episodes = new LinkedList<>();

        try {
            Document doc = Jsoup.connect(tvStationDao.getStation(CBS).getStationWebsite() + "/schedule/").get();
            Elements shows = doc.select("a.showTitle");
            for (Element sh : shows) {
                if (seriesList.stream().anyMatch(s -> s.getSeriesWebsite().equals(sh.attr("href")))) {
                    Episode ep = new Episode();
                    ep.setSeries(seriesDao.getSeriesByWebsite(sh.attr("href")));
                    String mouse = sh.attr("onMouseOver");
                    String[] parts = mouse.split(", '");
                    String date = parts[2].substring(0, 10);
                    String time = parts[1].substring(0, 5);
                    String datetime = date + " " + time;
                    ZoneId zone = ZoneId.of("America/New_York");
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm").withZone(zone);
                    ZonedDateTime localDateTime = ZonedDateTime.parse(datetime, fmt).withZoneSameInstant(ZoneId.of("Europe/Paris"));
                    LocalDate localDate = localDateTime.toLocalDate();
                    LocalTime localTime = localDateTime.toLocalTime();
                    ep.setAirDate(localDate);
                    ep.setAirTime(localTime);
                    episodes.add(ep);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return episodes;
    }

/*    @Override
    public List<Episode> getAllNewEpisodes() {
        List<Episode> episodes = new LinkedList<Episode>();
        try {
            Document doc = Jsoup.connect(tvStationDao.getStation(CBS).getStationWebsite() + "/schedule/").get();
            Elements shows = doc.select("a.showTitle");
            for (Element sh : shows) {
                    Episode ep = new Episode();
                    ep.setSeries(seriesDao.getSeriesByTitle(sh.html()));
                    String mouse = sh.attr("onMouseOver");
                    String[] parts = mouse.split(", '");
                    String date = parts[2].substring(0, 10);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    ep.setAirDate(localDate);
                    String time = parts[1].substring(0, 5);
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime localTime = LocalTime.parse(time, formatter2);
                    ep.setAirTime(localTime);

                    episodes.add(ep);
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return episodes;
    }*/
}
