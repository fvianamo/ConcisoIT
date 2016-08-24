DROP TABLE IF EXISTS `Buses`;

CREATE TABLE `Buses` (
  `busID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `licensePlate` varchar(7) DEFAULT NULL,
  `routeFK` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`busID`),
  KEY `FK_route` (`routeFK`),
  CONSTRAINT `Buses_ibfk_1` FOREIGN KEY (`routeFK`) REFERENCES `Routes` (`routeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `RELATIONS`;

CREATE TABLE `RELATIONS` (
  `relationsID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `routeID` int(10) unsigned DEFAULT NULL,
  `stopID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`relationsID`),
  KEY `FK_route` (`routeID`),
  KEY `FK_stop` (`stopID`),
  CONSTRAINT `RELATIONS_ibfk_1` FOREIGN KEY (`routeID`) REFERENCES `Routes` (`routeID`),
  CONSTRAINT `RELATIONS_ibfk_2` FOREIGN KEY (`stopID`) REFERENCES `Stops` (`stopID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Routes`;

CREATE TABLE `Routes` (
  `routeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`routeID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Stops`;

CREATE TABLE `Stops` (
  `stopID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `latit` double DEFAULT NULL,
  `longi` double DEFAULT NULL,
  PRIMARY KEY (`stopID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

