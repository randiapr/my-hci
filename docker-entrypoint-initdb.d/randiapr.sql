CREATE DATABASE  IF NOT EXISTS `randiapr` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `randiapr`;
-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: 172.17.0.2    Database: randiapr
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `module_app`
--

DROP TABLE IF EXISTS `module_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `module_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module_app`
--

LOCK TABLES `module_app` WRITE;
/*!40000 ALTER TABLE `module_app` DISABLE KEYS */;
INSERT INTO `module_app` VALUES (1,'PromoCard','Promo Card','2019-07-25 11:31:47','2019-07-25 11:31:47'),(2,'FlashSaleCard','Flash Sale Card','2019-07-25 13:16:31','2019-07-25 13:16:31'),(3,'NewsCard','News Card','2019-07-25 14:10:28','2019-07-25 14:10:28');
/*!40000 ALTER TABLE `module_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_app`
--

DROP TABLE IF EXISTS `user_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_app`
--

LOCK TABLES `user_app` WRITE;
/*!40000 ALTER TABLE `user_app` DISABLE KEYS */;
INSERT INTO `user_app` VALUES (1,'randi','randi@gmail.com','2019-07-25 06:17:07','2019-07-25 06:17:07'),(2,'string','string','2019-07-25 09:35:53','2019-07-25 09:35:53');
/*!40000 ALTER TABLE `user_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_modules`
--

DROP TABLE IF EXISTS `user_modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_modules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL,
  `module_order` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_moduleapp_id_idx` (`module_id`),
  KEY `fk_userapp_id_idx` (`user_id`),
  CONSTRAINT `fk_moduleapp_id` FOREIGN KEY (`module_id`) REFERENCES `module_app` (`id`),
  CONSTRAINT `fk_userapp_id` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_modules`
--

LOCK TABLES `user_modules` WRITE;
/*!40000 ALTER TABLE `user_modules` DISABLE KEYS */;
INSERT INTO `user_modules` VALUES (1,1,1,1,'2019-07-25 12:57:53','2019-07-25 12:57:53'),(2,1,2,2,'2019-07-25 13:16:43','2019-07-25 13:16:43'),(3,1,3,3,'2019-07-25 14:18:14','2019-07-25 14:18:14');
/*!40000 ALTER TABLE `user_modules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-25 22:14:07
