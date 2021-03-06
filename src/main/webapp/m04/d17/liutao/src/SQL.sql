CREATE TABLE message 
(
	MID INT NOT NULL AUTO_INCREMENT,
	mtitle VARCHAR(40) NOT NULL, 
	mcontent VARCHAR(300) NOT NULL, 
	mname VARCHAR(20) NOT NULL,
	mdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	rcount INT DEFAULT 0,
  	PRIMARY KEY  (MID)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

INSERT INTO message(mtitle,mcontent,mname,mdate,rcount) VALUES('价格最低的MP4','价格最低的MP4是什么牌子？价格是多少？' , 'zzg' , '2007-10-04' , 1 );

INSERT INTO message(mtitle,mcontent,mname,mdate,rcount) VALUES('品红服务宗旨是什么' , '品红服务宗旨是：为用户服务' , 'bobo' , '2007-10-08 13:41:50' , 0 );


/*

*/
SELECT * FROM news

CREATE TABLE news
 (
	nid INT NOT NULL AUTO_INCREMENT,  
	ntitle VARCHAR(30) NOT NULL, 
	ncontent VARCHAR(500) NOT NULL, 
 	ndate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 	PRIMARY KEY  (nid)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

INSERT INTO news( ntitle , ncontent , ndate ) VALUES('爱国者数码相机今日七折优惠' , '为了答谢广大用户，爱国者数码相机今日七折优惠。' , '2007-09-30' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('黄金周最热销手机汇总导购' , ' 在这个被看作是我国最大的消费高峰之一的七天长假中，那些准备买新手机的朋友们是不是已经买到了称心如意的手机呢？今天手机中国编辑就把从北京几大手机卖场了解到的这七天长假中几款最热卖的机型做个总结，相信这些机型也是大多数朋友认可和喜爱的，看看你的选择是不是和很多朋友一样，也为还没选好目标的朋友做个推荐' , '2007-10-01' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('时尚浪漫情侣手机配对推荐' , '　对于商家来说，十一以后的几天依然是畅销的好时候，各种优惠活动仍然在各大卖场如火如荼的进行。既然是优惠购物好时机，小编今天就为情侣们推荐了三对最登对情侣手机，甜蜜的你们一定能选购到适合他她的最登对手机。' , '2007-10-01' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('三星女性翻盖E428行货仅1180' , '以其独特的气质，深受女性消费者的喜爱。目前携节后余威，该机特价仅售：1180元，有兴趣的女性朋友可以多考虑一下。' , '2007-10-02' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('国庆期间降价最猛八款数码相机' , '三星S系列一直是抢占低端市场的主打产品，其低廉的价格，丰富的功能占据了一定的市场，这让一些国际大品牌都对S系列无措。现在降价促销其中一款机型S750，降幅高达200元，目前仅1180元的价格还送1GB SD卡。
' , '2007-10-03' );
INSERT INTO news(ntitle , ncontent , ndate ) VALUES('国庆各品牌最好卖的相机' , ' 七天的国庆长假弹指间便过去了，相信大家都和小编一样有一种意犹未尽的感觉。不知道大家有在国庆之后购买数码相机的打算没有，如果有的话，这篇文章就是为您而准备的。' , '2007-10-04' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('单反与镜头组合' , ' 尽管不少朋友都选择在过节期间消费一些奢侈的数码产品——比如我们今天的主角单反相机或者交换镜头，但相信还是有不少朋友会选择避开这个万众瞩目的消费热潮，毕竟黄金周往往是好卖的货早早卖空涨价，难卖的货堆积如山又常被JS当作欺负菜鸟的转型诱饵……因此今天，在黄金周即将结束之时，我们还是一起来看看节后重会“理性时代”的市场上有哪些单反机型和交换镜头值得我们关注吧：' , '2007-10-05' );
INSERT INTO NEWS (ntitle , ncontent , ndate ) VALUES('MP4关注度排行TOP10' , '　黄金周过后，很多行业都要盘点一下自己的销售业绩，虽然MP4现在还不属于大众消费品，但是也不能例外。十一期间购买MP4作为出游装备或者过节礼品的情况让这个市场也升温了不少，这也导致MP4关注排行的TOP 10名次有了不小变化。' , '2007-10-05' );
INSERT INTO NEWS (ntitle , ncontent , ndate  ) VALUES('理光R5不到二千' , '沈阳行情 凭借R系列的出众表现，理光在家用市场一直有着较高的知名度，随着R7的上市，老型R系列机型也面临退市的边缘，近日笔者了解到，较早上市的R5的售价已经突破二千大关，该机拥有七倍变焦镜头、CCD防抖以及28mm的广角等功能，卖点非常突出，近期打算购买数码相机的家庭不妨重点考虑一下这款产品。 ' , '2007-10-06' );
INSERT INTO news(ntitle , ncontent , ndate  ) VALUES('索尼W55降价送卡' , '说起索尼的W系列相机，相信大家都不会感到陌生，其不错的功能表现外加时尚前卫的外形设计，一度颇受消费者认可。今日，笔者从索尼专卖处获悉，其对W系低端机型W55推出1550元的促销价格，附送一张512M的记忆棒，颇为超值，感兴趣的读者可以关注一下。' , '2007-10-07' );


/*

*/
CREATE TABLE product 
(
	pid INT(11) NOT NULL AUTO_INCREMENT, 
	pname VARCHAR(20) NOT NULL, 
	pbrand VARCHAR(20) NOT NULL, 
	pmodel VARCHAR(20) NOT NULL,  
	pprice FLOAT NOT NULL,  
	ppicture VARCHAR(100) DEFAULT NULL, 
	pdes VARCHAR(100) DEFAULT NULL, 
  	PRIMARY KEY  (pid) 
) ENGINE=INNODB DEFAULT CHARSET=gbk;

 INSERT INTO product( pname , pbrand , pmodel , pprice , ppicture , pdes ) VALUES( '笔记本' , 'IBM' , 'g123' , 8000.00 , 'd_r11_10_r1_c1.jpg' , 'IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列IBM5x系列' );
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes) VALUES( '摄像机' , '三星' , '05' , 8000.00 , 'd_r11_10_r1_c8.jpg' , 'IBM5x系列');                         
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes) VALUES('数码相机' , '爱国者' , '08' , 8000.00 , 'd_r11_10_r1_c16.jpg' , '爱国者  a08');                 
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes ) VALUES('手机' , '摩托罗拉' , '60' , 8000.00 , 'd_r11_10_r1_c22.jpg' , '摩托罗拉 v60');
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes) VALUES(  '笔记本' , 'IBM' , '80' , 8000.00 , 'd_r11_10_r1_c2.jpg' , 'IBM5x系列' );
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes ) VALUES(  '摄像机' , '松下' , '100' , 8000.00 , 'd_r11_10_r1_c81.jpg' , '松下sx100' );
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes) VALUES('数码相机' , '柯达' , '200' , 8000.00 , 'd_r11_10_r1_c116.jpg' , ' 柯达k200' );
 INSERT INTO product(pname , pbrand , pmodel , pprice , ppicture , pdes ) VALUES( '索爱手机' , '索爱' , '1980' , 5000.00 , 'd_r11_10_r1_c221.jpg' , '索爱最近产品' );

/*

*/
CREATE TABLE revert 
(  
	rid INT(11) NOT NULL AUTO_INCREMENT,
	MID INT(11) NOT NULL REFERENCES message (MID),
	rcontent VARCHAR(400) NOT NULL,
	rname VARCHAR(20) NOT NULL,
  	rdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  	PRIMARY KEY  (rid)  
) ENGINE=INNODB DEFAULT CHARSET=gbk;

INSERT INTO revert(MID , rcontent , rname , rdate) VALUES( 1 , '价格最低的MP4是爱国者牌子的，价格是1200' , 'zzg' , '2007-10-05' );


/*

*/
CREATE TABLE USER 
(  
	uid INT(11) NOT NULL AUTO_INCREMENT,
	uname VARCHAR(20) UNIQUE NOT NULL,
	upwd VARCHAR(20) NOT NULL,
	ustatus CHAR(1) NOT NULL,
	upic VARCHAR(50),
 	PRIMARY KEY  (uid)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

INSERT INTO USER ( uName , upwd , ustatus ) VALUES ('chris' , 'chris' , 1 );
 INSERT INTO USER (uName , upwd , ustatus) VALUES ('zzg' , 'zzg' , 0 );
 INSERT INTO USER (uName , upwd , ustatus) VALUES ('bobo' , 'bobo' , 0 );
 INSERT INTO USER(uName , upwd , ustatus) VALUES ('balr' , 'balr' , 0 );


