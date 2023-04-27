-- 코드를 입력하세요
-- oracle null 값 설정!! NVL!!
-- 문자열 포함 여부는 like!!!
SELECT warehouse_id, warehouse_name, address, NVL(freezer_yn, 'N') as freezer_yn from food_warehouse where warehouse_name like '%경기%' order by warehouse_id