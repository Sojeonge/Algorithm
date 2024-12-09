-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
AND CAR_ID IN (SELECT CAR_ID
              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
               WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
               GROUP BY CAR_ID
               HAVING COUNT(CAR_ID) >= 5
              )
GROUP BY CAR_ID, MONTH
HAVING RECORDS > 0
ORDER BY MONTH, CAR_ID DESC;


// %Y : 년도(2024) / %y : 년도(21)
// %m : 월(01,02,11) / %c : 월(1,8) / %M : 월(January, August) / %b : 월(Jan, Aug)
// %d : 일(01,19) / %e : 일(1,19)
// %W : 요일(Wednesday, friday) / %a : 요일(Wed, Fri)
// %T : 시간 (12:30:00) / %r : 시간 (12:30:00 AM)
// %H : 24시간 시간(01, 14, 18) / %l : 12시간 시간 (01, 02, 06)
// %i : 분 (00)
// %S : 초 (00)
