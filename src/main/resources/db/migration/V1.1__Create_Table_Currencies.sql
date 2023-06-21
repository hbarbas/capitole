CREATE TABLE CURRENCIES (
  ID INT NOT NULL PRIMARY KEY,
  NOMBRE VARCHAR(50),
  ISO CHAR(3)
);

INSERT INTO CURRENCIES (ID, NOMBRE, ISO)
VALUES
  (1, 'Euro', 'EUR'),
  (2, 'Dólar estadounidense', 'USD'),
  (3, 'Libra esterlina', 'GBP'),
  (4, 'Yen japonés', 'JPY'),
  (5, 'Dólar canadiense', 'CAD'),
  (6, 'Dólar australiano', 'AUD'),
  (7, 'Franco suizo', 'CHF'),
  (8, 'Peso mexicano', 'MXN'),
  (9, 'Renminbi chino', 'CNY'),
  (10, 'Real brasileño', 'BRL');
