package com.ming.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 指定处理类规范
 * @Author ming
 * @time 2020/9/7 9:48
 */
public interface HttpRequestHandler {

    void handlerRequest(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException ;


}
