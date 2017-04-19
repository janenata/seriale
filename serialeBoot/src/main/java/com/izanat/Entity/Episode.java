package com.izanat.Entity;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Created by Nathalie on 08.04.2017.
 */
public class Episode {
    private Series series;
    private LocalDate airDate;
    private LocalTime airTime;

    public String getDay() {

        return day.substring(0,1)+day.substring(1,day.length()).toLowerCase();
    }

    public void setDay(String day) {
        this.day = day;
    }

    private String day;

    public Episode(Series series, LocalDate airDate, LocalTime airTime) {
        this.series = series;
        this.airDate = airDate;
        this.airTime = airTime;
        day = String.valueOf(airDate.getDayOfWeek());
    }

    public Episode() {
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
        day = String.valueOf(airDate.getDayOfWeek());
    }

    public LocalTime getAirTime() {
        return airTime;
    }

    public void setAirTime(LocalTime airTime) {
        this.airTime = airTime;
    }
}
