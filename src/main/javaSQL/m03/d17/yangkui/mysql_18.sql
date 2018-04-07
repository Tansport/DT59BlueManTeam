#没有被读者借阅的图书信息
SELECT 
  bname AS 图书名称,
  bid AS 图书编号,
  author AS 作者姓名,
  pubcomp AS 出本社,
  price AS 单价 
FROM
  book b 
WHERE b.bid NOT IN 
  (SELECT DISTINCT 
    nif 
  FROM
    borrow) ;

#今年的所有缴纳罚款读者清单
SELECT 
  r.rname AS 读者姓名,
  b.bname AS 图书名称,
  p.pdate AS 罚款日期,
  p.amount AS 缴纳金额 
FROM
  reader r,
  book b,
  penalty p 
WHERE r.rid = p.`rid` 
  AND b.bid = p.`bid` 
  AND p.`pdate` IN 
  (SELECT 
    pdate 
  FROM
    penalty 
  WHERE YEAR(pdate) = 2018) ;



#地址为空的所有读者信息
SELECT 
  r.`rid` AS 读者编号,
  r.`rname` AS 读者姓名,
  b1.`bname` AS 图书名称,
  b2.lenddate AS 借书日期,
  b2.willdate AS 应归还日期 
FROM
  reader r,
  book b1,
  borrow b2 
WHERE r.`rid` = b2.`rid` 
  AND b1.`bid` = b2.`nif` 
  AND r.`rid` IN 
  (SELECT 
    rid 
  FROM
    reader 
  WHERE raddress IS NULL) 
  AND r.`rid` IN 
  (SELECT 
    rid 
  FROM
    borrow 
  WHERE returndate IS NULL) 
ORDER BY r.`rid` DESC,
  lenddate ASC ;
