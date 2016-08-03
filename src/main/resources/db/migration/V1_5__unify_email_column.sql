ALTER TABLE taschengeldboerse.anbieter
ADD COLUMN email varchar(255);

UPDATE taschengeldboerse.anbieter
SET anbieter.email=anbieter.emailadresse;

ALTER TABLE taschengeldboerse.anbieter
DROP COLUMN emailadresse;