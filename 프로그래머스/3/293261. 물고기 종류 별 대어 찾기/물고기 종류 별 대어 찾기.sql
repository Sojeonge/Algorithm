-- 코드를 작성해주세요
# SELECT A.ID, B.FISH_NAME, A.LENGTH
# FROM FISH_INFO A JOIN FISH_NAME_INFO B
# ON A.FISH_TYPE = B.FISH_TYPE
# WHERE A.LENGTH = (
# SELECT MAX(LENGTH)
# FROM FISH_INFO
# WHERE FISH_TYPE = A.FISH_TYPE
# )
# ORDER BY A.ID;

WITH MAX_LENGTH AS (
SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
FROM FISH_INFO
GROUP BY FISH_TYPE
)
SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
JOIN MAX_LENGTH M
ON A.FISH_TYPE = M.FISH_TYPE AND A.LENGTH = M.LENGTH
JOIN FISH_NAME_INFO B
ON A.FISH_TYPE = B.FISH_TYPE
ORDER BY A.ID;
