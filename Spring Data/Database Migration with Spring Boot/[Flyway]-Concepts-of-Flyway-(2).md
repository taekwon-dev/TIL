# [Flyway] Concepts of Flyway (2)

### | 목차

##### - Migrations 

##### - Callbacks 

##### - Error Overrides ◀︎ **현재 글**

##### - Dry Runs 

##### - State Scripts 

___

### | Error Overrides 

\# <u>커스텀 예외 처리</u>

> While Flyway executes SQL statements it reports all warnings returned by the database. In case an error is returned Flyway displays it with all necessary details, marks the migration as failed and automatically rolls it back if possible. 
>
> This default behavior is greate for the vast majority of the cases.
>
> There are however situations where you may want to 
>
> - ###### treat an error as a warning as you know your migration will handle it correctly later
>
> - ###### treat a warning as an error as you prefer to fail fast to be able to fix the problem sooner
>
> - ###### perform an additional action when a specific error or warning is being emitted by the database



### | Reference

###### https://flywaydb.org/documentation/concepts/erroroverrides