-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: bj-cynosdbmysql-grp-n1ox8dpy.sql.tencentcdb.com    Database: rentingSystem
-- ------------------------------------------------------
-- Server version	5.7.18-cynos-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f384490b-a29a-11eb-9ec0-b8599fe4feca:1-152';

--
-- Table structure for table `House`
--

DROP TABLE IF EXISTS `House`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `House` (
  `houseId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `managerId` int(11) NOT NULL,
  `city` varchar(16) NOT NULL,
  `district` varchar(16) NOT NULL,
  `village` varchar(32) NOT NULL,
  `address` varchar(64) NOT NULL,
  `floor` int(11) NOT NULL,
  `floor_sum` int(11) NOT NULL,
  `floor_lift` tinyint(4) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `type_bedroom` int(11) NOT NULL,
  `type_livingroom` int(11) NOT NULL,
  `type_bathroom` int(11) NOT NULL,
  `area` decimal(5,2) NOT NULL,
  `description` text,
  `houseToward` varchar(16) NOT NULL,
  `facilities` varchar(256) DEFAULT NULL,
  `requirement` varchar(256) DEFAULT NULL,
  `personnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`houseId`),
  KEY `userId_idx` (`userId`),
  KEY `managerId_idx` (`managerId`),
  CONSTRAINT `managerId` FOREIGN KEY (`managerId`) REFERENCES `Manager` (`managerId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `House`
--

LOCK TABLES `House` WRITE;
/*!40000 ALTER TABLE `House` DISABLE KEYS */;
/*!40000 ALTER TABLE `House` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manager`
--

DROP TABLE IF EXISTS `Manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Manager` (
  `managerId` int(11) NOT NULL,
  `managerPwd` varchar(16) NOT NULL,
  `managerName` varchar(16) DEFAULT NULL,
  `managerIcon` varchar(1024) DEFAULT NULL,
  `houseSum` int(11) DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manager`
--

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rent`
--

DROP TABLE IF EXISTS `Rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Rent` (
  `rentId` int(11) NOT NULL,
  `houseId` int(11) NOT NULL,
  `userrentId` int(11) NOT NULL,
  `managerId` int(11) NOT NULL,
  `tenancy` int(11) NOT NULL,
  `startDate` datetime NOT NULL,
  PRIMARY KEY (`rentId`),
  KEY `userId_idx` (`userrentId`),
  KEY `managerId_idx` (`managerId`),
  KEY `houseId_idx` (`houseId`),
  CONSTRAINT `hId` FOREIGN KEY (`houseId`) REFERENCES `House` (`houseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mId` FOREIGN KEY (`managerId`) REFERENCES `Manager` (`managerId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `uId` FOREIGN KEY (`userrentId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rent`
--

LOCK TABLES `Rent` WRITE;
/*!40000 ALTER TABLE `Rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `Rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `userPwd` varchar(16) NOT NULL,
  `userName` varchar(16) DEFAULT NULL,
  `userIcon` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-03 13:47:54
