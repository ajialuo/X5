package com.highdata.util.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        CustomException customException = null;
        //如果抛出的是系统自定义的异常则直接转换
        if(ex instanceof CustomException) {
            customException = (CustomException) ex;
        } else {
            //根据不同异常选择不同输出内容
            customException = new CustomException("系统未知错误");
        }

        //向前台返回错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", customException.getMessage());
        modelAndView.setViewName("/error");
        return modelAndView;
    }

}
