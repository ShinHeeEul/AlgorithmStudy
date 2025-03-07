# -- 코드를 입력하세요

select * from (SELECT CAR_ID, round(avg(datediff(date(end_date), date(start_date)) + 1),1) as AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id) ce
where ce.AVERAGE_DURATION >= 7
order by ce.AVERAGE_DURATION desc, ce.CAR_ID desc;
