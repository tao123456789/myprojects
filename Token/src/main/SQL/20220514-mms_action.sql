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

 Date: 14/05/2022 22:02:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mms_action
-- ----------------------------
DROP TABLE IF EXISTS `mms_action`;
CREATE TABLE `mms_action`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_id` int NOT NULL,
  `action_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `action_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `action_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `action_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mms_action
-- ----------------------------
INSERT INTO `mms_action` VALUES (1, 50001, '', '2', '全部物料', '/allMaterial', '50000');
INSERT INTO `mms_action` VALUES (2, 50002, '', '2', '账号管理', '/allUser', '40000');
INSERT INTO `mms_action` VALUES (3, 50003, '', '2', '测试功能', '/test', '50000');
INSERT INTO `mms_action` VALUES (4, 50000, 'el-icon-tickets', '1', '物料管理', '', NULL);
INSERT INTO `mms_action` VALUES (5, 60000, 'el-icon-setting', '1', '设置管理', NULL, NULL);
INSERT INTO `mms_action` VALUES (6, 60001, NULL, '2', '菜单设置', '/menuSetting', '60000');
INSERT INTO `mms_action` VALUES (7, 40000, 'el-icon-setting', '1', '基础管理', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
