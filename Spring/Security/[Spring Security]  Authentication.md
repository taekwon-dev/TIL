# [Spring Security]  Authentication (1)

`Spring Security Framework` 이 동작하는 상대적인 위치에 대해서 이해가 됐다면, 이 프레임워크에서 인증을 어떻게 수행하는 지를 알아보자. `Security Filters` 중에서 어떤 필터가 인증을 담당하는 지, 인증을 하는 방식에는 어떤 것들이 있는 지 그리고 인증을 처리하기 위해 필요한 개념(컴포넌트)에는 무엇이 있는 지에 대해서 알아볼 것이다. 

### | Architecture Components (9)

##### - SecurityContextHolder

##### - SecurityContext

##### - Authentication 

##### - GrantedAuthority 

##### - AuthenticationManager 

##### - ProviderManager 

##### - AuthenticationProvider 

##### - Request Credentials with AuthenticationEntryPoint

##### - AbstractAuthenticationProcessingFilter 

---

### | SecurityContextHolder

\# Contains SecurityContext # ThreadLocal 

Spring 공식 레퍼런스에서는 `SecurityContextHolder`를 인증 개념에서 '심장'에 비유한다. 이름에서 쉽게 추론할 수 있듯이 `SecurityContext` 를 감싸고 있다. `SecurityContextHolder` 는 `Spring Security`에서 **누가** 인증됐는 지에 대한 정보를 저장하는 공간으로 이해하면 된다. 아래 <그림 1>을 보면, 지금은 자세히 다루지 않았지만 인증 주체에 대한 정보를 담고 있는 것을 확인할 수 있다. 

![image-20210717131046113](/Users/youn/Library/Application Support/typora-user-images/image-20210717131046113.png)

​													<그림 1>

기본 설정으로 `SecurityContextHolder`는 `TheadLocal`을 사용해서 <그림 1>에서 포함하고 있는 인증한 유저의 정보를 저장한다. 이는 동일한 스레드에서 `SecurityContext` 에 접근할 수 있도록 한다. 

### | SecurityContext 

<그림 1>에서 알 수 있듯이 `SecurityContext`는 `SecurityContextHolder`에서 조회할 수 있으며, `Authentication` 객체를 가지고 있다. 

### | Authentication 







___

### | Reference 

https://catsbi.oopy.io/f9b0d83c-4775-47da-9c81-2261851fe0d0

https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication

https://nathanh.tistory.com/131
