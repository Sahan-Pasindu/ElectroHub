-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2021 at 06:21 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uokjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customerID` int(5) NOT NULL,
  `name` text NOT NULL,
  `contactNum` int(10) NOT NULL,
  `email` text NOT NULL,
  `address` text NOT NULL,
  `gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerID`, `name`, `contactNum`, `email`, `address`, `gender`) VALUES
(1, 'Dilshan', 115468952, 'dilshan97@gmail.com', '61/6, Kanampitiya, Galle.', 'Male'),
(2, 'Gayasha', 817568264, 'sgayasha@yahoo.com', 'No. 34, Tangalla, Hambanthota.', 'Female'),
(3, 'Chamindu', 751469532, 'chami56@gmail.com', '81, Sirimal Mw, Gampaha.', 'Male'),
(4, 'Wenura', 764523984, 'wenuraran@gamil.com', '23, 4th floor, Maligawatta.', 'Male'),
(5, 'Sahan', 786615735, 'sahangg9@gmail.com', '225, Colombo Rd, Kegalle.', 'Male'),
(6, 'Nilmini', 764823564, 'nilmmni@yahoo.com', '67/A, Habudugala, Kurunegala.', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` int(10) NOT NULL,
  `name` text NOT NULL,
  `category` text NOT NULL,
  `retailPrice` int(10) NOT NULL,
  `wholesalePrice` int(10) NOT NULL,
  `description` text NOT NULL,
  `activate` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `name`, `category`, `retailPrice`, `wholesalePrice`, `description`, `activate`) VALUES
(1, 'Speakers Maximo Active', 'TV Video and Audio', 32400, 24990, 'Wireless MIC option, Multiple disco lighting effect, RMS:80W ', 'Yes'),
(2, 'Speakers Panasonic 22000W Active', 'TV Video and Audio', 103400, 99990, '2.1ch Digital Amp, 2 way 4 speaker system, Maximized Bass Sound PLUS', 'Yes'),
(7, 'GoPro Chesty – Performance Chest Mount', 'Cameras & Accessories', 11000, 9000, 'Lightweight, flexible, Padded and breathable materials, Fully adjustable, Stable platform', 'Yes'),
(8, 'GoPro Tripod Mounts', 'Cameras & Accessories', 9500, 7000, 'Lightweight, Quick Release Tripod Mount, Attach your GoPro to any standard tripod', 'Yes'),
(9, 'Laptop Dell Intel Core i7 10th Generation Desktop with DELL 19\" Monitor', 'Laptops & Desktops', 224800, 202390, '10th Gen Intel(R) Core(TM) i7-10700 processor, NVIDIA(R) GeForce(R) GT(TM) 730 2GB GDDR5, Warranty 2 years  ', 'Yes'),
(10, 'Laptop Dell Intel Core i5 10th Generation Desktop with DELL 19\" Monitor', 'Laptops & Desktops', 148800, 133900, '10th Gen Intel(R) Core(TM) i5-10400 processor, 1TB 7200RPM 3.5\" SATA HDD, Warranty 2 Years', 'Yes'),
(11, 'Samsung Galaxy S21 ', 'Mobile Phones', 220000, 199900, 'ROM:256GB, RAM:8GB, Nano-SIM, Dual-SIM, 6.7\", USB Type-C, ', 'Yes'),
(12, 'Nokia 3.4', 'Mobile Phones', 37500, 31500, 'ROM:64GB, RAM:3GB, Dual Sim', 'Yes'),
(14, 'Gopro Adapter Bracket for Tripods', 'Cameras & Accessories', 1200, 750, 'Color:Black, Meterial:PC, Support to GoPro Hero1,2,3,4', 'Yes'),
(15, 'Samsung Galaxy M02s', 'Mobile Phones', 35000, 29000, 'ROM:64GB, RAM:4GB, Nano-SIM, 5000mAh', 'Yes'),
(16, 'Canon EOS 850D Kit (EF S 18-55 IS STM)', 'Cameras & Accessories', 210000, 200000, '15 Months Warranty, Dual Pixel CMOS AF, 4K Video Resolution, Bluetooth Enabled', 'Yes'),
(18, 'Radio', 'TV Video and Audio', 5000, 4000, 'tjdsjs', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(10) NOT NULL,
  `customerID` int(10) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `customerID`, `subtotal`, `pay`, `balance`, `time`, `date`) VALUES
(1, 1, 32400, 35000, 2600, '01:03:58', '2021-09-23'),
(2, 3, 103400, 200000, 96600, '01:04:53', '2021-09-23'),
(3, 4, 103400, 150000, 46600, '01:12:57', '2021-09-23'),
(4, 3, 1034000, 2000000, 966000, '01:16:13', '2021-09-23'),
(5, 3, 9500, 10000, 500, '02:41:29', '2021-09-23'),
(6, 2, 135800, 150000, 14200, '03:24:57', '2021-09-23'),
(7, 1, 140900, 150000, 9100, '09:34:31', '2021-09-23'),
(8, 1, 103400, 120000, 16600, '09:35:48', '2021-09-23');

-- --------------------------------------------------------

--
-- Table structure for table `sales_products`
--

CREATE TABLE `sales_products` (
  `id` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL,
  `product_id` text NOT NULL,
  `name` text NOT NULL,
  `price` text NOT NULL,
  `wprice` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `total` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_products`
--

INSERT INTO `sales_products` (`id`, `sales_id`, `product_id`, `name`, `price`, `wprice`, `quantity`, `total`) VALUES
(1, 1, '1', 'Speakers Maximo Active', '32400', 24990, 1, '32400'),
(2, 2, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 1, '103400'),
(3, 3, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 1, '103400'),
(4, 4, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 10, '1034000'),
(5, 5, '8', 'GoPro Tripod Mounts', '9500', 7000, 1, '9500'),
(6, 6, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 1, '103400'),
(7, 6, '1', 'Speakers Maximo Active', '32400', 24990, 1, '32400'),
(8, 7, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 1, '103400'),
(9, 7, '12', 'Nokia 3.4', '37500', 31500, 1, '37500'),
(10, 8, '2', 'Speakers Panasonic 22000W Active', '103400', 99990, 1, '103400');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `productID` int(10) NOT NULL,
  `amountInStock` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`productID`, `amountInStock`) VALUES
(1, 53),
(2, 35),
(3, 50),
(7, 0),
(8, 24),
(9, 7),
(10, 15),
(11, 25),
(12, 19),
(18, 50);

-- --------------------------------------------------------

--
-- Table structure for table `stockhistory`
--

CREATE TABLE `stockhistory` (
  `id` int(10) NOT NULL,
  `productID` int(10) NOT NULL,
  `name` text NOT NULL,
  `amount` int(10) NOT NULL,
  `action` text NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stockhistory`
--

INSERT INTO `stockhistory` (`id`, `productID`, `name`, `amount`, `action`, `date`, `time`) VALUES
(1, 1, 'Speakers Maximo Active', 100, 'ADDED', '2021-09-23', '01:03:02'),
(2, 2, 'Speakers Panasonic 22000W Active', 200, 'ADDED', '2021-09-23', '01:03:10'),
(3, 3, 'fafafaf', 50, 'ADDED', '2021-09-23', '01:23:17'),
(4, 13, 'kkyhykvlk', 100, 'ADDED', '2021-09-23', '02:11:08'),
(5, 13, 'kkyhykvlk', 100, 'ADDED', '2021-09-23', '02:11:34'),
(6, 2, 'Speakers Panasonic 22000W Active', 150, 'REMOVED', '2021-09-23', '02:18:44'),
(7, 1, 'Speakers Maximo Active', 50, 'REMOVED', '2021-09-23', '02:18:50'),
(8, 7, 'GoPro Chesty – Performance Chest Mount', 30, 'ADDED', '2021-09-23', '02:19:01'),
(9, 8, 'GoPro Tripod Mounts', 25, 'ADDED', '2021-09-23', '02:19:08'),
(10, 9, 'Laptop Dell Intel Core i7 10th Generation Desktop with DELL 19\" Monitor', 10, 'ADDED', '2021-09-23', '02:19:13'),
(11, 10, 'Laptop Dell Intel Core i5 10th Generation Desktop with DELL 19\" Monitor', 15, 'ADDED', '2021-09-23', '02:19:42'),
(12, 11, 'Samsung Galaxy S21 ', 25, 'ADDED', '2021-09-23', '02:19:57'),
(13, 12, 'Nokia 3.4', 20, 'ADDED', '2021-09-23', '02:20:05'),
(14, 9, 'Laptop Dell Intel Core i7 10th Generation Desktop with DELL 19\" Monitor', 3, 'REMOVED', '2021-09-23', '02:20:29'),
(15, 7, 'GoPro Chesty – Performance Chest Mount', 30, 'REMOVED', '2021-09-23', '02:20:52'),
(16, 12, 'Nokia 3.4', 20, 'REMOVED', '2021-09-23', '02:38:14'),
(17, 12, 'Nokia 3.4', 20, 'ADDED', '2021-09-23', '02:39:42'),
(18, 17, 'jyr', 100, 'ADDED', '2021-09-23', '02:58:21'),
(19, 17, 'jyr', 100, 'REMOVED', '2021-09-23', '02:58:39'),
(20, 1, 'Speakers Maximo Active', 5, 'ADDED', '2021-09-23', '03:22:43'),
(21, 18, 'Radio', 100, 'ADDED', '2021-09-23', '09:28:45'),
(22, 18, 'Radio', 50, 'REMOVED', '2021-09-23', '09:29:56');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(10) NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `userName` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customerID`),
  ADD UNIQUE KEY `contactNum` (`contactNum`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`),
  ADD UNIQUE KEY `name` (`name`) USING HASH;

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_products`
--
ALTER TABLE `sales_products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `stockhistory`
--
ALTER TABLE `stockhistory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `userName` (`userName`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customerID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `sales_products`
--
ALTER TABLE `sales_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `stockhistory`
--
ALTER TABLE `stockhistory`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
