
/**
 * Create database for the app.
 */

CREATE DATABASE `taschengeldboerse`;



CREATE USER 'boersenadmin'@'%' IDENTIFIED BY 'admin2015!';
GRANT ALL PRIVILEGES ON taschengeldboerse.* TO 'boersenadmin'@'%';

CREATE USER 'boerse'@'%' IDENTIFIED BY 'admin2015!';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE, SHOW VIEW ON taschengeldboerse.* TO 'boerse'@'%';


CREATE USER 'boersenadmin'@'localhost' IDENTIFIED BY 'admin2015!';
GRANT ALL PRIVILEGES ON taschengeldboerse.* TO 'boersenadmin'@'localhost';

CREATE USER 'boerse'@'localhost' IDENTIFIED BY 'admin2015!';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE, SHOW VIEW ON taschengeldboerse.* TO 'boerse'@'localhost';

FLUSH PRIVILEGES;