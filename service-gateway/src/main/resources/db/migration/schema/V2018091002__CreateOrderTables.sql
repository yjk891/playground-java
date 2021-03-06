CREATE TABLE `Order` (
  -- primary key
  `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,

  -- FK columns
  `user_id`    BIGINT UNSIGNED NOT NULL,

  INDEX `idx_Order_userId` (`user_id`),

  CONSTRAINT `fk_Order_userId`
  FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  -- common
  `version`    BIGINT UNSIGNED DEFAULT '0'        NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `deleted_at` datetime,
  `locked`     VARCHAR(4)                         NOT NULL,
  INDEX `idx_Order_createdAt` (`created_at`),
  INDEX `idx_Order_deletedAt` (`deleted_at`),
  INDEX `idx_Order_locked` (`locked`),

  -- columns
  `state`             VARCHAR(30)          NOT NULL,
  INDEX `idx_Order_state` (`state`),

  `amount`            BIGINT UNSIGNED      NOT NULL,

  `shipping_country`  VARCHAR(50)          NOT NULL,
  `shipping_city`     VARCHAR(50)          NOT NULL,
  `shipping_zipcode`  VARCHAR(20)          NOT NULL,
  `shipping_address1` VARCHAR(255)         NOT NULL,
  `shipping_address2` VARCHAR(255)         NOT NULL,
  `shipping_message`  TEXT                 NOT NULL,

  `orderer_name`      VARCHAR(50)          NOT NULL,
  `orderer_phone`     VARCHAR(50)          NOT NULL,
  `orderer_email`     VARCHAR(50)          NOT NULL,
  `recipient_name`    VARCHAR(50)          NOT NULL,
  `recipient_phone`   VARCHAR(50)          NOT NULL,
  `recipient_email`   VARCHAR(50)          NOT NULL
);

CREATE TABLE OrderLine (
  -- primary key
  `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,

  -- FK columns
  `order_id`          BIGINT UNSIGNED NOT NULL,
  `product_id`        BIGINT UNSIGNED NOT NULL,
  `product_option_id` BIGINT UNSIGNED NOT NULL,

  INDEX `idx_OrderLine_orderId` (`order_id`),
  INDEX `idx_OrderLine_productId` (`product_id`),

  CONSTRAINT `fk_OrderLine_orderId`
  FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  CONSTRAINT `fk_OrderLine_productId`
  FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  -- common
  `version`    BIGINT UNSIGNED DEFAULT '0'        NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `deleted_at` datetime,
  `locked`     VARCHAR(4)                         NOT NULL,
  INDEX `idx_OrderLine_createdAt` (`created_at`),
  INDEX `idx_OrderLine_deletedAt` (`deleted_at`),
  INDEX `idx_OrderLine_locked` (`locked`),

  -- columns
  `state`             VARCHAR(30)          NOT NULL,
  INDEX `idx_OrderLine_state` (`state`),

  `price`             BIGINT UNSIGNED NOT NULL,
  `quantity`          BIGINT UNSIGNED NOT NULL,
  `index`             BIGINT UNSIGNED NOT NULL
);

CREATE TABLE `OrderLineOption` (
  -- primary key
  `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,

  -- FK columns
  `order_line_id`         BIGINT UNSIGNED NOT NULL,
  `product_option_id`    BIGINT UNSIGNED NOT NULL,

  INDEX `idx_OrderLineOption_orderLineId` (`order_line_id`),
  INDEX `idx_OrderLineOption_productOptionId` (`product_option_id`),

  CONSTRAINT `fk_OrderLineOption_orderLineId`
  FOREIGN KEY (`order_line_id`) REFERENCES `OrderLine` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  CONSTRAINT `fk_OrderLineOption_productOptionId`
  FOREIGN KEY (`product_option_id`) REFERENCES `ProductOption` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,

  -- common
  `version`    BIGINT UNSIGNED DEFAULT '0'        NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `deleted_at` datetime,
  `locked`     VARCHAR(4)                         NOT NULL,
  INDEX `idx_OrderLineOption_createdAt` (`created_at`),
  INDEX `idx_OrderLineOption_deletedAt` (`deleted_at`),
  INDEX `idx_OrderLineOption_locked` (`locked`),

  -- columns
  `price`             BIGINT UNSIGNED NOT NULL,
  `quantity`          BIGINT UNSIGNED NOT NULL
);

