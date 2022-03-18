/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : test001

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 18/03/2022 20:26:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('0b41a913972a4e25b6a1f3abf613c788', '部门5');
INSERT INTO `dept` VALUES ('1727447132176121857', '部门0');
INSERT INTO `dept` VALUES ('1727447132478111745', '部门1');
INSERT INTO `dept` VALUES ('1727447132486500353', '部门2');
INSERT INTO `dept` VALUES ('1727447132494888961', '部门3');
INSERT INTO `dept` VALUES ('1727447132504326145', '部门4');
INSERT INTO `dept` VALUES ('1727447132511666177', '部门5');
INSERT INTO `dept` VALUES ('1727447132521103361', '部门6');
INSERT INTO `dept` VALUES ('1727447132529491969', '部门7');
INSERT INTO `dept` VALUES ('1727447132537880577', '部门8');
INSERT INTO `dept` VALUES ('1727447132548366337', '部门9');
INSERT INTO `dept` VALUES ('314cec6c778444678f3a7149dd815adc', '部门6');
INSERT INTO `dept` VALUES ('59716d65f33e4bfbaa59860ce5cad79d', '部门4');
INSERT INTO `dept` VALUES ('651ecb31ca2842ae821ae5639e713d2d', '部门1');
INSERT INTO `dept` VALUES ('9a1546fb192a441fb4f544ae97c5d3c8', '部门3');
INSERT INTO `dept` VALUES ('b24392ad8aa642a5a359a52c3275e36d', '部门0');
INSERT INTO `dept` VALUES ('d1ee4a7043c14666b3eb5b6f913366e1', '部门8');
INSERT INTO `dept` VALUES ('e12e79f40cbf452f88995fda31c24447', '部门9');
INSERT INTO `dept` VALUES ('e78cc5f61bf54a55a56f0ac3d0638dd9', '部门2');
INSERT INTO `dept` VALUES ('f7e8a6bc427f4f86a97ea40dfbb81ba0', '部门7');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '角色01');
INSERT INTO `role` VALUES (2, '角色11');
INSERT INTO `role` VALUES (3, '角色21');
INSERT INTO `role` VALUES (4, '角色31');
INSERT INTO `role` VALUES (5, '角色41');
INSERT INTO `role` VALUES (6, '角色51');
INSERT INTO `role` VALUES (7, '角色61');
INSERT INTO `role` VALUES (8, '角色71');
INSERT INTO `role` VALUES (9, '角色81');
INSERT INTO `role` VALUES (10, '角色91');
INSERT INTO `role` VALUES (11, '角色01');
INSERT INTO `role` VALUES (12, '角色11');
INSERT INTO `role` VALUES (13, '角色21');
INSERT INTO `role` VALUES (14, '角色31');
INSERT INTO `role` VALUES (15, '角色41');
INSERT INTO `role` VALUES (16, '角色51');
INSERT INTO `role` VALUES (17, '角色61');
INSERT INTO `role` VALUES (18, '角色71');
INSERT INTO `role` VALUES (19, '角色81');
INSERT INTO `role` VALUES (20, '角色91');
INSERT INTO `role` VALUES (21, '角色01');
INSERT INTO `role` VALUES (22, '角色11');
INSERT INTO `role` VALUES (23, '角色21');
INSERT INTO `role` VALUES (24, '角色31');
INSERT INTO `role` VALUES (25, '角色41');
INSERT INTO `role` VALUES (26, '角色51');
INSERT INTO `role` VALUES (27, '角色61');
INSERT INTO `role` VALUES (28, '角色71');
INSERT INTO `role` VALUES (29, '角色81');
INSERT INTO `role` VALUES (30, '角色91');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
