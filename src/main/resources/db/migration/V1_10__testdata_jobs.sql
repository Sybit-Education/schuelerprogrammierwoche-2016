/* 
 * Schuelerprojekt: Taschengeldboerse
 * Sybit GmbH - www.sybit.de -  Apache License, Version 2.0
 * https://github.com/Sybit-Education/schuelerprogrammierwoche-201
 */
/**
 * Author:  Schulungsnb04
 * Created: 04.08.2016
 */
/*
-- Query: SELECT * FROM taschengeldboerse.jobs
LIMIT 0, 1000

-- Date: 2016-08-04 10:16
*/
INSERT INTO `taschengeldboerse`.`user` 
(`email`, `authority`, `enabled`, `password`)
VALUES ('elfriede@troll.de', 'ROLE_ANBIETER', '1', '$2a$10$4.W3mxoRfPNq17F8rCjU.e9ZvCMByQOgrflOte2dvN/a0tJlHSpl6');

INSERT INTO `taschengeldboerse`.`anbieter` VALUES (2,'Frau','Elfriede','Troll',NULL,'Elfenstr.5','87654','Tausendfuß','',0,0,NULL,'elfriede@troll.de');

INSERT INTO `taschengeldboerse`.`jobs` (`id`,`bezeichnung`,`anbieter`,`schueler`,`datum`,`uhrzeit`,`zeitaufwand`,`entlohnung`,`zusaetzliche_infos`,`turnus`,`anforderungen`) VALUES (1,'Hilfe beim Rasenmähen',2,NULL,'4.August.2016','14 Uhr','5 h','150','Mein Elfengarten muss gemäht werden, da mein Drache kein Gras isst. Mein Garten hat 1000 Quadratmeter und meine Froschblüter sollten stehen bleiben. Für die Entsorgung steht eine Biotonne bereit. ',0,'keine Angst vor Drachen ');
INSERT INTO `taschengeldboerse`.`jobs` (`id`,`bezeichnung`,`anbieter`,`schueler`,`datum`,`uhrzeit`,`zeitaufwand`,`entlohnung`,`zusaetzliche_infos`,`turnus`,`anforderungen`) VALUES (2,'Hilfe beim Einkaufen',2,NULL,'4.August.2016','11 Uhr','3 h','99','-Fleisch für meinen Drachen\r\n-einkaufen bei Rewe\r\n-einkaufen im Elfenladen ',1,'Mobiles Endgerät, kräftiger Bursche');
INSERT INTO `taschengeldboerse`.`jobs` (`id`,`bezeichnung`,`anbieter`,`schueler`,`datum`,`uhrzeit`,`zeitaufwand`,`entlohnung`,`zusaetzliche_infos`,`turnus`,`anforderungen`) VALUES (3,'Gassigehen mit meinem Drachen',2,NULL,'7.August.2016','23:45','135 Minuten','300','Er braucht sehr viel Auslauf und wenn es möglich ist einen Freiflug',1,'Schutzkleidung, feuerfeste Handschuhe');

