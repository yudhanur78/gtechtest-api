-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 08, 2020 at 05:28 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gtech_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `gt_mst_product`
--

DROP TABLE IF EXISTS `gt_mst_product`;
CREATE TABLE IF NOT EXISTS `gt_mst_product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `store` varchar(20) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `descr` varchar(40) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gt_mst_product`
--

INSERT INTO `gt_mst_product` (`id_product`, `product`, `price`, `store`, `brand`, `category`, `descr`, `created_dt`, `modified_dt`) VALUES
(1, 'meja', 200000, 'meja store', 'mejamania', 'furniture', 'perlengkapan furniture', NULL, NULL),
(2, 'monitor', 350000, 'globalkomputer', 'samyang', 'elektronik', 'perlengkapan kerja', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `gt_mst_user`
--

DROP TABLE IF EXISTS `gt_mst_user`;
CREATE TABLE IF NOT EXISTS `gt_mst_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `mobile_number` varchar(14) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `created_dt` date DEFAULT NULL,
  `modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gt_mst_user`
--

INSERT INTO `gt_mst_user` (`id_user`, `email`, `mobile_number`, `first_name`, `last_name`, `gender`, `date_of_birth`, `password`, `created_dt`, `modified_dt`) VALUES
(1, 'admin@cobain.com', '08120030004', 'juju', NULL, NULL, NULL, '', NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
