package com.study.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private Connection conn = null;

    static {
        Properties prop = new Properties();
        try {
            InputStream in = ConnectionFactory.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("配置文件读取异常");
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");

        System.out.println("driver = " + driver);
        System.out.println("dburl = " + dburl);
        System.out.println("user = " + user);
        System.out.println("password = " + password);
    }


    private static ConnectionFactory instance = null;
    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        if (instance == null) {
            synchronized (ConnectionFactory.class) {
                if (instance == null) {
                    instance = new ConnectionFactory();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
