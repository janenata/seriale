package com.izanat.Controller;

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

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("/static/index.jsp");
        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");
        //tu trzeba będzie dać listę serial, ale ja jeszcze nie do końca ogarniam
        //jak tu wszystko działa z tymi bazami i podstawowe zapytanie niestety nie zadziałalo
        model.addObject("lista",list);
        return model;
    }

}
