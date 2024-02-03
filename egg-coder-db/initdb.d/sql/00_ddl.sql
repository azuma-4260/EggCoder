SET GLOBAL time_zone = "Asia/Tokyo";

-- --------------------------------------------------------

--
-- Table structure for database(EGG_CODER)
--

DROP DATABASE IF EXISTS EGG_CODER;
CREATE DATABASE EGG_CODER
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;
SET default_storage_engine = InnoDB;

USE EGG_CODER;

CREATE TABLE `USER`
(
    `ID_USER`        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `USER_TYPE_CODE` INT          NOT NULL, /* value from enum UserType */
    `NAME`           VARCHAR(100) NOT NULL,
    `DISPLAY_NAME`   VARCHAR(100) NOT NULL,
    `EMAIL`          VARCHAR(256) NOT NULL,
    `CREATED_AT`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `CREATED_BY`     VARCHAR(20)  NOT NULL,
    `UPDATED_AT`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_BY`     VARCHAR(20)  NOT NULL,
    `DELETED_AT`     TIMESTAMP             DEFAULT NULL,
    `ENABLED`        BOOLEAN      NOT NULL DEFAULT 1
);