package com.ming.adapter;

import com.ming.handler.HttpRequestHandler;
import com.ming.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpRequestHandler 处理器 对应的 适配器
 * @Author ming
 * @time 2020/9/7 10:30
 */
public class HttpRequestHandlerAdapter implements HandlerAdapter{

    public boolean supports(Object handler) {
        return (handler instanceof HttpRequestHandler);
    }

    public ModelAndView handlerRequest(Object handler, HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        ((HttpRequestHandler)handler).handlerRequest(res, resp);
        return null;
    }
}
