CREATE TABLE `users` (
  `id` integer PRIMARY KEY,
  `username` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `age` integer,
  `role` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp,
  `is_deleted` tinyint
);

CREATE TABLE `categories` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `parent_id` integer,
  `created_at` timestamp
);

CREATE TABLE `products` (
  `id` integer PRIMARY KEY,
  `category_id` integer NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(10,2) NOT NULL,
  `stock_quantity` integer DEFAULT 0,
  `is_active` tinyint DEFAULT true,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp,
  `is_deleted` tinyint
);

CREATE TABLE `orders` (
  `id` integer PRIMARY KEY,
  `user_id` integer NOT NULL,
  `shipping_address_id` integer,
  `status` varchar(255),
  `total_amount` decimal,
  `created_at` timestamp
);

CREATE TABLE `order_products` (
  `id` integer PRIMARY KEY,
  `order_id` integer NOT NULL,
  `product_id` integer NOT NULL,
  `quantity` integer NOT NULL DEFAULT 1,
  `unit_price` decimal(10,2) NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `tables` (
  `id` integer PRIMARY KEY,
  `restaurant_id` integer NOT NULL,
  `table_number` varchar(50) NOT NULL,
  `capacity` integer NOT NULL,
  `location` varchar(255),
  `is_active` tinyint DEFAULT 1,
  `created_at` timestamp
);

CREATE TABLE `reservations` (
  `id` integer PRIMARY KEY,
  `user_id` integer NOT NULL,
  `table_id` integer NOT NULL,
  `reservation_date` timestamp NOT NULL,
  `guest_count` integer NOT NULL,
  `status` varchar(255) DEFAULT 'pending',
  `special_requests` text,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `restaurants` (
  `id` integer PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `description` text,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255),
  `is_active` tinyint DEFAULT 1,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `restaurant_users` (
  `id` integer PRIMARY KEY,
  `restaurant_id` integer NOT NULL,
  `user_id` integer NOT NULL,
  `customer` varchar(255) NOT NULL,
  `created_at` timestamp
);

ALTER TABLE `order_products` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_products` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `tables` ADD FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`);

ALTER TABLE `restaurant_users` ADD FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`);

ALTER TABLE `restaurant_users` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `reservations` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `reservations` ADD FOREIGN KEY (`table_id`) REFERENCES `tables` (`id`);
