package com.izanat.Service;

import com.izanat.Dao.SeriesDAO.SeriesDao;
import com.izanat.Dao.SeriesDAO.SeriesDaoInterface;
import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nathalie on 15.04.2017.
 */
@Service
public class SeriesService {

    private SeriesDao seriesDao;

    @Autowired
    public SeriesService(SeriesDao seriesDao){
        this.seriesDao = seriesDao;
    }

    public List<Series> getMostPopularSeries() {
        return seriesDao.getMostPopularSeries();
    }


    public List<Series> getTopRatedSeries() {
        return seriesDao.getTopRatedSeries();
    }


    public List<Series> getAllSeries() {
        return seriesDao.getAllSeries();
    }


    public List<Series> getSeriesWatchedByUser(User user) {
        return seriesDao.getSeriesWatchedByUser(user);
    }


    public List<Series> getSeriesUserMightLike(User user) {
        return seriesDao.getSeriesWatchedByUser(user);
    }


    public void addSeriesToUser(User user, Series series) {
        seriesDao.addSeriesToUser(user, series);
    }


    public void addRating(int rating, Series series) {
        seriesDao.addRating(rating, series);
    }


    public void addSeries(Series series) {
        seriesDao.addSeries(series);
    }
}
