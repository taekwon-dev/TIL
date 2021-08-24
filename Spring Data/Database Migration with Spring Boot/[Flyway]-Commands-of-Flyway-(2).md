# [Flyway] Commands of Flyway (1)

### | 목차

##### - Migrate 

##### - Clean 

##### - Info 

##### - Validate 

##### - Undo ◀︎ **현재 글**

##### - Baseline ◀︎ **현재 글**

##### - Repair ◀︎ **현재 글**

___

### | Undo

### | Baseline

\# 기준 - Migrate 

> ###### Baselines an existing database, excluding all migrations up to and including baselineVersion.

![image-20210823233536309](/Users/youn/Library/Application Support/typora-user-images/image-20210823233536309.png)

​						  <그림 1>

`baseline`은 특정 시점에 대한 스냅샷 즉, version으로써 역할한다. 이를 통해서 `baseline` 을 포함 이전 version을 migrate 대상을 관리할 수 있다. 

### | Repair

> ###### Repair is your tool to fix issues with the schema history table. It has a few main uses:
>
> - Remove failed migrations entries. (실패 history가 있는 경우, 앱 실행 과정에서 에러 발생)
> - Realign the <u>checksums</u>, descriptions, and types of  the applied migrations with the ones of the available migrations.
> - Mark all missing migrations as deleted.

### | Reference

###### https://flywaydb.org/documentation/command/undo

###### https://flywaydb.org/documentation/command/baseline

###### https://flywaydb.org/documentation/command/repair