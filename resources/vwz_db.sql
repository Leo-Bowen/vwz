-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2021 at 07:50 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vwz_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_db`
--

CREATE TABLE `employee_db` (
  `employee_id` int(11) NOT NULL,
  `employee_firstname` varchar(255) NOT NULL,
  `employee_lastname` varchar(255) NOT NULL,
  `employee_birthdate` date NOT NULL,
  `employee_entrydate` date NOT NULL,
  `employee_position` varchar(255) NOT NULL,
  `employee_schedule` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_db`
--

INSERT INTO `employee_db` (`employee_id`, `employee_firstname`, `employee_lastname`, `employee_birthdate`, `employee_entrydate`, `employee_position`, `employee_schedule`) VALUES
(1, 'Leo', 'Wang', '1999-05-04', '2021-01-01', 'Backend', 'Full-Time'),
(2, 'Fatih', 'Varli', '1998-10-01', '2021-01-02', 'Tutor', 'Full-Time'),
(3, 'Fabian', 'Zdarsky', '1996-01-19', '2021-01-05', ' Archeologist', 'Part-Time');

-- --------------------------------------------------------

--
-- Table structure for table `order_db`
--

CREATE TABLE `order_db` (
  `order_id` int(11) NOT NULL,
  `order_name` varchar(255) NOT NULL,
  `order_quantity` int(11) NOT NULL,
  `order_orderdate` date NOT NULL,
  `order_url` varchar(512) CHARACTER SET ascii DEFAULT NULL,
  `order_status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_db`
--

INSERT INTO `order_db` (`order_id`, `order_name`, `order_quantity`, `order_orderdate`, `order_url`, `order_status`) VALUES
(1, 'iPad Air', 20, '2021-01-05', 'https://www.apple.com/at/shop/buy-ipad/ipad-air', 0),
(2, 'Apple Macbook Pro M1', 15, '2021-01-05', 'https://www.apple.com/at/shop/buy-mac/macbook-pro/13-zoll', 1),
(3, 'Apple MacBook Air M1', 15, '2021-01-05', 'https://www.apple.com/at/shop/buy-mac/macbook-air', 0),
(4, 'Leo Wang', 1, '2021-01-05', 'www.wang.at', 0),
(5, 'Apfel', 1000, '2021-01-05', '', 1),
(6, 'One Direction Concert Ticket', 3, '2021-01-05', 'https://www.onedirectionmusic.com//gb/home.html', 0),
(7, 'iPhone 12 Pro', 7, '2021-01-05', 'https://www.apple.com/at/shop/buy-iphone/iphone-12-pro', 0),
(8, 'Apple iPhone 12', 9, '2021-01-05', 'https://www.apple.com/at/shop/buy-iphone/iphone-12', 0),
(9, 'Dell XPS 15 9500', 2, '2021-01-05', 'https://www.dell.com/de-at/shop/notebooks-ultrabooks/xps-15-laptop/spd/xps-15-9500-laptop', 0),
(10, 'PS5', 500, '2021-01-05', '', 0),
(11, 'XBOX Series X', 123, '2021-01-05', 'https://www.xbox.com/en-US/consoles/xbox-series-x', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_db`
--

CREATE TABLE `product_db` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_entrydate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_db`
--

INSERT INTO `product_db` (`product_id`, `product_name`, `product_quantity`, `product_entrydate`) VALUES
(1, 'Apple iPhone12', 5, '2021-01-02'),
(2, 'Apple iPhone12 Pro', 3, '2021-01-02'),
(3, 'Samsung Galaxy S20', 20, '2021-01-02'),
(4, 'Samsung Galaxy S10', 32, '2021-01-05'),
(5, 'Apple Macbook Air M1', 8, '2021-01-05'),
(6, 'Apple Macbook Pro M1', 8, '2021-01-05'),
(7, 'Dell XPS 15 9500', 14, '2021-01-05'),
(8, 'Lenovo Thinkpad 15', 1, '2021-01-05'),
(9, 'Apple iPad Pro 2020', 17, '2021-01-05'),
(10, 'Apple iPad Air 2020', 65, '2021-01-05'),
(11, 'Samsung Galaxy Fold 2', 5, '2021-01-05'),
(12, 'Nucleo-64 STM32L476', 108, '2020-10-01'),
(13, 'Nucleo-64 STM32F303', 108, '2020-10-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_db`
--
ALTER TABLE `employee_db`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `order_db`
--
ALTER TABLE `order_db`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `product_db`
--
ALTER TABLE `product_db`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee_db`
--
ALTER TABLE `employee_db`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_db`
--
ALTER TABLE `order_db`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `product_db`
--
ALTER TABLE `product_db`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
