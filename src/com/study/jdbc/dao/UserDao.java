package com.study.jdbc.dao;

import com.study.jdbc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //保存用户信息
    void save(Connection conn, User user) throws SQLException;

    //更新用户信息
    void update(Connection conn,Long id,User user) throws SQLException;

    //删除用户信息
    void delete(Connection conn,User user) throws SQLException;

    //查询用户信息
    List<User> query(Connection conn) throws SQLException;

    //
    ResultSet getLoginInfo(Connection conn, User user) throws SQLException;
}
