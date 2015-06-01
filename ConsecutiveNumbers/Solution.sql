select * from Logs where Num in (select Num from Logs group by Num having count(id) > 3);
