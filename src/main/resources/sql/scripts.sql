CREATE TABLE testdb.authorities (
	`id` int NOT NULL AUTO_INCREMENT,
    `user_id` bigint NOT NULL,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY(`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO testdb.authorities (`user_id`, `name`)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO testdb.authorities (`user_id`, `name`)
VALUES (1, 'ROLE_USER');