# [Spring Security] Username/Password Authentication (1)

### | Username/Password Authentication 

가장 일반적인 인증 방식이다. 인증 처리를 위해 유저네임과 패스워드를 활용하는 것을 쉽게 추론할 수 있는데, 유저네임과 패스워드 정보는 어디서 가져올까? `Spring Security`는 `HttpServletRequest`에서 유저네임과 패스워드를 활용할 수 있는 내장 메카니즘을 제공한다. 

###### - Form Login 

###### - Basic Authentication 

###### - Digest Authentication (<u>Spring 공식 레퍼런스에서 권장하지 않는 방법</u>)

클라이언트 요청을 통해 유저네임과 패스워드를 받아오면, 이 정보가 유효한 지에 대해서 확인하기 위해서 메모리 또는 데이터베이스 등 서버 측에서 관리하는 유저네임과 패스워드 정보와 대조를 해야 하는데 다음과 같은 방식을 통해서 저장된 유저 정보를 활용할 수 있다.

###### - Simple Storage with In-Memory Authentication

###### - Relational Database with JDBC Authentication ◀︎ **현재 글**

###### - Custom data stores with UserDetailsService ◀︎ **현재 글**

###### - LDAP storage with LDAP Authentication 



### | JDBC Authentication 

Spring Security's `JdbcDaoImpl` implements `UserDetailsService` to provice support for username/password based authentication that is retrived using JDBC. `JdbcUserDetailsManager` extends `JdbcDaoImpl` to provide management of `UserDetails` through the `UserDetailsManager` interface. `UserDetails` based authentication is used by Spring Security when it is configured to accept a username/password for authentication. 

#### - UserDetails 

`UserDetails` is returned by the `UserDetailsService`. The `DaoAuthenticationProvider` vaildates the `UserDetails` and then returns an `Authentication` that has a principal that is the `UserDetails` returned by the configured `UserDetailsService`.

#### - UserDetailsService

`UserDetailsService` is used by `DaoAuthenticationProvider` for retreiving a username, password, and other attributes for authenticating with a username and password. Spring Security provides *in-memory* and *JDBC* implementations of `UserDetailsService`. 

You can define custom authentication by exposing a custom `UserDetailsService` as a bean. For example, the following will customize authentication assuming that `CustomUserDetailsSerivce` implements `UserDetailsService`. 

###### ! This is only used if the AuthenticationManagerBuilder has not been populated and no AuthenticationProviderBean is defined. 

```java
@Bean
CustomUserDetailsService customUserDetailsService() {
    return new CustomUserDetailsService();
}
```

### | DaoAuthenticationProvider 

![image-20210723104929250](/Users/youn/Library/Application Support/typora-user-images/image-20210723104929250.png)

​				 <그림 1> 



### | Reference 

###### https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-unpwd