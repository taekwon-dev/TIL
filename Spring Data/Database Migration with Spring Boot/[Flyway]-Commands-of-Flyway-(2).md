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

### | Repair

> ###### Repair is your tool to fix issues with the schema history table. It has a few main uses:
>
> - Remove failed migrations entries.
> - Realign the checksums, descriptions, and types of  the applied migrations with the ones of the available migrations.
> - Mark all missing migrations as deleted.

### | Reference

###### https://flywaydb.org/documentation/command/undo

###### https://flywaydb.org/documentation/command/baseline

###### https://flywaydb.org/documentation/command/repair