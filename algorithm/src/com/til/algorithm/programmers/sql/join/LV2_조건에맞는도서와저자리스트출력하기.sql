-- ⭐ DATE_FORMAT(컬럼, 형식) AS 출력이름

SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM AUTHOR A
INNER JOIN BOOK B
USING(AUTHOR_ID)
WHERE B.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE