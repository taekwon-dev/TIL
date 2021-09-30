# Embedded Redis Server with Spring Boot Test

로컬 서버에서 `Redis` 관련 개발 및 테스트 환경을 구축할 때는 `Embedded Redis` 를 통해서 구축하면 `Redis` 서버 내 데이터 생명주기를 Spring Application Run/Stop 주기와 맞출 수 있어 편리하다. 또한 테스트 코드 동작 시 마치 JPA Rollback 옵션을 적용한 것과 같이 각 테스트 별로 필요한 초기화 후 `Redis` 서버를 활용할 수 있어 좋다. 

 





### | Reference

###### https://www.baeldung.com/spring-embedded-redis

###### https://jojoldu.tistory.com/297

