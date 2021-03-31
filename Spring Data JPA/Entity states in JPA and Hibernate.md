# Entity States in JPA and Hibernate

Basically, there are **4 states** of an Object in JPA and these are New (**Transient**), **Persistent** (Managed), **Detached** (Unmanaged) and **Removed** (deleted).

https://jstobigdata.com/jpa/different-states-of-an-object-in-jpa/

![image-20210329203719214](/Users/youn/Library/Application Support/typora-user-images/image-20210329203719214.png)



### 1. New (Transient) state

An object that is newly created and **has never been associated with JPA *Persistence Context* (hibernate session)** is considered to be in the New (Transient) state. The data of objects in this state is not stored in the database.

```java
Student student = new Student("name"); 

'student' object is in New/Transient state. 
```



### 2. Persistent (JPA managed) state

An Object that **is associated with *persistence context* (hibernate session)** are in Persistent state. **Any changes** made to objects in this state are **automatically propagated to databases** without manually invoking **`persist`/`merge`/`remove`.**

```java
Student student = new Student("test@email.com");

// Make changes and see if the data is updated automatically
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(student);

// purposely made changes - did not manually update
student.setEmail("updated_email@gmail.com");
Long persistedId = student.getId();
tx.commit();
entityManager.close();
```

