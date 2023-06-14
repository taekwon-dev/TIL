SELECT
    CASE
        WHEN A = B AND B = C THEN "Equilateral"
        WHEN A + B <= C THEN "Not A Triangle"
        WHEN A != B AND B != C AND A != C THEN "Scalene"
        ELSE "Isosceles"
    END
FROM TRIANGLES