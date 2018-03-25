#一：为读者"张无忌"办理借阅《红楼梦》书籍的手续
BEGIN;
	INSERT INTO 
		reader(rid,rname,lennum,raddress) 
	VALUES 
		("0009","张无忌",0,NULL);
	INSERT INTO
		borrow(rid,nif,lenddate,willdate,returndate)
	VALUES 
		("0009","0006",NOW(),"2018-4-12 09:09:09",NULL);
		UPDATE book SET bcount=bcount-1 
			WHERE  bid=0006;
		UPDATE reader SET lennum=lennum+1 	
			WHERE  rid=0009;	
COMMIT;
SELECT * FROM reader;

SELECT * FROM book;


#二：实现读者“刘冰冰”缴纳罚金归还图书的手续

SELECT * FROM penalty;

SELECT * FROM borrow;

#delete from borrow where rid="0008";


BEGIN;
	INSERT INTO 
		borrow(rid,nif,lenddate,willdate) 
	VALUES 
		('0008','0007','2018-03-22 12:00:00','2018-5-20 12:00:00');
	UPDATE reader SET lennum=lennum+1
		WHERE rid='0008';
COMMIT;

BEGIN;
	INSERT INTO 
		penalty(rid,bid,pdate,ptype,amount) 
	VALUES 
		('0008','0007',NOW(),'1','4.6');
	UPDATE borrow SET returndate=NOW()
		WHERE rid='0008';
	UPDATE reader SET lennum=lennum-1
		WHERE rid='0008';
	UPDATE book SET bcount=bcount+1
		WHERE bid='0007';
COMMIT;

#三：图书馆日常管理   不会这题

#图书管理员视图
CREATE VIEW vi_borrow
	AS
		SELECT
			b.bname AS 图书名称,
			a.willdate AS 到期日期,
			r.rname AS 读者姓名
		FROM reader r
		INNER JOIN borrow a 
		ON 
			a.rid=r.rid
		INNER JOIN 
			book b 
		ON 
			b.bid=a.nif
		WHERE  r.rid IN
		(SELECT rid FROM borrow a WHERE a.willdate<NOW()AND br.returndate IS NULL); 

#读者视图
	
CREATE VIEW vi_book
	AS
		SELECT  
			b.bname AS 图书名称,
			b.bcount AS 馆存量,
			b.bcount-COUNT(br.nif) AS 可借阅数量
		FROM book b
		INNER JOIN borrow br ON br.nif=b.bid
		GROUP BY br.nif
		
		
		CREATE INDEX index_book_bname
		ON book(bname)


