/*
SQLyog Ultimate - MySQL GUI v8.22 
MySQL - 5.1.54-community : Database - studentregistration
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentregistration` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `studentregistration`;

/*Table structure for table `tblstudents` */

DROP TABLE IF EXISTS `tblstudents`;

CREATE TABLE `tblstudents` (
  `StudID` smallint(6) NOT NULL AUTO_INCREMENT,
  `LName` varchar(50) DEFAULT NULL,
  `FNmae` varchar(50) DEFAULT NULL,
  `MName` varchar(50) DEFAULT NULL,
  `Gender` varchar(15) DEFAULT NULL,
  `Address` varchar(75) DEFAULT NULL,
  `ContactNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`StudID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `tblstudents` */

insert  into `tblstudents`(`StudID`,`LName`,`FNmae`,`MName`,`Gender`,`Address`,`ContactNo`) values (19,'MIRAMON','RAUL','GWAPO','MALE','KORONADAL CITY','0935252525'),(22,'LEYSA','KEVIN','GWAPO','MALE','TBOLI','092672634824'),(23,'MANIBOG','JOCELYN','GWAPA','FEMALE','EDWARDS','092343235235'),(24,'MIRAMON','JOANNE','GWAPA','FEMALE','BRGY. BALDOSTAMON KORONADAL CITY SO. COT.','092345235325'),(25,'FACINAL','JEWIL','GWAPO','MALE','NORALA','0982345235'),(26,'LEYSA','FERDINAND','GWAPA','MALE','KORONADAL CITY','0926378525'),(27,'ARISTOTELES','APRIL','BB KO','FEMALE','SURALLAH SO. COT','09124124124');

/*Table structure for table `tbluseraccount` */

DROP TABLE IF EXISTS `tbluseraccount`;

CREATE TABLE `tbluseraccount` (
  `UserID` smallint(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `UPassword` varchar(50) DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tbluseraccount` */

insert  into `tbluseraccount`(`UserID`,`Name`,`Username`,`UPassword`,`Role`) values (1,'KEVIN G LEYSA','q','Q','ADMINISTRATOR'),(3,'APRIL ARISTOTELES','april','april','USER'),(4,'Holy children','ba','bat','USER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
