SELECT * FROM hos_district;

SELECT * FROM hos_house;

SELECT * FROM hos_street;

SELECT * FROM hos_type;

SELECT * FROM sys_user;
#1
SELECT ht.HTName AS 户型,su.UName AS 姓名,hd.DName AS 街道,hs.SName AS 区县
FROM hos_district hd
INNER JOIN hos_street hs ON hs.`SDID`=hd.`DID`
INNER JOIN hos_house hh ON hh.SID=hs.`SID`
INNER JOIN hos_type ht ON ht.HTID=hh.HTID
INNER JOIN sys_user su ON su.UID=hh.UID
WHERE hd.`DID` IN(
	SELECT hd.`DID` FROM hos_house hh
		INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
		INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
		GROUP BY hd.`DID` HAVING COUNT(*)>1
)


#2
SELECT  '季度','区县','街道','户型','数量'
FROM hos_house hh WHERE 1=2
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,'合计','','',COUNT(hh.HMID) AS 数量 FROM hos_house hh WHERE QUARTER(hh.`HTIME`)=1
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="朝阳区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="朝阳区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="海淀区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="海淀区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="西城区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=1 AND hd.`DName`="西城区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,'合计','','',COUNT(hh.HMID) AS 数量 FROM hos_house hh WHERE QUARTER(hh.`HTIME`)=2
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="东城区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="东城区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="海淀区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="海淀区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="西城区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=2 AND hd.`DName`="西城区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,'合计','','',COUNT(hh.HMID) AS 数量 FROM hos_house hh WHERE QUARTER(hh.`HTIME`)=3
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh 
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=3 AND hd.`DName`="东城区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=3 AND hd.`DName`="东城区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
UNION
SELECT QUARTER(hh.`HTIME`)AS 季度,hd.DName AS 区县,'小计','',COUNT(hh.HMID) AS 数量 FROM hos_house hh
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
WHERE QUARTER(hh.`HTIME`)=3 AND hd.`DName`="海淀区"
UNION
SELECT  QUARTER(hh.`HTIME`) AS 季度,hd.DName AS 区县,hs.`SName`AS 街道,ht.`HTName`AS 户型,COUNT(hh.HMID) AS 数量
FROM hos_house hh
INNER JOIN sys_user su ON hh.`UID`=su.`UID`
INNER JOIN hos_street hs ON hh.`SID`=hs.`SID`
INNER JOIN hos_district hd ON hs.`SDID`=hd.`DID`
INNER JOIN hos_type ht ON hh.`HTID`=ht.`HTID` 
WHERE QUARTER(hh.`HTIME`)=3 AND hd.`DName`="海淀区"
GROUP BY hd.`DName`,hs.`SName`,ht.`HTName`,QUARTER(hh.`HTIME`)
