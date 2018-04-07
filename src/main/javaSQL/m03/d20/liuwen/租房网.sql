#方法一，使用select子查询 from子查询实现
SELECT
(SELECT htname FROM hos_type WHERE a.htid = htid) AS 户型,
(SELECT uname FROM sys_user WHERE a.uid = uid) AS 姓名,
(SELECT dname FROM hos_district WHERE did IN     
	(SELECT sdid FROM hos_street WHERE a.`SID` = sid)) AS 区县,
(SELECT sname FROM hos_street WHERE a.`SID` = sid) AS 街道
FROM hos_house a
	WHERE a.sid IN
		(SELECT sid FROM hos_street WHERE sdid IN 
			(SELECT sdid FROM hos_street street,(SELECT DISTINCT(sid) FROM hos_house) AS temp
			WHERE street.sid = temp.sid
			GROUP BY sdid
			HAVING COUNT(street.sid)>1
			)
		);
		

#方法二，直接使用连接条件
SELECT t.`HTName` AS 户型, u.`UName` AS 姓名,d.`DName` AS 区县, s.`SName` 街道
FROM hos_type t,sys_user u,hos_district d ,hos_street s ,hos_house h
WHERE t.`HTID` = h.`HTID` AND u.`UID` = h.`UID` AND d.`DID` = s.`SDID` AND s.`SID` = h.`SID`
AND h.`SID` IN 
		(SELECT sid FROM hos_street WHERE sdid IN 
			(SELECT sdid FROM hos_street street,(SELECT DISTINCT(sid) FROM hos_house) AS temp
			WHERE street.sid = temp.sid
			GROUP BY sdid
			HAVING COUNT(street.sid)>1
			)
		);
