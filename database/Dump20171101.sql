-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `category_lk`
--

DROP TABLE IF EXISTS `category_lk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_lk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(100) NOT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `HS_CODE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='MASTER CATEGORY';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_lk`
--

LOCK TABLES `category_lk` WRITE;
/*!40000 ALTER TABLE `category_lk` DISABLE KEYS */;
INSERT INTO `category_lk` VALUES (1,'BEER','2017-05-13 21:30:37',1,'22030000'),(2,'BRANDY','2017-05-13 21:30:58',1,'22082000'),(3,'CHAMPAGNE','2017-05-13 21:31:15',1,'22041000'),(4,'GIN','2017-05-13 21:31:34',1,'22085000'),(5,'RUM','2017-05-13 21:31:49',1,'22084000'),(6,'TEQUILA','2017-05-13 21:32:06',1,'22087000'),(7,'VODKA','2017-05-13 21:32:27',1,'22086000'),(8,'WHISKY (CANADA)','2017-05-13 21:32:54',1,'22083000'),(9,'WHISKY (SCOTCH)','2017-05-13 21:33:12',1,'22083000'),(10,'CIGARETTES','2017-05-13 21:33:30',1,'24022000'),(11,'WINE','2017-05-13 22:35:38',1,'22042100');
/*!40000 ALTER TABLE `category_lk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_lk`
--

DROP TABLE IF EXISTS `country_lk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_lk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CNTRY_CODE` varchar(45) DEFAULT NULL,
  `CNTRY_DESC` varchar(45) DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_lk`
--

LOCK TABLES `country_lk` WRITE;
/*!40000 ALTER TABLE `country_lk` DISABLE KEYS */;
INSERT INTO `country_lk` VALUES (101,'UAE','United Arab Emirates',1,NULL),(102,'IN','INDIA',1,'2017-05-13 21:34:25'),(103,'USA','United States of America',1,'2017-05-13 21:36:26'),(104,'MX','Mexico',1,'2017-05-13 21:37:04'),(105,'ITALY','ITALY',1,'2017-05-13 21:37:22'),(106,'FR','France',1,'2017-05-13 21:37:48'),(107,'GB','United Kingdom',1,'2017-05-13 21:38:13'),(108,'PL','Poland',1,'2017-05-13 21:38:35'),(109,'MD','Moldova',1,'2017-05-13 21:38:59');
/*!40000 ALTER TABLE `country_lk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NAME` varchar(150) DEFAULT NULL,
  `ADDRESS_1` varchar(100) DEFAULT NULL,
  `ADDRESS_2` varchar(100) DEFAULT NULL,
  `ADDRESS_3` varchar(75) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_details`
--

LOCK TABLES `customer_details` WRITE;
/*!40000 ALTER TABLE `customer_details` DISABLE KEYS */;
INSERT INTO `customer_details` VALUES (1,'Dummy Customer One','Address Dummy Customer One','Address Dummy Customer One','Dummy Customer One',NULL,1,NULL);
/*!40000 ALTER TABLE `customer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_master`
--

DROP TABLE IF EXISTS `inventory_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GRN_ID` varchar(75) DEFAULT NULL,
  `OPENINIG_BAL` int(11) DEFAULT NULL,
  `CLOSING_BAL` int(11) DEFAULT NULL,
  `DO_TOTAL` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_master`
--

LOCK TABLES `inventory_master` WRITE;
/*!40000 ALTER TABLE `inventory_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `ID` int(11) NOT NULL,
  `INVOICE_ID` varchar(60) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `CURRENCY` varchar(45) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_details`
--

DROP TABLE IF EXISTS `invoice_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_details` (
  `ID` int(11) NOT NULL,
  `INVOICE_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `PACK_ID` int(11) DEFAULT NULL,
  `UNIT_RATE` int(11) DEFAULT NULL,
  `HS_CODE` varchar(45) DEFAULT NULL,
  `COUNTRY_ID` int(11) DEFAULT NULL,
  `BOD_DEC_NO` varchar(60) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_details`
--

LOCK TABLES `invoice_details` WRITE;
/*!40000 ALTER TABLE `invoice_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pack_lk`
--

DROP TABLE IF EXISTS `pack_lk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pack_lk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PACK_NAME` varchar(45) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `NO_PICES` varchar(45) DEFAULT NULL,
  `MEASUREMENT_COUNT` int(11) DEFAULT NULL,
  `MEASURMENT_TYPE` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pack_lk`
--

LOCK TABLES `pack_lk` WRITE;
/*!40000 ALTER TABLE `pack_lk` DISABLE KEYS */;
INSERT INTO `pack_lk` VALUES (1,'24/50CL','2017-05-13 21:46:04',1,'24',50,'Centiliters'),(2,'24/33CL','2017-05-13 21:46:49',1,'24',33,'Centiliters'),(3,'12/1LT','2017-05-13 21:47:22',1,'12',1,'Litre');
/*!40000 ALTER TABLE `pack_lk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_lk`
--

DROP TABLE IF EXISTS `product_lk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_lk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(100) DEFAULT NULL,
  `CUSTOM_FIELD_1` varchar(50) DEFAULT NULL,
  `CUSTOM_FIELD_2` varchar(50) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_lk`
--

LOCK TABLES `product_lk` WRITE;
/*!40000 ALTER TABLE `product_lk` DISABLE KEYS */;
INSERT INTO `product_lk` VALUES (1,'CARLSBEGR CANS','ok',NULL,'2017-05-13 21:49:01',1,1),(2,'HEINEKEN BOTTLES',NULL,NULL,'2017-05-13 21:49:10',1,1),(3,'KING FISHER CANS',NULL,NULL,'2017-05-13 21:49:18',1,1),(4,'KING FISHER LAGER BEER',NULL,NULL,'2017-05-13 21:49:25',1,1),(5,'KING FISHER STRONG BEER','',NULL,'2017-05-13 21:49:34',1,1),(6,'BACARDI CARTA BLANCA',NULL,NULL,'2017-05-13 21:49:48',1,5),(7,'CONTESSA RUM',NULL,NULL,'2017-05-13 21:49:55',1,5),(8,'OLD MONK RUM',NULL,NULL,'2017-05-13 21:50:03',1,5),(9,'EL CHARRO GOLD',NULL,NULL,'2017-05-13 21:50:12',1,6),(10,'MAGIC MOMENTS GRAIN VODKA',NULL,NULL,'2017-05-13 21:50:25',1,7),(11,'MAGIC MOMETNS GREEN APLLE',NULL,NULL,'2017-05-13 21:50:34',1,7),(12,'MAGIC MOMENTS RASPBERRY',NULL,NULL,'2017-05-13 21:50:43',1,7),(13,'MAGIC MOMENS LEMON & GRASS',NULL,NULL,'2017-05-13 21:50:51',1,7),(14,'MAGIC MOMENTS ORANGE',NULL,NULL,'2017-05-13 21:50:59',1,7),(15,'MAGIC MOMENTS LEMON',NULL,NULL,'2017-05-13 21:51:06',1,7),(16,'MAGIC MOMENTS CHOCLATE',NULL,NULL,'2017-05-13 21:51:14',1,7),(17,'MAGIC MOMENTS GRAIN VODKA',NULL,NULL,'2017-05-13 21:51:22',1,7),(18,'MAGIC MOMENTS RASPBERRY',NULL,NULL,'2017-05-13 21:51:31',1,7);
/*!40000 ALTER TABLE `product_lk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GRN_CODE` varchar(75) DEFAULT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `CNTRY_CODE` int(11) DEFAULT NULL,
  `UNIT_PRICE` decimal(11,2) DEFAULT NULL,
  `PACK_PIECES` int(11) DEFAULT NULL,
  `PACK_ID` int(11) DEFAULT NULL,
  `WEIGHT` decimal(11,2) DEFAULT NULL,
  `PIECE_WEIGHT` decimal(11,2) DEFAULT NULL,
  `COUNT` decimal(11,2) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `PRICE` decimal(11,2) DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  `REMARKS` varchar(75) DEFAULT NULL,
  `SUPPLIER_ID` int(11) DEFAULT NULL,
  `UNIT_SELLING_PRICE` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES (1,'GRINID0001',101,1,101,12221.00,101,101,1234.00,11.00,11.00,NULL,11.00,NULL,'ok',NULL,NULL),(6,'502-0130275915',101,5,101,1.00,111,101,111.00,1.00,0.00,'2017-05-13 00:00:00',111.00,NULL,'11',3,NULL),(7,'123212121',1,3,101,100.00,5000,1,50000.00,10.00,0.00,'2017-05-13 00:00:00',500000.00,NULL,'ok',3,120.00);
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_details`
--

DROP TABLE IF EXISTS `supplier_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUPPLIER_NAME` varchar(150) DEFAULT NULL,
  `ADDRESS_1` varchar(100) DEFAULT NULL,
  `ADDRESS_2` varchar(100) DEFAULT NULL,
  `ADDRESS_3` varchar(75) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_details`
--

LOCK TABLES `supplier_details` WRITE;
/*!40000 ALTER TABLE `supplier_details` DISABLE KEYS */;
INSERT INTO `supplier_details` VALUES (3,'Supplier One','Tamil Nadu','India','91553214526',NULL,1,NULL);
/*!40000 ALTER TABLE `supplier_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-01 21:30:23
