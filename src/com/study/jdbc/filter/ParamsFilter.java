package com.study.jdbc.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 参数过滤器   多个过滤器可以组成过滤器链
 */
public class ParamsFilter implements Filter {

    public ParamsFilter() {
        System.out.println("===========ParamsFilter 构造函数===========");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("===========ParamsFilter 初始化===========");
        String param = filterConfig.getInitParameter("param");
        System.out.println(param);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("===========ParamsFilter 开始执行doFilter===========");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("===========ParamsFilter 结束执行doFilter===========");
    }

    @Override
    public void destroy() {
        System.out.println("===========ParamsFilter destroy===========");
    }
}
