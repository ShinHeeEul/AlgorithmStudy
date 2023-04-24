-- 코드를 입력하세요
SELECT count(*) as USERS  from user_info where (joined between '2021-00-00' and '2022-00-00' && age >= 20 && age <= 29)

-- select * from user_info