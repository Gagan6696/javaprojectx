-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.89-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema project
--

CREATE DATABASE IF NOT EXISTS project;
USE project;

--
-- Definition of table `billdetails`
--

DROP TABLE IF EXISTS `billdetails`;
CREATE TABLE `billdetails` (
  `detailsid` int(11) NOT NULL auto_increment,
  `stockid` int(11) default NULL,
  `qty` int(11) default NULL,
  `price` float default NULL,
  `billid` int(11) default NULL,
  PRIMARY KEY  (`detailsid`),
  KEY `stockid` (`stockid`),
  KEY `billid` (`billid`),
  CONSTRAINT `billdetails_ibfk_1` FOREIGN KEY (`stockid`) REFERENCES `productstock` (`stockid`),
  CONSTRAINT `billdetails_ibfk_2` FOREIGN KEY (`billid`) REFERENCES `billinfo` (`billid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billdetails`
--

/*!40000 ALTER TABLE `billdetails` DISABLE KEYS */;
INSERT INTO `billdetails` (`detailsid`,`stockid`,`qty`,`price`,`billid`) VALUES 
 (1,3,5,1,2),
 (2,3,5,1,2),
 (3,3,5,1,2),
 (4,3,5,1,2);
/*!40000 ALTER TABLE `billdetails` ENABLE KEYS */;


--
-- Definition of table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
CREATE TABLE `billinfo` (
  `billid` int(11) NOT NULL auto_increment,
  `contactno` varchar(20) default NULL,
  `billdate` datetime default NULL,
  `username` varchar(100) default NULL,
  PRIMARY KEY  (`billid`),
  KEY `username` (`username`),
  CONSTRAINT `billinfo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `logininfo` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billinfo`
--

/*!40000 ALTER TABLE `billinfo` DISABLE KEYS */;
INSERT INTO `billinfo` (`billid`,`contactno`,`billdate`,`username`) VALUES 
 (1,'mjgrapess@gmail.com','2016-09-14 19:31:57','gagan'),
 (2,'mjgrapess@gmail.com','2016-09-14 19:33:06','gagan');
/*!40000 ALTER TABLE `billinfo` ENABLE KEYS */;


--
-- Definition of table `companyinfo`
--

DROP TABLE IF EXISTS `companyinfo`;
CREATE TABLE `companyinfo` (
  `companyid` varchar(20) NOT NULL,
  `companyname` varchar(100) default NULL,
  PRIMARY KEY  (`companyid`),
  UNIQUE KEY `companyname` (`companyname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companyinfo`
--

/*!40000 ALTER TABLE `companyinfo` DISABLE KEYS */;
INSERT INTO `companyinfo` (`companyid`,`companyname`) VALUES 
 ('af','amit food products'),
 ('bl','belltoyss'),
 ('de','deep enterprises'),
 ('DEN','densaya'),
 ('RB','reebok'),
 ('zeb','zebronics');
/*!40000 ALTER TABLE `companyinfo` ENABLE KEYS */;


--
-- Definition of table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) default NULL,
  `rolename` varchar(20) default NULL,
  `lastlogin` datetime default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

/*!40000 ALTER TABLE `logininfo` DISABLE KEYS */;
INSERT INTO `logininfo` (`username`,`password`,`rolename`,`lastlogin`) VALUES 
 ('ansh','anshrana','admin','2016-09-12 11:25:13'),
 ('gagan','admin','user','2016-09-17 13:16:38'),
 ('gagansharma','admin','admin','2016-09-17 16:38:10'),
 ('pooja','admin','user',NULL),
 ('poonam','punnu','user',NULL),
 ('poonamgagan','puunugagan','admin','2016-09-12 16:11:15');
/*!40000 ALTER TABLE `logininfo` ENABLE KEYS */;


--
-- Definition of table `productinfo`
--

DROP TABLE IF EXISTS `productinfo`;
CREATE TABLE `productinfo` (
  `productid` int(11) NOT NULL auto_increment,
  `productname` varchar(100) default NULL,
  `companyid` varchar(20) default NULL,
  `subtypeid` int(11) default NULL,
  `price` float default NULL,
  PRIMARY KEY  (`productid`),
  UNIQUE KEY `index_4` (`productname`),
  KEY `companyid` (`companyid`),
  KEY `subtypeid` (`subtypeid`),
  CONSTRAINT `productinfo_ibfk_1` FOREIGN KEY (`companyid`) REFERENCES `companyinfo` (`companyid`),
  CONSTRAINT `productinfo_ibfk_2` FOREIGN KEY (`subtypeid`) REFERENCES `productsubtype` (`subtypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productinfo`
--

/*!40000 ALTER TABLE `productinfo` DISABLE KEYS */;
INSERT INTO `productinfo` (`productid`,`productname`,`companyid`,`subtypeid`,`price`) VALUES 
 (17,'Salt','af',30,1),
 (18,'chowmin','af',36,110),
 (20,'iodine salt','af',39,47),
 (21,'high base spekerss','zeb',40,4555),
 (22,'running','RB',41,2345);
/*!40000 ALTER TABLE `productinfo` ENABLE KEYS */;


--
-- Definition of table `productstock`
--

DROP TABLE IF EXISTS `productstock`;
CREATE TABLE `productstock` (
  `productid` int(11) default NULL,
  `stockdate` date default NULL,
  `stockid` int(11) NOT NULL auto_increment,
  `qty` int(11) default NULL,
  `price` float default NULL,
  `expirydate` date default NULL,
  PRIMARY KEY  (`stockid`),
  UNIQUE KEY `index_3` (`productid`),
  CONSTRAINT `productstock_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `productinfo` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productstock`
--

/*!40000 ALTER TABLE `productstock` DISABLE KEYS */;
INSERT INTO `productstock` (`productid`,`stockdate`,`stockid`,`qty`,`price`,`expirydate`) VALUES 
 (17,'2015-01-02',3,345,4500,'2016-09-14'),
 (21,'2013-03-03',4,345,23400,'2020-02-02'),
 (22,'2013-03-03',5,345,34000,'2020-01-03');
/*!40000 ALTER TABLE `productstock` ENABLE KEYS */;


--
-- Definition of table `productsubtype`
--

DROP TABLE IF EXISTS `productsubtype`;
CREATE TABLE `productsubtype` (
  `subtypeid` int(11) NOT NULL auto_increment,
  `subtypename` varchar(100) default NULL,
  `typeid` varchar(20) default NULL,
  PRIMARY KEY  (`subtypeid`),
  UNIQUE KEY `index_3` (`subtypename`),
  KEY `typeid` (`typeid`),
  CONSTRAINT `productsubtype_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `producttype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productsubtype`
--

/*!40000 ALTER TABLE `productsubtype` DISABLE KEYS */;
INSERT INTO `productsubtype` (`subtypeid`,`subtypename`,`typeid`) VALUES 
 (30,'face cream','bp'),
 (36,'mouse','cp'),
 (38,'face productss','bp'),
 (39,'salt','FP'),
 (40,'boofer','EL'),
 (41,'shoes','WD');
/*!40000 ALTER TABLE `productsubtype` ENABLE KEYS */;


--
-- Definition of table `producttype`
--

DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `typeid` varchar(20) NOT NULL,
  `typename` varchar(100) default NULL,
  PRIMARY KEY  (`typeid`),
  UNIQUE KEY `typename` (`typename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producttype`
--

/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
INSERT INTO `producttype` (`typeid`,`typename`) VALUES 
 ('bp','beauty products'),
 ('cp','computer productss'),
 ('den','densaya'),
 ('EL','electronics'),
 ('FP','food products'),
 ('WD','wears');
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
