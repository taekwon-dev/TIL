# [MySQL] FOREIGN KEY Constraints

> MySQL support `ON UPDATE` and `ON DELETE` foreign key reference in `CREATE TABLE` and `ALTER TABLE` statements. The available referential actions are `RESTRICT`, `CASCADE`, `SET NULL`, and `NO ACTION`.
>
> `SET DEFAULT` is also supported by the MySQL Server but is currently rejected as invalid by [`InnoDB`](https://dev.mysql.com/doc/refman/8.0/en/innodb-storage-engine.html). Since MySQL does not support deferred constraint checking, `NO ACTION` is treated as `RESTRICT`.



> <u>MySQL requires that foreign key columns **be indexed</u>;** if you create a table with a foreign key contraint but no index on a given column, an index is created. 
>
> You can obtain information about foreign keys from the [`INFORMATION_SCHEMA.KEY_COLUMN_USAGE`](https://dev.mysql.com/doc/refman/8.0/en/information-schema-key-column-usage-table.html) table



```sql
SELECT TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_SCHEMA IS NOT NULL;
```

















### | Reference

###### https://dev.mysql.com/doc/refman/8.0/en/constraint-foreign-key.html