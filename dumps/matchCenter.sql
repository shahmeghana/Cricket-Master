CREATE DATABASE  IF NOT EXISTS `matchcenter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `matchcenter`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: matchcenter
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
  `userid` int DEFAULT NULL,
  `matchid` int DEFAULT NULL,
  `teamid` int DEFAULT NULL,
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
-- Table structure for table `player_rtab`
--

DROP TABLE IF EXISTS `player_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_rtab`
--

LOCK TABLES `player_rtab` WRITE;
/*!40000 ALTER TABLE `player_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polloptions_rtab`
--

DROP TABLE IF EXISTS `polloptions_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polloptions_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pollid` int NOT NULL,
  `answer` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polloptions_rtab`
--

LOCK TABLES `polloptions_rtab` WRITE;
/*!40000 ALTER TABLE `polloptions_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `polloptions_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polls_rtab`
--

DROP TABLE IF EXISTS `polls_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polls_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `question` varchar(200) NOT NULL,
  `report_count` int(10) unsigned zerofill NOT NULL,
  `flag_count` int(10) unsigned zerofill NOT NULL,
  `when_created` datetime NOT NULL,
  `expiration` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polls_rtab`
--

LOCK TABLES `polls_rtab` WRITE;
/*!40000 ALTER TABLE `polls_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `polls_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portfolio_rtab`
--

DROP TABLE IF EXISTS `portfolio_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `portfolio_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `eventid` int NOT NULL,
  `eventtype` varchar(45) NOT NULL,
  `score` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_portfolio` (`userid`,`eventid`,`eventtype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portfolio_rtab`
--

LOCK TABLES `portfolio_rtab` WRITE;
/*!40000 ALTER TABLE `portfolio_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `portfolio_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicchats_rtab`
--

DROP TABLE IF EXISTS `publicchats_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicchats_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `comments` varchar(45) NOT NULL,
  `report_count` int(10) unsigned zerofill NOT NULL,
  `flag_count` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicchats_rtab`
--

LOCK TABLES `publicchats_rtab` WRITE;
/*!40000 ALTER TABLE `publicchats_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicchats_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system.properties_rtab`
--

DROP TABLE IF EXISTS `system.properties_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system.properties_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `value` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system.properties_rtab`
--

LOCK TABLES `system.properties_rtab` WRITE;
/*!40000 ALTER TABLE `system.properties_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `system.properties_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_rtab`
--

DROP TABLE IF EXISTS `team_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teamid` int NOT NULL,
  `playerid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_rtab`
--

LOCK TABLES `team_rtab` WRITE;
/*!40000 ALTER TABLE `team_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_rtab` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamlist_rtab`
--

LOCK TABLES `teamlist_rtab` WRITE;
/*!40000 ALTER TABLE `teamlist_rtab` DISABLE KEYS */;
INSERT INTO `teamlist_rtab` VALUES (1,'Mumbai Indians','2020',1,'MI'),(2,'Chennai Super Kings','2020',1,'CSK'),(3,'Delhi Capitals','2020',1,'DC'),(4,'Kings XI Punjab','2020',1,'KXI'),(5,'Royal Challengers Bangalore','2020',1,'RCB'),(6,'Kolkata Knight Riders','2020',1,'KKR'),(7,'Sunrisers Hyderabad','2020',1,'SH'),(8,'Rajasthan Royals','2020',1,'RR');
/*!40000 ALTER TABLE `teamlist_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable_rtab`
--

DROP TABLE IF EXISTS `timetable_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `season` varchar(45) NOT NULL,
  `tournamentid` int NOT NULL,
  `eventDate` datetime NOT NULL,
  `team1` int NOT NULL,
  `team2` int NOT NULL,
  `stadium` varchar(45) NOT NULL,
  `winnerid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable_rtab`
--

LOCK TABLES `timetable_rtab` WRITE;
/*!40000 ALTER TABLE `timetable_rtab` DISABLE KEYS */;
INSERT INTO `timetable_rtab` VALUES (1,'MI vs CSK','2020',1,'2020-03-29 20:00:00',1,2,'Mumbai',NULL),(2,'DC vs KXI','2020',1,'2020-03-30 20:00:00',3,4,'Delhi',NULL),(3,'RCB vs KKR','2020',1,'2020-03-31 20:00:00',5,6,'Bengaluru',NULL),(4,'SH vs MI','2020',1,'2020-04-01 20:00:00',7,1,'Hyderabad',NULL),(5,'CSK vs RR','2020',1,'2020-04-02 20:00:00',2,8,'Chennai',NULL),(6,'KKR vs DC','2020',1,'2020-04-03 20:00:00',6,3,'Kolkata',NULL),(7,'KXI vs SH','2020',1,'2020-04-04 20:00:00',4,7,'Mohali',NULL),(8,'MI vs RCB','2020',1,'2020-04-05 16:00:00',1,5,'Mumbai',NULL),(9,'RR vs DC','2020',1,'2020-04-05 20:00:00',8,3,'Jaipur/Guwahati',NULL),(10,'KKR vs CSK','2020',1,'2020-04-06 20:00:00',6,2,'Kolkata',NULL),(11,'RCB vs SH','2020',1,'2020-04-07 20:00:00',5,7,'Bengaluru',NULL),(12,'KXI vs MI','2020',1,'2020-04-08 20:00:00',1,4,'Mohali',NULL),(13,'RR vs KKR','2020',1,'2020-04-09 20:00:00',8,6,'Jaipur/Guwahati',NULL),(14,'DC vs RCB','2020',1,'2020-04-10 20:00:00',3,5,'Delhi',NULL),(15,'CSK vs KXI','2020',1,'2020-04-11 20:00:00',2,4,'Chennai',NULL),(16,'SH vs RR','2020',1,'2020-04-12 16:00:00',7,8,'Hyderabad',NULL),(17,'KKR vs MI','2020',1,'2020-04-12 20:00:00',6,1,'Kolkata',NULL),(18,'DC vs CSK','2020',1,'2020-04-13 20:00:00',3,2,'Delhi',NULL),(19,'KXI vs RCB','2020',1,'2020-04-14 20:00:00',4,5,'Mohali',NULL),(20,'MI vs RR','2020',1,'2020-04-15 20:00:00',1,8,'Mumbai',NULL),(21,'SH vs KKR','2020',1,'2020-04-16 20:00:00',7,6,'Hyderabad',NULL),(22,'KXI vs CSK','2020',1,'2020-04-17 20:00:00',4,2,'Mohali',NULL),(23,'RCB vs RR','2020',1,'2020-04-18 20:00:00',5,8,'Bengaluru',NULL),(24,'DC vs KKR','2020',1,'2020-04-19 16:00:00',3,6,'Delhi',NULL),(25,'CSK vs SH','2020',1,'2020-04-19 20:00:00',2,7,'Chennai',NULL),(26,'MI vs KXI','2020',1,'2020-04-20 20:00:00',1,4,'Mumbai',NULL),(27,'RR vs SH','2020',1,'2020-04-21 20:00:00',8,7,'Jaipur',NULL),(28,'RCB vs DC','2020',1,'2020-04-22 20:00:00',5,3,'Bengaluru',NULL),(29,'KKR vs KXI','2020',1,'2020-04-23 20:00:00',6,4,'Kolkata',NULL),(30,'CSK vs MI','2020',1,'2020-04-24 20:00:00',2,1,'Chennai',NULL),(31,'RR vs RCB','2020',1,'2020-04-25 20:00:00',8,5,'Jaipur',NULL),(32,'KXI vs KKR','2020',1,'2020-04-26 16:00:00',4,6,'Mohali',NULL),(33,'SH vs DC','2020',1,'2020-04-26 20:00:00',7,3,'Hyderabad',NULL),(34,'CSK vs RCB','2020',1,'2020-04-27 20:00:00',2,5,'Chennai',NULL),(35,'MI vs KKR','2020',1,'2020-04-28 20:00:00',1,6,'Mumbai',NULL),(36,'RR vs KXI','2020',1,'2020-04-29 20:00:00',8,4,'Jaipur',NULL),(37,'SH vs CSK','2020',1,'2020-04-30 20:00:00',7,2,'Hyderabad',NULL),(38,'MI vs DC','2020',1,'2020-05-01 20:00:00',1,3,'Mumbai',NULL),(39,'KKR vs RR','2020',1,'2020-05-02 20:00:00',6,8,'Kolkata',NULL),(40,'RCB vs KXI','2020',1,'2020-05-03 16:00:00',5,4,'Bengaluru',NULL),(41,'DC vs SH','2020',1,'2020-05-03 20:00:00',3,7,'Delhi',NULL),(42,'RR vs CSK','2020',1,'2020-05-04 20:00:00',8,2,'Jaipur',NULL),(43,'SH vs RCB','2020',1,'2020-05-05 20:00:00',7,5,'Hyderabad',NULL),(44,'DC vs MI','2020',1,'2020-05-06 20:00:00',3,1,'Delhi',NULL),(45,'CSK vs KKR','2020',1,'2020-05-07 20:00:00',2,6,'Chennai',NULL),(46,'KXI vs RR','2020',1,'2020-05-08 20:00:00',4,8,'Mohali',NULL),(47,'MI vs SH','2020',1,'2020-05-09 20:00:00',1,7,'Mumbai',NULL),(48,'CSK vs DC','2020',1,'2020-05-10 16:00:00',2,3,'Chennai',NULL),(49,'KKR vs RCB','2020',1,'2020-05-10 20:00:00',6,5,'Kolkata',NULL),(50,'RR vs MI','2020',1,'2020-05-11 20:00:00',8,1,'Jaipur',NULL),(51,'SH vs KXI','2020',1,'2020-05-12 20:00:00',7,4,'Hyderabad',NULL),(52,'DC vs RR','2020',1,'2020-05-13 20:00:00',3,8,'Delhi',NULL),(53,'RCB vs CSK','2020',1,'2020-05-14 20:00:00',5,2,'Bengaluru',NULL),(54,'KKR vs SH','2020',1,'2020-05-15 20:00:00',6,7,'Kolkata',NULL),(55,'KXI vs DC','2020',1,'2020-05-16 20:00:00',4,3,'Mohali',NULL),(56,'RCB vs MI','2020',1,'2020-05-17 20:00:00',5,1,'Bengaluru',NULL);
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
-- Table structure for table `userinfo_rtab`
--

DROP TABLE IF EXISTS `userinfo_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo_rtab`
--

LOCK TABLES `userinfo_rtab` WRITE;
/*!40000 ALTER TABLE `userinfo_rtab` DISABLE KEYS */;
INSERT INTO `userinfo_rtab` VALUES (4,'Pranjal','pgore','$2a$10$mqpiib.qMCJKazIsL/S4BeaQpkQ9TTw8rd3MsfMmH4Kdzcmno9hgW','pranjalgore@gmail.com','8983189247'),(5,'Meghana','mshah','$2a$10$qwfx8ZZ4d4JepFizgZ7AAOiPUTwPpyZ/xS8HICfVi0m9lQzB1yV0G','shahmeghana29@gmail.com','7709300836'),(7,'Random','test','$2a$10$MVpmKbBoBhRQpnU9cdemHeVa1B.awnG7Yl4AYZT9ps7Z6OoaVryGa','random@gmail.com','123456789');
/*!40000 ALTER TABLE `userinfo_rtab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpollanswers_rtab`
--

DROP TABLE IF EXISTS `userpollanswers_rtab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userpollanswers_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `pollid` int NOT NULL,
  `optionid` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_userpolls` (`userid`,`pollid`,`optionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpollanswers_rtab`
--

LOCK TABLES `userpollanswers_rtab` WRITE;
/*!40000 ALTER TABLE `userpollanswers_rtab` DISABLE KEYS */;
/*!40000 ALTER TABLE `userpollanswers_rtab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-12 10:16:40
