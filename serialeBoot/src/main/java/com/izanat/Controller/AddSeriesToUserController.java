package com.izanat.Controller;

import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import com.izanat.Service.CurrentUser;
import com.izanat.Service.SeriesService;
import com.izanat.Service.UserService;
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

    public AddSeriesToUserController(SeriesService seriesService, UserService userService) {
        this.seriesService = seriesService;
        this.userService = userService;
    }

    @RequestMapping(value = "/editSeries", method = RequestMethod.GET)
    public ModelAndView getUserPage() {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return addParams(user);
    }

    @RequestMapping(value = "/editSeries",method = RequestMethod.POST,params="add")
    public ModelAndView addSeries(@RequestParam String add) {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        seriesService.addSeriesToUser(user.getUser(),seriesService.getSeriesByTitle(add));
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
        model.addObject("notUserSeries",seriesService.getSeriesNotWatchedByUser(user.getUser()));
        model.addObject("userSeries", seriesList);
        return model;
    }

}
