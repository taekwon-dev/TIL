-- ⭐ JOIN 과정에서 ON 대신, USING(외래 키) 활용 가능
-- ⭐ LEFT OUTER JOIN에서 왼쪽 테이블에만 있는 것을 표현할 때 IS NULL 활용
-- ⭐ 오름차순 적용 시 ASC 생략 가능
-- ⭐ LIMIT 출력하고 싶은 로우 수 제한 시 활용

SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS I
LEFT OUTER JOIN ANIMAL_OUTS O
USING(ANIMAL_ID)
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
LIMIT 3