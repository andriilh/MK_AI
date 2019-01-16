-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2017 at 04:01 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `krs`
--
CREATE DATABASE IF NOT EXISTS `krs` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `krs`;

-- --------------------------------------------------------

--
-- Table structure for table `krs`
--

CREATE TABLE IF NOT EXISTS `krs` (
  `nim` varchar(4) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `id_makul` varchar(4) NOT NULL,
  `makul` varchar(32) NOT NULL,
  `sks` varchar(1) NOT NULL,
  `semester` varchar(2) NOT NULL,
  `dosen` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `krs`
--

INSERT INTO `krs` (`nim`, `nama`, `id_makul`, `makul`, `sks`, `semester`, `dosen`) VALUES
('0001', 'Fikrish Shobah', 'BIND', 'Bahasa Indonesia', '2', '1', 'Anina'),
('0001', 'Fikrish Shobah', 'MTK1', 'Matematika 1', '3', '1', 'Budi'),
('0002', 'Fahrul Anam', 'MTK1', 'Matematika 1', '3', '1', 'Budi'),
('0001', 'Fikrish Shobah', 'MTK1', 'Matematika 1', '3', '1', 'Budi'),
('0002', 'Fahrul Anam', 'AG00', 'Agama', '2', '1', 'Anis'),
('0002', 'Fahrul Anam', 'BIND', 'Bahasa Indonesia', '2', '1', 'Anina'),
('0002', 'Fahrul Anam', 'PW01', 'Pemograman WEB', '3', '1', 'Agus');

-- --------------------------------------------------------

--
-- Table structure for table `makul`
--

CREATE TABLE IF NOT EXISTS `makul` (
  `id_makul` varchar(4) NOT NULL,
  `makul` varchar(32) NOT NULL,
  `sks` varchar(1) NOT NULL,
  `semester` varchar(2) NOT NULL,
  `dosen` varchar(128) NOT NULL,
  PRIMARY KEY (`id_makul`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `makul`
--

INSERT INTO `makul` (`id_makul`, `makul`, `sks`, `semester`, `dosen`) VALUES
('AG00', 'Agama', '2', '1', 'Anis'),
('BIND', 'Bahasa Indonesia', '2', '1', 'Anina'),
('MTK1', 'Matematika 1', '3', '1', 'Budi'),
('PW01', 'Pemograman WEB', '3', '1', 'Agus');

-- --------------------------------------------------------

--
-- Table structure for table `mhs`
--

CREATE TABLE IF NOT EXISTS `mhs` (
  `nim` varchar(4) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `alamat` varchar(128) NOT NULL,
  `jenis_k` varchar(12) NOT NULL,
  `jurusan` varchar(31) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mhs`
--

INSERT INTO `mhs` (`nim`, `nama`, `alamat`, `jenis_k`, `jurusan`) VALUES
('0001', 'Fikrish Shobah', 'Troso Pec Jepara', 'Laki-laki', 'Teknik Informatika'),
('0002', 'Fahrul Anam', 'Troso', 'Laki-laki', 'Teknik Sipil');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
