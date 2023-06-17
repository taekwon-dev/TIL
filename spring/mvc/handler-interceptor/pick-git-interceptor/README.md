# JWT 토큰 기반 인증 및 인가 처리 기능

### 관련 PR 링크

https://github.com/taekwon-dev/intly-api/pull/1

---

### 작업하게 된 이유

- 포스트, 댓글 작성 등 일부 기능은 인증한 유저만 허용되도록 하는 제한 조건 필요
- 인증을 요구하는 기능 중, 특정 권한을 가진 유저만 허용하는 기능을 구분하기 위해

  인가 정보를 확인하는 제한 조건 필요


### 작업 과정

- **기획서를 기반으로 API 별 인증 요구 여부 및 권한 레벨 분류**
    - 예) 포스트 작성 API - 로그인 유저만 요청 가능
    - 예) 포스트 상세 조회 API - 게스트, 로그인 유저 모두 요청 가능
    - 예) My-Campus 커뮤니티 관련 API - 로그인 유저 중 대학생 회원만 요청 가능
- **인증, 인가 처리 과정 설계 및 구현**

  ![[ 그림 1 - Spring MVC 클라이언트 요청 처리 과정 도식화 ]](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/db448cca-3304-4759-b527-da7b69fa4069/Untitled.png)

  [ 그림 1 - Spring MVC 클라이언트 요청 처리 과정 도식화 ]

    - 토큰 기반의 인증 방식을 사용하는 상황에서 클라이언트의 매 요청마다 클라이언트가 보낸 토큰의 유효성을 검증하는 구조를 가짐
    - 토큰 유효성 검증을 통한 인증 처리는 `Handler Interceptor` 에서 진행
        - 인증이 요구되는 API 요청 : 토큰 유효성 검증 로직 통과
        - 인증이 필요하지 않은 API 요청
            - 클라이언트에서 토큰 전송하지 않은 경우 : 토큰 유효성 검증 로직 건너뛰고 `Controller` 호출
            - 클라이언트에서 토큰을 전송한 경우 : 유저 식별을 위해 토큰 유효성 검증 로직 통과
                - 유저 식별이 필요한 이유 : 해당 유저와 관련한 상태를 표현해야 하는 경우 (좋아요 표시 등)
    - 인증된 유저를 대상으로 권한 레벨을 나누어 적용해야 하는 경우 토큰 내부의 유저 식별자 정보를 활용해 데이터베이스에서 유저 정보 조회 후, 유저의 권한 정보를 조회하여 처리

### 고민했던 부분

1. **토큰 유효성 검증은 어디서 할까 : 서블릿 필터(Filter) vs 핸들러 인터셉터(Interceptor)**
    - 우선, 토큰의 유효성 검증을 위해서 필요한 것을 모두 충족하는 지 체크
        - 컨트롤러 호출 전에 유효성 검증이 일어나는가?
            - 서블릿 필터 O, 핸들러 인터셉터 O
        - JWT 토큰 유효성 검증 기능을 제공하는 유틸리티 객체(=Bean) 의존성 주입을 받을 수 있는가?
            - 서블릿 필터 O, 핸들러 인터셉터 O
        - 스프링의 예외 처리 지원을 받을 수 있는가?
            - 서블릿 필터 X, 핸들러 인터셉터 O
    - 인증, 인가 처리 외 API 구현 시 예외 상황을 처리할 때 예외 코드를 정의하고,  `@RestControllerAdvice`, `@ExceptionHandler` 를 활용해 일관적인 방식으로 예외 응답 처리를 고려하고 있던 상황에서 스프링 예외 처리 지원을 받을 수 있는지 여부는 매우 중요했다.
    - 서블릿 필터의 경우 [[ 그림 1 ]](https://www.notion.so/JWT-d72e4c5d4f7348c29806dc8e99ffd67a?pvs=21) 에서 알 수 있듯이 스프링 컨테이너 외부에 위치하고 있어 스프링이 지원하는 예외 전략이 적용되지 않는 범주에 해당한다. (=일관된 예외 처리 적용 불가)
    - 위와 같은 배경에서 토큰의 유효성 검증 로직을 핸들러 인터셉터에서 처리하는 것으로 결정했다.

---

---

1. **RESTful API 아키텍처가 낳은 고민 : `GET /api/posts/1` vs `DELETE /api/posts/1`**
    - 문제 배경 및 문제 상황 정의

      ![ [ 그림 2 - **API는 같지만 HTTP 메서드가 다른 API**가 각각 다른 핸들러 인터셉터를 통과해야 하는 상황 ] ](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/44945552-a772-4d36-9ab8-6eeef4ea24fc/Untitled.png)

      [ 그림 2 - **API는 같지만 HTTP 메서드가 다른 API**가 각각 다른 핸들러 인터셉터를 통과해야 하는 상황 ]

      Spring MVC는 핸들러 인터셉터를 통과할 API를 지정할 때 HTTP 메서드 정보를 활용할 수 없다. (오직 URL 패턴을 문자열 형식으로만 지정 가능)

      ![ [ 그림 3 - 두 개 이상의 핸들러 인터셉터가 등록되어 있는 상황 도식화 ]](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f59e30a6-fabf-42ab-aeea-b513d7cb0d02/Untitled.png)

      [ 그림 3 - 두 개 이상의 핸들러 인터셉터가 등록되어 있는 상황 도식화 ]

      핸들러 인터셉터는 핸들러 매핑 전략을 기준으로 [[ 그림 3 ]](https://www.notion.so/JWT-d72e4c5d4f7348c29806dc8e99ffd67a?pvs=21) 와 같이 선형적으로 구조화 된다. 두 핸들러 인터셉터 모두에 `/api/posts/{postId}` 패턴이 포함된 요청이 통과하도록 지정 했다고 가정해보자. 그리고 이 상태에서 `/api/posts/{postId}` 패턴이 포함된 클라이언트 요청이 오면 하나의 클라이언트 요청 주기 속에서 두 개의 핸들러 인터셉터의 서비스 로직이 등록된 순서대로 호출되는 구조를 가진다.

      ![[ 그림 4 - 핸들러 인터셉터 preHandle() 메서드 활용 예시 ]](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b622b1ad-645a-43f3-b0ea-d87e0140b005/Untitled.png)

      [ 그림 4 - 핸들러 인터셉터 preHandle() 메서드 활용 예시 ]

      이 때 API URL은 같지만 HTTP 메서드만 차이가 있는 경우, [[ 그림 4 ]](https://www.notion.so/JWT-d72e4c5d4f7348c29806dc8e99ffd67a?pvs=21) 와 같이 각 핸들러 인터셉터 별로 처리 대상을 필터링하기 위해 HTTP 메서드를 기준으로 해당 인터셉터의 서비스 로직을 적용할지 여부를 결정해야 한다.

      **Q. 위 방식을 문제 상황으로 정의한 이유가 뭘까?**

      각 API 마다 HTTP 메서드에 따라 통과할 인터셉터를 결정하는 패턴이 상이할 수 있고, 이로 인해 일관된 처리가 사실상 불가능한 측면이 있다는 점에서 문제 상황으로 정의했다. 또한 API 개발 과정에서 새로운 기능이 추가되거나 제외되는 과정에서 핸들러 인터셉터까지 영향을 받는 구조라는 점에서 유지﹒보수 측면에서 불리하다고 판단했다.

    - 문제 해결 아이디어

      문제 해결 과정을 요약하면 아래와 같고, 자세한 내용은 관련 포스팅을 통해 확인할 수 있다.

        - 문제 해결 과정 (3 단계)

            1) Java Annotation을 활용해 각 API 별로 통과할 핸들러 인터셉터 정보 남기기

          ![[ 그림 5 - IgnoreAuthentication Interceptor 대상 API ] ](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cf4790a4-8b32-4a1c-860f-ef39a2d78f08/Untitled.png)

          [ 그림 5 - IgnoreAuthentication Interceptor 대상 API ]

          ![[ 그림 6 - Authentication Interceptor 대상 API ]](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ebd01980-b257-4d53-ab97-c6f43fbca1a4/Untitled.png)

          [ 그림 6 - Authentication Interceptor 대상 API ]

            2) Java Reflection을 통해 컨트롤러 클래스 내 메서드 별로 선언된 Annotation에 접근해서 런타임 시점에 각 API 별로 어떤 핸들러 인터셉터를 통과해야 하는지 Map 타입의 자료구조를 활용해 <K, V> = <URL, HTTP METHOD> 형식으로 데이터 구축

            3) 인터페이스 기반의 프록시 내에서 위에서 구축된 데이터를 활용해 해당 인터셉터를 통과할지 여부를 제어 (프록시 패턴 적용)

          ![ [ 그림 7 - 프록시 내부에 Map 형식의 자료 구조를 활용해 타겟의 로직을 호출할지 판단 ]](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/15396d5f-af0a-4409-b10c-82e5c1d614e7/Untitled.png)

          [ 그림 7 - 프록시 내부에 Map 형식의 자료 구조를 활용해 타겟의 로직을 호출할지 판단 ]

    - 관련 포스팅
        - [https://github.com/taekwon-dev/pick-git-interceptor](https://github.com/taekwon-dev/TIL/tree/main/spring/mvc/handler-interceptor/pick-git-interceptor)
        - [핸들러 인터셉터 & 프록시 패턴 [1] - GET api/posts/{postId} vs POST api/posts/{postId}](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EB%B0%8F-%EA%B6%8C%ED%95%9C-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-1-2e736844d46b)
        - [핸들러 인터셉터 & 프록시 패턴 [2] - 핵심 아이디어 소개(Java Annotation, Reflection, Proxy Pattern)](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-2-pick-git-%ED%8C%80-%ED%95%B4%EA%B2%B0-%EC%95%84%EC%9D%B4%EB%94%94%EC%96%B4-%EC%86%8C%EA%B0%9C-java-annotation-reflection-85d02cc20b32)
        - [핸들러 인터셉터 & 프록시 패턴 [3] - pick-git팀 소스코드 분석](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-3-pick-git-%ED%8C%80-%EC%86%8C%EC%8A%A4-%EC%BD%94%EB%93%9C-%EB%B6%84%EC%84%9D%ED%95%98%EA%B8%B0-7aad4ffc8297)