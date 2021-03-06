package com.izanat.Dao.SeriesDAO;

import com.izanat.Entity.Series;
import com.izanat.Entity.User;

import java.util.List;

/**
 * Created by Nathalie on 09.04.2017.
 */
public interface SeriesDaoInterface {
    List<Series> getMostPopularSeries();
    List<Series> getTopRatedSeries();
    List<Series> getAllSeries();
    List<Series> getSeriesWatchedByUser(User user);
    List<Series> getSeriesNotWatchedByUser(User user);
    List<Series> getSeriesUserMightLike(User user);
    void addSeriesToUser(User user, Series series);
    void addRating(int rating, Series series);
    void addSeries(Series series);
    void deleteSeriesFromUser(User user, Series series);
    Series getSeriesByWebsite(String www);
    Series getSeriesByTitle(String title);
}
