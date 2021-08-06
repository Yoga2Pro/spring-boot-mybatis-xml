DROP TABLE IF EXISTS WORKER_NODE;
CREATE TABLE WORKER_NODE
(
ID BIGINT NOT NULL AUTO_INCREMENT,
HOST_NAME VARCHAR(64) NOT NULL,
PORT VARCHAR(64) NOT NULL,
TYPE INT NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
LAUNCH_DATE DATE NOT NULL,
MODIFIED DATETIME NOT NULL,
CREATED DATETIME NOT NULL,
PRIMARY KEY(ID)
)COMMENT='DB WorkerID Assigner for UID Generator',ENGINE = INNODB;

DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
