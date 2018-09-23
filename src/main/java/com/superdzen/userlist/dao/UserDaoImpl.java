package com.superdzen.userlist.dao;

import com.superdzen.userlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    public void setTransactionTemplate(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Override
    public void insert(User user) {
        transactionTemplate.execute(status -> {
            String sqlQuery = "insert into users (first_name) values (?)";
            jdbcTemplate.update(sqlQuery, user.getFirstName());
            return null;
        });
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
