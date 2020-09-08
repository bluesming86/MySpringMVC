package com.ming.servlet;

import com.ming.adapter.HandlerAdapter;
import com.ming.adapter.HttpRequestHandlerAdapter;
import com.ming.adapter.SimpleControllerHandlerAdapter;
import com.ming.mapping.BeanNameUrlHandlerMapping;
import com.ming.mapping.HandlerMapping;
import com.ming.mapping.SimpleUrlHandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 唯一的Servlet
 * @Author ming
 * @time 2020/9/7 9:38
 */
public class DispatcherServlet extends AbstractServlet {

    //适配器的 策略集合
    private List<HandlerAdapter> handlerAdapterList = new ArrayList<HandlerAdapter>();

    //映射关系 的 策略集合
    private List<HandlerMapping> handlerMappingList = new ArrayList<HandlerMapping>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        //在Servlet初始化时， 从配置文件中 获取 适配器，映射关系的 策略集合
        handlerAdapterList.add(new HttpRequestHandlerAdapter());
        handlerAdapterList.add(new SimpleControllerHandlerAdapter());

        handlerMappingList.add(new BeanNameUrlHandlerMapping());
        handlerMappingList.add(new SimpleUrlHandlerMapping());
        super.init(config);
    }

    /**
     *  根据请求查找对应的处理类
     *  调用处理类的处理方法，执行请求结果，并返回结果
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void doDispath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object handler = null;
        try {
            //获取处理器
            handler = getHandler(req);
            if (handler == null){
                return ;
            }
            // 处理器适配器，来找到对应的
            HandlerAdapter adapter = getHandlerAdapter(handler);
            if (adapter == null){
                return;
            }
            //执行 请求
            adapter.handlerRequest(handler, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 根据处理器 获取处理器适配器
     * @param handler 处理器
     * @return
     */
    private HandlerAdapter getHandlerAdapter(Object handler) {
        if (handlerAdapterList != null && handlerAdapterList.size()>0){
            for (HandlerAdapter handlerAdapter : handlerAdapterList) {
                if (handlerAdapter.supports(handler)){
                    return handlerAdapter;
                }
            }
        }
        return null;
    }

    /**
     * 获取请求获取 处理
     * @param req
     * @return
     * @throws Exception
     */
    private Object getHandler(HttpServletRequest req) throws Exception {

        // 遍历 映射关系列表
        if (handlerMappingList != null && handlerMappingList.size() >0){
            Object handler = null;
            for (HandlerMapping handlerMapping : handlerMappingList) {
                handler = handlerMapping.getHandler(req);
                if (handler != null){
                    return handler;
                }
            }
        }
        return null;
    }

}
