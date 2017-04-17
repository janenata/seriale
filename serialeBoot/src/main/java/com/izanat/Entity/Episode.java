package com.izanat.Entity;

import java.time.LocalDate;


/**
 * Created by Nathalie on 08.04.2017.
 */
public class Episode {
    private Series series;
    private LocalDate airDate;
    //private Integer episodeNumber;

    public Episode(Series series, LocalDate airDate) {
        this.series = series;
        this.airDate = airDate;
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
    }

  /*  public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }*/
}
