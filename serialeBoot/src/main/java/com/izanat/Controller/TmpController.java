package com.izanat.Controller;

import com.izanat.Entity.User;
import com.izanat.Service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@RestController
@RequestMapping("/users")
public class TmpController {
    @Autowired
    private TmpService tmpService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllStudents(){
        return tmpService.getAllUsers();
    }



}
