SELECT H.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
INNER JOIN CAR_RENTAL_COMPANY_CAR C
USING(CAR_ID)
WHERE C.CAR_TYPE REGEXP '세단' AND DATE_FORMAT(H.START_DATE, '%Y-%m') = '2022-10'
GROUP BY CAR_ID
ORDER BY CAR_ID DESC