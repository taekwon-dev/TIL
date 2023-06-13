-- ⭐ REGEXP 모음으로 끝나는 대상 찾기 REGEXP '(a|e|i|o|u)$'

SELECT DISTINCT CITY
FROM STATION
WHERE CITY REGEXP '(a|e|i|o|u)$'