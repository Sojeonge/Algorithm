-- 코드를 작성해주세요
WITH RESULT AS (
    SELECT *, 
    (CASE
        WHEN LENGTH IS NULL THEN 10
        WHEN LENGTH <= 10 THEN 10
        ELSE LENGTH
    END) AS R_LENGTH
    FROM FISH_INFO
) // CTE

SELECT COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM RESULT
GROUP BY FISH_TYPE
HAVING AVG(R_LENGTH) >= 33
ORDER BY FISH_TYPE;
