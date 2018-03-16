CREATE DATABASE Library;

USE Library;

CREATE TABLE book(
	bid VARCHAR(20) PRIMARY KEY COMMENT '图书标号',
	bName VARCHAR(20) NOT NULL COMMENT '图书书名',
	author VARCHAR(20) COMMENT '作者姓名',
	pubComp VARCHAR(20) COMMENT '出版社',
	pubDate DATE COMMENT '出版日期',
	bCount INT COMMENT '现存量',
	price FLOAT COMMENT '单价'
);

CREATE TABLE reader(
	rid VARCHAR(20) PRIMARY KEY COMMENT '读者标号',
	rName VARCHAR(20) NOT NULL COMMENT '读者姓名',
	lendNum INT COMMENT '已借书数量',
	rAddress VARCHAR(20) COMMENT '联系地址'
);

CREATE TABLE borrow(
	rid VARCHAR(20) COMMENT '读者编号',
	nif VARCHAR(20) COMMENT '图书编号',
	lendDate TIMESTAMP COMMENT '借阅日期',
	willDate DATE COMMENT '应归还日期',
	returnDate DATE COMMENT '实际归还日期',
        CONSTRAINT borrow_pk PRIMARY KEY(rid,nif,lendDate)
);

CREATE TABLE penalty(
	rid VARCHAR(20) COMMENT '读者标号',
	bid VARCHAR(20) COMMENT '图书标号',
	pDate DATE COMMENT '罚款日期',
	pType ENUM('1','2','3') DEFAULT 1 COMMENT '罚款类型 1-延期 2-损坏 3-丢失',
	amount FLOAT COMMENT '付款金额'
);

DROP TABLE penalty;

INSERT INTO penalty VALUES('1','2','3',4,20.00);

SELECT * FROM penalty;

SELECT * FROM borrow;

SELECT * FROM book;

SELECT * FROM reader;

INSERT INTO reader VALUES('1','刘文1',2,'地址1');
INSERT INTO reader VALUES('2','刘文2',2,'地址2');
INSERT INTO reader VALUES('3','刘文3',2,'地址1');
INSERT INTO reader VALUES('4','刘文4',2,'地址2');
INSERT INTO reader VALUES('5','刘文5',2,'地址3');
INSERT INTO reader VALUES('6','刘文6',2,'地址5');
INSERT INTO reader VALUES('7','刘文7',2,'地址4');
INSERT INTO reader VALUES('8','刘文8',2,'地址8');
INSERT INTO reader VALUES('9','刘文9',2,'地址9');
INSERT INTO reader VALUES('10','刘文10',2,'地址10');

DELETE FROM reader WHERE rid='10';

#分页实现公式
#limit (当前页码-1)*每页条数，每页条数
SELECT * FROM reader LIMIT (SELECT (2-1)*3),3;#这句话实现不了？不知道为什么？

#显示1~3条数据
SELECT * FROM reader LIMIT 0,3;

#显示4~6条数据
SELECT * FROM reader LIMIT 3,3;

#显示6~9条数据
SELECT * FROM reader LIMIT 6,3;
  
#select (2-1)*3;