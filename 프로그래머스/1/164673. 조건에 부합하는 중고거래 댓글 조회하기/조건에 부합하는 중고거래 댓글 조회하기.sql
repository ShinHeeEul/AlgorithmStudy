-- 코드를 입력하세요
SELECT ugb.TITLE, 
ugb.BOARD_ID, 
ugr.REPLY_ID, 
ugr.WRITER_ID, 
ugr.CONTENTS, 
DATE_FORMAT(ugr.created_date, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD ugb join USED_GOODS_REPLY ugr
on ugb.board_id = ugr.board_id
where YEAR(ugb.created_date) = 2022 and MONTH(ugb.created_date) = 10
order by ugr.created_date asc, ugb.title asc