-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: matchcenter
-- ------------------------------------------------------
-- Server version	8.0.19

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

--
-- Table structure for table `bets_rtab`
--

DROP TABLE IF EXISTS `bets_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bets_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `matchid` int NOT NULL,
  `teamcode` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bets_rtab`
--

LOCK TABLES `bets_rtab` WRITE;
/*!40000 ALTER TABLE `bets_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `bets_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventtype_enum`
--

DROP TABLE IF EXISTS `eventtype_enum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventtype_enum` (
  `id` int(10) unsigned zerofill NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventtype_enum`
--

LOCK TABLES `eventtype_enum` WRITE;
/*!40000 ALTER TABLE `eventtype_enum` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventtype_enum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends_rtab`
--

DROP TABLE IF EXISTS `friends_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friends_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `friendid` int NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_friend` (`userid`,`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends_rtab`
--

LOCK TABLES `friends_rtab` WRITE;
/*!40000 ALTER TABLE `friends_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemproperties_rtab`
--

DROP TABLE IF EXISTS `systemproperties_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `systemproperties_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `value` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemproperties_rtab`
--

LOCK TABLES `systemproperties_rtab` WRITE;
/*!40000 ALTER TABLE `systemproperties_rtab` DISABLE KEYS */;
INSERT INTO `systemproperties_rtab` VALUES (1,'BET_TIME','15','Threshold time to stop betting'),(2,'LEADERSBOARD','20','User limit to display on leadersboard');
/*!40000 ALTER TABLE `systemproperties_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teamlist_rtab`
--

DROP TABLE IF EXISTS `teamlist_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teamlist_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `season` varchar(45) NOT NULL,
  `tournamentid` int NOT NULL,
  `teamCode` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamlist_rtab`
--

LOCK TABLES `teamlist_rtab` WRITE;
/*!40000 ALTER TABLE `teamlist_rtab` DISABLE KEYS */;
INSERT INTO `teamlist_rtab` VALUES (1,'Mumbai Indians','2020',1,'MI'),(2,'Chennai Super Kings','2020',1,'CSK'),(3,'Delhi Capitals','2020',1,'DC'),(4,'Kings XI Punjab','2020',1,'KXIP'),(5,'Royal Challengers Bangalore','2020',1,'RCB'),(6,'Kolkata Knight Riders','2020',1,'KKR'),(7,'Sunrisers Hyderabad','2020',1,'SRH'),(8,'Rajasthan Royals','2020',1,'RR'),(9,'Unknown','2020',1,'U');
/*!40000 ALTER TABLE `teamlist_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable_rtab`
--

DROP TABLE IF EXISTS `timetable_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable_rtab` (
  `id` int NOT NULL,
  `name` text,
  `season` int DEFAULT NULL,
  `tournamentid` int DEFAULT NULL,
  `eventDate` datetime DEFAULT NULL,
  `team1` int DEFAULT NULL,
  `team2` int DEFAULT NULL,
  `stadium` text,
  `winnerid` text,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable_rtab`
--

LOCK TABLES `timetable_rtab` WRITE;
/*!40000 ALTER TABLE `timetable_rtab` DISABLE KEYS */;
INSERT INTO `timetable_rtab` VALUES (1,'MI vs CSK',2020,1,'2020-09-19 19:30:00',1,2,'UAE',NULL,NULL),(2,'DC vs KXIP',2020,1,'2020-09-20 15:30:00',3,4,'UAE',NULL,NULL),(3,'RCB vs KKR',2020,1,'2020-09-20 19:30:00',5,6,'UAE',NULL,NULL),(4,'SRH vs MI',2020,1,'2020-09-21 19:30:00',7,1,'UAE',NULL,NULL),(5,'CSK vs RR',2020,1,'2020-09-22 19:30:00',2,8,'UAE',NULL,NULL),(6,'KKR vs DC',2020,1,'2020-09-23 19:30:00',6,3,'UAE',NULL,NULL),(7,'KXIP vs SRH',2020,1,'2020-09-24 19:30:00',4,7,'UAE',NULL,NULL),(8,'MI vs RCB',2020,1,'2020-09-25 15:30:00',1,5,'UAE',NULL,NULL),(9,'RR vs DC',2020,1,'2020-09-26 19:30:00',8,3,'UAE',NULL,NULL),(10,'KKR vs CSK',2020,1,'2020-09-27 15:30:00',6,2,'UAE',NULL,NULL),(11,'RCB vs SRH',2020,1,'2020-09-27 19:30:00',5,7,'UAE',NULL,NULL),(12,'KXIP vs MI',2020,1,'2020-09-28 19:30:00',1,4,'UAE',NULL,NULL),(13,'RR vs KKR',2020,1,'2020-09-29 19:30:00',8,6,'UAE',NULL,NULL),(14,'DC vs RCB',2020,1,'2020-09-30 19:30:00',3,5,'UAE',NULL,NULL),(15,'CSK vs KXIP',2020,1,'2020-10-01 19:30:00',2,4,'UAE',NULL,NULL),(16,'SRH vs RR',2020,1,'2020-10-02 15:30:00',7,8,'UAE',NULL,NULL),(17,'KKR vs MI',2020,1,'2020-10-03 19:30:00',6,1,'UAE',NULL,NULL),(18,'DC vs CSK',2020,1,'2020-10-04 15:30:00',3,2,'UAE',NULL,NULL),(19,'KXIP vs RCB',2020,1,'2020-10-04 19:30:00',4,5,'UAE',NULL,NULL),(20,'MI vs RR',2020,1,'2020-10-05 19:30:00',1,8,'UAE',NULL,NULL),(21,'SRH vs KKR',2020,1,'2020-10-06 19:30:00',7,6,'UAE',NULL,NULL),(22,'KXIP vs CSK',2020,1,'2020-10-07 19:30:00',4,2,'UAE',NULL,NULL),(23,'RCB vs RR',2020,1,'2020-10-08 19:30:00',5,8,'UAE',NULL,NULL),(24,'DC vs KKR',2020,1,'2020-10-09 15:30:00',3,6,'UAE',NULL,NULL),(25,'CSK vs SRH',2020,1,'2020-10-10 19:30:00',2,7,'UAE',NULL,NULL),(26,'MI vs KXIP',2020,1,'2020-10-11 15:30:00',1,4,'UAE',NULL,NULL),(27,'RR vs SRH',2020,1,'2020-10-11 19:30:00',8,7,'UAE',NULL,NULL),(28,'RCB vs DC',2020,1,'2020-10-12 19:30:00',5,3,'UAE',NULL,NULL),(29,'KKR vs KXIP',2020,1,'2020-10-13 19:30:00',6,4,'UAE',NULL,NULL),(30,'CSK vs MI',2020,1,'2020-10-14 19:30:00',2,1,'UAE',NULL,NULL),(31,'RR vs RCB',2020,1,'2020-10-15 19:30:00',8,5,'UAE',NULL,NULL),(32,'KXIP vs KKR',2020,1,'2020-10-16 15:30:00',4,6,'UAE',NULL,NULL),(33,'SRH vs DC',2020,1,'2020-10-17 19:30:00',7,3,'UAE',NULL,NULL),(34,'CSK vs RCB',2020,1,'2020-10-18 15:30:00',2,5,'UAE',NULL,NULL),(35,'MI vs KKR',2020,1,'2020-10-18 19:30:00',1,6,'UAE',NULL,NULL),(36,'RR vs KXIP',2020,1,'2020-10-19 19:30:00',8,4,'UAE',NULL,NULL),(37,'SRH vs CSK',2020,1,'2020-10-20 19:30:00',7,2,'UAE',NULL,NULL),(38,'MI vs DC',2020,1,'2020-10-21 19:30:00',1,3,'UAE',NULL,NULL),(39,'KKR vs RR',2020,1,'2020-10-22 19:30:00',6,8,'UAE',NULL,NULL),(40,'RCB vs KXIP',2020,1,'2020-10-23 15:30:00',5,4,'UAE',NULL,NULL),(41,'DC vs SRH',2020,1,'2020-10-24 19:30:00',3,7,'UAE',NULL,NULL),(42,'RR vs CSK',2020,1,'2020-10-25 15:30:00',8,2,'UAE',NULL,NULL),(43,'SRH vs RCB',2020,1,'2020-10-25 19:30:00',7,5,'UAE',NULL,NULL),(44,'DC vs MI',2020,1,'2020-10-26 19:30:00',3,1,'UAE',NULL,NULL),(45,'CSK vs KKR',2020,1,'2020-10-27 19:30:00',2,6,'UAE',NULL,NULL),(46,'KXIP vs RR',2020,1,'2020-10-28 19:30:00',4,8,'UAE',NULL,NULL),(47,'MI vs SRH',2020,1,'2020-10-29 19:30:00',1,7,'UAE',NULL,NULL),(48,'CSK vs DC',2020,1,'2020-10-30 15:30:00',2,3,'UAE',NULL,NULL),(49,'KKR vs RCB',2020,1,'2020-10-31 19:30:00',6,5,'UAE',NULL,NULL),(50,'RR vs MI',2020,1,'2020-11-01 15:30:00',8,1,'UAE',NULL,NULL),(51,'SRH vs KXIP',2020,1,'2020-11-01 19:30:00',7,4,'UAE',NULL,NULL),(52,'DC vs RR',2020,1,'2020-11-02 19:30:00',3,8,'UAE',NULL,NULL),(53,'RCB vs CSK',2020,1,'2020-11-03 19:30:00',5,2,'UAE',NULL,NULL),(54,'KKR vs SRH',2020,1,'2020-11-04 19:30:00',6,7,'UAE',NULL,NULL),(55,'KXIP vs DC',2020,1,'2020-11-05 19:30:00',4,3,'UAE',NULL,NULL),(56,'RCB vs MI',2020,1,'2020-11-06 19:30:00',5,1,'UAE',NULL,NULL),(57,'Qualifier-1',2020,1,'2020-11-07 19:30:00',9,9,'UAE',NULL,NULL),(58,'Eliminator',2020,1,'2020-11-08 19:30:00',9,9,'UAE',NULL,NULL),(59,'Qualifer-2',2020,1,'2020-11-09 19:30:00',9,9,'UAE',NULL,NULL),(60,'FINAL',2020,1,'2020-11-10 19:30:00',9,9,'UAE',NULL,'Hi Handsome!!!');
/*!40000 ALTER TABLE `timetable_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tournament_enum`
--

DROP TABLE IF EXISTS `tournament_enum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tournament_enum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `game` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournament_enum`
--

LOCK TABLES `tournament_enum` WRITE;
/*!40000 ALTER TABLE `tournament_enum` DISABLE KEYS */;
INSERT INTO `tournament_enum` VALUES (1,'IPL','Cricket','Indian Premier League');
/*!40000 ALTER TABLE `tournament_enum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails_rtab`
--

DROP TABLE IF EXISTS `userdetails_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetails_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `displayName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `emailVerified` varchar(1) DEFAULT NULL,
  `isAnonymous` varchar(1) DEFAULT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `photoURL` varchar(100) DEFAULT NULL,
  `providerId` varchar(45) DEFAULT NULL,
  `uid` varchar(45) NOT NULL,
  `token` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails_rtab`
--

LOCK TABLES `userdetails_rtab` WRITE;
/*!40000 ALTER TABLE `userdetails_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `userdetails_rtab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-06 21:16:48
