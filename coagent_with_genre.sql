-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema coagent
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema coagent
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coagent` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `coagent` ;

-- -----------------------------------------------------
-- Table `coagent`.`agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`agent` (
  `Agent_Id` INT NOT NULL AUTO_INCREMENT,
  `Agent_Username` VARCHAR(45) NULL DEFAULT NULL,
  `Agent_Password` VARCHAR(45) NULL DEFAULT NULL,
  `Agent_Email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Agent_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`clients` (
  `Clients_Id` INT NOT NULL AUTO_INCREMENT,
  `Clients_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Clients_Contact` VARCHAR(45) NULL DEFAULT NULL,
  `Clients_Email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Clients_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`authors` (
  `Authors_Id` INT NOT NULL AUTO_INCREMENT,
  `Authors_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Clients_Clients_Id` INT NOT NULL,
  PRIMARY KEY (`Authors_Id`, `Clients_Clients_Id`),
  INDEX `fk_Authors_Clients_idx` (`Clients_Clients_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Authors_Clients`
    FOREIGN KEY (`Clients_Clients_Id`)
    REFERENCES `coagent`.`clients` (`Clients_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`books` (
  `Books_Id` INT NOT NULL AUTO_INCREMENT,
  `Books_Title` VARCHAR(45) NULL DEFAULT NULL,
  `Books_Genre` VARCHAR(45) NULL DEFAULT NULL,
  `Books_Tag` VARCHAR(45) NULL DEFAULT NULL,
  `Agent_Agent_Id` INT NOT NULL,
  `Authors_Authors_Id` INT NOT NULL,
  PRIMARY KEY (`Books_Id`, `Agent_Agent_Id`, `Authors_Authors_Id`),
  INDEX `fk_Books_Agent1_idx` (`Agent_Agent_Id` ASC) VISIBLE,
  INDEX `fk_Books_Authors1_idx` (`Authors_Authors_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Books_Agent1`
    FOREIGN KEY (`Agent_Agent_Id`)
    REFERENCES `coagent`.`agent` (`Agent_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Books_Authors1`
    FOREIGN KEY (`Authors_Authors_Id`)
    REFERENCES `coagent`.`authors` (`Authors_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`genre` (
  `Genre_Id` INT NOT NULL AUTO_INCREMENT,
  `Genre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Genre_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`book_has_genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`book_has_genre` (
  `Books_Has_Genre_Id` INT NOT NULL AUTO_INCREMENT,
  `Books_Id` INT NOT NULL,
  `Genre_Id` INT NOT NULL,
  PRIMARY KEY (`Books_Has_Genre_Id`),
  INDEX `Genre_Id_idx` (`Genre_Id` ASC) VISIBLE,
  INDEX `Books_Id_idx` (`Books_Id` ASC) VISIBLE,
  CONSTRAINT `Books_Id`
    FOREIGN KEY (`Books_Id`)
    REFERENCES `coagent`.`books` (`Books_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Genre_Id`
    FOREIGN KEY (`Genre_Id`)
    REFERENCES `coagent`.`genre` (`Genre_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`publisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`publisher` (
  `Publisher_Id` INT NOT NULL AUTO_INCREMENT,
  `Publisher_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Publisher_Contact` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Publisher_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`editor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`editor` (
  `Editor_Id` INT NOT NULL AUTO_INCREMENT,
  `Editor_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Editor_Contact` VARCHAR(45) NULL DEFAULT NULL,
  `Editor_Interested_In` VARCHAR(45) NULL DEFAULT NULL,
  `Publisher_Publisher_Id` INT NOT NULL,
  PRIMARY KEY (`Editor_Id`, `Publisher_Publisher_Id`),
  INDEX `fk_Editor_Publisher1_idx` (`Publisher_Publisher_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Editor_Publisher1`
    FOREIGN KEY (`Publisher_Publisher_Id`)
    REFERENCES `coagent`.`publisher` (`Publisher_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`contract` (
  `Contract_Id` INT NOT NULL AUTO_INCREMENT,
  `Books_Books_Id` INT NOT NULL,
  `Books_Authors_Authors_Id` INT NOT NULL,
  `Books_Authors_Clients_Clients_Id` INT NOT NULL,
  `Books_Agent_Agent_Id` INT NOT NULL,
  `Publisher_Publisher_Id` INT NOT NULL,
  `Editor_Editor_Id` INT NOT NULL,
  PRIMARY KEY (`Contract_Id`, `Books_Books_Id`, `Books_Authors_Authors_Id`, `Books_Authors_Clients_Clients_Id`, `Books_Agent_Agent_Id`, `Publisher_Publisher_Id`, `Editor_Editor_Id`),
  INDEX `fk_Contract_Books1_idx` (`Books_Books_Id` ASC, `Books_Authors_Authors_Id` ASC, `Books_Authors_Clients_Clients_Id` ASC, `Books_Agent_Agent_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Publisher1_idx` (`Publisher_Publisher_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Editor1_idx` (`Editor_Editor_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Books1` (`Books_Books_Id` ASC, `Books_Agent_Agent_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Contract_Books1`
    FOREIGN KEY (`Books_Books_Id` , `Books_Agent_Agent_Id`)
    REFERENCES `coagent`.`books` (`Books_Id` , `Agent_Agent_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Contract_Editor1`
    FOREIGN KEY (`Editor_Editor_Id`)
    REFERENCES `coagent`.`editor` (`Editor_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Contract_Publisher1`
    FOREIGN KEY (`Publisher_Publisher_Id`)
    REFERENCES `coagent`.`publisher` (`Publisher_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`submissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`submissions` (
  `Submissions_Id` INT NOT NULL AUTO_INCREMENT,
  `Books_Books_Id` INT NOT NULL,
  `Editor_Editor_Id` INT NOT NULL,
  PRIMARY KEY (`Submissions_Id`, `Books_Books_Id`, `Editor_Editor_Id`),
  INDEX `fk_Books_has_Publisher_Books1_idx` (`Books_Books_Id` ASC) VISIBLE,
  INDEX `fk_Submissions_Editor1_idx` (`Editor_Editor_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Books_has_Publisher_Books1`
    FOREIGN KEY (`Books_Books_Id`)
    REFERENCES `coagent`.`books` (`Books_Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_Submissions_Editor1`
    FOREIGN KEY (`Editor_Editor_Id`)
    REFERENCES `coagent`.`editor` (`Editor_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
