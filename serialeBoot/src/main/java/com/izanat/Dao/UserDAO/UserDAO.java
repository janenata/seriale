
package com.izanat.Dao.UserDAO;

import com.izanat.Entity.Role;
import com.izanat.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


/**
 * Created by Nathalie on 08.04.2017.
 */


@Repository
public class UserDAO implements UserDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setLogin(resultSet.getString("login"));
            user.setPasswordHash(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(Role.USER);
            return user;
        }
    }

    @Override
    public void addUser(User user) {
        final String query = "INSERT INTO users VALUES(?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{user.getLogin(), user.getPasswordHash(), user.getEmail()});
    }

    @Override
    public void changePassword(String login, String newPass) {
        final String query = "UPDATE users SET password = ? WHERE login = ?";
        jdbcTemplate.update(query, new Object[]{newPass, login});
    }

    @Override
    public User getUser(String login) {
        final String query = "SELECT login, password, email FROM users WHERE login = ?";
        User user = jdbcTemplate.queryForObject(query, new Object[]{login}, new UserRowMapper());
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        final String query = "SELECT login, password, email FROM users; ";
        List<User> users = jdbcTemplate.query(query, new UserRowMapper());
        return users;
    }
    @Override
    public boolean checkPassword(String login, String password) {
        final String query = "SELECT (CASE WHEN  password = ? then 1 else 0 END) FROM users WHERE login = ?;";
        int odp = jdbcTemplate.queryForObject(query, new Object[]{password, login}, Integer.class);
        if (odp == 1) return true;
        else return false;
    }


}

