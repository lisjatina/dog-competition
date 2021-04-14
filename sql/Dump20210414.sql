-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: competitors
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `dogs`
--

DROP TABLE IF EXISTS `dogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dogs` (
  `dog_id` int NOT NULL AUTO_INCREMENT,
  `dog_pedigree_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dog_pet_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dog_date_of_birth` date NOT NULL,
  `dog_microchip` varchar(100) NOT NULL,
  `dog_size` varchar(45) NOT NULL,
  `dog_level` varchar(45) NOT NULL,
  `dog_handler_id` int NOT NULL,
  `dog_breed` varchar(100) NOT NULL,
  PRIMARY KEY (`dog_id`),
  KEY `FK_dog_handler_h_id_idx` (`dog_handler_id`),
  CONSTRAINT `FK_dog_handler_h_id` FOREIGN KEY (`dog_handler_id`) REFERENCES `handler` (`handler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogs`
--

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;
INSERT INTO `dogs` VALUES (14,'Glucose','Nera','2018-02-14','22222','M','A0',17,'shetland sheepdog'),(15,'Marvitholl Mokka','Mokka','2010-06-03','71718','M','A1',18,'border-collie'),(16,'Great Gatsby','Teo','2021-04-01','71718','S','A3',19,'papillon');
/*!40000 ALTER TABLE `dogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handler`
--

DROP TABLE IF EXISTS `handler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `handler` (
  `handler_id` int NOT NULL AUTO_INCREMENT,
  `handler_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `handler_surname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`handler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handler`
--

LOCK TABLES `handler` WRITE;
/*!40000 ALTER TABLE `handler` DISABLE KEYS */;
INSERT INTO `handler` VALUES (17,'Lidia','Belyaeva'),(18,'Olga','Knazeva'),(19,'Diana','Hakova');
/*!40000 ALTER TABLE `handler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `dog_result_id` int NOT NULL,
  `time` decimal(10,0) DEFAULT NULL,
  `faults` int DEFAULT NULL,
  `refusals` int DEFAULT NULL,
  `speed` decimal(10,0) DEFAULT NULL,
  `mistakes` int DEFAULT NULL,
  `time_faults` decimal(10,0) DEFAULT NULL,
  `total_faults` decimal(10,0) DEFAULT NULL,
  `disq` varchar(45) DEFAULT NULL,
  `course_length` int NOT NULL,
  `course_speed` decimal(10,0) NOT NULL,
  PRIMARY KEY (`result_id`),
  KEY `FK_dogs_results_dr_id_idx` (`dog_result_id`),
  CONSTRAINT `FK_dogs_results_dr_id` FOREIGN KEY (`dog_result_id`) REFERENCES `dogs` (`dog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (9,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(10,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(11,16,0,0,0,0,0,0,0,'',0,0);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_login` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lidia','lidia_ice@inbox.lv','cc03e747a6afbbcbf8be7668acfebee5');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'competitors'
--

--
-- Dumping routines for database 'competitors'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-14 13:47:50
