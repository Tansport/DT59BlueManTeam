#--------------------------------------------------------------
CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT,
	saDate DATETIME
)

INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');

SELECT 
  `empid`,
  `proid`,
  SUM(
    CASE
      MONTH(`saDate`) 
      WHEN '9' 
      THEN num 
      ELSE 0 
    END
  ) 九月,
  SUM(
    CASE
      MONTH(`saDate`) 
      WHEN '10' 
      THEN num 
      ELSE 0 
    END
  ) 十月,
  SUM(
    CASE
      MONTH(`saDate`) 
      WHEN '11' 
      THEN num 
      ELSE 0 
    END
  ) 十一月,
  SUM(
    CASE
      MONTH(`saDate`) 
      WHEN '12' 
      THEN num 
      ELSE 0 
    END
  ) 十二月 
FROM
  `sales` 
GROUP BY `empid`,
  `proid` ;


#------------------------------------------------------------------------
#创建储存过程

CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)

INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');


SELECT 
  A,
  SUM(B) AS 成绩,
  D 
FROM
  (SELECT 
    `A`,
    `B`,
    `D` 
  FROM
    `abc` 
  WHERE c = '正' 
  UNION
  SELECT 
    `A`,
    - B,
    `D` 
  FROM
    `abc` 
  WHERE c = '负') temp 
GROUP BY temp.A 
ORDER BY 和 DESC 

#--------------------------------------------------------------------------

DELIMITER ;;

CREATE PROCEDURE ups_test_00 (IN str VARCHAR (200)) 
BEGIN
  INSERT INTO penalty 
  VALUES
    (
      (SELECT 
        rid 
      FROM
        reader 
      WHERE rname = str),
      (SELECT 
        bid 
      FROM
        book 
      WHERE bname = '西游记'),
      NOW(),
      1,
      4.6
    ) ;
  UPDATE 
    borrow 
  SET
    returndate = NOW() 
  WHERE rid = 
    (SELECT 
      rid 
    FROM
      reader 
    WHERE rname = str) ;
  UPDATE 
    reader 
  SET
    lennum = lennum - 1 
  WHERE rname = str ;
  UPDATE 
    book 
  SET
    bcount = bcount + 1 
  WHERE bname = '西游记' ;
END ;;
DELIMITER ;

CALL ups_test_00('刘冰冰');


#-----------------------------------------------------------------
#列出所有试题信息 请用存储过程封装select * from 表名; 返回给java一个结果集按,题干模糊查询，用存储过程传递一个参数：题干返回给java一个结果集
DELIMITER ;;
CREATE PROCEDURE ups_test_00)
BEGIN
	SELECT * FROM `question_info`;
END
;;
DELIMITER ;

DROP PROCEDURE ups_test_00;


DELIMITER ;;

#---------------------------------------------------------------------

CREATE PROCEDURE ups_test_01 (IN str VARCHAR (10)) 
BEGIN
  
  SELECT 
    * 
  FROM
    `question_info` 
  WHERE `question` LIKE CONCAT('%', str, '%') ;
  
END ;;


DELIMITER ;

CALL ups_test_01('a');

CALL ups_test_00;


#--------------------------------------------------------------------------
