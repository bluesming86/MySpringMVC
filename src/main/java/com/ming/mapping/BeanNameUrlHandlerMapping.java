package com.ming.mapping;

import com.ming.handler.QueryUserHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ming
 * @time 2020/9/7 10:36
 */
public class BeanNameUrlHandlerMapping implements HandlerMapping {

    private Map<String, Object> urlHandlers = new HashMap<String, Object>();


    public BeanNameUrlHandlerMapping() {
        this.urlHandlers.put("/queryUser", new QueryUserHandler());
    }

    public Object getHandler(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();
        return urlHandlers.get(uri);
    }
}
