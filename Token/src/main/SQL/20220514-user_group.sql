/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 14/05/2022 22:03:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (1, 1, 1001);
INSERT INTO `user_group` VALUES (2, 2, 1001);
INSERT INTO `user_group` VALUES (3, 3, 1001);
INSERT INTO `user_group` VALUES (4, 3, 1001);
INSERT INTO `user_group` VALUES (5, 4, 1001);
INSERT INTO `user_group` VALUES (6, 5, 1001);
INSERT INTO `user_group` VALUES (7, 6, 1001);
INSERT INTO `user_group` VALUES (8, 7, 1001);
INSERT INTO `user_group` VALUES (9, 8, 1001);

SET FOREIGN_KEY_CHECKS = 1;
