package com.ming.mapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理映射关系
 */
public interface HandlerMapping {

    /**
     *   获取处理类
     */
    Object getHandler(HttpServletRequest request) throws Exception;
}
