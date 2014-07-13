CREATE DATABASE  IF NOT EXISTS `dormitory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dormitory`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: localhost    Database: dormitory
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
-- Table structure for table `AttendanceLog`
--

DROP TABLE IF EXISTS `AttendanceLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AttendanceLog` (
  `logID` int(11) NOT NULL AUTO_INCREMENT,
  `log_tenantID` int(11) NOT NULL,
  `isIn` tinyint(1) NOT NULL,
  `timeLogged` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`logID`),
  KEY `tenantID_idx` (`log_tenantID`),
  CONSTRAINT `log_tenantID` FOREIGN KEY (`log_tenantID`) REFERENCES `Tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AttendanceLog`
--

LOCK TABLES `AttendanceLog` WRITE;
/*!40000 ALTER TABLE `AttendanceLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `AttendanceLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bill`
--

DROP TABLE IF EXISTS `Bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bill` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `bill_roomID` int(11) NOT NULL,
  `price` double NOT NULL,
  `paidRent` tinyint(1) NOT NULL,
  `paidWater` tinyint(1) NOT NULL,
  `paidElectric` tinyint(1) NOT NULL,
  PRIMARY KEY (`billID`),
  KEY `roomID_idx` (`bill_roomID`),
  CONSTRAINT `bill_roomID` FOREIGN KEY (`bill_roomID`) REFERENCES `Room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bill`
--

LOCK TABLES `Bill` WRITE;
/*!40000 ALTER TABLE `Bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contract`
--

DROP TABLE IF EXISTS `Contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contract` (
  `contractID` int(11) NOT NULL AUTO_INCREMENT,
  `contract_tenantID` int(11) NOT NULL,
  `effectivedate` date NOT NULL,
  `expirydate` date NOT NULL,
  PRIMARY KEY (`contractID`),
  KEY `tenantID_idx` (`contract_tenantID`),
  CONSTRAINT `tenantID` FOREIGN KEY (`contract_tenantID`) REFERENCES `Tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contract`
--

LOCK TABLES `Contract` WRITE;
/*!40000 ALTER TABLE `Contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `Contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ElectricReading`
--

DROP TABLE IF EXISTS `ElectricReading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ElectricReading` (
  `electric_billID` int(11) NOT NULL,
  `currentKW` float NOT NULL,
  `priceperKW` float NOT NULL,
  `price` float NOT NULL,
  `dateRead` date DEFAULT NULL,
  KEY `billID_idx` (`electric_billID`),
  CONSTRAINT `electricID` FOREIGN KEY (`electric_billID`) REFERENCES `Bill` (`billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ElectricReading`
--

LOCK TABLES `ElectricReading` WRITE;
/*!40000 ALTER TABLE `ElectricReading` DISABLE KEYS */;
/*!40000 ALTER TABLE `ElectricReading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Guardian`
--

DROP TABLE IF EXISTS `Guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Guardian` (
  `guardianID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `contact` bigint(12) NOT NULL,
  PRIMARY KEY (`guardianID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Guardian`
--

LOCK TABLES `Guardian` WRITE;
/*!40000 ALTER TABLE `Guardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `Guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Room` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `currentKW` float NOT NULL,
  `currentcubicmeter` float NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tenant`
--

DROP TABLE IF EXISTS `Tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tenant` (
  `tenantID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `image` blob,
  `contact` bigint(12) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `expectedyearofgrad` int(4) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`tenantID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tenant`
--

LOCK TABLES `Tenant` WRITE;
/*!40000 ALTER TABLE `Tenant` DISABLE KEYS */;
INSERT INTO `Tenant` VALUES (10001,'Adrian','Perez',NULL,123456789,'Male','Pasig City','BS CS-NE','DLSU',2016,'Registered');
/*!40000 ALTER TABLE `Tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TenantGuardian`
--

DROP TABLE IF EXISTS `TenantGuardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TenantGuardian` (
  `tg_tenantID` int(11) NOT NULL,
  `tg_guardianID` int(11) NOT NULL,
  KEY `tenantID_idx` (`tg_tenantID`),
  KEY `guardianID_idx` (`tg_guardianID`),
  CONSTRAINT `tg_tenantID` FOREIGN KEY (`tg_tenantID`) REFERENCES `Tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tg_guardianID` FOREIGN KEY (`tg_guardianID`) REFERENCES `Guardian` (`guardianID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TenantGuardian`
--

LOCK TABLES `TenantGuardian` WRITE;
/*!40000 ALTER TABLE `TenantGuardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `TenantGuardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TenantRoom`
--

DROP TABLE IF EXISTS `TenantRoom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TenantRoom` (
  `tr_tenantID` int(11) NOT NULL,
  `tr_roomID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  KEY `tr_tenantID_idx` (`tr_tenantID`),
  KEY `tr_roomID_idx` (`tr_roomID`),
  CONSTRAINT `tr_tenantID` FOREIGN KEY (`tr_tenantID`) REFERENCES `Tenant` (`tenantID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tr_roomID` FOREIGN KEY (`tr_roomID`) REFERENCES `Room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TenantRoom`
--

LOCK TABLES `TenantRoom` WRITE;
/*!40000 ALTER TABLE `TenantRoom` DISABLE KEYS */;
/*!40000 ALTER TABLE `TenantRoom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WaterReading`
--

DROP TABLE IF EXISTS `WaterReading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WaterReading` (
  `water_billID` int(11) NOT NULL,
  `currentcubicpermeter` float NOT NULL,
  `pricepercubicmeter` float NOT NULL,
  `price` float NOT NULL,
  `dateRead` date DEFAULT NULL,
  KEY `billID_idx` (`water_billID`),
  CONSTRAINT `waterID` FOREIGN KEY (`water_billID`) REFERENCES `Bill` (`billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WaterReading`
--

LOCK TABLES `WaterReading` WRITE;
/*!40000 ALTER TABLE `WaterReading` DISABLE KEYS */;
/*!40000 ALTER TABLE `WaterReading` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-14  7:45:53
