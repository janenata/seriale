package com.izanat.Controller;

import com.izanat.Entity.Episode;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
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
        return addParams();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, params = "rate")
    public ModelAndView addRating(HttpServletRequest request, @RequestParam String rate) {
        String rating = request.getParameter("rating");
        seriesService.addRating(Integer.parseInt(rating), seriesService.getSeriesByTitle(rate));
        return addParams();

    }

    private ModelAndView addParams() {
        ModelAndView model = new ModelAndView("/static/user.jsp");
        LocalDate now = LocalDate.now().plusDays(1);

        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Episode> episodes = seriesService.getUserSchedule(user.getUser());
        model.addObject("userSchedule", episodes);
        model.addObject("user", user);
        List<Series> seriesList = seriesService.getSeriesWatchedByUser(userService.getUser(user.getLogin()));
        List<Episode> tomorrow = new ArrayList<>();
        List<Episode> notTomorrow = new ArrayList<>();
        for (Episode e : episodes) {
            if ((e.getAirDate()).isEqual(now)) {
                tomorrow.add(e);
            } else {
                notTomorrow.add(e);
            }
        }
        model.addObject("tomorrow", tomorrow);
        model.addObject("notTomorrow", notTomorrow);
        model.addObject("userSeries", seriesList);
        model.addObject("allSeries", seriesService.getAllSeries());
        model.addObject("topRated", seriesService.getTopRatedSeries());
        model.addObject("youMightLike", seriesService.getSeriesUserMightLike(user.getUser()));
        model.addObject("mostPopular", seriesService.getMostPopularSeries());
        return model;
    }


}
