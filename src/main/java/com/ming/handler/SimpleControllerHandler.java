package com.ming.handler;

import com.ming.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *指定处理类规范（可以对返回值进行二次处理）
 */
public interface SimpleControllerHandler {
    ModelAndView handlerRequest(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException ;
}
