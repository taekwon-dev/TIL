SELECT AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY, SUM(SALES*PRICE) AS TOTAL_SALES
FROM (SELECT *
      FROM BOOK_SALES AS A
      INNER JOIN BOOK AS B
      USING(BOOK_ID)
      WHERE DATE_FORMAT(SALES_DATE, '%m') = '01') AS AB
INNER JOIN AUTHOR AS C
ON AB.AUTHOR_ID = C.AUTHOR_ID
GROUP BY AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY
ORDER BY AB.AUTHOR_ID ASC, AB.CATEGORY DESC

-- ⭐ NATURAL JOIN : 'ON' 절이 없는 내부 조인 (컬럼 이름이 같은 두 테이블을 조인할 때만 활용)

SELECT AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY, SUM(SALES*PRICE) AS TOTAL_SALES
FROM (
    SELECT *
    FROM BOOK_SALES AS A
    NATURAL JOIN BOOK AS B
    WHERE DATE_FORMAT(SALES_DATE, '%m') = '01'
    ) AS AB
INNER JOIN AUTHOR AS C
USING(AUTHOR_ID)
GROUP BY AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY
ORDER BY AB.AUTHOR_ID ASC, AB.CATEGORY DESC

SELECT AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY, SUM(SALES*PRICE) AS TOTAL_SALES
FROM (
     SELECT *
     FROM BOOK_SALES A
     NATURAL JOIN BOOK B
     WHERE DATE_FORMAT(SALES_DATE, '%m') = '01'
) AB
NATURAL JOIN AUTHOR C
GROUP BY AB.AUTHOR_ID, C.AUTHOR_NAME, AB.CATEGORY
ORDER BY AB.AUTHOR_ID ASC, AB.CATEGORY DESC