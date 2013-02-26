CREATE TABLE `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_phone` varchar(50) DEFAULT NULL,
  `user_addr` varchar(50) DEFAULT NULL,
  `user_duty` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);