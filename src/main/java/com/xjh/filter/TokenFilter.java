package com.xjh.filter;

import com.xjh.utils.CurrentHolder;
import com.xjh.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ballauma
 */
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            // 登录请求 直接放行
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            // 没有token 拒绝访问
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("token is empty");
            return;
        }
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer empId = Integer.valueOf(claims.getId());
            CurrentHolder.setCurrentId(empId);

        } catch (Exception e) {
            // token 解析失败 拒绝访问
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("token is invalid");
            return;
        }
        // 放行
        filterChain.doFilter(request, response);

        CurrentHolder.remove();
    }
}
