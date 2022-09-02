-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommercedb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agency` (
  `agencyID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isActive` int DEFAULT '1',
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `coverImage` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hotline` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `manager` int DEFAULT NULL,
  `isCensored` int DEFAULT '0',
  `field` int DEFAULT NULL,
  PRIMARY KEY (`agencyID`),
  KEY `fk_usermanager_idx` (`manager`),
  KEY `fk_fieldagent_idx` (`field`),
  CONSTRAINT `fk_fieldagent` FOREIGN KEY (`field`) REFERENCES `agent_field` (`afID`),
  CONSTRAINT `fk_usermanager` FOREIGN KEY (`manager`) REFERENCES `user` (`userID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'Adidas.vn',0,'https://res.cloudinary.com/dec25/image/upload/v1661522777/usjokiyorcs71rox2axn.webp','https://res.cloudinary.com/dec25/image/upload/v1658686871/coveradidas_arvw1t.webp','106 Le Van Sy, Phuong 11, Phu Nhuan, Thanh pho Ho Chi Minh, Vietnam',' 028 3991 4164','2022-08-23 15:01:35',3,1,1),(2,'My Pham Cao Cap',1,'https://images.squarespace-cdn.com/content/v1/53883795e4b016c956b8d243/1568301416904-UMSIRKEMXXEKOKMHHKY3/chup-anh-sep-pham-dep.jpg','https://images.squarespace-cdn.com/content/v1/53883795e4b016c956b8d243/1568301416904-UMSIRKEMXXEKOKMHHKY3/chup-anh-sep-pham-dep.jpg','106 Le Van Sy, Phuong 11, Phu Nhuan, Thanh pho Ho Chi Minh',' 028 3991 4165','2022-08-23 15:01:35',1,1,2),(3,'Thoi Trang Gioi Tre',1,'https://namlongfashion.com/wp-content/uploads/2020/03/134.jpg','https://namlongfashion.com/wp-content/uploads/2020/03/134.jpg','106 Le Van Sy, Phuong 11, Phu Nhuan, Thanh pho Ho Chi Minh',' 027 3991 4165','2022-08-23 15:01:35',1,1,1),(5,'Apple Store',1,'https://res.cloudinary.com/dec25/image/upload/v1661241690/zsfeovosbcgowgqtjpvr.png',NULL,'25 Duong Quang Ham, tp Ho Chi Minh','0744455522221','2022-08-23 15:01:35',20,1,6),(7,'Cửa Hàng Dược  Phẩm',0,'https://res.cloudinary.com/dec25/image/upload/v1661846611/yeo9w35g2iifmjdp0itw.jpg',NULL,'106 Le Van Sy, Phuong 11, Phu Nhuan, Thanh pho Ho Chi Minh, Viet Nam',' 028 3991 4161','2022-08-30 15:03:32',19,0,2);
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_field`
--

DROP TABLE IF EXISTS `agent_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent_field` (
  `afID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`afID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_field`
--

LOCK TABLES `agent_field` WRITE;
/*!40000 ALTER TABLE `agent_field` DISABLE KEYS */;
INSERT INTO `agent_field` VALUES (1,'Thời trang'),(2,'Dược phẩm'),(3,'Đồ gia dụng'),(4,'Đồ handmade - Mỹ nghệ'),(5,'Thực phẩm'),(6,'Phụ kiện công nghệ'),(7,'Đồ chơi trẻ em'),(8,'Phụ kiện - Trang sức'),(9,'Sách'),(10,'Văn phòng phẩm'),(11,'Chăm sóc thú cưng'),(12,'Thể thao - Du lịch'),(13,'Mỹ phẩm - Chăm sóc sắc đẹp'),(14,'Dịch vụ'),(15,'Xe - Phụ kiện xe'),(16,'Khác');
/*!40000 ALTER TABLE `agent_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_provider`
--

DROP TABLE IF EXISTS `auth_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_provider` (
  `authID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`authID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_provider`
--

LOCK TABLES `auth_provider` WRITE;
/*!40000 ALTER TABLE `auth_provider` DISABLE KEYS */;
INSERT INTO `auth_provider` VALUES (1,'DEFAULT'),(2,'GOOGLE'),(3,'FACEBOOK');
/*!40000 ALTER TABLE `auth_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Moms, Kids & Babies','https://res.cloudinary.com/dec25/image/upload/v1658859831/099edde1ab31df35bc255912bab54a5e_tn_j8imem.png'),(2,'Consumer Electronics','https://res.cloudinary.com/dec25/image/upload/v1658859831/978b9e4cb61c611aaaf58664fae133c5_tn_i1fwmx.png'),(3,'Fashion','https://res.cloudinary.com/dec25/image/upload/v1658859831/687f3967b7c2fe6a134a2c11894eea4b_tn_hym300.png'),(5,'Home & Living','https://res.cloudinary.com/dec25/image/upload/v1658859830/24b194a695ea59d384768b7b471d563f_tn_od4idc.png'),(6,'Shoes','https://res.cloudinary.com/dec25/image/upload/v1658859831/74ca517e1fa74dc4d974e5d03c3139de_tn_ooekx6.png'),(7,'Grocery','https://res.cloudinary.com/dec25/image/upload/v1658859831/c432168ee788f903f1ea024487f2c889_tn_smsulc.png'),(8,'Computer & Accessories','https://res.cloudinary.com/dec25/image/upload/v1658859831/c3f3edfaa9f6dafc4825b77d8449999d_tn_x4pchf.png'),(9,'Mobile & Gadgets','https://res.cloudinary.com/dec25/image/upload/v1658860482/31234a27876fb89cd522d7e3db1ba5ca_tn_v1p2uo.png'),(10,'Sport & Outdoor','https://res.cloudinary.com/dec25/image/upload/v1658859830/6cb7e633f8b63757463b676bd19a50e4_tn_dardwd.png'),(11,'Books & Stationery','https://res.cloudinary.com/dec25/image/upload/v1658860366/36013311815c55d303b0e6c62d6a8139_tn_vbcsc4.png'),(12,'Home Appliances','https://res.cloudinary.com/dec25/image/upload/v1658859830/7abfbfee3c4844652b4a8245e473d857_tn_adkwtb.png'),(13,'Cameras','https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png'),(14,'Watches','https://res.cloudinary.com/dec25/image/upload/v1658859831/86c294aae72ca1db5f541790f7796260_tn_axqtnt.png'),(15,'Automotive','https://res.cloudinary.com/dec25/image/upload/v1658859831/3fb459e3449905545701b418e8220334_tn_qa92jt.png'),(17,'Home care','https://res.cloudinary.com/dec25/image/upload/v1658860366/cd8e0d2e6c14c4904058ae20821d0763_tn_ks3olq.png'),(19,'Toys','https://res.cloudinary.com/dec25/image/upload/v1658860366/ce8f8abc726cafff671d0e5311caa684_tn_qbzpev.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `censorship_agent`
--

DROP TABLE IF EXISTS `censorship_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `censorship_agent` (
  `censorshipID` int NOT NULL AUTO_INCREMENT,
  `createdDate` date DEFAULT NULL,
  `censoredDate` date DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `agencyID` int DEFAULT NULL,
  `censorID` int DEFAULT NULL,
  PRIMARY KEY (`censorshipID`),
  KEY `fk_censor_idx` (`userID`),
  KEY `fk_sensoredagent_idx` (`agencyID`),
  KEY `fk_censor_idx1` (`censorID`),
  CONSTRAINT `fk_manager` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE,
  CONSTRAINT `fk_sensoredagent` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`) ON DELETE CASCADE,
  CONSTRAINT `fk_sensoreuser` FOREIGN KEY (`censorID`) REFERENCES `user` (`userID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `censorship_agent`
--

LOCK TABLES `censorship_agent` WRITE;
/*!40000 ALTER TABLE `censorship_agent` DISABLE KEYS */;
INSERT INTO `censorship_agent` VALUES (2,'2022-08-30',NULL,19,7,NULL);
/*!40000 ALTER TABLE `censorship_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classify`
--

DROP TABLE IF EXISTS `classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classify` (
  `classifyID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postID` int DEFAULT NULL,
  PRIMARY KEY (`classifyID`),
  KEY `fk_postclassify_idx` (`postID`),
  CONSTRAINT `fk_postclassify` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify`
--

LOCK TABLES `classify` WRITE;
/*!40000 ALTER TABLE `classify` DISABLE KEYS */;
/*!40000 ALTER TABLE `classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classify_details`
--

DROP TABLE IF EXISTS `classify_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classify_details` (
  `cdID` int NOT NULL AUTO_INCREMENT,
  `value` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `classifyID` int DEFAULT NULL,
  PRIMARY KEY (`cdID`),
  KEY `fk_classify_idx` (`classifyID`),
  CONSTRAINT `fk_classify` FOREIGN KEY (`classifyID`) REFERENCES `classify` (`classifyID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify_details`
--

LOCK TABLES `classify_details` WRITE;
/*!40000 ALTER TABLE `classify_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `classify_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classify_details_item`
--

DROP TABLE IF EXISTS `classify_details_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classify_details_item` (
  `itemID` int NOT NULL,
  `classifyDetailsID` int NOT NULL,
  PRIMARY KEY (`itemID`,`classifyDetailsID`),
  KEY `fk_classifydetailsclassifydetailsitem_idx` (`classifyDetailsID`),
  CONSTRAINT `fk_classifydetailsclassifydetailsitem` FOREIGN KEY (`classifyDetailsID`) REFERENCES `classify_details` (`cdID`),
  CONSTRAINT `fk_itemclassifydetailsitem` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify_details_item`
--

LOCK TABLES `classify_details_item` WRITE;
/*!40000 ALTER TABLE `classify_details_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `classify_details_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_post`
--

DROP TABLE IF EXISTS `comment_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_post` (
  `commentID` int NOT NULL AUTO_INCREMENT,
  `content` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `postID` int DEFAULT NULL,
  `sup_comment` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `star_rate` int DEFAULT NULL,
  PRIMARY KEY (`commentID`),
  KEY `fk_usercmt_idx` (`userID`),
  KEY `fk_postcmt_idx` (`postID`),
  KEY `fk_cmtsuper_idx` (`sup_comment`),
  CONSTRAINT `fk_cmtsuper` FOREIGN KEY (`sup_comment`) REFERENCES `comment_post` (`commentID`) ON DELETE CASCADE,
  CONSTRAINT `fk_postcmt` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`) ON DELETE CASCADE,
  CONSTRAINT `fk_usercmt` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_post`
--

LOCK TABLES `comment_post` WRITE;
/*!40000 ALTER TABLE `comment_post` DISABLE KEYS */;
INSERT INTO `comment_post` VALUES (1,'consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam',3,1,NULL,'2022-08-10 18:35:06',2),(2,'Lorem twou consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam',1,1,NULL,'2022-08-10 18:35:06',4),(98,'first comment from thu.nv',20,3,NULL,'2022-08-26 00:17:00',4),(99,'smod tempor incididunt ut labore !!!',3,1,NULL,'2022-08-27 16:05:48',3),(104,'alo alo',1,3,NULL,'2022-09-02 17:31:10',2);
/*!40000 ALTER TABLE `comment_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_agent`
--

DROP TABLE IF EXISTS `follow_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow_agent` (
  `faID` int NOT NULL AUTO_INCREMENT,
  `isFollow` int DEFAULT '1',
  `createdDate` date DEFAULT NULL,
  `updatedDate` date DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `agencyID` int DEFAULT NULL,
  PRIMARY KEY (`faID`),
  KEY `fk_userfollow_idx` (`userID`),
  KEY `fk_agencyfollow_idx` (`agencyID`),
  CONSTRAINT `fk_agencyfollow` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`),
  CONSTRAINT `fk_userfollow` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_agent`
--

LOCK TABLES `follow_agent` WRITE;
/*!40000 ALTER TABLE `follow_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `genderID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`genderID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'MALE'),(2,'FEMALE'),(3,'UNDEFINED');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `isActive` int DEFAULT '1',
  `unitPrice` double DEFAULT '0',
  `inventory` int DEFAULT '0',
  `isClassified` int DEFAULT '0',
  `postID` int DEFAULT NULL,
  `description` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  KEY `fk_postitem_idx` (`postID`),
  CONSTRAINT `fk_postitem` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Adidas Prophere','https://res.cloudinary.com/dec25/image/upload/v1661630858/plg7v4pzt9rbgf40stlx.jpg',1,2900000,5,1,1,'Red - 39'),(2,'Adidas Prophere','https://res.cloudinary.com/dec25/image/upload/v1658941724/products/red-white-b37635-ap-dung-ck_uuu96p.jpg',1,2800000,0,1,1,'Red - 40'),(3,'Adidas Prophere','https://res.cloudinary.com/dec25/image/upload/v1658941724/products/rep-11-dep-chat_oho9nw.jpg',1,2880000,5,1,1,'White - 41'),(4,'Adidas Prophere','https://res.cloudinary.com/dec25/image/upload/v1658942093/products/fea91b2da0c4cea3535a5bd35057cb7e_r2thz1.png',1,2910000,5,1,1,'Brown - 41'),(7,'Trà Ăn Ngủ Ngon','https://xuconcept.com/wp-content/uploads/2018/07/chup-quang-cao.jpg',1,250000,5,1,2,'Small Box'),(8,'Trà Ăn Ngủ Ngon','https://xuconcept.com/wp-content/uploads/2018/07/chup-quang-cao.jpg',1,300000,0,1,2,'Big Box'),(9,'Áo thun Đỏ','https://namlongfashion.com/wp-content/uploads/2020/03/134.jpg',1,120000,9,1,3,'Size XL - Red'),(10,'Áo thun Xanh','https://namlongfashion.com/wp-content/uploads/2020/03/134.jpg',1,120000,6,1,3,'Size XL - Blue'),(11,'Dép tổ ong ','https://res.cloudinary.com/dec25/image/upload/v1661631464/swzrho5qpqrm2yganm2u.jpg',1,20000,5,1,19,'Size nhỏ'),(12,'Dép tổ ong ','https://res.cloudinary.com/dec25/image/upload/v1661533266/oxyizvskrjzb2llp2od3.jpg',1,20000,10,1,19,'Size vừa'),(14,'Dép tổ ong ','https://res.cloudinary.com/dec25/image/upload/v1661533608/y5d6334czckgver29cna.jpg',1,20000,7,1,19,'Size super bự'),(25,'Giày superstar','https://res.cloudinary.com/dec25/image/upload/v1661695282/a1ihjatcwsg5p0schptr.webp',1,1900000,17,1,21,'White - 43');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_post`
--

DROP TABLE IF EXISTS `like_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_post` (
  `likeID` int NOT NULL AUTO_INCREMENT,
  `state` int DEFAULT '0',
  `userID` int DEFAULT NULL,
  `postID` int DEFAULT NULL,
  PRIMARY KEY (`likeID`),
  KEY `fk_userlike_idx` (`userID`),
  KEY `fk_postlike_idx` (`postID`),
  CONSTRAINT `fk_postlike` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`) ON DELETE CASCADE,
  CONSTRAINT `fk_userlike` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_post`
--

LOCK TABLES `like_post` WRITE;
/*!40000 ALTER TABLE `like_post` DISABLE KEYS */;
INSERT INTO `like_post` VALUES (1,0,1,1),(2,1,1,2),(3,0,1,3),(8,0,3,1),(9,0,3,17),(12,0,20,2),(13,1,1,21),(14,1,3,2);
/*!40000 ALTER TABLE `like_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_agent`
--

DROP TABLE IF EXISTS `order_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_agent` (
  `oaID` int NOT NULL AUTO_INCREMENT,
  `totalPrice` double DEFAULT '0',
  `promoPrice` double DEFAULT '0',
  `agencyID` int DEFAULT NULL,
  `orderID` int DEFAULT NULL,
  `order_agentcol` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `voucherID` int DEFAULT NULL,
  PRIMARY KEY (`oaID`),
  KEY `fk_orderagent_idx` (`agencyID`),
  KEY `fk_orderorderagent_idx` (`orderID`),
  KEY `fk_voucherorderagent_idx` (`voucherID`),
  CONSTRAINT `fk_agentorder` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`),
  CONSTRAINT `fk_orderorderagent` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  CONSTRAINT `fk_voucherorderagent` FOREIGN KEY (`voucherID`) REFERENCES `voucher_agent` (`voucherID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_agent`
--

LOCK TABLES `order_agent` WRITE;
/*!40000 ALTER TABLE `order_agent` DISABLE KEYS */;
INSERT INTO `order_agent` VALUES (1,0,0,1,1,NULL,NULL);
/*!40000 ALTER TABLE `order_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `odID` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT '0',
  `itemID` int DEFAULT NULL,
  `orderAgentID` int DEFAULT NULL,
  PRIMARY KEY (`odID`),
  KEY `fk_itemorderdetails_idx` (`itemID`),
  KEY `fk_orderagentorderdetails_idx` (`orderAgentID`),
  CONSTRAINT `fk_itemorderdetails` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`) ON DELETE CASCADE,
  CONSTRAINT `fk_orderagentorderdetails` FOREIGN KEY (`orderAgentID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,2,1,1),(2,1,2,1),(3,8,3,1),(4,1,7,4),(5,1,7,5),(6,1,8,5),(10,5,2,9),(11,1,3,10),(12,2,7,10),(13,1,8,10),(14,2,4,11),(15,1,7,11),(16,3,8,11),(17,5,4,12),(18,1,8,12),(19,2,3,13),(20,1,3,14);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_state`
--

DROP TABLE IF EXISTS `order_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_state` (
  `osID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`osID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_state`
--

LOCK TABLES `order_state` WRITE;
/*!40000 ALTER TABLE `order_state` DISABLE KEYS */;
INSERT INTO `order_state` VALUES (1,'Wait for confirmation'),(2,'Accepted'),(3,'Packed'),(4,'Shiped'),(5,'Completed');
/*!40000 ALTER TABLE `order_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `paymentState` int DEFAULT '0',
  `paymentType` int DEFAULT NULL,
  `totalPrice` double DEFAULT '0',
  `orderState` int DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `fk_userbuy_idx` (`userID`),
  KEY `fk_paymenttype_idx` (`paymentType`),
  KEY `fk_orderstate_idx` (`orderState`),
  CONSTRAINT `fk_orderstate` FOREIGN KEY (`orderState`) REFERENCES `order_state` (`osID`),
  CONSTRAINT `fk_paymenttype` FOREIGN KEY (`paymentType`) REFERENCES `payment_type` (`ptID`),
  CONSTRAINT `fk_userbuy` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,0,1,31640000,4,'2021-02-10',1),(4,0,1,250000,5,'2022-03-18',20),(5,0,1,550000,5,'2022-04-18',19),(9,0,1,14000000,4,'2022-05-18',19),(10,0,1,3680000,4,'2022-06-18',20),(11,0,1,6970000,3,'2022-07-18',20),(12,0,1,14850000,3,'2022-07-19',21),(13,0,1,5760000,4,'2022-07-20',21),(14,0,1,2880000,2,'2022-08-18',21);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_type`
--

DROP TABLE IF EXISTS `payment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_type` (
  `ptID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ptID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_type`
--

LOCK TABLES `payment_type` WRITE;
/*!40000 ALTER TABLE `payment_type` DISABLE KEYS */;
INSERT INTO `payment_type` VALUES (1,'BY CASH'),(2,'BY PAYPAL '),(3,'BY MOMO E-Wallet');
/*!40000 ALTER TABLE `payment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture_comment`
--

DROP TABLE IF EXISTS `picture_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture_comment` (
  `picID` int NOT NULL AUTO_INCREMENT,
  `image` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `commentID` int DEFAULT NULL,
  PRIMARY KEY (`picID`),
  KEY `fk_piccmt_idx` (`commentID`),
  CONSTRAINT `fk_piccmt` FOREIGN KEY (`commentID`) REFERENCES `comment_post` (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture_comment`
--

LOCK TABLES `picture_comment` WRITE;
/*!40000 ALTER TABLE `picture_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture_post`
--

DROP TABLE IF EXISTS `picture_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture_post` (
  `picID` int NOT NULL AUTO_INCREMENT,
  `image` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `postID` int DEFAULT NULL,
  PRIMARY KEY (`picID`),
  KEY `fk_picpost_idx` (`postID`),
  CONSTRAINT `fk_picpost` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture_post`
--

LOCK TABLES `picture_post` WRITE;
/*!40000 ALTER TABLE `picture_post` DISABLE KEYS */;
INSERT INTO `picture_post` VALUES (1,'https://res.cloudinary.com/dec25/image/upload/v1658942093/products/fea91b2da0c4cea3535a5bd35057cb7e_r2thz1.png',NULL,1),(3,'https://res.cloudinary.com/dec25/image/upload/v1658941724/products/rep-11-dep-chat_oho9nw.jpg',NULL,1),(15,'https://res.cloudinary.com/dec25/image/upload/v1661607307/q0czxezlkkb9nnanqvrz.webp',NULL,1),(20,'https://res.cloudinary.com/dec25/image/upload/v1661695357/r20wql4p8b6gpps89otq.jpg',NULL,21),(22,'https://res.cloudinary.com/dec25/image/upload/v1661695485/cgfsi9imqb8l6g8jngur.webp',NULL,21),(23,'https://res.cloudinary.com/dec25/image/upload/v1662115763/hupfbgmx4xhw2xs0vr4g.jpg',NULL,19),(24,'https://res.cloudinary.com/dec25/image/upload/v1662115766/abk7fnxbvpywcb3zgdef.jpg',NULL,19);
/*!40000 ALTER TABLE `picture_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate_post`
--

DROP TABLE IF EXISTS `rate_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate_post` (
  `rateID` int NOT NULL AUTO_INCREMENT,
  `star` int DEFAULT '0',
  `userID` int DEFAULT NULL,
  `postID` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`rateID`),
  KEY `fk_userratepost_idx` (`userID`),
  KEY `fk_postrate_idx` (`postID`),
  CONSTRAINT `fk_postrate` FOREIGN KEY (`postID`) REFERENCES `sale_post` (`postID`),
  CONSTRAINT `fk_userratepost` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate_post`
--

LOCK TABLES `rate_post` WRITE;
/*!40000 ALTER TABLE `rate_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `rate_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_agent`
--

DROP TABLE IF EXISTS `report_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_agent` (
  `reportID` int NOT NULL,
  `title` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `settlement_state` int DEFAULT '0',
  `userID` int DEFAULT NULL,
  `sensorID` int DEFAULT NULL,
  `agencyID` int DEFAULT NULL,
  PRIMARY KEY (`reportID`),
  KEY `fk_sensorreport_idx` (`sensorID`),
  KEY `fk_userreport_idx` (`userID`),
  KEY `fk_reportagent_idx` (`agencyID`),
  CONSTRAINT `fk_reportagent` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`),
  CONSTRAINT `fk_sensorreport` FOREIGN KEY (`sensorID`) REFERENCES `user` (`userID`),
  CONSTRAINT `fk_userreport` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_agent`
--

LOCK TABLES `report_agent` WRITE;
/*!40000 ALTER TABLE `report_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_agent`
--

DROP TABLE IF EXISTS `response_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_agent` (
  `resID` int NOT NULL AUTO_INCREMENT,
  `star` int DEFAULT '0',
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `agencyID` int DEFAULT NULL,
  PRIMARY KEY (`resID`),
  KEY `fk_responseagent_user_idx` (`userID`),
  KEY `fk_responseagnent_agent_idx` (`agencyID`),
  CONSTRAINT `fk_responseagent_user` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `fk_responseagnent_agent` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_agent`
--

LOCK TABLES `response_agent` WRITE;
/*!40000 ALTER TABLE `response_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`roleID`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(3,'ROLE_AGENT_CENSORSHIP'),(2,'ROLE_CUSTOMER_CARE'),(5,'ROLE_GENERAL'),(4,'ROLE_MANAGEMENT_AGENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_post`
--

DROP TABLE IF EXISTS `sale_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_post` (
  `postID` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `isActive` int DEFAULT '1',
  `title` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `finalPrice` double DEFAULT '0',
  `initialPrice` double DEFAULT '0',
  `categoryID` int DEFAULT NULL,
  `manufacturer` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `origin` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `brand` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `agencyID` int DEFAULT NULL,
  `saleStatus` int DEFAULT '1',
  PRIMARY KEY (`postID`),
  KEY `fk_postagency_idx` (`agencyID`),
  KEY `fk_salestaus_idx` (`saleStatus`),
  KEY `fk_category_idx` (`categoryID`),
  CONSTRAINT `fk_category` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`),
  CONSTRAINT `fk_postagency` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`),
  CONSTRAINT `fk_salestaus` FOREIGN KEY (`saleStatus`) REFERENCES `sale_status` (`stID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_post`
--

LOCK TABLES `sale_post` WRITE;
/*!40000 ALTER TABLE `sale_post` DISABLE KEYS */;
INSERT INTO `sale_post` VALUES (1,'https://res.cloudinary.com/dec25/image/upload/v1658942093/products/fea91b2da0c4cea3535a5bd35057cb7e_r2thz1.png','2021-12-15',1,'Giày thể thao Adidas Prophere Chính Hãng',2990000,3000000,6,'Adidas US','USA','Adidas','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim',1,2),(2,'https://xuconcept.com/wp-content/uploads/2018/07/chup-quang-cao.jpg','2021-12-16',1,'Trà Ăn Ngủ Ngon - Chất Lượng Cao',100000,250000,1,'OLongTea.vn','CHINA','OlongTea.vn','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Uty enim ad minim',2,5),(3,'https://namlongfashion.com/wp-content/uploads/2020/03/134.jpg','2021-12-17',1,'Áo Thun Co Dãn Cực Cool Cực Chất',120000,150000,3,'AoQuan.vn','Vietnam','AoQuan.vn','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim',3,2),(17,'https://res.cloudinary.com/dec25/image/upload/v1661362629/lpaynvczpigddssbra77.jpg','2022-08-25',0,'Dép lào 7 màu cá tính dành cho người cá tính',10000,10000000,7,'depxin.com','Chợ Bà Chiểu','depxin.com','Đây là dép lào 7 màu dành cho người cá tính',1,4),(19,'https://res.cloudinary.com/dec25/image/upload/v1661533163/mzf53wc61avxizrugphx.jpg','2022-08-26',0,'Dép tổ ong thương hiệu Gu Chì Xà Neo kết hợp',20000,100000000,6,'Gu Chì Factory','Chợ Bà Chiểu','Xà Neo','Đây là dép tổ màu dành cho người siêu cá tính ',1,2),(21,'https://res.cloudinary.com/dec25/image/upload/v1661695193/t9iu45ia6nmuuncdphkm.webp','2022-08-28',1,'Giày Adidas Superstar Nam Chính Hãng',1900000,2000000,6,'depxin.com','USA','Adidas','Đây là giày adidas dành cho người siêu cá tính ',1,4);
/*!40000 ALTER TABLE `sale_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_status`
--

DROP TABLE IF EXISTS `sale_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_status` (
  `stID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`stID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_status`
--

LOCK TABLES `sale_status` WRITE;
/*!40000 ALTER TABLE `sale_status` DISABLE KEYS */;
INSERT INTO `sale_status` VALUES (1,'IN STOCK'),(2,'BEST SELLER'),(3,'PROMOTION'),(4,'SUPER SALE'),(5,'FREE SHIP'),(6,'TRENDING');
/*!40000 ALTER TABLE `sale_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `isActive` int DEFAULT '1',
  `avatar` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lastName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` int DEFAULT '3',
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role` int DEFAULT '5',
  `authProvider` int DEFAULT '1',
  `joinedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_userrole_idx` (`role`),
  KEY `fk_usergender_idx` (`gender`),
  KEY `fk_userauth_idx` (`authProvider`),
  CONSTRAINT `fk_userauth` FOREIGN KEY (`authProvider`) REFERENCES `auth_provider` (`authID`),
  CONSTRAINT `fk_usergender` FOREIGN KEY (`gender`) REFERENCES `gender` (`genderID`),
  CONSTRAINT `fk_userrole` FOREIGN KEY (`role`) REFERENCES `role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'https://res.cloudinary.com/dec25/image/upload/v1661088095/afshxqgiktgjlxqhp6jv.jpg','thunv.admin','$2a$10$GKQIIAAugD89SE62XmiXg.vdF2qhq.TUAcrLn8Ry2FR4ty2YmEIsK','Thu','Nguyen Van',1,'thunguyenvan@gmail.com','0784301745',NULL,'136/16 Duong Quang Ham, phuong 5, quan Go Vap,tp Ho Chi Minhhhh',1,1,NULL),(3,1,'https://res.cloudinary.com/dec25/image/upload/v1653199820/jchyuzogke4m4mi9h2uc.jpg','thunv.user','$2a$12$8bcZCGD.rAMv011pJ1GHM.vD1/OcF6rP0C7mspvkpEV6PX2KIxx0m','Thuuuu',NULL,1,'1951050080@ou.edu.vn','0877158491',NULL,'phuong 5, quan Go Vap,tp Ho Chi Minh',4,1,NULL),(19,1,'https://res.cloudinary.com/dec25/image/upload/v1661702455/qydgfm6l5xdhimirs9zf.jpg','Thu Văn','$2a$10$uJvAkesxVtcspcM0.giCAeCGZlcq560GgsFDsS.FvW3NCLPjN6OcW',NULL,NULL,NULL,'thuthuvan2512@gmail.com',NULL,NULL,'136/16 Duong Quang Ham, phuong 5, quan Go Vap,tp Ho Chi Minh',5,3,'2022-08-14 21:51:25'),(20,1,'https://lh3.googleusercontent.com/a-/AFdZucr0fHrYbZEPDfc1r8n8p2svkOPBXZwNaBQi7qAYsg=s96-c','1951050080thu','$2a$10$UUAWkK7jKVs44f798GQEjOe.qnxRQgCpl1M2gcMw84pAn/v0vg7y.','Thu','Van Nguyen',NULL,'1951050080thu@ou.edu.vn',NULL,NULL,'136/16 Duong Quang Ham, phuong 5, quan Go Vap,tp Ho Chi Minh',4,2,'2022-08-18 19:24:50'),(21,1,'https://lh3.googleusercontent.com/a-/AFdZucoI-twPiKbvclwQRRtSnwqyVnTJaSGZobCzJiLON5s=s96-c','thunguyenvan2512','$2a$10$iSaS5gWsCPFcuwIBZA1Gyex14WlusgOKOLf3bBNQk/UIlLvDvBWHq',NULL,NULL,NULL,'thunguyenvan2512@gmail.com',NULL,NULL,'136/16 Duong Quang Ham, phuong 5, quan Go Vap,tp Ho Chi Minh',5,2,'2022-08-18 23:04:26');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher_agent`
--

DROP TABLE IF EXISTS `voucher_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher_agent` (
  `voucherID` int NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `percentDiscount` double DEFAULT '0',
  `createdDate` datetime DEFAULT NULL,
  `expiredDate` datetime DEFAULT NULL,
  `times` int DEFAULT '1',
  `agencyID` int DEFAULT NULL,
  PRIMARY KEY (`voucherID`),
  KEY `fk_agencyvoucher_idx` (`agencyID`),
  CONSTRAINT `fk_agencyvoucher` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher_agent`
--

LOCK TABLES `voucher_agent` WRITE;
/*!40000 ALTER TABLE `voucher_agent` DISABLE KEYS */;
INSERT INTO `voucher_agent` VALUES (1,'CHAOBANMOI',0.05,NULL,NULL,1,1);
/*!40000 ALTER TABLE `voucher_agent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-02 18:26:30
