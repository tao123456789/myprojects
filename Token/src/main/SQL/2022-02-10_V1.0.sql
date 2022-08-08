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

 Date: 10/02/2022 21:52:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action1
-- ----------------------------
DROP TABLE IF EXISTS `action1`;
CREATE TABLE `action1`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_id` int NOT NULL,
  `action_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `action_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `action_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `action_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action1
-- ----------------------------
INSERT INTO `action1` VALUES (1, 50001, 'el-icon-postcard', '2', '全部物料', '/allMaterial', '50000');
INSERT INTO `action1` VALUES (2, 50002, 'el-icon-postcard', '2', '账号管理', '/allUser', '50000');
INSERT INTO `action1` VALUES (3, 50003, 'el-icon-postcard', '2', '测试功能', '/test', '50000');
INSERT INTO `action1` VALUES (4, 50000, 'el-icon-postcard', '1', '物料管理', '', NULL);

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_action
-- ----------------------------
INSERT INTO `group_action` VALUES (1, 1001, 50001);
INSERT INTO `group_action` VALUES (2, 1001, 50002);
INSERT INTO `group_action` VALUES (3, 1002, 50001);
INSERT INTO `group_action` VALUES (4, 1002, 50002);
INSERT INTO `group_action` VALUES (5, 1003, 50001);
INSERT INTO `group_action` VALUES (6, 1001, 50003);
INSERT INTO `group_action` VALUES (7, 1001, 50000);

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `material_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `material_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material_dw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `material_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `material_gys` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gys_name_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, 'test', 'test物料 ', '11', 'PC', '111.00', '测试供应商', '张三', '12345678901', '备注');
INSERT INTO `material` VALUES (2, 'test2', 'test物料2', '22', 'PC', '222', '测试供应商2', '李四', '09876543211', '备注2');
INSERT INTO `material` VALUES (3, '10001', '电钻', '33', 'PC', '24', '海电', '王五', '08234978234', NULL);
INSERT INTO `material` VALUES (4, '10002', '缆绳', '44', '米', '33', '神绳', '老刘', '782364827', '缺货');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ifuse` int NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `os` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '123456', '杨涛', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'admin', '123456', '杨涛', '192.168.1.1', '湖南', 'Chrome', 'Windows', '2021-10-19 20:00:01');
INSERT INTO `user` VALUES (3, 'yangt52', 'PZGBSJ@2021a', '杨涛', NULL, NULL, NULL, NULL, NULL);

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

SET FOREIGN_KEY_CHECKS = 1;
