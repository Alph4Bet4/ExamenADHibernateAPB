DROP DATABASE IF EXISTS `automoviles`;
CREATE DATABASE  IF NOT EXISTS `automoviles` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `automoviles`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: automoviles
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `coche`
--

DROP TABLE IF EXISTS `coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coche` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `antiguedad` int NOT NULL,
  `precio` int NOT NULL,
  `id_concesionario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_c_c_idx` (`id_concesionario`),
  CONSTRAINT `fk_c_c` FOREIGN KEY (`id_concesionario`) REFERENCES `concesionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` (`id`, `marca`, `antiguedad`, `precio`, `id_concesionario`) VALUES (1,'Marca1',3,25000,1),(2,'Marca1',3,35000,1),(3,'Marca1',3,45000,2),(4,'Marca2',2,30000,2),(5,'Marca3',1,35000,3),(6,'Marca4',2,10000,2);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concesionario`
--

DROP TABLE IF EXISTS `concesionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concesionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concesionario`
--

LOCK TABLES `concesionario` WRITE;
/*!40000 ALTER TABLE `concesionario` DISABLE KEYS */;
INSERT INTO `concesionario` (`id`, `nombre`) VALUES (1,'Concesionario A'),(2,'Concesionario B'),(3,'Concesionario C'),(4,'Concesionario A'),(5,'Concesionario B'),(6,'Concesionario C'),(7,'Concesionario D'),(8,'Concesionario E'),(9,'Concesionario F');
/*!40000 ALTER TABLE `concesionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deportivo`
--

DROP TABLE IF EXISTS `deportivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deportivo` (
  `id` int NOT NULL,
  `cilindrada` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_d_c` FOREIGN KEY (`id`) REFERENCES `coche` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deportivo`
--

LOCK TABLES `deportivo` WRITE;
/*!40000 ALTER TABLE `deportivo` DISABLE KEYS */;
INSERT INTO `deportivo` (`id`, `cilindrada`) VALUES (1,2000),(2,2500),(3,1800);
/*!40000 ALTER TABLE `deportivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`id`, `nombre`) VALUES (1,'Proveedor X'),(2,'Proveedor Y'),(3,'Proveedor Z');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_concesionario`
--

DROP TABLE IF EXISTS `proveedor_concesionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_concesionario` (
  `id_proveedor` int NOT NULL,
  `id_concesionario` int NOT NULL,
  PRIMARY KEY (`id_proveedor`,`id_concesionario`),
  KEY `fk_pc_c_idx` (`id_concesionario`),
  CONSTRAINT `fk_pc_c` FOREIGN KEY (`id_concesionario`) REFERENCES `concesionario` (`id`),
  CONSTRAINT `fk_pc_p` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_concesionario`
--

LOCK TABLES `proveedor_concesionario` WRITE;
/*!40000 ALTER TABLE `proveedor_concesionario` DISABLE KEYS */;
INSERT INTO `proveedor_concesionario` (`id_proveedor`, `id_concesionario`) VALUES (1,1),(1,2),(2,2),(1,3),(3,3);
/*!40000 ALTER TABLE `proveedor_concesionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'automoviles'
--

--
-- Dumping routines for database 'automoviles'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-05 23:58:28
