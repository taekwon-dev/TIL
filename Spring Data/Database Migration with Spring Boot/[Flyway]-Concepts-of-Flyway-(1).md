# [Flyway] Concepts of Flyway (1)

### | 목차

##### - Migrations ◀︎ **현재 글**

##### - Callbacks ◀︎ **현재 글**

##### - Error Overrides

##### - Dry Runs 

##### - State Scripts 

___

### | Migrations

>

### | Callback 

\# <u>시점</u> 

> While migrations are sufficient for most needs, there are certain situations that require you to **execute the same action over and over again**. This could be recompiling procedures, updating materialized views and many other types of housekeeping. 
>
> For this reason, Flyway offeres you <u>the possibility to hook into its lifecycle by using Callbacks</u>.



### | Reference

###### https://flywaydb.org/documentation/concepts/migrations

###### https://flywaydb.org/documentation/concepts/callbacks