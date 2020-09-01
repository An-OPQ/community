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

 Date: 01/09/2020 18:20:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `accountName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sginName` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `qq` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `WeChat` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mobile` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `github` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `microblog` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_accountName_uindex`(`accountName`) USING BTREE,
  UNIQUE INDEX `user_email_uindex`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (2, '1503021658@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '夏雨', '98327b77-de02-44ca-b82a-baa83bf6ae75', '男', '5075e1fc-85bb-42d0-8721-e792d26d4ca8.jpeg', '船到桥头自然直', '1503021658', 'weixin', '10010', 'github', 'weibo');
INSERT INTO `userinfo` VALUES (3, 'test', 'test', 'test', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (4, 'test1', 'test11', 'test1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (5, 'test2', 'test2', 'test2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (6, 'test3', 'test3', 'test3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (7, 'test4', 'test4', 'test4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
