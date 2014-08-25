CREATE DATABASE  IF NOT EXISTS `dormitory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dormitory`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: dormitory
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attendancelog`
--

DROP TABLE IF EXISTS `attendancelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendancelog` (
  `logID` int(11) NOT NULL AUTO_INCREMENT,
  `log_tenantID` int(11) NOT NULL,
  `isIn` tinyint(1) NOT NULL,
  `timeLogged` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`logID`),
  KEY `tenantID_idx` (`log_tenantID`),
  CONSTRAINT `log_tenantID` FOREIGN KEY (`log_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `bill_roomID` int(11) NOT NULL,
  `price` double NOT NULL,
  `paidRent` tinyint(1) NOT NULL,
  `paidWater` tinyint(1) NOT NULL,
  `paidElectric` tinyint(1) NOT NULL,
  `totalwaterconsumption` float NOT NULL,
  `totalelectricityconsumption` float NOT NULL,
  `roomprice` float NOT NULL,
  PRIMARY KEY (`billID`),
  KEY `roomID_idx` (`bill_roomID`),
  CONSTRAINT `bill_roomID` FOREIGN KEY (`bill_roomID`) REFERENCES `room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `contractID` int(11) NOT NULL AUTO_INCREMENT,
  `contract_tenantID` int(11) NOT NULL,
  `effectivedate` date NOT NULL,
  `expirydate` date NOT NULL,
  PRIMARY KEY (`contractID`),
  KEY `tenantID_idx` (`contract_tenantID`),
  CONSTRAINT `tenantID` FOREIGN KEY (`contract_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `electricreading`
--

DROP TABLE IF EXISTS `electricreading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electricreading` (
  `electric_billID` int(11) NOT NULL AUTO_INCREMENT,
  `currentKW` float NOT NULL,
  `priceperKW` float NOT NULL,
  `price` float NOT NULL,
  `dateRead` date DEFAULT NULL,
  KEY `billID_idx` (`electric_billID`),
  CONSTRAINT `electricID` FOREIGN KEY (`electric_billID`) REFERENCES `bill` (`billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guardian`
--

DROP TABLE IF EXISTS `guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guardian` (
  `guardianID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `contact` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`guardianID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `currentKW` float NOT NULL,
  `currentcubicmeter` float NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into room (roomID, currentKW, currentcubicmeter) values(1, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(2, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(3, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(4, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(5, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(6, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(7, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(8, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(9, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(10, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(11, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(12, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(13, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(14, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(15, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(16, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(17, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(18, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(19, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(20, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(21, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(22, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(23, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(24, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(25, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(26, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(27, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(28, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(29, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(30, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(31, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(32, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(33, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(34, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(35, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(36, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(37, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(38, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(39, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(40, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(41, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(42, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(43, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(44, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(45, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(46, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(47, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(48, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(49, 0,0);
insert into room (roomID, currentKW, currentcubicmeter) values(50, 0,0);


--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `tenantID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `image` longblob,
  `contact` varchar(12) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `expectedyearofgrad` int(4) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`tenantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tenantguardian`
--

DROP TABLE IF EXISTS `tenantguardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenantguardian` (
  `tg_tenantID` int(11) NOT NULL,
  `tg_guardianID` int(11) NOT NULL,
  KEY `tenantID_idx` (`tg_tenantID`),
  KEY `guardianID_idx` (`tg_guardianID`),
  CONSTRAINT `tg_tenantID` FOREIGN KEY (`tg_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tg_guardianID` FOREIGN KEY (`tg_guardianID`) REFERENCES `guardian` (`guardianID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tenantroom`
--

DROP TABLE IF EXISTS `tenantroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenantroom` (
  `tr_tenantID` int(11) NOT NULL,
  `tr_roomID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  KEY `tr_tenantID_idx` (`tr_tenantID`),
  KEY `tr_roomID_idx` (`tr_roomID`),
  CONSTRAINT `tr_tenantID` FOREIGN KEY (`tr_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tr_roomID` FOREIGN KEY (`tr_roomID`) REFERENCES `room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `waterreading`
--

DROP TABLE IF EXISTS `waterreading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waterreading` (
  `water_billID` int(11) NOT NULL,
  `currentcubicpermeter` float NOT NULL,
  `pricepercubicmeter` float NOT NULL,
  `price` float NOT NULL,
  `dateRead` date DEFAULT NULL,
  KEY `billID_idx` (`water_billID`),
  CONSTRAINT `waterID` FOREIGN KEY (`water_billID`) REFERENCES `bill` (`billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-25 18:06:47
