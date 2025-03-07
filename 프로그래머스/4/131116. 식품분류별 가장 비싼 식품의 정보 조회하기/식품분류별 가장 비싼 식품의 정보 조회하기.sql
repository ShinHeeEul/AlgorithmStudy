-- 코드를 입력하세요
select f.category as CATEGORY, f.price as MAX_PRICE, f.product_name as PPRODUCT_NAME from
(SELECT product_name, max(price) over(partition by category) as p
from FOOD_PRODUCT) e join FOOD_PRODUCT f
where e.p = f.price and CATEGORY in ('과자', '국', '김치', '식용유')
group by f.CATEGORY
order by MAX_PRICE desc;