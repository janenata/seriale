package com.izanat.Dao.SeriesDAO;

import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathalie on 09.04.2017.
 */

//przetestowane
@Repository
public class SeriesDao implements SeriesDaoInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class SeriesRowMapper implements RowMapper<Series> {

        @Override
        public Series mapRow(ResultSet resultSet, int i) throws SQLException {
            Series serie = new Series();
            serie.setTitle(resultSet.getString("title"));
            serie.setSeriesWebsite(resultSet.getString("series_website"));
            serie.setStation(resultSet.getString("station_id"));
            serie.setRating(resultSet.getDouble("rating"));
            serie.setImageLink(resultSet.getString("image"));

            return serie;
        }
    }


    @Override
    public List<Series> getMostPopularSeries() {
        final String query = "SELECT title, series_website, station_id, rating, image  FROM watched_series NATURAL JOIN series GROUP BY title ORDER BY COUNT(title) DESC LIMIT 3;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }


    @Override
    public List<Series> getTopRatedSeries() {
        final String query = "SELECT title, series_website, station_id, rating, image FROM series ORDER BY Rating DESC LIMIT 3;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }

    @Override
    public List<Series> getAllSeries() {
        final String query = "SELECT title, series_website, station_id, rating, image FROM series;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }

    @Override
    public List<Series> getSeriesWatchedByUser(User user) {
        final String query = "SELECT title, series_website, station_id, rating, image FROM watched_series NATURAL JOIN series WHERE login = ?;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper(), user.getLogin());
        return series;
    }

    @Override
    public List<Series> getSeriesNotWatchedByUser(User user) {
        final String query = "SELECT title, series_website, station_id, rating, image FROM series WHERE title NOT IN(  SELECT title FROM watched_series NATURAL JOIN series WHERE login = ?);";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper(), user.getLogin());
        return series;
    }

    @Override
    public List<Series> getSeriesUserMightLike(User user) {
        final String query = "SELECT title, series_website, station_id, rating, image \n" +
                "FROM watched_series NATURAL JOIN series " +
                "WHERE login IN ( " +
                "SELECT login FROM watched_series WHERE title IN ( " +
                "SELECT title FROM watched_series WHERE login=? " +
                ") " +
                " ) AND login != ? AND title NOT IN(SELECT title FROM watched_series WHERE login=?) " +
                "GROUP BY title " +
                "ORDER BY COUNT(title) DESC " +
                "LIMIT 5;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper(), new Object[]{user.getLogin(), user.getLogin(), user.getLogin()});
        return series;
    }

    @Override
    public void addSeriesToUser(User user, Series series) {
        final String query = "INSERT IGNORE INTO watched_series VALUES (?, ?);";
        jdbcTemplate.update(query, new Object[]{user.getLogin(), series.getTitle()});

    }

    @Override
    public void addRating(int rating, Series series) {
        final String query = "UPDATE series SET Rating = (Rating*Votes + ? )/(Votes +1) WHERE title = ?; ";
        jdbcTemplate.update(query, new Object[]{rating, series.getTitle()});
        final String query2 = "UPDATE series Set Votes = Votes +1 WHERE title = ?;";
        jdbcTemplate.update(query2, series.getTitle());
    }

    @Override
    public void addSeries(Series series) {
        final String query = "INSERT IGNORE INTO series VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{series.getTitle(), series.getSeriesWebsite(), series.getStation(), series.getImageLink(), 0, 0});
    }

    @Override
    public void deleteSeriesFromUser(User user, Series series) {
        final String query = "DELETE FROM watched_series WHERE login = ? and title = ?;";
        jdbcTemplate.update(query, new Object[]{user.getLogin(), series.getTitle()});
    }

    @Override
    public Series getSeriesByTitle(String t) {
        final String query = "SELECT title, series_website, station_id, rating, image FROM series WHERE title = ?";
        Series series = jdbcTemplate.queryForObject(query, new Object[]{t}, new SeriesRowMapper());
        return series;
    }

    @Override
    public Series getSeriesByWebsite(String w) {
        final String query = "SELECT title, series_website, station_id, rating, image FROM series WHERE series_website = ?";
        Series series = jdbcTemplate.queryForObject(query, new Object[]{w}, new SeriesRowMapper());
        return series;
    }
}
