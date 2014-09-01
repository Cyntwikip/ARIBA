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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Lea','Coloma','leacoloma','abcd');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `attendancelog`
--

LOCK TABLES `attendancelog` WRITE;
/*!40000 ALTER TABLE `attendancelog` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendancelog` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormbill`
--

DROP TABLE IF EXISTS `dormbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dormbill` (
  `dbill_ID` int(11) NOT NULL AUTO_INCREMENT,
  `waterconsumption` float NOT NULL,
  `electricityconsumption` float NOT NULL,
  `totalwaterprice` double NOT NULL,
  `totalelectricityprice` double NOT NULL,
  `dateRead` datetime NOT NULL,
  PRIMARY KEY (`dbill_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormbill`
--

LOCK TABLES `dormbill` WRITE;
/*!40000 ALTER TABLE `dormbill` DISABLE KEYS */;
/*!40000 ALTER TABLE `dormbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electricreading`
--

DROP TABLE IF EXISTS `electricreading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electricreading` (
  `electric_billID` int(11) NOT NULL AUTO_INCREMENT,
  `currentKW` float NOT NULL,
  `datePaid` datetime DEFAULT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'Unpaid',
  PRIMARY KEY (`electric_billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electricreading`
--

LOCK TABLES `electricreading` WRITE;
/*!40000 ALTER TABLE `electricreading` DISABLE KEYS */;
/*!40000 ALTER TABLE `electricreading` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `guardian`
--

LOCK TABLES `guardian` WRITE;
/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(15) NOT NULL DEFAULT 'Unoccupied',
  `roomprice` double DEFAULT '0',
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'Unoccupied',0),(2,'Unoccupied',0),(3,'Unoccupied',0),(4,'Unoccupied',0),(5,'Unoccupied',0),(6,'Unoccupied',0),(7,'Unoccupied',0),(8,'Unoccupied',0),(9,'Unoccupied',0),(10,'Unoccupied',0),(11,'Unoccupied',0),(12,'Unoccupied',0),(13,'Unoccupied',0),(14,'Unoccupied',0),(15,'Unoccupied',0),(16,'Unoccupied',0),(17,'Unoccupied',0),(18,'Unoccupied',0),(19,'Unoccupied',0),(20,'Unoccupied',0),(21,'Unoccupied',0),(22,'Unoccupied',0),(23,'Unoccupied',0),(24,'Unoccupied',0),(25,'Unoccupied',0),(26,'Unoccupied',0),(27,'Unoccupied',0),(28,'Unoccupied',0),(29,'Unoccupied',0),(30,'Unoccupied',0),(31,'Unoccupied',0),(32,'Unoccupied',0),(33,'Unoccupied',0),(34,'Unoccupied',0),(35,'Unoccupied',0),(36,'Unoccupied',0),(37,'Unoccupied',0),(38,'Unoccupied',0),(39,'Unoccupied',0),(40,'Unoccupied',0),(41,'Unoccupied',0),(42,'Unoccupied',0),(43,'Unoccupied',0),(44,'Unoccupied',0),(45,'Unoccupied',0),(46,'Unoccupied',0),(47,'Unoccupied',0),(48,'Unoccupied',0),(49,'Unoccupied',0),(50,'Unoccupied',0);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roombill`
--

DROP TABLE IF EXISTS `roombill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roombill` (
  `roomID` int(11) NOT NULL,
  `waterreadingID` int(11) NOT NULL,
  `electricreadingID` int(11) NOT NULL,
  `dbillID` int(11) NOT NULL,
  `surcharge` double DEFAULT NULL,
  `datePaid` datetime DEFAULT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'Unpaid',
  KEY `roomID_idx` (`roomID`),
  KEY `dbillID_idx` (`dbillID`),
  KEY `waterID_idx` (`waterreadingID`),
  KEY `electricID_idx` (`electricreadingID`),
  CONSTRAINT `dbillID` FOREIGN KEY (`dbillID`) REFERENCES `dormbill` (`dbill_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `electricID` FOREIGN KEY (`electricreadingID`) REFERENCES `electricreading` (`electric_billID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `roomID` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `waterID` FOREIGN KEY (`waterreadingID`) REFERENCES `waterreading` (`water_billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roombill`
--

LOCK TABLES `roombill` WRITE;
/*!40000 ALTER TABLE `roombill` DISABLE KEYS */;
/*!40000 ALTER TABLE `roombill` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `tg_guardianID` FOREIGN KEY (`tg_guardianID`) REFERENCES `guardian` (`guardianID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tg_tenantID` FOREIGN KEY (`tg_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenantguardian`
--

LOCK TABLES `tenantguardian` WRITE;
/*!40000 ALTER TABLE `tenantguardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenantguardian` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `tr_roomID` FOREIGN KEY (`tr_roomID`) REFERENCES `room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tr_tenantID` FOREIGN KEY (`tr_tenantID`) REFERENCES `tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenantroom`
--

LOCK TABLES `tenantroom` WRITE;
/*!40000 ALTER TABLE `tenantroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenantroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waterreading`
--

DROP TABLE IF EXISTS `waterreading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waterreading` (
  `water_billID` int(11) NOT NULL AUTO_INCREMENT,
  `currentcubicpermeter` float NOT NULL,
  `datePaid` datetime DEFAULT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'Unpaid',
  PRIMARY KEY (`water_billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waterreading`
--

LOCK TABLES `waterreading` WRITE;
/*!40000 ALTER TABLE `waterreading` DISABLE KEYS */;
/*!40000 ALTER TABLE `waterreading` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

<<<<<<< HEAD
-- Dump completed on 2014-09-02  0:17:04
=======
-- Dump completed on 2014-09-01 18:37:49
>>>>>>> 4a482fd56314ed2fc39f67dafe672f934436e251
