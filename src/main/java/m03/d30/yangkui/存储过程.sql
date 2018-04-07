SELECT * FROM sales;

SELECT `empid` `No`,`proid` `No2`,
	SUM(CASE MONTH(`saDate`) WHEN '9' THEN num ELSE 0 END) 九月,
	SUM(CASE MONTH(`saDate`) WHEN '10' THEN num ELSE 0 END) 十月,
	SUM(CASE MONTH(`saDate`) WHEN '11' THEN num ELSE 0 END) 十一月,
	SUM(CASE MONTH(`saDate`) WHEN '12' THEN num ELSE 0 END) 十二月
FROM `sales`
GROUP BY `empid`,`proid`;


CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班')
INSERT INTO ABC VALUES('李大',20,'正','一班')
INSERT INTO ABC VALUES('张五',15,'负','一班')
INSERT INTO ABC VALUES('赵三',40,'负','二班')
INSERT INTO ABC VALUES('王小',5 ,'负','二班')

SELECT  a,SUM(b),d FROM (
SELECT a,b,d FROM abc WHERE c='正'
UNION
SELECT a,-b,d FROM abc WHERE c='负'
)temp
GROUP BY a


#2 李冰冰 数据存储过程

DELIMITER ;;
CREATE PROCEDURE ups_test_02(IN str VARCHAR(200))
BEGIN
	INSERT INTO penalty VALUES((SELECT rid FROM reader WHERE rname=str),
	(SELECT bid FROM book WHERE bname='西游记'),NOW(),1,4.6);
	UPDATE borrow SET returndate=NOW() WHERE rid=(SELECT rid FROM reader WHERE rname=str);
	UPDATE reader SET lennum=lennum-1 WHERE rname=str;
	UPDATE book SET bcount=bcount+1 WHERE bname='西游记';
END
;;
DELIMITER ;

#call存储过程
CALL ups_test_02('刘冰冰');

SELECT * FROM reader;

SELECT * FROM book;

SELECT * FROM borrow;

#存储过程模糊查询

DELIMITER ;;
CREATE PROCEDURE ups_test_01()
BEGIN
	SELECT * FROM `question_info`;
END
;;
DELIMITER ;

CALL ups_test_01;

DELIMITER ;;
CREATE PROCEDURE ups_test_02(IN str VARCHAR(10))
BEGIN
	#DECLARE Tempsql VARCHAR(200);#定义的变量
	SELECT * FROM `question_info` WHERE `question` LIKE  CONCAT('%',str,'%');
	#SELECT Tempsql;
END
;;
DELIMITER ;

CALL ups_test_02('a');


