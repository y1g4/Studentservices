-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 18, 2026 at 06:01 PM
-- Server version: 10.11.19-MariaDB-ubu2204
-- PHP Version: 8.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentservicesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Campuses`
--

CREATE TABLE `Campuses` (
  `Campus_id` int(11) NOT NULL,
  `Campus_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Campuses`
--

INSERT INTO `Campuses` (`Campus_id`, `Campus_name`) VALUES
(2, 'Kihumuro'),
(3, 'Mbarara'),
(4, 'Mulago');

-- --------------------------------------------------------

--
-- Table structure for table `Course_units`
--

CREATE TABLE `Course_units` (
  `Course_unit_id` int(11) NOT NULL,
  `Course_unit_name` varchar(45) DEFAULT NULL,
  `Programmes_Programme_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Departments`
--

CREATE TABLE `Departments` (
  `Department_id` int(11) NOT NULL,
  `Department_name` varchar(45) DEFAULT NULL,
  `Faculties_Faculty_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Districts`
--

CREATE TABLE `Districts` (
  `District_id` int(11) NOT NULL,
  `District_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Faculties`
--

CREATE TABLE `Faculties` (
  `Faculty_id` int(11) NOT NULL,
  `Faculty_name` varchar(45) DEFAULT NULL,
  `Universities_University_id` int(11) NOT NULL,
  `Campuses_Campus_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Faculties`
--

INSERT INTO `Faculties` (`Faculty_id`, `Faculty_name`, `Universities_University_id`, `Campuses_Campus_id`) VALUES
(11, 'Faculty of Medicine', 9, 3),
(12, 'Faculty of Science', 9, 3),
(13, 'Faculty of Interdisciplinary Studies', 9, 3),
(14, 'Faculty of Business and Management Sciences', 9, 3),
(15, 'Faculty of Computing and Informatics', 9, 2),
(16, 'Faculty of Applied Sciences and Technology', 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE `Login` (
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Login`
--

INSERT INTO `Login` (`Username`, `Password`) VALUES
('Frank', 'Frank@123');

-- --------------------------------------------------------

--
-- Table structure for table `Programmes`
--

CREATE TABLE `Programmes` (
  `Programme_id` int(11) NOT NULL,
  `Programme_name` varchar(45) DEFAULT NULL,
  `Programme_duration` varchar(45) DEFAULT NULL,
  `Programme_level_Programme_level_id` int(11) NOT NULL,
  `Study_time_Study_time_id` int(11) NOT NULL,
  `Departments_Department_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Programme_level`
--

CREATE TABLE `Programme_level` (
  `Programme_level_id` int(11) NOT NULL,
  `Programme_level_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Students`
--

CREATE TABLE `Students` (
  `Student_id` int(11) NOT NULL,
  `Student_name` varchar(45) DEFAULT NULL,
  `Student_sex` varchar(45) DEFAULT NULL,
  `Student_age` varchar(45) DEFAULT NULL,
  `Districts_District_id` int(11) NOT NULL,
  `Programmes_Programme_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Study_time`
--

CREATE TABLE `Study_time` (
  `Study_time_id` int(11) NOT NULL,
  `Study_time_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Universities`
--

CREATE TABLE `Universities` (
  `University_id` int(11) NOT NULL,
  `University_name` varchar(145) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Universities`
--

INSERT INTO `Universities` (`University_id`, `University_name`) VALUES
(3, 'NDEJJE'),
(6, 'KAB'),
(8, 'KYU'),
(9, 'MUST');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Campuses`
--
ALTER TABLE `Campuses`
  ADD PRIMARY KEY (`Campus_id`);

--
-- Indexes for table `Course_units`
--
ALTER TABLE `Course_units`
  ADD PRIMARY KEY (`Course_unit_id`),
  ADD KEY `fk_Course_units_Programmes1_idx` (`Programmes_Programme_id`);

--
-- Indexes for table `Departments`
--
ALTER TABLE `Departments`
  ADD PRIMARY KEY (`Department_id`),
  ADD KEY `fk_Departments_Faculties1_idx` (`Faculties_Faculty_id`);

--
-- Indexes for table `Districts`
--
ALTER TABLE `Districts`
  ADD PRIMARY KEY (`District_id`);

--
-- Indexes for table `Faculties`
--
ALTER TABLE `Faculties`
  ADD PRIMARY KEY (`Faculty_id`),
  ADD KEY `fk_Faculties_Universities1_idx` (`Universities_University_id`),
  ADD KEY `fk_Faculties_Campuses1_idx` (`Campuses_Campus_id`);

--
-- Indexes for table `Programmes`
--
ALTER TABLE `Programmes`
  ADD PRIMARY KEY (`Programme_id`),
  ADD KEY `fk_Programmes_Programme_level1_idx` (`Programme_level_Programme_level_id`),
  ADD KEY `fk_Programmes_Study_time1_idx` (`Study_time_Study_time_id`),
  ADD KEY `fk_Programmes_Departments1_idx` (`Departments_Department_id`);

--
-- Indexes for table `Programme_level`
--
ALTER TABLE `Programme_level`
  ADD PRIMARY KEY (`Programme_level_id`);

--
-- Indexes for table `Students`
--
ALTER TABLE `Students`
  ADD PRIMARY KEY (`Student_id`,`Programmes_Programme_id`),
  ADD KEY `fk_Students_Districts1_idx` (`Districts_District_id`),
  ADD KEY `fk_Students_Programmes1_idx` (`Programmes_Programme_id`);

--
-- Indexes for table `Study_time`
--
ALTER TABLE `Study_time`
  ADD PRIMARY KEY (`Study_time_id`);

--
-- Indexes for table `Universities`
--
ALTER TABLE `Universities`
  ADD PRIMARY KEY (`University_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Course_units`
--
ALTER TABLE `Course_units`
  ADD CONSTRAINT `fk_Course_units_Programmes1` FOREIGN KEY (`Programmes_Programme_id`) REFERENCES `Programmes` (`Programme_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Departments`
--
ALTER TABLE `Departments`
  ADD CONSTRAINT `fk_Departments_Faculties1` FOREIGN KEY (`Faculties_Faculty_id`) REFERENCES `Faculties` (`Faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Faculties`
--
ALTER TABLE `Faculties`
  ADD CONSTRAINT `fk_Faculties_Campuses1` FOREIGN KEY (`Campuses_Campus_id`) REFERENCES `Campuses` (`Campus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Faculties_Universities1` FOREIGN KEY (`Universities_University_id`) REFERENCES `Universities` (`University_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Programmes`
--
ALTER TABLE `Programmes`
  ADD CONSTRAINT `fk_Programmes_Departments1` FOREIGN KEY (`Departments_Department_id`) REFERENCES `Departments` (`Department_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Programmes_Programme_level1` FOREIGN KEY (`Programme_level_Programme_level_id`) REFERENCES `Programme_level` (`Programme_level_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Programmes_Study_time1` FOREIGN KEY (`Study_time_Study_time_id`) REFERENCES `Study_time` (`Study_time_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Students`
--
ALTER TABLE `Students`
  ADD CONSTRAINT `fk_Students_Districts1` FOREIGN KEY (`Districts_District_id`) REFERENCES `Districts` (`District_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Students_Programmes1` FOREIGN KEY (`Programmes_Programme_id`) REFERENCES `Programmes` (`Programme_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
