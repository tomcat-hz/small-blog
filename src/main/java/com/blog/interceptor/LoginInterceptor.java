package com.blog.interceptor;

import com.blog.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/27 14:25
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            if (user.getUserType() == 0) {
                return true;
            }
        }
        request.setAttribute("msg", "管理员才能访问,谢谢.");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
