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

 Date: 14/05/2022 22:03:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_module
-- ----------------------------
DROP TABLE IF EXISTS `user_module`;
CREATE TABLE `user_module`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `moduleid` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_module
-- ----------------------------
INSERT INTO `user_module` VALUES (1, 1, 1);
INSERT INTO `user_module` VALUES (2, 1, 2);
INSERT INTO `user_module` VALUES (3, 1, 3);
INSERT INTO `user_module` VALUES (4, 1, 4);
INSERT INTO `user_module` VALUES (5, 1, 5);
INSERT INTO `user_module` VALUES (6, 2, 2);
INSERT INTO `user_module` VALUES (7, 2, 3);
INSERT INTO `user_module` VALUES (8, 2, 4);
INSERT INTO `user_module` VALUES (9, 2, 5);
INSERT INTO `user_module` VALUES (10, 3, 2);
INSERT INTO `user_module` VALUES (11, 3, 3);
INSERT INTO `user_module` VALUES (12, 3, 4);
INSERT INTO `user_module` VALUES (13, 3, 5);
INSERT INTO `user_module` VALUES (14, 4, 2);
INSERT INTO `user_module` VALUES (15, 4, 3);
INSERT INTO `user_module` VALUES (16, 4, 4);
INSERT INTO `user_module` VALUES (17, 4, 5);
INSERT INTO `user_module` VALUES (18, 5, 1);
INSERT INTO `user_module` VALUES (19, 5, 2);
INSERT INTO `user_module` VALUES (20, 5, 3);
INSERT INTO `user_module` VALUES (21, 5, 4);
INSERT INTO `user_module` VALUES (22, 5, 5);
INSERT INTO `user_module` VALUES (23, 6, 1);
INSERT INTO `user_module` VALUES (24, 6, 2);
INSERT INTO `user_module` VALUES (25, 6, 3);
INSERT INTO `user_module` VALUES (26, 6, 4);
INSERT INTO `user_module` VALUES (27, 6, 5);
INSERT INTO `user_module` VALUES (28, 7, 1);
INSERT INTO `user_module` VALUES (29, 7, 2);
INSERT INTO `user_module` VALUES (30, 7, 3);
INSERT INTO `user_module` VALUES (31, 7, 4);
INSERT INTO `user_module` VALUES (32, 7, 5);
INSERT INTO `user_module` VALUES (33, 8, 1);
INSERT INTO `user_module` VALUES (34, 8, 2);
INSERT INTO `user_module` VALUES (35, 8, 3);
INSERT INTO `user_module` VALUES (36, 8, 4);
INSERT INTO `user_module` VALUES (37, 8, 5);

SET FOREIGN_KEY_CHECKS = 1;
