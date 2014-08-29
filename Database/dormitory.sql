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
INSERT INTO `tenant` VALUES (1,'SF','ALBAYDA','1980-04-07','����\0JFIF\0\0�\0�\0\0��\0,Photoshop 3.0\08BIM�\0\0\0\0\0\0�\0\0\0\0\0�\0\0\0\0��.http://ns.adobe.com/xap/1.0/\0<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"Adobe XMP Core 5.3-c011 66.145661, 2012/02/06-14:56:27        \">\n   <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n      <rdf:Description rdf:about=\"\"\n            xmlns:dc=\"http://purl.org/dc/elements/1.1/\">\n         <dc:format>image/jpeg</dc:format>\n         <dc:title>\n            <rdf:Alt>\n               <rdf:li xml:lang=\"x-default\">Default Photos</rdf:li>\n            </rdf:Alt>\n         </dc:title>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\"\n            xmlns:xmpGImg=\"http://ns.adobe.com/xap/1.0/g/img/\">\n         <xmp:MetadataDate>2014-08-05T21:46:29+08:00</xmp:MetadataDate>\n         <xmp:ModifyDate>2014-08-05T13:46:32Z</xmp:ModifyDate>\n         <xmp:CreateDate>2014-08-05T21:46:29+08:00</xmp:CreateDate>\n         <xmp:CreatorTool>Adobe Illustrator CS6 (Windows)</xmp:CreatorTool>\n         <xmp:Thumbnails>\n            <rdf:Alt>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <xmpGImg:width>256</xmpGImg:width>\n                  <xmpGImg:height>256</xmpGImg:height>\n                  <xmpGImg:format>JPEG</xmpGImg:format>\n                  <xmpGImg:image>/9j/4AAQSkZJRgABAgEAlgCWAAD/7QAsUGhvdG9zaG9wIDMuMAA4QklNA+0AAAAAABAAlgAAAAEA&#xA;AQCWAAAAAQAB/+4ADkFkb2JlAGTAAAAAAf/bAIQABgQEBAUEBgUFBgkGBQYJCwgGBggLDAoKCwoK&#xA;DBAMDAwMDAwQDA4PEA8ODBMTFBQTExwbGxscHx8fHx8fHx8fHwEHBwcNDA0YEBAYGhURFRofHx8f&#xA;Hx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8f/8AAEQgBAAEAAwER&#xA;AAIRAQMRAf/EAaIAAAAHAQEBAQEAAAAAAAAAAAQFAwIGAQAHCAkKCwEAAgIDAQEBAQEAAAAAAAAA&#xA;AQACAwQFBgcICQoLEAACAQMDAgQCBgcDBAIGAnMBAgMRBAAFIRIxQVEGE2EicYEUMpGhBxWxQiPB&#xA;UtHhMxZi8CRygvElQzRTkqKyY3PCNUQnk6OzNhdUZHTD0uIIJoMJChgZhJRFRqS0VtNVKBry4/PE&#xA;1OT0ZXWFlaW1xdXl9WZ2hpamtsbW5vY3R1dnd4eXp7fH1+f3OEhYaHiImKi4yNjo+Ck5SVlpeYmZ&#xA;qbnJ2en5KjpKWmp6ipqqusra6voRAAICAQIDBQUEBQYECAMDbQEAAhEDBCESMUEFURNhIgZxgZEy&#xA;obHwFMHR4SNCFVJicvEzJDRDghaSUyWiY7LCB3PSNeJEgxdUkwgJChgZJjZFGidkdFU38qOzwygp&#xA;0+PzhJSktMTU5PRldYWVpbXF1eX1RlZmdoaWprbG1ub2R1dnd4eXp7fH1+f3OEhYaHiImKi4yNjo&#xA;+DlJWWl5iZmpucnZ6fkqOkpaanqKmqq6ytrq+v/aAAwDAQACEQMRAD8A6vil2KuxV2KuxV2KuxV2&#xA;KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2K&#xA;uxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2KuxV2Ku&#xA;xV2KuxV2KuxV2KuxV2KuAJNBuT0GKo+30HV7gVjtnCnu9EH/AA1MUI5PJ2rMKlok9mY/wU4qvPkv&#xA;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&#xA;uxV2KuxV2KuxVIvOEsa6WsbEc3kXgvfatTir/9k=</xmpGImg:image>\n               </rdf:li>\n            </rdf:Alt>\n         </xmp:Thumbnails>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:xmpMM=\"http://ns.adobe.com/xap/1.0/mm/\"\n            xmlns:stRef=\"http://ns.adobe.com/xap/1.0/sType/ResourceRef#\"\n            xmlns:stEvt=\"http://ns.adobe.com/xap/1.0/sType/ResourceEvent#\">\n         <xmpMM:InstanceID>xmp.iid:BB20DCCAA61CE4118EEE8C922D5077CA</xmpMM:InstanceID>\n         <xmpMM:DocumentID>xmp.did:BB20DCCAA61CE4118EEE8C922D5077CA</xmpMM:DocumentID>\n         <xmpMM:OriginalDocumentID>uuid:5D20892493BFDB11914A8590D31508C8</xmpMM:OriginalDocumentID>\n         <xmpMM:RenditionClass>proof:pdf</xmpMM:RenditionClass>\n         <xmpMM:DerivedFrom rdf:parseType=\"Resource\">\n            <stRef:instanceID>uuid:46e5ab95-0d1c-4495-877e-e5723467b732</stRef:instanceID>\n            <stRef:documentID>xmp.did:D3F8A651A21CE4118026AF5055624C80</stRef:documentID>\n            <stRef:originalDocumentID>uuid:5D20892493BFDB11914A8590D31508C8</stRef:originalDocumentID>\n            <stRef:renditionClass>proof:pdf</stRef:renditionClass>\n         </xmpMM:DerivedFrom>\n         <xmpMM:History>\n            <rdf:Seq>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <stEvt:action>saved</stEvt:action>\n                  <stEvt:instanceID>xmp.iid:D3F8A651A21CE4118026AF5055624C80</stEvt:instanceID>\n                  <stEvt:when>2014-08-05T21:28:30+08:00</stEvt:when>\n                  <stEvt:softwareAgent>Adobe Illustrator CS6 (Windows)</stEvt:softwareAgent>\n                  <stEvt:changed>/</stEvt:changed>\n               </rdf:li>\n               <rdf:li rdf:parseType=\"Resource\">\n                  <stEvt:action>saved</stEvt:action>\n                  <stEvt:instanceID>xmp.iid:BB20DCCAA61CE4118EEE8C922D5077CA</stEvt:instanceID>\n                  <stEvt:when>2014-08-05T21:46:29+08:00</stEvt:when>\n                  <stEvt:softwareAgent>Adobe Illustrator CS6 (Windows)</stEvt:softwareAgent>\n                  <stEvt:changed>/</stEvt:changed>\n               </rdf:li>\n            </rdf:Seq>\n         </xmpMM:History>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:illustrator=\"http://ns.adobe.com/illustrator/1.0/\">\n         <illustrator:StartupProfile>Print</illustrator:StartupProfile>\n      </rdf:Description>\n      <rdf:Description rdf:about=\"\"\n            xmlns:pdf=\"http://ns.adobe.com/pdf/1.3/\">\n         <pdf:Producer>Adobe PDF library 10.01</pdf:Producer>\n      </rdf:Description>\n   </rdf:RDF>\n</x:xmpmeta>\n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                                                                                                    \n                           \n<?xpacket end=\"w\"?>��\0Adobe\0d�\0\0\0��\0�\0		\n\n				\r	\r��\0\0��\0�\0\0\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0!1��AQaq��\"�2#�Rbr��3�B���Cs�$4Dc����S���%56��Tt�F\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\0\0\0?\0�\0K\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���w*�EW*���3�KY���\0\"\"�;.u�j�,\\��)�@JY�Nm�\Zѳ\\�:�һV��]t��O���V��ۣOƿo��T��O��U13�L��U��S0���s7����\0���s7����\0�7���_�\0ig��?����DkN����ߵ��U\0���a��ٲ袈ֻ�ڪ�\"=5SH!*��*�k�i�:��c��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0om��v᝿k�~�]W��W�?H;�\nw{�5n��4OL�DM�蘎\Z}������j˽��\\}jj�-۟eG����Y,l����:}�x���ٱD[�j�6㪋t�1�}\0\0\0\0\0\0����͈�7�]1�޷M��h�r���dU?�c�_�c�U�=T�4�\0�3|$îfv�������E�n�?�Lѧ��o�ˍӏۅ>H�w��l]�#� �v\r�n�ݫ+�gI�U��?N\"i�A\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0݁�n���۰��]��n���:��z�=2;h�2�Swzͧ��gK�4���?\r3�����o.m��ۻz4�\'\">uzǖ&�b����\0\0\0\0\0\0\0\0\0\0\0\0\0\0C�r�ǹqNnՋ~���ٷL\\�8���#��-dUŏ����-]���H�~�~��0�{3r���E����@%(�.R��vj\'�]����=Trw+�LSNǋ1�G���A��ɜ�rbj�1�Oŉ���\0����n��msj�����1��>�AexQ�\\�~靗�_��h�L{8i����;ň���;>�ꢸ�7\'��O��p����l�1�m������M<V�|�r�i�d�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�n��\r�\"�]��]��Zh��bz5���=3 ��q�ż���\0�n�����6��]}U��� �q0�0,S���o��j�1M:��,���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ʩ��j��b�j�����&\'�&�o^���ܳc�^]]W�\"��ʵ�g٤�AMs$o[̽]�����Fu����$ܧ����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��3=PC�<7�ܾ^f�Ƿ`�M�W�G�\'�G�����m�N58�v-�)�-�T��zj�L�=�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��=@�9�Ì-�.f�F֫����D}I�GG��\n#3+oɻ��b�l�3��UƓ���&�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�/rʵ��b����Tu�fg�\"<�=@�\\��8[[��\"��ۮ���ՙ�������i�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0s<���w2����~N]�t�Ϧ>;~]\'���<O�Ii�6|�:�}��z�M�M(���,O�\0	�X\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Wfٳ���x;}��r���\'��tk��\\�\"?�t�Kr�+�����i��Wb>��T|w\'��Ly\">��J\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��N\\��L\n�rb-�[��2#�\\��L�c���A��=�/h����m���z�j�UJ��,Lt�<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0������>�߁o��ޚ���h�:�|������_���\n0�)�V�e�L|wkӮ|�H�{��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��T��p>~5�38�uM�z��ϧ�5�\\�4�MT�4�MTΕS=I�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�����ȳ��j���mS�US�\r?�|���;|Z���g��񪎪i�������T\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��3�~���1�j�Ϣ����W�������\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_��mش����̣����Y��ފ���� ��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��p1�L��.�<|�sn�yc^��|�=1�L�v썣p��r���%ɢ�ꊣ����TLL<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�!r����/d���v��TOU���[���#�\r-��@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ns�]���&�\0b��֘���3�uO�u�g�\0��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0}-Z�~�6h��oUZ�Lk5UT��j�Y��r�э�ѥW�>fe��=꾴���=	�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�t���vf��Y���3��3G�\'I�d\\�k�y9��࿋r�W��UD�3��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0g�a���t��ߢ\'k�,D�EW뎏эgנ4\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\03���Wܷ�s�ӥ���\\��H������gϬ�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0U�����U9S�<�\06�MQ?�\ZS�J\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n��ݶ39rr�&��z��W����u�{f\'��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0:�Kڣw�=��8�Y��91���k��}U�>�j`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�ܰ��v��\n���ǹg�zb8�b}��}U5QUTU5Q3S>I��~@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0t�K����OL��+�}���`.p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0R��?��.���Sy���TS{�)�u@�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�<3�M�b�cI��z��3p�\n`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05��ٙ1\ZMVlL��\\G��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��򘧔6���k���|���F��j\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0͞%꼿�l2�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Qr%3G)l�>[w\'��v��u�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��W������� \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05o(��<����î%������ۮ���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�ĸ�欙����Y�f|���G���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\\�|��d���5:O_E�`�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0������\0���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\06>����X�c�Y�oI��i����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�~*�M<ǍTGM;�Uz�e��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��Gͽf�_̮�z}3�6X\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\nň���yg��e۟�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0/�Z����fz��c�W�nS�5�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\nŪ&7]��EX�Sy�k��٨*p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0?%ٜ�i�(�ׇ&.uk�8��\0�\rR\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��vޗv���FM:~l۟��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��ojnsf\rzL��w��kn�?�\r*\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��v�q�:���ȧ�O��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0hxQj+��n�k�k��4�r��D�@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��Y��˷^��<���ۮ�\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�����ܙ���q��>��d�� P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n��s_,�W��e����k��A��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_���&��k��G�ݺ&>���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0+�;qs�wI�Y�6+��z���d�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���,r�\r~\\������D}�;�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�8Y����Q��8����\0g��\0DL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��Lx�孎�yp�\\�]�x��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�����7[\Z��;��<�V�d\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�j��h�5����=2\r��f�l{�}K�G������\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��LLLk�1>PcK���۶���uS>��0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\01���l��F�]ͱM���8���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0I�K?#�7�Q\ZSFvG~Lܪc�(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�<:���ٷU��N=7�����T���i�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�y��c�n�Ɣݪ����v�����\Z\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0-	����t��Zq�i�3曵�Q�[�_ \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0=x�����1ѓ�n���U5�O��h\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0/�	�x6��7˓�M�e�\"��@[\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��s\"��.#�/ڹ>�ટ� �@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���1�Om�4�&n޹���E3�1\0�@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0e�?���[�N�cfѭ^jk����@g�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���I�ڶ�)�)�ͪ�?\Z�\"\'��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�9��<����U�(�O��ܦ��tH2�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0%6<H��v�9��9vm�1ӥ3\\qO��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r�\Zsv�����Žf#�r���A��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�xo�9<Չs���+Wo��?.\'���i@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0y����a���˽n���Ms>�`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��L8���|�MZǷ?�3]ͤ`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��,b�^�4��FLZ�Di��DU>ڢAĀ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��a�7,[�1���]��ҙ�Q��X@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0(��&��i�ӣ#�>�U���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�v/��&Յ4�W��j���\0�ቯ��A.\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��W/lX�qL�xyt����5D��R�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���x�;^ƴ��ڢ�F��S�A��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��$���f#Y�oG�����*�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0,?p����dL|;~=����U*#��}�Ѡ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�]�E�w,ܦ*�v���3妨�`�+�L��[���k�ڹj��i���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���<;��TF��Ƿ>X�T�U�8��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0{�0���[�4��ӓDϗ��U�� �\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��|����ڪ����_y�1���5ӯ�)��u�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��k�7i�b:/ٯ�Dګ�5�����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����<�̿n��TS��\r�n�m۵j��ݪb�tGTSLi��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0W�&���kȈ�-�\"��|�5O˘�Ӊ�9\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����эr�b�{}��5���8)��UăJ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0#������o����{��ת*���d� �311��Dă�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���u���\"����n8��L��[�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\02�7`~��M�)�h��WmSQEﴦ#�hp\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��ݿ�g-m8�+��ti<W��b}1ŧ�8\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n#ō��n[v�M:S�b�7&?���⸏`*`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�ˁ;��m�1��E4�&~9�S��]�DDDF���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�V���Y�~����v��z:f��\n��V��f�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��f����#p��h�,O^k���?V*�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�;�~^ދY�k�r|�]3L��}~��k���S�{�V��>J��&=��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ўm�r��˪�.�w�������QD�z�b\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�������릞;�4�����_��2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0l{r�,bا��M�mY�<�W1LG�A�0q-�ab`����,۟<QLS>��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0G��g��0wJ)ּ�j��Wz:&g�U1�P�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�8��\0xs%����gl�����㏆�z��_`4�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\'}�i��}�m����Sjg�.G�ng�TD�#UL�T�TM5S:U�\0�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�~mt��n5ӥ����O�+Z�O�M@�@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0f.~ڿu�.o\r<63�˱�\0K����`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�j���mY�L�v�t�n�뚪�\"#�\r��[�v�,Zpa٢�LF���D϶zA�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Tx����t��k½6��G�w��g�U1�P�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ϐ6��ѷ�L�k�.�O��\'��i�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Bs���b�p\"����z�M1�G�o���d�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��.ߥ��u���U�j���M �\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0L�}��^�\0�aE<ZȮ�4������Z�@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Pr��V�)���TNU�����C��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�|V���u4pџ��U^{�j�V�AV�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0щ�s3+�kw*�mG�WTSL�aٳoͫ��b�mۧ�M1�G��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���1a�ͦ���2i��n�M3�� Ϡ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\n3y�l�����My���t��?��4�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��8����\Zu�qk�DG��_iL{f�O\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��&f�OGɳo�Oͫ�}�.x�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0?�TM5DUMQ�T�LLH1��V~n[��5z��4�\0\0<`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\04?��#�n��\ZU��r�k��DE�*�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\00s�$bs^�M1���>��E5U?��8�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\Z���~��%�-X�ޘ�����Ҁ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��Xƚ7��.)Ҝ�O����uL��*�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�*�]�骺��c�3�6F=�1�XǷ�;�G������\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n�żi�g�Ӣ�E�3>��EQ�\0V\n,\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05�v#\'�6[G����LWW�\0��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�|MǛܭr�F�tɳv}\Z����3�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����^�ݫX֛_:��\0&�z}:N\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��3�7�\"5�M�?������e�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��e��̗nO�|+��:k�5�G����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\071[����Q1`d�k���}��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��%�3�n�t�(Ċ8���g� �@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�ܭ�ݻ>�O�ƻN�mh�<\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\\�[���w_�F5>~)�:��.�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|�����ڙዔUN�mc@c0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���\0��\0�����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���m�UuΔQUS��c\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��\rT�\\�F�Q�TG�>lO�]@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�nŬ�D�6���TG^�L�1�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���g��1h���W��{�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��ŝ�{�3�D��O˫N�X2@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���.�~g��_�n٧�N�\r\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0č.Xɳ��w���ǗMx�<�S���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��s�훆�g���.�O�xgY�}\0�8Y�7Ll�j����v�^��^�4ǖ�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�<F��������ǅ��Vh�:��3��G�\"�f�PW�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0-�\r���K����ا�sV�z��(�W]���U=1����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0V���4m�6�����M:]�D��۪:����:��~mC<�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B��6v����Ҍ]ι��Mٞ���/���B��鎠\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0V<��>�Mݻg�NN��E܈ҫv<����7Ty|��o^��v���*�z�SU˵��US=s3=2�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��~�v/���Ÿ�t�j��[T�\0��|�������Ͽm[폟��S{H�[3�ܢ|�Q=1���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\"�m�l�1�#rˣ\Z���tOMu�y(�:g�\n3��E�7x����{f�TM5���b\Z����l�+p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����¿FN%����[w�U4���Z[\'�y��w�hε\ZD�و��y�i袯g-����M�w�۹vc�����&t��@\'�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�s&ɲSW��v��tcS<wgX�>\nu��<���<T�Ȋ�lX�q�=|��wf?&��i������ͽ^NfE̬��^�ڦ��� �\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�4�UL�LN�1��j��e�xh�7�)��ˉ�\Zuikƞh�6���w���o��_DM�h��3�T{5}�s&ú���~��Jl�\\&�����`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0}ǘ6]�*����WO]��*���:�>�p;���]�*6�+��Ʊ����D�t�>��s���2�T}��*��&߾�f��35L�T��γ3�2�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0o�7�0wl�4Q:�fk����z�����O��Nf>.}1?SLۮ}�Oꃮ��ci�ѝ���U>[SE�c�3���Q��|���n���W]�֞�����G����\Z���ˍ5���nF�ə�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��Qj��]��tS�UuLDG�d���X1�#z��:�_Ϊ=t��r��*l8����Ϯ>�QLZ�>ڧ�?D�w����*p6�l*j�\"��U����S�^�͜ǹ�F^�U��J�۫�Q1�-���`�_L����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�111:LuLW�0�)���,QV�\\S�:�	� �n<E?�>u4�E�V��m\\<_H&����DE�L�u��r���^�@%���r)��ة��-v�&���?��|Y�*�\01�fZ��m��5P	~(��sT�Y�b&k�L���k��~\"�q�[�V�]8j�{__�D�;l�v-d�ޢ�=�b�W��i�\'��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0v�=�b�T��b�~&m[��s��MS�1{��W�3�s\'#�n����E�x��S�Wl̽?�fݿ�U`���s&��d�j\Z��}�G�&O��~4��~�V���\0�U\\}\0���>i˙���M\Z�\0��c�j)=\'#&����s\"���s\\��d\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��0���gbȹ3��V$U=�S\Z�h�\"}��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r�p���ٛ�G��Ur�z����Lzj�\"�w=�+w���3n|̌�檼�ǒ�|��\0�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ݶeU���f�:U��j�\"�����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0_�t��10h�i������j8�?Ji�g�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���u���k\Z[�~�_�h����:\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0=X6*���Ʀ5�\"��tǦ��?�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Q>-QTn[M��Ս]1립g��*P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��V$�sN�j:����?�D���58\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��]��\r莟�4U?��)p\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0kxO��]�p���0���>J�U�1��&=���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�<\\��rb5�6)��M�+��@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\r���.[�&�t��ޮ�ϗ�>\n#�fc�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0r��9���SM<Uآ��z>Ut�T��H2�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0k��\n\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0sn��v�\r���u}[�O��+��k��N�����l\Z*����z�>�������M�Q�7<����E��1r~�M��ߔ�F�0���n_�̪�z��(�i���:�m{_���\0���v4��w\Z\Z���?�Up7�]����u�ƟſE7��~^�H-<LkXX��v#K8���j?&�b�� �\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��ƣ7+��o.�vk��\\�i���ooο~�.>����+�f�U�D�1�12	���9:|��\"�t��E���&�{�þo�uڢ�^E�� �W��\07�L�;<�G\\Sz�S ���|�c^=�6xz�U\\�} �����WE��+�[��3|@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\05���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�oڷ���۰��]��t���U]TǦd~��N]���u8�N�8��WsO,Ms�����Y�_\'����V.�n����&�\0���?�^�L�l@:`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�(�4���&ff\"4鞙�h?@\0\0?5�E�f���tU�UF�>��@fr�-gF�..�:�v��5O��|3���d��V^Ns�i�����:U���w����+����i���r}tץ?�;j��ʢ����՛�ULU��1��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Wj�7]����0�d��ˑ\Z[�_Ʈt�=��c���������8vfh�髢���h-\\L\\+4c���űGԳj����F��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��v��U��Sr�q�v눚f<��3t��\0�w>*��}���Ø���M�\n�u�x�⹵�Z��GU����uS4��{]f`�����v-�K��]�&��ƽp \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0߷�[��w���W�.��3�媮�c�2g�|.�+��uN��j�O��#�S?������b�l<{x���J,ۦ)�=�@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0͗���fq�qmeث���\"�u��1=>�V�υ�fWݟ\"�����=�nY��D��O�}@�7�V��\Z���Qb\'Js-|vg���V�i�A�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�Wr�h�����Jh�5���D@;����c��k��f=]?7*f����Z��\0�6�����t�ݯ�����}��L����c�61�[ǳGԳj����SLD@>�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��LLLk�1>Pq{� ����\\b~�ɫ���io�O-\ZM����\n�w��|�⹷\\��X��������N��_@+̜\\�;�c���ƿG׳v�����Q�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0&���\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\'6�[������}���t���Q�_�U�>�Ag�>�77�Î|����\\k��;k�6}���o��V�Uz#��Q曕kT��.\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0vٷ�v���g2ޓM�b��|��\\O�Z��m�Wvl��.OLc^��TU�������?�6^:��*��F��,}��#�34��D�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Mwp!@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0����ͽN>5ܫ��[6���e12h�{�ṹ]��Y��\n����k�)�#�V��ZG r���\\�~�ȧ����s��F�Dz:5􃴈����\":\"#��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�w~K��犼�\nldWח��W5�Α�T�tH*��½���ѕoq�1b斮��fx\'׬z�[f���m���Ļ�z:��D�3x׮=0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��9\'���\n�`�6=]YYZڣI��LqU��ZG�{^7��*��v4�Ƿ��^����^�����`m�b�%�;]\Z�j��]<�1�3�{\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|�L\\�Sc3\Z�U��f��\"�u��TL���.ٳ8�m��mW����ݳ?ɪx�_E^�Uۿ\"s��]x}Ƨ�N&�#N�f�\"���3\ZzA�utOD�\\\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	��(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0	�h��k�+m���\\N�M�g��\Z��i��,ͣ˼7w��q(�&qq���X���}QP,����\r���-��ȧI��ﴻ�yb����b�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[b�������~��\07o���\'��&t�k����(ɷ�wdΧ&���L���<���3�AYn[>�]�[�\r�J�f)��~\Z��Z�Zj�H#@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0~�]��n��\\�t��bff|��h�瘷.�iڱ�빓�sO.�������xk��w�ȯvȧI�����<�n��T�;�6,�Z��=�,Y�\ZQj�1M4Ǣ#H�}@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�f�E��ߵE�7#K��SSTy�\'X�p�����s\n+�2*����kY�۪~�fWn����r͈�1�����5��?��A��Evꪋ�M�:UEQ����$�\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�P\0\0\0\0\0\0\0\0\0\0\0\0\0�����1;~�v��\0S\\pZ��uiꎐY�O�hṽ�v�..\'�O��Q��)�X,�c�6z86;�\'F�\\�5�1檺��}�	P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0>�l��<;��k&��)�1�r#�)Ҩ�F��7\n#⻱�\ZO\\be�\0�#ݭ>�V�/o[-S��w�t��qZ�U�u�٨!@\0\0\0\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\0\0\0\0�/:�c�c]˿WU�TMuz�X�G���g\r���������{Oͦxc�W����|����NgdS��/K��H�=ڃ������\":�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�i��������b�f5��뉀q�����q\\��;fM]?7Ji��۝i�Dz�Wn�����vǧY�/���T����}~��k�Yȳ^=�\'J�\\�i�\'����\0\0\0\0\0\0\0\0\0\0\0���B�\0\0\0\0\0\0\0\0\0�h�nc�8k��8x�t��/[T�1�LS15LO� ~��fӋ�suȹ�ݎ��N����>���������>-�K1����DϞt�L��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��i�wk_\'r³�DD�?2���ׯ���}�\n�w��ݗ6�J禜\\�k���+�����@��~S߶I���\n�E?��}��<�U?W�Z�\0\0\0\0\0\0\0\0\0�w\0\0\0\0\0\0\0\'�컮�s����X�������Ʈt��l���<(ɹ�wzϧ\Z��j������r��\'���9Wa�8*�����c��ϴ���*�]5��Ѐ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\09\rߑ�sx��a�U��KU{b\"i�\\Ơ��w|N+�VE���tũ���uS�:~w��^f鱛�w�uڽD�V�}& P\0\0\0\0\0\05���\0\0\0\0\0��j���Z�n��nN�[�&���4Dt�;ͣ�~aܸ.e[�iǫI��?i���=:�*����/m�72�׻dS��dt[��5�z4�U5��jՋtڳn�6��(�DE4�y�#��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ys0p�3���k.�����Eq�z��\0��6��;�NEͶ��Ś��g��<Q��}@��~H�=����3��N�9X�ݣH陘������@9 \0\0\0\0\0]�P\0\0\0��<��o|5`m�*�W���gk�]ZD�5��xQ�o����VEq�V./�F�i�TqLz��Y{n˵l��^ہg&4��)ֺ��j�l�P\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���;��Vf�W�������|�U?[�Q ��\ns����shͷ\Z�8���w�_ժ}| ��\r�qڮ���\n�Ξ�L�U������LH<\0\0\0\0���B�\0\0��P�����>��Ӈ^�n����O��]^�>��b\"\"\"#H�����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0��||�UXɱo&�^��b�g�MQ1 ������y�E�8v�؛�=zS?�&~�ƀ\0\0���B�\0\0�彇#��K8u������X�j:��=Qpj|,,m��Y�Ƣ(�n<�<�\\�=@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0G�v��K��Qŝ��F�\\�Lt�������\0\0k��\n\0\0�QEwk�ݺ&�˕E6�5���\"\"#� �\\��v�sj��t��Z\\�.Ɠ�i�DLy(���>Pu�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�^!l?��ۗ��Å��dX�:)�_��=S:���\0\0&���\0g�[��U{�]�laU4`S1�U�:k�Q����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�<l�6�V�����\0���5Q���\Zy�^\0\0Mwp!@�m�����v,k.�[��\Z��:y)�f}\0֛fߏ�`bmش��ķQ�뚧O-S�Ϥ�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0]�}��\'0eٷG._��M:���:��TLz�Ȁ	��(\0��*�\"~��ߣY�\\l�\'��Q�DO�H\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\n������%���:��nqW�\\ٹ�5���}Z�=\0	��(>��\\�vݛTM˷��-�uUT����v�{>Ձ�[�c�QUQ�U}u����d`\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0>Xֳ1�1/��c*�v�S禸�g�d�;�~v^�>n��ܘꙢ��c�:�	��(;�6��y���⵷SV]�]\ZE��A�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0x�Cm��0Q�M:[�,S\\ΚG̵�U�}���5�����&F>��GM˖�W������_ ��\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0a��6<\\�iֽ�&\"����G��R�	��(4o�6b�+�\\i�#*���iG�Aa�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0o�1~��ݝ5�Ū�G�Ηc���`���B�I�k1<������?� �@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0n�LU�n��\Z�Xw�c�6�A�w��t��s���LL��c�.�?M5�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0|͕F/oY��Çv�\'��h�=�L%�k��\n�m❷�K�p���|��������δǬ\Z8\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0S\'�%���˸wb�����U3�GM�ӯ�>m �&������?�/����u����04�h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h�\0v��h����������O\\�\0�����\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0;@��\0�\0|2��_�\0�~�_���W�=>`f�߶��G���O���oO�.������{��','09178888888','FEMALE','a@y.com','SFA','SDF','DF',2000,'CURRENT');
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
