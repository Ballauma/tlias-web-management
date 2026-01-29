package com.xjh.interceptor;

import com.xjh.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Ballauma
 */
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            // 登录请求 直接放行
            return true;
        }

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            // 没有token 拒绝访问
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("token is empty");
            return false;
        }
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            // token 解析失败 拒绝访问
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("token is invalid");
            return false;
        }
        // 放行
        return true;
    }
}
