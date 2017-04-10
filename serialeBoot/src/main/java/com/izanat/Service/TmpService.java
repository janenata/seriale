package com.izanat.Service;

import com.izanat.Dao.SeriesDAO.SeriesDao;
import com.izanat.Dao.TvStationDAO.TvStationDao;
import com.izanat.Dao.UserDAO.UserDAO;
import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@Service
public class TmpService {



    @Autowired
    private SeriesDao seriesDao;



    public Collection<Series> getMostPopularSeries() {
        return seriesDao.getMostPopularSeries();
    }

    public Collection<Series> getTopRatedSeries() {
        return seriesDao.getTopRatedSeries();
    }

    public Collection<Series> getAllSeries() {
        return seriesDao.getAllSeries();
    }

    public Collection<Series> getSeriesWatchedByUser(User user) {
        User userek = new User("nat", "pass", "nat@gmail.com");
        return seriesDao.getSeriesWatchedByUser(userek);
    }

    public Collection<Series> getSeriesUserMightLike(String user) {
        User userek = new User(user, "pass", "nat@gmail.com");
        return seriesDao.getSeriesUserMightLike(userek);
    }

    public void addRating(int rating, Series series) {
        Series ser = new Series("CSI:Miami", "http://www.cbs.com/shows/csi-miami/","CBS", "/");
        seriesDao.addRating(rating, ser);
    }

    public void addSeriesToUser(String user, String series) {
        User userek = new User("nat", "pass", "nat@gmail.com");
        Series ser = new Series("CSI:Miami", "http://www.cbs.com/shows/csi-miami/","CBS", "/");
        seriesDao.addSeriesToUser(userek, ser);
    }


}
