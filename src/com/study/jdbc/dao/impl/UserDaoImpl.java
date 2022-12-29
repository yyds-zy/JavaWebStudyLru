package com.study.jdbc.dao.impl;

import com.study.jdbc.dao.UserDao;
import com.study.jdbc.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(Connection conn, User user) throws SQLException {
        String insertSql = "insert into tbl_user(`name`,password,email) values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insertSql);
//        PreparedStatement ps = conn
//                .prepareCall("insert into tbl_user(`name`,password,email) values (?,?,?)");
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.execute();
    }

    @Override
    public void update(Connection conn, Long id, User user) throws SQLException {
        String updateSql = "update tbl_user `name` = ?, password = ?, email = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(updateSql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setLong(4,user.getId());
        ps.execute();
    }

    @Override
    public void delete(Connection conn, User user) throws SQLException {
         String deleteSql = "delete from tbl_user where id = ?";
         PreparedStatement ps = conn.prepareStatement(deleteSql);
         ps.setLong(1,user.getId());
         ps.execute();
    }

    @Override
    public List<User> query(Connection conn) throws SQLException {
        List<User> userList = new ArrayList<>();
        userList.clear();
        String querySql = "select * from tbl_user";
        PreparedStatement ps = conn.prepareStatement(querySql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            userList.add(new User(name,password,email));
        }
        ps.execute();
        return userList;
    }

    @Override
    public ResultSet getLoginInfo(Connection conn, User user) throws SQLException {
        String queryLoginInfo = "select * from tbl_user where `name` = ? and password = ?";
        PreparedStatement ps = conn.prepareStatement(queryLoginInfo);
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        return ps.executeQuery();
    }
}
