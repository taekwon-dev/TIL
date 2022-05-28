# Spring Boot + Flyway - Database Migration

[Spring Boot + Flyway DB Migration (MySQL DDL)](https://medium.com/taekwon-v/spring-boot-flyway-db-migration-mysql-ddl-4e649bda7f45)

---

- Spring Boot 2.5.3
- Docker, Docker-compose
- MySQL 5.7 
- Flyway 7.14.0 

---

### | Docker-compose Command 

Flyway 컨테이너를 띄워서 DB Migration 하지 않고 Spring 애플리케이션에서 Flyway 의존성을 통해 DB Migration을 처리합니다.
따라서 Spring Application Resource에서 관리하는 Flyway Migrations 파일이 추가, 수정, 삭제 등의 변경 이력이 생기는 경우 
새롭게 빌드가 필요합니다. 

> docker-compose up -d --build 

현재 도커 볼륨을 통해서 MySQL 데이터베이스를 호스트와 연동해서 관리합니다. 도커 볼륨까지 모두 삭제해서 히스토리를 초기화하려면 -v 옵션을 사용하면 됩니다. 

> docker-compose down (-v, if you want to init the previous history)

