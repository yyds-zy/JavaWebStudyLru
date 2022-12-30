package com.study.jdbc.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String charEncoding = null;

    public EncodingFilter(){}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charEncoding = filterConfig.getInitParameter("encoding");
        if (charEncoding == null) {
            throw new ServletException("EncodingFilter中的编码设置为空！");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!charEncoding.equals(servletRequest.getCharacterEncoding())) {
            servletRequest.setCharacterEncoding(charEncoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
