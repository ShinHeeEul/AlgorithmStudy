-- 코드를 입력하세요
SELECT concat('/home/grep/src/', ugb.BOARD_ID, '/', ugf.FILE_ID, ugf.FILE_NAME, ugf.FILE_EXT) as 'FILE_PATH'
FROM 
USED_GOODS_FILE ugf join USED_GOODS_BOARD ugb
on ugf.BOARD_ID = ugb.BOARD_ID,
(select max(VIEWS) as vi from USED_GOODS_BOARD) ugbv
where ugbv.vi = ugb.VIEWS
order by ugf.FILE_ID desc;
