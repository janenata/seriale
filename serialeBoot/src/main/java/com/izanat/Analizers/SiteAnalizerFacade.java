package com.izanat.Analizers;

import com.izanat.Entity.Episode;
import com.izanat.Entity.Series;

import java.util.List;

/**
 * Created by Nathalie on 19.04.2017.
 */
public class SiteAnalizerFacade implements SiteAnalizer{

    @Override
    public List<Series> getAllSeries() {
        return null;
    }

    @Override
    public List<Episode> getNewEpisodes(List<Series> series) {
        return null;
    }
}
