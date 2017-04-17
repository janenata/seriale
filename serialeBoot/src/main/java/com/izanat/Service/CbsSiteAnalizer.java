package com.izanat.Service;

import com.izanat.Dao.SeriesDAO.SeriesDao;
import com.izanat.Dao.TvStationDAO.TvStationDao;
import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nathalie on 17.04.2017.
 */
@Service
public class CbsSiteAnalizer implements SiteAnalizerService {

    public static final String CBS = "CBS";
    private TvStationDao tvStationDao;
    private SeriesDao seriesDao;

    @Autowired
    public CbsSiteAnalizer(TvStationDao tvStationDao, SeriesDao seriesDao) {
        this.tvStationDao = tvStationDao;
        this.seriesDao = seriesDao;
    }

    @Override
    public List<Series> getAllSeries() {
        List<Series> seriesList = new LinkedList<Series>();
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

        return seriesList;
    }

    @Override
    public List<Episode> getNewEpisodes(List<Series> seriesList) {
        List<Episode> episodes = new LinkedList<Episode>();

        try {
            Document doc = Jsoup.connect(tvStationDao.getStation(CBS).getStationWebsite() + "/schedule/").get();
            Elements shows = doc.select("a.showTitle");
            for (Element sh : shows) {
                if (seriesList.stream().anyMatch(s -> s.getTitle().equals(sh.html()))) {
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
