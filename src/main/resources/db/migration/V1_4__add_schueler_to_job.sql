/* 
 * Schuelerprojekt: Taschengeldboerse
 * Sybit GmbH - www.sybit.de -  Apache License, Version 2.0
 * https://github.com/Sybit-Education/schuelerprogrammierwoche-201
 */
/**
 * Referenz des SChülers im Job.
 */
ALTER TABLE `jobs` 
ADD COLUMN `schueler` INT(11) NULL DEFAULT NULL AFTER `anbieter`;
