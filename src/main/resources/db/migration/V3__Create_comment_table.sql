CREATE TABLE `community`.`comment`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `creatorId` bigint(11) NOT NULL,
  `questionId` bigint(11) NOT NULL,
  `commentDescription` text NULL,
  `commentDate` varchar(11) NULL,
  `likeCount` varchar(11) NULL,
  `commentCount` varchar(11) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `1` FOREIGN KEY (`creatorId`) REFERENCES `community`.`userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `2` FOREIGN KEY (`questionId`) REFERENCES `community`.`question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
);