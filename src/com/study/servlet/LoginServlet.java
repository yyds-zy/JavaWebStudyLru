package com.study.servlet;

import com.study.jdbc.dao.UserDao;
import com.study.jdbc.dao.impl.UserDaoImpl;
import com.study.jdbc.entity.User;
import com.study.jdbc.service.CheckUserService;
import com.study.jdbc.util.ConnectionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    private UserDao userDao = null;
    private Connection conn = null;

    @Override
    public void init() throws ServletException {
        ConnectionFactory factory = ConnectionFactory.getInstance();
        conn = factory.getConnection();
        userDao = new UserDaoImpl();
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        System.out.println("用户名：= " + username);
//        System.out.println("密  码：= " + password);
//
//        try {
//            userDao.save(conn,new User(username,password,username+"@gamil.com"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===========doGet===============");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===========doPost===============");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("用户名：= " + username);
        System.out.println("密  码：= " + password);

        String forward = null;

        if (username.equals("Jack") && password.equals("123456")) {
            forward = "https://www.baidu.com";
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
//            requestDispatcher.forward(req,resp);
            resp.sendRedirect(forward);
        } else {
//            resp.sendRedirect(req.getContextPath() + "/error.jsp");
            forward = "/error.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
            requestDispatcher.forward(req,resp);
        }

//        try {
//            userDao.save(conn,new User(username,password,username+"@gamil.com"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (userDao != null) {
            userDao = null;
        }
    }
}
