# Create database on docker-compose start up

로컬 개발 / 테스트 환경 구축 과정에서 로컬 호스트 볼륨 내 `init.sql` 를 통해 데이터베이스를 생성 할 수 있다. 직접적으로 호스트에 설치된 `mysql` 서버가 참조하고 있는 데이터 저장 경로를 공유하는 것이 아닌 데이터베이스 생성 쿼리 파일을 통해 컨테이너가 `run` 할 때 초기화 작업으로 활용할 수 있다. 

```sql
database:
    image: mysql:5.7
    ports:
        - "3306:3306"
    command: --init-file /data/application/init.sql
    volumes:
        - ./init.sql:/data/application/init.sql
    environment:
        MYSQL_ROOT_USER: root
        MYSQL_ROOT_PASSWORD: password
        MYSQL_DATABASE: database
        MYSQL_USER: user
        MYSQL_PASSWORD: password
```



### | Reference

###### https://stackoverflow.com/questions/43322033/create-database-on-docker-compose-startup

