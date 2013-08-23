SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `quebecwhisky` ;
CREATE SCHEMA IF NOT EXISTS `quebecwhisky` DEFAULT CHARACTER SET utf8 ;
USE `quebecwhisky` ;

-- -----------------------------------------------------
-- Table `quebecwhisky`.`Distillery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quebecwhisky`.`Distillery` ;

CREATE  TABLE IF NOT EXISTS `quebecwhisky`.`Distillery` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `country` VARCHAR(255) NULL DEFAULT NULL ,
  `history` VARCHAR(255) NULL DEFAULT NULL ,
  `hyperlink` VARCHAR(255) NULL DEFAULT NULL ,
  `logo` VARCHAR(255) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  `region` VARCHAR(255) NULL DEFAULT NULL ,
  `established` SMALLINT(6) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quebecwhisky`.`Bottle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quebecwhisky`.`Bottle` ;

CREATE  TABLE IF NOT EXISTS `quebecwhisky`.`Bottle` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `abv` SMALLINT(6) NULL DEFAULT NULL ,
  `age` SMALLINT(6) NULL DEFAULT NULL ,
  `bottler` VARCHAR(255) NULL DEFAULT NULL ,
  `finish` VARCHAR(255) NULL DEFAULT NULL ,
  `history` VARCHAR(255) NULL DEFAULT NULL ,
  `logo` VARCHAR(255) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  `priceStore` DOUBLE NULL DEFAULT NULL ,
  `subtype` VARCHAR(255) NULL DEFAULT NULL ,
  `BOTTLE_TYPE` VARCHAR(255) NULL DEFAULT NULL ,
  `distillery_id` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK76F285E6AFAFDC32` (`distillery_id` ASC) ,
  CONSTRAINT `FK76F285E6AFAFDC32`
    FOREIGN KEY (`distillery_id` )
    REFERENCES `quebecwhisky`.`Distillery` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `quebecwhisky`.`Review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quebecwhisky`.`Review` ;

CREATE  TABLE IF NOT EXISTS `quebecwhisky`.`Review` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `author` VARCHAR(255) NULL DEFAULT NULL ,
  `created` DATETIME NULL DEFAULT NULL ,
  `notes` VARCHAR(255) NULL DEFAULT NULL ,
  `rating` DOUBLE NULL DEFAULT NULL ,
  `bottle_id` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FK91B3E3786F7C1B12` (`bottle_id` ASC) ,
  CONSTRAINT `FK91B3E3786F7C1B12`
    FOREIGN KEY (`bottle_id` )
    REFERENCES `quebecwhisky`.`Bottle` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
