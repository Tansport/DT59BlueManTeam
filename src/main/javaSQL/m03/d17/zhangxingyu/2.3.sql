SELECT 
  * 
FROM
  `book` ;


SELECT 
  * 
FROM
  `penalty` ;


SELECT 
  * 
FROM
  borrow ;


SELECT 
  * 
FROM
  reader ;


SELECT 
  * 
FROM
  book 
WHERE bid NOT IN 
  (SELECT 
    nif 
  FROM
    borrow 
  WHERE returndate IS NULL) ;

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
  AND p.`bid` IN 
  (SELECT 
    bid 
  FROM
    penalty 
  WHERE pdate IN 
    (SELECT 
      pdate 
    FROM
      penalty 
    WHERE YEAR(pdate) > 2017))


SELECT 
  r.`rid` AS 读者编号,
  r.`rname` AS 读者姓名,
  b.`bname` AS 图书书名,
  br.lenddate AS 借阅日期,
  br.willdate AS 应还日期 
FROM
  reader r,
  book b,
  borrow br 
WHERE r.`rid` = br.rid 
  AND b.`bid` = br.nif 
  AND r.`rid` IN 
  (SELECT 
    rid 
  FROM
    reader 
  WHERE raddress IS NULL) 
  AND br.rid IN 
  (SELECT 
    rid 
  FROM
    borrow 
  WHERE returndate IS NULL) 
ORDER BY r.`rid` DESC 
