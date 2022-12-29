package com.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TODO jdbc事务管理
public class JDBCTransaction {

    //多用户同事操作数据  事务解决并发问题   要么都执行要么都不执行   事务是维持数据库一致性的单位

    //事务特点   原子性  事务包含的操作是一个逻辑单元      一致性  事务开始之前与结束以后  状态一致
    //隔离性    多个事务彼此隔离   事务是独立的 互补影响   持久性   事务对数据库的操作是真实存在的

    //事务相关SQL语句
    //beginTransaction   rollBackTransaction  commitTransaction

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC",
                    "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertUserData(Connection connection) throws SQLException {
        String sql = "insert into tbl_user(id,`name`,password,email)" +
                "values(10,'Tom','123456','tom@gamil.com')";
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println("向用户表插入" + count + "条数据");
    }

    public static void insertAddressData(Connection connection) throws SQLException {
        String sql = "insert into tbl_address(id,city,country,user_id)" +
                "values(3,'上海','中国',10)";
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println("向地址表插入" + count + "条数据");
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false); //设置禁止自动提交

            insertUserData(connection);
            insertAddressData(connection);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("成功捕获异常================");
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("成功回滚事务================");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
