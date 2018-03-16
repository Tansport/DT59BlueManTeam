/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` varchar(20) NOT NULL COMMENT '图书编号',
  `bName` varchar(20) NOT NULL COMMENT '图书书名',
  `author` varchar(20) DEFAULT NULL COMMENT '作者姓名',
  `pubcomp` varchar(20) DEFAULT NULL COMMENT '出版社',
  `pubDate` date DEFAULT NULL COMMENT '出版日期',
  `bCount` int(11) DEFAULT NULL COMMENT '现存数量',
  `price` double DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bid`,`bName`,`author`,`pubcomp`,`pubDate`,`bCount`,`price`) values ('001','时间简史','斯蒂芬.霍金','人民出版社','1988-09-09',1000,100);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `rid` varchar(20) NOT NULL COMMENT '读者编号',
  `nif` varchar(20) NOT NULL COMMENT '图书编号',
  `lendDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '借书日期',
  `willDate` date DEFAULT NULL COMMENT '应归还日期',
  `returnDate` date DEFAULT NULL COMMENT '实际归还日期',
  PRIMARY KEY (`rid`,`nif`,`lendDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`rid`,`nif`,`lendDate`,`willDate`,`returnDate`) values ('11','b08','2018-03-16 00:00:00','2018-04-16','2018-03-16');

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `rid` varchar(20) NOT NULL COMMENT '读者编号',
  `bid` varchar(20) NOT NULL COMMENT '图书编号',
  `pDate` date NOT NULL COMMENT '罚款日期',
  `ptype` int(11) DEFAULT NULL COMMENT '罚款类型',
  `amonunt` float DEFAULT NULL COMMENT '罚款金额',
  PRIMARY KEY (`rid`,`bid`,`pDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

insert  into `penalty`(`rid`,`bid`,`pDate`,`ptype`,`amonunt`) values ('01','10','2018-03-16',11,10),('11','20','2018-03-16',10,20);

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `rid` varchar(20) NOT NULL COMMENT '读者编号',
  `rName` varchar(20) NOT NULL COMMENT '读者姓名',
  `lendNum` int(11) DEFAULT NULL COMMENT '已借书数量',
  `rAddress` varchar(20) DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`rid`,`rName`,`lendNum`,`rAddress`) values ('1000','刘涛',100,'武汉市'),('11','lt',12,'武汉市江汉区');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentNo` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(100) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`studentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentNo`,`studentName`,`phone`,`address`) values (1,'李文才1',133,'武汉市1'),(2,'李文才2',1363,'武汉市2'),(3,'李文才3',13643,'武汉市3'),(4,'李文才4',136713,'武汉市4'),(5,'李文才5',13723,'武汉市5'),(6,'李文才6',1367733,'武汉市6'),(7,'李文才7',13667743,'武汉市7'),(8,'李文才8',1367753,'武汉市8'),(9,'李文才9',1364763,'武汉市9'),(10,'李文才0',1364773,'武汉市10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
