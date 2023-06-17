# RESTful API 아키텍처가 낳은 고민 : `GET /api/posts/1` vs `DELETE /api/posts/1`

### 문제 배경 및 문제 상황 정의
![ [ 그림 1 - API는 같지만 HTTP 메서드가 다른 API가 각각 다른 핸들러 인터셉터를 통과해야 하는 상황 ] ](https://user-images.githubusercontent.com/70354365/246624278-e817dfe3-b124-47d6-84ef-21e6dd0e7a1e.png) </br>
[ 그림 1 - URL은 같지만 HTTP 메서드가 다른 API가 각각 다른 핸들러 인터셉터를 통과해야 하는 상황 ]

Spring MVC는 핸들러 인터셉터를 통과할 API를 지정할 때 HTTP 메서드 정보를 활용할 수 없다. (오직 URL 패턴을 문자열 형식으로만 지정 가능)

![ [ 그림 2 - 두 개 이상의 핸들러 인터셉터가 등록되어 있는 상황 도식화 ]](https://user-images.githubusercontent.com/70354365/246624283-c98cb5ee-1b1b-4d9b-bde3-c6c0cfbddb66.png) </br>
[ 그림 2 - 두 개 이상의 핸들러 인터셉터가 등록되어 있는 상황 도식화 ]

핸들러 인터셉터는 핸들러 매핑 전략을 기준으로 [ 그림 2 ] 와 같이 선형적으로 구조화 된다. 두 핸들러 인터셉터 모두에 `/api/posts/{postId}` 패턴이 포함된 요청이 통과하도록 지정 했다고 가정해보자. 그리고 이 상태에서 `/api/posts/{postId}` 패턴이 포함된 클라이언트 요청이 오면 하나의 클라이언트 요청 주기 속에서 두 개의 핸들러 인터셉터의 서비스 로직이 등록된 순서대로 호출되는 구조를 가진다.

![[ 그림 3 - 핸들러 인터셉터 preHandle() 메서드 활용 예시 ]](https://user-images.githubusercontent.com/70354365/246624318-206679ea-d831-434b-a6af-d2b9fb3c14e2.png) </br>
[ 그림 3 - 핸들러 인터셉터 preHandle() 메서드 활용 예시 ]

이 때 API URL은 같지만 HTTP 메서드만 차이가 있는 경우, [ 그림 3 ] 와 같이 각 핸들러 인터셉터 별로 처리 대상을 필터링하기 위해 HTTP 메서드를 기준으로 해당 인터셉터의 서비스 로직을 적용할지 여부를 결정해야 한다.

**Q. 위 방식을 문제 상황으로 정의한 이유가 뭘까?**

각 API 마다 HTTP 메서드에 따라 통과할 인터셉터를 결정하는 패턴이 상이할 수 있고, 이로 인해 일관된 처리가 사실상 불가능한 측면이 있다는 점에서 문제 상황으로 정의했다. 또한 API 개발 과정에서 새로운 기능이 추가되거나 제외되는 과정에서 핸들러 인터셉터까지 영향을 받는 구조라는 점에서 유지﹒보수 측면에서 불리하다고 판단했다.

---
### 문제 해결 아이디어
문제 해결 과정을 요약하면 아래와 같고, 자세한 내용은 아래 관련 포스팅을 통해 확인할 수 있다.

문제 해결 과정 (3 단계)

1. Java Annotation을 활용해 각 API 별로 통과할 핸들러 인터셉터 정보 남기기

![[ 그림 4 - IgnoreAuthentication Interceptor 대상 API ] ](https://user-images.githubusercontent.com/70354365/246624325-3876cace-a0db-4261-ad68-1f096a259138.png) </br>
[ 그림 4 - IgnoreAuthentication Interceptor 대상 API ]

![[ 그림 5 - Authentication Interceptor 대상 API ]](https://user-images.githubusercontent.com/70354365/246624333-6d9ef7a0-6ce7-466f-8cab-42175a561eea.png)
 </br>
[ 그림 5 - Authentication Interceptor 대상 API ]

2. Java Reflection을 통해 컨트롤러 클래스 내 메서드 별로 선언된 Annotation에 접근해서 런타임 시점에 각 API 별로 어떤 핸들러 인터셉터를 통과해야 하는지 Map 타입의 자료구조를 활용해 <K, V> = <URL, HTTP METHOD> 형식으로 데이터 구축

3. 인터페이스 기반의 프록시 내에서 위에서 구축된 데이터를 활용해 해당 인터셉터를 통과할지 여부를 제어 (프록시 패턴 적용)

![ [ 그림 6 - 프록시 내부에 Map 형식의 자료 구조를 활용해 타겟의 로직을 호출할지 판단 ]](https://user-images.githubusercontent.com/70354365/246624349-2a0dcfb1-b2a8-4c21-9a5f-9389d8336b4c.png) </br>
[ 그림 6 - 프록시 내부에 Map 형식의 자료 구조를 활용해 타겟의 로직을 호출할지 판단 ]

---
- 관련 포스팅
    - [https://github.com/taekwon-dev/pick-git-interceptor](https://github.com/taekwon-dev/TIL/tree/main/spring/mvc/handler-interceptor/pick-git-interceptor)
    - [Spring MVC 핸들러 인터셉터에서 유저 인증 여부 및 권한 검사하기 1 — 문제 배경 및 정의](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EB%B0%8F-%EA%B6%8C%ED%95%9C-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-1-2e736844d46b)
    - [Spring MVC 핸들러 인터셉터에서 유저 인증 여부 검사하기 2 — pick-git 팀 해결 아이디어 소개 (Java Annotation, Reflection, Proxy Pattern)](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-2-pick-git-%ED%8C%80-%ED%95%B4%EA%B2%B0-%EC%95%84%EC%9D%B4%EB%94%94%EC%96%B4-%EC%86%8C%EA%B0%9C-java-annotation-reflection-85d02cc20b32)
    - [Spring MVC 핸들러 인터셉터에서 유저 인증 여부 검사하기 3 — pick-git 팀 소스 코드 분석하기](https://medium.com/taekwon-v/spring-mvc-%ED%95%B8%EB%93%A4%EB%9F%AC-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%97%90%EC%84%9C-%EC%9C%A0%EC%A0%80-%EC%9D%B8%EC%A6%9D-%EC%97%AC%EB%B6%80-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0-3-pick-git-%ED%8C%80-%EC%86%8C%EC%8A%A4-%EC%BD%94%EB%93%9C-%EB%B6%84%EC%84%9D%ED%95%98%EA%B8%B0-7aad4ffc8297)
