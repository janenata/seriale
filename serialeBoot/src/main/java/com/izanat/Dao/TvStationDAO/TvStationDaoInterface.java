package com.izanat.Dao.TvStationDAO;

import com.izanat.Entity.TvStation;

import java.util.List;

/**
 * Created by Nathalie on 10.04.2017.
 */
public interface TvStationDaoInterface {
    void addStation(TvStation tvStation);
    List<TvStation> getAllStations();
    TvStation getStation(String stationId);

}
