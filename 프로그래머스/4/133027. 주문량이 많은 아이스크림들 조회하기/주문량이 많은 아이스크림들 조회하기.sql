-- 코드를 입력하세요
SELECT j.FLAVOR from 
(select FLAVOR, sum(TOTAL_ORDER) as t from JULY group by FLAVOR) j join (select FLAVOR,sum(TOTAL_ORDER) as t from FIRST_HALF group by FLAVOR) f on j.FLAVOR = f.FLAVOR
order by(j.t + f.t) desc limit 3;