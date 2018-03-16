CREATE DATABASE library;

USE library;

CREATE TABLE book(
	bid  VARCHAR(20) PRIMARY KEY COMMENT '图书编号',
	bName  VARCHAR(20) NOT NULL COMMENT '图书书名',
	author VARCHAR(8) COMMENT '作者姓名',
	pubComp VARCHAR(10) COMMENT '出版社',
	pubDate DATE COMMENT '出版日期',
	bCount  INT COMMENT '现存数量',
	price FLOAT COMMENT '单价'
)
CREATE TABLE reader(
	rid VARCHAR(20) PRIMARY KEY COMMENT'读者编号',
	rName VARCHAR(20) NOT NULL COMMENT'读者姓名',
	lengNum INT COMMENT'已借书数量',
	rAddress VARCHAR(20) COMMENT'联系地址'
)
SELECT * FROM reader;

INSERT INTO reader VALUES('01','杨奎',1,'武汉');
INSERT INTO reader VALUES('02','杨奎',1,'武汉');
INSERT INTO reader VALUES('03','杨奎',1,'武汉');
INSERT INTO reader VALUES('04','杨奎',1,'武汉');
INSERT INTO reader VALUES('05','杨奎',1,'武汉');
INSERT INTO reader VALUES('06','杨奎',1,'武汉');
INSERT INTO reader VALUES('07','杨奎',1,'武汉');
INSERT INTO reader VALUES('08','杨奎',1,'武汉');
INSERT INTO reader VALUES('09','杨奎',1,'武汉');
INSERT INTO reader VALUES('10','杨奎',1,'武汉');

#删除表单数据
#delete from reader where rid=1
SELECT * FROM reader LIMIT(1-1)*3,3;
SELECT * FROM reader LIMIT 0,3;
SELECT * FROM reader LIMIT 3,3;
SELECT * FROM reader LIMIT 6,3;
SELECT * FROM reader LIMIT 9,3;



CREATE TABLE borrow(
	rid VARCHAR(20) COMMENT'读者编号',
	nif VARCHAR(20) COMMENT'图书编号',
	lendDate TIMESTAMP COMMENT'借阅日期',
	willDate DATE COMMENT'应归还日期',
	returnDate DATE COMMENT'实际归还日期',
	CONSTRAINT borrow_pk PRIMARY KEY(rid,nif,lendDate)
)
#删除表
#drop table borrow

CREATE TABLE penalty(
	rid VARCHAR(20) COMMENT'读者编号',
	bid VARCHAR(20) COMMENT'图书编号',
	pDate DATE COMMENT'罚款日期',
	pType INT COMMENT'罚款类型，1--延期，2--损坏，3--丢失',
	amount FLOAT COMMENT'罚款金额',
	CONSTRAINT penalty_pk PRIMARY KEY(rid,bid,pDate)
)


SELECT * FROM book;



SELECT * FROM borrow;

SELECT * FROM penalty;