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

            return serie;
        }
    }


    @Override
    public List<Series> getMostPopularSeries() {
        //nie wiem co z image bo nie mamy w klasie Series--mógłby nam się przydać do wyświetlania na stronie ???
        final String query = "SELECT title, series_website, station_id, rating  FROM watched_series NATURAL JOIN series GROUP BY title ORDER BY COUNT(title) DESC LIMIT 3;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }


    @Override
    public List<Series> getTopRatedSeries() {
        final String query = "SELECT title, series_website, station_id, rating FROM series ORDER BY Rating DESC LIMIT 3;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }

    @Override
    public List<Series> getAllSeries() {
        final String query = "SELECT title, series_website, station_id, rating FROM series;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper());
        return series;
    }

    @Override
    public List<Series> getSeriesWatchedByUser(User user) {
        final String query = "SELECT title, series_website, station_id, rating FROM watched_series NATURAL JOIN series WHERE login = ?;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper(), user.getLogin());
        return series;
    }

    @Override
    public List<Series> getSeriesUserMightLike(User user) {
        final String query = "SELECT title, series_website, station_id, rating \n" +
                "FROM watched_series NATURAL JOIN series\n" +
                "WHERE login IN (\n" +
                "SELECT login FROM watched_series WHERE title IN (\n" +
                "SELECT title FROM watched_series WHERE login=?\n" +
                ")\n" +
                " ) AND login != ? AND title NOT IN(SELECT title FROM watched_series WHERE login=?)\n" +
                "GROUP BY title\n" +
                "ORDER BY COUNT(title) DESC\n" +
                "LIMIT 5;";
        List<Series> series = jdbcTemplate.query(query, new SeriesRowMapper(), new Object[]{user.getLogin(), user.getLogin(),user.getLogin()});
        return series;
    }

    @Override
    public void addSeriesToUser(User user, Series series) {
        final String query = "INSERT INTO watched_series VALUES (?, ?);";
        jdbcTemplate.update(query, new Object[]{user.getLogin(), series.getTitle()});

    }

    @Override
    public void addRating(int rating, Series series) {
        final String query = "UPDATE series SET Rating = (Rating*Votes + ? )/(Votes +1) WHERE title = ?; " ;
        jdbcTemplate.update(query, new Object[]{rating, series.getTitle()});
        final String query2 = "UPDATE series Set Votes = Votes +1 WHERE title = ?;";
        jdbcTemplate.update(query2, series.getTitle());
    }
}
