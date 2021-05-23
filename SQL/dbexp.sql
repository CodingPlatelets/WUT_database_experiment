/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : dbexp

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 22/05/2021 15:05:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `id` int NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1234',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('Edward', 1, '1818181818', 'root');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodAttributes` int NOT NULL,
  `goodsId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stock` int NOT NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `saleDate` date NULL DEFAULT NULL,
  `saleStatus` tinyint(1) NOT NULL DEFAULT 0,
  `isReturnAvailable` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '1', 1, '123', '2021-05-21', 0, 0);
INSERT INTO `goods` VALUES (3, '1619349122', 34, 'lxx最帅了', NULL, 0, 0);
INSERT INTO `goods` VALUES (1, '2', 2, '456', '2021-05-22', 0, 0);
INSERT INTO `goods` VALUES (2, '4815698760', 123, '这是我的衣服', NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Records of user
-- ----------------------------

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                          `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                          `vipStatus` int NULL DEFAULT 0,
                          `balance` double NOT NULL DEFAULT 0,
                          `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
                          `gender` int NULL DEFAULT 0,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `user` VALUES('1','hwk最帅',1,1000.0,'11111111',1);
INSERT INTO `user` VALUES('2','zc最帅',5,1000.0,'110',0);
INSERT INTO `user` VALUES('100','yr最帅',5,0,'110000000000',0);

