# Spring Security Architecture



### | Spring Security 주요 개념 

- *Authentication* :  **인증** (Who are you?), 예를 들어 비로그인 상태에서 유저가 로그인을 통해 자신이 __유저임을 증명하는 것을 들 수 있다. 

- *Authorication* : **인가**(What are you allowed to do?), 이는 로그인 상태를 전제로 이 유저가 __권한을 갖고 있는 지를 확인하는 절차이다. 

  - 따라서 아래와 같은 `ROLE` 을 정의하고, 주어진 권한에 따라서 유저에게 제공하는 서비스의 범위를 제한할 수 있다. 

    - ROLE_ADMIN : 관리자 계정 
    - ROLE_MEMBER : 회원 계정

    

### | Spring Security 주요 요소

- AuthenticationManager
- ProviderManager
- AuthenticationManager



### | Web Security : 

Spring Security가 <u>어디서 작동하는 지</u> 알 수 있음. 

클라이언트 요청 -- 필터1 --- 필터2 --- 필터3 --- 서블릿 

Spring security도 결국 필터 (-> 어디서 작동하는 지 확인할 수 있음)









