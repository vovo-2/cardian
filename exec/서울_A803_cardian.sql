-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: i10a803.p.ssafy.io    Database: cardian
-- ------------------------------------------------------
-- Server version	11.2.2-MariaDB-1:11.2.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accumulate_benefit`
--

DROP TABLE IF EXISTS `accumulate_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accumulate_benefit` (
  `benefit_amount` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(10) NOT NULL,
  `my_card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accumulate_benefit`
--

LOCK TABLES `accumulate_benefit` WRITE;
/*!40000 ALTER TABLE `accumulate_benefit` DISABLE KEYS */;
INSERT INTO `accumulate_benefit` VALUES (0,1,'C001',1),(0,2,'C002',1),(0,3,'C003',1),(0,4,'C004',1),(0,5,'C005',1),(0,6,'C006',1),(0,7,'C007',1),(0,8,'C008',1),(2965,9,'C009',1),(0,10,'C010',1),(0,11,'C011',1),(0,12,'C012',1),(0,13,'C001',2),(0,14,'C002',2),(0,15,'C003',2),(0,16,'C004',2),(0,17,'C005',2),(0,18,'C006',2),(0,19,'C007',2),(0,20,'C008',2),(0,21,'C009',2),(1978,22,'C010',2),(0,23,'C011',2),(0,24,'C012',2),(0,25,'C001',3),(0,26,'C002',3),(0,27,'C003',3),(0,28,'C004',3),(0,29,'C005',3),(0,30,'C006',3),(0,31,'C007',3),(0,32,'C008',3),(0,33,'C009',3),(3362,34,'C010',3),(3683,35,'C011',3),(0,36,'C012',3),(0,37,'C001',4),(0,38,'C002',4),(0,39,'C003',4),(0,40,'C004',4),(0,41,'C005',4),(0,42,'C006',4),(0,43,'C007',4),(0,44,'C008',4),(0,45,'C009',4),(0,46,'C010',4),(0,47,'C011',4),(0,48,'C012',4),(0,49,'C001',5),(0,50,'C002',5),(0,51,'C003',5),(0,52,'C004',5),(9710,53,'C005',5),(0,54,'C006',5),(0,55,'C007',5),(0,56,'C008',5),(0,57,'C009',5),(0,58,'C010',5),(0,59,'C011',5),(0,60,'C012',5),(0,61,'C001',6),(0,62,'C002',6),(0,63,'C003',6),(0,64,'C004',6),(0,65,'C005',6),(0,66,'C006',6),(0,67,'C007',6),(0,68,'C008',6),(0,69,'C009',6),(0,70,'C010',6),(0,71,'C011',6),(0,72,'C012',6);
/*!40000 ALTER TABLE `accumulate_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accumulate_category_benefit`
--

DROP TABLE IF EXISTS `accumulate_category_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accumulate_category_benefit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `benefit_amount` int(11) NOT NULL,
  `category_benefit_id` int(11) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  `my_card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accumulate_category_benefit`
--

LOCK TABLES `accumulate_category_benefit` WRITE;
/*!40000 ALTER TABLE `accumulate_category_benefit` DISABLE KEYS */;
INSERT INTO `accumulate_category_benefit` VALUES (1,0,1,'C001',1),(2,0,2,'C002',1),(3,0,3,'C007',1),(4,0,4,'C008',1),(5,2965,5,'C009',1),(6,0,6,'C010',1),(7,0,7,'C011',1),(8,0,8,'C012',1),(9,0,9,'C003',2),(10,0,10,'C005',2),(11,1978,11,'C010',2),(12,0,12,'C011',2),(13,0,13,'C012',2),(14,0,14,'C001',3),(15,0,15,'C004',3),(16,0,37,'C005',3),(17,3362,16,'C010',3),(18,3683,17,'C011',3),(19,0,18,'C001',4),(20,0,19,'C006',4),(21,0,20,'C010',4),(22,0,21,'C011',4),(23,0,22,'C012',4),(24,0,23,'C003',5),(25,0,24,'C004',5),(26,9710,25,'C005',5),(27,0,26,'C008',5),(28,0,27,'C010',5),(29,0,28,'C011',5),(30,0,29,'C012',5),(31,0,30,'C003',6),(32,0,31,'C004',6),(33,0,32,'C005',6),(34,0,33,'C006',6),(35,0,34,'C010',6),(36,0,35,'C011',6),(37,0,36,'C012',6),(38,0,23,'C003',5),(39,0,24,'C004',5),(40,9710,25,'C005',5),(41,0,26,'C008',5),(42,0,27,'C010',5),(43,0,28,'C011',5),(44,0,29,'C012',5),(45,0,30,'C003',6),(46,0,31,'C004',6),(47,0,32,'C005',6),(48,0,33,'C006',6),(49,0,34,'C010',6),(50,0,35,'C011',6),(51,0,36,'C012',6),(52,0,1,'C001',1),(53,0,2,'C002',1),(54,0,3,'C007',1),(55,0,4,'C008',1),(56,2965,5,'C009',1),(57,0,6,'C010',1),(58,0,7,'C011',1),(59,0,8,'C012',1),(60,0,9,'C003',2),(61,0,10,'C005',2),(62,1978,11,'C010',2),(63,0,12,'C011',2),(64,0,13,'C012',2),(65,0,14,'C001',3),(66,0,15,'C004',3),(67,0,37,'C005',3),(68,3362,16,'C010',3),(69,3683,17,'C011',3),(70,0,18,'C001',4),(71,0,1,'C001',1),(72,0,2,'C002',1),(73,0,19,'C006',4),(74,0,3,'C007',1),(75,0,1,'C001',1),(76,0,4,'C008',1),(77,0,20,'C010',4),(78,0,2,'C002',1),(79,2965,5,'C009',1),(80,0,21,'C011',4),(81,0,6,'C010',1),(82,0,22,'C012',4),(83,0,7,'C011',1),(84,0,8,'C012',1),(85,0,3,'C007',1),(86,0,9,'C003',2),(87,0,4,'C008',1),(88,2965,5,'C009',1),(89,0,10,'C005',2),(90,0,6,'C010',1),(91,0,7,'C011',1),(92,0,8,'C012',1),(93,1978,11,'C010',2),(94,0,9,'C003',2),(95,0,12,'C011',2),(96,0,13,'C012',2),(97,0,10,'C005',2),(98,0,14,'C001',3),(99,0,15,'C004',3),(100,0,37,'C005',3),(101,1978,11,'C010',2),(102,0,12,'C011',2),(103,0,13,'C012',2),(104,0,14,'C001',3),(105,3362,16,'C010',3),(106,0,15,'C004',3),(107,3683,17,'C011',3),(108,0,37,'C005',3),(109,0,18,'C001',4),(110,3362,16,'C010',3),(111,3683,17,'C011',3),(112,0,19,'C006',4),(113,0,18,'C001',4),(114,0,20,'C010',4),(115,0,21,'C011',4),(116,0,22,'C012',4),(117,0,19,'C006',4),(118,0,20,'C010',4),(119,0,21,'C011',4),(120,0,22,'C012',4);
/*!40000 ALTER TABLE `accumulate_category_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accumulate_exception_benefit`
--

DROP TABLE IF EXISTS `accumulate_exception_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accumulate_exception_benefit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `benefit_amount` int(11) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  `exception_benefit_id` int(11) NOT NULL,
  `my_card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accumulate_exception_benefit`
--

LOCK TABLES `accumulate_exception_benefit` WRITE;
/*!40000 ALTER TABLE `accumulate_exception_benefit` DISABLE KEYS */;
INSERT INTO `accumulate_exception_benefit` VALUES (1,0,'C007',8,1),(2,0,'C005',3,3),(3,0,'C010',2,3),(4,0,'C006',4,4),(5,0,'C005',5,5),(6,0,'C004',6,6),(7,0,'C005',5,5),(8,0,'C004',6,6),(9,0,'C007',8,1),(10,0,'C005',3,3),(11,0,'C010',2,3),(12,0,'C006',4,4),(13,0,'C007',8,1),(14,0,'C007',8,1),(15,0,'C005',3,3),(16,0,'C010',2,3),(17,0,'C005',3,3),(18,0,'C010',2,3),(19,0,'C006',4,4),(20,0,'C006',4,4);
/*!40000 ALTER TABLE `accumulate_exception_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `associate`
--

DROP TABLE IF EXISTS `associate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `associate` (
  `associate_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`associate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `associate`
--

LOCK TABLES `associate` WRITE;
/*!40000 ALTER TABLE `associate` DISABLE KEYS */;
INSERT INTO `associate` VALUES (1,'C011','https://i.imgur.com/NRkfFHa.png','SKT'),(2,'C011','https://i.imgur.com/YAd2CMx.png','KT'),(3,'C011','https://i.imgur.com/QingQGT.png','LGU+'),(4,'C011','https://i.imgur.com/1Ygo8DQ.png','알뜰폰'),(5,'C012','https://i.imgur.com/uv4ntkU.png','GS25'),(6,'C012','https://i.imgur.com/qh79LY9.jpg','CU'),(7,'C012','https://i.imgur.com/w0enIO5.png','세븐일레븐'),(8,'C012','https://i.imgur.com/SV0viSJ.jpg','이마트24'),(9,'C005','https://i.imgur.com/rt8wUSm.jpeg','올리브영'),(10,'C005','https://i.imgur.com/F373EUy.png','다이소'),(11,'C003','https://i.imgur.com/qs9qo3q.png','유튜브프리미엄'),(12,'C003','https://i.imgur.com/12DTErk.png','넷플릭스'),(13,'C003','https://i.imgur.com/B6LDj4v.png','왓챠'),(14,'C003','https://i.imgur.com/NiJabRZ.png','웨이브'),(15,'C003','https://i.imgur.com/S1SjvCG.png','디즈니플러스'),(16,'C003','https://i.imgur.com/C31b21h.png','티빙'),(17,'C001','https://i.imgur.com/Tek1e11.png','버스'),(18,'C001','https://i.imgur.com/zaXU3D5.png','지하철'),(19,'C001','https://i.imgur.com/cJyzFiw.png','택시'),(20,'C004','https://i.imgur.com/FE9mc5c.jpeg','배달의 민족'),(21,'C004','https://i.imgur.com/8ejCfsV.jpeg','요기요'),(22,'C004','https://i.imgur.com/qjqSgnK.jpeg','쿠팡이츠'),(23,'C004','https://i.imgur.com/KLSKC1k.jpeg','마켓컬리'),(24,'C010','https://i.imgur.com/2EaOSAB.png','스타벅스'),(25,'C010','https://i.imgur.com/CApZYeb.png','이디야커피'),(26,'C010','https://i.imgur.com/xnlvopV.png','투썸플레이스'),(27,'C005','https://i.imgur.com/lmd2vnl.jpeg','리안헤어'),(28,'C005','https://i.imgur.com/YyXalCX.jpeg','박승철헤어스튜디오'),(29,'C010','https://i.imgur.com/xgH9heg.png','커피빈'),(30,'C010','https://i.imgur.com/OLGus1W.jpeg','빽다방'),(31,'C010','https://i.imgur.com/bsSayy3.png','메가커피'),(32,'C010','https://i.imgur.com/nyQNSNf.jpeg','블루보틀'),(33,'C006','https://i.imgur.com/EvvANRF.png','CGV'),(34,'C006','https://i.imgur.com/iTIph5K.png','롯데시네마'),(35,'C006','https://i.imgur.com/0AhaquO.png','메가박스'),(36,'C005','https://i.imgur.com/AYhfT25.jpeg','이철헤어커커'),(37,'C007','https://i.imgur.com/ENGXclU.png','옥션'),(38,'C007','https://i.imgur.com/m9aCSDX.png','G마켓'),(39,'C007','https://i.imgur.com/tnJ9IUB.png','AK몰'),(40,'C007','https://i.imgur.com/lF8huWP.png','11번가'),(41,'C007','https://i.imgur.com/x1Dclgx.png','티켓몬스터'),(42,'C007','https://i.imgur.com/achW7Hi.png','위메프'),(43,'C007','https://i.imgur.com/9a7z6N2.png','쿠팡'),(44,'C007','https://i.imgur.com/DElcxsa.png','인테이크몰'),(45,'C002','https://i.imgur.com/kAT4UrP.png','이마트'),(46,'C002','https://i.imgur.com/L3kNO3x.jpg','롯데마트'),(47,'C002','https://i.imgur.com/w41v67X.jpg','홈플러스'),(48,'C009','https://i.imgur.com/Hg0zlTr.jpg','SK에너지'),(49,'C009','https://i.imgur.com/eAZNIYC.jpg','GS칼텍스'),(50,'C009','https://i.imgur.com/EGk3Zko.png','현대오일뱅크'),(51,'C009','https://i.imgur.com/rsAKZUz.png','S-Oil'),(52,'C008','https://i.imgur.com/or1G49o.jpg','아웃백'),(53,'C008','https://i.imgur.com/ZZWYofB.png','애슐리');
/*!40000 ALTER TABLE `associate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benefit`
--

DROP TABLE IF EXISTS `benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefit` (
  `dtype` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_amount` int(11) NOT NULL,
  `discount_limit` int(11) NOT NULL,
  `discount_line` int(11) NOT NULL,
  `sign` varchar(5) NOT NULL,
  `card_id` int(11) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  `associate_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit`
--

LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `annualfee` int(11) NOT NULL,
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `carddb_id` int(11) NOT NULL,
  `company_id` int(11) DEFAULT NULL,
  `goal` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(400) NOT NULL,
  `benefit_code` enum('DISCOUNT','ACCUMULATE','CASHBACK') DEFAULT NULL,
  `type` enum('CREDIT','CHECK') DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  KEY `FKnjd4v0y61kx3mso04dvbqxaa4` (`company_id`),
  CONSTRAINT `FKnjd4v0y61kx3mso04dvbqxaa4` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (15000,1,1,1,300000,'신한카드 Mr.Life','https://api.card-gorilla.com:8080/storage/card/13/card_img/28201/13card.png','DISCOUNT','CREDIT'),(0,2,2,1,200000,'신한카드 On 체크','https://api.card-gorilla.com:8080/storage/card/2379/card_imgs/30623/2379card_2.png','ACCUMULATE','CHECK'),(20000,3,3,2,300000,'모니모카드','https://api.card-gorilla.com:8080/storage/card/2349/card_imgs/30214/2349card_2.png','DISCOUNT','CREDIT'),(0,4,4,2,300000,'알뜰교통플러스 삼성체크카드','https://api.card-gorilla.com:8080/storage/card/2563/card_img/29688/2563card.png','CASHBACK','CHECK'),(0,5,5,3,300000,'KB국민 My WE:SH 카드','https://api.card-gorilla.com:8080/storage/card/2441/card_imgs/30331/2441card_4.png','DISCOUNT','CREDIT'),(0,6,6,3,300000,'노리2 체크카드','https://api.card-gorilla.com:8080/storage/card/2422/card_img/27141/2422card.png','DISCOUNT','CHECK');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_category_mapping`
--

DROP TABLE IF EXISTS `card_category_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_category_mapping` (
  `associate_id` int(11) DEFAULT NULL,
  `card_id` int(11) NOT NULL,
  `categorybenefit_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmpx2rrax94cb1pqrle0il9bed` (`associate_id`),
  KEY `FK4th8nxblfwbyaedgi1glekgsy` (`categorybenefit_id`),
  CONSTRAINT `FK4th8nxblfwbyaedgi1glekgsy` FOREIGN KEY (`categorybenefit_id`) REFERENCES `category_benefit` (`categorybenefit_id`),
  CONSTRAINT `FKmpx2rrax94cb1pqrle0il9bed` FOREIGN KEY (`associate_id`) REFERENCES `associate` (`associate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_category_mapping`
--

LOCK TABLES `card_category_mapping` WRITE;
/*!40000 ALTER TABLE `card_category_mapping` DISABLE KEYS */;
INSERT INTO `card_category_mapping` VALUES (19,1,1,1,'C001'),(45,1,2,2,'C002'),(46,1,2,3,'C002'),(47,1,2,4,'C002'),(37,1,3,5,'C007'),(38,1,3,6,'C007'),(39,1,3,7,'C007'),(40,1,3,8,'C007'),(41,1,3,9,'C007'),(42,1,3,10,'C007'),(43,1,3,11,'C007'),(52,1,4,12,'C008'),(53,1,4,13,'C008'),(48,1,5,14,'C009'),(49,1,5,15,'C009'),(50,1,5,16,'C009'),(51,1,5,17,'C009'),(24,1,6,18,'C010'),(25,1,6,19,'C010'),(26,1,6,20,'C010'),(29,1,6,21,'C010'),(30,1,6,22,'C010'),(31,1,6,23,'C010'),(32,1,6,24,'C010'),(1,1,7,25,'C011'),(2,1,7,26,'C011'),(3,1,7,27,'C011'),(5,1,8,28,'C012'),(6,1,8,29,'C012'),(7,1,8,30,'C012'),(8,1,8,31,'C012'),(11,2,9,32,'C003'),(12,2,9,33,'C003'),(13,2,9,34,'C003'),(14,2,9,35,'C003'),(15,2,9,36,'C003'),(9,2,10,37,'C005'),(24,2,11,38,'C010'),(25,2,11,39,'C010'),(26,2,11,40,'C010'),(29,2,11,41,'C010'),(30,2,11,42,'C010'),(31,2,11,43,'C010'),(32,2,11,44,'C010'),(1,2,12,45,'C011'),(2,2,12,46,'C011'),(3,2,12,47,'C011'),(5,2,13,48,'C012'),(6,2,13,49,'C012'),(7,2,13,50,'C012'),(8,2,13,51,'C012'),(17,3,14,52,'C001'),(18,3,14,53,'C001'),(19,3,14,54,'C001'),(20,3,15,55,'C004'),(21,3,15,56,'C004'),(22,3,15,57,'C004'),(25,3,16,59,'C010'),(26,3,16,60,'C010'),(29,3,16,61,'C010'),(30,3,16,62,'C010'),(31,3,16,63,'C010'),(1,3,17,65,'C011'),(2,3,17,66,'C011'),(3,3,17,67,'C011'),(4,3,17,68,'C011'),(17,4,18,69,'C001'),(18,4,18,70,'C001'),(34,4,19,71,'C006'),(35,4,19,72,'C006'),(24,4,20,73,'C010'),(25,4,20,74,'C010'),(26,4,20,75,'C010'),(29,4,20,76,'C010'),(32,4,20,77,'C010'),(1,4,21,78,'C011'),(2,4,21,79,'C011'),(3,4,21,80,'C011'),(4,4,21,81,'C011'),(5,4,22,82,'C012'),(6,4,22,83,'C012'),(7,4,22,84,'C012'),(8,4,22,85,'C012'),(11,5,23,86,'C003'),(12,5,23,87,'C003'),(14,5,23,88,'C003'),(15,5,23,89,'C003'),(16,5,23,90,'C003'),(20,5,24,91,'C004'),(21,5,24,92,'C004'),(23,5,24,93,'C004'),(27,5,25,94,'C005'),(28,5,25,95,'C005'),(52,5,26,96,'C008'),(53,5,26,97,'C008'),(24,5,27,98,'C010'),(25,5,27,99,'C010'),(26,5,27,100,'C010'),(29,5,27,101,'C010'),(30,5,27,102,'C010'),(31,5,27,103,'C010'),(32,5,27,104,'C010'),(1,5,28,105,'C011'),(2,5,28,106,'C011'),(3,5,28,107,'C011'),(5,5,29,108,'C012'),(6,5,29,109,'C012'),(11,6,30,110,'C003'),(12,6,30,111,'C003'),(20,6,31,112,'C004'),(21,6,31,113,'C004'),(9,6,32,114,'C005'),(27,6,32,115,'C005'),(28,6,32,116,'C005'),(33,6,33,117,'C006'),(24,6,34,118,'C010'),(29,6,34,119,'C010'),(1,6,35,120,'C011'),(2,6,35,121,'C011'),(3,6,35,122,'C011'),(5,6,36,123,'C012'),(6,6,36,124,'C012');
/*!40000 ALTER TABLE `card_category_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_benefit`
--

DROP TABLE IF EXISTS `category_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_benefit` (
  `card_id` int(11) NOT NULL,
  `categorybenefit_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_amount` int(11) NOT NULL,
  `discount_line` int(11) NOT NULL,
  `sign` varchar(5) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  `discount_limit` int(11) NOT NULL,
  PRIMARY KEY (`categorybenefit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_benefit`
--

LOCK TABLES `category_benefit` WRITE;
/*!40000 ALTER TABLE `category_benefit` DISABLE KEYS */;
INSERT INTO `category_benefit` VALUES (1,1,10,0,'%','C001',10000),(1,2,10,0,'%','C002',50000),(1,3,10,0,'%','C007',10000),(1,4,10,0,'%','C008',10000),(1,5,3,0,'%','C009',9000),(1,6,10,0,'%','C010',10000),(1,7,10,0,'%','C011',5000),(1,8,10,0,'%','C012',5000),(2,9,10,0,'%','C003',8000),(2,10,10,0,'%','C005',8000),(2,11,10,0,'%','C010',8000),(2,12,10,0,'%','C011',8000),(2,13,10,0,'%','C012',8000),(3,14,10,0,'%','C001',5000),(3,15,10,0,'%','C004',5000),(3,16,5,5000,'%','C010',10000),(3,17,10,0,'%','C011',5000),(4,18,10,0,'%','C001',2500),(4,19,2000,5000,'+','C006',30000),(4,20,1000,10000,'+','C010',3000),(4,21,10,0,'%','C011',2500),(4,22,1000,10000,'+','C012',3000),(5,23,30,0,'%','C003',5000),(5,24,5,0,'%','C004',5000),(5,25,5,0,'%','C005',10000),(5,26,10,0,'%','C008',5000),(5,27,5,0,'%','C010',5000),(5,28,10,0,'%','C011',5000),(5,29,10,0,'%','C012',5000),(6,30,1000,10000,'+','C003',2000),(6,31,1000,10000,'+','C004',1000),(6,32,5,0,'%','C005',2000),(6,33,4000,10000,'+','C006',8000),(6,34,10,0,'%','C010',3000),(6,35,2500,50000,'+','C011',2500),(6,36,5,0,'%','C012',2000),(3,37,7,0,'%','C005',5000);
/*!40000 ALTER TABLE `category_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_icon`
--

DROP TABLE IF EXISTS `category_icon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_icon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(10) NOT NULL,
  `icon_image` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_icon`
--

LOCK TABLES `category_icon` WRITE;
/*!40000 ALTER TABLE `category_icon` DISABLE KEYS */;
INSERT INTO `category_icon` VALUES (1,'C001','https://cdn2.iconfinder.com/data/icons/travel-solid-world-is-beautiful/512/Bus-256.png'),(2,'C002','https://cdn3.iconfinder.com/data/icons/business-glyph-vol-01/100/Store-256.png'),(3,'C003','https://cdn3.iconfinder.com/data/icons/ott-media-service-1-3/1024/OTT_media-256.png'),(4,'C004','https://cdn3.iconfinder.com/data/icons/remixicon-map/24/e-bike-2-fill-256.png'),(5,'C005','https://cdn0.iconfinder.com/data/icons/miscellaneous-326-solid/128/cosmetic_makeup_beauty_manicure_lotion_cream_product_package-256.png'),(6,'C006','https://cdn2.iconfinder.com/data/icons/boxicons-solid-vol-1/24/bxs-camera-movie-256.png'),(7,'C007','https://cdn1.iconfinder.com/data/icons/ecommerce-31/24/online_shop_shopping_comfortable_e-commerce_ecommerce_3-256.png'),(8,'C008','https://cdn0.iconfinder.com/data/icons/pixel-perfect-at-24px-volume-2/24/2034-256.png'),(9,'C009','https://cdn2.iconfinder.com/data/icons/boxicons-solid-vol-2/24/bxs-gas-pump-256.png'),(10,'C010','https://cdn1.iconfinder.com/data/icons/andriod-app/32/coffee_cup1-256.png'),(11,'C011','https://cdn0.iconfinder.com/data/icons/essentials-solid-glyphs-vol-1/100/Phone-Call-Telephone-256.png'),(12,'C012','https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_local_convenience_store_48px-256.png');
/*!40000 ALTER TABLE `category_icon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_month_consume`
--

DROP TABLE IF EXISTS `category_month_consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_month_consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(10) NOT NULL,
  `consume` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `my_card_id` int(11) NOT NULL,
  `type` enum('CREDIT','CHECK') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=865 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_month_consume`
--

LOCK TABLES `category_month_consume` WRITE;
/*!40000 ALTER TABLE `category_month_consume` DISABLE KEYS */;
INSERT INTO `category_month_consume` VALUES (1,'C001',0,1,1,'CREDIT'),(2,'C001',0,2,1,'CREDIT'),(3,'C001',3870,3,1,'CREDIT'),(4,'C001',0,4,1,'CREDIT'),(5,'C001',2750,5,1,'CREDIT'),(6,'C001',0,6,1,'CREDIT'),(7,'C001',7470,7,1,'CREDIT'),(8,'C001',45170,8,1,'CREDIT'),(9,'C001',0,9,1,'CREDIT'),(10,'C001',0,10,1,'CREDIT'),(11,'C001',0,11,1,'CREDIT'),(12,'C001',0,12,1,'CREDIT'),(13,'C002',0,1,1,'CREDIT'),(14,'C002',0,2,1,'CREDIT'),(15,'C002',0,3,1,'CREDIT'),(16,'C002',0,4,1,'CREDIT'),(17,'C002',0,5,1,'CREDIT'),(18,'C002',0,6,1,'CREDIT'),(19,'C002',231290,7,1,'CREDIT'),(20,'C002',0,8,1,'CREDIT'),(21,'C002',81880,9,1,'CREDIT'),(22,'C002',0,10,1,'CREDIT'),(23,'C002',252050,11,1,'CREDIT'),(24,'C002',0,12,1,'CREDIT'),(25,'C003',0,1,1,'CREDIT'),(26,'C003',0,2,1,'CREDIT'),(27,'C003',17000,3,1,'CREDIT'),(28,'C003',13900,4,1,'CREDIT'),(29,'C003',12900,5,1,'CREDIT'),(30,'C003',17000,6,1,'CREDIT'),(31,'C003',17000,7,1,'CREDIT'),(32,'C003',0,8,1,'CREDIT'),(33,'C003',12900,9,1,'CREDIT'),(34,'C003',13900,10,1,'CREDIT'),(35,'C003',14900,11,1,'CREDIT'),(36,'C003',14900,12,1,'CREDIT'),(37,'C004',48590,1,1,'CREDIT'),(38,'C004',104480,2,1,'CREDIT'),(39,'C004',0,3,1,'CREDIT'),(40,'C004',40540,4,1,'CREDIT'),(41,'C004',0,5,1,'CREDIT'),(42,'C004',169560,6,1,'CREDIT'),(43,'C004',0,7,1,'CREDIT'),(44,'C004',20630,8,1,'CREDIT'),(45,'C004',0,9,1,'CREDIT'),(46,'C004',0,10,1,'CREDIT'),(47,'C004',0,11,1,'CREDIT'),(48,'C004',100200,12,1,'CREDIT'),(49,'C005',30590,1,1,'CREDIT'),(50,'C005',190070,2,1,'CREDIT'),(51,'C005',72430,3,1,'CREDIT'),(52,'C005',88430,4,1,'CREDIT'),(53,'C005',258430,5,1,'CREDIT'),(54,'C005',185210,6,1,'CREDIT'),(55,'C005',0,7,1,'CREDIT'),(56,'C005',0,8,1,'CREDIT'),(57,'C005',0,9,1,'CREDIT'),(58,'C005',0,10,1,'CREDIT'),(59,'C005',54090,11,1,'CREDIT'),(60,'C005',30140,12,1,'CREDIT'),(61,'C006',51270,1,1,'CREDIT'),(62,'C006',18150,2,1,'CREDIT'),(63,'C006',14190,3,1,'CREDIT'),(64,'C006',27460,4,1,'CREDIT'),(65,'C006',0,5,1,'CREDIT'),(66,'C006',43960,6,1,'CREDIT'),(67,'C006',45310,7,1,'CREDIT'),(68,'C006',0,8,1,'CREDIT'),(69,'C006',0,9,1,'CREDIT'),(70,'C006',0,10,1,'CREDIT'),(71,'C006',29090,11,1,'CREDIT'),(72,'C006',27120,12,1,'CREDIT'),(73,'C007',231530,1,1,'CREDIT'),(74,'C007',169940,2,1,'CREDIT'),(75,'C007',0,3,1,'CREDIT'),(76,'C007',640530,4,1,'CREDIT'),(77,'C007',198610,5,1,'CREDIT'),(78,'C007',570860,6,1,'CREDIT'),(79,'C007',0,7,1,'CREDIT'),(80,'C007',0,8,1,'CREDIT'),(81,'C007',62880,9,1,'CREDIT'),(82,'C007',297040,10,1,'CREDIT'),(83,'C007',184640,11,1,'CREDIT'),(84,'C007',0,12,1,'CREDIT'),(85,'C008',23370,1,1,'CREDIT'),(86,'C008',0,2,1,'CREDIT'),(87,'C008',0,3,1,'CREDIT'),(88,'C008',0,4,1,'CREDIT'),(89,'C008',0,5,1,'CREDIT'),(90,'C008',96710,6,1,'CREDIT'),(91,'C008',0,7,1,'CREDIT'),(92,'C008',0,8,1,'CREDIT'),(93,'C008',53190,9,1,'CREDIT'),(94,'C008',0,10,1,'CREDIT'),(95,'C008',0,11,1,'CREDIT'),(96,'C008',0,12,1,'CREDIT'),(97,'C009',0,1,1,'CREDIT'),(98,'C009',0,2,1,'CREDIT'),(99,'C009',0,3,1,'CREDIT'),(100,'C009',0,4,1,'CREDIT'),(101,'C009',0,5,1,'CREDIT'),(102,'C009',22840,6,1,'CREDIT'),(103,'C009',0,7,1,'CREDIT'),(104,'C009',0,8,1,'CREDIT'),(105,'C009',149360,9,1,'CREDIT'),(106,'C009',94220,10,1,'CREDIT'),(107,'C009',0,11,1,'CREDIT'),(108,'C009',95900,12,1,'CREDIT'),(109,'C010',0,1,1,'CREDIT'),(110,'C010',142270,2,1,'CREDIT'),(111,'C010',9670,3,1,'CREDIT'),(112,'C010',0,4,1,'CREDIT'),(113,'C010',92780,5,1,'CREDIT'),(114,'C010',132200,6,1,'CREDIT'),(115,'C010',63900,7,1,'CREDIT'),(116,'C010',176530,8,1,'CREDIT'),(117,'C010',66890,9,1,'CREDIT'),(118,'C010',41570,10,1,'CREDIT'),(119,'C010',5980,11,1,'CREDIT'),(120,'C010',0,12,1,'CREDIT'),(121,'C011',0,1,1,'CREDIT'),(122,'C011',68680,2,1,'CREDIT'),(123,'C011',0,3,1,'CREDIT'),(124,'C011',0,4,1,'CREDIT'),(125,'C011',77010,5,1,'CREDIT'),(126,'C011',79210,6,1,'CREDIT'),(127,'C011',0,7,1,'CREDIT'),(128,'C011',0,8,1,'CREDIT'),(129,'C011',0,9,1,'CREDIT'),(130,'C011',0,10,1,'CREDIT'),(131,'C011',0,11,1,'CREDIT'),(132,'C011',0,12,1,'CREDIT'),(133,'C012',0,1,1,'CREDIT'),(134,'C012',0,2,1,'CREDIT'),(135,'C012',17250,3,1,'CREDIT'),(136,'C012',0,4,1,'CREDIT'),(137,'C012',0,5,1,'CREDIT'),(138,'C012',0,6,1,'CREDIT'),(139,'C012',0,7,1,'CREDIT'),(140,'C012',42590,8,1,'CREDIT'),(141,'C012',0,9,1,'CREDIT'),(142,'C012',49750,10,1,'CREDIT'),(143,'C012',17950,11,1,'CREDIT'),(144,'C012',0,12,1,'CREDIT'),(145,'C001',2300,1,2,'CHECK'),(146,'C001',0,2,2,'CHECK'),(147,'C001',1990,3,2,'CHECK'),(148,'C001',2980,4,2,'CHECK'),(149,'C001',5290,5,2,'CHECK'),(150,'C001',0,6,2,'CHECK'),(151,'C001',3830,7,2,'CHECK'),(152,'C001',0,8,2,'CHECK'),(153,'C001',0,9,2,'CHECK'),(154,'C001',0,10,2,'CHECK'),(155,'C001',1700,11,2,'CHECK'),(156,'C001',0,12,2,'CHECK'),(157,'C002',282960,1,2,'CHECK'),(158,'C002',0,2,2,'CHECK'),(159,'C002',288840,3,2,'CHECK'),(160,'C002',0,4,2,'CHECK'),(161,'C002',244760,5,2,'CHECK'),(162,'C002',0,6,2,'CHECK'),(163,'C002',0,7,2,'CHECK'),(164,'C002',0,8,2,'CHECK'),(165,'C002',0,9,2,'CHECK'),(166,'C002',0,10,2,'CHECK'),(167,'C002',381340,11,2,'CHECK'),(168,'C002',0,12,2,'CHECK'),(169,'C003',14900,1,2,'CHECK'),(170,'C003',16000,2,2,'CHECK'),(171,'C003',0,3,2,'CHECK'),(172,'C003',0,4,2,'CHECK'),(173,'C003',0,5,2,'CHECK'),(174,'C003',0,6,2,'CHECK'),(175,'C003',0,7,2,'CHECK'),(176,'C003',24800,8,2,'CHECK'),(177,'C003',13900,9,2,'CHECK'),(178,'C003',0,10,2,'CHECK'),(179,'C003',13900,11,2,'CHECK'),(180,'C003',0,12,2,'CHECK'),(181,'C004',0,1,2,'CHECK'),(182,'C004',0,2,2,'CHECK'),(183,'C004',13930,3,2,'CHECK'),(184,'C004',0,4,2,'CHECK'),(185,'C004',114860,5,2,'CHECK'),(186,'C004',0,6,2,'CHECK'),(187,'C004',0,7,2,'CHECK'),(188,'C004',0,8,2,'CHECK'),(189,'C004',0,9,2,'CHECK'),(190,'C004',0,10,2,'CHECK'),(191,'C004',0,11,2,'CHECK'),(192,'C004',0,12,2,'CHECK'),(193,'C005',0,1,2,'CHECK'),(194,'C005',0,2,2,'CHECK'),(195,'C005',93590,3,2,'CHECK'),(196,'C005',18190,4,2,'CHECK'),(197,'C005',0,5,2,'CHECK'),(198,'C005',0,6,2,'CHECK'),(199,'C005',0,7,2,'CHECK'),(200,'C005',0,8,2,'CHECK'),(201,'C005',19990,9,2,'CHECK'),(202,'C005',0,10,2,'CHECK'),(203,'C005',179310,11,2,'CHECK'),(204,'C005',222100,12,2,'CHECK'),(205,'C006',0,1,2,'CHECK'),(206,'C006',57680,2,2,'CHECK'),(207,'C006',43620,3,2,'CHECK'),(208,'C006',0,4,2,'CHECK'),(209,'C006',0,5,2,'CHECK'),(210,'C006',0,6,2,'CHECK'),(211,'C006',0,7,2,'CHECK'),(212,'C006',0,8,2,'CHECK'),(213,'C006',14630,9,2,'CHECK'),(214,'C006',0,10,2,'CHECK'),(215,'C006',0,11,2,'CHECK'),(216,'C006',17270,12,2,'CHECK'),(217,'C007',270730,1,2,'CHECK'),(218,'C007',654370,2,2,'CHECK'),(219,'C007',286350,3,2,'CHECK'),(220,'C007',0,4,2,'CHECK'),(221,'C007',0,5,2,'CHECK'),(222,'C007',0,6,2,'CHECK'),(223,'C007',167010,7,2,'CHECK'),(224,'C007',0,8,2,'CHECK'),(225,'C007',247220,9,2,'CHECK'),(226,'C007',0,10,2,'CHECK'),(227,'C007',181090,11,2,'CHECK'),(228,'C007',0,12,2,'CHECK'),(229,'C008',89540,1,2,'CHECK'),(230,'C008',82010,2,2,'CHECK'),(231,'C008',0,3,2,'CHECK'),(232,'C008',0,4,2,'CHECK'),(233,'C008',34140,5,2,'CHECK'),(234,'C008',0,6,2,'CHECK'),(235,'C008',0,7,2,'CHECK'),(236,'C008',0,8,2,'CHECK'),(237,'C008',0,9,2,'CHECK'),(238,'C008',0,10,2,'CHECK'),(239,'C008',0,11,2,'CHECK'),(240,'C008',0,12,2,'CHECK'),(241,'C009',0,1,2,'CHECK'),(242,'C009',85340,2,2,'CHECK'),(243,'C009',0,3,2,'CHECK'),(244,'C009',0,4,2,'CHECK'),(245,'C009',0,5,2,'CHECK'),(246,'C009',0,6,2,'CHECK'),(247,'C009',0,7,2,'CHECK'),(248,'C009',0,8,2,'CHECK'),(249,'C009',88820,9,2,'CHECK'),(250,'C009',0,10,2,'CHECK'),(251,'C009',0,11,2,'CHECK'),(252,'C009',0,12,2,'CHECK'),(253,'C010',73660,1,2,'CHECK'),(254,'C010',85710,2,2,'CHECK'),(255,'C010',59730,3,2,'CHECK'),(256,'C010',14010,4,2,'CHECK'),(257,'C010',0,5,2,'CHECK'),(258,'C010',0,6,2,'CHECK'),(259,'C010',0,7,2,'CHECK'),(260,'C010',0,8,2,'CHECK'),(261,'C010',95170,9,2,'CHECK'),(262,'C010',26510,10,2,'CHECK'),(263,'C010',17410,11,2,'CHECK'),(264,'C010',19780,12,2,'CHECK'),(265,'C011',0,1,2,'CHECK'),(266,'C011',0,2,2,'CHECK'),(267,'C011',0,3,2,'CHECK'),(268,'C011',0,4,2,'CHECK'),(269,'C011',0,5,2,'CHECK'),(270,'C011',0,6,2,'CHECK'),(271,'C011',0,7,2,'CHECK'),(272,'C011',0,8,2,'CHECK'),(273,'C011',0,9,2,'CHECK'),(274,'C011',0,10,2,'CHECK'),(275,'C011',35500,11,2,'CHECK'),(276,'C011',0,12,2,'CHECK'),(277,'C012',0,1,2,'CHECK'),(278,'C012',0,2,2,'CHECK'),(279,'C012',0,3,2,'CHECK'),(280,'C012',33950,4,2,'CHECK'),(281,'C012',43760,5,2,'CHECK'),(282,'C012',41950,6,2,'CHECK'),(283,'C012',11870,7,2,'CHECK'),(284,'C012',0,8,2,'CHECK'),(285,'C012',0,9,2,'CHECK'),(286,'C012',0,10,2,'CHECK'),(287,'C012',0,11,2,'CHECK'),(288,'C012',0,12,2,'CHECK'),(289,'C001',0,1,3,'CREDIT'),(290,'C001',0,2,3,'CREDIT'),(291,'C001',0,3,3,'CREDIT'),(292,'C001',0,4,3,'CREDIT'),(293,'C001',0,5,3,'CREDIT'),(294,'C001',1950,6,3,'CREDIT'),(295,'C001',0,7,3,'CREDIT'),(296,'C001',0,8,3,'CREDIT'),(297,'C001',0,9,3,'CREDIT'),(298,'C001',5670,10,3,'CREDIT'),(299,'C001',0,11,3,'CREDIT'),(300,'C001',0,12,3,'CREDIT'),(301,'C002',231090,1,3,'CREDIT'),(302,'C002',0,2,3,'CREDIT'),(303,'C002',207160,3,3,'CREDIT'),(304,'C002',0,4,3,'CREDIT'),(305,'C002',0,5,3,'CREDIT'),(306,'C002',0,6,3,'CREDIT'),(307,'C002',0,7,3,'CREDIT'),(308,'C002',78590,8,3,'CREDIT'),(309,'C002',0,9,3,'CREDIT'),(310,'C002',0,10,3,'CREDIT'),(311,'C002',0,11,3,'CREDIT'),(312,'C002',0,12,3,'CREDIT'),(313,'C003',0,1,3,'CREDIT'),(314,'C003',4900,2,3,'CREDIT'),(315,'C003',12900,3,3,'CREDIT'),(316,'C003',0,4,3,'CREDIT'),(317,'C003',0,5,3,'CREDIT'),(318,'C003',0,6,3,'CREDIT'),(319,'C003',27800,7,3,'CREDIT'),(320,'C003',16000,8,3,'CREDIT'),(321,'C003',24400,9,3,'CREDIT'),(322,'C003',0,10,3,'CREDIT'),(323,'C003',0,11,3,'CREDIT'),(324,'C003',4900,12,3,'CREDIT'),(325,'C004',16320,1,3,'CREDIT'),(326,'C004',60270,2,3,'CREDIT'),(327,'C004',0,3,3,'CREDIT'),(328,'C004',0,4,3,'CREDIT'),(329,'C004',0,5,3,'CREDIT'),(330,'C004',0,6,3,'CREDIT'),(331,'C004',72280,7,3,'CREDIT'),(332,'C004',0,8,3,'CREDIT'),(333,'C004',0,9,3,'CREDIT'),(334,'C004',0,10,3,'CREDIT'),(335,'C004',0,11,3,'CREDIT'),(336,'C004',0,12,3,'CREDIT'),(337,'C005',97210,1,3,'CREDIT'),(338,'C005',0,2,3,'CREDIT'),(339,'C005',16460,3,3,'CREDIT'),(340,'C005',83320,4,3,'CREDIT'),(341,'C005',165330,5,3,'CREDIT'),(342,'C005',247390,6,3,'CREDIT'),(343,'C005',0,7,3,'CREDIT'),(344,'C005',46570,8,3,'CREDIT'),(345,'C005',216440,9,3,'CREDIT'),(346,'C005',95740,10,3,'CREDIT'),(347,'C005',0,11,3,'CREDIT'),(348,'C005',0,12,3,'CREDIT'),(349,'C006',49880,1,3,'CREDIT'),(350,'C006',0,2,3,'CREDIT'),(351,'C006',22800,3,3,'CREDIT'),(352,'C006',0,4,3,'CREDIT'),(353,'C006',0,5,3,'CREDIT'),(354,'C006',0,6,3,'CREDIT'),(355,'C006',19700,7,3,'CREDIT'),(356,'C006',0,8,3,'CREDIT'),(357,'C006',0,9,3,'CREDIT'),(358,'C006',0,10,3,'CREDIT'),(359,'C006',0,11,3,'CREDIT'),(360,'C006',37590,12,3,'CREDIT'),(361,'C007',251770,1,3,'CREDIT'),(362,'C007',0,2,3,'CREDIT'),(363,'C007',0,3,3,'CREDIT'),(364,'C007',0,4,3,'CREDIT'),(365,'C007',250890,5,3,'CREDIT'),(366,'C007',171340,6,3,'CREDIT'),(367,'C007',94530,7,3,'CREDIT'),(368,'C007',0,8,3,'CREDIT'),(369,'C007',0,9,3,'CREDIT'),(370,'C007',254690,10,3,'CREDIT'),(371,'C007',404760,11,3,'CREDIT'),(372,'C007',0,12,3,'CREDIT'),(373,'C008',0,1,3,'CREDIT'),(374,'C008',0,2,3,'CREDIT'),(375,'C008',0,3,3,'CREDIT'),(376,'C008',0,4,3,'CREDIT'),(377,'C008',0,5,3,'CREDIT'),(378,'C008',78910,6,3,'CREDIT'),(379,'C008',63350,7,3,'CREDIT'),(380,'C008',0,8,3,'CREDIT'),(381,'C008',0,9,3,'CREDIT'),(382,'C008',97620,10,3,'CREDIT'),(383,'C008',0,11,3,'CREDIT'),(384,'C008',0,12,3,'CREDIT'),(385,'C009',33190,1,3,'CREDIT'),(386,'C009',12310,2,3,'CREDIT'),(387,'C009',71120,3,3,'CREDIT'),(388,'C009',0,4,3,'CREDIT'),(389,'C009',0,5,3,'CREDIT'),(390,'C009',73340,6,3,'CREDIT'),(391,'C009',0,7,3,'CREDIT'),(392,'C009',50400,8,3,'CREDIT'),(393,'C009',79370,9,3,'CREDIT'),(394,'C009',0,10,3,'CREDIT'),(395,'C009',0,11,3,'CREDIT'),(396,'C009',0,12,3,'CREDIT'),(397,'C010',11690,1,3,'CREDIT'),(398,'C010',61050,2,3,'CREDIT'),(399,'C010',73320,3,3,'CREDIT'),(400,'C010',78390,4,3,'CREDIT'),(401,'C010',0,5,3,'CREDIT'),(402,'C010',68140,6,3,'CREDIT'),(403,'C010',14690,7,3,'CREDIT'),(404,'C010',0,8,3,'CREDIT'),(405,'C010',0,9,3,'CREDIT'),(406,'C010',24630,10,3,'CREDIT'),(407,'C010',11020,11,3,'CREDIT'),(408,'C010',162390,12,3,'CREDIT'),(409,'C011',0,1,3,'CREDIT'),(410,'C011',0,2,3,'CREDIT'),(411,'C011',0,3,3,'CREDIT'),(412,'C011',0,4,3,'CREDIT'),(413,'C011',0,5,3,'CREDIT'),(414,'C011',0,6,3,'CREDIT'),(415,'C011',0,7,3,'CREDIT'),(416,'C011',0,8,3,'CREDIT'),(417,'C011',0,9,3,'CREDIT'),(418,'C011',0,10,3,'CREDIT'),(419,'C011',0,11,3,'CREDIT'),(420,'C011',33150,12,3,'CREDIT'),(421,'C012',59900,1,3,'CREDIT'),(422,'C012',0,2,3,'CREDIT'),(423,'C012',0,3,3,'CREDIT'),(424,'C012',0,4,3,'CREDIT'),(425,'C012',39920,5,3,'CREDIT'),(426,'C012',0,6,3,'CREDIT'),(427,'C012',52890,7,3,'CREDIT'),(428,'C012',50250,8,3,'CREDIT'),(429,'C012',56500,9,3,'CREDIT'),(430,'C012',0,10,3,'CREDIT'),(431,'C012',25590,11,3,'CREDIT'),(432,'C012',0,12,3,'CREDIT'),(433,'C001',3340,1,4,'CHECK'),(434,'C001',2330,2,4,'CHECK'),(435,'C001',0,3,4,'CHECK'),(436,'C001',0,4,4,'CHECK'),(437,'C001',0,5,4,'CHECK'),(438,'C001',0,6,4,'CHECK'),(439,'C001',1900,7,4,'CHECK'),(440,'C001',0,8,4,'CHECK'),(441,'C001',0,9,4,'CHECK'),(442,'C001',0,10,4,'CHECK'),(443,'C001',0,11,4,'CHECK'),(444,'C001',0,12,4,'CHECK'),(445,'C002',31700,1,4,'CHECK'),(446,'C002',153130,2,4,'CHECK'),(447,'C002',0,3,4,'CHECK'),(448,'C002',0,4,4,'CHECK'),(449,'C002',0,5,4,'CHECK'),(450,'C002',0,6,4,'CHECK'),(451,'C002',0,7,4,'CHECK'),(452,'C002',0,8,4,'CHECK'),(453,'C002',0,9,4,'CHECK'),(454,'C002',0,10,4,'CHECK'),(455,'C002',0,11,4,'CHECK'),(456,'C002',199720,12,4,'CHECK'),(457,'C003',0,1,4,'CHECK'),(458,'C003',13900,2,4,'CHECK'),(459,'C003',0,3,4,'CHECK'),(460,'C003',22800,4,4,'CHECK'),(461,'C003',9500,5,4,'CHECK'),(462,'C003',30900,6,4,'CHECK'),(463,'C003',9900,7,4,'CHECK'),(464,'C003',13500,8,4,'CHECK'),(465,'C003',0,9,4,'CHECK'),(466,'C003',13500,10,4,'CHECK'),(467,'C003',17000,11,4,'CHECK'),(468,'C003',0,12,4,'CHECK'),(469,'C004',31180,1,4,'CHECK'),(470,'C004',0,2,4,'CHECK'),(471,'C004',0,3,4,'CHECK'),(472,'C004',116770,4,4,'CHECK'),(473,'C004',69580,5,4,'CHECK'),(474,'C004',0,6,4,'CHECK'),(475,'C004',0,7,4,'CHECK'),(476,'C004',16940,8,4,'CHECK'),(477,'C004',0,9,4,'CHECK'),(478,'C004',0,10,4,'CHECK'),(479,'C004',59750,11,4,'CHECK'),(480,'C004',25010,12,4,'CHECK'),(481,'C005',0,1,4,'CHECK'),(482,'C005',12140,2,4,'CHECK'),(483,'C005',0,3,4,'CHECK'),(484,'C005',0,4,4,'CHECK'),(485,'C005',160280,5,4,'CHECK'),(486,'C005',0,6,4,'CHECK'),(487,'C005',0,7,4,'CHECK'),(488,'C005',138590,8,4,'CHECK'),(489,'C005',78510,9,4,'CHECK'),(490,'C005',59330,10,4,'CHECK'),(491,'C005',133570,11,4,'CHECK'),(492,'C005',19680,12,4,'CHECK'),(493,'C006',39180,1,4,'CHECK'),(494,'C006',0,2,4,'CHECK'),(495,'C006',27270,3,4,'CHECK'),(496,'C006',0,4,4,'CHECK'),(497,'C006',0,5,4,'CHECK'),(498,'C006',0,6,4,'CHECK'),(499,'C006',22250,7,4,'CHECK'),(500,'C006',50090,8,4,'CHECK'),(501,'C006',0,9,4,'CHECK'),(502,'C006',27750,10,4,'CHECK'),(503,'C006',0,11,4,'CHECK'),(504,'C006',0,12,4,'CHECK'),(505,'C007',234420,1,4,'CHECK'),(506,'C007',56000,2,4,'CHECK'),(507,'C007',265330,3,4,'CHECK'),(508,'C007',162230,4,4,'CHECK'),(509,'C007',0,5,4,'CHECK'),(510,'C007',0,6,4,'CHECK'),(511,'C007',328260,7,4,'CHECK'),(512,'C007',109220,8,4,'CHECK'),(513,'C007',0,9,4,'CHECK'),(514,'C007',453050,10,4,'CHECK'),(515,'C007',424110,11,4,'CHECK'),(516,'C007',289810,12,4,'CHECK'),(517,'C008',155050,1,4,'CHECK'),(518,'C008',63620,2,4,'CHECK'),(519,'C008',0,3,4,'CHECK'),(520,'C008',0,4,4,'CHECK'),(521,'C008',0,5,4,'CHECK'),(522,'C008',0,6,4,'CHECK'),(523,'C008',35410,7,4,'CHECK'),(524,'C008',0,8,4,'CHECK'),(525,'C008',0,9,4,'CHECK'),(526,'C008',0,10,4,'CHECK'),(527,'C008',0,11,4,'CHECK'),(528,'C008',38370,12,4,'CHECK'),(529,'C009',12310,1,4,'CHECK'),(530,'C009',0,2,4,'CHECK'),(531,'C009',0,3,4,'CHECK'),(532,'C009',0,4,4,'CHECK'),(533,'C009',0,5,4,'CHECK'),(534,'C009',0,6,4,'CHECK'),(535,'C009',0,7,4,'CHECK'),(536,'C009',0,8,4,'CHECK'),(537,'C009',0,9,4,'CHECK'),(538,'C009',76980,10,4,'CHECK'),(539,'C009',0,11,4,'CHECK'),(540,'C009',0,12,4,'CHECK'),(541,'C010',0,1,4,'CHECK'),(542,'C010',0,2,4,'CHECK'),(543,'C010',0,3,4,'CHECK'),(544,'C010',0,4,4,'CHECK'),(545,'C010',0,5,4,'CHECK'),(546,'C010',152660,6,4,'CHECK'),(547,'C010',46680,7,4,'CHECK'),(548,'C010',0,8,4,'CHECK'),(549,'C010',69770,9,4,'CHECK'),(550,'C010',0,10,4,'CHECK'),(551,'C010',0,11,4,'CHECK'),(552,'C010',13080,12,4,'CHECK'),(553,'C011',0,1,4,'CHECK'),(554,'C011',0,2,4,'CHECK'),(555,'C011',0,3,4,'CHECK'),(556,'C011',0,4,4,'CHECK'),(557,'C011',0,5,4,'CHECK'),(558,'C011',0,6,4,'CHECK'),(559,'C011',0,7,4,'CHECK'),(560,'C011',0,8,4,'CHECK'),(561,'C011',0,9,4,'CHECK'),(562,'C011',0,10,4,'CHECK'),(563,'C011',0,11,4,'CHECK'),(564,'C011',0,12,4,'CHECK'),(565,'C012',79660,1,4,'CHECK'),(566,'C012',6780,2,4,'CHECK'),(567,'C012',16450,3,4,'CHECK'),(568,'C012',11570,4,4,'CHECK'),(569,'C012',27850,5,4,'CHECK'),(570,'C012',8700,6,4,'CHECK'),(571,'C012',62500,7,4,'CHECK'),(572,'C012',25950,8,4,'CHECK'),(573,'C012',0,9,4,'CHECK'),(574,'C012',0,10,4,'CHECK'),(575,'C012',0,11,4,'CHECK'),(576,'C012',0,12,4,'CHECK'),(577,'C001',0,1,5,'CREDIT'),(578,'C001',0,2,5,'CREDIT'),(579,'C001',0,3,5,'CREDIT'),(580,'C001',40740,4,5,'CREDIT'),(581,'C001',0,5,5,'CREDIT'),(582,'C001',1730,6,5,'CREDIT'),(583,'C001',0,7,5,'CREDIT'),(584,'C001',3170,8,5,'CREDIT'),(585,'C001',4000,9,5,'CREDIT'),(586,'C001',0,10,5,'CREDIT'),(587,'C001',0,11,5,'CREDIT'),(588,'C001',4720,12,5,'CREDIT'),(589,'C002',222520,1,5,'CREDIT'),(590,'C002',0,2,5,'CREDIT'),(591,'C002',0,3,5,'CREDIT'),(592,'C002',0,4,5,'CREDIT'),(593,'C002',348970,5,5,'CREDIT'),(594,'C002',0,6,5,'CREDIT'),(595,'C002',0,7,5,'CREDIT'),(596,'C002',174540,8,5,'CREDIT'),(597,'C002',241160,9,5,'CREDIT'),(598,'C002',0,10,5,'CREDIT'),(599,'C002',248960,11,5,'CREDIT'),(600,'C002',0,12,5,'CREDIT'),(601,'C003',0,1,5,'CREDIT'),(602,'C003',0,2,5,'CREDIT'),(603,'C003',0,3,5,'CREDIT'),(604,'C003',0,4,5,'CREDIT'),(605,'C003',0,5,5,'CREDIT'),(606,'C003',21900,6,5,'CREDIT'),(607,'C003',0,7,5,'CREDIT'),(608,'C003',13900,8,5,'CREDIT'),(609,'C003',0,9,5,'CREDIT'),(610,'C003',17000,10,5,'CREDIT'),(611,'C003',9900,11,5,'CREDIT'),(612,'C003',0,12,5,'CREDIT'),(613,'C004',41510,1,5,'CREDIT'),(614,'C004',0,2,5,'CREDIT'),(615,'C004',0,3,5,'CREDIT'),(616,'C004',59220,4,5,'CREDIT'),(617,'C004',37890,5,5,'CREDIT'),(618,'C004',0,6,5,'CREDIT'),(619,'C004',0,7,5,'CREDIT'),(620,'C004',19600,8,5,'CREDIT'),(621,'C004',0,9,5,'CREDIT'),(622,'C004',0,10,5,'CREDIT'),(623,'C004',0,11,5,'CREDIT'),(624,'C004',0,12,5,'CREDIT'),(625,'C005',197520,1,5,'CREDIT'),(626,'C005',0,2,5,'CREDIT'),(627,'C005',14200,3,5,'CREDIT'),(628,'C005',0,4,5,'CREDIT'),(629,'C005',0,5,5,'CREDIT'),(630,'C005',86680,6,5,'CREDIT'),(631,'C005',158660,7,5,'CREDIT'),(632,'C005',0,8,5,'CREDIT'),(633,'C005',0,9,5,'CREDIT'),(634,'C005',28780,10,5,'CREDIT'),(635,'C005',194230,11,5,'CREDIT'),(636,'C005',184490,12,5,'CREDIT'),(637,'C006',0,1,5,'CREDIT'),(638,'C006',0,2,5,'CREDIT'),(639,'C006',0,3,5,'CREDIT'),(640,'C006',0,4,5,'CREDIT'),(641,'C006',0,5,5,'CREDIT'),(642,'C006',0,6,5,'CREDIT'),(643,'C006',0,7,5,'CREDIT'),(644,'C006',0,8,5,'CREDIT'),(645,'C006',0,9,5,'CREDIT'),(646,'C006',0,10,5,'CREDIT'),(647,'C006',0,11,5,'CREDIT'),(648,'C006',24990,12,5,'CREDIT'),(649,'C007',480050,1,5,'CREDIT'),(650,'C007',0,2,5,'CREDIT'),(651,'C007',49400,3,5,'CREDIT'),(652,'C007',16360,4,5,'CREDIT'),(653,'C007',0,5,5,'CREDIT'),(654,'C007',0,6,5,'CREDIT'),(655,'C007',0,7,5,'CREDIT'),(656,'C007',261750,8,5,'CREDIT'),(657,'C007',107910,9,5,'CREDIT'),(658,'C007',0,10,5,'CREDIT'),(659,'C007',251870,11,5,'CREDIT'),(660,'C007',0,12,5,'CREDIT'),(661,'C008',0,1,5,'CREDIT'),(662,'C008',0,2,5,'CREDIT'),(663,'C008',0,3,5,'CREDIT'),(664,'C008',32630,4,5,'CREDIT'),(665,'C008',0,5,5,'CREDIT'),(666,'C008',0,6,5,'CREDIT'),(667,'C008',0,7,5,'CREDIT'),(668,'C008',0,8,5,'CREDIT'),(669,'C008',99290,9,5,'CREDIT'),(670,'C008',141580,10,5,'CREDIT'),(671,'C008',0,11,5,'CREDIT'),(672,'C008',0,12,5,'CREDIT'),(673,'C009',0,1,5,'CREDIT'),(674,'C009',0,2,5,'CREDIT'),(675,'C009',0,3,5,'CREDIT'),(676,'C009',51510,4,5,'CREDIT'),(677,'C009',0,5,5,'CREDIT'),(678,'C009',0,6,5,'CREDIT'),(679,'C009',61150,7,5,'CREDIT'),(680,'C009',0,8,5,'CREDIT'),(681,'C009',58050,9,5,'CREDIT'),(682,'C009',0,10,5,'CREDIT'),(683,'C009',0,11,5,'CREDIT'),(684,'C009',135730,12,5,'CREDIT'),(685,'C010',0,1,5,'CREDIT'),(686,'C010',66630,2,5,'CREDIT'),(687,'C010',19360,3,5,'CREDIT'),(688,'C010',119640,4,5,'CREDIT'),(689,'C010',0,5,5,'CREDIT'),(690,'C010',0,6,5,'CREDIT'),(691,'C010',101910,7,5,'CREDIT'),(692,'C010',32760,8,5,'CREDIT'),(693,'C010',4720,9,5,'CREDIT'),(694,'C010',55100,10,5,'CREDIT'),(695,'C010',0,11,5,'CREDIT'),(696,'C010',0,12,5,'CREDIT'),(697,'C011',51440,1,5,'CREDIT'),(698,'C011',0,2,5,'CREDIT'),(699,'C011',0,3,5,'CREDIT'),(700,'C011',44800,4,5,'CREDIT'),(701,'C011',0,5,5,'CREDIT'),(702,'C011',46440,6,5,'CREDIT'),(703,'C011',1920,7,5,'CREDIT'),(704,'C011',0,8,5,'CREDIT'),(705,'C011',0,9,5,'CREDIT'),(706,'C011',0,10,5,'CREDIT'),(707,'C011',0,11,5,'CREDIT'),(708,'C011',0,12,5,'CREDIT'),(709,'C012',0,1,5,'CREDIT'),(710,'C012',0,2,5,'CREDIT'),(711,'C012',0,3,5,'CREDIT'),(712,'C012',21400,4,5,'CREDIT'),(713,'C012',0,5,5,'CREDIT'),(714,'C012',0,6,5,'CREDIT'),(715,'C012',0,7,5,'CREDIT'),(716,'C012',21270,8,5,'CREDIT'),(717,'C012',59800,9,5,'CREDIT'),(718,'C012',38510,10,5,'CREDIT'),(719,'C012',27530,11,5,'CREDIT'),(720,'C012',0,12,5,'CREDIT'),(721,'C001',0,1,6,'CHECK'),(722,'C001',0,2,6,'CHECK'),(723,'C001',0,3,6,'CHECK'),(724,'C001',0,4,6,'CHECK'),(725,'C001',0,5,6,'CHECK'),(726,'C001',0,6,6,'CHECK'),(727,'C001',3730,7,6,'CHECK'),(728,'C001',0,8,6,'CHECK'),(729,'C001',0,9,6,'CHECK'),(730,'C001',44030,10,6,'CHECK'),(731,'C001',0,11,6,'CHECK'),(732,'C001',2720,12,6,'CHECK'),(733,'C002',121160,1,6,'CHECK'),(734,'C002',248620,2,6,'CHECK'),(735,'C002',0,3,6,'CHECK'),(736,'C002',261010,4,6,'CHECK'),(737,'C002',0,5,6,'CHECK'),(738,'C002',0,6,6,'CHECK'),(739,'C002',203090,7,6,'CHECK'),(740,'C002',399470,8,6,'CHECK'),(741,'C002',0,9,6,'CHECK'),(742,'C002',60610,10,6,'CHECK'),(743,'C002',74080,11,6,'CHECK'),(744,'C002',0,12,6,'CHECK'),(745,'C003',9900,1,6,'CHECK'),(746,'C003',0,2,6,'CHECK'),(747,'C003',9900,3,6,'CHECK'),(748,'C003',0,4,6,'CHECK'),(749,'C003',4900,5,6,'CHECK'),(750,'C003',9900,6,6,'CHECK'),(751,'C003',0,7,6,'CHECK'),(752,'C003',0,8,6,'CHECK'),(753,'C003',0,9,6,'CHECK'),(754,'C003',0,10,6,'CHECK'),(755,'C003',0,11,6,'CHECK'),(756,'C003',0,12,6,'CHECK'),(757,'C004',0,1,6,'CHECK'),(758,'C004',0,2,6,'CHECK'),(759,'C004',35370,3,6,'CHECK'),(760,'C004',96400,4,6,'CHECK'),(761,'C004',0,5,6,'CHECK'),(762,'C004',68310,6,6,'CHECK'),(763,'C004',0,7,6,'CHECK'),(764,'C004',160440,8,6,'CHECK'),(765,'C004',0,9,6,'CHECK'),(766,'C004',0,10,6,'CHECK'),(767,'C004',0,11,6,'CHECK'),(768,'C004',113060,12,6,'CHECK'),(769,'C005',0,1,6,'CHECK'),(770,'C005',0,2,6,'CHECK'),(771,'C005',0,3,6,'CHECK'),(772,'C005',63600,4,6,'CHECK'),(773,'C005',0,5,6,'CHECK'),(774,'C005',0,6,6,'CHECK'),(775,'C005',0,7,6,'CHECK'),(776,'C005',0,8,6,'CHECK'),(777,'C005',164560,9,6,'CHECK'),(778,'C005',224680,10,6,'CHECK'),(779,'C005',227930,11,6,'CHECK'),(780,'C005',0,12,6,'CHECK'),(781,'C006',0,1,6,'CHECK'),(782,'C006',0,2,6,'CHECK'),(783,'C006',0,3,6,'CHECK'),(784,'C006',0,4,6,'CHECK'),(785,'C006',0,5,6,'CHECK'),(786,'C006',15190,6,6,'CHECK'),(787,'C006',39560,7,6,'CHECK'),(788,'C006',0,8,6,'CHECK'),(789,'C006',24710,9,6,'CHECK'),(790,'C006',16010,10,6,'CHECK'),(791,'C006',0,11,6,'CHECK'),(792,'C006',0,12,6,'CHECK'),(793,'C007',274950,1,6,'CHECK'),(794,'C007',0,2,6,'CHECK'),(795,'C007',33210,3,6,'CHECK'),(796,'C007',0,4,6,'CHECK'),(797,'C007',0,5,6,'CHECK'),(798,'C007',452310,6,6,'CHECK'),(799,'C007',151170,7,6,'CHECK'),(800,'C007',0,8,6,'CHECK'),(801,'C007',221500,9,6,'CHECK'),(802,'C007',0,10,6,'CHECK'),(803,'C007',107070,11,6,'CHECK'),(804,'C007',271650,12,6,'CHECK'),(805,'C008',0,1,6,'CHECK'),(806,'C008',0,2,6,'CHECK'),(807,'C008',0,3,6,'CHECK'),(808,'C008',0,4,6,'CHECK'),(809,'C008',0,5,6,'CHECK'),(810,'C008',0,6,6,'CHECK'),(811,'C008',29430,7,6,'CHECK'),(812,'C008',24510,8,6,'CHECK'),(813,'C008',0,9,6,'CHECK'),(814,'C008',0,10,6,'CHECK'),(815,'C008',0,11,6,'CHECK'),(816,'C008',0,12,6,'CHECK'),(817,'C009',0,1,6,'CHECK'),(818,'C009',59550,2,6,'CHECK'),(819,'C009',63120,3,6,'CHECK'),(820,'C009',106460,4,6,'CHECK'),(821,'C009',80260,5,6,'CHECK'),(822,'C009',0,6,6,'CHECK'),(823,'C009',0,7,6,'CHECK'),(824,'C009',0,8,6,'CHECK'),(825,'C009',0,9,6,'CHECK'),(826,'C009',0,10,6,'CHECK'),(827,'C009',5660,11,6,'CHECK'),(828,'C009',112630,12,6,'CHECK'),(829,'C010',151450,1,6,'CHECK'),(830,'C010',0,2,6,'CHECK'),(831,'C010',82280,3,6,'CHECK'),(832,'C010',21830,4,6,'CHECK'),(833,'C010',17930,5,6,'CHECK'),(834,'C010',73050,6,6,'CHECK'),(835,'C010',0,7,6,'CHECK'),(836,'C010',0,8,6,'CHECK'),(837,'C010',0,9,6,'CHECK'),(838,'C010',10450,10,6,'CHECK'),(839,'C010',0,11,6,'CHECK'),(840,'C010',0,12,6,'CHECK'),(841,'C011',0,1,6,'CHECK'),(842,'C011',0,2,6,'CHECK'),(843,'C011',0,3,6,'CHECK'),(844,'C011',0,4,6,'CHECK'),(845,'C011',0,5,6,'CHECK'),(846,'C011',0,6,6,'CHECK'),(847,'C011',0,7,6,'CHECK'),(848,'C011',0,8,6,'CHECK'),(849,'C011',0,9,6,'CHECK'),(850,'C011',0,10,6,'CHECK'),(851,'C011',0,11,6,'CHECK'),(852,'C011',0,12,6,'CHECK'),(853,'C012',21110,1,6,'CHECK'),(854,'C012',22380,2,6,'CHECK'),(855,'C012',34750,3,6,'CHECK'),(856,'C012',0,4,6,'CHECK'),(857,'C012',0,5,6,'CHECK'),(858,'C012',0,6,6,'CHECK'),(859,'C012',45720,7,6,'CHECK'),(860,'C012',91760,8,6,'CHECK'),(861,'C012',0,9,6,'CHECK'),(862,'C012',0,10,6,'CHECK'),(863,'C012',58170,11,6,'CHECK'),(864,'C012',0,12,6,'CHECK');
/*!40000 ALTER TABLE `category_month_consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `refresh_token` varchar(400) NOT NULL,
  `token_password` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rjim2ojk3cy8pbmn7ntfr467k` (`member_id`),
  CONSTRAINT `FKker57vwakg9ssc6sv3i7imo82` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'신한카드'),(2,'삼성카드'),(3,'KB국민카드');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exception_benefit`
--

DROP TABLE IF EXISTS `exception_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exception_benefit` (
  `associate_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `discount_amount` int(11) NOT NULL,
  `discount_limit` int(11) NOT NULL,
  `discount_line` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sign` varchar(5) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exception_benefit`
--

LOCK TABLES `exception_benefit` WRITE;
/*!40000 ALTER TABLE `exception_benefit` DISABLE KEYS */;
INSERT INTO `exception_benefit` VALUES (24,3,2,50,10000,0,2,'%','C010'),(10,3,2,7,5000,0,3,'%','C005'),(33,4,2,3000,10000,5000,4,'+','C006'),(9,5,3,10,10000,10000,5,'%','C005'),(22,6,3,10,20000,10000,6,'%','C004'),(44,1,1,20,999999,0,8,'%','C007');
/*!40000 ALTER TABLE `exception_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_card`
--

DROP TABLE IF EXISTS `favorite_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_card` (
  `card_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9t0r74hg9mqu0yx693w4g7rds` (`member_id`),
  CONSTRAINT `FK9t0r74hg9mqu0yx693w4g7rds` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_card`
--

LOCK TABLES `favorite_card` WRITE;
/*!40000 ALTER TABLE `favorite_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goal`
--

DROP TABLE IF EXISTS `goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goal` (
  `accumulate` int(11) NOT NULL,
  `achieve` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mycard_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_m47uvh48gowke1w55jw24ako0` (`mycard_id`),
  CONSTRAINT `FKp2l1dwmc600rxuhqekoa6usy6` FOREIGN KEY (`mycard_id`) REFERENCES `my_card` (`mycard_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal`
--

LOCK TABLES `goal` WRITE;
/*!40000 ALTER TABLE `goal` DISABLE KEYS */;
INSERT INTO `goal` VALUES (268260,1,21,1),(259150,1,22,2),(238030,1,23,3),(585670,1,24,4),(349930,1,25,5),(500060,1,26,6);
/*!40000 ALTER TABLE `goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_commom_code`
--

DROP TABLE IF EXISTS `main_commom_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_commom_code` (
  `code` varchar(3) NOT NULL,
  `main_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`main_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_commom_code`
--

LOCK TABLES `main_commom_code` WRITE;
/*!40000 ALTER TABLE `main_commom_code` DISABLE KEYS */;
INSERT INTO `main_commom_code` VALUES ('C',1,'카테고리','카테고리 구분 코드');
/*!40000 ALTER TABLE `main_commom_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `age` int(11) NOT NULL,
  `birth` date NOT NULL,
  `card_member_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `update_date` datetime(6) NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (27,'1998-01-07',1,1,'김민준','01038284948','MALE','2023-12-31 23:59:59.000000'),(27,'1998-01-08',2,2,'김싸피','01012345678','FEMALE','2023-12-31 23:59:59.000000');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthly_card_statistic`
--

DROP TABLE IF EXISTS `monthly_card_statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monthly_card_statistic` (
  `monthlycardstatistic_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` int(11) NOT NULL,
  `my_card_id` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `type` enum('CREDIT','CHECK') NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`monthlycardstatistic_id`),
  KEY `FKd0q3r4kruc4rm5d7kd0dwwahx` (`member_id`),
  CONSTRAINT `FKd0q3r4kruc4rm5d7kd0dwwahx` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly_card_statistic`
--

LOCK TABLES `monthly_card_statistic` WRITE;
/*!40000 ALTER TABLE `monthly_card_statistic` DISABLE KEYS */;
INSERT INTO `monthly_card_statistic` VALUES (1,1,1,385350,'CREDIT',1),(2,2,1,693590,'CREDIT',1),(3,3,1,134410,'CREDIT',1),(4,4,1,810860,'CREDIT',1),(5,5,1,642480,'CREDIT',1),(6,6,1,1317550,'CREDIT',1),(7,7,1,364970,'CREDIT',1),(8,8,1,284920,'CREDIT',1),(9,9,1,427100,'CREDIT',1),(10,10,1,496480,'CREDIT',1),(11,11,1,558700,'CREDIT',1),(12,12,1,268260,'CREDIT',1),(13,1,2,734090,'CHECK',1),(14,2,2,981110,'CHECK',1),(15,3,2,788050,'CHECK',1),(16,4,2,69130,'CHECK',1),(17,5,2,442810,'CHECK',1),(18,6,2,41950,'CHECK',1),(19,7,2,182710,'CHECK',1),(20,8,2,24800,'CHECK',1),(21,9,2,479730,'CHECK',1),(22,10,2,26510,'CHECK',1),(23,11,2,810250,'CHECK',1),(24,12,2,259150,'CHECK',1),(25,1,3,751050,'CREDIT',1),(26,2,3,138530,'CREDIT',1),(27,3,3,403760,'CREDIT',1),(28,4,3,161710,'CREDIT',1),(29,5,3,456140,'CREDIT',1),(30,6,3,641070,'CREDIT',1),(31,7,3,345240,'CREDIT',1),(32,8,3,241810,'CREDIT',1),(33,9,3,376710,'CREDIT',1),(34,10,3,478350,'CREDIT',1),(35,11,3,441370,'CREDIT',1),(36,12,3,238030,'CREDIT',1),(37,1,4,586840,'CHECK',1),(38,2,4,307900,'CHECK',1),(39,3,4,309050,'CHECK',1),(40,4,4,313370,'CHECK',1),(41,5,4,267210,'CHECK',1),(42,6,4,192260,'CHECK',1),(43,7,4,506900,'CHECK',1),(44,8,4,354290,'CHECK',1),(45,9,4,148280,'CHECK',1),(46,10,4,630610,'CHECK',1),(47,11,4,634430,'CHECK',1),(48,12,4,585670,'CHECK',1),(49,1,5,993040,'CREDIT',2),(50,2,5,66630,'CREDIT',2),(51,3,5,82960,'CREDIT',2),(52,4,5,386300,'CREDIT',2),(53,5,5,386860,'CREDIT',2),(54,6,5,156750,'CREDIT',2),(55,7,5,323640,'CREDIT',2),(56,8,5,526990,'CREDIT',2),(57,9,5,574930,'CREDIT',2),(58,10,5,280970,'CREDIT',2),(59,11,5,732490,'CREDIT',2),(60,12,5,349930,'CREDIT',2),(61,1,6,578570,'CHECK',2),(62,2,6,330550,'CHECK',2),(63,3,6,258630,'CHECK',2),(64,4,6,549300,'CHECK',2),(65,5,6,103090,'CHECK',2),(66,6,6,618760,'CHECK',2),(67,7,6,472700,'CHECK',2),(68,8,6,676180,'CHECK',2),(69,9,6,410770,'CHECK',2),(70,10,6,355780,'CHECK',2),(71,11,6,472910,'CHECK',2),(72,12,6,500060,'CHECK',2);
/*!40000 ALTER TABLE `monthly_card_statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_card`
--

DROP TABLE IF EXISTS `my_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_card` (
  `card_id` int(11) DEFAULT NULL,
  `expire_date` date NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `mycard_id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL,
  PRIMARY KEY (`mycard_id`),
  KEY `FK8mdspqvbwovi0ofol7cgddvhg` (`card_id`),
  KEY `FK76c7fjqruvo645owibe84sicl` (`member_id`),
  CONSTRAINT `FK76c7fjqruvo645owibe84sicl` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK8mdspqvbwovi0ofol7cgddvhg` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4546 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_card`
--

LOCK TABLES `my_card` WRITE;
/*!40000 ALTER TABLE `my_card` DISABLE KEYS */;
INSERT INTO `my_card` VALUES (1,'2028-12-24',1,1,'4364-0110-8575-7598'),(2,'2027-06-19',1,2,'4364-0114-7568-2546'),(3,'2030-05-12',1,3,'2865-2554-7596-3201'),(4,'2024-10-01',1,4,'2865-2551-1258-7503'),(5,'2025-03-20',2,5,'7598-8950-7741-0210'),(6,'2025-01-10',2,6,'7598-8157-1586-2027');
/*!40000 ALTER TABLE `my_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settlement`
--

DROP TABLE IF EXISTS `settlement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settlement` (
  `annual_cosume` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7okjhinrut7gdoikno00uspew` (`member_id`),
  CONSTRAINT `FKqmsiw656x8um90ysgl3dd2jo0` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settlement`
--

LOCK TABLES `settlement` WRITE;
/*!40000 ALTER TABLE `settlement` DISABLE KEYS */;
INSERT INTO `settlement` VALUES (20735540,1,1,23330000),(10188790,2,2,12000000);
/*!40000 ALTER TABLE `settlement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settlement_standard`
--

DROP TABLE IF EXISTS `settlement_standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settlement_standard` (
  `high` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `low` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settlement_standard`
--

LOCK TABLES `settlement_standard` WRITE;
/*!40000 ALTER TABLE `settlement_standard` DISABLE KEYS */;
INSERT INTO `settlement_standard` VALUES (2500000,1,3000000,20,70000000);
/*!40000 ALTER TABLE `settlement_standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_common_code`
--

DROP TABLE IF EXISTS `sub_common_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_common_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_code` varchar(3) NOT NULL,
  `main_id` int(11) DEFAULT NULL,
  `detail_code` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqlghj7kgfg088m2wuejxn26kr` (`main_id`),
  CONSTRAINT `FKqlghj7kgfg088m2wuejxn26kr` FOREIGN KEY (`main_id`) REFERENCES `main_commom_code` (`main_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_common_code`
--

LOCK TABLES `sub_common_code` WRITE;
/*!40000 ALTER TABLE `sub_common_code` DISABLE KEYS */;
INSERT INTO `sub_common_code` VALUES (1,'C',1,'C001','대중교통','카테고리 판별 코드'),(2,'C',1,'C002','대형마트','카테고리 판별 코드'),(3,'C',1,'C003','디지털구독','카테고리 판별 코드'),(4,'C',1,'C004','배달앱','카테고리 판별 코드'),(5,'C',1,'C005','뷰티','카테고리 판별 코드'),(6,'C',1,'C006','영화','카테고리 판별 코드'),(7,'C',1,'C007','온라인쇼핑','카테고리 판별 코드'),(8,'C',1,'C008','외식','카테고리 판별 코드'),(9,'C',1,'C009','주유','카테고리 판별 코드'),(10,'C',1,'C010','카페','카테고리 판별 코드'),(11,'C',1,'C011','통신','카테고리 판별 코드'),(12,'C',1,'C012','편의점','카테고리 판별 코드');
/*!40000 ALTER TABLE `sub_common_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `mycard_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `day` date NOT NULL,
  `date` datetime NOT NULL,
  `store` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `discount` tinyint(1) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_Transaction_to+mycard_idx` (`mycard_id`),
  CONSTRAINT `FK_Transaction_to+mycard` FOREIGN KEY (`mycard_id`) REFERENCES `my_card` (`mycard_id`)
) ENGINE=InnoDB AUTO_INCREMENT=447 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,6,1,'2023-01-01','2023-01-01 15:38:00','디즈니플러스',9900,1,0),(2,5,4,'2023-01-02','2023-01-02 02:30:00','이마트',20570,0,0),(3,5,8,'2023-01-04','2023-01-04 02:36:00','티켓몬스터',195270,0,1),(4,6,10,'2023-01-05','2023-01-05 02:36:00','스타벅스',62980,1,0),(5,5,13,'2023-01-05','2023-01-05 22:27:00','위메프',97170,0,0),(6,5,17,'2023-01-07','2023-01-07 13:01:00','위메프',66150,0,0),(7,5,26,'2023-01-14','2023-01-14 15:49:00','올리브영',3720,0,0),(8,6,28,'2023-01-16','2023-01-16 19:23:00','이마트',121160,0,1),(9,5,30,'2023-01-17','2023-01-17 16:47:00','이마트',201950,0,1),(10,6,31,'2023-01-18','2023-01-18 13:10:00','티켓몬스터',274950,0,1),(11,5,32,'2023-01-19','2023-01-19 03:31:00','KT',51440,0,0),(12,5,39,'2023-01-25','2023-01-25 11:07:00','쿠팡이츠',41510,1,1),(13,6,40,'2023-01-25','2023-01-25 19:29:00','블루보틀',88470,0,1),(14,6,41,'2023-01-27','2023-01-27 02:06:00','CU',21110,0,0),(15,5,46,'2023-01-29','2023-01-29 01:12:00','박승철헤어스튜디오',193800,0,1),(16,5,50,'2023-01-31','2023-01-31 04:32:00','11번가',121460,0,1),(17,6,53,'2023-02-01','2023-02-01 20:11:00','홈플러스',248620,1,0),(18,5,62,'2023-02-07','2023-02-07 18:19:00','커피빈',66630,0,1),(19,6,74,'2023-02-15','2023-02-15 15:45:00','세븐일레븐',22380,0,0),(20,6,87,'2023-02-27','2023-02-27 19:55:00','GS칼텍스',59550,0,1),(21,6,96,'2023-03-05','2023-03-05 22:55:00','11번가',33210,0,1),(22,5,99,'2023-03-11','2023-03-11 09:51:00','AK몰',49400,1,0),(23,6,104,'2023-03-16','2023-03-16 09:57:00','디즈니플러스',9900,1,1),(24,6,107,'2023-03-18','2023-03-18 22:27:00','마켓컬리',35370,0,1),(25,6,114,'2023-03-23','2023-03-23 01:12:00','이마트24',34750,0,0),(26,6,120,'2023-03-27','2023-03-27 15:07:00','스타벅스',82280,0,1),(27,5,122,'2023-03-28','2023-03-28 18:39:00','다이소',14200,0,1),(28,6,124,'2023-03-29','2023-03-29 18:43:00','SK에너지',63120,0,0),(29,5,126,'2023-03-31','2023-03-31 18:29:00','커피빈',19360,1,0),(30,6,127,'2023-04-04','2023-04-04 00:58:00','S-Oil',81440,1,1),(31,5,131,'2023-04-09','2023-04-09 01:09:00','애슐리',32630,0,0),(32,5,132,'2023-04-09','2023-04-09 01:24:00','블루보틀',94370,0,0),(33,6,139,'2023-04-11','2023-04-11 04:11:00','스타벅스',21830,0,0),(34,5,140,'2023-04-11','2023-04-11 06:44:00','세븐일레븐',21400,0,0),(35,6,143,'2023-04-11','2023-04-11 22:46:00','이마트',261010,0,0),(36,5,144,'2023-04-14','2023-04-14 09:51:00','쿠팡이츠',47120,1,0),(37,6,145,'2023-04-14','2023-04-14 12:50:00','리안헤어',63600,0,0),(38,5,146,'2023-04-15','2023-04-15 03:31:00','택시',40740,0,0),(39,5,151,'2023-04-17','2023-04-17 11:05:00','옥션',16360,1,0),(40,6,153,'2023-04-19','2023-04-19 01:09:00','배달의 민족',96400,0,1),(41,6,155,'2023-04-19','2023-04-19 09:34:00','SK에너지',25020,0,1),(42,5,156,'2023-04-22','2023-04-22 02:36:00','S-Oil',51510,1,1),(43,5,159,'2023-04-26','2023-04-26 15:49:00','KT',44800,1,1),(44,5,160,'2023-04-29','2023-04-29 22:49:00','블루보틀',25270,0,0),(45,5,162,'2023-04-30','2023-04-30 14:48:00','마켓컬리',12100,0,1),(46,6,166,'2023-05-06','2023-05-06 07:20:00','왓챠',4900,0,0),(47,5,168,'2023-05-12','2023-05-12 02:54:00','홈플러스',147130,1,0),(48,5,169,'2023-05-12','2023-05-12 21:36:00','요기요',37890,0,0),(49,6,178,'2023-05-20','2023-05-20 10:45:00','이디야커피',17930,0,1),(50,6,187,'2023-05-29','2023-05-29 07:02:00','S-Oil',80260,1,1),(51,5,190,'2023-05-30','2023-05-30 09:59:00','홈플러스',201840,0,0),(52,6,193,'2023-06-02','2023-06-02 13:17:00','위메프',248340,1,1),(53,5,197,'2023-06-05','2023-06-05 02:59:00','넷플릭스',17000,0,0),(54,5,199,'2023-06-05','2023-06-05 23:58:00','이철헤어커커',33760,1,1),(55,6,203,'2023-06-08','2023-06-08 02:59:00','배달의 민족',68310,0,0),(56,5,204,'2023-06-08','2023-06-08 12:56:00','왓챠',4900,0,0),(57,5,206,'2023-06-10','2023-06-10 12:05:00','지하철',1730,1,0),(58,5,210,'2023-06-17','2023-06-17 11:57:00','KT',46440,0,0),(59,6,217,'2023-06-20','2023-06-20 05:55:00','디즈니플러스',9900,0,0),(60,5,223,'2023-06-23','2023-06-23 23:51:00','다이소',52920,1,1),(61,6,225,'2023-06-24','2023-06-24 23:36:00','티켓몬스터',203970,0,1),(62,6,227,'2023-06-27','2023-06-27 18:20:00','CGV',15190,0,1),(63,6,228,'2023-06-28','2023-06-28 04:29:00','이디야커피',73050,1,0),(64,5,233,'2023-07-02','2023-07-02 09:12:00','블루보틀',67700,0,1),(65,6,234,'2023-07-02','2023-07-02 13:10:00','롯데시네마',16370,0,1),(66,6,236,'2023-07-04','2023-07-04 13:01:00','지하철',3730,0,1),(67,6,238,'2023-07-04','2023-07-04 22:27:00','이마트',119390,0,0),(68,6,243,'2023-07-08','2023-07-08 04:23:00','아웃백',29430,0,0),(69,5,244,'2023-07-11','2023-07-11 18:43:00','빽다방',14470,1,0),(70,6,246,'2023-07-12','2023-07-12 16:03:00','롯데시네마',23190,0,0),(71,5,250,'2023-07-14','2023-07-14 22:27:00','빽다방',19740,1,0),(72,6,249,'2023-07-14','2023-07-14 22:27:00','인테이크몰',151170,0,1),(73,5,251,'2023-07-15','2023-07-15 04:29:00','SK에너지',61150,1,0),(74,6,252,'2023-07-16','2023-07-16 06:56:00','세븐일레븐',17910,1,1),(75,5,254,'2023-07-18','2023-07-18 02:54:00','KT',1920,0,0),(76,5,270,'2023-07-28','2023-07-28 17:33:00','박승철헤어스튜디오',158660,1,1),(77,6,271,'2023-07-29','2023-07-29 19:55:00','이마트',83700,0,0),(78,6,273,'2023-07-31','2023-07-31 10:52:00','CU',23850,0,1),(79,6,274,'2023-07-31','2023-07-31 13:25:00','CU',3960,0,0),(80,5,278,'2023-08-05','2023-08-05 08:47:00','쿠팡이츠',19600,0,1),(81,6,280,'2023-08-05','2023-08-05 18:47:00','이마트',113120,0,0),(82,6,282,'2023-08-06','2023-08-06 07:05:00','GS25',35920,0,0),(83,6,284,'2023-08-08','2023-08-08 01:02:00','세븐일레븐',55840,0,1),(84,5,285,'2023-08-08','2023-08-08 05:55:00','블루보틀',32760,0,1),(85,5,286,'2023-08-08','2023-08-08 05:55:00','디즈니플러스',13900,0,1),(86,5,291,'2023-08-12','2023-08-12 16:10:00','이마트',174540,0,0),(87,6,292,'2023-08-12','2023-08-12 17:33:00','애슐리',24510,0,1),(88,5,296,'2023-08-14','2023-08-14 06:50:00','버스',3170,0,0),(89,6,298,'2023-08-16','2023-08-16 03:44:00','이마트',286350,0,0),(90,6,299,'2023-08-16','2023-08-16 04:29:00','마켓컬리',56930,0,0),(91,5,300,'2023-08-16','2023-08-16 06:44:00','옥션',261750,1,1),(92,5,302,'2023-08-20','2023-08-20 18:38:00','세븐일레븐',21270,0,1),(93,6,304,'2023-08-22','2023-08-22 10:52:00','마켓컬리',103510,0,1),(94,5,310,'2023-09-01','2023-09-01 19:38:00','아웃백',54660,0,0),(95,5,315,'2023-09-07','2023-09-07 19:38:00','인테이크몰',107910,0,1),(96,5,316,'2023-09-08','2023-09-08 11:41:00','애슐리',44630,0,0),(97,6,318,'2023-09-10','2023-09-10 17:33:00','리안헤어',164560,0,0),(98,5,324,'2023-09-16','2023-09-16 21:10:00','세븐일레븐',59800,0,0),(99,6,325,'2023-09-17','2023-09-17 18:20:00','옥션',221500,1,1),(100,5,328,'2023-09-18','2023-09-18 22:57:00','이마트',241160,0,0),(101,5,332,'2023-09-23','2023-09-23 07:02:00','GS칼텍스',58050,1,0),(102,6,333,'2023-09-23','2023-09-23 20:17:00','CGV',24710,0,1),(103,5,335,'2023-09-26','2023-09-26 22:46:00','블루보틀',4720,0,1),(104,5,337,'2023-09-27','2023-09-27 20:17:00','버스',4000,0,0),(105,6,342,'2023-10-01','2023-10-01 15:55:00','리안헤어',112820,0,0),(106,6,346,'2023-10-03','2023-10-03 12:50:00','다이소',111860,0,0),(107,6,347,'2023-10-05','2023-10-05 19:23:00','롯데마트',60610,0,0),(108,5,348,'2023-10-06','2023-10-06 19:23:00','아웃백',59220,1,0),(109,5,349,'2023-10-06','2023-10-06 23:51:00','투썸플레이스',36440,0,1),(110,5,350,'2023-10-07','2023-10-07 11:41:00','넷플릭스',17000,0,0),(111,6,352,'2023-10-10','2023-10-10 00:19:00','롯데시네마',16010,1,1),(112,5,359,'2023-10-18','2023-10-18 07:20:00','빽다방',18660,1,1),(113,6,362,'2023-10-19','2023-10-19 18:47:00','블루보틀',10450,1,0),(114,5,363,'2023-10-23','2023-10-23 18:20:00','아웃백',82360,1,1),(115,5,372,'2023-10-28','2023-10-28 16:10:00','CU',38510,0,1),(116,6,373,'2023-10-29','2023-10-29 11:05:00','택시',44030,1,1),(117,5,374,'2023-10-29','2023-10-29 12:56:00','박승철헤어스튜디오',28780,0,1),(118,5,375,'2023-11-01','2023-11-01 18:47:00','이마트24',27530,1,0),(119,6,376,'2023-11-02','2023-11-02 07:05:00','리안헤어',128520,1,0),(120,6,383,'2023-11-06','2023-11-06 16:03:00','세븐일레븐',58170,1,0),(121,6,385,'2023-11-09','2023-11-09 06:01:00','위메프',107070,0,1),(122,5,388,'2023-11-11','2023-11-11 12:56:00','인테이크몰',251870,0,0),(123,5,396,'2023-11-15','2023-11-15 23:58:00','디즈니플러스',9900,0,1),(124,5,397,'2023-11-16','2023-11-16 06:56:00','이철헤어커커',194230,0,0),(125,6,401,'2023-11-19','2023-11-19 00:49:00','이마트',74080,1,0),(126,5,406,'2023-11-28','2023-11-28 18:37:00','이마트',248960,0,0),(127,6,409,'2023-11-29','2023-11-29 19:29:00','다이소',99410,0,1),(128,6,410,'2023-11-29','2023-11-29 20:35:00','GS칼텍스',5660,0,0),(129,6,419,'2023-12-09','2023-12-09 09:59:00','G마켓',183510,0,0),(130,5,422,'2023-12-11','2023-12-11 07:49:00','SK에너지',66170,0,1),(131,6,427,'2023-12-15','2023-12-15 09:38:00','SK에너지',42170,0,0),(132,6,429,'2023-12-16','2023-12-16 09:51:00','마켓컬리',101020,0,1),(133,5,433,'2023-12-18','2023-12-18 21:30:00','메가박스',24990,1,1),(134,5,435,'2023-12-20','2023-12-20 09:48:00','지하철',2830,0,1),(135,5,437,'2023-12-22','2023-12-22 01:02:00','GS칼텍스',69560,1,0),(136,5,438,'2023-12-22','2023-12-22 14:58:00','박승철헤어스튜디오',184490,0,1),(137,6,441,'2023-12-24','2023-12-24 10:52:00','G마켓',88140,1,1),(138,6,442,'2023-12-24','2023-12-24 15:55:00','마켓컬리',12040,0,1),(139,6,443,'2023-12-24','2023-12-24 15:58:00','현대오일뱅크',70460,0,1),(140,6,444,'2023-12-25','2023-12-25 07:20:00','버스',2720,0,0),(141,5,445,'2023-12-27','2023-12-27 09:12:00','버스',1890,1,0),(142,2,2,'2023-01-01','2023-01-01 18:29:00','홈플러스',282960,0,0),(143,4,3,'2023-01-01','2023-01-01 20:35:00','버스',3340,0,1),(144,4,5,'2023-01-02','2023-01-02 13:01:00','GS25',30290,0,0),(145,4,6,'2023-01-03','2023-01-03 15:49:00','홈플러스',31700,1,0),(146,4,7,'2023-01-03','2023-01-03 19:10:00','CGV',20060,1,1),(147,4,9,'2023-01-04','2023-01-04 16:03:00','애슐리',84820,1,0),(148,3,11,'2023-01-05','2023-01-05 06:44:00','리안헤어',97210,0,1),(149,4,12,'2023-01-05','2023-01-05 11:05:00','세븐일레븐',49370,0,1),(150,3,14,'2023-01-07','2023-01-07 01:24:00','메가박스',22150,0,0),(151,1,15,'2023-01-07','2023-01-07 02:54:00','위메프',92350,0,1),(152,3,16,'2023-01-07','2023-01-07 09:51:00','쿠팡이츠',16320,0,1),(153,3,18,'2023-01-07','2023-01-07 19:32:00','메가커피',7150,0,0),(154,1,19,'2023-01-08','2023-01-08 09:35:00','아웃백',23370,0,1),(155,4,20,'2023-01-11','2023-01-11 12:20:00','메가박스',19120,1,0),(156,3,21,'2023-01-11','2023-01-11 21:30:00','홈플러스',231090,1,0),(157,3,22,'2023-01-12','2023-01-12 06:56:00','인테이크몰',231160,1,1),(158,1,23,'2023-01-12','2023-01-12 09:51:00','배달의 민족',48590,0,0),(159,4,24,'2023-01-13','2023-01-13 18:20:00','애슐리',70230,0,1),(160,4,25,'2023-01-13','2023-01-13 18:54:00','티켓몬스터',212330,1,0),(161,4,27,'2023-01-16','2023-01-16 19:18:00','위메프',22090,0,1),(162,3,29,'2023-01-17','2023-01-17 07:05:00','세븐일레븐',59900,0,0),(163,4,33,'2023-01-20','2023-01-20 04:29:00','마켓컬리',31180,0,0),(164,1,34,'2023-01-20','2023-01-20 07:45:00','CGV',26650,0,0),(165,3,35,'2023-01-20','2023-01-20 08:28:00','메가커피',4540,0,1),(166,1,36,'2023-01-20','2023-01-20 15:55:00','11번가',139180,0,1),(167,1,37,'2023-01-21','2023-01-21 10:37:00','올리브영',30590,0,1),(168,2,38,'2023-01-23','2023-01-23 12:56:00','아웃백',89540,0,0),(169,2,42,'2023-01-27','2023-01-27 07:49:00','지하철',2300,0,0),(170,4,43,'2023-01-27','2023-01-27 08:28:00','SK에너지',12310,0,1),(171,3,44,'2023-01-27','2023-01-27 18:38:00','메가박스',27730,0,1),(172,3,45,'2023-01-28','2023-01-28 21:36:00','인테이크몰',20610,0,1),(173,3,47,'2023-01-29','2023-01-29 09:47:00','SK에너지',33190,0,0),(174,2,48,'2023-01-29','2023-01-29 15:58:00','티켓몬스터',270730,1,1),(175,2,49,'2023-01-30','2023-01-30 06:21:00','커피빈',73660,0,1),(176,1,51,'2023-01-31','2023-01-31 07:02:00','CGV',24620,0,0),(177,2,52,'2023-01-31','2023-01-31 12:05:00','유튜브프리미엄',14900,0,0),(178,1,54,'2023-02-01','2023-02-01 20:38:00','블루보틀',50510,0,0),(179,3,55,'2023-02-03','2023-02-03 03:29:00','배달의 민족',60270,0,0),(180,2,56,'2023-02-04','2023-02-04 03:34:00','티켓몬스터',165650,1,0),(181,1,57,'2023-02-04','2023-02-04 06:50:00','투썸플레이스',7360,0,0),(182,4,58,'2023-02-04','2023-02-04 18:35:00','GS25',6780,0,1),(183,4,59,'2023-02-04','2023-02-04 21:06:00','롯데마트',153130,0,1),(184,2,60,'2023-02-06','2023-02-06 11:13:00','티켓몬스터',81170,0,0),(185,2,61,'2023-02-07','2023-02-07 01:24:00','롯데시네마',14120,0,1),(186,1,63,'2023-02-07','2023-02-07 21:36:00','롯데시네마',18150,0,0),(187,1,64,'2023-02-08','2023-02-08 02:06:00','SKT',68680,0,0),(188,4,65,'2023-02-08','2023-02-08 08:28:00','디즈니플러스',13900,1,1),(189,4,66,'2023-02-09','2023-02-09 04:22:00','위메프',56000,0,0),(190,4,67,'2023-02-09','2023-02-09 23:36:00','올리브영',12140,1,0),(191,2,68,'2023-02-11','2023-02-11 21:36:00','롯데시네마',28820,0,1),(192,2,69,'2023-02-12','2023-02-12 04:23:00','웨이브',16000,0,0),(193,1,70,'2023-02-13','2023-02-13 11:13:00','커피빈',84400,1,1),(194,2,71,'2023-02-13','2023-02-13 16:03:00','이디야커피',66210,1,1),(195,2,72,'2023-02-14','2023-02-14 20:11:00','11번가',209170,1,0),(196,3,73,'2023-02-15','2023-02-15 06:56:00','현대오일뱅크',12310,1,0),(197,2,75,'2023-02-16','2023-02-16 15:48:00','빽다방',19500,0,1),(198,3,76,'2023-02-17','2023-02-17 16:10:00','스타벅스',58090,0,1),(199,2,77,'2023-02-17','2023-02-17 18:20:00','현대오일뱅크',85340,0,1),(200,3,78,'2023-02-19','2023-02-19 07:48:00','왓챠',4900,0,1),(201,2,79,'2023-02-20','2023-02-20 00:58:00','아웃백',82010,0,0),(202,2,80,'2023-02-20','2023-02-20 20:38:00','11번가',11280,0,1),(203,4,81,'2023-02-22','2023-02-22 07:28:00','버스',2330,0,1),(204,2,82,'2023-02-23','2023-02-23 00:49:00','AK몰',187100,1,1),(205,1,83,'2023-02-24','2023-02-24 01:12:00','박승철헤어스튜디오',190070,1,0),(206,3,84,'2023-02-24','2023-02-24 11:11:00','빽다방',2960,1,0),(207,1,85,'2023-02-25','2023-02-25 22:49:00','배달의 민족',104480,1,1),(208,1,86,'2023-02-26','2023-02-26 09:38:00','인테이크몰',169940,0,0),(209,2,88,'2023-02-27','2023-02-27 21:36:00','메가박스',14740,0,0),(210,4,89,'2023-02-28','2023-02-28 20:59:00','애슐리',63620,0,0),(211,1,90,'2023-03-01','2023-03-01 09:57:00','이마트24',17250,0,0),(212,3,91,'2023-03-03','2023-03-03 18:38:00','스타벅스',58160,1,1),(213,1,92,'2023-03-03','2023-03-03 18:43:00','메가박스',14190,0,0),(214,2,93,'2023-03-04','2023-03-04 15:55:00','버스',1990,0,1),(215,1,94,'2023-03-04','2023-03-04 18:43:00','넷플릭스',17000,0,0),(216,3,95,'2023-03-05','2023-03-05 02:54:00','롯데마트',207160,0,0),(217,2,97,'2023-03-08','2023-03-08 19:18:00','배달의 민족',13930,0,0),(218,2,98,'2023-03-09','2023-03-09 06:50:00','메가박스',16630,0,0),(219,2,100,'2023-03-11','2023-03-11 18:29:00','인테이크몰',261120,0,0),(220,2,101,'2023-03-12','2023-03-12 13:25:00','커피빈',59730,0,0),(221,4,102,'2023-03-13','2023-03-13 17:33:00','롯데시네마',27270,1,0),(222,3,103,'2023-03-15','2023-03-15 08:01:00','GS칼텍스',57850,0,0),(223,4,105,'2023-03-17','2023-03-17 15:45:00','옥션',80570,0,1),(224,4,106,'2023-03-17','2023-03-17 20:59:00','AK몰',184760,1,1),(225,3,108,'2023-03-20','2023-03-20 01:09:00','올리브영',16460,1,1),(226,1,109,'2023-03-20','2023-03-20 07:45:00','지하철',3870,0,0),(227,2,110,'2023-03-21','2023-03-21 06:44:00','인테이크몰',25230,1,1),(228,1,111,'2023-03-21','2023-03-21 19:32:00','리안헤어',72430,1,1),(229,2,112,'2023-03-21','2023-03-21 21:30:00','이철헤어커커',93590,0,1),(230,2,113,'2023-03-22','2023-03-22 02:36:00','이마트',159540,0,0),(231,2,115,'2023-03-24','2023-03-24 06:21:00','CGV',26990,0,0),(232,4,116,'2023-03-25','2023-03-25 00:49:00','GS25',16450,0,0),(233,3,117,'2023-03-25','2023-03-25 03:29:00','왓챠',12900,0,0),(234,3,118,'2023-03-25','2023-03-25 07:45:00','S-Oil',13270,1,1),(235,3,119,'2023-03-25','2023-03-25 08:47:00','CGV',22800,0,0),(236,3,121,'2023-03-27','2023-03-27 15:58:00','메가커피',15160,0,1),(237,2,123,'2023-03-28','2023-03-28 18:54:00','이마트',129300,1,1),(238,1,125,'2023-03-31','2023-03-31 11:07:00','스타벅스',9670,1,1),(239,4,128,'2023-04-04','2023-04-04 04:05:00','마켓컬리',116770,0,1),(240,1,129,'2023-04-07','2023-04-07 19:32:00','올리브영',13390,0,1),(241,3,130,'2023-04-08','2023-04-08 15:49:00','이디야커피',78390,0,0),(242,2,133,'2023-04-09','2023-04-09 04:11:00','CU',33950,0,0),(243,1,134,'2023-04-09','2023-04-09 08:47:00','11번가',171090,0,1),(244,4,135,'2023-04-09','2023-04-09 23:44:00','디즈니플러스',9900,0,1),(245,1,136,'2023-04-10','2023-04-10 19:18:00','요기요',40540,1,1),(246,2,137,'2023-04-10','2023-04-10 20:17:00','지하철',2980,0,0),(247,1,138,'2023-04-11','2023-04-11 02:36:00','쿠팡',245650,0,1),(248,2,141,'2023-04-11','2023-04-11 08:50:00','다이소',18190,0,1),(249,1,142,'2023-04-11','2023-04-11 18:02:00','웨이브',13900,0,0),(250,1,147,'2023-04-16','2023-04-16 19:32:00','올리브영',59830,1,1),(251,2,148,'2023-04-17','2023-04-17 01:24:00','빽다방',14010,0,1),(252,1,149,'2023-04-17','2023-04-17 04:11:00','다이소',15210,0,0),(253,4,150,'2023-04-17','2023-04-17 06:21:00','쿠팡',162230,0,1),(254,4,152,'2023-04-18','2023-04-18 16:10:00','왓챠',12900,0,0),(255,4,154,'2023-04-19','2023-04-19 04:53:00','세븐일레븐',11570,0,0),(256,1,157,'2023-04-22','2023-04-22 06:01:00','11번가',223790,0,1),(257,3,158,'2023-04-26','2023-04-26 02:59:00','올리브영',83320,0,0),(258,1,161,'2023-04-30','2023-04-30 04:23:00','CGV',27460,0,0),(259,1,163,'2023-05-02','2023-05-02 16:03:00','SKT',77010,1,0),(260,2,164,'2023-05-04','2023-05-04 22:46:00','홈플러스',244760,1,0),(261,1,165,'2023-05-05','2023-05-05 13:10:00','올리브영',97140,0,1),(262,4,167,'2023-05-11','2023-05-11 14:58:00','배달의 민족',69580,0,0),(263,1,170,'2023-05-13','2023-05-13 02:06:00','박승철헤어스튜디오',22230,0,1),(264,4,171,'2023-05-14','2023-05-14 01:27:00','티빙',9500,0,1),(265,1,172,'2023-05-14','2023-05-14 06:51:00','지하철',2750,0,1),(266,1,173,'2023-05-14','2023-05-14 09:34:00','AK몰',198610,0,0),(267,2,174,'2023-05-17','2023-05-17 17:33:00','GS25',43760,1,1),(268,3,175,'2023-05-18','2023-05-18 03:34:00','AK몰',250890,0,0),(269,2,176,'2023-05-18','2023-05-18 18:37:00','지하철',1840,0,0),(270,4,177,'2023-05-19','2023-05-19 09:47:00','박승철헤어스튜디오',160280,0,0),(271,1,179,'2023-05-24','2023-05-24 21:36:00','커피빈',76280,1,0),(272,2,180,'2023-05-26','2023-05-26 06:56:00','버스',3450,0,0),(273,1,181,'2023-05-26','2023-05-26 07:02:00','이디야커피',16500,0,0),(274,1,182,'2023-05-26','2023-05-26 22:57:00','왓챠',12900,1,1),(275,3,183,'2023-05-28','2023-05-28 11:11:00','GS25',39920,0,1),(276,4,184,'2023-05-28','2023-05-28 20:35:00','GS25',20380,0,0),(277,3,185,'2023-05-29','2023-05-29 02:36:00','박승철헤어스튜디오',165330,0,0),(278,2,186,'2023-05-29','2023-05-29 06:44:00','쿠팡이츠',114860,1,0),(279,2,188,'2023-05-29','2023-05-29 13:10:00','애슐리',34140,1,1),(280,1,189,'2023-05-29','2023-05-29 14:58:00','리안헤어',139060,0,0),(281,4,191,'2023-05-30','2023-05-30 18:47:00','세븐일레븐',7470,0,1),(282,3,192,'2023-06-01','2023-06-01 00:49:00','리안헤어',247390,0,1),(283,1,194,'2023-06-04','2023-06-04 08:28:00','G마켓',298540,0,0),(284,4,195,'2023-06-05','2023-06-05 01:12:00','디즈니플러스',13900,0,0),(285,1,196,'2023-06-05','2023-06-05 02:36:00','티빙',17000,0,1),(286,1,198,'2023-06-05','2023-06-05 09:34:00','애슐리',96710,1,0),(287,3,200,'2023-06-06','2023-06-06 11:05:00','옥션',171340,0,0),(288,1,201,'2023-06-06','2023-06-06 12:56:00','메가박스',17740,0,0),(289,1,202,'2023-06-07','2023-06-07 16:03:00','SKT',79210,0,1),(290,1,205,'2023-06-09','2023-06-09 15:48:00','이디야커피',82010,0,0),(291,4,207,'2023-06-11','2023-06-11 05:55:00','빽다방',8870,1,1),(292,1,208,'2023-06-11','2023-06-11 09:48:00','GS칼텍스',22840,1,0),(293,4,209,'2023-06-12','2023-06-12 07:49:00','이마트24',8700,1,0),(294,1,211,'2023-06-18','2023-06-18 19:30:00','올리브영',55810,1,0),(295,3,212,'2023-06-18','2023-06-18 20:17:00','스타벅스',34870,0,1),(296,4,213,'2023-06-19','2023-06-19 18:38:00','이디야커피',86150,0,1),(297,1,214,'2023-06-20','2023-06-20 03:29:00','쿠팡이츠',85290,0,1),(298,2,215,'2023-06-20','2023-06-20 04:22:00','CU',41950,0,1),(299,3,216,'2023-06-20','2023-06-20 04:53:00','버스',1950,0,1),(300,4,218,'2023-06-20','2023-06-20 08:48:00','넷플릭스',17000,0,1),(301,1,219,'2023-06-22','2023-06-22 02:36:00','메가박스',26220,0,1),(302,1,220,'2023-06-22','2023-06-22 10:37:00','배달의 민족',84270,0,0),(303,3,221,'2023-06-22','2023-06-22 23:51:00','현대오일뱅크',73340,0,0),(304,3,222,'2023-06-23','2023-06-23 15:12:00','이디야커피',33270,0,0),(305,3,224,'2023-06-24','2023-06-24 03:44:00','아웃백',78910,0,1),(306,1,226,'2023-06-26','2023-06-26 11:07:00','박승철헤어스튜디오',129400,0,0),(307,4,229,'2023-06-28','2023-06-28 10:52:00','투썸플레이스',57640,1,1),(308,1,230,'2023-06-29','2023-06-29 02:30:00','커피빈',50190,0,0),(309,1,231,'2023-06-29','2023-06-29 09:35:00','AK몰',272320,0,1),(310,3,232,'2023-07-01','2023-07-01 15:55:00','CU',52890,0,1),(311,1,235,'2023-07-03','2023-07-03 13:01:00','커피빈',63900,0,1),(312,1,237,'2023-07-04','2023-07-04 20:11:00','메가박스',26370,0,1),(313,4,239,'2023-07-05','2023-07-05 03:31:00','GS25',27020,1,0),(314,3,240,'2023-07-06','2023-07-06 18:35:00','요기요',72280,1,1),(315,1,241,'2023-07-07','2023-07-07 02:30:00','홈플러스',231290,1,0),(316,4,242,'2023-07-07','2023-07-07 04:21:00','버스',1900,0,1),(317,1,245,'2023-07-11','2023-07-11 22:27:00','버스',4010,0,1),(318,3,247,'2023-07-13','2023-07-13 11:13:00','아웃백',63350,0,0),(319,3,248,'2023-07-14','2023-07-14 02:48:00','투썸플레이스',14690,0,1),(320,4,253,'2023-07-17','2023-07-17 19:29:00','위메프',57420,0,1),(321,2,255,'2023-07-18','2023-07-18 06:01:00','CU',11870,1,0),(322,2,256,'2023-07-18','2023-07-18 19:32:00','버스',3830,0,1),(323,1,257,'2023-07-18','2023-07-18 21:28:00','티빙',17000,0,1),(324,4,258,'2023-07-19','2023-07-19 02:36:00','세븐일레븐',35480,0,0),(325,4,259,'2023-07-19','2023-07-19 09:48:00','투썸플레이스',46680,0,0),(326,4,260,'2023-07-20','2023-07-20 18:43:00','디즈니플러스',9900,0,0),(327,3,261,'2023-07-20','2023-07-20 23:44:00','유튜브프리미엄',14900,0,0),(328,4,262,'2023-07-21','2023-07-21 02:06:00','롯데시네마',22250,0,1),(329,3,263,'2023-07-21','2023-07-21 02:54:00','인테이크몰',94530,0,0),(330,4,264,'2023-07-21','2023-07-21 19:32:00','애슐리',35410,0,1),(331,2,265,'2023-07-21','2023-07-21 20:17:00','쿠팡',167010,1,0),(332,3,266,'2023-07-25','2023-07-25 04:22:00','왓챠',12900,0,0),(333,1,267,'2023-07-26','2023-07-26 02:54:00','CGV',18940,1,0),(334,4,268,'2023-07-26','2023-07-26 11:07:00','11번가',270840,0,1),(335,3,269,'2023-07-26','2023-07-26 12:50:00','메가박스',19700,1,0),(336,1,272,'2023-07-31','2023-07-31 04:31:00','지하철',3460,0,1),(337,2,275,'2023-08-01','2023-08-01 19:30:00','디즈니플러스',9900,0,1),(338,3,276,'2023-08-01','2023-08-01 22:57:00','웨이브',16000,0,0),(339,1,277,'2023-08-03','2023-08-03 09:38:00','커피빈',79750,0,1),(340,2,279,'2023-08-05','2023-08-05 10:52:00','유튜브프리미엄',14900,0,1),(341,4,281,'2023-08-05','2023-08-05 23:36:00','요기요',16940,1,1),(342,4,283,'2023-08-06','2023-08-06 14:48:00','GS25',25950,1,1),(343,4,287,'2023-08-08','2023-08-08 06:21:00','CGV',21490,0,1),(344,4,288,'2023-08-08','2023-08-08 16:34:00','AK몰',95730,0,0),(345,4,289,'2023-08-10','2023-08-10 03:31:00','넷플릭스',13500,0,1),(346,3,290,'2023-08-11','2023-08-11 13:25:00','CU',50250,1,1),(347,3,293,'2023-08-12','2023-08-12 21:36:00','롯데마트',78590,0,0),(348,1,294,'2023-08-13','2023-08-13 15:12:00','투썸플레이스',96780,1,1),(349,3,295,'2023-08-14','2023-08-14 01:58:00','SK에너지',50400,0,0),(350,1,297,'2023-08-16','2023-08-16 01:12:00','택시',45170,0,1),(351,1,301,'2023-08-19','2023-08-19 01:09:00','GS25',42590,1,0),(352,4,303,'2023-08-21','2023-08-21 19:30:00','쿠팡',13490,1,0),(353,3,305,'2023-08-23','2023-08-23 04:11:00','올리브영',14040,1,0),(354,4,306,'2023-08-24','2023-08-24 20:17:00','롯데시네마',28600,0,1),(355,3,307,'2023-08-25','2023-08-25 04:29:00','다이소',32530,1,0),(356,1,308,'2023-08-30','2023-08-30 21:36:00','요기요',20630,0,1),(357,4,309,'2023-08-31','2023-08-31 19:29:00','박승철헤어스튜디오',138590,0,0),(358,1,311,'2023-09-03','2023-09-03 06:50:00','홈플러스',81880,0,1),(359,2,312,'2023-09-04','2023-09-04 21:36:00','위메프',247220,0,1),(360,1,313,'2023-09-06','2023-09-06 03:34:00','왓챠',12900,0,0),(361,1,314,'2023-09-07','2023-09-07 08:50:00','투썸플레이스',66890,0,1),(362,2,317,'2023-09-09','2023-09-09 15:07:00','블루보틀',95170,0,0),(363,1,319,'2023-09-11','2023-09-11 08:48:00','현대오일뱅크',69850,0,0),(364,2,320,'2023-09-12','2023-09-12 10:37:00','웨이브',13900,0,0),(365,3,321,'2023-09-15','2023-09-15 06:51:00','유튜브프리미엄',14900,1,0),(366,2,322,'2023-09-16','2023-09-16 12:20:00','다이소',19990,0,0),(367,1,323,'2023-09-16','2023-09-16 17:57:00','티켓몬스터',48340,0,0),(368,1,326,'2023-09-18','2023-09-18 09:48:00','S-Oil',79510,0,0),(369,3,327,'2023-09-18','2023-09-18 20:11:00','티빙',9500,0,1),(370,2,329,'2023-09-19','2023-09-19 11:11:00','메가박스',14630,0,1),(371,3,330,'2023-09-20','2023-09-20 09:47:00','SK에너지',79370,0,0),(372,3,331,'2023-09-23','2023-09-23 01:24:00','이철헤어커커',216440,1,0),(373,4,334,'2023-09-26','2023-09-26 04:22:00','스타벅스',69770,0,1),(374,1,336,'2023-09-27','2023-09-27 09:47:00','아웃백',53190,0,1),(375,1,338,'2023-09-27','2023-09-27 22:46:00','쿠팡',14540,1,0),(376,2,339,'2023-09-28','2023-09-28 04:23:00','S-Oil',88820,0,1),(377,4,340,'2023-09-28','2023-09-28 21:30:00','올리브영',78510,0,1),(378,3,341,'2023-09-30','2023-09-30 15:07:00','CU',56500,0,1),(379,1,343,'2023-10-01','2023-10-01 22:27:00','GS칼텍스',94220,0,0),(380,4,344,'2023-10-03','2023-10-03 03:31:00','11번가',109910,0,1),(381,4,345,'2023-10-03','2023-10-03 09:48:00','롯데시네마',27750,0,1),(382,4,351,'2023-10-08','2023-10-08 23:44:00','티빙',13500,1,1),(383,4,353,'2023-10-11','2023-10-11 04:32:00','쿠팡',59510,0,0),(384,4,354,'2023-10-11','2023-10-11 19:38:00','올리브영',59330,0,1),(385,3,355,'2023-10-12','2023-10-12 18:43:00','버스',1990,0,0),(386,1,356,'2023-10-13','2023-10-13 18:47:00','위메프',297040,0,1),(387,3,357,'2023-10-14','2023-10-14 18:54:00','스타벅스',17180,0,0),(388,3,358,'2023-10-16','2023-10-16 03:31:00','올리브영',95740,0,1),(389,1,360,'2023-10-18','2023-10-18 21:36:00','디즈니플러스',13900,0,0),(390,4,361,'2023-10-19','2023-10-19 18:19:00','옥션',283630,0,0),(391,2,364,'2023-10-24','2023-10-24 01:12:00','이디야커피',26510,0,0),(392,3,365,'2023-10-24','2023-10-24 03:44:00','메가커피',7450,0,1),(393,1,366,'2023-10-24','2023-10-24 15:49:00','이마트24',49750,1,0),(394,3,367,'2023-10-25','2023-10-25 09:57:00','11번가',254690,0,0),(395,3,368,'2023-10-25','2023-10-25 11:05:00','애슐리',97620,0,1),(396,3,369,'2023-10-26','2023-10-26 01:02:00','지하철',3680,0,0),(397,1,370,'2023-10-26','2023-10-26 22:55:00','블루보틀',41570,1,1),(398,4,371,'2023-10-27','2023-10-27 16:03:00','현대오일뱅크',76980,0,0),(399,3,377,'2023-11-03','2023-11-03 08:47:00','투썸플레이스',11020,0,1),(400,3,378,'2023-11-03','2023-11-03 11:05:00','G마켓',149510,0,0),(401,4,379,'2023-11-03','2023-11-03 13:25:00','마켓컬리',59750,0,0),(402,2,380,'2023-11-04','2023-11-04 06:21:00','이철헤어커커',179310,1,0),(403,2,381,'2023-11-05','2023-11-05 18:20:00','SKT',35500,0,1),(404,1,382,'2023-11-06','2023-11-06 07:49:00','롯데시네마',29090,0,1),(405,2,384,'2023-11-08','2023-11-08 09:38:00','웨이브',13900,1,0),(406,1,386,'2023-11-09','2023-11-09 22:57:00','블루보틀',5980,0,0),(407,2,387,'2023-11-10','2023-11-10 06:01:00','티켓몬스터',181090,0,1),(408,3,389,'2023-11-12','2023-11-12 08:48:00','티켓몬스터',93050,0,0),(409,1,390,'2023-11-12','2023-11-12 21:36:00','올리브영',54090,0,1),(410,4,391,'2023-11-13','2023-11-13 15:38:00','리안헤어',133570,0,0),(411,4,392,'2023-11-14','2023-11-14 03:44:00','쿠팡',143220,0,1),(412,3,393,'2023-11-14','2023-11-14 16:47:00','쿠팡',162200,1,0),(413,1,394,'2023-11-15','2023-11-15 00:58:00','롯데마트',152540,0,0),(414,3,395,'2023-11-15','2023-11-15 07:48:00','CU',25590,0,1),(415,2,398,'2023-11-16','2023-11-16 18:39:00','롯데마트',265000,0,0),(416,1,399,'2023-11-17','2023-11-17 18:54:00','홈플러스',99510,1,1),(417,1,400,'2023-11-18','2023-11-18 09:34:00','GS25',17950,1,1),(418,4,402,'2023-11-21','2023-11-21 02:59:00','쿠팡',280890,0,0),(419,2,403,'2023-11-21','2023-11-21 22:55:00','메가커피',17410,0,0),(420,1,404,'2023-11-27','2023-11-27 07:05:00','11번가',184640,0,1),(421,4,405,'2023-11-28','2023-11-28 07:48:00','티빙',17000,0,1),(422,2,407,'2023-11-29','2023-11-29 18:37:00','지하철',1700,1,0),(423,2,408,'2023-11-29','2023-11-29 18:47:00','이마트',116340,0,1),(424,1,411,'2023-11-30','2023-11-30 19:29:00','유튜브프리미엄',14900,1,0),(425,3,412,'2023-12-03','2023-12-03 01:09:00','메가박스',16550,0,0),(426,2,413,'2023-12-03','2023-12-03 09:51:00','리안헤어',215950,1,1),(427,4,414,'2023-12-03','2023-12-03 20:17:00','G마켓',176560,0,0),(428,3,415,'2023-12-04','2023-12-04 03:44:00','왓챠',4900,0,0),(429,1,416,'2023-12-05','2023-12-05 21:30:00','CGV',27120,0,1),(430,1,417,'2023-12-06','2023-12-06 06:51:00','요기요',100200,0,0),(431,2,418,'2023-12-08','2023-12-08 00:19:00','메가박스',17270,0,1),(432,1,420,'2023-12-09','2023-12-09 18:29:00','올리브영',30140,0,0),(433,1,421,'2023-12-11','2023-12-11 07:45:00','SK에너지',95900,1,0),(434,2,423,'2023-12-12','2023-12-12 07:28:00','다이소',6150,0,1),(435,1,424,'2023-12-12','2023-12-12 18:47:00','유튜브프리미엄',14900,0,0),(436,4,425,'2023-12-13','2023-12-13 22:55:00','마켓컬리',25010,0,1),(437,4,426,'2023-12-14','2023-12-14 04:23:00','아웃백',38370,0,1),(438,2,428,'2023-12-16','2023-12-16 00:47:00','빽다방',19780,0,0),(439,3,430,'2023-12-16','2023-12-16 20:11:00','블루보틀',98510,0,1),(440,4,431,'2023-12-17','2023-12-17 16:10:00','11번가',113250,0,1),(441,4,432,'2023-12-18','2023-12-18 14:48:00','올리브영',19680,0,0),(442,3,434,'2023-12-19','2023-12-19 07:05:00','롯데시네마',21040,1,1),(443,3,436,'2023-12-21','2023-12-21 21:06:00','이디야커피',63880,1,0),(444,4,439,'2023-12-22','2023-12-22 19:30:00','메가커피',13080,1,0),(445,3,440,'2023-12-23','2023-12-23 06:01:00','SKT',33150,1,0),(446,4,446,'2023-12-27','2023-12-27 18:38:00','홈플러스',199720,0,1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-14 10:22:10
