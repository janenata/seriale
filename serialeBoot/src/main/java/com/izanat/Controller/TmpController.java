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


    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("/static/index.jsp");
        return model;
    }




}
