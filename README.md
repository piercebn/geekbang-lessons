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
3. 通过SPI方式实现ConfigSource的OS环境变量实现和本地配置文件实现
```
//1.环境变量配置，ConfigDemo运行时配置
application.name=user-web-env;config_ordinal=102
//2.本地配置文件config.properties配置
config_ordinal=101
application.name=user-web-local
application.version.major=1
application.version.minor=2
application.version=1.2

环境变量中的application.name会被获取配置
```
4. 通过SPI方式实现Converter的三种简单类型转换：String，Integer，Float
通过ConfigDemo运行测试
