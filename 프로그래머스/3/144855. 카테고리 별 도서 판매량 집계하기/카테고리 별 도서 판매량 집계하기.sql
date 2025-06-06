-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B JOIN BOOK_SALES S
ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE >= '2022-01-01' AND S.SALES_DATE < '2022-02-01'
GROUP BY CATEGORY
ORDER BY CATEGORY;
