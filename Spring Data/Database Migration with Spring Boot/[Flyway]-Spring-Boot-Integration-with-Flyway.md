# [Flyway] Spring Boot Integration with Flyway

### | application.yml 



- 앱 실행 시 자동체크 
- or 
- 커맨드 

- 형상관리 대상 
  - 주로 테이블, 테이블 내 옵션 
  - 테스트 목적
    - 내부 데이터
      - https://ecsimsw.tistory.com/entry/Flyway-DB-%EB%A7%88%EC%9D%B4%EA%B7%B8%EB%A0%88%EC%9D%B4%EC%85%98-%EA%B8%B0%EC%A1%B4-%EB%8D%B0%EC%9D%B4%ED%84%B0%EA%B0%80-%EC%9E%88%EB%8A%94-%EA%B2%BD%EC%9A%B0

- 버전  -> 추가한 날짜로 처리하는 법 
- ![image-20210823224145303](/Users/youn/Library/Application Support/typora-user-images/image-20210823224145303.png)
- 테스트 경로 추가하기, 테스트 시 쌓여 있어야 하는 데이터 자동으로 생성하기  예를 들면 꼭 있어야 하는 애들 같은 경우

커맨드 --> 자동 처리 (유연) --> 안정적으로 처리하기 위한 최적 옵션 