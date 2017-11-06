CREATE DATABASE mediaservice;
USE mediaservice;

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ismn` varchar(64) NOT NULL,
  `title` varchar(64) NOT NULL,
  `author` varchar(64) NOT NULL,
  `album` varchar(64) NOT NULL,
  `borrowed` boolean NOT NULL,
  `borrower` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ismn` varchar(64) NOT NULL,
  `title` varchar(64) NOT NULL,
  `director` varchar(64) NOT NULL,
  `producer` varchar(64) NOT NULL,
  `borrowed` boolean NOT NULL,
  `borrower` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `tvshow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ismn` varchar(64) NOT NULL,
  `title` varchar(64) NOT NULL,
  `director` varchar(64) NOT NULL,
  `producer` varchar(64) NOT NULL,
  `borrowed` boolean NOT NULL,
  `borrower` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB;