# [Spring Security] DelegatingFilterProxy, FilterChainProxy

### | Topic : 

<u>[Spring Security] The Big Picture</u> 글에서는Spring Security와 Servlet Filter의 상관 관계에 대해서 설명했고, 해당 글에서 중요한 컴포넌트인 `DelegatingFilterProxy`, `FilterChainProxy` 역할에 대해서 말로만 풀었었다. 이번 글에서는 두 컴포넌트의 관계가 어떻게 정의되는 지 Spring Security 프레임워크 코드 디버깅을 통해서 직접 눈으로 확인하고자 한다. 직접 눈으로 확인할 목록은 아래와 같다. 

- `FilterChainProxy` is a Bean, it is typically wrapped in a [DelegatingFilterProxy](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-delegatingfilterproxy). 

- [`SecurityFilterChain`](https://docs.spring.io/spring-security/site/docs/5.5.1/api/org/springframework/security/web/SecurityFilterChain.html) is used by [FilterChainProxy](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-filterchainproxy) to determine which Spring Security `Filter`s should be invoked for this request.

  

### | How DelegatingFilterChainProxy Wraps FIlterChainProxy ? 



### | How FilterChainProxy manages SecurityFIlterChain from Spring Security ? 



___

### | Reference :

https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-architecture

https://velog.io/@yaho1024/series/spring-security
