package com.izanat.Service;

import com.izanat.Entity.Role;
import com.izanat.Entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Nathalie on 13.04.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getLogin(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getLogin() {
        return user.getLogin();
    }

    public String getEmail(){return user.getEmail();}

    public Role getRole() {
        return user.getRole();
    }

}
