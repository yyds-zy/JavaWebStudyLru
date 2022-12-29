package com.study.jdbc.service;

import com.study.jdbc.dao.UserDao;
import com.study.jdbc.dao.impl.UserDaoImpl;
import com.study.jdbc.entity.User;
import com.study.jdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean check(User user){
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            connection.setAutoCommit(false);
            ResultSet resultSet = userDao.getLoginInfo(connection, user);
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
