-- 코드를 입력하세요
with cte as
(
select SHIPMENT_ID,flavor,total_order
from FIRST_HALF 
union
select SHIPMENT_ID,flavor,total_order
from july

)
select cte.flavor 
from cte
group by cte.flavor
order by sum(cte.TOTAL_ORDER) desc
limit 3