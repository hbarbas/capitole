CREATE TABLE PUBLIC.CURRENCIES
(
    ID     INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50) NOT NULL UNIQUE,
    ISO    CHAR(3) NOT NULL UNIQUE
);
