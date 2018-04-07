SELECT * FROM student ;
   
 SELECT studentNO,studentName,phome,address,bornDate
 FROM `student`
 WHERE gradeId=1
 ORDER BY studentNo
 LIMIT 3;
 
 DROP TABLE student ;

CREATE TABLE student (
  gradeId INT COMMENT '年纪编号',
  studentNO INT PRIMARY KEY COMMENT '学生编号',
  studentName VARCHAR (200) COMMENT '学生姓名',
  phome VARCHAR(200) COMMENT '电话号码',
  address VARCHAR (200) COMMENT '学生地址',
  bornDate DATETIME COMMENT '入学时间'
)

INSERT INTO student 
VALUES
  (
    1,
    10000,
    '郭靖',
    13645667783,
    '雷霆崖',
   '2002-12-02 00:00:00') ;

INSERT INTO student 
VALUES
  (
    1,
    10001,
    '小龙女',
    13645661234,
    '古墓派',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10002,
    '杨过',
    13645665432,
    '暴风城',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10003,
    '东方不败',
    13645661235,
    '奥格瑞玛',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10004,
    '鳌拜',
    13645666523,
    '幽暗城',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10005,
    '鲁智深',
    13645667532,
    '诺森德',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10006,
    '宋江',
    13645664567,
    '梁山',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10007,
    '小明',
    13645668749,
    '铁炉堡',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10008,
    '小红',
    13645664825,
    '达拉然',
   '2002-12-02 00:00:00') ;
   
   INSERT INTO student 
VALUES
  (
    1,
    10009,
    '明明',
    13645669437,
    '破碎虚空',
   '2002-12-02 00:00:00') ;
