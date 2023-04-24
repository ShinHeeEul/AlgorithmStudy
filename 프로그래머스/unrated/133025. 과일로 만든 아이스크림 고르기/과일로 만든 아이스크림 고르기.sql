-- 코드를 입력하세요
SELECT flavor from first_half where total_order > 3000 and flavor in (select flavor from icecream_info where ingredient_type = 'fruit_based') order by total_order desc
