-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.0.45-community-nt - MySQL Community Edition (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `banco`;


-- Volcando estructura para tabla banco.tarjetacredito
DROP TABLE IF EXISTS `tarjetacredito`;
CREATE TABLE IF NOT EXISTS `tarjetacredito` (
  `id` int(4) NOT NULL auto_increment,
  `numero` varchar(12) collate utf8_spanish_ci NOT NULL,
  `cupoMaximo` int(6) NOT NULL,
  `cupoDisponible` int(6) NOT NULL,
  `tipo` tinyint(10) NOT NULL,
  `numeroComprobacion` varchar(7) collate utf8_spanish_ci NOT NULL,
  `contrasenha` int(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `numero` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla banco.tarjetacredito: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tarjetacredito` DISABLE KEYS */;
INSERT INTO `tarjetacredito` (`id`, `numero`, `cupoMaximo`, `cupoDisponible`, `tipo`, `numeroComprobacion`, `contrasenha`) VALUES
	(1, '1111', 50000, 19, 1, '123', 321),
	(2, '2222', 100000, 10000, 0, '741', 147),
	(3, '3333', 70000, 1000, 1, '852', 456),
	(4, '4444', 200000, 20001, 1, '852', 369);
/*!40000 ALTER TABLE `tarjetacredito` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
