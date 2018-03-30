#作业0
#第一题答案
SELECT `empid`AS `No`,`proid` AS No2,
	SUM(CASE MONTH(`saDate`) WHEN '9' THEN num ELSE 0 END) 九月,
	SUM(CASE MONTH(`saDate`) WHEN '10' THEN num ELSE 0 END) 十月,
	SUM(CASE MONTH(`saDate`) WHEN '11' THEN num ELSE 0 END) 十一月,
	SUM(CASE MONTH(`saDate`) WHEN '12' THEN num ELSE 0 END) 十二月
FROM `sales`
GROUP BY `empid`,`proid`;

#第二题答案
SELECT A,SUM(B) AS 和,D FROM
(SELECT `A`,`B`,`D`FROM `abc` WHERE c='正'
UNION
SELECT `A`,-B,`D` FROM `abc` WHERE c='负') temp
GROUP BY temp.A


#作业1
#创建储存过程
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



#作业2
#列出所有试题信息 请用存储过程封装select * from 表名; 返回给java一个结果集
DELIMITER ;;
CREATE PROCEDURE ups_test_01()
BEGIN
	SELECT * FROM `question_info`;
END
;;
DELIMITER ;

DROP PROCEDURE ups_test_01;

#按题干模糊查询，用存储过程传递一个参数：题干返回给java一个结果集
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

CALL ups_test_01;