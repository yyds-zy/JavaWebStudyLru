package com.study.jdbc.filter;

import javax.servlet.*;
import java.io.IOException;

public class UrlsFilter implements Filter {

    public UrlsFilter() {
        System.out.println("==============UrlsFilter 构造方法==============");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==============UrlsFilter 初始化==============");
        String url = filterConfig.getInitParameter("url");
        System.out.println(url);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("==============UrlsFilter 开始doFilter==============");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("==============UrlsFilter 结束doFilter==============");
    }

    @Override
    public void destroy() {
        System.out.println("==============UrlsFilter destroy==============");
    }
}
