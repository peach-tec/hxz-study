/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.109-mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.0.109:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/03/2022 21:51:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `did` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (1, '测试部');
INSERT INTO `t_dept` VALUES (2, '开发部');
INSERT INTO `t_dept` VALUES (3, '行政部');
INSERT INTO `t_dept` VALUES (4, '财务部');

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `emp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `did` int NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES (4, 'test004', 44, '女', '1111@qq.com', 2);
INSERT INTO `t_emp` VALUES (5, 'test005', 55, '女', '1111@qq.com', 3);
INSERT INTO `t_emp` VALUES (6, 'test0', 10, '男', '14587@qq0', 0);
INSERT INTO `t_emp` VALUES (7, 'test1', 11, '女', '14587@qq1', 1);
INSERT INTO `t_emp` VALUES (8, 'test2', 12, '男', '14587@qq2', 2);
INSERT INTO `t_emp` VALUES (9, 'test3', 13, '女', '14587@qq3', 3);
INSERT INTO `t_emp` VALUES (10, 'test4', 14, '男', '14587@qq4', 4);
INSERT INTO `t_emp` VALUES (11, 'test5', 15, '女', '14587@qq5', 5);
INSERT INTO `t_emp` VALUES (12, 'test6', 16, '男', '14587@qq6', 6);
INSERT INTO `t_emp` VALUES (13, 'test7', 17, '女', '14587@qq7', 7);
INSERT INTO `t_emp` VALUES (14, 'test8', 18, '男', '14587@qq8', 8);
INSERT INTO `t_emp` VALUES (15, 'test9', 19, '女', '14587@qq9', 9);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 205 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (10, 'test7', '1234567', 7, '女', '52367qq.com');
INSERT INTO `t_user` VALUES (11, 'test8', '1234568', 8, '男', '52368qq.com');
INSERT INTO `t_user` VALUES (12, 'test9', '1234569', 9, '女', '52369qq.com');
INSERT INTO `t_user` VALUES (13, 'test10', '12345610', 10, '男', '523610qq.com');
INSERT INTO `t_user` VALUES (14, 'test11', '12345611', 11, '女', '523611qq.com');
INSERT INTO `t_user` VALUES (15, 'test12', '12345612', 12, '男', '523612qq.com');
INSERT INTO `t_user` VALUES (16, 'test13', '12345613', 13, '女', '523613qq.com');
INSERT INTO `t_user` VALUES (17, 'test14', '12345614', 14, '男', '523614qq.com');
INSERT INTO `t_user` VALUES (18, 'test15', '12345615', 15, '女', '523615qq.com');
INSERT INTO `t_user` VALUES (19, 'test16', '12345616', 16, '男', '523616qq.com');
INSERT INTO `t_user` VALUES (20, 'test17', '12345617', 17, '女', '523617qq.com');
INSERT INTO `t_user` VALUES (21, 'test18', '12345618', 18, '男', '523618qq.com');
INSERT INTO `t_user` VALUES (22, 'test19', '12345619', 19, '女', '523619qq.com');
INSERT INTO `t_user` VALUES (23, 'test20', '12345620', 20, '男', '523620qq.com');
INSERT INTO `t_user` VALUES (24, 'test21', '12345621', 21, '女', '523621qq.com');
INSERT INTO `t_user` VALUES (25, 'test22', '12345622', 22, '男', '523622qq.com');
INSERT INTO `t_user` VALUES (26, 'test23', '12345623', 23, '女', '523623qq.com');
INSERT INTO `t_user` VALUES (27, 'test24', '12345624', 24, '男', '523624qq.com');
INSERT INTO `t_user` VALUES (28, 'test25', '12345625', 25, '女', '523625qq.com');
INSERT INTO `t_user` VALUES (29, 'test26', '12345626', 26, '男', '523626qq.com');
INSERT INTO `t_user` VALUES (30, 'test27', '12345627', 27, '女', '523627qq.com');
INSERT INTO `t_user` VALUES (31, 'test28', '12345628', 28, '男', '523628qq.com');
INSERT INTO `t_user` VALUES (32, 'test29', '12345629', 29, '女', '523629qq.com');
INSERT INTO `t_user` VALUES (33, 'test30', '12345630', 30, '男', '523630qq.com');
INSERT INTO `t_user` VALUES (34, 'test31', '12345631', 31, '女', '523631qq.com');
INSERT INTO `t_user` VALUES (35, 'test32', '12345632', 32, '男', '523632qq.com');
INSERT INTO `t_user` VALUES (36, 'test33', '12345633', 33, '女', '523633qq.com');
INSERT INTO `t_user` VALUES (37, 'test34', '12345634', 34, '男', '523634qq.com');
INSERT INTO `t_user` VALUES (38, 'test35', '12345635', 35, '女', '523635qq.com');
INSERT INTO `t_user` VALUES (39, 'test36', '12345636', 36, '男', '523636qq.com');
INSERT INTO `t_user` VALUES (40, 'test37', '12345637', 37, '女', '523637qq.com');
INSERT INTO `t_user` VALUES (41, 'test38', '12345638', 38, '男', '523638qq.com');
INSERT INTO `t_user` VALUES (42, 'test39', '12345639', 39, '女', '523639qq.com');
INSERT INTO `t_user` VALUES (43, 'test40', '12345640', 40, '男', '523640qq.com');
INSERT INTO `t_user` VALUES (44, 'test41', '12345641', 41, '女', '523641qq.com');
INSERT INTO `t_user` VALUES (45, 'test42', '12345642', 42, '男', '523642qq.com');
INSERT INTO `t_user` VALUES (46, 'test43', '12345643', 43, '女', '523643qq.com');
INSERT INTO `t_user` VALUES (47, 'test44', '12345644', 44, '男', '523644qq.com');
INSERT INTO `t_user` VALUES (48, 'test45', '12345645', 45, '女', '523645qq.com');
INSERT INTO `t_user` VALUES (49, 'test46', '12345646', 46, '男', '523646qq.com');
INSERT INTO `t_user` VALUES (50, 'test47', '12345647', 47, '女', '523647qq.com');
INSERT INTO `t_user` VALUES (51, 'test48', '12345648', 48, '男', '523648qq.com');
INSERT INTO `t_user` VALUES (52, 'test49', '12345649', 49, '女', '523649qq.com');
INSERT INTO `t_user` VALUES (53, 'test50', '12345650', 50, '男', '523650qq.com');
INSERT INTO `t_user` VALUES (54, 'test51', '12345651', 51, '女', '523651qq.com');
INSERT INTO `t_user` VALUES (55, 'test52', '12345652', 52, '男', '523652qq.com');
INSERT INTO `t_user` VALUES (56, 'test53', '12345653', 53, '女', '523653qq.com');
INSERT INTO `t_user` VALUES (57, 'test54', '12345654', 54, '男', '523654qq.com');
INSERT INTO `t_user` VALUES (58, 'test55', '12345655', 55, '女', '523655qq.com');
INSERT INTO `t_user` VALUES (59, 'test56', '12345656', 56, '男', '523656qq.com');
INSERT INTO `t_user` VALUES (60, 'test57', '12345657', 57, '女', '523657qq.com');
INSERT INTO `t_user` VALUES (61, 'test58', '12345658', 58, '男', '523658qq.com');
INSERT INTO `t_user` VALUES (62, 'test59', '12345659', 59, '女', '523659qq.com');
INSERT INTO `t_user` VALUES (63, 'test60', '12345660', 60, '男', '523660qq.com');
INSERT INTO `t_user` VALUES (64, 'test61', '12345661', 61, '女', '523661qq.com');
INSERT INTO `t_user` VALUES (65, 'test62', '12345662', 62, '男', '523662qq.com');
INSERT INTO `t_user` VALUES (66, 'test63', '12345663', 63, '女', '523663qq.com');
INSERT INTO `t_user` VALUES (67, 'test64', '12345664', 64, '男', '523664qq.com');
INSERT INTO `t_user` VALUES (68, 'test65', '12345665', 65, '女', '523665qq.com');
INSERT INTO `t_user` VALUES (69, 'test66', '12345666', 66, '男', '523666qq.com');
INSERT INTO `t_user` VALUES (70, 'test67', '12345667', 67, '女', '523667qq.com');
INSERT INTO `t_user` VALUES (71, 'test68', '12345668', 68, '男', '523668qq.com');
INSERT INTO `t_user` VALUES (72, 'test69', '12345669', 69, '女', '523669qq.com');
INSERT INTO `t_user` VALUES (73, 'test70', '12345670', 70, '男', '523670qq.com');
INSERT INTO `t_user` VALUES (74, 'test71', '12345671', 71, '女', '523671qq.com');
INSERT INTO `t_user` VALUES (75, 'test72', '12345672', 72, '男', '523672qq.com');
INSERT INTO `t_user` VALUES (76, 'test73', '12345673', 73, '女', '523673qq.com');
INSERT INTO `t_user` VALUES (77, 'test74', '12345674', 74, '男', '523674qq.com');
INSERT INTO `t_user` VALUES (78, 'test75', '12345675', 75, '女', '523675qq.com');
INSERT INTO `t_user` VALUES (79, 'test76', '12345676', 76, '男', '523676qq.com');
INSERT INTO `t_user` VALUES (80, 'test77', '12345677', 77, '女', '523677qq.com');
INSERT INTO `t_user` VALUES (81, 'test78', '12345678', 78, '男', '523678qq.com');
INSERT INTO `t_user` VALUES (82, 'test79', '12345679', 79, '女', '523679qq.com');
INSERT INTO `t_user` VALUES (83, 'test80', '12345680', 80, '男', '523680qq.com');
INSERT INTO `t_user` VALUES (84, 'test81', '12345681', 81, '女', '523681qq.com');
INSERT INTO `t_user` VALUES (85, 'test82', '12345682', 82, '男', '523682qq.com');
INSERT INTO `t_user` VALUES (86, 'test83', '12345683', 83, '女', '523683qq.com');
INSERT INTO `t_user` VALUES (87, 'test84', '12345684', 84, '男', '523684qq.com');
INSERT INTO `t_user` VALUES (88, 'test85', '12345685', 85, '女', '523685qq.com');
INSERT INTO `t_user` VALUES (89, 'test86', '12345686', 86, '男', '523686qq.com');
INSERT INTO `t_user` VALUES (90, 'test87', '12345687', 87, '女', '523687qq.com');
INSERT INTO `t_user` VALUES (91, 'test88', '12345688', 88, '男', '523688qq.com');
INSERT INTO `t_user` VALUES (92, 'test89', '12345689', 89, '女', '523689qq.com');
INSERT INTO `t_user` VALUES (93, 'test90', '12345690', 90, '男', '523690qq.com');
INSERT INTO `t_user` VALUES (94, 'test91', '12345691', 91, '女', '523691qq.com');
INSERT INTO `t_user` VALUES (95, 'test92', '12345692', 92, '男', '523692qq.com');
INSERT INTO `t_user` VALUES (96, 'test93', '12345693', 93, '女', '523693qq.com');
INSERT INTO `t_user` VALUES (97, 'test94', '12345694', 94, '男', '523694qq.com');
INSERT INTO `t_user` VALUES (98, 'test95', '12345695', 95, '女', '523695qq.com');
INSERT INTO `t_user` VALUES (99, 'test96', '12345696', 96, '男', '523696qq.com');
INSERT INTO `t_user` VALUES (100, 'test97', '12345697', 97, '女', '523697qq.com');
INSERT INTO `t_user` VALUES (101, 'test98', '12345698', 98, '男', '523698qq.com');
INSERT INTO `t_user` VALUES (102, 'test99', '12345699', 99, '女', '523699qq.com');
INSERT INTO `t_user` VALUES (103, 'test100', '123456100', 100, '男', '5236100qq.com');
INSERT INTO `t_user` VALUES (110, 'test7', '1234567', 7, '女', '52367qq.com');
INSERT INTO `t_user` VALUES (111, 'test8', '1234568', 8, '男', '52368qq.com');
INSERT INTO `t_user` VALUES (112, 'test9', '1234569', 9, '女', '52369qq.com');
INSERT INTO `t_user` VALUES (113, 'test10', '12345610', 10, '男', '523610qq.com');
INSERT INTO `t_user` VALUES (114, 'test11', '12345611', 11, '女', '523611qq.com');
INSERT INTO `t_user` VALUES (115, 'test12', '12345612', 12, '男', '523612qq.com');
INSERT INTO `t_user` VALUES (116, 'test13', '12345613', 13, '女', '523613qq.com');
INSERT INTO `t_user` VALUES (117, 'test14', '12345614', 14, '男', '523614qq.com');
INSERT INTO `t_user` VALUES (118, 'test15', '12345615', 15, '女', '523615qq.com');
INSERT INTO `t_user` VALUES (119, 'test16', '12345616', 16, '男', '523616qq.com');
INSERT INTO `t_user` VALUES (120, 'test17', '12345617', 17, '女', '523617qq.com');
INSERT INTO `t_user` VALUES (121, 'test18', '12345618', 18, '男', '523618qq.com');
INSERT INTO `t_user` VALUES (122, 'test19', '12345619', 19, '女', '523619qq.com');
INSERT INTO `t_user` VALUES (123, 'test20', '12345620', 20, '男', '523620qq.com');
INSERT INTO `t_user` VALUES (124, 'test21', '12345621', 21, '女', '523621qq.com');
INSERT INTO `t_user` VALUES (125, 'test22', '12345622', 22, '男', '523622qq.com');
INSERT INTO `t_user` VALUES (126, 'test23', '12345623', 23, '女', '523623qq.com');
INSERT INTO `t_user` VALUES (127, 'test24', '12345624', 24, '男', '523624qq.com');
INSERT INTO `t_user` VALUES (128, 'test25', '12345625', 25, '女', '523625qq.com');
INSERT INTO `t_user` VALUES (129, 'test26', '12345626', 26, '男', '523626qq.com');
INSERT INTO `t_user` VALUES (130, 'test27', '12345627', 27, '女', '523627qq.com');
INSERT INTO `t_user` VALUES (131, 'test28', '12345628', 28, '男', '523628qq.com');
INSERT INTO `t_user` VALUES (132, 'test29', '12345629', 29, '女', '523629qq.com');
INSERT INTO `t_user` VALUES (133, 'test30', '12345630', 30, '男', '523630qq.com');
INSERT INTO `t_user` VALUES (134, 'test31', '12345631', 31, '女', '523631qq.com');
INSERT INTO `t_user` VALUES (135, 'test32', '12345632', 32, '男', '523632qq.com');
INSERT INTO `t_user` VALUES (136, 'test33', '12345633', 33, '女', '523633qq.com');
INSERT INTO `t_user` VALUES (137, 'test34', '12345634', 34, '男', '523634qq.com');
INSERT INTO `t_user` VALUES (138, 'test35', '12345635', 35, '女', '523635qq.com');
INSERT INTO `t_user` VALUES (139, 'test36', '12345636', 36, '男', '523636qq.com');
INSERT INTO `t_user` VALUES (140, 'test37', '12345637', 37, '女', '523637qq.com');
INSERT INTO `t_user` VALUES (141, 'test38', '12345638', 38, '男', '523638qq.com');
INSERT INTO `t_user` VALUES (142, 'test39', '12345639', 39, '女', '523639qq.com');
INSERT INTO `t_user` VALUES (143, 'test40', '12345640', 40, '男', '523640qq.com');
INSERT INTO `t_user` VALUES (144, 'test41', '12345641', 41, '女', '523641qq.com');
INSERT INTO `t_user` VALUES (145, 'test42', '12345642', 42, '男', '523642qq.com');
INSERT INTO `t_user` VALUES (146, 'test43', '12345643', 43, '女', '523643qq.com');
INSERT INTO `t_user` VALUES (147, 'test44', '12345644', 44, '男', '523644qq.com');
INSERT INTO `t_user` VALUES (148, 'test45', '12345645', 45, '女', '523645qq.com');
INSERT INTO `t_user` VALUES (149, 'test46', '12345646', 46, '男', '523646qq.com');
INSERT INTO `t_user` VALUES (150, 'test47', '12345647', 47, '女', '523647qq.com');
INSERT INTO `t_user` VALUES (151, 'test48', '12345648', 48, '男', '523648qq.com');
INSERT INTO `t_user` VALUES (152, 'test49', '12345649', 49, '女', '523649qq.com');
INSERT INTO `t_user` VALUES (153, 'test50', '12345650', 50, '男', '523650qq.com');
INSERT INTO `t_user` VALUES (154, 'test51', '12345651', 51, '女', '523651qq.com');
INSERT INTO `t_user` VALUES (155, 'test52', '12345652', 52, '男', '523652qq.com');
INSERT INTO `t_user` VALUES (156, 'test53', '12345653', 53, '女', '523653qq.com');
INSERT INTO `t_user` VALUES (157, 'test54', '12345654', 54, '男', '523654qq.com');
INSERT INTO `t_user` VALUES (158, 'test55', '12345655', 55, '女', '523655qq.com');
INSERT INTO `t_user` VALUES (159, 'test56', '12345656', 56, '男', '523656qq.com');
INSERT INTO `t_user` VALUES (160, 'test57', '12345657', 57, '女', '523657qq.com');
INSERT INTO `t_user` VALUES (161, 'test58', '12345658', 58, '男', '523658qq.com');
INSERT INTO `t_user` VALUES (162, 'test59', '12345659', 59, '女', '523659qq.com');
INSERT INTO `t_user` VALUES (163, 'test60', '12345660', 60, '男', '523660qq.com');
INSERT INTO `t_user` VALUES (164, 'test61', '12345661', 61, '女', '523661qq.com');
INSERT INTO `t_user` VALUES (165, 'test62', '12345662', 62, '男', '523662qq.com');
INSERT INTO `t_user` VALUES (166, 'test63', '12345663', 63, '女', '523663qq.com');
INSERT INTO `t_user` VALUES (167, 'test64', '12345664', 64, '男', '523664qq.com');
INSERT INTO `t_user` VALUES (168, 'test65', '12345665', 65, '女', '523665qq.com');
INSERT INTO `t_user` VALUES (169, 'test66', '12345666', 66, '男', '523666qq.com');
INSERT INTO `t_user` VALUES (170, 'test67', '12345667', 67, '女', '523667qq.com');
INSERT INTO `t_user` VALUES (171, 'test68', '12345668', 68, '男', '523668qq.com');
INSERT INTO `t_user` VALUES (172, 'test69', '12345669', 69, '女', '523669qq.com');
INSERT INTO `t_user` VALUES (173, 'test70', '12345670', 70, '男', '523670qq.com');
INSERT INTO `t_user` VALUES (174, 'test71', '12345671', 71, '女', '523671qq.com');
INSERT INTO `t_user` VALUES (175, 'test72', '12345672', 72, '男', '523672qq.com');
INSERT INTO `t_user` VALUES (176, 'test73', '12345673', 73, '女', '523673qq.com');
INSERT INTO `t_user` VALUES (177, 'test74', '12345674', 74, '男', '523674qq.com');
INSERT INTO `t_user` VALUES (178, 'test75', '12345675', 75, '女', '523675qq.com');
INSERT INTO `t_user` VALUES (179, 'test76', '12345676', 76, '男', '523676qq.com');
INSERT INTO `t_user` VALUES (180, 'test77', '12345677', 77, '女', '523677qq.com');
INSERT INTO `t_user` VALUES (181, 'test78', '12345678', 78, '男', '523678qq.com');
INSERT INTO `t_user` VALUES (182, 'test79', '12345679', 79, '女', '523679qq.com');
INSERT INTO `t_user` VALUES (183, 'test80', '12345680', 80, '男', '523680qq.com');
INSERT INTO `t_user` VALUES (184, 'test81', '12345681', 81, '女', '523681qq.com');
INSERT INTO `t_user` VALUES (185, 'test82', '12345682', 82, '男', '523682qq.com');
INSERT INTO `t_user` VALUES (186, 'test83', '12345683', 83, '女', '523683qq.com');
INSERT INTO `t_user` VALUES (187, 'test84', '12345684', 84, '男', '523684qq.com');
INSERT INTO `t_user` VALUES (188, 'test85', '12345685', 85, '女', '523685qq.com');
INSERT INTO `t_user` VALUES (189, 'test86', '12345686', 86, '男', '523686qq.com');
INSERT INTO `t_user` VALUES (190, 'test87', '12345687', 87, '女', '523687qq.com');
INSERT INTO `t_user` VALUES (191, 'test88', '12345688', 88, '男', '523688qq.com');
INSERT INTO `t_user` VALUES (192, 'test89', '12345689', 89, '女', '523689qq.com');
INSERT INTO `t_user` VALUES (193, 'test90', '12345690', 90, '男', '523690qq.com');
INSERT INTO `t_user` VALUES (194, 'test91', '12345691', 91, '女', '523691qq.com');
INSERT INTO `t_user` VALUES (195, 'test92', '12345692', 92, '男', '523692qq.com');
INSERT INTO `t_user` VALUES (196, 'test93', '12345693', 93, '女', '523693qq.com');
INSERT INTO `t_user` VALUES (197, 'test94', '12345694', 94, '男', '523694qq.com');
INSERT INTO `t_user` VALUES (198, 'test95', '12345695', 95, '女', '523695qq.com');
INSERT INTO `t_user` VALUES (199, 'test96', '12345696', 96, '男', '523696qq.com');
INSERT INTO `t_user` VALUES (200, 'test97', '12345697', 97, '女', '523697qq.com');
INSERT INTO `t_user` VALUES (201, 'test98', '12345698', 98, '男', '523698qq.com');
INSERT INTO `t_user` VALUES (202, 'test99', '12345699', 99, '女', '523699qq.com');
INSERT INTO `t_user` VALUES (203, 'test100', '123456100', 100, '男', '5236100qq.com');
INSERT INTO `t_user` VALUES (204, 'HXZ', '123456', 28, '男', '184821@qq.com');
INSERT INTO `t_user` VALUES (205, 'HXZ1', '123456', 28, '男', '184821@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
