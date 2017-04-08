package com.izanat.Service;

import com.izanat.Dao.UserDAO.UserDAO;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
@Service
public class TmpService {
    @Autowired
    @Qualifier("mysql")
    private UserDAO userDAO;

    public Collection<User> getAllUsers(){
        return userDAO.getAllUsers();
    }



}
