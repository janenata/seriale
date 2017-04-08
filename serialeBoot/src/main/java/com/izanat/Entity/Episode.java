package com.izanat.Entity;

import java.time.LocalDateTime;

/**
 * Created by Nathalie on 08.04.2017.
 */
public class Episode {
    private Series series;
    private LocalDateTime airDate;
    private Integer episodeNumber;

    public Episode(Series series, LocalDateTime airDate, Integer episodeNumber) {
        this.series = series;
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
    }

    public Episode() {
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public LocalDateTime getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDateTime airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
