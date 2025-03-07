-- 코드를 입력하세요
with RECURSIVE cte as (
    select 0 as a
    union
    select a + 1 from cte where a < 23
)
select cte.a as HOUR, count(hour(datetime)) as COUNT
from cte left join animal_outs on cte.a = hour(datetime) group by cte.a
order by cte.a;