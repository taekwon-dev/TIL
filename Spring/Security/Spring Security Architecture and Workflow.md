# Spring Security 개념과 주요 요소

### | Spring Security 주요 개념 

- *Authentication* :  **인증** (Who are you?), 예를 들어 비로그인 상태에서 유저가 로그인을 통해 자신이 __유저임을 증명하는 것을 들 수 있다. 

- *Authorication* : **인가**(What are you allowed to do?), 이는 로그인 상태를 전제로 이 유저가 __권한을 갖고 있는 지를 확인하는 절차이다. 

  - 따라서 아래와 같은 `ROLE` 을 정의하고, 주어진 권한에 따라서 유저에게 제공하는 서비스의 범위를 제한할 수 있다. 

    - ROLE_ADMIN : 관리자 계정 
    - ROLE_MEMBER : 회원 계정


### | Spring Security 주요 요소

- AuthenticationManager
- ProviderManager
- AuthenticationProvider
- UserDetailsService
- UserDetails 





In a Spring MVC application the `Servlet` is an instance of [`DispatcherServlet`](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-servlet).

[`DelegatingFilterProxy`](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/web/filter/DelegatingFilterProxy.html/) that allows bridging between the Servlet container’s lifecycle and Spring’s `ApplicationContext`.

`DelegatingFilterProxy` looks up *Bean Filter0* from the `ApplicationContext` and then invokes *Bean Filter0*. The pseudo code of `DelegatingFilterProxy` can be seen below

Another benefit of `DelegatingFilterProxy` is that it allows delaying looking `Filter` bean instances. This is important because the container needs to register the `Filter` instances before the container can startup. However, Spring typically uses a `ContextLoaderListener` to load the Spring Beans which will not be done until after the `Filter` instances need to be registered.

https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-architecture



