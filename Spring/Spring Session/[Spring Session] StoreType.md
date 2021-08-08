# [Spring Session] StoreType

### | StoreType:

```java
public enum StoreType {

   /**
    * Redis backed sessions.
    */
   REDIS,

   /**
    * MongoDB backed sessions.
    */
   MONGODB,

   /**
    * JDBC backed sessions.
    */
   JDBC,

   /**
    * Hazelcast backed sessions.
    */
   HAZELCAST,

   /**
    * No session data-store.
    */
   NONE
}
```