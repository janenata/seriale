package com.izanat.Service;

import com.izanat.Entity.User;
import com.izanat.Entity.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Nathalie on 13.04.2017.
 */
public interface UserService {

    Optional<User> getUserByLogin(String login);

    User getUser(String login);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
