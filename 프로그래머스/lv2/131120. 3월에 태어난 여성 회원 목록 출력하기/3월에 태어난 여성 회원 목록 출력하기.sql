-- 코드를 입력하세요
-- Oracle에선 날짜 추출 시 Extract(Year/month/date from 컬럼) 

SELECT member_id, 
member_name, 
gender, 
TO_CHAR(date_of_birth, 'YYYY-MM-DD') as DATE_OF_BIRTH
from member_profile 
where gender = 'W' and TLNO is not Null and Extract(MONTH from date_of_birth) = '3' order by member_id;
