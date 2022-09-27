# Spring Boot + [Flyway](https://flywaydb.org/) - Database Migration

## Project 

---

- Spring Boot 2.5.3
- Docker, Docker-compose
- MySQL 5.7
- Flyway 7.14.0

---

이번 프로젝트에서는 DDL (CREATE, DROP, ALTER) 명령어를 중심으로 Flyway 에서 제공하는 데이터베이스 형상 관리 툴을 사용합니다.  

```groovy
implementation 'org.flywaydb:flyway-core' // build.gradle 의존성 추가
```

![image](https://user-images.githubusercontent.com/70354365/192590601-f6e942d3-9cf7-4407-85b3-f70aff68db65.png)
[ 그림 1 ]

위 의존성을 추가하고, `application.yml` 파일에 [ 그림 2 ] 와 같이 설정 해주시면 됩니다. 

```
- `spring.flyway.enabled` : default 값으로 true 를 갖고 있고, flyway 사용 여부를 결정합니다.  
- `spring.flyway.baseline-on-migrate` : default 값으로 false 를 갖고 있고, true 로 설정 시 형상 관리 테이블인 flyway-schema-history 테이블을 생성해줍니다.
- `spring.flyway.locations` : flyway 패키지 위치를 지정합니다. (아래 그림 2 참고)
```

![image](https://user-images.githubusercontent.com/70354365/192582058-bf58ab31-fda5-4bac-9764-ed00ed760b7a.png)
[ 그림 2 ]

패키지 구조는 [ 그림 2 ] 과 같이 관리하고, 별도의 패키지 경로를 수정하고 싶은 경우 spring.flyway.location 값 변경을 통해 수정 가능합니다. 

## Blog 

- [Spring Boot + Flyway DB Migration (MySQL DDL)](https://medium.com/taekwon-v/spring-boot-flyway-db-migration-mysql-ddl-4e649bda7f45)

- [Flyway - Repeatable migration & Seed Data](https://medium.com/taekwon-v/flyway-repeatable-migration-seed-data-a363c7f86206)


## | Docker-compose Command

```
docker-compose up -d --build

docker-compose down (-v, 볼륨 초기화 원하는 경우)
```

`flyway_shcema_history` 테이블에서 마이그레이션 히스토리를 관리하고 있기 때문에 컨테이너를 내리는 과정에서 기존 데이터베이스 내용이 초기화되지 않도록 하기 위해 도커 볼륨을 활용 했고, 참고로 데이터베이스를 초기화 하고 싶은 경우 도커 컴포즈 서비스를 내릴 때 -v 옵션을 활용하시면 됩니다.     



