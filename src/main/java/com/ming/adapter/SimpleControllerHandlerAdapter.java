package com.ming.adapter;

import com.ming.handler.SimpleControllerHandler;
import com.ming.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ming
 * @time 2020/9/7 10:34
 */
public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    public boolean supports(Object handler) {
        return (handler instanceof SimpleControllerHandler);
    }

    public ModelAndView handlerRequest(Object handler, HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        return ((SimpleControllerHandler)handler).handlerRequest(res, resp);
    }
}
