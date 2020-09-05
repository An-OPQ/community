/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : community

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 01/09/2020 18:17:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `creatorid` bigint(20) NOT NULL,
  `commentCount` int(11) NULL DEFAULT 0,
  `viewCount` int(11) NULL DEFAULT 0,
  `likeCount` int(11) NULL DEFAULT 0,
  `tag` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_userinfo_id_fk`(`creatorid`) USING BTREE,
  CONSTRAINT `question_userinfo_id_fk` FOREIGN KEY (`creatorid`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 'springboot', '<p>springboot 安全问题，需要集成spring security</p>', 2, 0, 0, 0, 'springboot', '2020-09-01');
INSERT INTO `question` VALUES (2, 'springboot', '<p>springboot 安全问题，需要集成spring security</p>', 2, 0, 0, 0, 'springboot', '2020-09-01');
INSERT INTO `question` VALUES (3, 'springboot', '<p>springboot 安全问题，需要集成spring security</p>', 2, 0, 0, 0, 'springboot', '2020-09-01');
INSERT INTO `question` VALUES (4, 'springboot', '<p>springboot 安全问题，需要集成spring security</p>', 2, 0, 0, 0, 'springboot', '2020-09-01');

SET FOREIGN_KEY_CHECKS = 1;
