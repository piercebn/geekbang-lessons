package org.geektimes.projects.user.web.controller;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.geektimes.di.context.ComponentContext;
import org.geektimes.projects.user.sql.DBConnectionManager;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        //1。验证DBConnectionManager中的是否正常注入
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getEntityManager();

        //2。验证通过ServletContext获取Config对象，并读取配置值
        Config config = (Config) request.getServletContext().getAttribute(Config.class.getName());
//        ConfigProviderResolver configProviderResolver = ConfigProviderResolver.instance();
//        Config config = configProviderResolver.getConfig(Thread.currentThread().getContextClassLoader());
        //get config from DefaultResourceConfigSource
        String appName = config.getValue("app.name", String.class);
        Float appVersion = config.getValue("app.version", Float.class);
        System.out.println("+++++ app name : " + appName + " , app version : " + appVersion);
        //get config from JavaSystemProperitiesConfigSource
        String awtToolkit = config.getValue("awt.toolkit", String.class);
        Float javaVersion = config.getValue("java.specification.version", Float.class);
        System.out.println("+++++ awtToolkit : " + awtToolkit + " , javaVersion : " + javaVersion);
        return "index.jsp";
    }
}
