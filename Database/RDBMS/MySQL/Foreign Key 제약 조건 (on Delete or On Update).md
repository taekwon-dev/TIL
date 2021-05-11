# Foreign Key 제약 조건 (on Delete or On Update)

http://tcpschool.com/mysql/mysql_constraint_foreignKey

https://dev.mysql.com/doc/refman/8.0/en/create-table-foreign-keys.html

### | Foreign Key 제약 조건 

두 테이블 간의 관계에서 Foreign Key를 통해 연결된 상황에서, 참조되는 테이블에서 데이터의 수정이나 삭제가 발생하면, 참조하고 있는 테이블의 데이터도 같이 영향을 받게 된다. 참조하고 있는 테이블에 <u>어떤</u> 영향을 주는 지는 제약 조건에 따라 다르다. 

**CASCADE** :

**SET NULL** :

객체를 삭제하거나 수정하면, 해당 객체를 참조하고 있는 컬럼의 값이 `NULL` 로 세팅됩니다. 

(이 때, 해당 테이블에서 `NOT NULL` 옵션 여부를 주의해야 한다.)

**NO ACTION** :

**SET DEFAULT** :

참조되는 테이블에서 데이터를 삭제하거나 수정하면, 참조하는 테이블의 데이터는 필드의 기본 값으로 설정됩니다.

**RESTRICT** :



