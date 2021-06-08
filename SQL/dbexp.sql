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

 Date: 28/05/2021 23:13:10
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('Edward', 1, '1818181818', 'root');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `goodId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodAttributes` int NOT NULL,
  `saleDate` datetime NULL DEFAULT NULL,
  `saleStatus` bit(1) NOT NULL DEFAULT b'0',
  `originPrice` double(10, 0) NOT NULL DEFAULT 0,
  `isSale` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`goodId`) USING BTREE,
  INDEX `goodAttributes`(`goodAttributes`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodAttributes` int NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`goodAttributes`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, NULL, 0);
INSERT INTO `goods` VALUES (2, NULL, 0);
INSERT INTO `goods` VALUES (3, NULL, 0);
INSERT INTO `goods` VALUES (10, NULL, 0);

-- ----------------------------
-- Table structure for logger
-- ----------------------------
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `userId`('userId') USING BTREE,
  INDEX `goodId`(`goodId`) USING BTREE,
  CONSTRAINT `logger_ibfk_1` FOREIGN KEY (`goodId`) REFERENCES `good` (`goodId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logger
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `vipStatus` int NULL DEFAULT 0,
  `balance` double NOT NULL DEFAULT 0,
  `phoneNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `gender` int NULL DEFAULT 0
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hwk', 2, 10000, '110110110110', 1);
INSERT INTO `user` VALUES ('100', 'yr最帅', 5, 0, '110000000000', 0);
INSERT INTO `user` VALUES ('2', 'zc最帅', 5, 1000, '110', 0);
INSERT INTO `user` VALUES ('3', 'lxx最帅', 5, 10000, '10010010110', 1);

SET FOREIGN_KEY_CHECKS = 1;
