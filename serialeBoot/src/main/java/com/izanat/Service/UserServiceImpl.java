package com.izanat.Service;

import com.izanat.Dao.UserDAO.UserDaoInterface;
import com.izanat.Dao.UserDAO.UserRepository;
import com.izanat.Entity.User;
import com.izanat.Entity.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Nathalie on 13.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  UserDaoInterface userDao;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDaoInterface userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public User getUser(String login) { return userDao.getUser(login);}

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("login"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

}
