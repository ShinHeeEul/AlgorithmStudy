-- 코드를 입력하세요
SELECT animal_id, name from animal_ins where (animal_type = 'Dog') and (name like '%el%'
or name like '%eL%'
or name like '%El%'
or name like '%EL%')order by name