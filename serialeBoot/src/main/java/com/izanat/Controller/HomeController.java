package com.izanat.Controller;

import com.izanat.Entity.Series;
import com.izanat.Service.CurrentUser;
import com.izanat.Service.SeriesService;
import com.izanat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 13.04.2017.
 */
@Controller
public class HomeController {

    private final SeriesService seriesService;

    @Autowired
    public HomeController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("/static/index.jsp");
        model.addObject("lista",seriesService.getAllSeries());
        return model;
    }

}
