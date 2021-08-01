# [Spring] Life cycle of a Bean, Scope (2)

이 번 글에서는 이전 글에서 다루지 않은 나머지 `Bean Scope`에 대해서 다룬다. 

###### - Singleton Bean Scope (<u>Default</u>) 

###### - Prototype Bean Scope 

###### - Request and Session Bean Scope (Related with Web) ◀︎ **현재 글**

###### - Application Bean Scope ◀︎ **현재 글**

###### - Websocket Bean Scope ◀︎ **현재 글**

___

### | Request and Session Bean Scope 

##### | Background for Request, Session

\# Web Application \# Life cycle of a Session \# How Servlet Container do handle HTTP requests 

`Request`, `Session` Scopes를 이해하기 위해서는 위에 나열한 것들에 대한 선수 지식이 필요하다. 서블릿 컨테이너가 HTTP 요청을 처리하고 응답하는 과정 그리고 세션 생성과 소멸에 대해서 이해가 부족한 분은 해당 주제에 대해서 공부한 뒤 스코프를 공부하는 것이 좋다. (<u>매우 중요</u>)

우선, `Request`, `Session` 서로 다른 두 스코프가 하나의 주제로 엮일 수 있는 것은 세션 생성 방법을 알면 이해할 수 있다. 서블릿 컨테이너는 클라이언트의 요청에 대해서 `HttpServletReuqest`, `HttpServletResponse` 객체를 각각 생성하는데, `HttpServletRequest`에서 아래 메소드를 호출 시점에 `HttpSession` 객체가 생성된다. 그리고 세션 생성 시 설정된 세션 유효 기간이 초과되거나 `HttpSession`에서 `invalidate()` 메소드가 호출되는 경우 `HttpSession` 객체가 소멸된다.

```java
public interface HttpServletRequest extends ServletRequest {
	...
  HttpSession getSession(boolean var1);
	HttpSession getSession();
  ...
}
```

```java
public interface HttpSession { 
	...
  void invalidate();
  ...
}
```

서블릿 컨테이너가 클라이언트의 요청을 처리하고 응답하기 까지 주기를 `Request`로 이해하면 되고, 클라이언트의 요청을 처리하는 과정에서 `HttpSession`가 생성되고 해당 세션이 만료되는 시점까지의 주기를 `Session`으로 이해하면 된다. 

##### | How to use Request, Session Scope in Spring Boot 

\# proxyMode 

실제 사례를 통해서 어떻게 `Request`, `Session` Scope를 사용하는지 알아보자. 먼저 쿠팡과 같이 이커머스 서비스를 생각해보자. 로그인을 통해 인증한 각각의 유저가 자신이 담은 물건을 독립적으로 관리할 수 있도록 해야 한다. 각 유저가 담은 물건을 장바구니에 보관한다고 하면, <u>장바구니 빈은 로그인한 유저 별로 하나씩 생성</u>을 해줘야 한다. 세션 기반으로 인증한다는 맥락에서, 세션이 생성될 때 장바구니 빈을 생성하고 해당 세션이 만료되어 소멸될 때 장바구니 빈을 소멸시키는 것이다. 이렇듯 `Session` Scope는 인증된 유저를 대상으로 무엇인가를 관리하는 맥락과 매우 밀접하다. 

반면, `Request` Scope는 웹 애플리케이션에서 인증 여부와 관계 없이 있을 수 있는 것으로 상대적으로 더 일반적인 상황을 처리할 수 있다. 여기서는 이커머스 서비스에 로그인하는 상황을 가정하여,  `LoginAction`이라는  `Request` Scope로 등록해보자. 반드시 `Request` Scope로 관리해야 하는 것은 아니다. 위에서 예로 든 상황을 아래와 같은 코드로 구현할 수 있다.

```java
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES)
public ShoppingCart shoppingcart() {...}

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.INTERFACES)
public LoginAction loginAction() {...}
```

위와 같이 `@Scope` 어노테이션과 속성 값을 지정함으로써 `Session Scope`로 빈을 관리할  수 있다. `value` 속성은 Scope의 종류를 지정한다. `proxyMode`를 이해하기 위해서는 

### | Application Bean Scope 





### | Websocket Bean Scope 



### | Reference 

###### https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html

###### https://taes-k.github.io/2020/06/14/spring-bean-scope-lifecycle/

###### http://lifeinhurry.com/spring-bean-scope/

###### https://stackoverflow.com/questions/21759684/interfaces-or-target-class-which-proxymode-should-i-choose

###### https://renuevo.github.io/spring/scope/spring-scope/
