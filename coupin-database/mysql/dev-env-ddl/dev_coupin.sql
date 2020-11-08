-- | Variables - Ignore Case
SHOW VARIABLES WHERE variable_name LIKE '%case%';
    -- lower_case_file_system  OFF
    -- lower_case_table_names  0



-- | Schema
CREATE DATABASE `coupin`
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_unicode_ci';



-- | USER (ONLY ALLOW FROM BRIDGE - "Gateway": "172.17.0.1")
USE `mysql`;
CREATE USER IF NOT EXISTS 'dev_coupin'@'172.17.0.%' IDENTIFIED BY 'dev_coupin' PASSWORD EXPIRE NEVER;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE `coupin`.* TO 'dev_coupin'@'172.17.0.%';
SHOW GRANTS FOR 'dev_coupin'@'172.17.0.%';



-- | TABLE
USE `coupin`;
CREATE TABLE `coupin`.`UserInfo` (
  `userNo`    BIGINT        NOT NULL AUTO_INCREMENT COMMENT '회원 번호',
  `userId`    VARCHAR(50)   NOT NULL COMMENT '회원 아이디',
  `userPw`    VARCHAR(256)  NOT NULL COMMENT '회원 비밀번호',
  `userEmail` VARCHAR(50)   NOT NULL COMMENT '회원 이메일주소',
  PRIMARY KEY(`userNo`)
);
CREATE INDEX `idx_coupin_userId`    ON `coupin`.`UserInfo`(`userId`);
CREATE INDEX `idx_coupin_userEmail` ON `coupin`.`UserInfo`(`userEmail`);
