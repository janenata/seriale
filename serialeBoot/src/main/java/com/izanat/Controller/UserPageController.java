package com.izanat.Controller;

import com.izanat.Entity.User;
import com.izanat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

/**
 * Created by Nathalie on 14.04.2017.
 */
@Controller
public class UserPageController {
    private final UserService userService;

    @Autowired
    public UserPageController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/user/{login}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable String login) {
        ModelAndView model=  new ModelAndView("/static/user.jsp");
        User user = userService.getUserByLogin(login).orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", login)));
        model.addObject("user", user);
        return model;
    }


}
