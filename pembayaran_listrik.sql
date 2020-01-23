-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2020 at 06:17 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pembayaran_listrik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(11) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `nama_admin` varchar(25) NOT NULL,
  `id_level` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `Username`, `Password`, `nama_admin`, `id_level`) VALUES
('AD01', 'admin', 'admin', 'admin', 'LV001');

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` varchar(11) NOT NULL,
  `nama_level` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id_level`, `nama_level`) VALUES
('LV001', 'Super Admin'),
('LV002', 'Normal Admin');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(11) NOT NULL,
  `Username` varchar(11) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `nomor_KWH` varchar(25) NOT NULL,
  `nama_pelanggan` varchar(25) NOT NULL,
  `alamat` text NOT NULL,
  `id_tarif` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `Username`, `Password`, `nomor_KWH`, `nama_pelanggan`, `alamat`, `id_tarif`) VALUES
('P01', 'andri', '12345', '1420120201235', 'Andrian', 'Bandung', 'RS004');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(11) NOT NULL,
  `id_tagihan` varchar(11) NOT NULL,
  `id_pelanggan` varchar(11) NOT NULL,
  `tanggal_pembayaran` int(11) NOT NULL,
  `bulan_bayar` int(11) NOT NULL,
  `biaya_admin` int(9) NOT NULL,
  `total_bayar` int(9) NOT NULL,
  `id_admin` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_tagihan`, `id_pelanggan`, `tanggal_pembayaran`, `bulan_bayar`, `biaya_admin`, `total_bayar`, `id_admin`) VALUES
('PAY01', 'T01', 'P01', 27, 2, 2500, 372172, NULL),
('PAY02', 'T02', 'P01', 29, 2, 2500, 54828, NULL),
('PAY03', 'T03', 'P01', 31, 3, 2500, 625372, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `penggunaan`
--

CREATE TABLE `penggunaan` (
  `id_penggunaan` varchar(11) NOT NULL,
  `id_pelanggan` varchar(11) NOT NULL,
  `bulan` varchar(11) NOT NULL,
  `tahun` varchar(11) NOT NULL,
  `meter_awal` int(9) NOT NULL,
  `meter_akhir` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penggunaan`
--

INSERT INTO `penggunaan` (`id_penggunaan`, `id_pelanggan`, `bulan`, `tahun`, `meter_awal`, `meter_akhir`) VALUES
('PG01', 'P01', '1', '2020', 581, 143),
('PG02', 'P01', '2', '2020', 2094, 2032),
('PG03', 'P01', '3', '2020', 3078, 2340);

-- --------------------------------------------------------

--
-- Table structure for table `tagihan`
--

CREATE TABLE `tagihan` (
  `id_tagihan` varchar(11) NOT NULL,
  `id_penggunaan` varchar(11) NOT NULL,
  `id_pelanggan` varchar(11) NOT NULL,
  `bulan` int(11) NOT NULL,
  `tahun` int(11) NOT NULL,
  `jumlah_meter` int(9) NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tagihan`
--

INSERT INTO `tagihan` (`id_tagihan`, `id_penggunaan`, `id_pelanggan`, `bulan`, `tahun`, `jumlah_meter`, `status`) VALUES
('T01', 'PG01', 'P01', 1, 2020, 438, 1),
('T02', 'PG02', 'P01', 2, 2020, 62, 1),
('T03', 'PG03', 'P01', 3, 2020, 738, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tarif`
--

CREATE TABLE `tarif` (
  `id_tarif` varchar(11) NOT NULL,
  `daya` int(12) NOT NULL,
  `tarif_perkwh` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarif`
--

INSERT INTO `tarif` (`id_tarif`, `daya`, `tarif_perkwh`) VALUES
('RS001', 900, 421650),
('RS002', 1300, 796450),
('RS003', 2200, 1639750),
('RS004', 3500, 2955450),
('RS005', 4400, 3827550),
('RS006', 5500, 4893450);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD KEY `id_level` (`id_level`) USING BTREE;

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD KEY `id_tarif` (`id_tarif`) USING BTREE;

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD UNIQUE KEY `id_tagihan` (`id_tagihan`,`id_pelanggan`,`id_admin`) USING BTREE,
  ADD KEY `id_admin` (`id_admin`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indexes for table `penggunaan`
--
ALTER TABLE `penggunaan`
  ADD PRIMARY KEY (`id_penggunaan`),
  ADD KEY `id_pelanggan` (`id_pelanggan`) USING BTREE;

--
-- Indexes for table `tagihan`
--
ALTER TABLE `tagihan`
  ADD PRIMARY KEY (`id_tagihan`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_penggunaan` (`id_penggunaan`,`id_pelanggan`) USING BTREE;

--
-- Indexes for table `tarif`
--
ALTER TABLE `tarif`
  ADD PRIMARY KEY (`id_tarif`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `level` (`id_level`);

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`id_tarif`) REFERENCES `tarif` (`id_tarif`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `pembayaran_ibfk_2` FOREIGN KEY (`id_tagihan`) REFERENCES `tagihan` (`id_tagihan`),
  ADD CONSTRAINT `pembayaran_ibfk_3` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);

--
-- Constraints for table `penggunaan`
--
ALTER TABLE `penggunaan`
  ADD CONSTRAINT `penggunaan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);

--
-- Constraints for table `tagihan`
--
ALTER TABLE `tagihan`
  ADD CONSTRAINT `tagihan_ibfk_1` FOREIGN KEY (`id_penggunaan`) REFERENCES `penggunaan` (`id_penggunaan`),
  ADD CONSTRAINT `tagihan_ibfk_2` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
