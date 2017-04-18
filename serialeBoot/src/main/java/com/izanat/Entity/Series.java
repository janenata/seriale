package com.izanat.Entity;

/**
 * Created by Nathalie on 08.04.2017.
 */
public class Series {
    private String title;
    private String seriesWebsite;
    private String station;
    private String imageLink;
    private Double rating;


    public Series(String title, String seriesWebsite, String station, String imageLink) {
        this.title = title;
        this.seriesWebsite = seriesWebsite;
        this.station = station;
        this.imageLink = imageLink;

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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Series series = (Series) o;

        return title != null ? title.equals(series.title) : series.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
