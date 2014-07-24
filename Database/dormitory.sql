SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `dormitory` ;
CREATE SCHEMA IF NOT EXISTS `dormitory` DEFAULT CHARACTER SET utf8 ;
USE `dormitory` ;

-- -----------------------------------------------------
-- Table `dormitory`.`Tenant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`Tenant` (
  `tenantID` INT(11) NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `image` BLOB NULL,
  `contact` VARCHAR(12) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `degree` VARCHAR(255) NOT NULL,
  `school` VARCHAR(255) NOT NULL,
  `expectedyearofgrad` INT(4) NOT NULL,
  `status` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`tenantID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `dormitory`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`Room` (
  `roomID` INT(11) NOT NULL AUTO_INCREMENT,
  `currentKW` FLOAT NOT NULL,
  `currentcubicmeter` FLOAT NOT NULL,
  PRIMARY KEY (`roomID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;

INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);
INSERT into ROOM (currentKW, currentcubicmeter) values (0,0);



-- -----------------------------------------------------
-- Table `dormitory`.`Bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`Bill` (
  `billID` INT(11) NOT NULL AUTO_INCREMENT,
  `bill_roomID` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `paidRent` TINYINT(1) NOT NULL,
  `paidWater` TINYINT(1) NOT NULL,
  `paidElectric` TINYINT(1) NOT NULL,
  PRIMARY KEY (`billID`),
  INDEX `roomID_idx` (`bill_roomID` ASC),
  CONSTRAINT `bill_roomID`
    FOREIGN KEY (`bill_roomID`)
    REFERENCES `dormitory`.`Room` (`roomID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `dormitory`.`ElectricReading`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`ElectricReading` (
  `electric_billID` INT(11) NOT NULL,
  `currentKW` FLOAT NOT NULL,
  `priceperKW` FLOAT NOT NULL,
  `price` FLOAT NOT NULL,
  `dateRead` DATE NULL,
  INDEX `billID_idx` (`electric_billID` ASC),
  CONSTRAINT `electricID`
    FOREIGN KEY (`electric_billID`)
    REFERENCES `dormitory`.`Bill` (`billID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`WaterReading`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`WaterReading` (
  `water_billID` INT(11) NOT NULL,
  `currentcubicpermeter` FLOAT NOT NULL,
  `pricepercubicmeter` FLOAT NOT NULL,
  `price` FLOAT NOT NULL,
  `dateRead` DATE NULL,
  INDEX `billID_idx` (`water_billID` ASC),
  CONSTRAINT `waterID`
    FOREIGN KEY (`water_billID`)
    REFERENCES `dormitory`.`Bill` (`billID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`Contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`Contract` (
  `contractID` INT(11) NOT NULL AUTO_INCREMENT,
  `contract_tenantID` INT(11) NOT NULL,
  `effectivedate` DATE NOT NULL,
  `expirydate` DATE NOT NULL,
  INDEX `tenantID_idx` (`contract_tenantID` ASC),
  PRIMARY KEY (`contractID`),
  CONSTRAINT `tenantID`
    FOREIGN KEY (`contract_tenantID`)
    REFERENCES `dormitory`.`Tenant` (`tenantID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `dormitory`.`Guardian`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`Guardian` (
  `guardianID` INT(11) NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(12) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`guardianID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `dormitory`.`TenantGuardian`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`TenantGuardian` (
  `tg_tenantID` INT(11) NOT NULL,
  `tg_guardianID` INT(11) NOT NULL,
  INDEX `tenantID_idx` (`tg_tenantID` ASC),
  INDEX `guardianID_idx` (`tg_guardianID` ASC),
  CONSTRAINT `tg_tenantID`
    FOREIGN KEY (`tg_tenantID`)
    REFERENCES `dormitory`.`Tenant` (`tenantID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tg_guardianID`
    FOREIGN KEY (`tg_guardianID`)
    REFERENCES `dormitory`.`Guardian` (`guardianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dormitory`.`AttendanceLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`AttendanceLog` (
  `logID` INT(11) NOT NULL AUTO_INCREMENT,
  `log_tenantID` INT(11) NOT NULL,
  `isIn` TINYINT(1) NOT NULL,
  `timeLogged` TIMESTAMP NOT NULL,
  INDEX `tenantID_idx` (`log_tenantID` ASC),
  PRIMARY KEY (`logID`),
  CONSTRAINT `log_tenantID`
    FOREIGN KEY (`log_tenantID`)
    REFERENCES `dormitory`.`Tenant` (`tenantID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `dormitory`.`TenantRoom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dormitory`.`TenantRoom` (
  `tr_tenantID` INT NOT NULL,
  `tr_roomID` INT NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NULL,
  INDEX `tr_tenantID_idx` (`tr_tenantID` ASC),
  INDEX `tr_roomID_idx` (`tr_roomID` ASC),
  CONSTRAINT `tr_tenantID`
    FOREIGN KEY (`tr_tenantID`)
    REFERENCES `dormitory`.`Tenant` (`tenantID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tr_roomID`
    FOREIGN KEY (`tr_roomID`)
    REFERENCES `dormitory`.`Room` (`roomID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
