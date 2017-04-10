package com.izanat.Dao.TvStationDAO;

import com.izanat.Entity.TvStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathalie on 10.04.2017.
 */
public class TvStationDao implements TvStationDaoInterface {

    private static class StationRowMapper implements RowMapper<TvStation> {
        @Override
        public TvStation mapRow(ResultSet resultSet, int i) throws SQLException {
            TvStation tvStation = new TvStation();
            tvStation.setStationId(resultSet.getString("station_id"));
            tvStation.setStationWebsite(resultSet.getString("station_website"));
            return tvStation;
        }
    }
//TO DO: test wszystko
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addStation(TvStation tvStation) {
        final String query = "INSERT INTO tv_station VALUES(?, ?)";
        jdbcTemplate.update(query, new Object[]{tvStation.getStationId(), tvStation.getStationWebsite()});
    }

    @Override
    public List<TvStation> getAllStations() {
        final String query = "SELECT station_id, station_website FROM tv_station";
        List<TvStation> stations = jdbcTemplate.query(query, new StationRowMapper());
        return stations;

    }

    @Override
    public TvStation getStation(String stationId) {
        final String query = "SELECT station_id, station_website FROM tv_station WHERE station_id = ?";
        jdbcTemplate.queryForObject(query, new Object[]{stationId}, new StationRowMapper());
        return null;
    }
}
