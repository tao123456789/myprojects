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

 Date: 24/07/2021 14:46:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `action_id` int NOT NULL,
                           `action_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO `action` VALUES (1, 5001, '查看');
INSERT INTO `action` VALUES (2, 5002, '修改');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `group_id` int NOT NULL,
                          `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, 1001, '超级管理员');
INSERT INTO `group` VALUES (2, 1002, '管理员');
INSERT INTO `group` VALUES (3, 1003, '一般用户');

-- ----------------------------
-- Table structure for group_action
-- ----------------------------
DROP TABLE IF EXISTS `group_action`;
CREATE TABLE `group_action`  (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `group_id` int NOT NULL,
                                 `action_id` int NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_action
-- ----------------------------
INSERT INTO `group_action` VALUES (1, 1001, 50001);
INSERT INTO `group_action` VALUES (2, 1001, 50002);
INSERT INTO `group_action` VALUES (3, 1002, 50001);
INSERT INTO `group_action` VALUES (4, 1002, 50002);
INSERT INTO `group_action` VALUES (5, 1003, 5001);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `ifuse` int NOT NULL DEFAULT 1,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMjMifQ.aGFldwhacqQqHt4w6ZvOXvLnWt-RvrteKTLNTleUWcQ', 1);
INSERT INTO `token` VALUES (2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0._PhkZlaMLeSuizgbFBjRvr7JDVfTMQh6GVW4i9AJ1F0', 1);
INSERT INTO `token` VALUES (3, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzIn0._kQefbca7m0v_swYQcOrF2F7SIviLD1qXXGSpWoKlrk', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `rest2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '123456', '杨涛', NULL);
INSERT INTO `user` VALUES (2, 'admin', '123456', 'admin', NULL);
INSERT INTO `user` VALUES (3, 'yangt52', 'PZGBSJ@2021a', '杨涛', NULL);

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `user_id` int NOT NULL,
                               `group_id` int NOT NULL,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (1, 1, 1001);
INSERT INTO `user_group` VALUES (2, 2, 1002);
INSERT INTO `user_group` VALUES (3, 3, 1003);

SET FOREIGN_KEY_CHECKS = 1;
