# geekbang-lessons
极客时间课程工程

## 第4周作业：

### 完善 my dependency-injection 模块

```
1.注释掉web.xml中的ComponentContextInitializerListener配置，将ComponentContext组件移到my-dependency-injection模块下，通过SPI方式配置ServletContainerInitializer实现类ComponentContextInitializer，并在onStartup中将ComponentContextInitializerListener设置给ServletContext
2.存在问题
EntityManager和Validator初始化时报ELManager找不到的问题，导致ComponentContext运行异常，暂时去掉@Postonstruct注解，以保证ComponentContext正常注入组件
3.验证方式
1）编译运行
mvn clean package
java -jar user-web/target/user-web-v1-SNAPSHOT-war-exec.jar
查看如下日志，成功触发两个ServletContainerInitializer的启动
+++++ServletConfigInitializer startup!
+++++ComponentContextInitializer startup!
2）访问http://localhost:8080/hello/world，查看如下日志，ComponentContext组件运行成功，DBConnectionManager中的EntityManager成功注入
三月 24, 2021 12:27:11 上午 org.geektimes.projects.user.sql.DBConnectionManager getEntityManager
信息: 当前 EntityManager 实现类：org.geektimes.projects.user.orm.jpa.DelegatingEntityManager

```

### 完善 my-configuration 模块
```
1.ServletContextConfigInitializer在ServletContextListener的contextInitialized中加载扩展Converter，并将构建Config对象设置到ServletContext的属性中，以便Controller获取
2.验证方式
1）编译运行
mvn clean package
java -jar user-web/target/user-web-v1-SNAPSHOT-war-exec.jar
2）访问http://localhost:8080/hello/world，查看如下日志，通过ServletContext获取Config对象，且获取属性值成功
+++++ app name : "user-web" , app version : 1.1
+++++ awtToolkit : sun.lwawt.macosx.LWCToolkit , javaVersion : 1.8

```



