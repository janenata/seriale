package com.izanat.Service;

import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;
import com.izanat.Entity.TvStation;

import java.util.List;

/**
 * Created by Nathalie on 17.04.2017.
 */
public interface SiteAnalizerService {

    List<Series> getAllSeries();
    List<Episode> getNewEpisodes(List<Series> series);
    //List<Episode> getAllNewEpisodes();
}
