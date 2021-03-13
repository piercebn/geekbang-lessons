# geekbang-lessons
极客时间课程工程

work03

1. UserManager改成MXBean，以支持自定义类型的展示
2. 增加Jolokia支持http访问JMX UserManager MXBean，测试方式
```
//1.启动应用
mvn tomcat7:run
//2.验证http方式获取UserManager MXBean信息
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8080/user-web/jolokia/read/org.geektimes.projects.user.management:type=User’
```
