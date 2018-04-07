SELECT * FROM student GROUP BY sex 
SELECT * FROM student;
SELECT gradeID,sex,COUNT(studentname) AS 人数 FROM student GROUP BY GradeId, sex HAVING COUNT(*)>1  ;

SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT * FROM penalty;
USE library;

DESC borrow;
#第二题，查询没有借阅信息的读者编号和姓名
SELECT r.`rid` AS `读者编号` ,r.`rname` AS `读者姓名` FROM reader r WHERE NOT EXISTS(
SELECT * FROM borrow WHERE r.`rid`=rid
) ;

#第三题，查询所有到今天为止应还书但未还书的读者姓名，所借书的书名，应归还日期：
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) 
VALUES("0002","0006","2018-03-10 08:08:08","2018-03-20 08:08:08",NULL),
("0003","0007","2018-03-08 08:08:08","2018-03-20 08:08:08",NULL);

SELECT 
(SELECT rname FROM reader WHERE reader.`rid`=b.`rid`)AS 读者姓名,
(SELECT bname FROM book WHERE book.`bid`=b.`nif`)AS 所借书名,
b.`willdate` AS 应还日期 FROM borrow b WHERE b.`returndate` IS NULL AND DATEDIFF(NOW(),willdate)>0;

#第四题，查询各种图书未借出的本数，显示查询书名和本书；

SELECT b.`bname` AS 书名,b.`bcount`-COUNT(c.nif) AS 数量 
FROM book b 
INNER JOIN borrow c ON b.`bid`=c.`nif` GROUP BY c.`nif`;

#第五题，从已完成借阅记录(即图书归还日期不为空）中，统计每位读者的借书次数，显示读者姓名和借书次数；

SELECT
(SELECT c.rname FROM reader c WHERE c.`rid`=b.`rid`) AS 读者姓名,
COUNT(b.rid) AS 借书次数 FROM borrow b  WHERE b.returndate IS NOT NULL GROUP BY b.rid;


#第六题，查询总罚款金额大于5元的读者姓名和总罚款金额；
INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES("0006","0004","2018-03-20 00:00:00","2","8");
INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES("0006","0005","2018-03-20 00:00:00","2","8");
SELECT 
(SELECT c.rname FROM reader c WHERE c.`rid`=p.`rid`) AS 读者姓名,
SUM(p.`amount`) AS 总金额 
FROM penalty p 
GROUP BY p.`rid` 
HAVING SUM(p.`amount`)>5;

#第七题，统计已完成借阅的记录(即图书归还日期不为空)中的每本书的借阅次数，显示借阅次数排在前5位的图书名称和借阅次数；
SELECT
(SELECT c.bname FROM book c WHERE c.bid=b.nif) AS 图书名称,
 COUNT(b.`nif`) AS 借阅次数 FROM borrow b WHERE b.`returndate` IS NOT NULL GROUP BY b.`nif`
 ORDER BY COUNT(b.`nif`) DESC LIMIT 5;
 

 