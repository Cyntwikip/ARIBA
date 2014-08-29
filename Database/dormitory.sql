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
  `surcharge` float DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`billID`),
  KEY `roomID_idx` (`bill_roomID`),
  CONSTRAINT `bill_roomID` FOREIGN KEY (`bill_roomID`) REFERENCES `room` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,1,'2014-08-26','2015-08-26');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
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
  `priceperKW` float NOT NULL,
  `price` float NOT NULL,
  `dateRead` date DEFAULT NULL,
  KEY `billID_idx` (`electric_billID`),
  CONSTRAINT `electricID` FOREIGN KEY (`electric_billID`) REFERENCES `bill` (`billID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian`
--

LOCK TABLES `guardian` WRITE;
/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
INSERT INTO `guardian` VALUES (1,'ASDF','ASDF','09178888888','s@y.com');
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
  `currentKW` float NOT NULL,
  `currentcubicmeter` float NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,0,0),(2,0,0),(3,0,0),(4,0,0),(5,0,0),(6,0,0),(7,0,0),(8,0,0),(9,0,0),(10,0,0),(11,0,0),(12,0,0),(13,0,0),(14,0,0),(15,0,0),(16,0,0),(17,0,0),(18,0,0),(19,0,0),(20,0,0),(21,0,0),(22,0,0),(23,0,0),(24,0,0),(25,0,0),(26,0,0),(27,0,0),(28,0,0),(29,0,0),(30,0,0),(31,0,0),(32,0,0),(33,0,0),(34,0,0),(35,0,0),(36,0,0),(37,0,0),(38,0,0),(39,0,0),(40,0,0),(41,0,0),(42,0,0),(43,0,0),(44,0,0),(45,0,0),(46,0,0),(47,0,0),(48,0,0),(49,0,0),(50,0,0);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'SF','ALBAYDA','1980-04-07','ˇÿˇ‡\0JFIF\0\0ñ\0ñ\0\0ˇÌ\0,Photoshop 3.0\08BIMÌ\0\0\0\0\0\0ñ\0\0\0\0\0ñ\0\0\0\0ˇ·.http://ns.adobe.com/xap/1.0/\0<?xpacket begin=\"Ôªø\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"Adobe XMP Core 5.3-c011 66.145661, 2012/02/06-14:56:27        \">\n   <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n      <rdf:Description rdf:about=\"\"\n            xmlns:dc=\"http://purl.org/dc/elements/1.1/\">\n         <dc:format>image/jpeg</dc:format>\n         <dc:title>\n            <rdf:Alt>\n               <rdf:li xml:lang=\"x-default\">Default Photos</rdf:li>\n            </rdf:Alt>\n         </dc:title>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\"\n            xmlns:xmpGImg=\"http://ns.adobe.com/xap/1.0/g/img/\">\n         <xmp:MetadataDate>2014-08-05T21:46:29+08:00</xmp:MetadataDate>\n         <xmp:ModifyDate>2014-08-05T13:46:32Z</xmp:ModifyDate>\n         <xmp:CreateDate>2014-08-05T21:46:29+08:00</xmp:CreateDate>\n         <xmp:CreatorTool>Adobe Illustrator CS6 (Windows)</xmp:CreatorTool>\n         <xmp:Thumbnails>\n            <rdf:Alt>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <xmpGImg:width>256</xmpGImg:width>\n                  <xmpGImg:height>256</xmpGImg:height>\n                  <xmpGImg:format>JPEG</xmpGImg:format>\n                  <xmpGImg:image>/9j/4AAQSkZJRgABAgEAlgCWAAD/7QAsUGhvdG9zaG9wIDMuMAA4QklNA+0AAAAAABAAlgAAAAEA&#xA;AQCWAAAAAQAB/+4ADkFkb2JlAGTAAAAAAf/bAIQABgQEBAUEBgUFBgkGBQYJCwgGBggLDAoKCwoK&#xA;DBAMDAwMDAwQDA4PEA8ODBMTFBQTExwbGxscHx8fHx8fHx8fHwEHBwcNDA0YEBAYGhURFRofHx8f&#xA;Hx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8f/8AAEQgBAAEAAwER&#xA;AAIRAQMRAf/EAaIAAAAHAQEBAQEAAAAAAAAAAAQFAwIGAQAHCAkKCwEAAgIDAQEBAQEAAAAAAAAA&#xA;AQACAwQFBgcICQoLEAACAQMDAgQCBgcDBAIGAnMBAgMRBAAFIRIxQVEGE2EicYEUMpGhBxWxQiPB&#xA;UtHhMxZi8CRygvElQzRTkqKyY3PCNUQnk6OzNhdUZHTD0uIIJoMJChgZhJRFRqS0VtNVKBry4/PE&#xA;1OT0ZXWFlaW1xdXl9WZ2hpamtsbW5vY3R1dnd4eXp7fH1+f3OEhYaHiImKi4yNjo+Ck5SVlpeYmZ&#xA;qbnJ2en5KjpKWmp6ipqqusra6voRAAICAQIDBQUEBQYECAMDbQEAAhEDBCESMUEFURNhIgZxgZEy&#xA;obHwFMHR4SNCFVJicvEzJDRDghaSUyWiY7LCB3PSNeJEgxdUkwgJChgZJjZFGidkdFU38qOzwygp&#xA;0+PzhJSktMTU5PRldYWVpbXF1eX1RlZmdoaWprbG1ub2R1dnd4eXp7fH1+f3OEhYaHiImKi4yNjo&#xA;+DlJWWl5iZmpucnZ6fkqOkpaanqKmqq6ytrq+v/aAAwDAQACEQMRAD8A6vil2KuxV2KuxV2KuxV2&#xA;KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2K&#xA;uxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2Ku&#xA;xV2KuxV2KuxV2KuxV2KuAJNBuT0GKo+30HV7gVjtnCnu9EH/AA1MUI5PJ2rMKlok9mY/wU4qvPkv&#xA;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&#xA;uxV2KuxV2KuxVIvOEsa6WsbEc3kXgvfatTir/9k=</xmpGImg:image>\n               </rdf:li>\n            </rdf:Alt>\n         </xmp:Thumbnails>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:xmpMM=\"http://ns.adobe.com/xap/1.0/mm/\"\n            xmlns:stRef=\"http://ns.adobe.com/xap/1.0/sType/ResourceRef#\"\n            xmlns:stEvt=\"http://ns.adobe.com/xap/1.0/sType/ResourceEvent#\">\n         <xmpMM:InstanceID>xmp.iid:BB20DCCAA61CE4118EEE8C922D5077CA</xmpMM:InstanceID>\n         <xmpMM:DocumentID>xmp.did:BB20DCCAA61CE4118EEE8C922D5077CA</xmpMM:DocumentID>\n         <xmpMM:OriginalDocumentID>uuid:5D20892493BFDB11914A8590D31508C8</xmpMM:OriginalDocumentID>\n         <xmpMM:RenditionClass>proof:pdf</xmpMM:RenditionClass>\n         <xmpMM:DerivedFrom rdf:parseType=\"Resource\">\n            <stRef:instanceID>uuid:46e5ab95-0d1c-4495-877e-e5723467b732</stRef:instanceID>\n            <stRef:documentID>xmp.did:D3F8A651A21CE4118026AF5055624C80</stRef:documentID>\n            <stRef:originalDocumentID>uuid:5D20892493BFDB11914A8590D31508C8</stRef:originalDocumentID>\n            <stRef:renditionClass>proof:pdf</stRef:renditionClass>\n         </xmpMM:DerivedFrom>\n         <xmpMM:History>\n            <rdf:Seq>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <stEvt:action>saved</stEvt:action>\n                  <stEvt:instanceID>xmp.iid:D3F8A651A21CE4118026AF5055624C80</stEvt:instanceID>\n                  <stEvt:when>2014-08-05T21:28:30+08:00</stEvt:when>\n                  <stEvt:softwareAgent>Adobe Illustrator CS6 (Windows)</stEvt:softwareAgent>\n                  <stEvt:changed>/</stEvt:changed>\n               </rdf:li>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <stEvt:action>saved</stEvt:action>\n                  <stEvt:instanceID>xmp.iid:BB20DCCAA61CE4118EEE8C922D5077CA</stEvt:instanceID>\n                  <stEvt:when>2014-08-05T21:46:29+08:00</stEvt:when>\n                  <stEvt:softwareAgent>Adobe Illustrator CS6 (Windows)</stEvt:softwareAgent>\n                  <stEvt:changed>/</stEvt:changed>\n               </rdf:li>\n            </rdf:Seq>\n         </xmpMM:History>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:illustrator=\"http://ns.adobe.com/illustrator/1.0/\">\n         <illustrator:StartupProfile>Print</illustrator:StartupProfile>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:pdf=\"http://ns.adobe.com/pdf/1.3/\">\n         <pdf:Producer>Adobe PDF library 10.01</pdf:Producer>\n      </rdf:Description>\n   </rdf:RDF>\n</x:xmpmeta>\n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                           \n<?xpacket end=\"w\"?>ˇÓ\0Adobe\0d¿\0\0\0ˇ€\0Ñ\0		\n\n				\r	\rˇ¿\0\0ˇƒ\0ï\0\0\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0!1ï’AQaqÅë\"°2#±Rbrí¢3¡BÇ≤¬Csì$4Dcî—“SÉ≥√%56·Ò£TtÑF\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ˇ⁄\0\0\0?\0ˇ\0K\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˚¢›w*·∑EW*ü‚”3ÓÄKYÂ›ˇ\0\"\"´;.u jÍÆ,\\·˝)ß@JY‰Nmø\Z—≥\\¶:˛“ªVÁ›]tÉ›OÜ¸ŸV∫‡€£O∆øoß›TÉ”OÜœU13îLı”UÓò˜S0◊˛◊s7ü˚Ÿˇ\0í˛◊s7ü˚Ÿˇ\0í7˛⁄Û_ˇ\0ig˚˙?„‚Áá€DkNª≥¯¥ﬂµØÎU\0Ç Âéa¬ä™»Ÿ≤Ë¢à÷ªî⁄™∫\"=5SH!*¶™*ök¶i™:Èò“cÿ»\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0omÂΩ˜v·ùøkø~›]WÊûﬁW•?H;ú\nw{¸5nÿ¯4OL—DMÎëËòé\Z}’±¬≥óÒ¯jÀΩïü\\}jjÆ-€üeGÈ®ƒÂY¬ç,lò≥Ê™Ì:}˜x§ˆ¨Ÿ±D[±jã6„™ãt≈1ÓÄ}\0\0\0\0\0\0‰ ¿¡Õàß7∆]1—ﬁ∑M»˝hêr˘ûÚÆdU?ªcÂ_÷c◊UΩ=TÎ4˝\0Â3|$√Æfv˝ﬁıéèÜﬁE∫nÎ?ùL—ß∏éoÜÀç”è€Ö>HµwÜØl]ä#› ‰≥v\rÔn‚ú›´+ägIªU™∏?N\"i˙A\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›Å∂n•Ë«€∞ÓÊ]Ú”nôò¶:µ™z¢=2;hß2ÙSwzÕßô“gKó4Úƒ◊?\r3Í‚ôµÚo.mç∂€ªz4◊\'\">uz«ñ&≠bü‰ƒ®\0\0\0\0\0\0\0\0\0\0\0\0\0\0CÁr˛«πqNn’ã~∫˛µŸ∑L\\˝8à´È#ô·-dU≈è˜¨ò¯-]‚ß”˚HÆ~ê~Ò¸0Â{3rú¨øE€⁄’”@%(‰.R∑ıvj\'ÛÆ]´˘’»=Trw+—LSN«ã1çG˚Í÷A˘π…ú≠rbjŸ1£O≈â£˘≥\0›Ûînƒƒmsj©ÍÆ›Î—1ÏöÊ>ÄAexQ≤\\¶~Èùóã_ìéhªL{8iü§¶Ö;≈à™≠ø;>òÍ¢∏õ7\'’≈Oæ†põñ¡ΩlÛ1πm∑±©â”ÁM<VÊ|—rùiüdÇ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0øn⁄˜\r€\"ú]ªÊ]˘”Zhéäbz5™©Ë¶=3 ∏ˆq¨≈ºç˛ˇ\0ﬁnı˝¬ƒÕ6„—]}UÏ”◊ µq0±0,SçÖçoè´j’1M:˘Ùè,˘¡È\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 ©¶∫j¶™b™jâä©ò÷&\'Æ&√o^Ú˛Ì‹≥c˜^]]WÒ¢\"âü µıgŸ§˙AMs$o[ÃΩ]ØæÌÙœFuàôàè$‹ßÆè¡È\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊—3=PCñ<7Õ‹æ^fı«∑`œM›WÓG¶\'ÍGØß—Â„∑mòN58õv-∂)˛-”T˘Í™zjüL»=‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊—=@¨9£√å- .fÏ±F÷´™≈ŸÙD}IüGG£ \n#3+o…ªáõbºlõ3•ÀU∆ìÒƒ˘&Â\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ø/r µÖÉb¨úõÛ•ªTu˙fg™\"<≥=@–\\ß»8[[Õ‹\"åÌ€Æö¥÷’ô¸àûπ¸©ˆiÂ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0s<À €w2‚¸ºö~N]∫t≈œ¶>;~]\'´äü<O≥Iiﬁ6|Ìè:Ó}ØózﬂM«M(û™Ëü,Oˇ\0	ÈX\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0WfŸ≥˜‹€x;}ôπrÆõó\'¢ãtk§◊\\˘\"?˘tÉKrﬂ+Ì¸µãÚ±i˘πWb>˜ùT|w\'ÕãLy\">ôÈJ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ûÊN\\¬ÊL\n±rb-‰[â´2#‚µ\\«”L˘cÀÎ“Aó˜=∑/hŒ»€Ûm¸ºåz∏jÛUJ©ü,Lt¿<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ìŸˆå›Û>ŒﬂÅoéıﬁö™ûäh¢:Î™|ëÈüÂÓ_¡ÂÃ\n0Ò)‚πVïeÂL|wk”Æ|—HÚ{‰¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÜÁéT£òp>~5∂38µuM zÊ‘œßÆ5Íü\\É4’MT’4’MTŒïS=I\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˜≈≈»Õ»≥âãj´Ÿ≈mS◊US‘\r? |±èÀ;|Zéπ˘g‰«Ò™é™i◊¯¥Î—ÁÎT\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0áÒ3ñ~Áï˛Ω1≥j·œ¢òË¢ÙıW—‰ØÀÈıÇß\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_ﬁÚ§mÿ¥Ôôˆ¥ŒÃ£¸∫∫ÌY´¯ﬁä´è£◊ ¥Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‚‹p1˜L≠ø.û<|ªsn‰yc^©ç|±=1ÈL›vÏç£pÀ€r©“ˆ%…¢©Íä£Æö£—TLL<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊!r◊ÔÌ÷/d€‚€vÈ¶ÊTOU ÁÍ[ˆÈ¨˙#“\r-’—@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ns≈]èé÷&ˇ\0bèä÷òŸÛã3ˆuO™u¶g”\0§Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0}-Zπ~Ìª6hõóoUZ∑Lk5UTÈÈêjﬁYÿÌr˛—ç∑—•W¢>feÿ˛=Íæ¥˙£™=	\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ét€ÏÓªvf›ˆYñ™∑3◊√3G¶\'IÄd\\¨k∏y9óÈ‡øãr´W©ÛUDÕ3¯¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0g¯a±˝˚tªªﬂ¢\'kç,D«EWÎéè—çg◊†4\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\03øâ€W‹∑˙s≠”•ù÷‘\\ô”H˘∂Ù¢∏ègœ¨∏\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0UÚéœ¡ÉáU9SÛ≥<ˇ\06ÁMQ?õ\ZSÏJ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\nÎƒ›∂39rrÈ¶&ÓŸzã±WóÇπ˘uƒ{f\'ÿË\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0:ÆK⁄£wÊ=ª∫8ÏYØÔ91¶±¡k‚“}U•>–j`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‚‹∞È‹vÏÏ\n¥àÃ«πgäzb8Èöb}öÍ}U5QUTU5Q3S>Ié∞~@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0t¯K∑«Ì∫’OLÕñ+ı}•»˛`.p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0RÊÏ?∏Û.ıè§Sy™Ì«TS{Ì)èu@Á\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0§<3∑M´b™cIΩëz∫˝3p˛\n`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05¯ìŸô1\ZMVlL˙˛\\GÉ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0õÚòßî6ôà“kúâ™|ÛÛÓFæËj\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Õû%ÍºøÏl2¡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Qr%3G)l—>[w\'£”vπ˛u¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ÿ‚W˛´À˛∆«Û \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05o(⁄˘<±±—√√Æ%∫Ù¸¯„◊€Æ†Ë¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0∑ƒ∏òÊ¨ôòòä¨Yöf|±¡ßG∂¿Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\\Ï|Ωãd∑§«5:O_E™`‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Î‚è˛¶èˇ\0◊·®»\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\06>üª·‚X“c‰Y∑oIÎ¯iàÈ˜“\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0œ~*—M<«çTGMÕæ’Uz˛e⁄≥\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ı±GÕΩfﬂ_ÃÆöz}3†6X\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n≈àèﬂÿygàüe€üÒÇÆ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0/∞Z˘˚ÓÀfzÆÁc”W™nS®5»\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n≈™&7]™ÁEXµSy¯kô”Ÿ®*p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0?%ŸúéiŸ(à◊á&.uk˚8öˇ\0¢\rR\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ìÒvﬁóv∫Ù◊FM:~l€üÈõ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›¯ojnsf\rzL¸ãwÎôÛkn™?§\r*\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ùÒvùqˆ:¸î‹»ßﬂOë\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0hxQj+ﬂÛnÃk∞kàü4’rﬂDÉ@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0™¸YµÆÀ∑^Ë˚<Ë£”Ò€Æ¢\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Õ·àö˜‹ôèäöqÌ—>äæd’¯ P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n„≈s_,”W¸÷e™ß£Úkß¯AùÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_æ„≈&·ì¸k˘≥G≤›∫&>ö§ò\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0+ƒ;qsîwI”Y∑6+ßŸzàü¢dê\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ñ„,rû\r~\\´óÆ’ÙìD}¿;†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ﬂ8Y˘¸ØæQ¶º8µ‹Ëˇ\0gÒˇ\0DL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0∞ÂLx≈Â≠é‘ypÌ\\ü] xÁÈ®\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›Ê‘ﬂ⁄7[\ZÕÏ;ˆ‚<¸VÍÄd\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÍöjÆ™h¶5™πà¶=2\rëèfúl{Ù}KÈ∑G™ààè¿∞\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‰ƒLLLk—1>PcK÷Ê’€∂ßÆ›uS>…–0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\01ÀÿÒóølÿ’F¥]Õ±M»¸û8‚˙Æ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0IÊK?#ò7ªQ\ZSFvG~L‹™cË(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ó<:«˘¸Ÿ∑U√≈N=7Æ◊Ë“›Tƒ˚ÍÄiÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0òy˛ƒcÛnÌ∆î›™’ÿÙÕv®ößÙµ\Z\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0-	±¶Ω◊tÃ”ZqÒiµ3Êõµ≈QÙ[ê_ \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0=x©èπãı1—ìÖn™ßœU5◊O‡àh\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0/è	±x6≠”7ÀìïMüeö\"Ø˚@[\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ïÒs\"Ωè.#‚™/⁄π>à‡™ü√ ¶@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0õ˜1πOmù4Ø&nﬁπ¸´ïE3˙1\0Ì@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0e‚Æ?ÃÂ¸[ÒNµcf—≠^jk¢∏üß@g¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ØˆåI¡⁄∂‹)¶)´Õ™‚?\Zä\"\'Èà\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‰9ÛÔ<ßª”ÎU∫(ªO£Â‹¶©ütH2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0%6<HŒﬁv¨9˙π9vm◊1”•3\\qO≤Ø\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r”\ZsvÕ«ûôÀ≈Ωf#”râß¯AèÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ﬁxoâ9<’âsáäú+Wo◊˙?.\'Ù´Äi@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0y≈˚éÔ∫a«’∆ÀΩnôÛ”Ms>ÿ`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ì¬L8õªŒ|«MZ«∑?ù3]Õ§`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0À‚,bÛ^„4”√FLZøDi¯‘DU>⁄¢AƒÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0—ﬁaŒ7,[Ω1§Á‰]ΩÂ“ôãQ¸¿X@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0(Ø±&ç«iŒ”£#ª>õUÒ⁄§\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Æv/›€&’Ö4Wèãjõ¥ˇ\0¥·âØı¶A.\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0∞ÒW/lXôqLÕxytƒ’Ê¢Â5D˛¥R¸\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ïÿøxÔ;^∆¥‰‰⁄¢ÁFø’SÏçAÆ¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÃÛñ$ÊÚæıf#YßoGÆÃ≈ﬂËÉ*Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0,?pæıÃ‘dL|;~=€⁄œ„U*#ıÊ}Ä—†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¸]∑EÎw,‹¶*∑vô¢Â3Â¶®“`Á+ºLúå[±•Ãkµ⁄πj®™iü¶\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0üÑ∏<;Æ„TFπ®«∑>XãTÒUÏû8˜›\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0{ü0æÂÕ[≠4ƒ≈”ìDœóÊ”U˙” ‰\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0§‰|›¸Ø¥⁄™ò¶Â˚_yπ1Â˘”5”Ø¶)òÄuÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0åÒkÉ7i‹b:/ŸØøD⁄´ä5ı¸…˜¢\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Øº¸Ï<¥ÃønÕÈπTSØ“\rÖn›m€µjò¢›™bãtGTSLiÓÏ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Wû&‡˝Îñk»àé-ª\"›Ì|º5OÀòè”âˆ9\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0º„Ôº—çr™b´{}ªô5ƒ˘‚8)ˆ≈UƒÉJ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0#∑å‹ˆ≠«oòâúº{ñ®◊™*™ô·üdÈ »311§«DƒÉ¯\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÚóÉu‹Íà◊\"ÌˆßÀn8™ˆL◊‡[¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\02ó7`~ÌÊMﬂ)äh˚≈WmSQEÔ¥¶#’hp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0©‰›ø˜g-m8Û+≥Ôti<Wæ“b}1≈ß∞8\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n#≈çøÂn[vÂM:Sôb´7&?ÃÎ¨˙‚∏è`*`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¶ÀÅ;¶Ô∑mÒ1óëE4Îä&~9ˆS¨É]ƒDDDFë‰Ù\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‚Vﬂ˜ﬁYΩ~ò÷Ê€våäz:fôû\n£›Væ¿f‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ù·f€˜ùÛ#p™ùh€,O^kóµ¢?V*Ç\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ó;ﬁ~^ﬁãYñk≥r|—]3Lœ“}~≈Ãk˜±ØS¡{ÂVÓ—>J®ù&=ê\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0—ûmørÂÿÀ™ù.Ów™ªØóÂ—QDÃz¡b\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0œ‚€˚øôÚÎ¶û;ç4Â€ı◊—_Î”2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0l{r≤,bÿßéˆM mY¢<µW1LGæA∞0q-‡ab`Ÿ˝ñö,€ü<QLS>ΩÍ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Gä€gœ€0wJ)÷º”jÙƒWz:&g—U1–P¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ôº8⁄ˇ\0xs%ãı”≈gl¢¨öıÍ„èÜ‹z¯ß_`4ê\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\'}€i›ˆ}«mòâú´Sjg™.G≈ng’TDÉ#UL”T”TM5S:U◊\0˛\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0–~mtÿÔn5”•›“ˆ¥O˚+Z”OÎM@≥@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0f.~⁄øuÛ.o\r<63ÙÀ±ˇ\0KØ∫∏®`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Èj’À˜mYµL◊vıt—nàÎö™ù\"#⁄\r∂·[€v¸,ZpaŸ¢‘LFöƒDœ∂zAÌ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0TxØ∂¸Ì≥t¢ùk¬Ω6ÆÃGıw£Æg—U1–P¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0œê6Ôﬁ—∑ÎL’kã.ÓûOïı\'ÙÊêi–\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Bs›˚◊b›p\"ôÆÂ¸zæM1ÂπG«oı©Äd†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ÿ·.ﬂ•≠€u™üØU∂j¸ÿ„πM π\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0LÊ}ø˜^ˇ\0ªaE<Z»Æ´4˘≠‹¯Ë˝Z†@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0PrÓ˛V€)™ûôTNUŸÛ¸È‚¶CÑÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0†|V¡˘÷u4p—üç√U^{ñj“V™AVÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0—âçs3+‘kw*ÌmGÂWTSLÉaŸ≥oÕ´©·µbäm€ßÕM1§G∫ı\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0èäò1a∆Õ¶ôö2i‚´ÕnÏM3˙‹ œ†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ïπ\n3y´lä©ö≠„MyÈ‰˘tÃ”?•†4\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0üÊº8œÂÕÁ\Zu÷qkπDGñª_iL{fòO\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ø·&fÔ∏OG…≥oüOÕ´é}ﬂ.xÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0?ìTM5DUMQ•TœLLH1Ê·ãV~n[˝À5zÌ’4ˇ\0\0<`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\04?Ö∏#ón‰Õ\ZUùïr∫kÛ—DEÓ™*í\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\00sˆ$bs^ÎM1•Í¢˝>ôπE5U?•®8‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ZØì±~ÁÀ%ü-X‘ﬁòÙﬁ÷ÔÙÅ“Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0†¸X∆ö7ùª.)“úåOó≈Á™’uL˝¿*∞\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Íä*π]ÈÈ™∫¢öc”3†6F=ö1¨X«∑˚;È∑G™òàè¿∞\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\nè≈ºi´gÀ”¢∆EÀ3>õ¥EQˇ\0V\n,\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05Àv#\'ò6[GÊÿ„ßœLWW—\0÷¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ø|M«õ‹≠r‰Føt…≥v}\ZÃ€˛ò3à\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¥˙Ã^Ê›´X÷õ_:‰ˇ\0&’z}:N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0îÁõ3ï7™\"5·≥MÕ?≥Æö¸æ†e†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ì·eòªÃónO˙|+µ”:k”5—G≥¢©á\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\071[ãºøæQ1`dÈ¨k”Ú™“}íê\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0µ¸%∑3ªnótù(ƒä8ºü g˙ æ@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‚‹≠¸›ª>‘O‹∆ªNæmhò<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\\û[÷Ó˝w_©F5>~)π:˛®.¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|Ó€˘∂Æ⁄ô·ãîUNæmc@c0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0—·ˇ\0–ˇ\0˙üˆ¿∫\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˘Æ∫m—UuŒîQUSÊàÈêc\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Õ·\rT≈\\¡FøQãTG¢>lO·Ä]@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ún≈¨ÎµDÕ6ÒÓ’TG^ëL»1–\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŸñÓõûÌg£Ì1hØ”WßÙÅ{Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0òÆ≈ùÉ{ª3ßDƒÎßOÀ´NüX2@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ƒ√.ú~g¶Õ_Î±nŸß◊Nó\r\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ƒç¬ú.X…≥ÆówñÒÌ«óMxÍù<⁄Sß¥∞\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ì€sÆÌõÜ·g¶ÊÍ.”OíxgY¶}\0◊8Yñ7Ll‹j¯ÒÚ≠”v’^ä£^ü4«ñÍ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ú<FﬂÈ›˜Øπ„◊«Ö¥≈Vh™:™ª3ˆïG∂\"üfæPW¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0-œ\rπÆúKëÀ˚Öÿß˝sV›z©“(πW]πôÚU=1ÈıÇÙ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Vº˝Œ4m◊6ù∫ˆª∂M:]πDÙ„€™:ıé™Ê:º›~mC<Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ªí¸B¢Ì6vù˛˜Ë“å]ŒπËØÕMŸû©¸Ø/óß¶B‚ÎÈé†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0V<·‚>’M›ªgπNNÈ”E‹à“´v<˛ä´è7Ty|¿†o^ªëvÂÎ˜*ΩzÌSUÀµÃ’US=s3=2ò\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¿Â~‹v/óâõ≈∏ÌtÈj©˚[Tˇ\0≥™|ë¯≥—Ê–∆œøm[Ìèü∂ÂS{H˚[3‹¢|’Q=1ÎÍ¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\"∑mÔlŸ1Á#rÀ£\Zââ˘tOMuÃy(¢:gÿ\n3ôºE‹7xπáµ≈{fﬂTM5’ˆ◊b\Z®˙±Ëèl»+p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˜∆ …¬øFN%˚òŸÁ[w≠U4’©ÄZ[\'äyÿ¸wÃhŒµ\ZDÂŸà¢ÙyÊiË¢Øg-ù£ô∂MÚöwÁ€πvcßπ‡ªÇ≠&tÛ«@\'Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ªs&…≤SWÔ˚vÆƒtcS<wgX÷>\nuûü<Ù¶ﬂ<TÃ»äÏlXøq∑=|ø•wf?&éöiˆÒ¨  …ÕΩ^NfEÃ¨ãü^ı⁄¶∫ß€ ÛÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˚4ÃULÃLN±1◊√jÁŒe⁄xhß7Ô∂)Í«Àâª\Zuik∆ûh®6€‚æ›wÜç◊oΩá_DMÎh◊À3√T{5}∑s&√∫∆Îè~∫ÁJlÕ\\&≥ØÜØ†`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0}«ò6]¶*˝·π„„WO]ôÆ*π˝›:’>‡p;üä€]é*6¨+Ÿı∆±Æ˝çøDƒt’>©às∫Û˜2ÓúT}˜Ó*˛£&ﬂæΩfø÷35L’TÃÃŒ≥3◊2‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0oô7Ì≥Ü0wlõ4Q:”fköÌ«˝z”Ù±¬ÒO±√Nf>.}1?SL€Æ}¥OÍÉÆ√Òciπ—ù∂‰‚U>[SEÍc◊3ÚÁËQâœ|´ô√n÷Ï◊W]ÈÆ÷û∫™àßÈGçüÉõ\Z·ÊÿÀç5÷Õ nFü…ô¨\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0äÓQjäÆ]ÆõtS”UuLDGÆdú›ÀX1˛#z≈÷:Èµ_Œ™=t⁄‚êrôæ*l8©√« œÆ>≠QLZ∑>⁄ßä?Déwä˚ΩÓ*p6¸l*jç\"ªìUÍ„”SÔ§^·Õú«πÒF^ÔëU∫„J¨€´ÂQ1Êö-ƒ˚`˜_LÙÃı»\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˚111:LuLWﬂ0‚)∆›Û,QVÈø\\S˙:Ë	Î Ûn<E?Ω>u4ıE€V™üm\\<_H&¨¯≠ÃDEÏL˙u’¡röß›^ü@%Ï¯ªr)à»ÿ©™Ø-vÚ&ò˝∑?Ññ|Y⁄*ˇ\01∂fZ˛Œm‹¸5P	~(ÚÕsTÊY÷b&kµLÈÈ¯k®˚~\"Úçq≠[ùVß]8j±{__√D¿;lõv-d‚ﬁ¢˛=Íb´W®ùi™\'À∞\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0vÊ=óbõTÓπÙb◊~&m[·ÆÂsÂ·∑MSÈò1{ƒÓWµ3¡s\'#”nÃ«ÛÊêE‰x≥¥S˛WlÃΩ?Ìf›ø¡U`Ü»Òs&®”dµj\ZÌÍÆ}”G·&OäÕ~4µò~õV¶©ˇ\0ÍU\\}\0Ä…Á>iÀôõªﬁM\Zˇ\0Ã’c›j)=\'#&øôìës\"πÎÆÂs\\˚Êd\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0©·è0‹≈‹gb»π3âüV$U=ÔS\ZÈhÆ\"}∫¸\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r”p≥¥ÌŸõéGÏ∞ÌUr™z¶©è´Lzjù\"ìw=À+wŒ…‹3n|ÃåöÊ™º‘«íö|——\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0›∂eUÉ∏‡f—:UâëjÙ\"®´¯∞Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_‚ÆtÿŸ10h™iú¸òõëÁ∑j8¶?Jiêg\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0–\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0èãóu»ÿÏk\Z[∑~Êû_éhéü—Ë:\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0=X6*…Õ√∆¶5´\"˝ªt«¶∫¢?Ñ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Q>-QTn[Mœ‚’ç]1Î¶Ωg¿*P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‘ÚV$ÊsNÀj:≠ﬂ˘Û?ÿD‹˛à58\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0•¸]µ˜\rËéüÒ4U?›Ã)p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kxOÅÛ∑]√p™òö0±‚’>JÔU—1¸ö&=†æÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‚æ<\\ÿrb5´6)◊ÕM +◊È¶@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r·¶›˜.[£&∫tªπﬁÆ¸œóÇ>\n#ıfc÷\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0r˘â9ú©ªSM<Uÿ¢õÙz>Ut’T˛åH2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kªÅ\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0snÂΩ˚v·ú\rÆ˝Îu}[ÛOøÔ+·ßÈkÉ·NıÇ¨ÏÃl\Z*˙‘”≈zÂ>»·ßıÅ‘‚¯M¥Q„7<ºäøŸE£›1r~êMŸﬂîÌFó0Æ‰˙n_πÃ™ÄzøÚ(ƒi˚ûù:øm{_Ãñˇ\0Ü¸ßv4∑Éw\Z\Z›˚ì?ØUp7¬]∫æùøu»∆ü≈øE7£ı~^üH-<LkXX∏ÿv#K8∂®≥j?&äbò˙ Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÊÃ∆£7+‰Èo.ÕvkòÛ\\¶iü¬âooŒø~Ê.>Ïõˆ´ö+µf›U’DÈ1•12	ªóÕ9:|Ωì\"ùt˝¨EÆøÌ&ê{£√æoùu⁄¢ü^Eè‡π ¸W·ˇ\07—L’;<ÃG\\Sz≈SÓãì éΩ |Àc^=è6xzÊãU\\è} ÑΩçëçWEãñ+¸[îÕ3ÓòÄ|@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05›¿Ö\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0øo⁄∑⁄˜»€∞ÆÊ]Ë‚ãtÎÎ—U]T«¶d~—·N]ﬁªﬁu8¥Nì8∏⁄WsO,Msƒ˙¢†Yõ_\'ÚÓ—¡V.€nªÙÈ˛&ˇ\0⁄‹÷?ç^±L˛l@:`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Êö(¢4¢ò¢&ff\"4Èûôüh?@\0\0?5—E fãî≈tU—UF±>∏ê@frü-gFô..≥:Õv®˘5OÆ´|3ÙÉêŒ´dø≈V^Nsıiôã÷„Ÿ:U˙¿‚wπÉä¨+∏˚ïıi¶Øïr}t◊•?¨;j‹ˆ ¢ç√˛œ’õ¥ULU˘≥1§˚\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0WjŸ7]Ó˜»€0Ód’•Àë\Z[£_∆Æt¶=≤ãc∑Ç˛˘ë˜˚—”8vfh≥È´¢™æèh-\\L\\+4c·„€≈±G‘≥jò¢òˆFÄÙ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0≈ÀvÓ—Uª¥Sr›q•vÎàöf<”÷3tˇ\0ñw>*£˜}˙øÆ√ò∑˙öM™\n◊u≥x≈‚πµ‰Z‹ÌGU©“ÕﬂuS4œÈ{]f`ÊÌ˜¶∆v-‹K—˝]⁄&âı∆Ωp \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ﬂ∑Ì[ñÎw‰ÌÿW≥.Â”3ÎÂ™Æ™c”2gó|.È£+òÓuN¥Ì∂jÛOıó#S? ¡ãâãÉbål<{x∏ˆ„J,€¶)¶=ê@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÕóÖáüfqÛqmeÿ´Æ’⁄\"∫uÛÈ1=>êVõœÖõfW›ü\"Ω∫ÙÙ∆=ÕnYôÛDœ«Oæ}@©7ûVﬁˆ\Z™˚˛Qb\'Js-|vgÕÒ«Væi“Aœ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0’Wr™h¢ôÆ∫ÁJh¶5ôôÚD@;çß√Œc‹¯kªèf=]?7*föΩñ„ZΩÒ\0¥6èˆøÜÊt‹›Ø””ˆø≠}ÈüÁLÇ¿±èc’61¨[«≥G‘≥jò¢òıSLD@>¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0‰ƒLLLk—1>Pq{ø ÚÊÌ«\\b~Ô…´ßÁ‚ioßO-\ZMÈË◊“\nªw√|¡‚π∑\\∑ªXéò¶ü≥Ω˘ïNìÏ´_@+Ãú\\ú;’cÂ„‹∆øG◊≥vô¢®ı≈QÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&ª∏†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\'6Æ[ﬁ˜©è›€}€÷ÊtúâéQß_⁄U•>ÕAgÌ>—77Ω√é|∏∏ùÌπ\\kÓß⁄;kÿ6}ñû∑oµçVöUz#äÂQÊõïkT˚¡.\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0vŸ∑Óv¶∆·ág2ﬁìM⁄b©ç|¥œ\\O¶ZÓ˛m˘Wvl∫.OLc^÷ÌØTUıÈˆÒÆ›˘?ò6^:Ú*πèFø„,}≠Ω#À34«ÁDò\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ë∆ƒ ÕΩN>5‹´ı˝[6®öÍüe12hø{Õ·ππ]∑µYûû\næ÷ˆökı)ù#€VæÄZG rﬁ’√\\‚~»ßßÁÂÈsß—FëDz:5ÙÉ¥ààààç\":\"#»Ë\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Âw~KÂ›Áäºå\nldW◊óçˆW5ÛŒë√T˛tH*Ìﬂ¬Ω”äÓ—ïoq∑1bÊñÆ˙¢fx\'◊¨zÅ[fÌ˘€mÈ«œƒªáz:®ªD”3x◊Æ=0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0¨⁄9\'ò∑û\nÏ`Œ6=]YYZ⁄£IÚƒLqU®êZGÖ{^7›ﬂ*Ê„v4ô«∑≠´^òôâ„ü^±ÍëÉ∑`m∂b∆%¨;]\Z—jàß]<≥1”3Èê{\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|¨L\\€Sc3\Z÷Uä∫fÕÍ\"∫uÛÈTLπ›¸.Ÿ≥8ÆmóÆmWßßÂÙ›≥?…™x£_E^¿U€ø\"s—«]x}∆ß˝N&∑#NΩfù\"∏”À3\ZzA«utOD«\\\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ÆÓ(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	ªh‹˜kø+m¡Ωô\\NïM∫gÜù\Z©¯iˆ»,Õ£¬úÀº7w¨Íq(ù&qq˛“ÊûXöÁ·¶}QP,˝£î∂\róÜº-æâ»ßI˚›Ô¥ª¨yb™æØÚb“\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ü›˘[bﬁ¯™œ€Ì’~®ˇ\07oÏÓ˙\'éù&tÚk¨Æ›¸(…∑«wdŒß&éôåLüÇΩ<ë«√3ÎäAYn[>È¥]˘[ñ\r‹J¶f)™∫~\Z¥¸Z„ZjˆH#@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0~Ë∑]⁄È∑näÆ\\Æt¢äbff|—ÎhÁò∑.ôi⁄±ÍÎπì—sO.ñ£‚◊Û¥°¥xkÀ˚wÃ»Øv»ßIôø⁄÷<±nü¡T»;Î6,„Z¢Œ=ö,Y∑\ZQj›1M4«¢#HÄ}@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÛΩfŒE∫ÏﬂµE˚7#KñÆSSTy¶\'XêpøÜª„«s\n+⁄2*È÷œ≈kYÛ€™~äfWn˛Û◊«rÕà›1©È˘∏Ω5ÈÈ∑?æ≠A¬◊EvÍ™ãîM”:UEQ§ƒ˘¶$ê\0\0\0\0\0\0\0\0\0\0\0\0\0\0]‹P\0\0\0\0\0\0\0\0\0\0\0\0\0ˆ”ÀÓı1;~›vÂ©ˇ\0S\\pZÙ¸uiÍéêY˚OÖh·πΩÓvØ..\'√O∂ÂQ¨˚)èX,Ì≥c⁄6z86ÕæŒ\'Fï\\¶5π1Ê™∫µ™}≤	P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0>È∞l˚’<;ñﬂk&®ç)Ω1√r#Õ)“®èF†¨7\n#‚ª±Ó\ZO\\beˇ\0 #›≠>–VØ/o[-Sñﬂwçtã˙qZüU ußŸ®!@\0\0\0\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\0\0\0\0ß/:Ùc·c]ÀøWU´TMuzÙàêXªGÖ€Œg\rÕŒıΩ™Ãı€Ëª{OÕ¶xc€W∞Ü”»|∑¥◊NgdS˛£/K≥Ï£H¢=⁄É≤ààààç\":†\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ê™iÆö®ÆòÆä‚b™f5ââÎâÄqøáºπ∫q\\∑è;fM]?7JiôÙ€ùi˜Dz¡Wn˛Ô€Ã£v«ßY˚/ÇÓëÁ∑TÙ˙©ô}~≈¸kµY»≥^=Í\'JÌ\\¶i™\'”§É‰\0\0\0\0\0\0\0\0\0\0\0öÓ‡BÄ\0\0\0\0\0\0\0\0\0øh‰ncﬁ8k∑Ö8xıt˝Á/[TÈ1¨LS15LOû ~—·f”ã√su»ππ›éô≥N∂¨˝≈>¯ı»√¡¬€Ï∆>-¨K1”ÚÏ—DœûtÎüLÉ‘\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0˝«i€wk_\'r¬≥ôDD≈?2òö©◊ØÜÆ∫}í\nÀwßÔ›ó6¨JÁ¶ú\\çk∑Øö+èäòı≈@´˜~Sﬂ∂IÆ¨Ï\n˛E?ÍÌ}•≠<ÛU?W˘Zú\0\0\0\0\0\0\0\0\0◊w\0\0\0\0\0\0\0\'∂ÏªÆÒsÂÌ∏≤ÁXä´¢üÇôü∆Æt¶ülÇÃ⁄<(…π¡wzœß\Zâ“j≈∆¯Î”ÀrØÜ\'’–⁄9WaŸ8*¡€Ì≈˙c¸›œ¥ªØû*´]5¸ù–Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\09\rﬂëπsx‚ÆÊa‰U˛ßKU{b\"iü\\∆†´∑w|N+õVEΩ“‘t≈©“’ÔuS√:~w∞Œ^fÈ±õãwÙu⁄ΩD—Vû}& P\0\0\0\0\0\05›¿Ö\0\0\0\0\0ÙµjÌ˚îZ≥n´◊nNî[¢&™™ü4Dt»;Õ£√~a‹∏.e[£i«´Iö≤?iß¢›=:˙*–Ü—·ø/m‹72≠◊ªdS§Òdt[âè5∫z4ÙU5ºµj’ãt⁄≥nã6®ç(µDE4ƒy¢#¢Ù\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ys0p∑3èùãk.ÃÙ¸ª‘EqÁçzß”\0≠˜6úÆ;ªNEÕ∂ÙÙ≈öıªg’”<QØÆ}@´∑~HÊ=üäªÿ3ïèN≥9X∫›£HÈôòàä©àÛÃ@9 \0\0\0\0\0]‹P\0\0\0–Ì<´øo|5`m˜*±W˙´ügkŸ]ZD˚5°¥xQçoÇÓıüVEq”V./¡FæiπTqLz¢êY{nÀµlˆ˛^€Åg&4™∫)÷∫£Ú´ùjülÇP\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0÷Ô ;˜«Vf‰W¨˝ÚœŸ›÷|≥U?[˘Q ´˜\ns¨Ò›ŸshÕ∑\ZÕ8∑Ù∑w—_’™}| ¨˜\r´q⁄Æ¸ù«\nˆŒûπLƒUßñö∫™èLH<\0\0\0\0öÓ‡BÄ\0\0∆‰P˝˘ï˚œ>ﬂ˝”á^ënØÎÓ«OÊ«]^Ô>Å¢b\"\"\"#HéààÚ˙\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ç¸||´UX…±o&Õ^Õ⁄b∫g◊MQ1 Ã¸ÒÀﬂ˘yπEä8v¸ÿõÿ=zS?Ω&~ç∆Ä\0\0öÓ‡BÄ\0\0üÂΩá#ò∑K8u¢◊◊À»”X∑j:Á◊=Qpj|,,mª‘Y∆∆¢(µn<ë<œ\\»=@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0GùvﬂˆKˆ≠Q≈ùáÆF«\\◊Lt—¸∏ËıË∫\0\0kªÅ\n\0\0˝QEwk¢›∫&ÂÀïE6Ë¶5ôôù\"\"#À ‘\\ùÀv˘sj¢ÕtƒÓZ\\‹.∆ìÒi—DLy(ÍıÎ>PuÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Õ^!l?π∑€óÏ—√Ö∫ÒdX“:)Ø_µ¢=S:˙¶¬\0\0&ª∏†\0g√[˚÷U{˛]ΩlaU4`S1—UÌ:kıQ—Èı˜\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0á<lø6õV®„Ã√ˇ\0á—”5Q˘‘Î\ZyÙ^\0\0Mwp!@ªm€ÔÓπ¯õv,k.‰[£Õ\Zı’:y)çf}\0÷õfﬂèµ`bmÿ¥ÿƒ∑QÁôÎößO-S¨œ§‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]Á}ó˜\'0eŸ∑G._¯úM:¢ãì:”õTLzÅ»Ä	ÆÓ(\0π¸*Ÿ\"~˜øﬂ£Yß\\lü\'ñÂQÙDO¨H\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n”ƒ˝üÔ€%Ω ›:ﬂ⁄nqWß\\Ÿπ•5˚ßÜ}ZÉ=\0	ÆÓ(>ñ≠\\øv›õTMÀ∑™ä-—uUTÈππŸv€{>’Å∂[“c‘QUQ’U}u’¸™¶d`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0>X÷≥1≤1/”≈c*›vØSÁ¶∏ögËêd¸;ª~v^˝>nÍÏ‹òÍô¢©çc—:»	ÆÓ(;è6ÿ‹yü™È‚µ∑SV]œ]\ZEÍÍ¶A¶\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0xÒCm˚ß0QùM:[›,S\\ŒöGÃµUË¶}†≠Å5›¿Ö›·&F>Ò∏’GMÀñÒ≠WÊ‡âÆ∏è_ ∏Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0a‚¶ﬁ6<\\Íi÷Ωø&\"™º÷ÔG˛¥R¸	ÆÓ(4oÜ6b◊+—\\i˛#*ı…ˆiGÙAaÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0oú1~˘À›ù5·≈™ÙG¶Œóc˘† `öÓ‡BÉI¯k1<©â§Î•ÎÒ?ß Ô@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0nÛLU¥n¥’\Z≈Xw‚c—6ÍA◊w˜Öt›Ÿs∞ı˚LLπÆcÚ.—?M5“\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|ÕïF/oY’√√ávö\'ÚÎ¶h¢=µL%ÇkªÅ\n√m‚ù∑åKµp„Ó‘|âôûàª≠©ˆŒ¥«¨\Z8\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0S\'Û%™Ì—À∏wb∫∏‚ÓÁU3¨GMß”Ø≈>m ∞&ª∏Œﬂ¸Œ?˘/⁄—˚⁄u«‘¸Ø04øh⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†h⁄\0vÄ†hÈ˛˙°˛˙˚ËÔ†¸O\\ˇ\0‚ƒŒ–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0;@–¥\0Ì\0|2øÀ_ˇ\0≈~•_±˝ßWÒ=>`f€ﬂ∂ª˛GÎ’˚OØ◊¸oOú.Œø˚á˘¯{ˇŸ','09178888888','FEMALE','a@y.com','SFA','SDF','DF',2000,'CURRENT');
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
INSERT INTO `tenantguardian` VALUES (1,1);
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
INSERT INTO `tenantroom` VALUES (1,1,'2014-08-26','2015-08-26');
/*!40000 ALTER TABLE `tenantroom` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2014-08-29 23:49:55
