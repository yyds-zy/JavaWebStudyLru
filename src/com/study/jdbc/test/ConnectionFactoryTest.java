package com.study.jdbc.test;

import com.study.jdbc.dao.UserDao;
import com.study.jdbc.dao.impl.UserDaoImpl;
import com.study.jdbc.entity.User;
import com.study.jdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConnectionFactoryTest {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = ConnectionFactory.getInstance();
        Connection conn = factory.getConnection();
        System.out.println(conn.getAutoCommit());

        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.query(conn);
        System.out.println(userList.size());

        userDao.save(conn,new User("Nine","23234","nine@gamil.com"));
    }
}
