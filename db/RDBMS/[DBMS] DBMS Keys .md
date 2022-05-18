# [DBMS] DBMS Keys 



### | What are Keys?

> KEYS in DBMS(Database Manage System) is an attribute or set of attributes which helps you to **identify** a row in a relation(table). Keys help you uniquely identify a row in a table by a combination of one or more columns in that table.

### | Types of Keys 

###### - Super Key

###### - Primary Key

###### - Candidate Key

###### - Alternate Key

###### - Foreign Key

###### - Compound Key

###### - Composite Key

###### - Surrogate Key 



### | Primary Key (기본키)

> PRIMARY KEY in DBMS is a column or group of columns in a table that uniquely identify every row in that table. The Primary Key can't be a duplicate meaning the same value can't appear more than once in the table. A table cannot have more than one primary key. 

- Two rows can't have the same primary key value. 
- It must for every row to have a primary key.
- The primary key field cannot be null.
- The value in a primary key column can never be modified or updated if any foreign key refers to that primary key. 



### | Compound Key 

> COMPOUND KEY has two or more attributes that allow you <u>to uniquely recognize a specific record</u>. It is possible that each column may not be unique by itself within the database. However, when combined with the other column or columns the combination of composite keys become unique. The purpose of the compound key in database to uniquely identify each record in the table. 

![image-20210809221838630](/Users/youn/Library/Application Support/typora-user-images/image-20210809221838630.png)

​								<그림 1> 

`OrderNO`, `ProductID` 각 컬럼은 중복된 값이 있어 PRIMARY 키가 될 수 없다 (= 특정 로우를 특정할 수 없다). 하지만 두 컬럼을 조합했을 경우에는 데이터베이스 내에서 특정 로우를 식별할 수 있게 된다. 이를 `COMPOUND KEY` 라고 한다. 

### | Composite Key 

> COMPOSITE KEY is a combination of two or more columns that uniquely identify rows in a table. <u>**The combination of columns guarantees uniqueness, though individually uniqueness is not guaranteed**</u>. Hence, they are combined to uniquely identify records in a table.

\+ compound vs composite 맥락 부터 살펴보기

### | Reference

###### https://www.guru99.com/dbms-keys.html

###### https://www.sololearn.com/Discuss/1443614/difference-between-compound-key-and-composite-key-please-any-one-help-on-this