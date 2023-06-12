-- ⭐ SUBSTR(문자열, 시작 위치, 길이) : 문자열 자르기
-- ⭐ CONCAT(문자열1, 문자열2) : 문자열 합치기

SELECT USER_ID, NICKNAME,
       CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소',
       CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_USER
WHERE USER_ID IN (SELECT WRITER_ID
                  FROM USED_GOODS_BOARD
                  GROUP BY WRITER_ID
                  HAVING COUNT(*) >= 3)
ORDER BY USER_ID DESC