SELECT * FROM student ;

DROP TABLE student ;

SELECT 
  studentNO,
  studentName,
  phone,
  address,
  bornDate 
FROM
  `student` 
WHERE gradeId = 1 
ORDER BY studentNo 
LIMIT 0,3 ;

SELECT 
  studentNO,
  studentName,
  phone,
  address,
  bornDate 
FROM
  `student` 
WHERE gradeId = 1 
ORDER BY studentNo 
LIMIT 3, 3 ;

CREATE TABLE student (
  gradeId INT COMMENT '班级编号',
  studentNO INT PRIMARY KEY COMMENT '学生编号',
  studentName VARCHAR (200) COMMENT '学生姓名',
  phone VARCHAR (200) COMMENT '电话号码',
  address VARCHAR (200) COMMENT '学生地址',
  bornDate DATETIME COMMENT '入学时间'
);

INSERT INTO student 
VALUES
  (
    1,
    10000,
    '杨奎',
    12353278564,
    '杨家院',
    '2002-12-02 00:00:00'
  ) ;

  INSERT INTO student 
VALUES
  (
    1,
    10001,
    '刘文',
    12353278565,
    '六角亭',
    '2002-12-02 00:00:00'
  ) ;
  
    INSERT INTO student 
VALUES
  (
    1,
    10002,
    '张星宇',
    12353278566,
    '星辰变',
    '2002-12-02 00:00:00'
  ) ;
      INSERT INTO student 
VALUES
  (
    1,
    10003,
    '郑河样',
    12353278567,
    '黄河',
    '2002-12-02 00:00:00'
  ) ;
  INSERT INTO student 
VALUES
  (
    1,
    10004,
    '杨奎',
    12353278564,
    '杨家院',
    '2002-12-02 00:00:00'
  ) ;

  INSERT INTO student 
VALUES
  (
    1,
    10005,
    '刘文',
    12353278565,
    '六角亭',
    '2002-12-02 00:00:00'
  ) ;
  
    INSERT INTO student 
VALUES
  (
    1,
    10006,
    '张星宇',
    12353278566,
    '星辰变',
    '2002-12-02 00:00:00'
  ) ;
      INSERT INTO student 
VALUES
  (
    1,
    10007,
    '郑河样',
    12353278567,
    '黄河',
    '2002-12-02 00:00:00'
  ) ;
