/*
第二题
*/
DELIMITER ;;
CREATE PROCEDURE ups_test_01(IN r VARCHAR(20),IN bid VARCHAR(20),IN ptype INT,IN amount FLOAT)
BEGIN
	INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES (r,bid,NOW(),ptype,amount);
	UPDATE borrow SET returndate=NOW() WHERE rid=r;
	UPDATE reader SET lennum=lennum-1 WHERE rid=r;
	
	UPDATE book SET bcount=bcount+1 WHERE bid=bid;
END
;;
DELIMITER ;

DROP PROCEDURE ups_test_01;
CALL ups_test_01('0008','0007',1,4.6);