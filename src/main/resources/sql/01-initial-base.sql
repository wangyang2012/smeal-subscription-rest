CREATE SCHEMA `smeal_subscription` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `smeal_subscription`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Yang');
INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Smeal');
INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Test');

