# [QueryDSL] Custom implementations for Spring Data Repositories

> When a query method requires a different behavior or cannot be implemented by query derivation, then it is necessary to provide a custom implementation. Spring Data Repositories let you provide custom repository code and integrate it with generic CRUD abstraction and query method functionality. 

### | Customizing Individual Repositories 

> To enrich a repository with custom functionality, you must first define a fragment interface and an implementation for the custom functionality, as shown in the following example. 

```java
interface CustomizedUserRepository {
  void someCustomMethod(User user);
}

class CustomizedUserRepositoryImpl implements CustomizedUserRepository {
  public void someCustomMethod(User user) {
    // ... 
  }
}
```

> The implementation itself does not depend on Spring Data and can be a regular Spring bean. Consequently, you can yuse standard dependency injection behavior to inject references to other beans, take part in aspects, and so on. 

```java
interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {
  // ...
}
```



### | Reference

###### https://docs.spring.io/spring-data/jpa/docs/2.1.3.RELEASE/reference/html/#repositories.custom-implementations