# Spring Exception Handling

https://www.baeldung.com/exception-handling-for-rest-with-spring



## 1: the Controller-Level @ExceptionHandler

The @ExceptionHandler annotated method is only active for that particular Controller, not globally for the. entire application. 

특정 @Controller에 제한된 예외처리이고, 컨트롤러 클래스 구조 (예를 들어 상속 관계)를 고려하는 맥락을 강조. 

## 2: the HandlerExceptionResolver

This will resolve any exception thrown by the application. It will also allow us to implement **a uniform exception handling mechanism in our REST API**. 

- ### ExceptionHandlerExceptionResolver

- ### DefaultHandlerExceptionResolver

  Spring 3.0 and it's enabled by default in the DispatcherServlet. It's used to resolve standard Spring exceptions to their corresponding HTTP Status Codes. 

  While it does set the Status Code of the Response properly, one **limitation is that it doesn't set anything to the body of the Response.** And for a REST API — the Status Code is really not enough information to present to the Client — the response has to have a body as well, to allow the application to give additional information about the failure.

  This can be solved by configuring view resolution and rendering error content through *ModelAndView*, but the solution is clearly not optimal. That's why Spring 3.2 introduced a better option that we'll discuss in a later section

  ![The Full list of Spring Exceptions](/Users/youn/Library/Application Support/typora-user-images/image-20210329111210172.png)

  https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html#mvc-ann-rest-spring-mvc-exceptions

  

- ### ResponseStatusExceptionResolver

- ### SimpleMappingExceptionResolver / AnnotationMethodHandlerExceptionResolver

- ### Custom HandlerExceptionResolver

  The combination of ***DefaultHandlerExceptionResolver*** and ***ResponseStatusExceptionResolver***

  

  One detail to notice here is that we have access to the *request* itself, so we can consider the value of the *Accept* header sent by the client.

  For example, if the client asks for *application/json*, then, in the case of an error condition, we'd want to make sure we return a response body encoded with *application/json*.

  The other important implementation detail is that **we return a \*ModelAndView\* — this is the body of the response**, and it will allow us to set whatever is necessary on it.

  This approach is a consistent and easily configurable mechanism for the error handling of a Spring REST Service.

  [아쉬운 점 또는 개선할 점]

  It does, however, have limitations: It's interacting with the **low-level *HtttpServletResponse*** and fits into the old MVC model that uses *ModelAndView*, so there's still room for improvement.

  ​	

  https://kadensungbincho.tistory.com/m/58 : 

  "서블릿은 자바 웹 어플리케이션의 핵심 컴포넌트로, <u>low-level</u> 이며 Spring MVC와 같은 특정 프로그래밍 패턴에 제약을 가하지 않습니다. 

## 3: @ControllerAdvice