-- ⭐ ^(=~로 시작하는 것) + [^문자] (= ~로 시작하지 않는 것)

SELECT DISTINCT CITY
FROM STATION
WHERE CITY REGEXP '^[^(a|e|i|o|u)]'