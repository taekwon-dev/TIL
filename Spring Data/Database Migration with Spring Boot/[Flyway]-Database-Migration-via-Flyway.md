# [Flyway] Base Database Migration via Flyway

### | Why database migrations?

###### - What state is the database in on this machine?

###### - Has this script already been applied or not?

###### - Has the quick fix in production been applied in test afterwards?

###### - How do you set up a new database instance? 



### | How Flyway works?

##### - Empty 

##### - Tracking the state of the database via Metadata (*flyway_schema_history*)

##### - Version 

Flyway will once again scan the filesystem or the classpath of the application for migrations. The migrations are checked against the schema history table. If their version number is lower or equal to the one of the version marked as current, they are ignored.









###  | Reference

###### https://www.youtube.com/watch?v=TMUMWfSS3yw

###### https://flywaydb.org/documentation/getstarted