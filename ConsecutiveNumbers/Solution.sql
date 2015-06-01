# https://leetcode.com/problems/consecutive-numbers/

/*
Consecutive Numbers Total Accepted: 2440 Total Submissions: 10365 My Submissions Question Solution
Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

实践发现我的sql实在是太烂了，因此决定找一个网站专门锻炼一下。
从reddit发现有类似问题。
http://www.reddit.com/r/SQL/comments/18fxho/are_there_any_sites_like_codecademy_to_learn_sql/
推荐的网站：
http://sqlschool.modeanalytics.com/   learn this course and read the tutorial
https://schemaverse.com/   then practice



http://sqlzoo.net/
http://www.sql-tutorial.ru/
http://sql.learncodethehardway.org/
http://sol.gfxile.net/galaxql.html   interactive on local browser

*/

select distinct Num from (
    select
        Num,
        case
            when @prevNum = Num then @count := @count + 1
            when (@prevNum := Num) is not null then @count := 1
        end n
    from Logs, (select @prevNum := NULL) init
    order by Id
) temp where n >= 3;
