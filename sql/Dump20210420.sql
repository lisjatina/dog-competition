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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogs`
--

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;
INSERT INTO `dogs` VALUES (37,'Great Gatsby','Teo','2014-06-19','22222','M','A0',40,'shetland sheepdog'),(38,'Marvitholl Mokka','Mokka','2021-04-03','56789','S','A1',41,'jack russel terrier'),(39,'Aleksis','Alex','2019-06-07','4566','S','A2',42,'croatian sheepdog'),(40,'Arem','Rem','2019-06-15','4566','L','A3',43,'whippet'),(41,'OREAN RAINBOW WARRIOR','Warry','2019-06-19','71718','L','A0',44,'mudi'),(42,'KELTIHOPE HARVESTER','Kelly','2019-06-07','56789','M','A2',45,'mixbreed'),(43,'Marvitholl Double Coffee','Varja','2017-08-15','345677','M','A3',46,'papillon'),(44,'LUNDECOCK\'S SCARFACE','Sorry','2021-04-01','4566','M','A3',47,'border-collie'),(45,'MILESEND MILKMAN','Milk','2021-04-14','71718','M','A1',48,'mixbreed'),(46,'Dalylove Spicy Shakira','Wifi','2016-07-14','4566','M','A3',49,'border-collie'),(47,'Wildfinn Testarossa','Tess','2019-10-09','22222','M','A2',50,'croatian sheepdog'),(48,'Seventy Seven Leonard','Leo','2013-06-19','56789','S','A0',51,'shetland sheepdog'),(49,'Flyland Cheetah','Geps','2019-06-20','71718','M','A1',52,'whippet'),(50,'Wonder Girl Wankan','Ada','2019-04-19','71718','S','A2',53,'border-collie'),(51,'Fair Helloiz Dolly','Dolly','2016-07-19','56789','M','A0',54,'border-collie'),(52,'Armirelli Hot Date','Janis','2017-08-19','4455','M','A0',55,'papillon'),(53,'Impala Essence Velvet','Nana','2019-08-19','4455','M','A1',56,'papillon'),(54,'Impala Essence Elisey','Essie','2018-08-13','56789','M','A1',57,'papillon'),(55,'Tiara Gamtos Harmonija','Tara','2018-07-19','4566','M','A2',58,'mudi'),(56,'Irhaberki Ronja','Ronja','2017-08-19','71718','M','A3',59,'mudi');
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handler`
--

LOCK TABLES `handler` WRITE;
/*!40000 ALTER TABLE `handler` DISABLE KEYS */;
INSERT INTO `handler` VALUES (40,'Diana','Hakova'),(41,'Olga','Knazeva'),(42,'Maksim','Vaskop'),(43,'Edvin','Berzins'),(44,'Katrin','Riska'),(45,'Elina','Volkova'),(46,'Oxana','Belyaeva'),(47,'Kaisa','Tsaro'),(48,'Jelena','Stukane'),(49,'Egle ','Pesti'),(50,'Karoliina ','Kansi'),(51,'Jelena ','Marzaljuk'),(52,'Inga','Jarv'),(53,'Lea ','Tummeleht'),(54,'Viivi ','Sepp'),(55,'Ingrid','Sats'),(56,'Marija','Antonova'),(57,'Ede','Brand'),(58,'Arta','Veisa'),(59,'Inge','Ringmets');
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
  `time` decimal(10,2) DEFAULT NULL,
  `faults` int DEFAULT NULL,
  `refusals` int DEFAULT NULL,
  `speed` decimal(10,2) DEFAULT NULL,
  `mistakes` int DEFAULT NULL,
  `time_faults` decimal(10,2) DEFAULT NULL,
  `total_faults` decimal(10,2) DEFAULT NULL,
  `disq` varchar(45) DEFAULT NULL,
  `course_length` int DEFAULT NULL,
  `course_speed` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`result_id`),
  KEY `FK_dogs_results_dr_id_idx` (`dog_result_id`),
  CONSTRAINT `FK_dogs_results_dr_id` FOREIGN KEY (`dog_result_id`) REFERENCES `dogs` (`dog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (31,37,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(32,38,23.87,1,1,8.38,10,0.00,10.00,'',200,4.00),(33,39,19.19,0,0,10.42,0,0.00,0.00,'',200,4.00),(34,40,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(35,41,58.87,0,0,3.40,0,8.87,8.87,'',200,4.00),(36,42,38.26,0,0,5.23,0,0.00,0.00,'',200,4.00),(37,43,18.26,0,0,10.95,0,0.00,0.00,'',200,4.00),(38,44,26.26,2,1,7.62,15,0.00,15.00,'',200,4.00),(39,45,19.19,1,2,10.42,15,0.00,15.00,'',200,4.00),(40,46,36.26,1,0,5.52,5,0.00,5.00,'',200,4.00),(41,47,36.26,0,0,5.52,0,0.00,0.00,'',200,4.00),(42,48,26.26,0,1,7.62,5,0.00,5.00,'',200,4.00),(43,49,26.48,0,1,7.55,5,0.00,5.00,'',200,4.00),(44,50,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DNS',0,0.00),(45,51,43.68,2,1,4.58,15,0.00,15.00,'',200,4.00),(46,52,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(47,53,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(48,54,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(49,55,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00),(50,56,500.00,NULL,NULL,NULL,NULL,NULL,500.00,'DISQ',0,0.00);
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

-- Dump completed on 2021-04-20 14:28:30
