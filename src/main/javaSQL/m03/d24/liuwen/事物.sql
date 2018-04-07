#为读者"张无忌"办理借阅《红楼梦》书籍的手续，要求编码实现；
BEGIN;
	INSERT INTO reader VALUES ('0009','张无忌',0,NULL);
	INSERT INTO borrow (rid,nif,lenddate,willdate) VALUES ('0009','0006','2017-09-22 09:13:00',NOW());
	UPDATE book SET bcount=bcount-1 WHERE bid = '0006';
	UPDATE reader SET lennum=lennum+1 WHERE rid = '0009';
COMMIT;

#编译实现读者刘冰冰缴纳罚金归还图书的手续
BEGIN;
	DELETE FROM penalty WHERE rid = '0008';
	INSERT INTO penalty VALUES ('0008','0007',NOW(),1,4.6);
	INSERT INTO borrow VALUES('0008','0007','2017-09-22 09:13:00','2017-12-22 09:13:00',NULL);
	UPDATE borrow SET returndate=NOW() WHERE rid = '0008';
	UPDATE reader SET lennum=lennum-1 WHERE rid = '0008';
	UPDATE book SET bcount=bcount+1 WHERE bid = '0007';
COMMIT;

#创建读书者试图和读者试图

	
	
	