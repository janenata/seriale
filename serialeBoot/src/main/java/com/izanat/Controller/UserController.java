package com.izanat.Controller;

import com.izanat.Entity.UserCreateForm;
import com.izanat.Service.UserService;
import com.izanat.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Nathalie on 13.04.2017.
 */
@Controller
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;


    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;

    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }


    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("/static/user_create.jsp", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST )
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/static/user_create.jsp";
        }
        try {
            userService.create(form);


        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("login.exists", "login already exists");
            return "/static/user_create.jsp";
        }


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(form.getLogin(), form.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return "redirect:/user";
    }

}
