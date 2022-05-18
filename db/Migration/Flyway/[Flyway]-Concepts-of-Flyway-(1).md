# [Flyway] Concepts of Flyway (1)

### | 목차

##### - Migrations ◀︎ **현재 글**

##### - Callbacks 

##### - Error Overrides

##### - Dry Runs 

##### - State Scripts 

___

### | Migrations

#### 	- Versioned Migrations

> ###### The most common type of migration is a **versioned migration**	

#### 	- Repeatable Migrations 

> ###### **Repeatable migrations** have a description and a checksum, but no version. <u>Instead of being run just once, they are (re-) applied every time their checksum changes</u>.
>
> ###### When any changes apply to file then it will be execute again at time of migration.
>
> R__ 스크립트 파일이 수정되는 시점에 Migration 진행
>
> ddl-auto create or create-drop과는 조합이 맞지 않음
>
> 

#### 	- SQL-based Migrations

> ###### Migrations are most commonly written in **SQL**

![image-20210824155340579](/Users/youn/Library/Application Support/typora-user-images/image-20210824155340579.png)

### | Reference

###### https://flywaydb.org/documentation/concepts/migrations#versioned-migrations

###### https://flywaydb.org/documentation/concepts/migrations#repeatable-migrations

###### https://flywaydb.org/documentation/concepts/migrations#sql-based-migrations

###### https://stackoverflow.com/questions/43267202/flyway-the-meaning-of-the-concept-of-checksums

###### 