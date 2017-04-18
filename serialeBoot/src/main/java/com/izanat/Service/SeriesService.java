package com.izanat.Service;

import com.izanat.Dao.SeriesDAO.SeriesDao;
import com.izanat.Dao.SeriesDAO.SeriesDaoInterface;
import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 15.04.2017.
 */
@Service
public class SeriesService {

    private SeriesDao seriesDao;
    private SiteAnalizerService siteAnalizer;

    @Autowired
    public SeriesService(SeriesDao seriesDao, SiteAnalizerService siteAnalizer){
        this.seriesDao = seriesDao;
        this.siteAnalizer = siteAnalizer;
    }

    public List<Series> getMostPopularSeries() {
        return seriesDao.getMostPopularSeries();
    }

    public Series getSeriesByTitle(String title){
        return seriesDao.getSeriesByTitle(title);
    }

    public List<Series> getSeriesNotWatchedByUser(User user){
        List<Series> seriesNotWatchedByUser = siteAnalizer.getAllSeries();
        seriesNotWatchedByUser.removeAll(seriesDao.getSeriesWatchedByUser(user));
        return seriesNotWatchedByUser;
    }

    public List<Series> getTopRatedSeries() {
        return seriesDao.getTopRatedSeries();
    }

    public List<Series> getAllWatchedSeries() { return seriesDao.getAllSeries();}


    public List<Series> getAllSeries() {
        return siteAnalizer.getAllSeries();
    }

    public List<Episode>  getUserSchedule(User user) {
        return siteAnalizer.getNewEpisodes(getSeriesWatchedByUser(user));
    }


    public List<Series> getSeriesWatchedByUser(User user) {
        return seriesDao.getSeriesWatchedByUser(user);
    }


    public List<Series> getSeriesUserMightLike(User user) {
        return seriesDao.getSeriesUserMightLike(user);
    }


    public void addSeriesToUser(User user, Series series) {
        seriesDao.addSeries(series);
        seriesDao.addSeriesToUser(user, series);
    }


    public void addRating(int rating, Series series) {
        seriesDao.addRating(rating, series);
    }


    public void addSeries(Series series) {
        seriesDao.addSeries(series);
    }

    public void deleteSeriesFromUser(User user, Series series){
        seriesDao.deleteSeriesFromUser(user,series);
    }

/*    public List<Episode> getAllNewEpisodes(){
        return siteAnalizer.getAllNewEpisodes();
    }*/
}
