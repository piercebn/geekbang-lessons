# geekbang-lessons
极客时间课程工程

## work05

### 修复本程序 org.geektimes.reactive.streams 包下

```
问题：
调整收到数据位置，先输出收到数据，在处理cancel逻辑

验证：
运行org.geektimes.reactive.streams.DefaultPublisher#main，日志输出
收到数据：0
收到数据：1
收到数据：2
本次数据发布已忽略，数据为：3
本次数据发布已忽略，数据为：4

```

### 继续完善 my-rest-client POST 方法

```
实现：
实现org.geektimes.rest.client.HttpPostInvocation处理post请求，通过connection的outputStream传递Entity内容

验证：
在org.geektimes.rest.demo.RestClientDemo增加post请求，通过Entity传递plain text类型文本
请求地址：http://127.0.0.1:8080/hello
post body：Entity.text("Bao Nan")
返回：hello Entity文本！
代码：
        Entity<String> stringEntity = Entity.text("Bao Nan");
        Response responsePost = client
                .target("http://127.0.0.1:8080/hello")      // WebTarget
                .request()                                  // Invocation.Builder
                .header("Content-Type", "text/plain")       // Invocation.Builder
                .post(stringEntity);                        //  Response
        String contentPost = responsePost.readEntity(String.class);
        System.out.println("Content Post : " + contentPost);

环境：
搭建springboot应用，实现如下Get和Post请求
@RestController
public class HelloWorldController {

    @GetMapping("/hello/world")
    public String helloWorld() {

        return "Hello World";
    }

    @PostMapping("/hello")
    public String hello(@RequestBody String name) {
        return "Hello " + name + "!";
    }

}

结果：
日志输出
Content Get : Hello World
Content Post : Hello Bao Nan!

```


