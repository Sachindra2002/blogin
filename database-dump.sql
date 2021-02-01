CREATE DATABASE  IF NOT EXISTS `blogger` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blogger`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: blogger
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
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogs` (
  `blogId` int NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `imageUrl` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `body` varchar(10000) NOT NULL,
  `date` varchar(50) NOT NULL,
  `status` varchar(255) NOT NULL,
  `likeCount` int DEFAULT NULL,
  `commentCount` int DEFAULT NULL,
  PRIMARY KEY (`blogId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` VALUES (1,'How to achieve work life balance','BlogImages\\K93Y3Z7SB.jpg','cb008264','Lifestyle','<p>Maintaining a work/life balance is easy when you&rsquo;re a sole trader, right? You typically work from home and you have no one else to answer to, so it should be easy to switch off. Unfortunately, that&rsquo;s not always the case. In fact, many home-based sole traders struggle to strike a healthy work/life balance because the lines are more blurred. Ella Legg, founder of copywriting consultancy Ella Smith Communications, knows how difficult it can be to strike that balance, having experienced it firsthand. Here are her top 20 tips for achieving and maintaining a healthy work/life balance.</p>','2021-01-22','Accepted',5,5),(3,'My first adventure','BlogImages\\3HMOMW.jpg','cb008264','Travel','<p style=\"text-align: center;\">The drive was short, less than an hour and a half from downtown Nashville. Our vehicle crept through the park\'s entrance slowly. I didn\'t know what to expect. My shy feet crushed against the cold pavement, as we walked towards the trailhead. A sign read Burgess Falls State Natural Area and warned that the hike to the falls would be moderately strenuous. I could feel my stomach drop at the thought of what would lie ahead, but I pushed on.I made my way slowly up the trail, mindful of every pebble in my path as I trailed behind my companions. The sound of the wind in the trees gave way to the roaring of the first waterfall. The air seemed to hum with energy, causing my breath to catch in my throat. The powerful sound of the waterfall was frightening, but it also intrigued me. As the noise grew louder, we approached the first overlook. To my dismay, I saw that it was blocked off with fencing. A sign explained the park was forced to close it due to flood damage. I peaked through the trees, trying to get a good look at the first waterfall I had ever seen. My companions told me that another waterfall and overlook waited just up the trail, so I led the way, more sure of each footstep.</p>','2021-01-22','Accepted',50,50),(4,'How to stay healthy','BlogImages\\9J7T5CH.jpg','cb008264','Food','<p style=\"text-align: left;\"><em>A healthy lifestyle can help you thrive throughout your life. Making healthy choices isn\'t always easy, however. It can be hard to find the time and energy to exercise regularly or prepare healthy meals. However, your efforts will pay off in many ways, and for the rest of your life.</em><em>Good ways to deal with stress include regular exercise, healthy eating habits and relaxation exercises, such as deep breathing or meditation. Talking to trusted family members and friends can help a lot. Some women find that interacting with their faith community is helpful in times of stress.</em></p>','2021-01-22','Accepted',5,5),(5,'My musical journey','BlogImages\\4872XI.jpg','cb008264','Music','<p><em>At that moment he had a thought that he\'d never imagine he\'d consider. \"I could just cheat,\" he thought, \"and that would solve the problem.\" He tried to move on from the thought but it was persistent. It didn\'t want to go away and, if he was honest with himself, he didn\'t want it to. I recently discovered I could make fudge with just chocolate chips, sweetened condensed milk, vanilla extract, and a thick pot on slow heat. I tried it with dark chocolate chunks and I tried it with semi-sweet chocolate chips. It\'s better with both kinds. It comes out pretty bad with just the dark chocolate. The best add-ins are crushed almonds and marshmallows -- what you get from that is Rocky Road. It takes about twenty minutes from start to fridge, and then it takes about six months to work off the twenty pounds you gain from eating it. All things in moderation, friends. All things in moderation.</em></p>','2021-01-22','Accepted',2,85),(6,'Why pancakes are the best','BlogImages\\214X2QT.jpg','cb007892','Food','<p><em>Josh had spent year and year accumulating the information. He knew it inside out and if there was ever anyone looking for an expert in the field, Josh would be the one to call. The problem was that there was nobody interested in the information besides him and he knew it. Years of information painstakingly memorized and sorted with not a sole giving even an ounce of interest in the topic. I\'m meant to be writing at this moment. What I mean is, I\'m meant to be writing something else at this moment. The document I\'m meant to be writing is, of course, open in another program on my computer and is patiently awaiting my attention. Yet here I am plonking down senseless sentiments in this paragraph because it\'s easier to do than to work on anything particularly meaningful. I am grateful for the distraction.</em></p>','2021-01-22','Accepted',78,78),(7,'Helpful tools when travelling','BlogImages\\L0K1FW8L.jpg','cb007892','Travel','<p><em>The rain and wind abruptly stopped, but the sky still had the gray swirls of storms in the distance. Dave knew this feeling all too well. The calm before the storm. He only had a limited amount of time before all Hell broke loose, but he stopped to admire the calmness. Maybe it would be different this time, he thought, with the knowledge deep within that it wouldn\'t. He was aware there were numerous wonders of this world including the unexplained creations of humankind that showed the wonder of our ingenuity. There are huge heads on Easter Island. There are the Egyptian pyramids. There&rsquo;s Stonehenge. But he now stood in front of a newly discovered monument that simply didn\'t make any sense and he wondered how he was ever going to be able to explain it.</em></p>','2021-01-22','Accepted',80,80),(8,'Best workout routine','BlogImages\\AYMX01A.jpg','cb007892','Fitness','<p><em>recently discovered I could make fudge with just chocolate chips, sweetened condensed milk, vanilla extract, and a thick pot on slow heat. I tried it with dark chocolate chunks and I tried it with semi-sweet chocolate chips. It\'s better with both kinds. It comes out pretty bad with just the dark chocolate. The best add-ins are crushed almonds and marshmallows -- what you get from that is Rocky Road. It takes about twenty minutes from start to fridge, and then it takes about six months to work off the twenty pounds you gain from eating it. All things in moderation, friends. All things in moderation. The chair sat in the corner where it had been for over 25 years. The only difference was there was someone actually sitting in it. How long had it been since someone had done that? Ten years or more he imagined. Yet there was no denying the presence in the chair now.</em></p>','2021-01-22','Accepted',80,80);
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `commentId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `blogId` int NOT NULL,
  `comment` varchar(1000) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'cb007892',7,'Thank you for the info','2021-01-22');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `followers`
--

DROP TABLE IF EXISTS `followers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `followers` (
  `username` varchar(20) DEFAULT NULL,
  `followers` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followers`
--

LOCK TABLES `followers` WRITE;
/*!40000 ALTER TABLE `followers` DISABLE KEYS */;
INSERT INTO `followers` VALUES ('cb007892','cb008211','following'),('cb004321','cb008142','following');
/*!40000 ALTER TABLE `followers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquiry`
--

DROP TABLE IF EXISTS `inquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquiry` (
  `inquiryId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNo` int NOT NULL,
  `message` varchar(255) NOT NULL,
  `submittedDate` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`inquiryId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquiry`
--

LOCK TABLES `inquiry` WRITE;
/*!40000 ALTER TABLE `inquiry` DISABLE KEYS */;
INSERT INTO `inquiry` VALUES (12,'CB008211','cb008211@students.apiit.lk',773249532,'login issue','2020-11-18','Replied'),(13,'CB008264','cb008264@students.apiit.lk',762343243,'can not comment on blogs','2020-11-18','Replied'),(14,'CB007892','cb007892@students.apiit.lk',772352355,'can not post blogs','2020-11-18','pending'),(22,'CB008211','cb008211@students.apiit.lk',112323232,'dsfs df d fsd  d ','2020-12-09','pending'),(23,'CB008211','cb008211@students.apiit.lk',112323232,'wdwa ','2020-12-09','pending'),(24,'CB007893','raaidrizvi123@gmail.com',1232323,'asdadsadasasdsds','2021-01-15','pending'),(25,'CB007892','raaidrizvi123@gmail.com',1232323,'asdsadasdd','2021-01-15','pending'),(26,'CB007892','raaidrizvi123@gmail.com',1232323,'asdsadasdd','2021-01-15','pending');
/*!40000 ALTER TABLE `inquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `lid` int NOT NULL AUTO_INCREMENT,
  `blogId` int NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (3,1,'CB008264'),(4,7,'cb007892');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `notificationId` int NOT NULL AUTO_INCREMENT,
  `senderName` varchar(255) NOT NULL,
  `receiverName` varchar(255) NOT NULL,
  `notiType` varchar(255) NOT NULL,
  `photoUrl` varchar(255) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'cb007892','cb007892','commented','BlogImages\\L0K1FW8L.jpg','2021-01-22');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `photoUrl` varchar(255) DEFAULT NULL,
  `roles` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('cb001234','Lahiru','De Silva','2021-01-20','cb001234@students.apiit.lk','12345','ProfileImages\\cb001234.png','moderator'),('cb004321','John','Taitor','2021-01-05','cb004321@students.apiit.lk','12345','ProfileImages\\cb004321.jpg','member'),('cb007892','Sachindra','Rodrigo','2002-11-06','cb007892@students.apiit.lk','12345','ProfileImages\\cb007892.jpg','blogger'),('cb008142','Kanchana','Walagambahu','2021-01-22','cb008142@students.apiit.lk','12345','ProfileImages\\cb008142.jpg','blogger'),('cb008211','Lahiru',' De Silva','2021-01-06','cb008211@students.apiit.lk','12345','ProfileImages\\cb008211.jpg','blogger'),('cb008264','Raaid','Rizvi','2001-04-02','cb008264@students.apiit.lk','12345','ProfileImages\\cb008264.jpg','blogger');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-22 11:53:16
