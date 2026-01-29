package com.xjh.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Ballauma
 */
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class DemoFilter implements Filter {
    /**
     * 初始化方法
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("DemoFilter init...");
        Filter.super.init(filterConfig);
    }
    /**
     * 过滤方法
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("DemoFilter doFilter...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        log.info("DemoFilter destroy...");
        Filter.super.destroy();
    }
}
