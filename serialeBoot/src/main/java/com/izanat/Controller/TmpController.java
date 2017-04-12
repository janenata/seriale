package com.izanat.Controller;

import com.izanat.Dao.CommentDAO.CommentDao;
import com.izanat.Dao.TvStationDAO.TvStationDao;
import com.izanat.Dao.UserDAO.UserDAO;
import com.izanat.Entity.Comment;
import com.izanat.Entity.Series;
import com.izanat.Entity.TvStation;
import com.izanat.Entity.User;
import com.izanat.Service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@Controller
public class TmpController {
    @Autowired
    private TmpService tmpService;

    @Autowired
    private TvStationDao tvStationDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    @Qualifier("mysql")
    private UserDAO userDAO;

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("/static/home.html");
        return model;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @RequestMapping(value = "/addUser/{login}-{pass}-{email}", method = RequestMethod.GET)
    public void addUser(@PathVariable("login") String login, @PathVariable("pass") String pass, @PathVariable("email") String email) {
        userDAO.addUser(new User(login, pass, email));
    }

    @RequestMapping(value = "/changePass/{login}-{newpass}", method = RequestMethod.GET)
    public void addUser(@PathVariable("login") String login, @PathVariable("newpass") String newpass) {
        userDAO.changePassword(login, newpass);
    }

    @RequestMapping(value = "popular", method = RequestMethod.GET)
    public Collection<Series> getMostPopularSeries() {
        return tmpService.getMostPopularSeries();
    }

    @RequestMapping(value = "top", method = RequestMethod.GET)
    public Collection<Series> getTopRatedSeries() {
        return tmpService.getTopRatedSeries();
    }

    @RequestMapping(value = "series", method = RequestMethod.GET)
    public Collection<Series> getAllSeries() {
        return tmpService.getAllSeries();
    }

    @RequestMapping(value = "watched", method = RequestMethod.GET)
    public Collection<Series> getSeriesWatchedByUser(User user) {
        return tmpService.getSeriesWatchedByUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Collection<Series> getSeriesUserMightLike(@PathVariable("name") String user) {
        return tmpService.getSeriesUserMightLike(user);
    }

    @RequestMapping(value = "/rating/{rate}", method = RequestMethod.GET)
    public void addRating(@PathVariable("rate") int rating, Series series) {
        tmpService.addRating(rating, series);
    }

    @RequestMapping(value = "/add/{name}-{series}", method = RequestMethod.GET)
    public void addSeriesToUser(@PathVariable("name") String user, @PathVariable("series") String series) {
        tmpService.addSeriesToUser(user, series);
    }

    @RequestMapping(value = "/addStation/{statId}-{statWWW}", method = RequestMethod.GET)
    public void addStation(@PathVariable("statId") String stationId, @PathVariable("statWWW") String stationWebsite) {
        tvStationDao.addStation(new TvStation(stationId, stationWebsite));
    }

    @RequestMapping(value = "stations", method = RequestMethod.GET)
    public Collection<TvStation> getAllStations() {
        return tvStationDao.getAllStations();
    }

    @RequestMapping(value = "station/{statId}", method = RequestMethod.GET)
    public TvStation getStations(@PathVariable("statId") String statId) {
        return tvStationDao.getStation(statId);
    }

    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public Collection<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @RequestMapping(value = "deleteComment/{num}", method = RequestMethod.GET)
    public void deleteComment(@PathVariable("num") Integer num) {
        commentDao.deleteComment(num);
    }

    @RequestMapping(value = "/addComment/{title}-{text}-{login}-{series}", method = RequestMethod.GET)
    public void addComment(@PathVariable("title") String title, @PathVariable("text") String text, @PathVariable("login") String login, @PathVariable("series") String series) {
        commentDao.addComment(new Comment(1, title, text, series, login));
    }


}
