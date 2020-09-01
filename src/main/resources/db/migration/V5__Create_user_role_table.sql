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

 Date: 01/09/2020 18:21:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`urid`) USING BTREE,
  INDEX `FKejomstwulyjhor5lubdvwrrtd`(`roleid`) USING BTREE,
  CONSTRAINT `FKejomstwulyjhor5lubdvwrrtd` FOREIGN KEY (`roleid`) REFERENCES `roleinfo` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户_角色关系维护表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
