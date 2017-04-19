package com.izanat.Controller;

import com.izanat.Analizers.SiteAnalizer;
import com.izanat.Entity.Series;
import com.izanat.Service.CurrentUser;
import com.izanat.Service.SeriesService;
import com.izanat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Izochora on 2017-04-16.
 */
@Controller
public class AddSeriesToUserController {
    private SeriesService seriesService;
    private UserService userService;
    private SiteAnalizer siteAnalizer;

    @Autowired
    public AddSeriesToUserController(SeriesService seriesService, UserService userService, SiteAnalizer siteAnalizer) {
        this.seriesService = seriesService;
        this.userService = userService;
        this.siteAnalizer = siteAnalizer;
    }

    @RequestMapping(value = "/editSeries", method = RequestMethod.GET)
    public ModelAndView getUserPage() {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return addParams(user);
    }

    @RequestMapping(value = "/editSeries",method = RequestMethod.POST, params = "add")
    public ModelAndView addSeries(@RequestParam String add) {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Series> seriesList = siteAnalizer.getAllSeries();
        for(Series ser : seriesList){
            if(ser.getTitle().equals(add)) { seriesService.addSeriesToUser(user.getUser(),ser); break;}
        }

        return addParams(user);
    }

    @RequestMapping(value = "/editSeries",method = RequestMethod.POST,params="delete")
    public ModelAndView deleteSeries(@RequestParam String delete) {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        seriesService.deleteSeriesFromUser(user.getUser(),seriesService.getSeriesByTitle(delete));
        return addParams(user);
    }

    private ModelAndView addParams(CurrentUser user){
        ModelAndView model=  new ModelAndView("/static/addSeriesToUser.jsp");
        model.addObject("user", user);
        List<Series> seriesList = seriesService.getSeriesWatchedByUser(userService.getUser(user.getLogin()));
        model.addObject("mostPopular",seriesService.getMostPopularSeries());
        model.addObject("topRated",seriesService.getTopRatedSeries());
        model.addObject("youMightLike",seriesService.getSeriesUserMightLike(user.getUser()));
        model.addObject("notUserSeries",seriesService.getSeriesNotWatchedByUser(user.getUser()));
        model.addObject("userSeries", seriesList);
        return model;
    }

}
