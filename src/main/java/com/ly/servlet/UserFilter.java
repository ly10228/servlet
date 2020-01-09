package com.ly.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author luoyong
 * @Description: UserFilter
 * @create 2020-01-09 22:57
 * @last modify by [LuoYong 2020-01-09 22:57]
 **/
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 过滤请求
        System.out.println("UserFilter...doFilter...");
        //放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
