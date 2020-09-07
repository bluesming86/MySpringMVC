package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ming
 * @time 2020/9/7 9:42
 */
public abstract class AbstractServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispath(req ,resp);

    }

    public abstract void doDispath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
}
