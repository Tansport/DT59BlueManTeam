USE library;
SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM reader;
SELECT * FROM penalty;
#首先再borrow表中查询被借过的所有书，然后再书里面查询没有被借过的书
SELECT * FROM book a WHERE a.`bid`  NOT IN(
SELECT nif FROM borrow b WHERE b.`nif`
);
#首先查到罚款的读者编号,再通过读者编号查询读者编号内的被罚款过的读者
SELECT * FROM reader r WHERE r.`rid` IN(
SELECT rid FROM penalty p WHERE YEAR(p.`pdate`)>2017
);
#先通过还书为空的找到编号，再通过地址为空的找到编号，最后通过查询排序完成查找
SELECT r.`rid`,r.`rname`,b.`bname`,c.`lenddate`,c.`willdate`FROM book b,borrow c,reader r WHERE r.`rid`=c.`rid` AND c.`nif`=b.`bid` AND r.`rid` IN(
SELECT rid FROM borrow WHERE returndate IS NULL )AND r.`rid` IN(
SELECT rid FROM reader WHERE raddress IS NULL )ORDER BY lenddate DESC;