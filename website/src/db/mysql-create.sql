/*
SQLyog Community v11.12 Beta1 (64 bit)
MySQL - 5.0.41-community-nt : Database - quebecwhisky
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quebecwhisky` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quebecwhisky`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL auto_increment,
  `category` varchar(255) default NULL,
  `date` datetime default NULL,
  `description` varchar(255) default NULL,
  `registrationUrl` varchar(255) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bottle` */

DROP TABLE IF EXISTS `bottle`;

CREATE TABLE `bottle` (
  `id` bigint(20) NOT NULL auto_increment,
  `abv` smallint(6) default NULL,
  `age` smallint(6) default NULL,
  `bottler` varchar(255) default NULL,
  `finish` varchar(255) default NULL,
  `history` varchar(255) default NULL,
  `logo` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `priceStore` double default NULL,
  `subtype` varchar(255) default NULL,
  `BOTTLE_TYPE` varchar(255) default NULL,
  `distillery_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK76F285E6AFAFDC32` (`distillery_id`),
  CONSTRAINT `FK76F285E6AFAFDC32` FOREIGN KEY (`distillery_id`) REFERENCES `distillery` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `distillery` */

DROP TABLE IF EXISTS `distillery`;

CREATE TABLE `distillery` (
  `id` bigint(20) NOT NULL auto_increment,
  `country` varchar(255) default NULL,
  `history` varchar(255) default NULL,
  `hyperlink` varchar(255) default NULL,
  `logo` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `region` varchar(255) default NULL,
  `established` smallint(6) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` bigint(20) NOT NULL auto_increment,
  `author` varchar(255) default NULL,
  `created` datetime default NULL,
  `description` varchar(255) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL auto_increment,
  `author` varchar(255) default NULL,
  `created` datetime default NULL,
  `notes` varchar(255) default NULL,
  `rating` double default NULL,
  `bottle_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK91B3E3786F7C1B12` (`bottle_id`),
  CONSTRAINT `FK91B3E3786F7C1B12` FOREIGN KEY (`bottle_id`) REFERENCES `bottle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
