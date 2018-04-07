SELECT 
  r.rid,
  r.rname 
FROM
  reader r 
WHERE NOT EXISTS 
  (SELECT 
    * 
  FROM
    borrow 
  WHERE r.rid = rid)
  
#到今天为止应还书但还未还书的读者姓名、所借书的书名、应归还日期
  SELECT 
    (SELECT 
      rname 
    FROM
      reader 
    WHERE temp.`rid` = rid) AS 读者姓名,
    (SELECT 
      bname 
    FROM
      book 
    WHERE temp.`nif` = bid) AS 图书名称,
    temp.willdate 
  FROM
    (SELECT 
      b.`rid`,
      b.`nif`,
      b.`willdate`,
      b.`returndate` 
    FROM
      borrow b 
    WHERE (DATEDIFF(NOW(), willdate)) > 0 
      AND b.`returndate` IS NULL) temp ;

#查询各种图书未借出的本数，显示查询书名和本数
SELECT 
  * 
FROM
  (SELECT 
    a.`bname` AS 图书书名,
    a.`bcount` - COUNT(b.`nif`) AS 未借出的本数 
  FROM
    book a 
    LEFT OUTER JOIN borrow b 
      ON a.`bid` = b.`nif` 
  GROUP BY b.`nif`) temp ;

#从已完成借阅的记录（即图书归还日期不为空）中，统计每位读者的借书次数，显示读者姓名和借书次数。
SELECT 
  COUNT(*) AS 借书次数,
  r.`rname` AS 读者姓名 
FROM
  borrow b 
  RIGHT JOIN reader r 
    ON r.`rid` = b.`rid` 
WHERE b.`returndate` IS NOT NULL 
GROUP BY b.`rid` ;

#查询总罚款金额大于5元的读者姓名和总罚款金额
SELECT 
  r.`rname` AS 读者姓名,
  SUM(amount) AS 总罚款金额 
FROM
  penalty p 
  RIGHT JOIN reader r 
    ON r.`rid` = p.`rid` 
GROUP BY p.`rid` 
HAVING 总罚款金额 > 5 ;

#统计已完成借阅的记录（即图书归还日期不为空）中每本书的借阅次数，显示借阅次数排名在前5位的图书名称和借阅次数
SELECT 
  b.`bname` AS 图书名称,
  COUNT(*) AS 借阅次数 
FROM
  book b 
  LEFT JOIN borrow bor 
    ON b.`bid` = bor.`nif` 
WHERE bor.`returndate` IS NOT NULL 
GROUP BY b.`bid`
ORDER BY 借阅次数 DESC 
LIMIT 5 ;

