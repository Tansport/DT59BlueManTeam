/*
第三题 为张无忌办理借阅红楼梦书籍的手续
*/ 
BEGIN;
	INSERT INTO reader(rid,rname,lennum) VALUES ('0009','张无忌','0');
	INSERT INTO borrow(rid,nif,lenddate,willdate) VALUES ('0009','0006',NOW(),'2018-05-30 09:13:07');
	UPDATE book SET bcount=bcount-1
		WHERE bid=0006;
	UPDATE reader SET lennum=lennum+1
		WHERE rid=0009;
COMMIT;


/*
第四题
编译实现读者刘冰冰缴纳罚金归还图书的手续
*/
BEGIN;
	INSERT INTO borrow(rid,nif,lenddate,willdate) VALUES ('0008','0007','2017-09-22 09:13:00','2017-10-06 17:27:35');
	UPDATE reader SET lennum=lennum+1
		WHERE rid=0008;
COMMIT;

BEGIN;
	INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES ('0008','0007',NOW(),'1','4.6');
	UPDATE borrow SET returndate=NOW()
		WHERE rid=0008;
	UPDATE reader SET lennum=lennum-1
		WHERE rid=0008;
	UPDATE book SET bcount=bcount+1
		WHERE bid=0007;
COMMIT;
/*
第五题

*/
CREATE VIEW view_borrow
	AS
		SELECT b.bname AS 图书名称,br.willdate AS 到期日期,r.rname AS 读者姓名
		FROM reader r
		INNER JOIN borrow br ON br.rid=r.rid
		INNER JOIN book b ON b.bid=br.nif
		WHERE  r.rid IN(SELECT rid FROM borrow br WHERE br.willdate<NOW()AND br.returndate IS NULL) 
		
CREATE VIEW view_book
	AS
		SELECT  b.bname AS 图书名称,b.bcount AS 馆存量,b.bcount-COUNT(br.nif) AS 可借阅数量
		FROM book b
		INNER JOIN borrow br ON br.nif=b.bid
		GROUP BY br.nif
		
		
CREATE INDEX index_book_bname
ON book(bname)



		