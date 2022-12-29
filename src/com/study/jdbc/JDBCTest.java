package com.study.jdbc;

import java.sql.*;

//TODO JDBC单表增删改查
public class JDBCTest {
    //TODO JDBC 编程流程
    //todo 1. 加载驱动  2.打开链接  3.执行查询  4.处理结果  5.清理环境
    public static void main(String[] args) {
//        insert();
//        update();
//        delete();
        query();
    }

    public static Connection getConnection(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 插入数据
     */
    public static void insert() {
        Connection conn = getConnection();

        try {
            String sql = "insert into tbl_user(name,password,email)" +
                    "values('Tom','123456','tom@gmail.com')";
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("向数据库里插入"+count+"条数据");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     */
    public static void update() {
        Connection conn = getConnection();

        try {
            String sql = "update tbl_user set email = 'tom@126.com' where `name` = 'Tom'";
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("更新数据库"+count+"条数据");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除数据
     */
    public static void delete() {
        Connection conn = getConnection();

        try {
            String sql = "delete from tbl_user where `name` = 'Tom'";
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("删除数据库"+count+"条数据");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据
     */
    public static void query() {
        Connection conn = getConnection();

        try {
            String sql = "select * from tbl_user";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "  ");
                System.out.print(resultSet.getString("name") + "  ");
                System.out.print(resultSet.getString("password") + "  ");
                System.out.print(resultSet.getString("email") + "  ");
                System.out.println();
            }
            System.out.println("查询数据库数据");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
