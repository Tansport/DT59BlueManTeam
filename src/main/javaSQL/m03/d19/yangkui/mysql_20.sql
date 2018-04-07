#到目前为止应还书的读者姓名，所借书名，应归还的日期
SELECT * FROM book

SELECT * FROM reader

SELECT * FROM borrow
#1
SELECT
(SELECT rname FROM reader WHERE temp.rid=rid) AS 读者姓名,
(SELECT bname FROM book WHERE temp.nif=bid) AS 所借书名,
temp.willdate FROM( 
SELECT b.rid,b.nif,b.willdate,b.returndate FROM borrow b WHERE
 (DATEDIFF(NOW(),willdate)) > 0 AND b.returndate IS NULL
)temp;

#2查询各种图书未借出的本数，显示查询书名和本数
 
 SELECT * FROM borrow
 SELECT * FROM book
 
 SELECT * FROM
  (SELECT a.`bcount` - COUNT(b.`nif`) AS 未借出的本数, a.`bname` AS 书名,a.`bcount` AS 本数
  FROM book a  LEFT OUTER JOIN borrow b ON a.`bid` = b.`nif` 
  GROUP BY b.`nif`) temp;
  
  #3已完成借阅的记录（图书归还日期不能为空）中，统计每位读者的借书次数，显示读者姓名和借书次数
  
 SELECT * FROM borrow
 SELECT * FROM reader
 
SELECT (SELECT rname FROM reader WHERE a.rid=rid)AS 读者姓名,COUNT(*)AS 借书次数 FROM borrow a WHERE
a.returndate IS NOT NULL GROUP BY a.rid;

#4查询总罚款金额大于5元的读者姓名和总罚款金额
SELECT * FROM penalty;
SELECT * FROM reader

SELECT (SELECT rname FROM reader WHERE a.`rid`=rid) AS 读者姓名,
SUM(amount) AS 总罚款金额 FROM penalty a
GROUP BY a.rid
HAVING SUM(amount)>5;

#5已完成借阅的记录（即图书归还日期不为空）中，每本书的借阅次数，
#显示借阅次数排名在前5位的图书名称和借阅次数

SELECT (SELECT bname FROM book WHERE a.`nif`=bid) AS 图书名称,COUNT(*) AS 借阅次数 FROM borrow a
WHERE a.`returndate` IS NOT NULL
GROUP BY a.`nif`
ORDER BY COUNT(*) DESC
LIMIT 5;

