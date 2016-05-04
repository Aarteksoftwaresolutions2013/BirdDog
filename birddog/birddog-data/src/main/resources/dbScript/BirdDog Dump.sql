/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.5.24 : Database - birddog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`birddog` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `birddog`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS1` varchar(500) NOT NULL,
  `ADDRESS2` varchar(500) DEFAULT NULL,
  `CITY_ID` int(11) NOT NULL,
  `ZIP_CODE` varchar(50) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `LATITUDE` varchar(50) DEFAULT NULL,
  `LONGITUDE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_address` (`CITY_ID`),
  CONSTRAINT `FK_address` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`ID`,`ADDRESS1`,`ADDRESS2`,`CITY_ID`,`ZIP_CODE`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`LATITUDE`,`LONGITUDE`) values (28,'sdf','sdfsd',1,'12345',0,'2016-03-25 17:55:01','2016-03-25 17:55:01',NULL,NULL),(43,'6025 Royal Ln',NULL,2,'75230',0,'2016-03-25 20:11:13','2016-03-25 20:11:13','32.8952283','-96.8027603'),(44,'ggfgd','sdgdfgdfgdfgg',3,'25453455',0,'2016-04-01 17:42:00','2016-04-01 17:42:00',NULL,NULL),(45,'International Pkwy, DFW Airport',NULL,2,'75261',0,'2016-04-01 17:44:40','2016-04-01 17:44:40','32.8978011','-97.0398010'),(46,'425 Bedford St',NULL,2,'75212',0,'2016-04-01 18:05:12','2016-04-01 18:05:12','32.7780644','-96.8307425'),(47,'fmc',NULL,1,'75230',0,'2016-04-04 16:18:19','2016-04-04 16:18:19','32.9005121','-96.7868794'),(48,'fsdfs',NULL,2,'2134234',0,'2016-04-04 18:00:53','2016-04-04 18:00:53',NULL,NULL);

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEAD_ID` int(11) NOT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `PATH` varchar(50) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_attachment` (`LEAD_ID`),
  CONSTRAINT `FK_attachment` FOREIGN KEY (`LEAD_ID`) REFERENCES `lead` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `attachment` */

insert  into `attachment`(`ID`,`LEAD_ID`,`TYPE`,`PATH`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`) values (2,12,NULL,'12_New Bitmap Image (3).bmp',1,'2016-03-25 17:57:31','2016-03-25 17:57:31');

/*Table structure for table `birddog` */

DROP TABLE IF EXISTS `birddog`;

CREATE TABLE `birddog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `CONTACT_NO` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `REI_ID` int(11) NOT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `IMAGE_NAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_birddog1` (`ADDRESS_ID`),
  KEY `FK_birddog` (`REI_ID`),
  CONSTRAINT `FK_birddog` FOREIGN KEY (`REI_ID`) REFERENCES `re_investor` (`ID`),
  CONSTRAINT `FK_birddog1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `birddog` */

insert  into `birddog`(`ID`,`NAME`,`CONTACT_NO`,`EMAIL`,`REI_ID`,`ADDRESS_ID`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`IMAGE_NAME`) values (4,'birddog','789456123','birddog@birddog.com',3,44,0,'2016-03-08 19:18:00','2016-03-08 19:18:00',NULL),(5,'birds','235435345','dog@gmial.com',3,NULL,1,'2016-03-11 14:59:03','2016-03-11 14:59:03',NULL);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(50) NOT NULL,
  `COUNTY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_city` (`COUNTY_ID`),
  CONSTRAINT `FK_city` FOREIGN KEY (`COUNTY_ID`) REFERENCES `county` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`ID`,`CITY_NAME`,`COUNTY_ID`) values (1,'Garland',5),(2,'Dallas',5),(3,'Richardson',5),(4,'Carrollton',5);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEAD_ID` int(11) NOT NULL,
  `COMMENT_TITLE` varchar(50) NOT NULL,
  `COMMENT_DETAILS` varchar(50) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_comment` (`LEAD_ID`),
  KEY `FK_comment1` (`ROLE_ID`),
  CONSTRAINT `FK_comment` FOREIGN KEY (`LEAD_ID`) REFERENCES `lead` (`ID`),
  CONSTRAINT `FK_comment1` FOREIGN KEY (`ROLE_ID`) REFERENCES `user_role` (`USER_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

/*Table structure for table `county` */

DROP TABLE IF EXISTS `county`;

CREATE TABLE `county` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COUNTY_NAME` varchar(50) NOT NULL,
  `STATE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_state` (`STATE_ID`),
  CONSTRAINT `FK_state` FOREIGN KEY (`STATE_ID`) REFERENCES `state` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `county` */

insert  into `county`(`ID`,`COUNTY_NAME`,`STATE_ID`) values (1,'Anderson County',43),(2,'Andrews County',43),(3,'Angelina County',43),(4,'Aransas County',43),(5,'Dallas County',43);

/*Table structure for table `lead` */

DROP TABLE IF EXISTS `lead`;

CREATE TABLE `lead` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BIRDDOG_ID` int(11) NOT NULL,
  `PROPERTY_TYPE` varchar(50) NOT NULL,
  `STATUS` varchar(50) NOT NULL,
  `ADDRESS_ID` int(11) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `OWNER_FIRST_NAME` varchar(55) DEFAULT NULL,
  `OWNER_LAST_NAME` varchar(55) DEFAULT NULL,
  `CONSTRUCTION_TYPE` varchar(55) DEFAULT NULL,
  `ROOF_CONSTRUCTION_TYPE` varchar(55) DEFAULT NULL,
  `SQ_FOOT_UNDER_AIR` varchar(50) DEFAULT NULL,
  `POOL` varchar(20) DEFAULT NULL,
  `SQ_FOOTAGE_UNDER_AIR` varchar(55) DEFAULT NULL,
  `BUILT_YEAR` varchar(20) DEFAULT NULL,
  `NO_BEDROOMS` varchar(20) DEFAULT NULL,
  `NO_BATHROOMS` varchar(20) DEFAULT NULL,
  `LAST_SALE_DATE` varchar(55) DEFAULT NULL,
  `LAST_SALES_PRICE` varchar(55) DEFAULT NULL,
  `PROPERTY_LEAD_TYPE` varchar(20) DEFAULT NULL,
  `OWNER_VERIFICATION` varchar(20) DEFAULT NULL,
  `SELLER_MOTIVATION` varchar(55) DEFAULT NULL,
  `PHYSICAL_PROPERTY_INDICATORS` varchar(55) DEFAULT NULL,
  `PERSONAL_INDICATORS` varchar(55) DEFAULT NULL,
  `DRIVE_BY_DATE` varchar(55) DEFAULT NULL,
  `VERIFY_OCCUPANCY` varchar(55) DEFAULT NULL,
  `NOTLISTED_WITH_REALTOR` varchar(10) DEFAULT NULL,
  `NOTLISTED_ANY_TYPE_AUCTIONS` varchar(10) DEFAULT NULL,
  `VIRIFY_PROPERTY_OWNER_ISPERSON` varchar(10) DEFAULT NULL,
  `APPROVAL` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lead` (`BIRDDOG_ID`),
  KEY `FK_lead1` (`ADDRESS_ID`),
  CONSTRAINT `FK_lead` FOREIGN KEY (`BIRDDOG_ID`) REFERENCES `birddog` (`ID`),
  CONSTRAINT `FK_lead1` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `lead` */

insert  into `lead`(`ID`,`BIRDDOG_ID`,`PROPERTY_TYPE`,`STATUS`,`ADDRESS_ID`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`OWNER_FIRST_NAME`,`OWNER_LAST_NAME`,`CONSTRUCTION_TYPE`,`ROOF_CONSTRUCTION_TYPE`,`SQ_FOOT_UNDER_AIR`,`POOL`,`SQ_FOOTAGE_UNDER_AIR`,`BUILT_YEAR`,`NO_BEDROOMS`,`NO_BATHROOMS`,`LAST_SALE_DATE`,`LAST_SALES_PRICE`,`PROPERTY_LEAD_TYPE`,`OWNER_VERIFICATION`,`SELLER_MOTIVATION`,`PHYSICAL_PROPERTY_INDICATORS`,`PERSONAL_INDICATORS`,`DRIVE_BY_DATE`,`VERIFY_OCCUPANCY`,`NOTLISTED_WITH_REALTOR`,`NOTLISTED_ANY_TYPE_AUCTIONS`,`VIRIFY_PROPERTY_OWNER_ISPERSON`,`APPROVAL`) values (12,4,'Apartment','Property Closed on',43,0,'2016-03-25 20:11:12','2016-03-25 20:11:12','sdfs','sdfsdf','Apartment','Woodframe/Stucco','234','No','234','2016','3','3','2016-03-27','23333','1','1','Foreclosure','Overgrown Grass,Roof Damage','Relocation','2016-03-26','Rental','1','1','1','Approved'),(13,4,'Vacant Lot','Reviewing',45,0,'2016-04-01 17:44:39','2016-04-01 17:44:39','eed','eefefef','Multi-Family 1-4 units','Woodframe/Stucco','12343','No','122231','2015','1','2','2016-04-08','12131','1','1','Relocation','Roof Damage','Tired Landlord','2016-04-22','Rental','1','1',NULL,'Approved'),(14,4,'Multi-Family 1-4 units','Reviewing',46,0,'2016-04-01 18:05:12','2016-04-01 18:05:12','asdas','asdasdd','Multi-Family 1-4 units','Woodframe','123','Yes','123','2015','2','3','2016-04-22','234324','1','1','Foreclosure','Overgrown Grass','Relocation','2016-04-28','Vacant','1','1','1','Approved'),(15,4,'Single Family Residence','Reviewing',47,0,'2016-04-04 16:18:18','2016-04-04 16:18:18','','','Single Family Residence','Woodframe/Stucco','','Yes','','2015','','','','',NULL,NULL,'Downsizing',NULL,'Foreclosure','','Owner Occupied','1','1',NULL,'Pending'),(16,4,'0','Reviewing',48,0,'2016-04-04 18:00:53','2016-04-04 18:00:53','','','0','0','','Yes','','0','','','','',NULL,NULL,'0','Overgrown Grass','Relocation','','0','1','1',NULL,'Pending');

/*Table structure for table `lead_attachment` */

DROP TABLE IF EXISTS `lead_attachment`;

CREATE TABLE `lead_attachment` (
  `lead_ID` int(11) NOT NULL,
  `attachments_ID` int(11) NOT NULL,
  PRIMARY KEY (`lead_ID`,`attachments_ID`),
  UNIQUE KEY `UK_muaix6q5y0dl4t36q49yvyn4i` (`attachments_ID`),
  KEY `FK_muaix6q5y0dl4t36q49yvyn4i` (`attachments_ID`),
  KEY `FK_95gki7rs6l0o4yifi2c4ayjxc` (`lead_ID`),
  CONSTRAINT `FK_95gki7rs6l0o4yifi2c4ayjxc` FOREIGN KEY (`lead_ID`) REFERENCES `lead` (`ID`),
  CONSTRAINT `FK_muaix6q5y0dl4t36q49yvyn4i` FOREIGN KEY (`attachments_ID`) REFERENCES `attachment` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lead_attachment` */

/*Table structure for table `lead_comment` */

DROP TABLE IF EXISTS `lead_comment`;

CREATE TABLE `lead_comment` (
  `lead_ID` int(11) NOT NULL,
  `comments_ID` int(11) NOT NULL,
  PRIMARY KEY (`lead_ID`,`comments_ID`),
  UNIQUE KEY `UK_pdfaqxyi6ilcxpn4lmba5h8k6` (`comments_ID`),
  KEY `FK_pdfaqxyi6ilcxpn4lmba5h8k6` (`comments_ID`),
  KEY `FK_q80egkpto3ad30lhsgx6vah3o` (`lead_ID`),
  CONSTRAINT `FK_pdfaqxyi6ilcxpn4lmba5h8k6` FOREIGN KEY (`comments_ID`) REFERENCES `comment` (`ID`),
  CONSTRAINT `FK_q80egkpto3ad30lhsgx6vah3o` FOREIGN KEY (`lead_ID`) REFERENCES `lead` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lead_comment` */

/*Table structure for table `lead_payment` */

DROP TABLE IF EXISTS `lead_payment`;

CREATE TABLE `lead_payment` (
  `lead_ID` int(11) NOT NULL,
  `payments_ID` int(11) NOT NULL,
  PRIMARY KEY (`lead_ID`,`payments_ID`),
  UNIQUE KEY `UK_1vu7w8m2u39yutxbktkmoj2p` (`payments_ID`),
  KEY `FK_1vu7w8m2u39yutxbktkmoj2p` (`payments_ID`),
  KEY `FK_ry3x0gbnq1d972ct3sdkr3rwd` (`lead_ID`),
  CONSTRAINT `FK_1vu7w8m2u39yutxbktkmoj2p` FOREIGN KEY (`payments_ID`) REFERENCES `payment` (`ID`),
  CONSTRAINT `FK_ry3x0gbnq1d972ct3sdkr3rwd` FOREIGN KEY (`lead_ID`) REFERENCES `lead` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lead_payment` */

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(100) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `EMAIL` varchar(50) NOT NULL,
  `ENCRYPTED` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_login` (`ROLE_ID`),
  CONSTRAINT `FK_login` FOREIGN KEY (`ROLE_ID`) REFERENCES `user_role` (`USER_ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`ID`,`PASSWORD`,`ROLE_ID`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`EMAIL`,`ENCRYPTED`) values (3,'12345',3,0,'2016-03-08 18:09:55','2016-03-04 15:20:42','vipul@gmail.com','$2a$10$1xRC8htxRmm5NfWXhSZXtuCqOPyMXIvBmxBEYNiCb71jxCzfYJnWC'),(7,'12345',1,0,'2016-03-08 19:01:22','2016-03-08 19:00:47','rei@rei.com','$2a$10$1xRC8htxRmm5NfWXhSZXtuCqOPyMXIvBmxBEYNiCb71jxCzfYJnWC'),(8,'12345',2,0,'2016-03-16 17:56:56','2016-03-08 19:17:59','birddog@birddog.com','$2a$10$ixioAz8QyGOPKarZA2Q3Jexisu2AHWGU7v3k9uYhsU/Vh9KbY8JHS');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REI_ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `BODY` varchar(300) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_message` (`REI_ID`),
  CONSTRAINT `FK_message` FOREIGN KEY (`REI_ID`) REFERENCES `re_investor` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `message` */

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEAD_ID` int(11) NOT NULL,
  `AMOUNT` decimal(50,0) NOT NULL,
  `PAYMENT_MODE` varchar(50) NOT NULL,
  `NOTES` varchar(50) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_payment` (`LEAD_ID`),
  CONSTRAINT `FK_payment` FOREIGN KEY (`LEAD_ID`) REFERENCES `lead` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payment` */

/*Table structure for table `re_investor` */

DROP TABLE IF EXISTS `re_investor`;

CREATE TABLE `re_investor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `CONTACT_NO` varchar(15) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `IMAGE_NAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hbbygc3ng7lciv75vek7waav4` (`ADDRESS_ID`),
  CONSTRAINT `FK_hbbygc3ng7lciv75vek7waav4` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `re_investor` */

insert  into `re_investor`(`ID`,`NAME`,`CONTACT_NO`,`EMAIL`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`ADDRESS_ID`,`IMAGE_NAME`) values (3,'REI','123456789','rei@rei.com',0,'2016-03-25 17:55:29','2016-03-08 19:00:47',28,NULL);

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATE_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

/*Data for the table `state` */

insert  into `state`(`ID`,`STATE_NAME`) values (1,'AL'),(2,'AK'),(3,'AZ'),(4,'AR'),(5,'CA'),(6,'CO'),(7,'CT'),(8,'DE'),(9,'FL'),(10,'GA'),(11,'HI'),(12,'ID'),(13,'IL'),(14,'IN'),(15,'IA'),(16,'KS'),(17,'KY'),(18,'LA'),(19,'ME'),(20,'MD'),(21,'MA'),(22,'MI'),(23,'MN'),(24,'MS'),(25,'MO'),(26,'MT'),(27,'NE'),(28,'NV'),(29,'NH'),(30,'NJ'),(31,'NM'),(32,'NY'),(33,'NC'),(34,'ND'),(35,'OH'),(36,'OK'),(37,'OR'),(38,'PA'),(39,'RI'),(40,'SC'),(41,'SD'),(42,'TN'),(43,'TX'),(44,'UT'),(45,'VY'),(46,'VA'),(47,'WA'),(48,'WV'),(49,'WI'),(50,'WY');

/*Table structure for table `super_admin` */

DROP TABLE IF EXISTS `super_admin`;

CREATE TABLE `super_admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `EMAIL_ID` varchar(50) NOT NULL,
  `CONTACT_NO` varchar(15) NOT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `IMAGE_NAME` varchar(200) DEFAULT NULL,
  `VIDEO_NAME` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_super_admin` (`ADDRESS_ID`),
  CONSTRAINT `FK_super_admin` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `super_admin` */

insert  into `super_admin`(`ID`,`NAME`,`EMAIL_ID`,`CONTACT_NO`,`ADDRESS_ID`,`IS_DELETED`,`CREATION_TIME`,`UPDATION_TIME`,`IMAGE_NAME`,`VIDEO_NAME`) values (1,'Vipul','vipul@gmail.com','123456789',NULL,0,'2016-03-19 13:04:15','2012-10-20 00:00:00',NULL,NULL);

/*Table structure for table `tutorial` */

DROP TABLE IF EXISTS `tutorial`;

CREATE TABLE `tutorial` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(50) NOT NULL,
  `AUDIENCE` varchar(100) NOT NULL,
  `REI_ID` int(11) NOT NULL,
  `ATTACHMENT_ID` int(11) NOT NULL,
  `CONTENT_DETAILS` varchar(200) NOT NULL,
  `IS_DELETED` int(3) NOT NULL,
  `CREATION_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATION_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_tutorial` (`REI_ID`),
  CONSTRAINT `FK_tutorial` FOREIGN KEY (`REI_ID`) REFERENCES `re_investor` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tutorial` */

/*Table structure for table `upload_tutorial` */

DROP TABLE IF EXISTS `upload_tutorial`;

CREATE TABLE `upload_tutorial` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IS_DELETED` int(11) DEFAULT NULL,
  `LINK` varchar(255) DEFAULT NULL,
  `ROLE` int(11) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `upload_tutorial` */

insert  into `upload_tutorial`(`ID`,`DESCRIPTION`,`IS_DELETED`,`LINK`,`ROLE`,`TITLE`,`TYPE`) values (1,'ddddddd',0,'',1,'dddd','default');

/*Table structure for table `upload_video` */

DROP TABLE IF EXISTS `upload_video`;

CREATE TABLE `upload_video` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `LINK` varchar(255) DEFAULT NULL,
  `ROLE` int(11) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `upload_video` */

/*Table structure for table `user_detail` */

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FULL_NAME` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `CONTACT_NO` varchar(15) NOT NULL,
  `REI_ID` int(50) DEFAULT NULL,
  `IS_DELETED` int(10) DEFAULT NULL,
  `CREATION_TIME` timestamp NULL DEFAULT NULL,
  `UPDATION_TIME` timestamp NULL DEFAULT NULL,
  `URL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_detail` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(20) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`USER_ROLE_ID`,`ROLE`) values (1,'REI'),(2,'BIRDDOG'),(3,'SA');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
