package com.izanat.Controller;

import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import com.izanat.Service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@RestController
@RequestMapping("/")
public class TmpController {
    @Autowired
    private TmpService tmpService;


    @RequestMapping(value = "users",method = RequestMethod.GET)
    public Collection<User> getAllStudents(){
        return tmpService.getAllUsers();
    }

    @RequestMapping(value = "popular",method = RequestMethod.GET)
    public Collection<Series> getMostPopularSeries() {return tmpService.getMostPopularSeries();}

    @RequestMapping(value = "top",method = RequestMethod.GET)
    public Collection<Series> getTopRatedSeries() {return tmpService.getTopRatedSeries();}

    @RequestMapping(value = "series",method = RequestMethod.GET)
    public Collection<Series> getAllSeries() {return tmpService.getAllSeries();}

    @RequestMapping(value = "watched",method = RequestMethod.GET)
    public Collection<Series> getSeriesWatchedByUser(User user) {return tmpService.getSeriesWatchedByUser(user);}

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Collection<Series> getSeriesUserMightLike(@PathVariable("name") String user) {return tmpService.getSeriesUserMightLike(user);}

    @RequestMapping(value = "/rating/{rate}", method = RequestMethod.GET)
    public void addRating(@PathVariable("rate")int rating, Series series) { tmpService.addRating(rating, series);}

    @RequestMapping(value = "/add/{name}-{series}", method = RequestMethod.GET)
    public void addSeriesToUser(@PathVariable("name")String user, @PathVariable("series")String series) { tmpService.addSeriesToUser(user, series);}

}
