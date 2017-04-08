package com.izanat.Entity;

/**
 * Created by Nathalie on 08.04.2017.
 */
public class Series {
    private String title;
    private String seriesWebsite;
    private TvStation station;
    private Double rating;
    private int votes;

    public Series(String title, String seriesWebsite, TvStation station) {
        this.title = title;
        this.seriesWebsite = seriesWebsite;
        this.station = station;
    }

    public Series() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeriesWebsite() {
        return seriesWebsite;
    }

    public void setSeriesWebsite(String seriesWebsite) {
        this.seriesWebsite = seriesWebsite;
    }

    public TvStation getStation() {
        return station;
    }

    public void setStation(TvStation station) {
        this.station = station;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
