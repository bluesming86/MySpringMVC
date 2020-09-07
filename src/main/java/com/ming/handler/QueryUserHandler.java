package com.ming.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ming
 * @time 2020/9/7 9:52
 */
public class QueryUserHandler implements HttpRequestHandler {
    public void handlerRequest(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write("ming 的  新世界 ： QueryUserHandler");
    }
}
