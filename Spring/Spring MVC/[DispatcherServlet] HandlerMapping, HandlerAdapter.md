# [DispatcherServlet] HandlerMapping, Adpater and Interceptor 

\# Order 

### | HandlerMapping 

`DispatcherServlet` (The Front Controller Pattern)는 해당 요청 정보를 처리할 수 있는 `Controller`로 요청을 위임시키는 역할을 한다. 영단어 `dispatcher` 에는 열차, 버스, 비행기 등의 운행 관리원, 또는 무엇인가를 보낸다는 의미를 가지고 있다. 클라이언트의 요청을 처리하는 서버 맥락에서는 위에서 설명 했듯이 클라이언트의 요청을 실제 처리할 수 있는 `Controller`에 요청을 배치, 위임하는 것으로 이해할 수 있다. 이러한 역할을 담당하는 핸들러에는 `BeanNameUrlHandlerMapping`, `SimpleUrlHandlerMapping`, `RequestMappingHandlerMapping` 를 예로 들 수 있다. 

먼저, 각각의 `HandlerMapping` 특징을 보기 전에 `HandlerMapping` 의 역할에 대해서 먼저 알아보자. `HandlerMapping` 은 특정`HandlerExecutionChain`를 제시하는데, `HandlerExecutionChain` 에는 클라이언트의 요청을 처리할 수 있는 핸들러와 핸들러 인터셉터 리스트를 갖고 있다. `DispatcherServlet` 은 클라이언트 요청에 대해서 `HandlerMapping`에 클라언트 요청 정보를 전달하고, 적절한 `HandlerExecutionChain` 을 반환하도록 한다. 그리고 `DispatcherServlet` 은 `HandlerExecutionChain` 내부에 있는 핸들러와 인터셉터 들을 실행시킨다. 

#### - BeanNameUrlHandlerMapping 

#### - SimpleUrlHandlerMapping

#### - RequestMappingHandlerMapping

### | Intercepting requests : the handlerinterceptor interface

\# 호출 위치 # 시점 (3)

### | HandlerAdapter



### | Reference 

###### https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch16s04.html

###### http://wonwoo.ml/index.php/post/2308

###### https://joont92.github.io/spring/DispatcherServlet-Flow/

###### https://m.blog.naver.com/nuberus/221485687327

###### https://www.programmersought.com/article/7219622968/



![image-20210722164551262](/Users/youn/Library/Application Support/typora-user-images/image-20210722164551262.png)

![image-20210722164629258](/Users/youn/Library/Application Support/typora-user-images/image-20210722164629258.png)

![image-20210722164758438](/Users/youn/Library/Application Support/typora-user-images/image-20210722164758438.png)
