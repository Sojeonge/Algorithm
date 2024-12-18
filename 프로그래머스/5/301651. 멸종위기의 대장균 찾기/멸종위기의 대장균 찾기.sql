WITH RECURSIVE DATA_GENERATION AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT D.ID, D.PARENT_ID, G.GENERATION + 1
    FROM DATA_GENERATION G JOIN ECOLI_DATA D
    ON G.ID = D.PARENT_ID
)

SELECT COUNT(*) AS COUNT, GENERATION
FROM DATA_GENERATION
WHERE ID NOT IN (
SELECT DISTINCT PARENT_ID
FROM DATA_GENERATION
WHERE PARENT_ID IS NOT NULL)
GROUP BY GENERATION
ORDER BY GENERATION;
