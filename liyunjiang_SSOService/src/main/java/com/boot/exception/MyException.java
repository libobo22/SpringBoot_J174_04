package com.boot.exception;

import com.boot.utils.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyException implements HandlerExceptionResolver {

    //全局异常处理
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        HandlerMethod hm= (HandlerMethod) o;
        System.out.println("异常错误为："+e.getMessage());
        System.out.println("出现异常的类是："+hm.getBean()+"/n/方法是："+hm.getMethod());
        e.printStackTrace();
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("errorInfo", StringUtil.SYS_ERROR_INFO);
        return mv;
    }
}
