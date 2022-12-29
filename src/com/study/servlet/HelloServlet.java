package com.study.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    //TODO 请求处理流程  client -> Tomcat -> webService  ->  servlet容器  -> HttpServletRequest -> load Servlet -> 处理 -> HttpServletResponse
    //TODO 执行流程  init -> servicing -> service多次 请求次数有关 -> destroy
    @Override
    public void init() throws ServletException {
        System.out.println("=========  init without parameters  ============");
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("=========  init with parameters  ============");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========  service  ============");
        // PrintWriter输出流
        PrintWriter pw = resp.getWriter();
        pw.println("Hello World");
        pw.close();
    }

    @Override
    public void destroy() {
        System.out.println("=========  destroy  ============");
        super.destroy();
    }
}
