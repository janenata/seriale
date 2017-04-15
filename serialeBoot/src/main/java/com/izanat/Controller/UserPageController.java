package com.izanat.Controller;

import com.izanat.Entity.Series;
import com.izanat.Entity.User;
import com.izanat.Service.CurrentUser;
import com.izanat.Service.SeriesService;
import com.izanat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Nathalie on 14.04.2017.
 */
@Controller
public class UserPageController {
    private final UserService userService;
    private final SeriesService seriesService;

    @Autowired
    public UserPageController(UserService userService, SeriesService seriesService) {
        this.userService = userService;
        this.seriesService = seriesService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage() {
        ModelAndView model=  new ModelAndView("/static/user.jsp");
       // User user = userService.getUserByLogin(login).orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", login)));
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("user", user);
        List<Series> seriesList = seriesService.getSeriesWatchedByUser(userService.getUser(user.getLogin()));
        model.addObject("userSeries", seriesList);
        model.addObject("allSeries",seriesService.getAllSeries());
        return model;
    }


}
