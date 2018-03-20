/*
第三题
查询所有到今天为止 应还书但还未归还的
读者姓名 所借书的书名 应归还日期

*/
select * from reader r where not exists(
select * from borrow where r.rid=rid);


/*
第四题
查询各种图书未借出的本数 
显示查询书名和本数
*/
SELECT 
b.bname AS 书名,
b.price - COUNT(br.nif) AS 本数
FROM book b
LEFT JOIN borrow br 
ON b.bid=br.nif
GROUP BY br.nif

/*
第五题
从已完成的借阅记录中
统计每位读者的借书次数
显示读者姓名和借书次数
*/
SELECT 
r.rname AS 读者姓名,
COUNT(br.nif) AS 借书次数
FROM borrow br
JOIN reader r
ON r.rid=br.rid AND br.returndate IS NOT NULL
GROUP BY br.nif


/*
第六题
查询总罚金大于5元的
读者姓名 和总罚金金额
*/
SELECT
(SELECT r.rname FROM reader r WHERE r.rid=p.rid) AS 读者姓名,
SUM(p.amount) AS 总罚金
FROM penalty p
GROUP BY p.rid
HAVING SUM(p.amount)>5

/*
第七题
统计已完成借阅记录的每本书的借阅次数
显示借阅次数的排名在前五的图书名称和借阅次数
*/
SELECT
b.bname AS 图书名称,
COUNT(br.nif) AS 借阅次数
 FROM borrow br
JOIN  book b
ON b.bid=br.rid AND br.returndate IS NOT NULL
GROUP BY br.nif
ORDER BY 借阅次数 DESC
LIMIT 5;


