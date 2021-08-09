# [Redis] Data Type 

### | Strings

> Strings are the most basic kind of Redis value. Redis String are <u>binary safe</u>, this means that a Redis String can contain any kind of data, for instance a JPEG image or a serialized Ruby Object.

- A String value can be at max **512 MB** in length.

### | Lists

> Redis Lists are simply lists of strings, sorted by insertion order. It is possible to add elements to a Redis List pushing new elements <u>on the head</u>, or <u>on the tail</u> of the list. 
>
> The **LPUSH** command inserts a new element on the head, while **RPUSH** inserts a new element on the tail. 

```sql
LPUSH mylist a   # now the list is "a"
LPUSH mylist b   # now the list is "b","a"
RPUSH mylist c   # now the list is "b","a","c" (RPUSH was used this time)
```

- The max length of a list is (2^32 -1) elements. 
- Insertions to head or tail : O(1)
- Access to the element : O(N)

### | Sets 

> Redis Sets are an unordered collection of Strings. It is possible to add, remove, and test for existence of members in O(1). Redis Sets have the desirable property of not allowing repeated members. 

- The max length of a list is (2^32 -1) elements. 

### | Hashes

> Redis Hashes are maps between string fields and string values, so they are the perfect data type to represent objects. (e.g. A User with a number of fields like name, surname, age, and so forth). A hash with a few fields is stored in a way that takes very little space, so you can store millions of objects in a small Redis instance.

- Every hash can store up to (2^32 -1) elements field-value pairs (more than 4 billion).

### | Sorted sets 

> Redis Sorted are, similarly to Redis Sets, non repeating collections of Strings. The difference is that every member of a Sorted Set is associated with score, that is used in order to take the sorted set ordered, from the smallest to the greatest score. While members are unique, scores may be repeated. 

### | Reference

###### https://redis.io/topics/data-types
