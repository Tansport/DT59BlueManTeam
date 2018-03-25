#'张无忌‘办理借阅<红楼梦>手续;
s_in_library |
+-------------------+
| book              |
| borrow            |
| penalty           |
| reader            |
| vw_manager_01     |
+-------------------+

insert into reader(rid,rname,lennum) values (9,'张无忌',0);
insert into borrow(rid,nif,lenddate,returndate) values (9,'0006',now(),'2018-7-30 10:10:10');
UPDATE book SET bcount=bcount-1
WHERE bid=0006;
UPDATE reader SET lennum=lennum+1
WHERE rid=9;
 COMMIT;

#5

CREATE VIEW view_borrow
          AS
                  SELECT b.bname AS 图书名称,br.willdate AS 到期日期,r.rname A    S 读者姓名
                  FROM reader r
                  INNER JOIN borrow br ON br.rid=r.rid
                  INNER JOIN book b ON b.bid=br.nif
                  WHERE  r.rid IN(SELECT rid FROM borrow br WHERE br.willdate<    NOW()AND br.returndate IS NULL)
  
  CREATE VIEW view_book
          AS
                  SELECT  b.bname AS 图书名称,b.bcount AS 馆存量,b.bcount-COUN    T(br.nif) AS 可借阅数量
                  FROM book b
                  INNER JOIN borrow br ON br.nif=b.bid
 
                 GROUP BY br.nif
  
  
 CREATE INDEX index_book_bname
 iN book(bname)

