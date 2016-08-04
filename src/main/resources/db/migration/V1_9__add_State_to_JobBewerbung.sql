ALTER TABLE `taschengeldboerse`.`jobbewerbung` 
ADD COLUMN `status` VARCHAR(8) NOT NULL DEFAULT 'Pending' AFTER `timestamp`;