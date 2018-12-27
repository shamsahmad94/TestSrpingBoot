CREATE TABLE `Task_definition` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Task_definition_mirror` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1