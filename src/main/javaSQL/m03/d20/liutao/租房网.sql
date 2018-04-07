USE house;
SELECT * FROM hos_district;
SELECT * FROM  hos_house;
SELECT * FROM  hos_street;
SELECT * FROM  hos_type;
SELECT * FROM  sys_user;
#查询第六条到第十条出租房屋信息
SELECT * FROM hos_house LIMIT 5,5;

#查询张三发布的所有租房信息，并显示房屋布局的街道和区县；
SELECT 
(SELECT sname FROM hos_street WHERE a.`SID`=sid) AS 街道,
(SELECT dname FROM hos_district WHERE did IN(
	SELECT sdid FROM hos_street WHERE a.`SID`=sid
)) AS 区县,
a.`price`,a.`TOPIC`,a.htid,a.contents,a.htime,a.copy
 FROM hos_house a
WHERE a.`UID` =(
	SELECT uid FROM sys_user WHERE uname='张三'
)

#根据户型和房屋所在区县和街道，为至少有两个街道有出租房屋的区县制作出房屋清单；
SELECT 
(SELECT htname FROM hos_type WHERE htid=a.htid) AS 户型,
(SELECT uname FROM sys_user  WHERE uid=a.uid) AS 姓名,
(SELECT dname FROM hos_district d WHERE d.did IN
(SELECT sdid FROM hos_street WHERE sid=a.sid)) AS 区县,
(SELECT sname FROM hos_street WHERE sid=a.sid) AS 街道
FROM hos_house a 
WHERE a.`SID` IN 
(SELECT sid FROM hos_street WHERE sdid IN 
			(SELECT sdid FROM hos_street s,(SELECT DISTINCT(sid) FROM hos_house) AS temp
			WHERE s.`SID` = temp.sid
			GROUP BY sdid
			HAVING COUNT(s.sid)>1
			) 
) ORDER BY 户型 ;
		
 
#按季度统计出本年各街道各种户型房屋出租数量；
#要求输出2016年从1月1日起至今的全部出租房数量、各区县出租房数量及各街道、户型出租房屋数量；

#不会做

