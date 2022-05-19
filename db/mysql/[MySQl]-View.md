# [MySQL] View

### | View 

> View는 데이터베이스에 존재하는 일종의 가상 테이블을 의미한다. 이러한 뷰는 실제 테이블처럼 행과 열을 가지고 있지만, 실제로 데이터를 저장하고 있지는 않는다. 
>
> MySQL에서 View는 다른 테이블이나 다른 뷰에 저장되어 있는 데이터를 보여주는 역할만을 수행한다. 즉, View를 사용하면 여러 테이블이나 View를 하나의 테이블처럼 볼 수 있다. 



### | View 대체 

> Create 문에 OR REPLACE 절을 추가하여 기존에 존재하는 View를 새로운 View로 대체할 수 있다. 
>
> 대체할 View가 없으면 CREATE VIEW 문과 같은 결과를 반환한다. 

```sql
CREATE OR REPLACE VIEW 뷰이름 AS 
SELECT F1, F2, ...
FROM 테이블이름
WHERE 조건 
```





### | Reference

###### http://tcpschool.com/mysql/mysql_view_createReplace