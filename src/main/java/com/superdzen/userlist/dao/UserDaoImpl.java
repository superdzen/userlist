package com.superdzen.userlist.dao;

import com.superdzen.userlist.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(User user) {
        String sqlQuery = "insert into users (first_name) values (?)";
        jdbcTemplate.update(sqlQuery, user.getFirstName());
    }

    @Override
    public List<User> listUsers() {
        String sqlQuery = "select * from users";
        List<User> users = jdbcTemplate.query(sqlQuery, new UserMapper());
        return users;
    }

    @Override
    public List<User> listUsers(String filter) {
        String sqlQuery = "select * from users where first_name like ?";
        Object[] args = new Object[]{"%" + filter + "%"};
        List<User> users = jdbcTemplate.query(sqlQuery, args, new UserMapper());
        return users;
    }

}
