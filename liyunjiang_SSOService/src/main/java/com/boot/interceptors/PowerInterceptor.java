package com.boot.interceptors;

import com.boot.dto.UserPermissionDTO;
import com.boot.entity.UserEntity;
import com.boot.utils.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PowerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理");
        String requestPath=request.getServletPath();
        System.out.println(requestPath);
        UserEntity currentUser= (UserEntity) request.getSession().getAttribute("currentUser");
        if (currentUser==null){
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/gotoLogin");
            return  false;
        }
        List<UserPermissionDTO> list= (List<UserPermissionDTO>) request.getSession().getAttribute("powerList");
        for (UserPermissionDTO permission:
                list) {
            if (permission.getPerURL().equals(requestPath)){
                return  true;
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(StringUtil.RESPONSE_NOT_FOUND_PERMISSION);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("渲染前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("渲染后");
    }
}
