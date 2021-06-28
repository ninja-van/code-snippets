CREATE TABLE `retries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `request_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `error` longtext COLLATE utf8mb4_unicode_ci,
  `proto_request` longtext COLLATE utf8mb4_unicode_ci,
  `processed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_create_dlq_errors_processed_index` (`processed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
