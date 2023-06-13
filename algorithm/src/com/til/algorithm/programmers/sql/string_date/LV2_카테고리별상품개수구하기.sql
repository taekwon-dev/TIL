-- ⭐ LEFT(문자열, 길이)
-- ⭐ RIGHT(문자열, 길이)
-- ⭐ SUBSTR(문자열, 시작 위치, 길이)

SELECT LEFT(PRODUCT_CODE, 2) AS 'CATEGORY', COUNT(*) AS 'PRODUCTS'
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY PRODUCT_CODE