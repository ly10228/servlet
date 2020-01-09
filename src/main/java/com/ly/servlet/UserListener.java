package com.ly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.stream.StreamSupport;

/**
 * @author luoyong
 * @Description: UserListener 监听项目的启动与停止
 * @create 2020-01-09 23:00
 * @last modify by [LuoYong 2020-01-09 23:00]
 **/
public class UserListener implements ServletContextListener {

    /**
     * @param sce
     * @return void
     * @Description: 监听ServletContext启动初始化
     * @author luoyong
     * @create 23:01 2020/1/9
     * @last modify by [LuoYong 23:01 2020/1/9 ]
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext);
        System.out.println("UserListener...contextInitialized...");
    }

    /**
     * @param sce
     * @return void
     * @Description: 监听ServletContext销毁
     * @author luoyong
     * @create 23:01 2020/1/9
     * @last modify by [LuoYong 23:01 2020/1/9 ]
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("UserListener...contextDestroyed...");
    }
}
