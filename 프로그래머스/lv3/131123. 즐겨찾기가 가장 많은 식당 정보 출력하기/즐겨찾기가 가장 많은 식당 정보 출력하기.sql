-- 코드를 입력하세요

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES from rest_info where (FOOD_TYPE, FAVORITES) IN (select FOOD_TYPE, MAX(FAVORITES) from rest_info group by food_type) order by food_type desc;