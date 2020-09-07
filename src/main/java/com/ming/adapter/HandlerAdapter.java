package com.ming.adapter;

import com.ming.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理器 适配器
 *    HandlerAdapter 跟 Handler  是一一对应的。
 * @Author ming
 * @time 2020/9/7 10:09
 */
public interface HandlerAdapter {

    /**
     * 判断 适配器 跟 处理是否 匹配
     * @param handler
     * @return
     */
    boolean supports(Object handler);


    /**
     *  调用不同的处理器完成请求处理
     * @param handler
     * @param res
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    ModelAndView handlerRequest(Object handler, HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException;
}
