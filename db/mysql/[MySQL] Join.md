# [MySQL] Join

### | JOIN :

JOIN은 데이터베이스 내 여러 테이블에서 가져온 레코드를 조합하여 하나의 테이블이나 결과 집합으로 표현한다. 보통 SELECT 절과 함께 사용된다. 

### | JOIN Type : 

- **INNER JOIN**

  (MySQL에서는 JOIN, INNER JOIN, CROSS JOIN 모두 같은 의미로 사용된다.)

  ON 절의 조건 (WHERE 절과 동일)을 만족하는 데이터만을 가져온다. 

  `A INNER JOIN B ON {조건절}` or `A JOIN B ON {조건절}`

- **LEFT JOIN**

  LEFT JOIN은 첫 번째 테이블을 기준으로, 두 번째 테이블을 조합하는 JOIN이다. 이 때 ON 절의 조건을 만족하지 않는 경우에는 첫 번째 테이블의 필드 값은 그대로 가져오고, 두 번째 테입블의 필드 값은 모두 NULL로 표시된다. 

  `A LEFT JOIN B ON {조건절}`

- **RIGHT JOIN**

  RIGHT JOIN은 LEFT JOIN과 달리, 두 번째 테이블을 기준으로 첫 번째 테이블을 조합하는 JOIN이다. 

### | Diagram : 

벤 다이어그램으로 JOIN TYPE을 각각 표현하면 다음과 같다. 

![image-20210706182444990](image/mysql-join1.png)

​															    <그림 1 : INNER JOIN> 

![image-20210706182444990](image/mysql-join2.png)

​																  <그림 2 : LEFT JOIN>

![image-20210706182444990](image/mysql-join3.png)

​																  <그림 3 : RIGHT JOIN> 



### | Reference : 

http://tcpschool.com/mysql/mysql_multipleTable_join