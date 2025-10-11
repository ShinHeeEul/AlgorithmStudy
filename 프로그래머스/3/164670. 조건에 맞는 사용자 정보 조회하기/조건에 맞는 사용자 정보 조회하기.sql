-- 코드를 입력하세요
SELECT ugu.user_id, ugu.nickname, 
concat(ugu.city, " ", ugu.street_address1, " ", ugu.street_address2) as '전체주소',
concat(substring(ugu.tlno, 1, 3), '-', substring(ugu.tlno,4, 4), '-', substring(ugu.tlno,8,4)) as '전화번호'
FROM USED_GOODS_BOARD ugb left join USED_GOODS_USER ugu
on ugb.writer_id = ugu.user_id
group by ugu.user_id, ugu.nickname, ugu.city, ugu.street_address1, ugu.street_address2, ugu.tlno
having count(board_id) >= 3
order by ugu.user_id desc;