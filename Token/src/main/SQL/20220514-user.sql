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

 Date: 14/05/2022 22:02:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
INSERT INTO `user` VALUES (1, 'root', '123456', 'root', '120.227.17.221', 'CHINA', 'chrome', 'others', '2022-5-14 21:58:6');
INSERT INTO `user` VALUES (2, 'yang', '123456', '杨涛', '120.227.17.221', 'CHINA', 'chrome', 'others', '2022-5-14 21:6:2');
INSERT INTO `user` VALUES (3, 'yangb', 'yangb', '杨彪', '120.227.17.221', 'CHINA', 'chrome', 'others', '2022-5-14 21:31:28');
INSERT INTO `user` VALUES (4, 'lub', 'lub', '陆彪', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'yangk', 'yangk', '杨阔', '120.227.17.221', 'CHINA', 'chrome', 'others', '2022-5-14 21:32:21');
INSERT INTO `user` VALUES (6, 'yangy', 'yangy', '杨樱', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 'yanggy', 'yanggy', '杨国跃', '120.227.17.221', 'CHINA', 'chrome', 'others', '2022-5-14 21:31:18');
INSERT INTO `user` VALUES (8, 'liudm', 'liudm', '刘冬梅', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
