DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(5) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `index_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
