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
