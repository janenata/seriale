package com.izanat.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

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
