USE library;
SHOW TABLES;

SELECT * FROM reader;
SELECT * FROM borrow;
SELECT * FROM book;
SELECT * FROM penalty;

#第三题：为读者"张无忌"办理借阅《红楼梦》书籍的手续，要求编码实现；
#1.增加名字为张无忌的读者信息和借阅信息
INSERT INTO reader(rid,rname,lennum,raddress) VALUES ("0010","张无忌",0,NULL);
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) VALUES ("0010","0006","2018-3-12 09:09:09","2018-4-12 09:09:09",NULL);
#2.使用事务更改字段信息并提交；
BEGIN;
UPDATE reader SET lennum=lennum+1 WHERE rname="张无忌";
UPDATE book SET bcount=bcount-1 WHERE bname="红楼梦";
COMMIT;

#第四题：编码实现读者"刘冰冰"缴纳罚金归还图书的手续，要求一次完成以下功能；
#1.在罚款记录表中添加一条记录，记录"刘冰冰"因延期归还《西游记》一书而缴纳滞纳金4.6元；
#2.在图书借阅表中修改归还日期为当前日期；
#3.在读者信息表中已借书数量减1；
#4.将图书信息表中现存数量加1；


BEGIN;
#删除此表中已有信息
DELETE FROM penalty WHERE rid="0008";
#删除此表中已有信息
DELETE FROM borrow WHERE rid="0008";
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) VALUES ("0008","0007","2018-2-22 08:08:08","2018-3-22 08:08:08","2018-03-24 17:50:50");
INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES ("0008","0007","2018-03-24 17:50:50","1","4.6");
UPDATE borrow SET willdate=NOW() WHERE rid="0008";
UPDATE reader SET lennum=lennum+1 WHERE rname="刘冰冰";
UPDATE book SET bcount=bcount-1 WHERE bname="西游记";
COMMIT;

#第五题：在图书馆日常工作中，图书管理员希望及时得到最新的到期图书清单，包括图书名称，到期日期和读者姓名等信息；
#而读者则关心的各种图书信息，如图书名称，馆存量和可阅读数量等。
#请编写代码上面的需求在图书名称字段创建索引，为图书馆管理员和读者分别创建不同的查询视图，
#并利用所创建的索引和视图获得相关的数据；

#管理员视图
DROP VIEW IF EXISTS vw_list_borrrow;
CREATE VIEW vw_list_borrrow
AS 
SELECT willdate AS 到期时间,
(SELECT bname FROM book  WHERE bid=b.nif) AS 图书名称,
(SELECT rname FROM reader WHERE rid=b.rid) AS 读者姓名
 FROM borrow b WHERE returndate IS NULL AND YEAR(willdate)=YEAR(NOW());
 
CREATE INDEX index_bname ON book(bname);

SELECT * FROM vw_list_borrrow;
#读者视图
DROP VIEW IF EXISTS vw_list_reader;
CREATE VIEW vw_list_reader
AS
SELECT bname AS 图书名称,
((SELECT lennum FROM reader WHERE rid IN
(SELECT rid FROM borrow WHERE borrow.`nif`=reader.`rid`))+
(SELECT bcount FROM book WHERE book.`bid`=b.bid))AS 馆存量,
bcount AS 可借阅数量
FROM book b

SELECT 图书名称,馆存量,可借阅数量 FROM vw_list_reader;


#mysqldump -u root -p root library>d:\mysql\homework.sql
#mysql -u root -p library<d:\mysql\homework.sql
#select columnlist from tablename where 
#into outfile
