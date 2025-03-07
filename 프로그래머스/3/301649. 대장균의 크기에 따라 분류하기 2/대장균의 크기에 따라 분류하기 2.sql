-- 코드를 작성해주세요

select e.id, case when e.p < 0.25 then 'CRITICAL'
when e.p < 0.5 then 'HIGH'
when e.p < 0.75 then 'MEDIUM'
else 'LOW'
end  as COLONY_NAME from
(select id, percent_rank() over(order by size_of_colony desc) as p from ecoli_data) e order by id;