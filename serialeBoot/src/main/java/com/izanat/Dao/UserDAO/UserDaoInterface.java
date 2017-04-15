package com.izanat.Dao.UserDAO;

import com.izanat.Entity.User;

import java.util.Collection;

/**
 * Created by Nathalie on 08.04.2017.
 */
public interface UserDaoInterface {
    void addUser(User user);
    void changePassword(String login, String newPass);
    User getUser(String login);

    //for testing
    Collection<User> getAllUsers();

    boolean checkPassword(String login, String password);
}
