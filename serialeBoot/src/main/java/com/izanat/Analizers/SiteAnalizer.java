package com.izanat.Analizers;

import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;

import java.util.List;

/**
 * Created by Nathalie on 17.04.2017.
 */
public interface SiteAnalizer {

    List<Series> getAllSeries();
    List<Episode> getNewEpisodes(List<Series> series);

}
