# [JAVA] Servlet Container, Servlet 

### | Servlet ?

A Servlet is a class that handles requests, processes them and reply back with a response. 

**서블릿**은 하나의 클래스로 클라이언트의 요청을 처리하고, 응답하는 과정을 담당한다. 예를 들어, HTML 폼으로 유저로 부터 받은 요청을 처리하거나 데이터베이스에 쿼리를 통해 동적인 웹 페이지를 생성하는데 활용된다. 서블릿은 **서블릿 컨테이너**와 상호작용을 하는데, **웹 서버** 내에서 구동되고 있는 웹 애플리케이션에 요청이 들어오면, 웹 서버는 해당 요청을 서블릿 컨테이너에 전달하고, 서블릿 컨테이너가 해당 요청을 처리할 수 있는 타겟 서블릿에 해당 요청을 다시 전달하는 역할을 한다. 

```java
package javax.servlet;

import java.io.IOException;

public interface Servlet {
    void init(ServletConfig var1) throws ServletException;

    ServletConfig getServletConfig();

    void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

    String getServletInfo();

    void destroy();
}
```



### | Servlet Lifecycle :

#### init()

The *init()* method is designed to be called only once. If an instance of the servlets does not exist, the web container(servlet container) :

- Loads the servlet class
- Creates an instance of the servlet class
- Initailizes it by calling the *init* method

The *init* method must complete successfully <u>before the servlet can receive any requests</u>. The server container cannot place the servlet into service if the *init* method either throws a ServletException or does not return within a time period defined by the Web server. 

서블릿 컨테이너에서 서블릿 인스턴스를 관리할 때 중요한 전제는 클라이언트의 요청을 받기 전에 초기화가 되어야 한다는 것이다. 

#### service()

This method is only called <u>after the servlet's *init()* method has completed successfully.</u> The Container calls the service() method <u>to handle requests coming from the client, intercepts the HTTP request type(GET, POST, PUT, DELETE, etc.) and calls *doGet*, *doPost*, *doPut*, *doDelete*</u>, etc. methods as appropriate.

*init()*가 정상적으로 처리됐을 때를 전제로 호출할 수 있고, 이 메소드는 클라이언트로부터 받은 HTTP 요청을 처리하는 역할을 맡는다.

#### destroy()

Called by the Servlet Container to take the Servlet out of service. This method is only called once all threads within the servlet's service method have exited or after a timeout period has passed. After the container calls this method, it will not call the service method again on the Servlet. 

___

### | Servlet Container & Servlet (* 중요)

위에서 정리한 서블릿 역할과 생명주기 흐름을 기반으로 클라이언트의 요청을 처리하는 상황에서 서블릿 컨테이너와의 연관관계를 정리해보자. 다시 한 번 **서블릿**의 역할을 정리하면, **클라이언트의 요청에 대한 처리와 응답이다.** 서블릿이 활용되기 위해서는 이를 관리하는 서블릿 컨테이너에 먼저 등록된 상태로 있어야 한다. 서블릿 생명주기 중, *init()* 메소드를 통해서 서블릿이 서블릿 컨테이너에 등록된다. 이러한 등록 절차가 정상적으로 완료됐을 때에만 클라이언트의 요청을 처리할 준비가 된 것이다. 참고로, *Apache Tomcat*과 같은 웹 애플리케이션 서버(WAS)가 처음 구동될 때 서블릿을 모두 초기화할 수 있는 옵션도 있고, 최초 클라이언트의 요청이 왔을 때 서블릿을 서블릿 컨테이너에 등록하는 방식이 있다. 

서블릿 컨테이너에 서블릿이 등록된 후, 클라이언트의 요청이 오면, 서블릿 컨테이너는 특정 서블릿의 *service()*를 호출하고, doGet() 또는 doPost()와 같은 특정 요청에 맞는 메소드로 해당 요청을 위임하여 요청을 처리하게 된다. 

### | Request, Response, and Session 

\# HttpServletRequest, HttpServletResponse

(1) Sends in a request

(2) The container creates a new *HttpServletReqeust*, *HttpServletResponse* object.

(3) It then passes on these new objects to the *servlet's service()* method. 

(4) Based on the *HttpServletRequest's method attribute*, this method determines which of the doXXX methods should be called.

- the request object also carries other informtaion such as headers, params, and body. 
- the *HttpServletResponse* object also carries headers, params, and body. 
- <u>we can set them up in our servlet's doXXX method.</u>

**This objects are short-lived.** When the client gets the response back, the server marks the request and response objects for garbage collection. 

How would we then maintain **a state** between subsequent client requests or connections? *HttpSession* is the answer to thid riddle. 

This basically binds objects to a user session, so that information pertaining to a particualr user can be persisted across multiple requests. This is generally achieved using the concept of cookies, using JSESSIONID as a unique identifier for a given session. We can specify the timeout for the session in web.xml.

```xml
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
```

 This means if our session has been idle for 10 minutes, the server will discard it. Any subsequent request would create a new session. 

### | How Do Servlets Share Data (scope) :

There're various ways in which servlets can share data, based on the required <u>**scope**</u>.

As we saw in the earlier sections, different objects have different lifetimes. *HttpServletRequest* and *HttpServletResponse* objects only live between one servlet call. *HttpSession* lives as long as it's active and hasn't timed out.

**ServletContext‘s lifespan is the longest.** It's born with the web application and gets destroyed only when the application itself shuts down. Since servlet, filter, and listener instances are tied to the context, they also live as long as the web application is up and running.

Consequently, if our requirement is to share data between all servlets, let's say if we want to count the number of visitors to our site, then we should put the variable in the *ServletContext*. If we need to share data within a session, then we'd save it in the session scope. A user's name would be an example in this case.

Lastly, there's the request scope pertaining to data for a single request, such as the request payload.

### | Handling Multithreading : 

Multiple *HttpServletRequest* objects share servlets among each other such that each request operates with its own thread of the servlet instance. What that effectively means **in terms of thread-safety is that we should not assign a request or session scoped data as an instance variable of the servlet.**

```java
public class ExampleThree extends HttpServlet {
    
    // Heap 메모리 영역 (-> 모든 스레드에서 공유)
    private String instanceMessage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        // JVM Stack 메모리 영역 (-> 각 스레드 별로 독립적으로 관리)
        String message = request.getParameter("message");
        instanceMessage = request.getParameter("message");
        request.setAttribute("text", message);
        request.setAttribute("unsafeText", instanceMessage);
        request.getRequestDispatcher("/jsp/ExampleThree.jsp").forward(request, response);
    }
}
```

In this case, all requests <u>in the session</u> share *instanceMessage*, whereas *message* is unique to a given request object. Consequently, in the case of concurrent requests, the data in *instanceMessage* could be <u>inconsistent</u>. 

### | Reference 

https://www.baeldung.com/intro-to-servlets

https://www.baeldung.com/java-servlets-containers-intro







