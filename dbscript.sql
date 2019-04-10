DROP DATABASE IF EXISTS rooms;

CREATE DATABASE rooms;
use rooms;

CREATE  TABLE `room` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `room_name` VARCHAR(45) NOT NULL ,
  `enabled` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`) );
  
INSERT INTO `room`(room_name, enabled) 
	VALUES ('room1', false), 
		   ('room2', true),
		   ('room3', false),
		   ('room4', false),
		   ('room5', true);
