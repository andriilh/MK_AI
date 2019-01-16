-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 22, 2013 at 07:21 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_pmb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_soal`
--

CREATE TABLE IF NOT EXISTS `tabel_soal` (
  `kd_soal` varchar(5) NOT NULL,
  `soal` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `d` text NOT NULL,
  `e` text NOT NULL,
  `benar` text NOT NULL,
  PRIMARY KEY (`kd_soal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_soal`
--

INSERT INTO `tabel_soal` (`kd_soal`, `soal`, `a`, `b`, `c`, `d`, `e`, `benar`) VALUES
('01', 'The increase in the sales of new cars ................... expected to make traffic jams \nworse', 'Is', 'Are', 'Be', 'Being', 'To', 'A'),
('02', 'little children are usually afraid of .................. by their mother', 'Left', 'To Leave', 'Leaving', 'been left', 'Live', 'C'),
('03', 'A : "When did you realize you had lost your purse".\n\nB : "When I ............. one to pay the conductor"', 'Was Needing', 'Had Needed', 'Have Needing', 'Am Needing', 'Was Needed', 'D'),
('04', 'A : "Why didn''t Didi wan to go home ?"\n\nB : "His mother ................... himfor causing the car accident"', 'Would blame', 'Has blamed', 'Is Blaming', 'Had blamed', 'Is Blamed', 'D'),
('05', 'The way professor Mattis teaches english not only keeps the student interest ............', 'And also increases their motivation', 'But also increasing their motivation', 'And he also increases their motivation ', 'But also increases their motivation', 'And also increase their motivation', 'D'),
('06', 'The thief ......................... Into the room through this windows because there are \nfootprint near the door', 'Was to get', 'My get', 'Would rather get', 'Must have got', 'Would rather got', 'D'),
('07', 'He told me alot about the Philipines. He .................. there for a long time	', 'Must have lived	', 'Might be living	', 'Ought to have lived	', 'Should be living	', 'Must to be lived', 'A'),
('08', 'Your son will be operated on tomorrow morning. He .............. have a good rest\ntonight the doctor said	', 'Might	', 'May	', 'Can	', 'Must	', 'Have', 'D'),
('09', 'Having given the prescription to the patient ..............	', 'The medicine was taken regularly by the patient		', 'The medicine is taken by the patient regularly', 'The medicine had to be taken regularly by the patient	', 'The patient was told to take the medicine regularly', 'The doctor told the patient to take the medicine regularly', 'E'),
('10', '.................... a few million rupiahs, he went on a four to Europe	', 'Saved	', 'Has saved	', 'He has saved	', 'Is Saved	', 'Having saved', 'E'),
('11', 'The fact that he was put into prison for something that he had not done made his\nwife ...........................	', 'Cry	', 'To be crying	', 'Cried	', 'To cry	', 'To Cried', 'A'),
('12', 'Doni : "Andi, will you slose the windows, please. I''m bussy right now"\nAndi : "I''m busy my self , but ........................... any how"	', 'Will close them	', 'Will have to close them	', 'Will shoul to closed them', 'Will ask you to close them', 'Will have them closed', 'E'),
('13', 'We are going on a long trip, so we must .........................	', 'Have checked the car	', 'Have had the car checked	', 'To have the car checked	', 'Have the car checked	', 'To chacked the car', 'C'),
('14', 'The company''s new product was ............................ advertised on TV.	', 'Nation	', 'National	', 'Nationally	', 'Nationalize	', 'To nationalize', 'C'),
('15', 'The origninal ....................... manuscript to the play is on display i the museum	', 'Written by hand	', 'Writing hand	', 'Hand written	', 'Writed by hand', 'Hand Writing', 'E'),
('16', 'His shop was burn down, .................. his car that was parked nearby', 'And either did	', 'Also was	', 'But neither was	', 'And so was	', 'But also', 'D'),
('17', 'My mother needs two ....................... To help him run the store.	', 'Assistants', 'Carpenters	', 'Instructors', 'Mechanics', 'Programmers', 'A'),
('18', '.............................. is not yet know	', 'Can he be involved in the trade of narcotics	', 'He was involved in the trade of narcotics	', 'Whether he is involved i the trade of narcotics	', 'When he is involved in the trade of narcotics	', 'He was''nt involved in the trade of narcotics', 'C'),
('19', 'My uncle doesn''t  car much ........................., he can send his children to college	', 'However	', 'And	', 'Therefore	', 'So	', 'But', 'A'),
('20', '"You look so unhappy, Anton. What''s the matter?"\n"My Father ............................ His job"	', 'Has just lose	', 'Has been losing	', 'Losing', 'Is losing', 'Are losing', 'A'),
('21', 'The work ........................... Computer requires well trained personel.	', 'Involved	', 'Involve	', 'To be involve	', 'Involves	', 'To be involves', 'D'),
('22', 'Did i tell you about the girl ........................ I met during the student demostration\nlas week ?	', 'Who	', 'Whom	', 'Whose		', 'Of which	', 'That', 'B'),
('23', 'He asked me whether he ........................ my car to go to party.	', 'Can borrow	', 'Should borrow		', 'Ought to borrow	', 'May Borrow', 'Might borrow', 'E'),
('24', '"Wha did ady finally decided ?" ......................... his master degree in Australia	', 'He can take	', 'His taking	', 'Taking	', 'To take	', 'Take', 'D'),
('25', 'I am still waiting ..................... for an interview	', 'To be called	', 'Be called	', 'Be calling	', 'To call	', 'To calling', 'A'),
('26', 'We were planning to open a new office in Surabaya, ...................... the economic\ncrisis forced us to postpone it', 'And	', 'Or	', 'So	', 'But	', 'That', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `tb_aplikan`
--

CREATE TABLE IF NOT EXISTS `tb_aplikan` (
  `nmr_aplikan` varchar(20) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `tpt_lahir` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `kode_pos` varchar(10) NOT NULL,
  `telp` int(15) NOT NULL,
  `hp` int(17) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pendidikan` varchar(10) NOT NULL,
  `thn_lulus` varchar(10) NOT NULL,
  `nama_ortu` varchar(100) NOT NULL,
  `tgl_datang` date NOT NULL,
  `presenter` varchar(100) NOT NULL,
  `jurusan1` varchar(100) NOT NULL,
  `jurusan2` varchar(100) NOT NULL,
  `sumber_info` varchar(50) NOT NULL,
  `sma` varchar(150) NOT NULL,
  `tahun_ajaran` varchar(15) NOT NULL,
  `mgm` varchar(100) NOT NULL,
  `stat_reg` varchar(10) NOT NULL,
  `stat_daf` varchar(10) NOT NULL,
  `no_ujian` varchar(50) DEFAULT NULL,
  `kd_jurusan` varchar(5) NOT NULL,
  `stat_uj` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`nmr_aplikan`),
  KEY `mgm` (`mgm`),
  KEY `mgm_2` (`mgm`),
  KEY `presenter` (`presenter`),
  KEY `presenter_2` (`presenter`),
  KEY `mgm_3` (`mgm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_aplikan`
--

INSERT INTO `tb_aplikan` (`nmr_aplikan`, `nama`, `tpt_lahir`, `tgl_lahir`, `alamat`, `kode_pos`, `telp`, `hp`, `email`, `pendidikan`, `thn_lulus`, `nama_ortu`, `tgl_datang`, `presenter`, `jurusan1`, `jurusan2`, `sumber_info`, `sma`, `tahun_ajaran`, `mgm`, `stat_reg`, `stat_daf`, `no_ujian`, `kd_jurusan`, `stat_uj`) VALUES
('13001', 'Muhammad Radhial', 'Meulaboh', '1991-12-05', 'Lambhuk	', '23681', 123456, 123456, 'radhial22@gmail.com', 'SMA', '2013', 'Muhammad Jamil', '2013-06-20', 'amsanir', 'Informatika Komputer', 'Komputer Akuntansi', 'Presenter Sekolah', 'SMA 1 Meulaboh', '2013', '-', 'sudah', 'sudah', '2013/IK/13001', 'IK', 'sudah'),
('13002', 'Fahrour Rozi', 'Penjerat', '1992-06-19', 'Lhong Raya	', '23681', 123456, 123456, 'jiji@yahoo.com', 'SMA', '2013', 'Rozi', '2013-06-20', 'Karyadi', 'Informatika Komputer', 'Office Manajemen', 'Alumni', 'SMA 3 Banda Aceh', '2013', 'Udin', 'sudah', 'sudah', '2013/IK/13002', 'IK', 'sudah'),
('13003', 'Riski Nanda', 'Sigli', '1992-05-18', 'Ketapang	', '1234', 123456, 12234, 'riski@gmail.com', 'SMA', '2013', 'Ortu', '2013-06-15', 'alfath', 'Bisnis Administrasi', 'Komputer Akuntansi', 'Street Banner', 'SMA 3 Banda Aceh', '2013', 'Udin', 'belum', 'sudah', '2013/BA/13003', 'BA', 'sudah'),
('13004', 'Tri Suwarso', 'Meulaboh', '1992-05-18', 'Lamtemen	', '233', 12112, 12121, 'tri@gmail.com', 'SMA', '2013', 'Suwarso', '2013-06-12', 'alfath', 'Office Manajemen', 'Bisnis Administrasi', 'Presenter Sekolah', 'SMA 1 Meulaboh', '2013', '-', 'belum', 'belum', NULL, 'OM', 'belum'),
('13005', 'Ardy Munawir', 'Blang Pidie', '1995-05-22', 'Lampaseh	', '2323', 2828, 2828, 'ards@yahoo.com', 'SMA', '2013', 'Munawir', '2013-06-12', 'Karyadi', 'Informatika Komputer', 'Informatika Komputer', 'Surat Kabar', 'SMA 3 Banda Aceh', '2013', 'Mahmud', 'belum', 'belum', NULL, 'IK', 'belum'),
('13006', 'Ziky Fuadi', 'Montasik', '1995-05-22', 'Montasik	', '2398', 1211, 2321121, 'kiki@gmail.com', 'SMA', '2013', 'Fuadi', '2013-06-17', 'amsanir', 'Office Manajemen', 'Bisnis Administrasi', 'Alumni', 'SMA 1 Meulaboh', '2013', '-', 'sudah', 'sudah', '2013/OM/13006', 'OM', 'sudah'),
('13007', 'Cut Ramatullaili', 'Aceh Tamiang', '1992-05-19', 'Ajun Jumpet	', '2322', 8888, 9999, 'icut@yahoo.com', 'SMA', '2013', 'Maulian', '2013-06-17', 'Karyadi', 'Informatika Komputer', 'Bisnis Administrasi', 'Presenter Sekolah', 'SMA 3 Banda Aceh', '2013', 'Udin', 'belum', 'belum', NULL, 'IK', 'belum'),
('13008', 'Maulian Saputra', 'Banda Aceh', '1992-05-19', 'Lueng Bata	', '23232', 34433, 8989, 'momol@gmail.com', 'SMA', '2013', 'Maulian', '2013-06-17', 'amsanir', 'Office Manajemen', 'Komputer Akuntansi', 'Street Banner', 'SMA 3 Banda Aceh', '2013', 'Udin', 'belum', 'belum', NULL, 'OM', 'belum'),
('13009', 'Nur Bahari', 'Peunayong', '1992-05-15', 'Peunayong	', '333', 3788, 23681, 'nur@yahoo.com', 'SMA', '2013', 'Baharie', '2013-06-17', 'amsanir', 'Komputer Akuntansi', 'Informatika Komputer', 'Surat Kabar', 'SMA 1 Meulaboh', '2013', '-', 'belum', 'sudah', '2013/KA/13009', 'KA', 'belum'),
('13010', 'Afzalur Syaref', 'Blang Pidie', '1992-05-15', 'Lam Dingin	', '2323', 23222, 232222, 'af@gmail.com', 'SMA', '2013', 'Syaef', '2013-06-20', 'Karyadi', 'Office Manajemen', 'Informatika Komputer', 'Street Banner', 'SMA 1 Meulaboh', '2013', '-', 'belum', 'sudah', '2013/OM/13010', 'OM', 'belum'),
('13011', 'Fajar', 'Banda Aceh', '2013-06-18', 'Banda Aceh', '22', 666, 66, 'fajar@jj.com', 'SMA', '2013', 'Muhammad', '2013-06-20', 'amsanir', 'Informatika Komputer', 'Office Manajemen', 'Surat Kabar', 'SMA 1 Meulaboh', '2013', 'Udin', 'belum', 'sudah', '2013/IK/13011', 'IK', 'belum');

-- --------------------------------------------------------

--
-- Table structure for table `tb_inggris`
--

CREATE TABLE IF NOT EXISTS `tb_inggris` (
  `no_ujian` varchar(100) NOT NULL,
  `no_aplikan` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `presenter` varchar(100) NOT NULL,
  `jur1` varchar(50) NOT NULL,
  `jur2` varchar(50) NOT NULL,
  `tgl` date NOT NULL,
  `benar` int(5) NOT NULL,
  `waktu` varchar(10) NOT NULL,
  `grade` varchar(1) NOT NULL,
  `petugas` varchar(100) NOT NULL,
  PRIMARY KEY (`no_ujian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_inggris`
--

INSERT INTO `tb_inggris` (`no_ujian`, `no_aplikan`, `nama`, `presenter`, `jur1`, `jur2`, `tgl`, `benar`, `waktu`, `grade`, `petugas`) VALUES
('2013/BA/13003', '13003', 'Riski Nanda', 'alfath', 'Bisnis Administrasi', 'Komputer Akuntansi', '2013-06-20', 11, '00:47:71', 'C', 'Amsanir'),
('2013/IK/13001', '13001', 'Muhammad Radhial', 'amsanir', 'Informatika Komputer', 'Komputer Akuntansi', '2013-06-20', 25, '00:44:25', 'A', 'Alfath'),
('2013/IK/13002', '13002', 'Fahrour Rozi', 'Karyadi', 'Informatika Komputer', 'Office Manajemen', '2013-06-20', 8, '00:37:07', 'D', 'Amsanir'),
('2013/OM/13006', '13006', 'Ziky Fuadi', 'amsanir', 'Office Manajemen', 'Bisnis Administrasi', '2013-06-20', 12, '00:40:75', 'C', 'Amsanir');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jurusan`
--

CREATE TABLE IF NOT EXISTS `tb_jurusan` (
  `kd_jurusan` varchar(10) NOT NULL,
  `jurusan` varchar(100) NOT NULL,
  PRIMARY KEY (`kd_jurusan`),
  KEY `jurusan` (`jurusan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jurusan`
--

INSERT INTO `tb_jurusan` (`kd_jurusan`, `jurusan`) VALUES
('BA', 'Bisnis Administrasi'),
('IK', 'Informatika Komputer'),
('KA', 'Komputer Akuntansi'),
('OM', 'Office Manajemen');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kab`
--

CREATE TABLE IF NOT EXISTS `tb_kab` (
  `kd_kab` varchar(5) NOT NULL,
  `kabupaten` varchar(50) NOT NULL,
  PRIMARY KEY (`kd_kab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kab`
--

INSERT INTO `tb_kab` (`kd_kab`, `kabupaten`) VALUES
('1', 'Aceh Barat'),
('2', 'Bener Meriah'),
('3', 'Aceh Singkil'),
('4', 'Banda Aceh');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelas`
--

CREATE TABLE IF NOT EXISTS `tb_kelas` (
  `kd_kelas` varchar(10) NOT NULL,
  `kelas` varchar(100) NOT NULL,
  `jumlah_siswa` int(11) NOT NULL,
  PRIMARY KEY (`kd_kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelas`
--

INSERT INTO `tb_kelas` (`kd_kelas`, `kelas`, `jumlah_siswa`) VALUES
('01', 'IK-60', 26),
('02', 'IK-61', 26),
('03', 'IK-62', 26),
('04', 'BA-60', 26),
('05', 'BA-62', 26),
('06', 'KA-60', 26),
('07', 'KA-61', 26);

-- --------------------------------------------------------

--
-- Table structure for table `tb_lap`
--

CREATE TABLE IF NOT EXISTS `tb_lap` (
  `nama` varchar(100) NOT NULL,
  `no_ujian` varchar(100) NOT NULL,
  `placement1` varchar(100) DEFAULT NULL,
  `waktu1` varchar(100) DEFAULT NULL,
  `placemnet2` varchar(100) DEFAULT NULL,
  `waktu2` varchar(100) DEFAULT NULL,
  `placement3` varchar(100) DEFAULT NULL,
  `waktu3` varchar(20) DEFAULT NULL,
  `grade` varchar(1) NOT NULL,
  `jurusanlus` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_lap`
--

INSERT INTO `tb_lap` (`nama`, `no_ujian`, `placement1`, `waktu1`, `placemnet2`, `waktu2`, `placement3`, `waktu3`, `grade`, `jurusanlus`) VALUES
('Andi Mahmud', '010111/IK/2013', '8', '14 Menit', '20', '12 Menit', NULL, NULL, 'A', 'Informatika Komputer');

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE IF NOT EXISTS `tb_login` (
  `id_user` varchar(10) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`id_user`, `pass`, `status`) VALUES
('radhial', 'radhial', 'admin'),
('user', 'user', 'User Cs');

-- --------------------------------------------------------

--
-- Table structure for table `tb_media`
--

CREATE TABLE IF NOT EXISTS `tb_media` (
  `kd_media` varchar(5) NOT NULL,
  `media_info` varchar(40) NOT NULL,
  PRIMARY KEY (`kd_media`),
  KEY `media_info` (`media_info`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_media`
--

INSERT INTO `tb_media` (`kd_media`, `media_info`) VALUES
('2', 'Alumni'),
('4', 'Iklan'),
('3', 'Presenter Sekolah'),
('5', 'Street Banner'),
('1', 'Surat Kabar');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mgm`
--

CREATE TABLE IF NOT EXISTS `tb_mgm` (
  `kd_mgm` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`kd_mgm`),
  KEY `nama` (`nama`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mgm`
--

INSERT INTO `tb_mgm` (`kd_mgm`, `nama`) VALUES
('1', 'Mahmud'),
('2', 'Udin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pendaftaran`
--

CREATE TABLE IF NOT EXISTS `tb_pendaftaran` (
  `no_daftar` varchar(20) NOT NULL,
  `no_aplikan` varchar(50) NOT NULL,
  `no_ujian` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tgl` date NOT NULL,
  `thn_ajaran` varchar(10) NOT NULL,
  `biaya` int(11) NOT NULL,
  `tipe_diskon` varchar(15) NOT NULL,
  `diskon` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `terbilang` varchar(200) NOT NULL,
  PRIMARY KEY (`no_daftar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pendaftaran`
--

INSERT INTO `tb_pendaftaran` (`no_daftar`, `no_aplikan`, `no_ujian`, `nama`, `tgl`, `thn_ajaran`, `biaya`, `tipe_diskon`, `diskon`, `bayar`, `terbilang`) VALUES
('13001/IK/2013', '13001', '2013/IK/13001', 'Muhammad Radhial', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13002/IK/2013', '13002', '2013/IK/13002', 'Fahrour Rozi', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13003/BA/2013', '13003', '2013/BA/13003', 'Riski Nanda', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13006/OM/2013', '13006', '2013/OM/13006', 'Ziky Fuadi', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13009/KA/2013', '13009', '2013/KA/13009', 'Nur Bahari', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13010/OM/2013', '13010', '2013/OM/13010', 'Afzalur Syaref', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah'),
('13011/IK/2013', '13011', '2013/IK/13011', 'Fajar', '2013-06-20', '2013', 250000, 'Quisioner', 100000, 150000, 'seratus lima puluh ribu Rupiah');

-- --------------------------------------------------------

--
-- Table structure for table `tb_petugas_ujian`
--

CREATE TABLE IF NOT EXISTS `tb_petugas_ujian` (
  `kd_petugas` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  PRIMARY KEY (`kd_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_petugas_ujian`
--

INSERT INTO `tb_petugas_ujian` (`kd_petugas`, `nama`, `no_hp`) VALUES
('1', 'Amsanir', '01020202'),
('2', 'Alfath', '69'),
('3', 'Karyadi', '089');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pewawancara`
--

CREATE TABLE IF NOT EXISTS `tb_pewawancara` (
  `kd_pewawancara` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  PRIMARY KEY (`kd_pewawancara`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pewawancara`
--

INSERT INTO `tb_pewawancara` (`kd_pewawancara`, `nama`, `no_hp`) VALUES
('1', 'amsanir', '34534'),
('2', 'alfath', '2342'),
('3', 'Karyadi', '089');

-- --------------------------------------------------------

--
-- Table structure for table `tb_place`
--

CREATE TABLE IF NOT EXISTS `tb_place` (
  `no_ujian` varchar(50) NOT NULL,
  `no_aplikan` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tgl` date NOT NULL,
  `jurusan1` varchar(50) NOT NULL,
  `jurusan2` varchar(50) NOT NULL,
  `test_ke1` varchar(2) NOT NULL,
  `waktu1` varchar(5) NOT NULL,
  `test_ke2` varchar(2) NOT NULL,
  `waktu2` varchar(5) NOT NULL,
  `test_ke3` varchar(2) NOT NULL,
  `waktu3` varchar(5) NOT NULL,
  `petugas_ujian` varchar(100) NOT NULL,
  PRIMARY KEY (`no_ujian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_place`
--

INSERT INTO `tb_place` (`no_ujian`, `no_aplikan`, `nama`, `tgl`, `jurusan1`, `jurusan2`, `test_ke1`, `waktu1`, `test_ke2`, `waktu2`, `test_ke3`, `waktu3`, `petugas_ujian`) VALUES
('2013/BA/13003', '13003', 'Riski Nanda', '2013-06-20', 'Bisnis Administrasi', 'Komputer Akuntansi', '20', '12:12', '', '', '', '', 'Amsanir'),
('2013/IK/13001', '13001', 'Muhammad Radhial', '2013-06-20', 'Informatika Komputer', 'Komputer Akuntansi', '20', '10:10', '', '', '', '', 'Alfath'),
('2013/IK/13002', '13002', 'Fahrour Rozi', '2013-06-20', 'Informatika Komputer', 'Office Manajemen', '20', '14:00', '', '', '', '', 'Karyadi'),
('2013/OM/13006', '13006', 'Ziky Fuadi', '2013-06-20', 'Office Manajemen', 'Bisnis Administrasi', '10', '14:16', '19', '10:13', '', '', 'Alfath');

-- --------------------------------------------------------

--
-- Table structure for table `tb_presenter`
--

CREATE TABLE IF NOT EXISTS `tb_presenter` (
  `kd_presenter` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  PRIMARY KEY (`kd_presenter`),
  KEY `nama` (`nama`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_presenter`
--

INSERT INTO `tb_presenter` (`kd_presenter`, `nama`, `no_hp`) VALUES
('1', 'amsanir', '1231'),
('2', 'alfath', '32323'),
('3', 'Karyadi', '089');

-- --------------------------------------------------------

--
-- Table structure for table `tb_registrasi`
--

CREATE TABLE IF NOT EXISTS `tb_registrasi` (
  `no_regis` varchar(11) NOT NULL,
  `no_aplikan` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tgl` date NOT NULL,
  `kelas` varchar(100) NOT NULL,
  PRIMARY KEY (`no_regis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_registrasi`
--

INSERT INTO `tb_registrasi` (`no_regis`, `no_aplikan`, `nama`, `tgl`, `kelas`) VALUES
('1010', '13006', 'Ziky Fuadi', '2013-06-20', 'IK-60'),
('1020', '13001', 'Muhammad Radhial', '2013-06-20', 'IK-61'),
('1030', '13002', 'Fahrour Rozi', '2013-06-20', 'IK-61');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sekolah`
--

CREATE TABLE IF NOT EXISTS `tb_sekolah` (
  `kd_sekolah` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kabupaten` varchar(50) NOT NULL,
  PRIMARY KEY (`kd_sekolah`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_sekolah`
--

INSERT INTO `tb_sekolah` (`kd_sekolah`, `nama`, `kabupaten`) VALUES
('1', 'SMA 1 Meulaboh', 'Aceh Barat'),
('2', 'SMA 3 Banda Aceh', 'Banda Aceh');

-- --------------------------------------------------------

--
-- Table structure for table `tb_tahun`
--

CREATE TABLE IF NOT EXISTS `tb_tahun` (
  `thn_ajaran` varchar(10) NOT NULL,
  `biaya` int(11) NOT NULL,
  `diskon_quis` int(11) NOT NULL,
  `diskon_sekolah` int(11) NOT NULL,
  `undangan` varchar(50) NOT NULL,
  PRIMARY KEY (`thn_ajaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_tahun`
--

INSERT INTO `tb_tahun` (`thn_ajaran`, `biaya`, `diskon_quis`, `diskon_sekolah`, `undangan`) VALUES
('2013', 250000, 100000, 100000, 'Udangan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_tes`
--

CREATE TABLE IF NOT EXISTS `tb_tes` (
  `no` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_tes`
--

INSERT INTO `tb_tes` (`no`, `nama`) VALUES
(1, 'andi'),
(2, 'lala');

-- --------------------------------------------------------

--
-- Table structure for table `tb_wawancara`
--

CREATE TABLE IF NOT EXISTS `tb_wawancara` (
  `no_ujian` varchar(50) NOT NULL,
  `no_aplikan` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jurusan1` varchar(50) NOT NULL,
  `jurusan2` varchar(50) NOT NULL,
  `komu_lisan` varchar(30) NOT NULL,
  `komu_tulis` varchar(30) NOT NULL,
  `kem_itel` varchar(30) NOT NULL,
  `motivasi` varchar(30) NOT NULL,
  `kedewasaan` varchar(30) NOT NULL,
  `kem_kerjasama` varchar(30) NOT NULL,
  `pd` varchar(30) NOT NULL,
  `daya_analisis` varchar(30) NOT NULL,
  `kem_adm` varchar(30) NOT NULL,
  `kelebihan` text NOT NULL,
  `penampilan` varchar(5) NOT NULL,
  `penyakit` text NOT NULL,
  `kacamata` varchar(8) NOT NULL,
  `ukuran` varchar(5) NOT NULL,
  `iq` varchar(5) NOT NULL,
  `kesimpulan` varchar(20) NOT NULL,
  `predikat` varchar(2) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `petugas` varchar(50) NOT NULL,
  PRIMARY KEY (`no_ujian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_wawancara`
--

INSERT INTO `tb_wawancara` (`no_ujian`, `no_aplikan`, `nama`, `jurusan1`, `jurusan2`, `komu_lisan`, `komu_tulis`, `kem_itel`, `motivasi`, `kedewasaan`, `kem_kerjasama`, `pd`, `daya_analisis`, `kem_adm`, `kelebihan`, `penampilan`, `penyakit`, `kacamata`, `ukuran`, `iq`, `kesimpulan`, `predikat`, `jurusan`, `petugas`) VALUES
('2013/BA/13003', '13003', 'Riski Nanda', 'Bisnis Administrasi', 'Komputer Akuntansi', 'Diatas Rata-rata', 'Utama', 'Utama', 'Diatas Rata-rata', 'Utama', 'Diatas Rata-rata', 'Utama', 'Diatas Rata-rata', 'Diatas Rata-rata', 'Lebih Kurang	', 'A', 'Tidak ada', 'Ya', '2', 'A', 'Lulus', 'A', 'Office Manajemen', 'amsanir'),
('2013/IK/13001', '13001', 'Muhammad Radhial', 'Informatika Komputer', 'Komputer Akuntansi', 'Utama', 'Utama', 'Utama', 'Utama', 'Utama', 'Utama', 'Utama', 'Utama', 'Utama', 'Sangat lebih', 'A', 'Tidak pernah', 'Tidak', '-', 'A', 'Lulus', 'A', 'Informatika Komputer', 'Karyadi'),
('2013/IK/13002', '13002', 'Fahrour Rozi', 'Informatika Komputer', 'Office Manajemen', 'Diatas Rata-rata', 'Diatas Rata-rata', 'Diatas Rata-rata', 'Diatas Rata-rata', 'Diatas Rata-rata', 'Utama', 'Utama', 'Utama', 'Utama', 'Lebih kurang', 'A', 'Tidak ada', 'Tidak', '', 'A', 'Lulus', 'A', 'Informatika Komputer', 'amsanir'),
('2013/OM/13006', '13006', 'Ziky Fuadi', 'Office Manajemen', 'Bisnis Administrasi', 'Diatas Rata-rata', 'Utama', 'Utama', 'Rata-rata', 'Rata-rata', 'Diatas Rata-rata', 'Utama', 'Rata-rata', 'Diatas Rata-rata', 'Kurang lebih', 'A', 'Tidak ada', 'Tidak', '-', 'A', 'Lulus', 'A', 'Bisnis Administrasi', 'alfath');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
