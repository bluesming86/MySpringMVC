package com.ming.mapping;

import com.ming.handler.SaveUserHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ming
 * @time 2020/9/7 10:40
 */
public class SimpleUrlHandlerMapping implements HandlerMapping {
    private Map<String, Object> urlHandlers = new HashMap<String, Object>();


    public SimpleUrlHandlerMapping() {
        this.urlHandlers.put("/saveUser", new SaveUserHandler());
    }

    public Object getHandler(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
        return urlHandlers.get(uri);
    }
}
