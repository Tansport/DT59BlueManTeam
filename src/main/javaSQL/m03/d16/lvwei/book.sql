
SELECT 
  * 
FROM
reader;

DROP TABLE book ;

CREATE TABLE book (
  bid VARCHAR (20) PRIMARY KEY COMMENT '图书编号',
  bName VARCHAR (20) NOT NULL COMMENT '图书书名',
  author VARCHAR (20) COMMENT '作者姓名',
  pubComp VARCHAR (20) COMMENT '出版社',
  bCount INT COMMENT '现存数量',
  price FLOAT COMMENT '单价'
) ;

CREATE TABLE reader (
  rid VARCHAR (20)  PRIMARY KEY COMMENT '读者编号',
  rName VARCHAR (20) NOT NULL COMMENT '读者姓名',
  lendNum INT COMMENT '已借书数量',
  rAddress VARCHAR (20) COMMENT '联系地址'
);
CREATE TABLE borrow (
  rid VARCHAR (20) COMMENT '读者编号',
  nif VARCHAR (20) COMMENT '图书编号',
  lendDate TIMESTAMP COMMENT '借阅日期',
  willDate DATE COMMENT '应归还日期',
  returnDate DATE COMMENT '实际归还日期',
  PRIMARY KEY (rid, nif, lendDate)
);
CREATE TABLE penalty (
  rid VARCHAR (20) COMMENT '读者编号',
  bid VARCHAR (20) COMMENT '图书编号',
  pDate DATE COMMENT '罚款日期',
  pType INT COMMENT '罚款类型，1——延期，2——损坏，3——丢失',
  amount FLOAT COMMENT '罚款金额',
  PRIMARY KEY (rid, bid, PDate)
);