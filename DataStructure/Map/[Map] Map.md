# [Map] Differences between HashMap and HashTable

##### HashMap and HashTable store key/value pairs in a hash table. When using a HashTable or HashMap, we specify an object that is used as a key and the value that you want to be linked to that key. The key is then hashed, and the resulting hash code is used as the index at which the value is stored within the table. 

### | HashMap vs HashTable 

###### 1) Sync 

HashMap is non synchronized. It is not-thread safe and can't be shared between many threads without proper synchronization code whereas HashTable is synchronized. It is thread-safe and can be shared with many threads. 

###### 2) Nullable

HashMap allows one null key and multiple null values whereas HashTable doesn't allow any null key or value.







### | Reference

###### https://www.geeksforgeeks.org/differences-between-hashmap-and-hashtable-in-java/
