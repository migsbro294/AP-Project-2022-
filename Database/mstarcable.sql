-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2022 at 04:05 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mstarcable`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Account_num` int(11) NOT NULL,
  `Customer_id` varchar(8) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `Payment_date` date NOT NULL,
  `Balance` double NOT NULL,
  `Amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `Complaint_id` varchar(8) NOT NULL,
  `Customer_id` varchar(8) NOT NULL,
  `Catergory` varchar(25) NOT NULL,
  `Details` varchar(50) NOT NULL,
  `Employee_id` varchar(8) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `Date` date NOT NULL,
  `Instructions` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_Id` varchar(8) NOT NULL,
  `Lastname` varchar(25) NOT NULL,
  `Firstname` varchar(25) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Contact_num` int(11) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer_password`
--

CREATE TABLE `customer_password` (
  `Customer_Id` varchar(8) NOT NULL,
  `Salt` varchar(75) NOT NULL,
  `Hash` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_id` varchar(8) NOT NULL,
  `Firstname` varchar(25) NOT NULL,
  `Lastname` varchar(25) NOT NULL,
  `Contact_num` int(11) NOT NULL,
  `Role` varchar(25) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee_password`
--

CREATE TABLE `employee_password` (
  `Employee_id` varchar(8) NOT NULL,
  `Salt` varchar(75) NOT NULL,
  `Hash` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Account_num`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`Complaint_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_Id`);

--
-- Indexes for table `customer_password`
--
ALTER TABLE `customer_password`
  ADD PRIMARY KEY (`Customer_Id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_id`);

--
-- Indexes for table `employee_password`
--
ALTER TABLE `employee_password`
  ADD PRIMARY KEY (`Employee_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_Id`) ON UPDATE CASCADE;

--
-- Constraints for table `complaint`
--
ALTER TABLE `complaint`
  ADD CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_Id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
