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
-- Table structure for table `breeds`
--

DROP TABLE IF EXISTS `breeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `breeds` (
  `breed_id` int NOT NULL AUTO_INCREMENT,
  `breed_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`breed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breeds`
--

LOCK TABLES `breeds` WRITE;
/*!40000 ALTER TABLE `breeds` DISABLE KEYS */;
INSERT INTO `breeds` VALUES (3,'American Cocker Spaniel'),(4,'American Staffordshire Terrier'),(5,'Australian Cattle Dog'),(6,'Australian Kelpie'),(7,'Australian Shepherd'),(8,'Australian Terrier'),(9,'Basenji'),(10,'Bavarian Mountain Hound'),(11,'Beagle'),(12,'Belgian Shepherd'),(13,'Border Collie'),(14,'Border Terrier'),(15,'Boston Terrier'),(16,'Boxer'),(17,'Brussels Griffon'),(18,'Cairn Terrier'),(19,'Cardigan Welsh Corgi'),(20,'Cavalier King Charles Spaniel'),(21,'Chihuahua'),(22,'Chinese Crested Dog'),(23,'Croatian Sheepdog'),(24,'Czechoslovakian Wolfdog'),(25,'Dobermann'),(26,'Dutch Shepherd'),(27,'German Spitz'),(28,'German Wirehaired Pointer'),(29,'Japanese Spitz'),(30,'Kooikerhondje'),(31,'Lagotto Romagnolo'),(32,'Manchester Terrier'),(33,'Mudi'),(34,'Nova Scotia Duck Tolling Retriever'),(35,'Papillon'),(36,'Parson Russell Terrier'),(37,'Pembroke Welsh Corgi'),(38,'Poodle'),(39,'Puli'),(40,'Pumi'),(41,'Pyrenean Sheepdog'),(42,'Rough Collie'),(43,'Samoyed'),(44,'Schipperke'),(45,'Shetland Sheepdog'),(46,'Smooth Collie'),(47,'Spanish Water Dog'),(48,'Weimaraner'),(49,'West Highland White Terrier'),(50,'Whippet'),(51,'White Swiss Shepherd Dog'),(52,'Yorkshire Terrier');
/*!40000 ALTER TABLE `breeds` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogs`
--

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;
INSERT INTO `dogs` VALUES (8,'Marvitholl Mokka','Mokka','2021-04-15','22222','L','A0',10,'shetland sheepdog'),(9,'Great Gatsby','Teo','2019-12-17','22222','S','A0',11,'shetland sheepdog'),(10,'Glucose','Nera','2020-12-21','4455','M','A1',13,'border-collie');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handler`
--

LOCK TABLES `handler` WRITE;
/*!40000 ALTER TABLE `handler` DISABLE KEYS */;
INSERT INTO `handler` VALUES (10,'Lidia','Belyaeva'),(11,'Diana','Hakova'),(13,'Olga','Knazeva');
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
  PRIMARY KEY (`result_id`),
  KEY `FK_dogs_results_dr_id_idx` (`dog_result_id`),
  CONSTRAINT `FK_dogs_results_dr_id` FOREIGN KEY (`dog_result_id`) REFERENCES `dogs` (`dog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
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

-- Dump completed on 2021-04-13  0:43:51
