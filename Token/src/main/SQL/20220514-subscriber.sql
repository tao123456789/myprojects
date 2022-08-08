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

 Date: 14/05/2022 22:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subscriber
-- ----------------------------
DROP TABLE IF EXISTS `subscriber`;
CREATE TABLE `subscriber`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subscriber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subscriber
-- ----------------------------
INSERT INTO `subscriber` VALUES (1, '1', '陆彪', '1943733546@qq.com', 0);
INSERT INTO `subscriber` VALUES (2, '1', '杨彪', '2984073395@qq.com', 0);
INSERT INTO `subscriber` VALUES (3, '1', '杨涛', '2413629661@qq.com', 1);
INSERT INTO `subscriber` VALUES (4, '1', '杨樱', 'longangoddess@qq.com', 0);
INSERT INTO `subscriber` VALUES (5, '1', '杨阔', '1933013414@qq.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
