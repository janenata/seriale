package com.izanat.Entity;

/**
 * Created by Nathalie on 08.04.2017.
 */

public class TvStation {

    private String stationId;
    private String stationWebsite;

    public TvStation(String stationId, String stationWebsite) {
        this.stationId = stationId;
        this.stationWebsite = stationWebsite;
    }

    public TvStation() {
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationWebsite() {
        return stationWebsite;
    }

    public void setStationWebsite(String stationWebsite) {
        this.stationWebsite = stationWebsite;
    }
}
