package com.izanat.Entity;

/**
 * Created by Nathalie on 08.04.2017.
 */
public class Series {
    private String title;
    private String seriesWebsite;
    private String station;
    private Double rating;
   // private int votes; //nie wiem czy potrzebujemy, czy nie wystarczy że baza bedzie sobie to liczyła i zmieniała w zapytaniu
    //może trzeba dodać image? bo możnaby wyświetlać na stronie

    public Series(String title, String seriesWebsite, String station) {
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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    /*public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }*/
}
