# [Spring Security] Demo Project for Spring Security (2)

이번 글에서는 Spring Security를 통한 인증 과정을 다룬다. 여러 인증 방식 중에서 Username/Password 인증 방식을 활용하고 로그인 상태를 유지하는 수단으로 Session/Cookie를 활용한다. 또한 인증 성공과 실패 경우에 대한 예외처리 부분을 다루는데, 이 번 글에서는 간단히 예외처리 포인트에 대해서 짚고 Spring Security 예외처리 관련 글에서 자세히 다룰 예정이다.

###### **Github** :  https://github.com/taekwon-dev/spring-demo/tree/main/spring-security 

###  | 목록

- **프로젝트 생성, DB 연동 (환경 설정)** 
- 인증 
  - 인증 방식 선택 ◀︎ **현재 글**
  - 인증 성공 처리 ◀︎ **현재 글**
  - 인증 실패 처리 ◀︎ **현재 글**
- 세션 관리 ◀︎ **현재 글**
- 인가  
- 예외 처리 

### | Work-flow 



### | Authentication via Username/Password 

\# JDBC Authentication # PasswordEncoder(Bcrypt) # UserDetailsService # UserDetails # HttpSession

우선 이번 데모 프로젝트에서는 유저로부터 입력 받은 유저네임과 패스워드를 통해 인증을 처리하는 방식을 다룬다. 실제 인증 처리를 위임 받은 `AuthenticationProvider` 중 `DaoAuthenticationProvider`과 직접 구현한 `CustomAuthenticationProvider` 를 통해서 인증 처리를 할 예정이다. 또한 `HttpSession`을 통한 인증된 유저의 세션 관리 방식에 대해서 다룬다.





### | 인증 성공 처리 



### | 인증 실패 처리 



### | 세션 관리

____

### | Reference

###### https://brunch.co.kr/@sbcoba/11

