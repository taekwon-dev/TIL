-- ⭐ LENGTH(문자열) : 문자열 길이 리턴
-- ⭐ CHAR_LENGTH(문자열) : LENGTH() 함수는 한글 길이 계산 시 정확한 길이를 반환하지 못함

(
    SELECT CITY, CHAR_LENGTH(CITY)
    FROM STATION
    WHERE CHAR_LENGTH(CITY) = (SELECT MIN(CHAR_LENGTH(CITY)) FROM STATION)
    ORDER BY CITY
    LIMIT 1
)
UNION ALL
(
    SELECT CITY, CHAR_LENGTH(CITY)
    FROM STATION
    WHERE CHAR_LENGTH(CITY) = (SELECT MAX(CHAR_LENGTH(CITY)) FROM STATION)
    ORDER BY CITY
    LIMIT 1
)