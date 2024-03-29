-- ⭐ LIKE '%S' : 특정 문자로 시작
-- ⭐ LIKE 'S%' : 특정 문자로 끝
-- ⭐ LIKE '%S%' : 특정 문자 포함

SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE

-- ⭐ REGEXP OR 조건 | 로 구분

SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS REGEXP ('통풍시트|열선시트|가죽시트')
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE