CREATE SCHEMA `smeal_subscription` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `smeal_subscription`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Yang');
INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Smeal');
INSERT INTO `smeal_subscription`.`user` (`name`) VALUES ('Test');


CREATE TABLE `prestashop_test`.`sub_card_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT(10) UNSIGNED NOT NULL,
  `card_token` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_card_customer_idx` (`customer_id` ASC),
  CONSTRAINT `fk_card_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `prestashop_test`.`ps_customer` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
