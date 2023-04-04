/*
SQLyog - Free MySQL GUI v5.02
Host - 5.5.27 : Database - insurance_management_system
*********************************************************************
Server version : 5.5.27
*/


create database if not exists `insurance_management_system`;

USE `insurance_management_system`;

SET FOREIGN_KEY_CHECKS=0;

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT 'null',
  `dob` date DEFAULT NULL,
  `address` varchar(1000) DEFAULT 'null',
  `contact` bigint(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert into `client` values (1,'Giri Roy','2001-11-29','168, Main Road, Razole,India', 0000000000);
insert into `client` values (2,'Hassain Skaik','2002-12-15','124, Temple side,Nuzvid,India', 111111111);
insert into `client` values (3,'Bhanu Dos','1988-08-21','79-c Madhapur, Hydrabad, India', 2222222222);
insert into `client` values (4,'Hell Boy','1999-03-14','32-b main road Hydrabad,India', 333333333);
insert into `client` values (5,'Naveen zoy','2000-11-31','1-168 main road, amalapuram.India', 444444444);

/*Table structure for table `policy` */

DROP TABLE IF EXISTS `policy`;

CREATE TABLE `policy` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `policy_number` varchar(120) DEFAULT 'null',
  `type` varchar(288) DEFAULT 'null',
  `coverage_amount` double(9,2) DEFAULT '0.00',
  `premium` double(9,2) DEFAULT '0.00',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `client_id` int(100) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_INSTRUCTOR_idx` (`client_id`),
  CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `policy` */

insert into `policy` values (1,'POL1','Life Insurance',1000000.55,2500.00,'2023-03-30','2024-01-01',1);
insert into `policy` values (2,'POL2','Home Insurance',50000.56,2000.00,'2023-03-31','2025-05-05',2);
insert into `policy` values (3,'POL3','Vehicle Insurance',30000.34,1200.00,'2023-04-01','2028-03-01',3);
insert into `policy` values (4,'POL4','Mobile Insurance',12000.05,500.00,'2023-04-02','2030-03-19',4);
insert into `policy` values (5,'POL5','Fire Insurance',1200,200.00,'2023-04-02','2029-11-23',5);

SET FOREIGN_KEY_CHECKS=1;

/*Table structure for table `claim` */

DROP TABLE IF EXISTS `claim`;

CREATE TABLE `claim` (
  `id` int(110) NOT NULL AUTO_INCREMENT,
  `claim_number` varchar(250) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `claim_date` date DEFAULT NULL,
  `claim_status` varchar(225) DEFAULT NULL,
  `policy_id` int(110) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`policy_id`),
  CONSTRAINT `FK_COURSE` FOREIGN KEY (`policy_id`) REFERENCES `policy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `claim` */

insert into `claim` values (1,'CLM1','Vehicle Missing','2023-03-31','Approved',1);
insert into `claim` values (2,'CLM2','Fire due to loss of property','2023-03-31','Approved',2);
insert into `claim` values (3,'CLM3','Mobile Missing','2023-03-10','Denied',3);
insert into `claim` values (4,'CLM4','Water damage and Freezing','2023-04-03','Pending',4);
insert into `claim` values (5,'CLM5','Heart Attack','2023-02-24','Approved',5);


