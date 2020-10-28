/*
 Navicat MySQL Data Transfer

 Source Server         : we
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : nas

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 20/10/2020 12:58:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nas_consumables
-- ----------------------------
DROP TABLE IF EXISTS `nas_consumables`;
CREATE TABLE `nas_consumables`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `con_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消耗品编号',
  `con_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消耗品名称',
  `con_number` int(255) NULL DEFAULT NULL COMMENT '消耗品数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `con_id`(`con_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_consumables
-- ----------------------------
INSERT INTO `nas_consumables` VALUES (1, '172481', '玻璃水', 48);
INSERT INTO `nas_consumables` VALUES (2, '172482', '毛巾', 150);
INSERT INTO `nas_consumables` VALUES (3, '123456', '洗手液', 82);
INSERT INTO `nas_consumables` VALUES (4, '91cd79e49e33460c9f26d40d5b803fe0', '肥皂', 100);
INSERT INTO `nas_consumables` VALUES (5, '6ef0924f584841d7ac69857900391e3d', '香皂', 740);
INSERT INTO `nas_consumables` VALUES (6, '164c2ed458704d1697201d76e49225fb', '纸巾', 100);
INSERT INTO `nas_consumables` VALUES (7, '1f528529f3064a5ebda10f816d41bd70', '肥皂1', 123);
INSERT INTO `nas_consumables` VALUES (8, 'c95950fa68df49dda12f10863dd2eaa2', '肥皂22', 123);
INSERT INTO `nas_consumables` VALUES (9, '081e2a4d5cd04225b7a3bf108d974ba7', '机油', 84);

-- ----------------------------
-- Table structure for nas_consumables_records
-- ----------------------------
DROP TABLE IF EXISTS `nas_consumables_records`;
CREATE TABLE `nas_consumables_records`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL COMMENT '消耗品id',
  `status` int(1) NULL DEFAULT NULL COMMENT '出入库标识 1 出库 0入库',
  `ware_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出入库编号',
  `ware_date` datetime(0) NULL DEFAULT NULL COMMENT '出入库时间',
  `ware_number` int(6) NULL DEFAULT NULL COMMENT '出入库数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ware_id`(`ware_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `nas_consumables_records_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `nas_consumables` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消耗品记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_consumables_records
-- ----------------------------
INSERT INTO `nas_consumables_records` VALUES (1, 1, 1, '1', '2020-10-07 19:46:57', 10);
INSERT INTO `nas_consumables_records` VALUES (2, 2, 0, '2', '2020-10-14 12:44:36', 20);
INSERT INTO `nas_consumables_records` VALUES (3, 8, 0, '3450cde0e2bd478dbc801d99415795f1', '2020-10-17 21:01:47', 11);
INSERT INTO `nas_consumables_records` VALUES (4, 9, 0, 'b6355ea10bb44ce8b1e92f448605a5fa', '2020-10-17 21:02:59', 123);
INSERT INTO `nas_consumables_records` VALUES (5, 5, 0, '113bf62749d1488087ed21a14e7ab845', '2020-10-17 21:16:01', 50);
INSERT INTO `nas_consumables_records` VALUES (6, 3, 1, '64011ca5c1c7482ba4a52e7890cd77e4', '2020-10-17 21:16:10', 18);
INSERT INTO `nas_consumables_records` VALUES (7, 9, 1, 'b3c143b8c81b43e1ac28e2bd568ff133', '2020-10-18 16:18:36', 150);
INSERT INTO `nas_consumables_records` VALUES (8, 9, 0, 'd6fe97af900e4241b9bfbf37768b7c71', '2020-10-18 16:49:34', 100);
INSERT INTO `nas_consumables_records` VALUES (9, 9, 0, '389fa8c86f354caca711bcf8bdc2e46c', '2020-10-18 19:33:57', 11);
INSERT INTO `nas_consumables_records` VALUES (10, 5, 1, '29503b0359e3430ea3ed981da06fd3fd', '2020-10-18 21:07:56', 10);
INSERT INTO `nas_consumables_records` VALUES (11, 5, 0, '75fc27a750904650847eb12250b46563', '2020-10-20 09:43:24', 100);

-- ----------------------------
-- Table structure for nas_debit_card
-- ----------------------------
DROP TABLE IF EXISTS `nas_debit_card`;
CREATE TABLE `nas_debit_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL COMMENT '开卡员工id',
  `emp_commision` int(11) NOT NULL COMMENT '员工提成',
  `card_species` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `card_amount` decimal(10, 0) NOT NULL,
  `card_deduction` decimal(2, 1) NOT NULL,
  `card_location` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `nas_debit_card_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `nas_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '储值卡信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_debit_card
-- ----------------------------
INSERT INTO `nas_debit_card` VALUES (1, 1, 0, 0, '白金储值卡', 8999, 0.8, '北京西盘子');
INSERT INTO `nas_debit_card` VALUES (2, 2, 1, 1, '黄金卡储值卡', 10000, 0.7, '天津');

-- ----------------------------
-- Table structure for nas_employee
-- ----------------------------
DROP TABLE IF EXISTS `nas_employee`;
CREATE TABLE `nas_employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_phone` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_gender` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_post` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_state` int(11) NOT NULL,
  `emp_createdate` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_employee
-- ----------------------------
INSERT INTO `nas_employee` VALUES (1, '王五', '1586645', '男', '销售', 0, '2020-10-19 03:19:36');
INSERT INTO `nas_employee` VALUES (2, '赵四', '123213', '男', '销售', 1, '2020-10-18 00:00:00');
INSERT INTO `nas_employee` VALUES (3, '张三', '12324343', '女', '施工', 0, '2020-10-19 18:06:59');
INSERT INTO `nas_employee` VALUES (4, '刘博', '13936467399', '女', '店长', 1, '2020-10-19 00:52:40');
INSERT INTO `nas_employee` VALUES (7, '董洪川', '17745561174', '男', '店长', 1, '2020-10-19 04:16:38');
INSERT INTO `nas_employee` VALUES (8, '杨永桃', '15826087749', '男', '销售', 1, '2020-10-19 04:16:20');
INSERT INTO `nas_employee` VALUES (9, '唐建', '15627445670', '男', '销售', 0, '2020-10-18 20:17:15');
INSERT INTO `nas_employee` VALUES (10, '谭雪峰', '15644331521', '男', '店长', 1, '2020-10-19 04:24:37');
INSERT INTO `nas_employee` VALUES (11, '张涛', '17746652270', '男', '销售', 0, '2020-10-19 18:42:39');
INSERT INTO `nas_employee` VALUES (12, '皇帝', '17746652270', '男', '店长', 1, '2020-10-20 11:02:38');
INSERT INTO `nas_employee` VALUES (13, '福建省', '17746652270', '男', '店长', 0, '2020-10-20 11:03:59');

-- ----------------------------
-- Table structure for nas_goods
-- ----------------------------
DROP TABLE IF EXISTS `nas_goods`;
CREATE TABLE `nas_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goods_price` decimal(10, 0) NOT NULL,
  `goods_commission` decimal(10, 0) NOT NULL COMMENT '商品提成',
  `goods_stock` decimal(10, 0) NOT NULL,
  `goods_state` int(255) NOT NULL,
  `goods_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_addtime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `nas_goods_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `nas_goods_class` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_goods
-- ----------------------------
INSERT INTO `nas_goods` VALUES (1, 1, '机油', 12, 12, 12, 1, 'dsds', '2020-10-19');

-- ----------------------------
-- Table structure for nas_goods_class
-- ----------------------------
DROP TABLE IF EXISTS `nas_goods_class`;
CREATE TABLE `nas_goods_class`  (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  UNIQUE INDEX `we`(`class_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_goods_class
-- ----------------------------
INSERT INTO `nas_goods_class` VALUES (66, '商品分类一');
INSERT INTO `nas_goods_class` VALUES (1, '空气清新剂');
INSERT INTO `nas_goods_class` VALUES (78, '装饰');
INSERT INTO `nas_goods_class` VALUES (81, '车座');
INSERT INTO `nas_goods_class` VALUES (76, '车漆');
INSERT INTO `nas_goods_class` VALUES (84, '车用');
INSERT INTO `nas_goods_class` VALUES (71, '车膜');
INSERT INTO `nas_goods_class` VALUES (83, '轮胎');
INSERT INTO `nas_goods_class` VALUES (68, '零件');
INSERT INTO `nas_goods_class` VALUES (79, '音响');

-- ----------------------------
-- Table structure for nas_order
-- ----------------------------
DROP TABLE IF EXISTS `nas_order`;
CREATE TABLE `nas_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `car_id` int(11) NULL DEFAULT NULL,
  `order_price` double NOT NULL,
  `order_paymethod` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_state` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_createdate` datetime(0) NOT NULL,
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_order
-- ----------------------------
INSERT INTO `nas_order` VALUES (123458, 1, 13, 1000, '现金', '0', '2020-10-03 01:39:34', '个人违规任务12313');
INSERT INTO `nas_order` VALUES (123463, 2, 13, 6000, '微信', '0', '2020-10-09 01:41:49', '个人违规任务');
INSERT INTO `nas_order` VALUES (123464, 3, 13, 4000, '刷卡', '0', '2020-10-16 01:42:28', '个人违规任务');
INSERT INTO `nas_order` VALUES (123465, 4, 13, 1500, '体验卡', '0', '2020-10-17 01:43:28', '个人违规任务');
INSERT INTO `nas_order` VALUES (123466, 6, 13, 3200, '现金', '0', '2020-10-12 01:43:55', '个人违规任务');
INSERT INTO `nas_order` VALUES (123467, 7, 13, 2100, '微信', '0', '2020-10-20 01:46:35', '个人违规任务');
INSERT INTO `nas_order` VALUES (123468, 9, 13, 2100, '现金', '0', '2020-10-20 09:04:13', '啦啦啦啦');
INSERT INTO `nas_order` VALUES (123469, 1, 13, 2060, '11', '0', '2020-10-20 10:46:47', '发语音翻译');

-- ----------------------------
-- Table structure for nas_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `nas_order_goods`;
CREATE TABLE `nas_order_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `nas_order_goods_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `nas_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_order_goods_ibfk_3` FOREIGN KEY (`goods_id`) REFERENCES `nas_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_order_goods_ibfk_4` FOREIGN KEY (`order_id`) REFERENCES `nas_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_order_goods
-- ----------------------------
INSERT INTO `nas_order_goods` VALUES (8, 123463, 1, 1);
INSERT INTO `nas_order_goods` VALUES (9, 123464, 1, 1);
INSERT INTO `nas_order_goods` VALUES (10, 123465, 1, 1);
INSERT INTO `nas_order_goods` VALUES (11, 123466, 1, 1);
INSERT INTO `nas_order_goods` VALUES (12, 123467, 1, 1);
INSERT INTO `nas_order_goods` VALUES (14, 123468, 1, 1);

-- ----------------------------
-- Table structure for nas_order_service
-- ----------------------------
DROP TABLE IF EXISTS `nas_order_service`;
CREATE TABLE `nas_order_service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `service_id` int(11) NOT NULL COMMENT '服务类型id',
  `car_type_id` int(11) NOT NULL COMMENT '车辆类型id',
  `emp_constructors_id` int(11) NOT NULL COMMENT '施工员工数组id',
  `emp_seller_id` int(11) NOT NULL COMMENT '销售员工id',
  `emp_constructor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `service_id`(`service_id`) USING BTREE,
  INDEX `nas_order_service_ibfk_1`(`order_id`) USING BTREE,
  INDEX `emp_constructor_id`(`emp_constructors_id`) USING BTREE,
  INDEX `emp_constructor_id_2`(`emp_constructor_id`) USING BTREE,
  CONSTRAINT `nas_order_service_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `nas_service` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_order_service_ibfk_4` FOREIGN KEY (`order_id`) REFERENCES `nas_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_order_service_ibfk_5` FOREIGN KEY (`emp_constructor_id`) REFERENCES `nas_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_order_service_ibfk_6` FOREIGN KEY (`emp_constructors_id`) REFERENCES `nas_service_constructors` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_order_service
-- ----------------------------
INSERT INTO `nas_order_service` VALUES (2, 123467, 1, 1, 8, 1, 1);
INSERT INTO `nas_order_service` VALUES (3, 123463, 1, 1, 2, 1, 1);
INSERT INTO `nas_order_service` VALUES (4, 123464, 2, 2, 1, 1, 1);
INSERT INTO `nas_order_service` VALUES (5, 123465, 3, 1, 3, 1, 1);
INSERT INTO `nas_order_service` VALUES (6, 123466, 2, 1, 4, 1, 1);
INSERT INTO `nas_order_service` VALUES (7, 123467, 3, 1, 7, 1, 1);

-- ----------------------------
-- Table structure for nas_reservation_card
-- ----------------------------
DROP TABLE IF EXISTS `nas_reservation_card`;
CREATE TABLE `nas_reservation_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kaname` int(11) NULL DEFAULT NULL,
  `species` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `amount` decimal(10, 0) NOT NULL,
  `bybuy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `xiaoshou_employee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addtime` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_reservation_card
-- ----------------------------
INSERT INTO `nas_reservation_card` VALUES (1, 1, 1, 1, 123, '2', '1', '2020-10-17 14:02:53.000000');
INSERT INTO `nas_reservation_card` VALUES (2, 2, 0, 232132, 100, '已支付', '王五', '2020-10-19 17:20:03.000000');
INSERT INTO `nas_reservation_card` VALUES (5, 2, 0, 1232132, 100, '已支付', '张三', '2020-10-20 04:12:37.000000');
INSERT INTO `nas_reservation_card` VALUES (6, 1, 1, 12321321, 100, '已支付', '赵四', '2020-10-20 11:13:15.000000');

-- ----------------------------
-- Table structure for nas_service
-- ----------------------------
DROP TABLE IF EXISTS `nas_service`;
CREATE TABLE `nas_service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `service_price` decimal(10, 0) NOT NULL,
  `emp_commission` decimal(10, 0) NOT NULL COMMENT '提成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务类别信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_service
-- ----------------------------
INSERT INTO `nas_service` VALUES (1, '全部服务', 299, 7);
INSERT INTO `nas_service` VALUES (2, '洗车', 25, 1);
INSERT INTO `nas_service` VALUES (3, '修车', 1000, 50);
INSERT INTO `nas_service` VALUES (4, '加油', 1000, 20);

-- ----------------------------
-- Table structure for nas_service_constructors
-- ----------------------------
DROP TABLE IF EXISTS `nas_service_constructors`;
CREATE TABLE `nas_service_constructors`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `constructor01_id` int(11) NOT NULL,
  `constructor02_id` int(11) NULL DEFAULT NULL,
  `constructor03_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `constructor01_id`(`constructor01_id`) USING BTREE,
  INDEX `constructor02_id`(`constructor02_id`) USING BTREE,
  INDEX `constructor03_id`(`constructor03_id`) USING BTREE,
  CONSTRAINT `nas_service_constructors_ibfk_1` FOREIGN KEY (`constructor01_id`) REFERENCES `nas_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_service_constructors_ibfk_2` FOREIGN KEY (`constructor02_id`) REFERENCES `nas_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_service_constructors_ibfk_3` FOREIGN KEY (`constructor03_id`) REFERENCES `nas_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_service_constructors
-- ----------------------------
INSERT INTO `nas_service_constructors` VALUES (1, 1, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (2, 1, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (3, 1, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (4, 1, 2, NULL);
INSERT INTO `nas_service_constructors` VALUES (5, 1, 2, NULL);
INSERT INTO `nas_service_constructors` VALUES (6, 2, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (7, 2, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (8, 2, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (9, 2, NULL, NULL);
INSERT INTO `nas_service_constructors` VALUES (10, 1, 2, NULL);

-- ----------------------------
-- Table structure for nas_station_comment
-- ----------------------------
DROP TABLE IF EXISTS `nas_station_comment`;
CREATE TABLE `nas_station_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `submit_time` datetime(6) NOT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `nas_station_comment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `nas_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '店面评论信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_station_comment
-- ----------------------------
INSERT INTO `nas_station_comment` VALUES (1, 123458, '2020-10-15 09:33:39.000000', '好用，良心', 5);
INSERT INTO `nas_station_comment` VALUES (2, 123463, '2020-10-17 09:34:04.000000', '优秀，好商家', 4);
INSERT INTO `nas_station_comment` VALUES (3, 123464, '2020-10-19 09:34:34.000000', '辣鸡店铺，垃圾商品', 1);
INSERT INTO `nas_station_comment` VALUES (4, 123467, '2020-10-15 09:35:06.000000', '一般般', 2);

-- ----------------------------
-- Table structure for nas_user
-- ----------------------------
DROP TABLE IF EXISTS `nas_user`;
CREATE TABLE `nas_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_user
-- ----------------------------
INSERT INTO `nas_user` VALUES (1, '张三但', '12526077530', '哈尔滨', '无');
INSERT INTO `nas_user` VALUES (2, '李四', '13453042643', '大庆', '无');
INSERT INTO `nas_user` VALUES (3, '王五', '18923781928', '重庆', 'dwq');
INSERT INTO `nas_user` VALUES (4, 'tom', '18923781928', '北京', 'dw');
INSERT INTO `nas_user` VALUES (6, 'siri', '18923781923', '上海', 'jr');
INSERT INTO `nas_user` VALUES (7, 'lily', '18923781920', '天津', 'dsa');
INSERT INTO `nas_user` VALUES (9, '刘博', '17745561400', '深圳', '无');
INSERT INTO `nas_user` VALUES (10, '李浩', '18923781928', '成都', '无');
INSERT INTO `nas_user` VALUES (11, '校长', '17746673995', '北京', '的哈市');
INSERT INTO `nas_user` VALUES (12, '赵磊', '17745561174', '重庆', '我是超级VIP');
INSERT INTO `nas_user` VALUES (13, '赵磊', '18827384711', NULL, 'FTYF');

-- ----------------------------
-- Table structure for nas_user_car
-- ----------------------------
DROP TABLE IF EXISTS `nas_user_car`;
CREATE TABLE `nas_user_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `old` int(11) NULL DEFAULT NULL COMMENT '年份',
  `brand` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `type` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `series` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系列',
  `model` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '型号',
  `mileage` decimal(16, 2) NOT NULL COMMENT '里程',
  `license_plate` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `engine_model` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车架号',
  `driving_license` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行驶证',
  `guide_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '指导价',
  `insurance_expiry_date` datetime(0) NOT NULL COMMENT '保险到期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uc_id`(`u_id`) USING BTREE,
  CONSTRAINT `nas_user_car_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `nas_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户车辆信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_user_car
-- ----------------------------
INSERT INTO `nas_user_car` VALUES (1, 1, 12, '宝马', 'B+级', 'R9', '宝马S', 108000.00, '粤ZF013G', 'UD125', 'GFEUFGUEH', 12000, '2020-10-14 11:18:00');
INSERT INTO `nas_user_car` VALUES (7, 1, 10, '宝马', 'B+级', 'R9', '宝马S', 108000.00, '粤ZF023G', 'UF125', 'FFASFSFSFF', 10000122, '2020-10-14 11:18:00');
INSERT INTO `nas_user_car` VALUES (8, 1, 9, '奥迪', '轿车', 'RS5', '奥迪RS', 88.00, '粤ZF033G', 'UC124', 'FASFDFDFFF', 12150225, '2020-10-21 00:00:00');
INSERT INTO `nas_user_car` VALUES (9, 2, 8, '奥迪', '轿车', 'RS5', '奥迪RS', 88.00, '粤ZF0438', 'UA125', 'FSFSFSFWW', 12154545, '2020-10-26 00:00:00');
INSERT INTO `nas_user_car` VALUES (10, 4, 7, '奥迪', '轿车', 'RS5', '奥迪RS', 23.00, '粤ZF0530', 'UG125', 'DSFDGDFFG', 12103564, '2020-10-20 00:00:00');
INSERT INTO `nas_user_car` VALUES (11, 4, 7, '奥迪', '轿车', 'RS5', '奥迪RS', 23.00, '粤ZF0634', 'UD125', 'WRVERERTE', 487858878, '2020-10-20 00:00:00');
INSERT INTO `nas_user_car` VALUES (12, 6, 6, '奥迪', '轿车', 'RS5', '奥迪RS', 88.00, '粤ZF0730', 'UD125', 'WERWEEDF', 265215, '2020-10-21 00:00:00');
INSERT INTO `nas_user_car` VALUES (13, 7, 12, '奥迪', '轿车', 'RS5', '奥迪RS', 33.00, '晋A12345', 'UD122', 'GDFGGDGRT', 423453453, '2020-10-20 00:00:00');
INSERT INTO `nas_user_car` VALUES (14, 9, 15, '奥迪', '轿车', 'RS5', '奥迪RS', 23.00, '粤ZF0830', 'UD125', 'FWTERERTRT', 5434645654, '2020-10-19 00:00:00');
INSERT INTO `nas_user_car` VALUES (15, 10, 16, '奥迪', '轿车', 'RS5', '奥迪RS', 88.00, '粤ZF0234', 'UG125', 'WEWRFEFW', 23424432, '2020-10-28 00:00:00');
INSERT INTO `nas_user_car` VALUES (16, 11, 11, '奥迪', '轿车', 'RS5', '奥迪RS', 10000.00, '川BVM479', 'UG125', 'FAFSAFEFEW', 234255534, '2020-10-31 00:00:00');
INSERT INTO `nas_user_car` VALUES (17, 12, NULL, '奥迪', '轿车', 'RS5', '奥迪RS', 100000.00, '川SDR576', NULL, NULL, NULL, '2020-10-31 00:00:00');
INSERT INTO `nas_user_car` VALUES (18, 13, NULL, '宝马', '运动suv', 'X5', '宝马X5', 5124.00, '粤ZF013J', NULL, NULL, NULL, '2020-10-23 00:00:00');

-- ----------------------------
-- Table structure for nas_user_giftpack
-- ----------------------------
DROP TABLE IF EXISTS `nas_user_giftpack`;
CREATE TABLE `nas_user_giftpack`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `gift_price` int(11) NOT NULL,
  `gift_fromtime` datetime(0) NOT NULL,
  `gift_totime` datetime(0) NOT NULL,
  `gift_location` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gift_details` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gpu_id`(`u_id`) USING BTREE,
  CONSTRAINT `nas_user_giftpack_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `nas_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '礼包信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_user_giftpack
-- ----------------------------
INSERT INTO `nas_user_giftpack` VALUES (1, 1, 893, '2020-10-01 19:18:33', '2020-10-18 19:18:41', '北京西盘子', '红药水两瓶、蓝药水一瓶、lily是个法师');
INSERT INTO `nas_user_giftpack` VALUES (2, 2, 633, '2020-10-14 00:23:40', '2020-10-21 00:23:47', '重庆', '垃圾');

-- ----------------------------
-- Table structure for nas_user_reservation
-- ----------------------------
DROP TABLE IF EXISTS `nas_user_reservation`;
CREATE TABLE `nas_user_reservation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) NOT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addtime` date NOT NULL,
  `finishtime` date NOT NULL,
  `yuyue_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `yuyue_che` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `beizhu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `s_id`(`service_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `nas_user_reservation_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `nas_service` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nas_user_reservation_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `nas_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_user_reservation
-- ----------------------------
INSERT INTO `nas_user_reservation` VALUES (1, 1, '已预约', '2020-10-07', '2020-10-15', 'e', '123213', '123213', '已经服务了么', 1);
INSERT INTO `nas_user_reservation` VALUES (2, 2, '已服务', '2020-10-20', '2020-10-25', '张三', '11111', '3232', '没服务', 2);

-- ----------------------------
-- Table structure for nas_year_card
-- ----------------------------
DROP TABLE IF EXISTS `nas_year_card`;
CREATE TABLE `nas_year_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL COMMENT '员工id',
  `yc_num` int(11) NULL DEFAULT NULL,
  `emp_commission` decimal(10, 0) NOT NULL COMMENT '员工开卡提成',
  `yc_amount` decimal(10, 0) NOT NULL,
  `yc_fromtime` datetime(0) NOT NULL,
  `yc_totime` datetime(0) NOT NULL,
  `yc_state` bit(1) NOT NULL,
  `yc_location` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `yuc_id`(`u_id`) USING BTREE,
  CONSTRAINT `nas_year_card_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `nas_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户年卡表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nas_year_card
-- ----------------------------
INSERT INTO `nas_year_card` VALUES (1, 1, 1, 1, 0, 1000, '2020-10-05 19:15:03', '2020-10-31 19:15:07', b'0', '北京西盘子');
INSERT INTO `nas_year_card` VALUES (2, 2, 2, 1, 0, 800, '2020-10-20 03:57:06', '2020-10-28 03:57:11', b'1', '天津');

-- ----------------------------
-- Table structure for userlogin
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin`  (
  `userlogin_id` int(11) NOT NULL AUTO_INCREMENT,
  `userlogin_zhanghao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userlogin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userlogin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userlogin
-- ----------------------------
INSERT INTO `userlogin` VALUES (1, '12345', '12345');

-- ----------------------------
-- View structure for v_today_reservation
-- ----------------------------
DROP VIEW IF EXISTS `v_today_reservation`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_today_reservation` AS select `nas_user`.`name` AS `name`,`nas_user`.`phone` AS `phone`,`nas_user_car`.`brand` AS `brand`,`nas_user_car`.`model` AS `model`,`nas_user_car`.`license_plate` AS `license_plate`,`nas_user_reservation`.`finishtime` AS `appoint_time`,`nas_service`.`service_name` AS `service_name`,`nas_user_reservation`.`beizhu` AS `reservation_remark` from (((`nas_user` join `nas_user_car` on((`nas_user`.`id` = `nas_user_car`.`u_id`))) join `nas_user_reservation` on((`nas_user`.`id` = `nas_user_reservation`.`u_id`))) join `nas_service` on((`nas_user_reservation`.`service_id` = `nas_service`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
