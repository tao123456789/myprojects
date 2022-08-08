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

 Date: 14/05/2022 22:02:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `module_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES (1, '个人应用系统', '/MyTools', 'img3.jpg', '用于个人应用开发，包括常用的地址记录，个人的网盘的功能等');
INSERT INTO `module` VALUES (2, '物料管理系统', '/MMS', 'img2.png', '对物料信息进行管理的一个系统，功能暂未完全实现，慢慢做，不着急');
INSERT INTO `module` VALUES (3, '后台日志系统', '/Logger', 'img5.jpg', '用于查看所有日志的系统入口，暂未实现，目标是将该系统的日志文件都纳入管理');
INSERT INTO `module` VALUES (4, 'demo系统', '/Demo', 'img4.png', '用于记录前端的组件应用');
INSERT INTO `module` VALUES (5, '权限入口管理', '/Controller', 'img3.jpg', '权限管理');

SET FOREIGN_KEY_CHECKS = 1;
