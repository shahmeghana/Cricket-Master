SQLs

CREATE TABLE `userinfo_rtab` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_username` (`username`)
);
  
CREATE TABLE `matchcenter`.`friends_rtab` (
  `userid` INT NOT NULL,
  `friendid` INT NOT NULL,
  UNIQUE KEY `UK_friend` (`userid`,`friendid`)
);
  
CREATE TABLE `portfolio_rtab` (
  `userid` int NOT NULL,
  `eventid` int NOT NULL,
  `eventtype` varchar(45) NOT NULL,
  `score` int(10) unsigned zerofill NOT NULL,
  UNIQUE KEY `UK_portfolio` (`userid`,`eventid`,`eventtype`)
);

CREATE TABLE `matchcenter`.`polls_rtab` (
  `id` INT NOT NULL,
  `userid` INT NOT NULL,
  `question` VARCHAR(200) NOT NULL,
  `report_count` INT ZEROFILL NOT NULL,
  `flagg_count` INT ZEROFILL NOT NULL,
  `when_created` DATETIME NOT NULL,
  `expiration` DATETIME NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`polloptions_rtab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pollid` INT NOT NULL,
  `answer` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `userpollanswers_rtab` (
  `id` int NOT NULL,
  `userid` int NOT NULL,
  `pollid` int NOT NULL,
  `optionid` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_userpolls` (`userid`,`pollid`,`optionid`)
);

CREATE TABLE `matchcenter`.`timetable_rtab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `season` VARCHAR(45) NOT NULL,
  `tournamentid` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` DATETIME NOT NULL,
  `team1` INT NOT NULL,
  `team2` INT NOT NULL,
  `stadium` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`tournament_enum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `game` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`teamlist_rtab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `season` VARCHAR(45) NOT NULL,
  `tournamentid` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`team_rtab` (
  `teamid` INT NOT NULL,
  `playerid` INT NOT NULL
);

CREATE TABLE `matchcenter`.`player_rtab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`publicchats_rtab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userid` INT NOT NULL,
  `comments` VARCHAR(45) NOT NULL,
  `report_count` INT ZEROFILL NOT NULL,
  `flag_count` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`eventtype_enum` (
  `id` INT ZEROFILL NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `matchcenter`.`system.properties_rtab` (
  `name` VARCHAR(50) NOT NULL,
  `values` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`name`)
);
