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
-- Table `coagent`.`agents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`agents` (
  `Agent_Id` INT NOT NULL AUTO_INCREMENT,
  `Agent_Username` VARCHAR(45) NULL DEFAULT NULL,
  `Agent_Hash_Password` BINARY(64) NULL DEFAULT NULL,
  `Agent_Email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Agent_Id`),
  UNIQUE INDEX `Agent_Email_UNIQUE` (`Agent_Email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
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
AUTO_INCREMENT = 6
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
AUTO_INCREMENT = 6
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
    REFERENCES `coagent`.`agents` (`Agent_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Books_Authors1`
    FOREIGN KEY (`Authors_Authors_Id`)
    REFERENCES `coagent`.`authors` (`Authors_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`themes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`themes` (
  `Theme_Id` INT NOT NULL AUTO_INCREMENT,
  `Theme` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Theme_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`book_has_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`book_has_theme` (
  `Books_Id` INT NOT NULL,
  `Theme_Id` INT NOT NULL,
  PRIMARY KEY (`Books_Id`, `Theme_Id`),
  INDEX `Genre_Id_idx` (`Theme_Id` ASC) VISIBLE,
  INDEX `Books_Id_idx` (`Books_Id` ASC) VISIBLE,
  CONSTRAINT `Books_Id`
    FOREIGN KEY (`Books_Id`)
    REFERENCES `coagent`.`books` (`Books_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Theme_Id`
    FOREIGN KEY (`Theme_Id`)
    REFERENCES `coagent`.`themes` (`Theme_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`publishers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`publishers` (
  `Publisher_Id` INT NOT NULL AUTO_INCREMENT,
  `Publisher_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Publisher_Contact` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Publisher_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`editors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`editors` (
  `Editor_Id` INT NOT NULL AUTO_INCREMENT,
  `Editor_Name` VARCHAR(45) NULL DEFAULT NULL,
  `Editor_Contact` VARCHAR(45) NULL DEFAULT NULL,
  `Editor_Interested_In` VARCHAR(45) NULL DEFAULT NULL,
  `Publisher_Publisher_Id` INT NOT NULL,
  PRIMARY KEY (`Editor_Id`, `Publisher_Publisher_Id`),
  INDEX `fk_Editor_Publisher1_idx` (`Publisher_Publisher_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Editor_Publisher1`
    FOREIGN KEY (`Publisher_Publisher_Id`)
    REFERENCES `coagent`.`publishers` (`Publisher_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`contracts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`contracts` (
  `Contract_Id` INT NOT NULL AUTO_INCREMENT,
  `Books_Books_Id` INT NOT NULL,
  `Publisher_Publisher_Id` INT NOT NULL,
  `Editor_Editor_Id` INT NOT NULL,
  PRIMARY KEY (`Contract_Id`, `Books_Books_Id`, `Publisher_Publisher_Id`, `Editor_Editor_Id`),
  INDEX `fk_Contract_Books1_idx` (`Books_Books_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Publisher1_idx` (`Publisher_Publisher_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Editor1_idx` (`Editor_Editor_Id` ASC) VISIBLE,
  INDEX `fk_Contract_Books1` (`Books_Books_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Contract_Books1`
    FOREIGN KEY (`Books_Books_Id`)
    REFERENCES `coagent`.`books` (`Books_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Contract_Editor1`
    FOREIGN KEY (`Editor_Editor_Id`)
    REFERENCES `coagent`.`editors` (`Editor_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Contract_Publisher1`
    FOREIGN KEY (`Publisher_Publisher_Id`)
    REFERENCES `coagent`.`publishers` (`Publisher_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`passwordsalt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`passwordsalt` (
  `Agent_Agent_Id` INT NOT NULL,
  `Salt` BINARY(64) NULL DEFAULT NULL,
  PRIMARY KEY (`Agent_Agent_Id`),
  CONSTRAINT `Agent_Agent_Id`
    FOREIGN KEY (`Agent_Agent_Id`)
    REFERENCES `coagent`.`agents` (`Agent_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coagent`.`submissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`submissions` (
  `Books_Books_Id` INT NOT NULL,
  `Editor_Editor_Id` INT NOT NULL,
  `Reply_Grade` VARCHAR(255) NULL DEFAULT NULL,
  `Last_Updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Books_Books_Id`, `Editor_Editor_Id`),
  INDEX `fk_Books_has_Publisher_Books1_idx` (`Books_Books_Id` ASC) VISIBLE,
  INDEX `fk_Submissions_Editor1_idx` (`Editor_Editor_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Books_has_Publisher_Books1`
    FOREIGN KEY (`Books_Books_Id`)
    REFERENCES `coagent`.`books` (`Books_Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_Submissions_Editor1`
    FOREIGN KEY (`Editor_Editor_Id`)
    REFERENCES `coagent`.`editors` (`Editor_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `coagent` ;

-- -----------------------------------------------------
-- Placeholder table for view `coagent`.`contract_all_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`contract_all_info` (`Books_Title` INT, `Authors_Name` INT, `Clients_Name` INT, `Editor_Name` INT, `Publisher_Name` INT, `Agent_Username` INT);

-- -----------------------------------------------------
-- Placeholder table for view `coagent`.`contract_all_info_with_id`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`contract_all_info_with_id` (`Contract_Id` INT, `Books_Title` INT, `Authors_Name` INT, `Clients_Name` INT, `Editor_Name` INT, `Publisher_Name` INT, `Agent_Username` INT);

-- -----------------------------------------------------
-- Placeholder table for view `coagent`.`search_for_book_theme_editor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`search_for_book_theme_editor` (`Books_Title` INT, `Authors_Name` INT, `Theme` INT, `Editor_Name` INT);

-- -----------------------------------------------------
-- Placeholder table for view `coagent`.`submission_all_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`submission_all_info` (`Books_Title` INT, `Authors_Name` INT, `Clients_Name` INT, `Editor_Name` INT, `Publisher_Name` INT, `Reply_Grade` INT, `Last_Updated` INT, `Agent_Username` INT);

-- -----------------------------------------------------
-- Placeholder table for view `coagent`.`theme_search`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coagent`.`theme_search` (`Books_Title` INT, `Theme` INT);

-- -----------------------------------------------------
-- procedure Update_Submission_Reply
-- -----------------------------------------------------

DELIMITER $$
USE `coagent`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Update_Submission_Reply`(
	`book_id` int,
    `editor_id` int,
	`reply` varchar(255))
BEGIN
	UPDATE submissions
	SET reply = `reply`
	WHERE Editor_Editor_Id = `editor_id` AND Books_Books_Id = `book_id`;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Update_Submission_Reply_Grade
-- -----------------------------------------------------

DELIMITER $$
USE `coagent`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Update_Submission_Reply_Grade`(
	`book_id` int,
    `editor_id` int,
    `reply_grade` int)
BEGIN
	UPDATE submissions
	SET Reply_Grade = `reply_grade`
	WHERE Editor_Editor_Id = `editor_id` AND Books_Books_Id = `book_id`;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- View `coagent`.`contract_all_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coagent`.`contract_all_info`;
USE `coagent`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coagent`.`contract_all_info` AS select `coagent`.`books`.`Books_Title` AS `Books_Title`,`coagent`.`authors`.`Authors_Name` AS `Authors_Name`,`coagent`.`clients`.`Clients_Name` AS `Clients_Name`,`coagent`.`editors`.`Editor_Name` AS `Editor_Name`,`coagent`.`publishers`.`Publisher_Name` AS `Publisher_Name`,`coagent`.`agents`.`Agent_Username` AS `Agent_Username` from ((((((`coagent`.`contracts` join `coagent`.`books` on((`coagent`.`contracts`.`Books_Books_Id` = `coagent`.`books`.`Books_Id`))) join `coagent`.`authors` on((`coagent`.`books`.`Authors_Authors_Id` = `coagent`.`authors`.`Authors_Id`))) join `coagent`.`clients` on((`coagent`.`authors`.`Clients_Clients_Id` = `coagent`.`clients`.`Clients_Id`))) join `coagent`.`editors` on((`coagent`.`contracts`.`Editor_Editor_Id` = `coagent`.`editors`.`Editor_Id`))) join `coagent`.`publishers` on((`coagent`.`editors`.`Publisher_Publisher_Id` = `coagent`.`publishers`.`Publisher_Id`))) join `coagent`.`agents` on((`coagent`.`books`.`Agent_Agent_Id` = `coagent`.`agents`.`Agent_Id`)));

-- -----------------------------------------------------
-- View `coagent`.`contract_all_info_with_id`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coagent`.`contract_all_info_with_id`;
USE `coagent`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coagent`.`contract_all_info_with_id` AS select `coagent`.`contracts`.`Contract_Id` AS `Contract_Id`,`coagent`.`books`.`Books_Title` AS `Books_Title`,`coagent`.`authors`.`Authors_Name` AS `Authors_Name`,`coagent`.`clients`.`Clients_Name` AS `Clients_Name`,`coagent`.`editors`.`Editor_Name` AS `Editor_Name`,`coagent`.`publishers`.`Publisher_Name` AS `Publisher_Name`,`coagent`.`agents`.`Agent_Username` AS `Agent_Username` from ((((((`coagent`.`contracts` join `coagent`.`books` on((`coagent`.`contracts`.`Books_Books_Id` = `coagent`.`books`.`Books_Id`))) join `coagent`.`authors` on((`coagent`.`books`.`Authors_Authors_Id` = `coagent`.`authors`.`Authors_Id`))) join `coagent`.`clients` on((`coagent`.`authors`.`Clients_Clients_Id` = `coagent`.`clients`.`Clients_Id`))) join `coagent`.`editors` on((`coagent`.`contracts`.`Editor_Editor_Id` = `coagent`.`editors`.`Editor_Id`))) join `coagent`.`publishers` on((`coagent`.`editors`.`Publisher_Publisher_Id` = `coagent`.`publishers`.`Publisher_Id`))) join `coagent`.`agents` on((`coagent`.`books`.`Agent_Agent_Id` = `coagent`.`agents`.`Agent_Id`)));

-- -----------------------------------------------------
-- View `coagent`.`search_for_book_theme_editor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coagent`.`search_for_book_theme_editor`;
USE `coagent`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coagent`.`search_for_book_theme_editor` AS select `coagent`.`books`.`Books_Title` AS `Books_Title`,`contract_all_info`.`Authors_Name` AS `Authors_Name`,`coagent`.`themes`.`Theme` AS `Theme`,`contract_all_info`.`Editor_Name` AS `Editor_Name` from (((`coagent`.`contract_all_info` join `coagent`.`books` on((`contract_all_info`.`Books_Title` = `coagent`.`books`.`Books_Title`))) join `coagent`.`book_has_theme` on((`coagent`.`books`.`Books_Id` = `coagent`.`book_has_theme`.`Books_Id`))) join `coagent`.`themes` on((`coagent`.`book_has_theme`.`Theme_Id` = `coagent`.`themes`.`Theme_Id`)));

-- -----------------------------------------------------
-- View `coagent`.`submission_all_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coagent`.`submission_all_info`;
USE `coagent`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coagent`.`submission_all_info` AS select `coagent`.`books`.`Books_Title` AS `Books_Title`,`coagent`.`authors`.`Authors_Name` AS `Authors_Name`,`coagent`.`clients`.`Clients_Name` AS `Clients_Name`,`coagent`.`editors`.`Editor_Name` AS `Editor_Name`,`coagent`.`publishers`.`Publisher_Name` AS `Publisher_Name`,`coagent`.`submissions`.`Reply_Grade` AS `Reply_Grade`,`coagent`.`submissions`.`Last_Updated` AS `Last_Updated`,`coagent`.`agents`.`Agent_Username` AS `Agent_Username` from ((((((`coagent`.`submissions` join `coagent`.`books` on((`coagent`.`submissions`.`Books_Books_Id` = `coagent`.`books`.`Books_Id`))) join `coagent`.`authors` on((`coagent`.`books`.`Authors_Authors_Id` = `coagent`.`authors`.`Authors_Id`))) join `coagent`.`clients` on((`coagent`.`authors`.`Clients_Clients_Id` = `coagent`.`clients`.`Clients_Id`))) join `coagent`.`editors` on((`coagent`.`submissions`.`Editor_Editor_Id` = `coagent`.`editors`.`Editor_Id`))) join `coagent`.`publishers` on((`coagent`.`editors`.`Publisher_Publisher_Id` = `coagent`.`publishers`.`Publisher_Id`))) join `coagent`.`agents` on((`coagent`.`books`.`Agent_Agent_Id` = `coagent`.`agents`.`Agent_Id`)));

-- -----------------------------------------------------
-- View `coagent`.`theme_search`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coagent`.`theme_search`;
USE `coagent`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coagent`.`theme_search` AS select `coagent`.`books`.`Books_Title` AS `Books_Title`,`coagent`.`themes`.`Theme` AS `Theme` from ((`coagent`.`books` join `coagent`.`book_has_theme` on((`coagent`.`books`.`Books_Id` = `coagent`.`book_has_theme`.`Books_Id`))) join `coagent`.`themes` on((`coagent`.`book_has_theme`.`Theme_Id` = `coagent`.`themes`.`Theme_Id`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
