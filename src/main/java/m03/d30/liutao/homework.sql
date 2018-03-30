DROP TABLE sales;
CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT,
	saDate DATETIME
);
INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');
SELECT * FROM sales;

DROP TABLE abc;
CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
);
INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');
SELECT * FROM abc;



#第一题
SELECT empid AS `No`,proid AS No2,
SUM(CASE WHEN MONTH(saDate)=9 THEN num ELSE num=0 END) AS 九月,
SUM(CASE WHEN MONTH(saDate)=10 THEN num ELSE num=0 END) AS 十月,
SUM(CASE WHEN MONTH(saDate)=10 THEN num ELSE num=0 END) AS 十一月,
SUM(CASE WHEN MONTH (saDate)=10 THEN num ELSE num=0 END) AS 十二月
  FROM sales s GROUP BY proid ORDER BY empid ASC;
  
  
#第二题
SELECT a,
SUM( CASE WHEN c='正' THEN b ELSE -b END) AS b,d
 FROM abc GROUP BY  a ORDER BY c ASC,a ASC;
 
#第三题
DELIMITER ;;
	CREATE PROCEDURE ups_bing_001()
BEGIN
INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES('0008','0007','2018-3-30 17:50:50','1','4.6');
UPDATE borrow SET returndate=NOW() WHERE rid='0008';
UPDATE borrow SET lennum=lennum-1 WHERE rname='刘冰冰';
UPDATE book SET bcount=bcount+1 WHERE bname='西游记';
END
;;
DELIMITER ;
CALL ups_bing_001;

#使用存储过程查询所有
DELIMITER ;;
	CREATE PROCEDURE ups_question()
BEGIN
	SELECT * FROM question_Info;
END
;;	
	
DELIMITER ;

#使用存储过程模糊查询
DELIMITER ;;
	CREATE PROCEDURE ups_questionLike(IN str VARCHAR(300))
BEGIN
	SELECT * FROM question_info WHERE question LIKE CONCAT('%',str,'%'); 
END
;;
DELIMITER ;

