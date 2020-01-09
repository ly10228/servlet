package com.ly.servlet;

import com.ly.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author luoyong001
 * @Description: MyServletContainerInitializer
 * 容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
 * 传入感兴趣的类型；
 * Shared libraries（共享库） / runtimes pluggability（运行时插件能力）
 * 1、Servlet容器启动会扫描，当前应用里面每一个jar包的
 * ServletContainerInitializer的实现
 * 2、提供ServletContainerInitializer的实现类；
 * 必须绑定在，META-INF/services/javax.servlet.ServletContainerInitializer
 * 文件的内容就是ServletContainerInitializer实现类的全类名；
 * 总结：容器在启动应用的时候，会扫描当前应用每一个jar包里面
 * META-INF/services/javax.servlet.ServletContainerInitializer
 * 指定的实现类，启动并运行这个实现类的方法；传入感兴趣的类型；
 * ServletContainerInitializer；
 * @HandlesTypes；
 * @create 2020-01-09 0:05
 * @last modify by [dell 2020-01-09 0:05]
 **/
@HandlesTypes({HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * @param c   感兴趣的类型的所有子类型；
     * @param ctx 代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     * @return void
     * @Description: 应用启动的时候，会运行onStartup方法；
     * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     * 必须在项目启动的时候来添加；
     * 1）、ServletContainerInitializer得到的ServletContext；
     * 2）、ServletContextListener得到的ServletContext；
     * @author luoyong
     * @create 0:08 2020/1/9
     * @last modify by [LuoYong 0:08 2020/1/9 ]
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型如下:");
        c.stream().forEach(System.out::println);


        //注册组件
        ServletRegistration.Dynamic userServlet = ctx.addServlet("userServlet", UserServlet.class);
        //配置映射信息
        userServlet.addMapping("/user");

        //注册Listener
        ctx.addListener(UserListener.class);

        //注册Filter
        FilterRegistration.Dynamic userFilter = ctx.addFilter("userFilter", UserFilter.class);
        //配置Filter的映射信息
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
