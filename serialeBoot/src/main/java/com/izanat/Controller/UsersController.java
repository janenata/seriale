package com.izanat.Controller;

import com.izanat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nathalie on 13.04.2017.
 */
@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("/static/users.jsp", "users", userService.getAllUsers());
    }

}
