package com.izanat.Controller;

import com.izanat.Entity.Series;
import com.izanat.Service.CurrentUser;
import com.izanat.Service.SeriesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Izochora on 2017-04-16.
 */
@Controller
public class AddSeriesToUserController {
    private SeriesService seriesService;

    public AddSeriesToUserController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @RequestMapping(value = "/addUserToSeries", method = RequestMethod.GET)
    public ModelAndView getUserPage() {
        ModelAndView model=  new ModelAndView("/static/addSeriesToUser.jsp");
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("user", user);
        model.addObject("allSeries",seriesService.getAllSeries());
        return model;
    }
}
