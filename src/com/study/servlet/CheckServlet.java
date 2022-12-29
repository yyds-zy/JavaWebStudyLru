package com.study.servlet;

import com.study.jdbc.entity.User;
import com.study.jdbc.service.CheckUserService;
import com.study.jdbc.util.TextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet {

    private CheckUserService checkUserService = new CheckUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        RequestDispatcher rd = null;
        String forward = null;

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            forward = "/error.jsp";
            rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);
        } else {
            User user = new User(username,password);
            boolean bool = checkUserService.check(user);
            if (bool) {
                forward = "/success.jsp";
            } else {
                forward = "/error.jsp";
            }
            rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);
        }
    }
}
