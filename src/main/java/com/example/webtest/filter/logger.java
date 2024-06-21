package com.example.webtest.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.logging.Logger;

@WebFilter
public class logger implements Filter {

    private static final Logger log = Logger.getLogger(logger.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        log.info("Request: " + method + " " + uri); // Ghi nhật ký thông tin chi tiết
        log.info("Query: " + query);
        filterChain.doFilter(servletRequest, servletResponse);
    }


}
