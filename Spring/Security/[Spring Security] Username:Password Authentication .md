# [Spring Security] Username/Password Authentication 

### | Username/Password Authentication 

가장 일반적인 인증 방식이다. 인증 처리를 위해 유저네임과 패스워드를 활용하는 것을 쉽게 추론할 수 있는데, 유저네임과 패스워드 정보는 어디서 가져올까? `Spring Security`는 `HttpServletRequest`에서 유저네임과 패스워드를 활용할 수 있는 내장 메카니즘을 제공한다. 

###### - Form Login ◀︎ **현재 글**

###### - Basic Authentication ◀︎ **현재 글**

###### - Digest Authentication (<u>Spring 공식 레퍼런스에서 권장하지 않는 방법</u>)

클라이언트 요청을 통해 유저네임과 패스워드를 받아오면, 이 정보가 유효한 지에 대해서 확인하기 위해서 메모리 또는 데이터베이스 등 서버 측에서 관리하는 유저네임과 패스워드 정보와 대조를 해야 하는데 다음과 같은 방식을 통해서 저장된 유저 정보를 활용할 수 있다.

###### - Simple Storage with In-Memory Authentication

###### - Relational Database with JDBC Authentication ◀︎ **현재 글**

###### - Custom data stores with UserDetailsService ◀︎ **현재 글**

###### - LDAP storage with LDAP Authentication 

### 

### | Form Login

비인증 유저가 인증이 요구되는 요청을 보내는 경우 지정한 로그인 URL로 리다이렉트 처리를하고, 로그인 페이지에서 유저가 입력한 유저네임, 패스워드 정보를 기반으로 인증을 처리하는 방식이다. 

![image-20210722101853629](/Users/youn/Library/Application Support/typora-user-images/image-20210722101853629.png)

​				<그림 1> 

###### 2) `FilterSecurityInterceptor`는 비인증 유저의 요청을 가로채서 `AccessDeniedException` 을 발생시킨다. 

###### 3) `ExceptionTranslationFilter`는 `AuthenticationEntryPoint` 에 설정된 로그인 URL로 리다이렉트 처리를 한다. 

###### 5)  유저네임, 패스워드 정보가 전송되면, `UsernamePasswordAuthenticationFilter` 가 해당 정보를 가지고 인증 처리를 한다.  

![image-20210722102632252](/Users/youn/Library/Application Support/typora-user-images/image-20210722102632252.png)

​				  <그림 2>

### | Basic Authentication 

\# WWW-Authenticate 

![image-20210722111956459](/Users/youn/Library/Application Support/typora-user-images/image-20210722111956459.png)

​				 <그림 3>

###### 2) `FilterSecurityInterceptor`는 비인증 유저의 요청을 가로채서 `AccessDeniedException` 을 발생시킨다. 

###### 3)  `ExceptionTranslationFilter` 를 통해서 인증 여부를 검사하게 되고, `BasicAuthenticationEntryPoint` 는 비인증 클라이언트에 `WWW-Authenticate` 헤더를 전송한다. 클라이언트는 해당 헤더 값을 받으면, 유저네임과 패스워드 정보를 재전송해야 함을 알게 된다. 

![image-20210722112337282](/Users/youn/Library/Application Support/typora-user-images/image-20210722112337282.png)

​				  <그림 4>

### | 

### | Reference 

###### https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-unpwd