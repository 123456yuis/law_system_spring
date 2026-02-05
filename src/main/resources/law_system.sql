#/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80043 (8.0.43)
 Source Host           : localhost:3306
 Source Schema         : law_system

 Target Server Type    : MySQL
 Target Server Version : 80043 (8.0.43)
 File Encoding         : 65001

 Date: 05/02/2026 11:32:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `client_id` bigint NULL DEFAULT NULL COMMENT '逻辑外键，发布公告的员工id',
  `thumbs_up` bigint NULL DEFAULT NULL COMMENT '点赞量',
  `views` bigint NULL DEFAULT NULL COMMENT '浏览量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '关于春节放假安排的通知', '根据国家法定节假日安排，本律所将于2月10日至2月17日放假，2月18日正常上班。放假期间如有紧急法律事务，请联系值班律师。', '2025-01-20 09:00:00', 1, 156, 1200);
INSERT INTO `announcement` VALUES (2, '新入职律师欢迎会通知', '欢迎张正义、李思思等五位新律师加入本所。定于1月25日下午3点在会议室举行欢迎会，请全体员工准时参加。', '2025-01-22 14:30:00', 1, 89, 850);
INSERT INTO `announcement` VALUES (3, '民法典专题讲座预告', '本周五下午2点，将由王法明律师在多功能厅举办《民法典合同编新规解读》专题讲座，欢迎各位律师及客户参加。', '2025-01-25 10:15:00', 2, 203, 1800);
INSERT INTO `announcement` VALUES (4, '办公室装修通知', '为改善办公环境，本所将于2月1日至2月5日进行办公室局部装修，施工期间请各位同事注意安全，尽量在家办公。', '2025-01-28 16:45:00', 1, 42, 620);
INSERT INTO `announcement` VALUES (5, '年度优秀律师评选结果公示', '经民主评议和合伙人会议决定，2024年度优秀律师为：赵维权、刘公正、陈明理。特此公示，公示期3天。', '2025-02-01 11:20:00', 1, 178, 1500);
INSERT INTO `announcement` VALUES (6, '关于规范案件档案管理的规定', '为进一步规范案件档案管理，提高工作效率，特制定《案件档案管理规定》，自2025年3月1日起实施。', '2025-02-05 15:30:00', 1, 67, 780);
INSERT INTO `announcement` VALUES (7, '五一劳动节放假安排', '根据国家规定，5月1日至5月5日放假调休，共5天。4月28日、5月11日正常上班。请各位律师安排好工作。', '2025-04-20 09:10:00', 1, 95, 1100);
INSERT INTO `announcement` VALUES (8, '夏季高温防暑降温通知', '近日持续高温，请各位同事注意防暑降温。办公室空调已全面检修，确保正常运行。如有身体不适及时就医。', '2025-07-15 14:40:00', 3, 56, 920);
INSERT INTO `announcement` VALUES (9, '国庆节放假安排通知', '国庆节放假安排：10月1日至10月7日放假调休，共7天。9月29日、10月12日正常上班。', '2025-09-25 10:50:00', 1, 112, 1350);
INSERT INTO `announcement` VALUES (10, '关于启用新办公系统的通知', '为提高办公效率，本所将于10月8日起启用新的OA办公系统。请各位同事在9月30日前完成培训。', '2025-09-28 16:20:00', 2, 78, 980);
INSERT INTO `announcement` VALUES (11, '年度总结大会通知', '定于12月28日下午2点，在会议中心召开2025年度工作总结大会，请全体员工准时参加。', '2025-12-20 13:15:00', 1, 134, 1250);
INSERT INTO `announcement` VALUES (12, '元旦放假安排', '元旦放假安排：1月1日至1月3日放假，共3天。1月4日正常上班。祝大家新年快乐！', '2025-12-28 11:30:00', 1, 89, 1050);
INSERT INTO `announcement` VALUES (13, '关于疫情防控的紧急通知', '近期疫情有所反弹，请各位同事和客户进入律所务必佩戴口罩、测量体温、出示健康码。感谢配合！', '2026-01-10 08:45:00', 1, 156, 2100);
INSERT INTO `announcement` VALUES (14, '律师继续教育培训通知', '市司法局定于1月15日举办律师继续教育线上培训，请各位律师按时参加，完成学时要求。', '2026-01-12 14:20:00', 3, 67, 890);
INSERT INTO `announcement` VALUES (15, '春节慰问金发放通知', '2026年春节慰问金将于1月20日前发放到各位员工的工资卡中，请注意查收。', '2026-01-18 10:35:00', 1, 145, 1150);
INSERT INTO `announcement` VALUES (16, '关于调整律师收费标准的通知', '根据市场情况和律所发展需要，经合伙人会议研究决定，自2026年2月1日起调整部分业务收费标准。', '2026-01-22 15:50:00', 1, 203, 1850);
INSERT INTO `announcement` VALUES (17, '三八妇女节活动通知', '为庆祝三八国际妇女节，律所将于3月8日下午组织女性员工开展健康讲座和手工制作活动，欢迎参加。', '2026-03-01 09:25:00', 2, 112, 950);
INSERT INTO `announcement` VALUES (18, '清明节放假安排', '清明节放假安排：4月4日至4月6日放假，共3天。4月7日正常上班。请各位律师安排好工作。', '2026-03-30 13:40:00', 1, 56, 820);
INSERT INTO `announcement` VALUES (19, '关于举办模拟法庭比赛的通知', '为提升青年律师的诉讼技能，律所将于5月10日举办模拟法庭比赛，欢迎35岁以下律师积极报名。', '2026-04-15 11:05:00', 3, 89, 1100);
INSERT INTO `announcement` VALUES (20, '端午节放假安排', '端午节放假安排：6月7日至6月9日放假，共3天。6月10日正常上班。祝大家端午安康！', '2026-05-28 16:30:00', 1, 78, 920);

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约单号',
  `client_id` bigint NULL DEFAULT NULL COMMENT '客户id',
  `lawer_id` bigint NULL DEFAULT NULL COMMENT '律师id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `case_id` bigint NULL DEFAULT NULL COMMENT '预约案件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, 1, 1, '2025-02-10 09:30:00', 7);
INSERT INTO `appointment` VALUES (2, 2, 2, '2025-02-12 14:00:00', 8);
INSERT INTO `appointment` VALUES (3, 3, 3, '2025-02-15 10:45:00', 9);
INSERT INTO `appointment` VALUES (4, 4, 4, '2025-02-18 16:20:00', 10);
INSERT INTO `appointment` VALUES (5, 5, 5, '2025-02-20 11:10:00', 12);
INSERT INTO `appointment` VALUES (6, 6, 6, '2025-02-22 15:30:00', 13);
INSERT INTO `appointment` VALUES (7, 7, 7, '2025-02-25 09:15:00', 14);
INSERT INTO `appointment` VALUES (8, 8, 8, '2025-02-28 13:45:00', 15);
INSERT INTO `appointment` VALUES (9, 9, 9, '2025-03-02 10:25:00', 16);
INSERT INTO `appointment` VALUES (10, 10, 10, '2025-03-05 14:50:00', 17);
INSERT INTO `appointment` VALUES (11, 11, 11, '2025-03-08 11:35:00', 18);
INSERT INTO `appointment` VALUES (12, 12, 12, '2025-03-10 16:05:00', 19);
INSERT INTO `appointment` VALUES (13, 13, 13, '2025-03-12 09:50:00', 20);
INSERT INTO `appointment` VALUES (14, 14, 14, '2025-03-15 14:15:00', 21);
INSERT INTO `appointment` VALUES (15, 15, 15, '2025-03-18 10:40:00', 22);
INSERT INTO `appointment` VALUES (16, 16, 16, '2025-03-20 15:20:00', 23);
INSERT INTO `appointment` VALUES (17, 17, 17, '2025-03-22 11:55:00', 24);
INSERT INTO `appointment` VALUES (18, 18, 18, '2025-03-25 16:30:00', 25);
INSERT INTO `appointment` VALUES (19, 19, 19, '2025-03-28 13:10:00', 26);
INSERT INTO `appointment` VALUES (20, 20, 20, '2025-03-30 09:45:00', 27);
INSERT INTO `appointment` VALUES (21, 21, 1, '2025-04-01 14:25:00', 28);
INSERT INTO `appointment` VALUES (22, 22, 2, '2025-04-03 10:05:00', 29);
INSERT INTO `appointment` VALUES (23, 23, 3, '2025-04-05 15:40:00', 30);
INSERT INTO `appointment` VALUES (24, 24, 4, '2025-04-08 11:20:00', 31);
INSERT INTO `appointment` VALUES (25, 25, 5, '2025-04-10 16:50:00', 32);
INSERT INTO `appointment` VALUES (26, 26, 6, '2025-04-12 13:30:00', 33);
INSERT INTO `appointment` VALUES (27, 27, 7, '2025-04-15 09:10:00', 34);
INSERT INTO `appointment` VALUES (28, 28, 8, '2025-04-17 14:35:00', 35);
INSERT INTO `appointment` VALUES (29, 29, 9, '2025-04-20 10:15:00', 36);
INSERT INTO `appointment` VALUES (30, 30, 10, '2025-04-22 15:55:00', 37);
INSERT INTO `appointment` VALUES (31, 31, 11, '2025-04-25 12:25:00', 38);
INSERT INTO `appointment` VALUES (32, 32, 12, '2025-04-28 09:05:00', 39);
INSERT INTO `appointment` VALUES (33, 33, 13, '2025-05-02 14:40:00', 40);
INSERT INTO `appointment` VALUES (34, 34, 14, '2025-05-05 10:20:00', 41);
INSERT INTO `appointment` VALUES (35, 35, 15, '2025-05-08 15:10:00', 42);
INSERT INTO `appointment` VALUES (36, 36, 16, '2025-05-10 11:45:00', 43);
INSERT INTO `appointment` VALUES (37, 37, 17, '2025-05-12 16:25:00', 44);
INSERT INTO `appointment` VALUES (38, 38, 18, '2025-05-15 13:05:00', 45);
INSERT INTO `appointment` VALUES (39, 39, 19, '2025-05-18 09:35:00', 46);
INSERT INTO `appointment` VALUES (40, 40, 20, '2025-05-20 14:15:00', 47);

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '收费单号',
  `em_id` bigint NULL DEFAULT NULL COMMENT '员工id',
  `client_id` bigint NULL DEFAULT NULL COMMENT '客户id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '收费时间',
  `bill_state` int NULL DEFAULT NULL COMMENT '支付状态，0表示未支付，1表示已支付一部分，2表示已支付完全',
  `bill_paid` decimal(10, 2) NULL DEFAULT NULL COMMENT '已收费用',
  `bill_payable` decimal(10, 2) NULL DEFAULT NULL COMMENT '应收费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, 2, 1, '2025-02-12 10:30:00', 2, 5000.00, 5000.00);
INSERT INTO `bill` VALUES (2, 3, 2, '2025-02-14 15:20:00', 2, 3000.00, 3000.00);
INSERT INTO `bill` VALUES (3, 4, 3, '2025-02-17 11:45:00', 2, 8000.00, 8000.00);
INSERT INTO `bill` VALUES (4, 5, 4, '2025-02-20 16:30:00', 2, 4500.00, 4500.00);
INSERT INTO `bill` VALUES (5, 6, 5, '2025-02-22 12:10:00', 2, 3500.00, 3500.00);
INSERT INTO `bill` VALUES (6, 7, 6, '2025-02-25 14:40:00', 2, 2800.00, 2800.00);
INSERT INTO `bill` VALUES (7, 8, 7, '2025-02-28 09:25:00', 2, 6000.00, 6000.00);
INSERT INTO `bill` VALUES (8, 9, 8, '2025-03-02 15:50:00', 2, 3200.00, 3200.00);
INSERT INTO `bill` VALUES (9, 10, 9, '2025-03-05 11:35:00', 2, 2700.00, 2700.00);
INSERT INTO `bill` VALUES (10, 11, 10, '2025-03-08 16:15:00', 1, 4500.00, 9000.00);
INSERT INTO `bill` VALUES (11, 12, 11, '2025-03-10 13:55:00', 2, 5500.00, 5500.00);
INSERT INTO `bill` VALUES (12, 13, 12, '2025-03-12 10:20:00', 2, 7000.00, 7000.00);
INSERT INTO `bill` VALUES (13, 2, 13, '2025-03-15 15:05:00', 2, 3800.00, 3800.00);
INSERT INTO `bill` VALUES (14, 3, 14, '2025-03-18 11:40:00', 2, 4200.00, 4200.00);
INSERT INTO `bill` VALUES (15, 4, 15, '2025-03-20 16:20:00', 1, 2400.00, 4800.00);
INSERT INTO `bill` VALUES (16, 5, 16, '2025-03-22 12:50:00', 2, 5200.00, 5200.00);
INSERT INTO `bill` VALUES (17, 6, 17, '2025-03-25 14:25:00', 2, 6500.00, 6500.00);
INSERT INTO `bill` VALUES (18, 7, 18, '2025-03-28 09:10:00', 2, 4700.00, 4700.00);
INSERT INTO `bill` VALUES (19, 8, 19, '2025-03-30 15:35:00', 2, 2900.00, 2900.00);
INSERT INTO `bill` VALUES (20, 9, 20, '2025-04-02 11:15:00', 2, 5300.00, 5300.00);
INSERT INTO `bill` VALUES (21, 10, 21, '2025-04-05 16:45:00', 0, 0.00, 3100.00);
INSERT INTO `bill` VALUES (22, 11, 22, '2025-04-08 13:20:00', 2, 4400.00, 4400.00);
INSERT INTO `bill` VALUES (23, 12, 23, '2025-04-10 09:55:00', 1, 2900.00, 5800.00);
INSERT INTO `bill` VALUES (24, 13, 24, '2025-04-12 14:30:00', 2, 3600.00, 3600.00);
INSERT INTO `bill` VALUES (25, 2, 25, '2025-04-15 10:05:00', 2, 4900.00, 4900.00);
INSERT INTO `bill` VALUES (26, 3, 26, '2025-04-17 15:40:00', 2, 4100.00, 4100.00);
INSERT INTO `bill` VALUES (27, 4, 27, '2025-04-20 12:25:00', 2, 4300.00, 4300.00);
INSERT INTO `bill` VALUES (28, 5, 28, '2025-04-22 09:10:00', 1, 1950.00, 3900.00);
INSERT INTO `bill` VALUES (29, 6, 29, '2025-04-25 14:50:00', 2, 4600.00, 4600.00);
INSERT INTO `bill` VALUES (30, 7, 30, '2025-04-28 11:30:00', 2, 7500.00, 7500.00);
INSERT INTO `bill` VALUES (31, 8, 31, '2025-05-02 16:10:00', 0, 0.00, 5000.00);
INSERT INTO `bill` VALUES (32, 9, 32, '2025-05-05 13:45:00', 2, 3000.00, 3000.00);
INSERT INTO `bill` VALUES (33, 10, 33, '2025-05-08 10:20:00', 2, 8000.00, 8000.00);
INSERT INTO `bill` VALUES (34, 11, 34, '2025-05-10 15:05:00', 1, 2250.00, 4500.00);
INSERT INTO `bill` VALUES (35, 12, 35, '2025-05-12 11:40:00', 2, 3500.00, 3500.00);
INSERT INTO `bill` VALUES (36, 13, 36, '2025-05-15 16:25:00', 2, 2800.00, 2800.00);
INSERT INTO `bill` VALUES (37, 2, 37, '2025-05-18 13:10:00', 2, 6000.00, 6000.00);
INSERT INTO `bill` VALUES (38, 3, 38, '2025-05-20 09:45:00', 2, 3200.00, 3200.00);
INSERT INTO `bill` VALUES (39, 4, 39, '2025-05-22 14:20:00', 2, 2700.00, 2700.00);
INSERT INTO `bill` VALUES (40, 5, 40, '2025-05-25 10:55:00', 2, 9000.00, 9000.00);
INSERT INTO `bill` VALUES (41, 6, 1, '2025-06-01 15:30:00', 2, 5500.00, 5500.00);
INSERT INTO `bill` VALUES (42, 7, 2, '2025-06-05 12:15:00', 2, 7000.00, 7000.00);
INSERT INTO `bill` VALUES (43, 8, 3, '2025-06-08 09:00:00', 2, 3800.00, 3800.00);
INSERT INTO `bill` VALUES (44, 9, 4, '2025-06-10 14:40:00', 1, 2100.00, 4200.00);
INSERT INTO `bill` VALUES (45, 10, 5, '2025-06-12 11:25:00', 2, 4800.00, 4800.00);
INSERT INTO `bill` VALUES (46, 11, 6, '2025-06-15 16:05:00', 2, 6500.00, 6500.00);
INSERT INTO `bill` VALUES (47, 12, 7, '2025-06-18 13:50:00', 2, 4700.00, 4700.00);
INSERT INTO `bill` VALUES (48, 13, 8, '2025-06-20 10:35:00', 2, 2900.00, 2900.00);
INSERT INTO `bill` VALUES (49, 2, 9, '2025-06-22 15:15:00', 2, 5300.00, 5300.00);
INSERT INTO `bill` VALUES (50, 3, 10, '2025-06-25 12:00:00', 0, 0.00, 3100.00);
INSERT INTO `bill` VALUES (51, 4, 11, '2025-06-28 09:45:00', 2, 4400.00, 4400.00);
INSERT INTO `bill` VALUES (52, 5, 12, '2025-07-01 14:20:00', 2, 5800.00, 5800.00);
INSERT INTO `bill` VALUES (53, 6, 13, '2025-07-03 11:05:00', 2, 3600.00, 3600.00);
INSERT INTO `bill` VALUES (54, 7, 14, '2025-07-05 16:40:00', 2, 4900.00, 4900.00);
INSERT INTO `bill` VALUES (55, 8, 15, '2025-07-08 13:25:00', 2, 4100.00, 4100.00);
INSERT INTO `bill` VALUES (56, 9, 16, '2025-07-10 10:10:00', 2, 4300.00, 4300.00);

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` int NULL DEFAULT NULL COMMENT '性别，1代表男，0代表女',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `biography` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
  `create_time` datetime NULL DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_client_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, '张伟', 'zhangwei', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_001.jpg', '13800138001', '北京市朝阳区建国门外大街1号', '企业法务负责人，专注于公司法与合同法领域，有10年从业经验。', '2025-01-15 09:30:00');
INSERT INTO `client` VALUES (2, '李娜', 'lina', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_002.jpg', '13800138002', '上海市浦东新区陆家嘴环路1000号', '个人客户，主要涉及房产纠纷和继承案件。', '2025-01-20 14:20:00');
INSERT INTO `client` VALUES (3, '王强', 'wangqiang', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_003.jpg', '13800138003', '广州市天河区天河路228号', '小型企业主，需要常年法律顾问服务。', '2025-02-10 11:15:00');
INSERT INTO `client` VALUES (4, '赵敏', 'zhaomin', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_004.jpg', '13800138004', '深圳市南山区科技园南区', 'IT公司创始人，关注知识产权保护。', '2025-02-25 16:40:00');
INSERT INTO `client` VALUES (5, '刘洋', 'liuyang', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_005.jpg', '13800138005', '杭州市西湖区文三路199号', '电商从业者，主要处理消费者权益纠纷。', '2025-03-05 10:10:00');
INSERT INTO `client` VALUES (6, '陈静', 'chenjing', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_006.jpg', '13800138006', '南京市鼓楼区中山路321号', '大学教授，涉及学术成果知识产权问题。', '2025-03-18 15:30:00');
INSERT INTO `client` VALUES (7, '孙浩', 'sunhao', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_007.jpg', '13800138007', '成都市武侯区人民南路四段', '餐饮连锁店老板，需要处理劳动合同纠纷。', '2025-04-02 13:45:00');
INSERT INTO `client` VALUES (8, '周婷', 'zhouting', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_008.jpg', '13800138008', '武汉市武昌区中北路', '自由职业者，处理房产租赁纠纷。', '2025-04-12 09:20:00');
INSERT INTO `client` VALUES (9, '吴刚', 'wugang', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_009.jpg', '13800138009', '西安市雁塔区小寨东路', '建筑工程承包商，涉及工程合同纠纷。', '2025-05-03 14:50:00');
INSERT INTO `client` VALUES (10, '郑秀英', 'zhengxiuying', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_010.jpg', '13800138010', '重庆市渝中区解放碑', '退休职工，处理遗产继承问题。', '2025-05-20 11:30:00');
INSERT INTO `client` VALUES (11, '钱程', 'qiancheng', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_011.jpg', '13800138011', '天津市和平区南京路', '外贸公司经理，涉及国际贸易纠纷。', '2025-06-08 16:15:00');
INSERT INTO `client` VALUES (12, '冯丽', 'fengli', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_012.jpg', '13800138012', '苏州市工业园区星湖街', '外企HR总监，处理劳动法相关事务。', '2025-06-22 10:05:00');
INSERT INTO `client` VALUES (13, '陈明', 'chenming', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_013.jpg', '13800138013', '长沙市岳麓区麓山南路', '创业公司CEO，需要股权架构设计。', '2025-07-10 14:40:00');
INSERT INTO `client` VALUES (14, '杨帆', 'yangfan', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_014.jpg', '13800138014', '郑州市金水区农业路', '医生，涉及医疗事故纠纷。', '2025-07-25 09:55:00');
INSERT INTO `client` VALUES (15, '朱建国', 'zhujianguo', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_015.jpg', '13800138015', '合肥市蜀山区长江西路', '国企中层干部，处理合同审核。', '2025-08-05 13:20:00');
INSERT INTO `client` VALUES (16, '秦小月', 'qinxiaoyue', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_016.jpg', '13800138016', '宁波市鄞州区钱湖北路', '网红主播，需要处理肖像权纠纷。', '2025-08-18 15:45:00');
INSERT INTO `client` VALUES (17, '何志强', 'hezhiqiang', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_017.jpg', '13800138017', '厦门市思明区湖滨南路', '民宿老板，涉及房屋租赁纠纷。', '2025-09-02 10:30:00');
INSERT INTO `client` VALUES (18, '林晓雨', 'linxiaoyu', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_018.jpg', '13800138018', '福州市鼓楼区五四路', '律师助理，个人法律咨询需求。', '2025-09-15 14:10:00');
INSERT INTO `client` VALUES (19, '马文涛', 'mawentao', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_019.jpg', '13800138019', '济南市历下区泺源大街', '培训机构负责人，处理退费纠纷。', '2025-10-08 11:25:00');
INSERT INTO `client` VALUES (20, '宋佳宁', 'songjianing', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_020.jpg', '13800138020', '青岛市市南区香港中路', '家庭主妇，处理离婚财产分割。', '2025-10-22 16:35:00');
INSERT INTO `client` VALUES (21, '黄伟', 'huangwei', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_021.jpg', '13800138021', '大连市中山区人民路', '船运公司经理，涉及海事纠纷。', '2025-11-05 09:40:00');
INSERT INTO `client` VALUES (22, '徐芳', 'xufang', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_022.jpg', '13800138022', '无锡市滨湖区蠡湖大道', '设计师，处理著作权侵权问题。', '2025-11-18 13:55:00');
INSERT INTO `client` VALUES (23, '高建军', 'gaojianjun', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_023.jpg', '13800138023', '温州市鹿城区车站大道', '制造业老板，处理债务纠纷。', '2025-12-01 10:20:00');
INSERT INTO `client` VALUES (24, '唐雪', 'tangxue', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_024.jpg', '13800138024', '昆明市官渡区春城路', '旅游公司负责人，处理旅游合同纠纷。', '2025-12-14 15:15:00');
INSERT INTO `client` VALUES (25, '罗志祥', 'luozhixiang', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_025.jpg', '13800138025', '贵阳市观山湖区林城西路', '房地产开发商，处理购房合同纠纷。', '2026-01-03 11:50:00');
INSERT INTO `client` VALUES (26, '韩梅梅', 'hanmeimei', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_026.jpg', '13800138026', '南宁市青秀区民族大道', '英语教师，处理教育培训合同。', '2026-01-16 14:25:00');
INSERT INTO `client` VALUES (27, '谢文东', 'xiewendong', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_027.jpg', '13800138027', '南昌市红谷滩新区赣江大道', '软件工程师，处理竞业限制协议。', '2026-01-28 09:15:00');
INSERT INTO `client` VALUES (28, '董丽华', 'donglihua', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_028.jpg', '13800138028', '太原市小店区长治路', '会计师，处理税务法律问题。', '2026-02-01 13:40:00');
INSERT INTO `client` VALUES (29, '梁超', 'liangchao', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_029.jpg', '13800138029', '哈尔滨市南岗区红军街', '冰雪运动教练，处理工伤赔偿。', '2026-02-10 16:20:00');
INSERT INTO `client` VALUES (30, '苏小雅', 'suxiaoya', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_030.jpg', '13800138030', '长春市朝阳区人民大街', '大学生，处理校园纠纷。', '2026-02-15 10:05:00');
INSERT INTO `client` VALUES (31, '潘建国', 'panjianguo', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_031.jpg', '13800138031', '沈阳市和平区南京北街', '退休工程师，处理专利侵权。', '2026-02-20 14:50:00');
INSERT INTO `client` VALUES (32, '杜娟', 'dujuan', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_032.jpg', '13800138032', '石家庄市桥西区中山西路', '记者，处理名誉权纠纷。', '2026-02-25 11:30:00');
INSERT INTO `client` VALUES (33, '陆天明', 'lutianming', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_033.jpg', '13800138033', '兰州市城关区庆阳路', '环保人士，处理环境公益诉讼。', '2026-03-02 15:45:00');
INSERT INTO `client` VALUES (34, '白洁', 'baijie', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_034.jpg', '13800138034', '乌鲁木齐市天山区中山路', '少数民族商人，处理民族事务法律问题。', '2026-03-10 09:20:00');
INSERT INTO `client` VALUES (35, '袁弘', 'yuanhong', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_035.jpg', '13800138035', '西宁市城西区五四西路', '高原旅游从业者，处理人身伤害赔偿。', '2026-03-18 13:15:00');
INSERT INTO `client` VALUES (36, '崔永元', 'cuiyongyuan', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_036.jpg', '13800138036', '银川市兴庆区解放街', '媒体人，处理言论自由相关法律问题。', '2026-03-25 16:30:00');
INSERT INTO `client` VALUES (37, '薛冰', 'xuebing', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_037.jpg', '13800138037', '海口市龙华区国贸路', '海南自贸港企业主，处理跨境贸易法律。', '2026-04-01 10:40:00');
INSERT INTO `client` VALUES (38, '欧阳明日', 'ouyangmingri', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_038.jpg', '13800138038', '拉萨市城关区北京中路', '藏族同胞，处理民族区域自治法律问题。', '2026-04-08 14:25:00');
INSERT INTO `client` VALUES (39, '慕容雪', 'murongxue', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_039.jpg', '13800138039', '呼和浩特市新城区新华大街', '蒙古族企业家，处理草原产权纠纷。', '2026-04-15 11:10:00');
INSERT INTO `client` VALUES (40, '东方明', 'dongfangming', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_040.jpg', '13800138040', '贵阳市南明区遵义路', '大数据企业法务，处理数据安全法合规。', '2026-04-22 15:55:00');
INSERT INTO `client` VALUES (41, '西门庆', 'ximenqing', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_041.jpg', '13800138041', '扬州市广陵区文昌中路', '古典家具商人，处理文物交易法律。', '2026-04-30 09:45:00');
INSERT INTO `client` VALUES (42, '南宫雪', 'nangongxue', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_042.jpg', '13800138042', '镇江市京口区中山东路', '醋业公司负责人，处理商标侵权。', '2026-05-06 13:20:00');
INSERT INTO `client` VALUES (43, '北堂风', 'beitangfeng', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_043.jpg', '13800138043', '常州市天宁区延陵中路', '纺织业老板，处理外贸合同纠纷。', '2026-05-12 16:05:00');
INSERT INTO `client` VALUES (44, '独孤剑', 'dugujian', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_044.jpg', '13800138044', '南通市崇川区工农路', '船舶制造企业主，处理海事海商法律。', '2026-05-20 10:30:00');
INSERT INTO `client` VALUES (45, '令狐冲', 'linghuchong', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_045.jpg', '13800138045', '泰州市海陵区青年路', '武侠文化传承人，处理非物质文化遗产保护。', '2026-05-28 14:15:00');
INSERT INTO `client` VALUES (46, '任盈盈', 'renyingying', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_046.jpg', '13800138046', '盐城市亭湖区解放南路', '音乐教育机构创始人，处理版权许可问题。', '2026-06-05 11:50:00');
INSERT INTO `client` VALUES (47, '向问天', 'xiangwentian', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_047.jpg', '13800138047', '淮安市清江浦区淮海北路', '水利工程师，处理水资源使用权纠纷。', '2026-06-12 15:35:00');
INSERT INTO `client` VALUES (48, '岳不群', 'yuebuqun', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_048.jpg', '13800138048', '连云港市海州区苍梧路', '武术学校校长，处理校园伤害事故。', '2026-06-20 09:25:00');
INSERT INTO `client` VALUES (49, '宁中则', 'ningzhongze', 'e10adc3949ba59abbe56e057f20f883e', 0, 'avatar_049.jpg', '13800138049', '宿迁市宿城区洪泽湖路', '女企业家，处理性别平等就业纠纷。', '2026-06-28 13:10:00');
INSERT INTO `client` VALUES (50, '左冷禅', 'zuolengchan', 'e10adc3949ba59abbe56e057f20f883e', 1, 'avatar_050.jpg', '13800138050', '徐州市云龙区和平路', '矿业公司负责人，处理安全生产责任事故。', '2026-07-05 16:40:00');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint NOT NULL COMMENT '评价信息id',
  `client_id` bigint NULL DEFAULT NULL COMMENT '逻辑外键，客户id',
  `lawer_id` bigint NULL DEFAULT NULL COMMENT '逻辑外键，律师id',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评价内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, '张律师专业素养极高，在刑事案件中表现出色，成功为我争取到了缓刑，非常感谢！', '2025-02-20 10:30:00');
INSERT INTO `comment` VALUES (2, 2, 2, '李律师在处理我的离婚案件中非常耐心细致，最终达成了令我满意的财产分割方案。', '2025-02-22 15:45:00');
INSERT INTO `comment` VALUES (3, 3, 3, '王律师的公司法专业知识扎实，为我们公司的股权架构设计提供了专业建议。', '2025-02-25 11:20:00');
INSERT INTO `comment` VALUES (4, 4, 4, '赵律师在知识产权保护方面经验丰富，成功帮助我们公司解决了专利侵权纠纷。', '2025-02-28 16:10:00');
INSERT INTO `comment` VALUES (5, 5, 5, '刘律师的行政诉讼代理非常专业，成功撤销了不合理的行政处罚决定。', '2025-03-02 14:35:00');
INSERT INTO `comment` VALUES (6, 6, 6, '陈律师在处理劳动争议方面很有经验，帮助我们员工争取到了应有的赔偿。', '2025-03-05 09:50:00');
INSERT INTO `comment` VALUES (7, 7, 7, '孙律师的合同审查非常细致，避免了我们在重大合作中的法律风险。', '2025-03-08 13:15:00');
INSERT INTO `comment` VALUES (8, 8, 8, '周律师对房地产法律非常熟悉，成功解决了我们的房产买卖纠纷。', '2025-03-10 16:40:00');
INSERT INTO `comment` VALUES (9, 9, 9, '吴律师在侵权责任案件中表现出色，为我们争取到了合理的损害赔偿。', '2025-03-12 10:05:00');
INSERT INTO `comment` VALUES (10, 10, 10, '郑律师的金融证券法律知识全面，为公司债券发行提供了专业法律服务。', '2025-03-15 15:20:00');
INSERT INTO `comment` VALUES (11, 11, 11, '冯律师的海事海商案件处理经验丰富，成功解决了我们的船舶碰撞纠纷。', '2025-03-18 11:45:00');
INSERT INTO `comment` VALUES (12, 12, 12, '陈律师的国际贸易法律知识全面，帮助我们应对了反倾销调查。', '2025-03-20 14:10:00');
INSERT INTO `comment` VALUES (13, 13, 13, '杨律师的环境公益诉讼经验丰富，为环境保护事业做出了贡献。', '2025-03-22 09:35:00');
INSERT INTO `comment` VALUES (14, 14, 14, '朱律师的医疗纠纷处理专业，帮助我们患者家属获得了应有的赔偿。', '2025-03-25 16:50:00');
INSERT INTO `comment` VALUES (15, 15, 15, '秦律师的网络数据法律知识前沿，为我们公司的数据合规提供了专业指导。', '2025-03-28 12:15:00');
INSERT INTO `comment` VALUES (16, 16, 16, '何律师的税务筹划方案合理合法，为我们公司节省了大量税款。', '2025-03-30 15:40:00');
INSERT INTO `comment` VALUES (17, 17, 17, '林律师的仲裁调解技巧高超，成功化解了我们的商事纠纷。', '2025-04-02 10:05:00');
INSERT INTO `comment` VALUES (18, 18, 18, '马律师的刑事辩护策略得当，为当事人争取到了从轻处罚。', '2025-04-05 14:30:00');
INSERT INTO `comment` VALUES (19, 19, 19, '宋律师的离婚调解工作细致耐心，帮助双方和平解决矛盾。', '2025-04-08 09:55:00');
INSERT INTO `comment` VALUES (20, 20, 20, '黄律师的房地产法律实务经验丰富，解决了我们的建筑工程合同纠纷。', '2025-04-10 13:20:00');
INSERT INTO `comment` VALUES (21, 21, 1, '第二次委托张律师，依然专业可靠，刑事案件辩护效果显著。', '2025-04-12 16:45:00');
INSERT INTO `comment` VALUES (22, 22, 2, '李律师不仅专业，而且富有同理心，在离婚案件中给予了我很多情感支持。', '2025-04-15 11:10:00');
INSERT INTO `comment` VALUES (23, 23, 3, '王律师的企业法律顾问服务全面，为公司日常运营提供了有力法律支持。', '2025-04-18 14:35:00');
INSERT INTO `comment` VALUES (24, 24, 4, '赵律师的商标维权案件处理专业，成功维护了我们品牌的合法权益。', '2025-04-20 09:00:00');
INSERT INTO `comment` VALUES (25, 25, 5, '刘律师的行政复议代理专业高效，快速解决了我们的行政争议。', '2025-04-22 12:25:00');
INSERT INTO `comment` VALUES (26, 26, 6, '陈律师的劳动法培训讲座内容丰富，对我们HR工作很有帮助。', '2025-04-25 15:50:00');
INSERT INTO `comment` VALUES (27, 27, 7, '孙律师的合同谈判技巧高超，为我们争取到了有利的合作条件。', '2025-04-28 10:15:00');
INSERT INTO `comment` VALUES (28, 28, 8, '周律师的物业管理法律知识全面，解决了我们小区的物业纠纷。', '2025-04-30 13:40:00');
INSERT INTO `comment` VALUES (29, 29, 9, '吴律师的人身损害赔偿案件处理专业，为我们争取到了合理赔偿。', '2025-05-03 16:05:00');
INSERT INTO `comment` VALUES (30, 30, 10, '郑律师的IPO法律服务专业全面，为公司成功上市提供了有力支持。', '2025-05-05 11:30:00');
INSERT INTO `comment` VALUES (31, 31, 11, '冯律师的海上货物运输纠纷处理经验丰富，成功挽回了我们的损失。', '2025-05-08 14:55:00');
INSERT INTO `comment` VALUES (32, 32, 12, '陈律师的跨境投资法律咨询专业，为我们的海外投资提供了法律保障。', '2025-05-10 09:20:00');
INSERT INTO `comment` VALUES (33, 33, 13, '杨律师的环境影响评价法律咨询专业，确保了我们项目的合法合规。', '2025-05-12 12:45:00');
INSERT INTO `comment` VALUES (34, 34, 14, '朱律师的医疗事故鉴定程序熟悉，帮助我们患者获得了公正的鉴定结果。', '2025-05-15 16:10:00');
INSERT INTO `comment` VALUES (35, 35, 15, '秦律师的网络安全法合规审查专业，帮助我们公司通过了相关检查。', '2025-05-18 10:35:00');
INSERT INTO `comment` VALUES (36, 36, 16, '何律师的税务争议解决专业高效，快速解决了我们的税务纠纷。', '2025-05-20 13:00:00');
INSERT INTO `comment` VALUES (37, 37, 17, '林律师的国际商事仲裁代理专业，为我们赢得了有利的仲裁裁决。', '2025-05-22 15:25:00');
INSERT INTO `comment` VALUES (38, 38, 18, '马律师的职务犯罪辩护策略得当，为当事人争取到了公正审判。', '2025-05-25 09:50:00');
INSERT INTO `comment` VALUES (39, 39, 19, '宋律师的家庭暴力保护令申请专业高效，及时保护了受害人的权益。', '2025-05-28 12:15:00');
INSERT INTO `comment` VALUES (40, 40, 20, '黄律师的房地产开发全流程法律服务专业，确保了项目的合法合规。', '2025-05-30 15:40:00');
INSERT INTO `comment` VALUES (41, 1, 21, '徐律师的劳动法咨询专业，解答了我们员工的劳动权益问题。', '2025-06-02 10:05:00');
INSERT INTO `comment` VALUES (42, 2, 22, '高律师的商业秘密保护方案设计合理，有效保护了我们公司的核心技术。', '2025-06-05 13:30:00');
INSERT INTO `comment` VALUES (43, 3, 23, '唐律师的公司破产重整方案专业，帮助企业成功实现了重生。', '2025-06-08 16:55:00');
INSERT INTO `comment` VALUES (44, 4, 24, '罗律师的行政处罚听证代理专业，为我们争取到了合理的处理结果。', '2025-06-10 11:20:00');
INSERT INTO `comment` VALUES (45, 5, 25, '韩律师的金融犯罪辩护专业，为当事人提供了有力的法律帮助。', '2025-06-12 14:45:00');
INSERT INTO `comment` VALUES (46, 6, 26, '谢律师的涉外继承案件处理专业，解决了我们的跨境遗产继承问题。', '2025-06-15 09:10:00');
INSERT INTO `comment` VALUES (47, 7, 27, '董律师的医疗过错鉴定代理专业，帮助我们获得了公正的鉴定意见。', '2025-06-18 12:35:00');
INSERT INTO `comment` VALUES (48, 8, 28, '梁律师的环境污染责任案件处理专业，为环境公益事业做出了贡献。', '2025-06-20 16:00:00');
INSERT INTO `comment` VALUES (49, 9, 29, '苏律师的电子商务平台责任案件处理专业，维护了我们商家的合法权益。', '2025-06-22 10:25:00');
INSERT INTO `comment` VALUES (50, 10, 30, '潘律师的国际税收筹划专业合理，为我们公司节省了跨境税务成本。', '2025-06-25 13:50:00');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工账号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像地址',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `sex` int NULL DEFAULT NULL COMMENT '性别，1代表男，0代表女',
  `create_time` datetime NULL DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'admin', '系统管理员', 'admin_avatar.jpg', '123456', '北京市海淀区中关村大街1号', 1, '2024-12-01 09:00:00');
INSERT INTO `employee` VALUES (2, 'zhangli', '张莉', 'emp_001.jpg', 'e10adc3949ba59abbe56e057f20f883e', '上海市黄浦区南京东路100号', 0, '2024-12-05 10:30:00');
INSERT INTO `employee` VALUES (3, 'wangtao', '王涛', 'emp_002.jpg', 'e10adc3949ba59abbe56e057f20f883e', '广州市越秀区中山五路', 1, '2024-12-10 14:20:00');
INSERT INTO `employee` VALUES (4, 'lixia', '李霞', 'emp_003.jpg', 'e10adc3949ba59abbe56e057f20f883e', '深圳市福田区深南大道', 0, '2024-12-15 11:45:00');
INSERT INTO `employee` VALUES (5, 'zhaogang', '赵刚', 'emp_004.jpg', 'e10adc3949ba59abbe56e057f20f883e', '杭州市西湖区文一路', 1, '2024-12-20 16:10:00');
INSERT INTO `employee` VALUES (6, 'sunfang', '孙芳', 'emp_005.jpg', 'e10adc3949ba59abbe56e057f20f883e', '南京市鼓楼区北京西路', 0, '2025-01-05 09:15:00');
INSERT INTO `employee` VALUES (7, 'zhouwei', '周伟', 'emp_006.jpg', 'e10adc3949ba59abbe56e057f20f883e', '成都市锦江区总府路', 1, '2025-01-10 13:40:00');
INSERT INTO `employee` VALUES (8, 'wuping', '吴平', 'emp_007.jpg', 'e10adc3949ba59abbe56e057f20f883e', '武汉市江汉区解放大道', 0, '2025-01-15 15:25:00');
INSERT INTO `employee` VALUES (9, 'zhengqiang', '郑强', 'emp_008.jpg', 'e10adc3949ba59abbe56e057f20f883e', '西安市碑林区南大街', 1, '2025-01-20 10:50:00');
INSERT INTO `employee` VALUES (10, 'fenglan', '冯兰', 'emp_009.jpg', 'e10adc3949ba59abbe56e057f20f883e', '重庆市江北区观音桥', 0, '2025-01-25 14:35:00');
INSERT INTO `employee` VALUES (11, 'chenjun', '陈军', 'emp_010.jpg', 'e10adc3949ba59abbe56e057f20f883e', '天津市河西区友谊路', 1, '2025-02-01 11:20:00');
INSERT INTO `employee` VALUES (12, 'yangli', '杨丽', 'emp_011.jpg', 'e10adc3949ba59abbe56e057f20f883e', '苏州市姑苏区干将路', 0, '2025-02-05 16:05:00');
INSERT INTO `employee` VALUES (13, 'zhuhua', '朱华', 'emp_012.jpg', 'e10adc3949ba59abbe56e057f20f883e', '长沙市芙蓉区五一大道', 1, '2025-02-10 09:40:00');
INSERT INTO `employee` VALUES (14, 'qinyu', '秦雨', 'emp_013.jpg', 'e10adc3949ba59abbe56e057f20f883e', '郑州市中原区建设路', 0, '2025-02-15 13:15:00');
INSERT INTO `employee` VALUES (15, 'hebin', '何斌', 'emp_014.jpg', 'e10adc3949ba59abbe56e057f20f883e', '合肥市包河区马鞍山路', 1, '2025-02-20 15:50:00');

-- ----------------------------
-- Table structure for forum_categories
-- ----------------------------
DROP TABLE IF EXISTS `forum_categories`;
CREATE TABLE `forum_categories`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类描述',
  `sort_order` int NULL DEFAULT 0 COMMENT '排序',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态(0-禁用,1-启用)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum_categories
-- ----------------------------
INSERT INTO `forum_categories` VALUES (1, '法律咨询', '提供各类法律问题咨询与解答', 1, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (2, '案例分析', '分享典型法律案例及分析', 2, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (3, '法律法规', '最新法律法规解读与讨论', 3, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (4, '律师交流', '律师专业经验与技巧分享', 4, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (5, '职场发展', '法律职业规划与发展讨论', 5, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (6, '学习资料', '法律学习资料与备考经验', 6, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (7, '热点讨论', '社会热点法律问题讨论', 7, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');
INSERT INTO `forum_categories` VALUES (8, '休闲娱乐', '法律人生活休闲交流', 8, 1, '2025-01-01 09:00:00', '2025-01-01 09:00:00');

-- ----------------------------
-- Table structure for forum_comments
-- ----------------------------
DROP TABLE IF EXISTS `forum_comments`;
CREATE TABLE `forum_comments`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `post_id` bigint NOT NULL COMMENT '帖子ID',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父评论ID(用于回复)',
  `author_id` bigint NOT NULL COMMENT '评论者ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论者姓名',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `like_count` int NULL DEFAULT 0 COMMENT '点赞数',
  `status` enum('normal','deleted') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'normal' COMMENT '状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_post_id`(`post_id` ASC) USING BTREE,
  INDEX `idx_parent_id`(`parent_id` ASC) USING BTREE,
  INDEX `idx_author_id`(`author_id` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum_comments
-- ----------------------------
INSERT INTO `forum_comments` VALUES (2, 1, NULL, 3, '王强', '补充一点：如果是父母出资购房，还需要考虑是赠与还是借款，这会影响财产分割结果。', 9, 'normal', '2025-02-11 09:15:00', '2026-02-05 10:51:13');
INSERT INTO `forum_comments` VALUES (3, 1, 1, 1, '张伟', '感谢李娜的认可。关于父母出资的性质，确实需要结合证据综合判断，建议咨询专业律师。', 5, 'normal', '2025-02-11 14:45:00', '2025-02-12 09:40:00');
INSERT INTO `forum_comments` VALUES (4, 2, NULL, 4, '赵敏', '股权架构设计确实很重要，我们公司之前就因为股权比例问题产生过内部纠纷。', 12, 'normal', '2025-02-12 15:20:00', '2025-02-13 11:25:00');
INSERT INTO `forum_comments` VALUES (5, 2, NULL, 5, '刘洋', '对于创业公司来说，预留期权池也是股权设计的重要环节，建议作者可以补充这部分内容。', 7, 'normal', '2025-02-13 10:10:00', '2025-02-14 16:05:00');
INSERT INTO `forum_comments` VALUES (8, 3, 7, 4, '赵敏', '中小企业可以从基础做起，比如数据分类分级、访问控制、员工培训等，逐步完善。', 7, 'normal', '2025-02-17 09:25:00', '2026-02-05 11:06:41');
INSERT INTO `forum_comments` VALUES (9, 4, NULL, 8, '周婷', '非法证据排除在实践中很难操作，法官往往更重视实体真实，程序正义容易被忽视。', 18, 'normal', '2025-02-18 17:45:00', '2025-02-19 13:20:00');
INSERT INTO `forum_comments` VALUES (10, 4, NULL, 9, '吴刚', '张律师提到的指导案例很有参考价值，能否分享具体的案例编号？', 5, 'normal', '2025-02-19 15:30:00', '2025-02-20 11:45:00');
INSERT INTO `forum_comments` VALUES (11, 4, 9, 1, '张正义', '可以参考最高人民法院指导案例第24号、第27号，以及《刑事审判参考》第98集的相关案例。', 7, 'normal', '2025-02-20 10:15:00', '2025-02-21 14:30:00');
INSERT INTO `forum_comments` VALUES (12, 5, NULL, 10, '郑秀英', '作为刚入行的律师，林律师的分享对我很有启发，特别是客户沟通这部分。', 11, 'normal', '2025-02-20 14:20:00', '2025-02-21 09:40:00');
INSERT INTO `forum_comments` VALUES (13, 5, NULL, 11, '钱程', '专业深耕很重要，但刚开始执业时往往需要什么案子都接，如何平衡专业化和生存问题？', 8, 'normal', '2025-02-21 12:35:00', '2025-02-22 16:15:00');
INSERT INTO `forum_comments` VALUES (14, 5, 11, 17, '林仲裁', '建议先从某一领域入手，同时不排斥其他案件，随着经验积累逐步向专业化过渡。', 6, 'normal', '2025-02-22 08:50:00', '2025-02-23 11:25:00');
INSERT INTO `forum_comments` VALUES (15, 6, NULL, 12, '冯丽', '民法典合同编确实变化很大，我们法务部门最近正在组织学习，这篇文章很及时。', 14, 'normal', '2025-02-22 16:45:00', '2025-02-23 13:10:00');
INSERT INTO `forum_comments` VALUES (16, 6, NULL, 13, '陈明', '格式条款的提示说明义务要求更高了，这对消费者是利好，但对企业来说合规成本增加了。', 9, 'normal', '2025-02-23 14:20:00', '2025-02-24 10:35:00');
INSERT INTO `forum_comments` VALUES (17, 7, NULL, 14, '杨帆', 'AI生成物的著作权问题确实很前沿，国内外判例还不一致，期待立法能够明确。', 16, 'normal', '2025-02-25 11:30:00', '2025-02-26 15:45:00');
INSERT INTO `forum_comments` VALUES (18, 7, NULL, 15, '朱建国', '如果AI生成物不能获得著作权保护，是否会打击AI研发的积极性？', 7, 'normal', '2025-02-26 09:15:00', '2025-02-27 12:20:00');
INSERT INTO `forum_comments` VALUES (19, 7, 15, 22, '高知产', '可以考虑通过反不正当竞争法、商业秘密等其他方式保护，不一定非要局限于著作权。', 5, 'normal', '2025-02-27 14:40:00', '2025-02-28 09:55:00');
INSERT INTO `forum_comments` VALUES (20, 8, NULL, 16, '秦小月', '劳动仲裁中证据确实很关键，我们公司最近有个案子就因为考勤记录不全而败诉。', 10, 'normal', '2025-02-28 15:10:00', '2025-03-01 11:25:00');
INSERT INTO `forum_comments` VALUES (21, 8, NULL, 17, '何志强', '电子证据的认定也比较复杂，微信聊天记录、电子邮件等如何保证真实性和完整性？', 6, 'normal', '2025-03-01 13:45:00', '2025-03-02 16:30:00');
INSERT INTO `forum_comments` VALUES (22, 9, NULL, 18, '林晓雨', '跨境电商的法律风险确实很多，我们在东南亚市场就遇到过消费者权益保护的纠纷。', 8, 'normal', '2025-03-02 12:20:00', '2025-03-03 09:35:00');
INSERT INTO `forum_comments` VALUES (23, 9, NULL, 19, '马文涛', '不同国家的法律差异很大，建议做跨境电商的企业一定要了解目标市场的法律规定。', 5, 'normal', '2025-03-03 15:55:00', '2025-03-04 14:10:00');
INSERT INTO `forum_comments` VALUES (25, 10, NULL, 21, '黄伟', '环境污染的损害鉴定和评估也是难点，希望有更科学的评估方法和标准。', 4, 'normal', '2025-03-06 14:30:00', '2025-03-07 12:45:00');
INSERT INTO `forum_comments` VALUES (26, 11, NULL, 22, '徐芳', '医疗纠纷调解确实需要医学知识，我们律所专门聘请了医学顾问来支持这类案件。', 9, 'normal', '2025-03-08 13:40:00', '2025-03-09 15:55:00');
INSERT INTO `forum_comments` VALUES (27, 11, NULL, 23, '高建军', '调解比诉讼更有利于维护医患关系，但有时候患者情绪激动，很难进行有效沟通。', 6, 'normal', '2025-03-09 11:25:00', '2025-03-10 09:40:00');
INSERT INTO `forum_comments` VALUES (28, 12, NULL, 24, '唐雪', '我们公司有几个主播，与MCN机构的合同纠纷不断，这个分析很及时。', 11, 'normal', '2025-03-10 17:20:00', '2025-03-11 13:35:00');
INSERT INTO `forum_comments` VALUES (29, 12, NULL, 25, '罗志祥', '主播跳槽引发的违约赔偿问题也很常见，违约金如何确定才合理？', 7, 'normal', '2025-03-11 15:45:00', '2025-03-12 11:10:00');
INSERT INTO `forum_comments` VALUES (30, 12, 25, 29, '苏网络', '违约金需要考虑主播的实际收入、机构投入成本、剩余合同期限等因素综合确定。', 5, 'normal', '2025-03-12 10:20:00', '2025-03-13 14:45:00');
INSERT INTO `forum_comments` VALUES (31, 13, NULL, 26, '韩梅梅', '金税四期上线后，税务稽查更严格了，企业必须重视合规管理。', 8, 'normal', '2025-03-12 11:55:00', '2025-03-13 16:20:00');
INSERT INTO `forum_comments` VALUES (32, 13, NULL, 27, '谢文东', '虚开发票的风险特别大，我们行业就有企业因为这个问题被查处。', 5, 'normal', '2025-03-13 14:10:00', '2025-03-14 09:35:00');
INSERT INTO `forum_comments` VALUES (33, 14, NULL, 28, '董丽华', '国际仲裁的保密性是其重要优势，特别适合涉及商业秘密的商业纠纷。', 6, 'normal', '2025-03-15 15:35:00', '2025-03-16 12:50:00');
INSERT INTO `forum_comments` VALUES (34, 14, NULL, 29, '梁超', '仲裁裁决的执行也是问题，特别是跨国执行，虽然纽约公约覆盖了很多国家。', 4, 'normal', '2025-03-16 13:20:00', '2025-03-17 10:45:00');
INSERT INTO `forum_comments` VALUES (35, 15, NULL, 30, '苏小雅', '认罪认罚制度提高了司法效率，但也要防止强迫认罪、虚假认罪的问题。', 9, 'normal', '2025-03-18 12:05:00', '2025-03-19 14:30:00');
INSERT INTO `forum_comments` VALUES (36, 15, NULL, 31, '潘建国', '律师在认罪认罚程序中的作用很重要，要确保当事人是在充分了解后果后自愿认罪。', 6, 'normal', '2025-03-19 10:40:00', '2025-03-20 09:15:00');
INSERT INTO `forum_comments` VALUES (37, 16, NULL, 32, '杜娟', '离婚冷静期确实降低了一时冲动的离婚，但也让一些真正需要离婚的人增加了困难。', 12, 'normal', '2025-03-20 16:45:00', '2025-03-21 13:10:00');
INSERT INTO `forum_comments` VALUES (38, 16, NULL, 33, '陆天明', '家暴案件是否适用离婚冷静期？这是个需要明确的问题。', 8, 'normal', '2025-03-21 14:20:00', '2025-03-22 11:35:00');
INSERT INTO `forum_comments` VALUES (39, 16, 33, 19, '宋离婚', '根据民法典规定，家暴等特殊情况可以向法院申请不适用冷静期，但实践中操作不一。', 7, 'normal', '2025-03-22 09:55:00', '2025-03-23 15:20:00');
INSERT INTO `forum_comments` VALUES (40, 17, NULL, 34, '白洁', '房地产并购的尽职调查需要关注土地性质、规划许可、抵押查封等多个方面。', 5, 'normal', '2025-03-22 13:15:00', '2025-03-23 10:30:00');
INSERT INTO `forum_comments` VALUES (41, 18, NULL, 35, '袁弘', '平台用工的劳动关系认定标准确实模糊，不同法院的判决也不一致，需要统一标准。', 7, 'normal', '2025-03-25 17:45:00', '2025-03-26 14:10:00');
INSERT INTO `forum_comments` VALUES (47, 3, NULL, 1, '系统管理员', '221', 0, 'normal', '2026-02-05 10:51:30', '2026-02-05 11:06:41');
INSERT INTO `forum_comments` VALUES (48, 3, NULL, 1, '系统管理员', '1333', 1, 'normal', '2026-02-05 10:56:25', '2026-02-05 11:06:42');

-- ----------------------------
-- Table structure for forum_likes
-- ----------------------------
DROP TABLE IF EXISTS `forum_likes`;
CREATE TABLE `forum_likes`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '点赞ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `target_type` enum('post','comment') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '目标类型',
  `target_id` bigint NOT NULL COMMENT '目标ID(帖子ID或评论ID)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_target`(`user_id` ASC, `target_type` ASC, `target_id` ASC) USING BTREE,
  INDEX `idx_target`(`target_type` ASC, `target_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛点赞表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum_likes
-- ----------------------------
INSERT INTO `forum_likes` VALUES (1, 1, 'post', 1, '2025-02-10 15:30:00');
INSERT INTO `forum_likes` VALUES (2, 2, 'post', 1, '2025-02-10 16:15:00');
INSERT INTO `forum_likes` VALUES (3, 3, 'post', 2, '2025-02-12 11:20:00');
INSERT INTO `forum_likes` VALUES (4, 4, 'post', 3, '2025-02-15 10:30:00');
INSERT INTO `forum_likes` VALUES (5, 5, 'post', 3, '2025-02-16 09:45:00');
INSERT INTO `forum_likes` VALUES (6, 6, 'post', 4, '2025-02-18 17:10:00');
INSERT INTO `forum_likes` VALUES (7, 7, 'post', 5, '2025-02-20 12:25:00');
INSERT INTO `forum_likes` VALUES (8, 8, 'post', 6, '2025-02-22 16:15:00');
INSERT INTO `forum_likes` VALUES (9, 9, 'post', 7, '2025-02-25 10:05:00');
INSERT INTO `forum_likes` VALUES (10, 10, 'post', 8, '2025-02-28 14:40:00');
INSERT INTO `forum_likes` VALUES (11, 1, 'comment', 1, '2025-02-10 17:20:00');
INSERT INTO `forum_likes` VALUES (12, 2, 'comment', 2, '2025-02-11 10:15:00');
INSERT INTO `forum_likes` VALUES (13, 3, 'comment', 3, '2025-02-11 15:30:00');
INSERT INTO `forum_likes` VALUES (14, 4, 'comment', 4, '2025-02-12 16:05:00');
INSERT INTO `forum_likes` VALUES (15, 5, 'comment', 5, '2025-02-13 11:10:00');
INSERT INTO `forum_likes` VALUES (16, 6, 'comment', 6, '2025-02-15 15:20:00');
INSERT INTO `forum_likes` VALUES (17, 7, 'comment', 7, '2025-02-16 12:35:00');
INSERT INTO `forum_likes` VALUES (18, 8, 'comment', 8, '2025-02-17 10:25:00');
INSERT INTO `forum_likes` VALUES (19, 9, 'comment', 9, '2025-02-18 18:15:00');
INSERT INTO `forum_likes` VALUES (20, 10, 'comment', 10, '2025-02-19 16:30:00');
INSERT INTO `forum_likes` VALUES (21, 11, 'post', 9, '2025-03-02 11:40:00');
INSERT INTO `forum_likes` VALUES (22, 12, 'post', 10, '2025-03-05 15:35:00');
INSERT INTO `forum_likes` VALUES (23, 13, 'post', 11, '2025-03-08 12:50:00');
INSERT INTO `forum_likes` VALUES (24, 14, 'post', 12, '2025-03-10 17:05:00');
INSERT INTO `forum_likes` VALUES (25, 15, 'post', 13, '2025-03-12 10:55:00');
INSERT INTO `forum_likes` VALUES (26, 16, 'post', 14, '2025-03-15 15:20:00');
INSERT INTO `forum_likes` VALUES (27, 17, 'post', 15, '2025-03-18 11:25:00');
INSERT INTO `forum_likes` VALUES (28, 18, 'post', 16, '2025-03-20 16:15:00');
INSERT INTO `forum_likes` VALUES (29, 19, 'post', 17, '2025-03-22 12:40:00');
INSERT INTO `forum_likes` VALUES (30, 20, 'post', 18, '2025-03-25 17:30:00');
INSERT INTO `forum_likes` VALUES (31, 11, 'comment', 11, '2025-02-20 11:15:00');
INSERT INTO `forum_likes` VALUES (32, 12, 'comment', 12, '2025-02-20 15:10:00');
INSERT INTO `forum_likes` VALUES (33, 13, 'comment', 13, '2025-02-21 13:25:00');
INSERT INTO `forum_likes` VALUES (34, 14, 'comment', 14, '2025-02-22 09:40:00');
INSERT INTO `forum_likes` VALUES (35, 15, 'comment', 15, '2025-02-22 17:15:00');
INSERT INTO `forum_likes` VALUES (36, 16, 'comment', 16, '2025-02-23 14:20:00');
INSERT INTO `forum_likes` VALUES (37, 17, 'comment', 17, '2025-02-25 12:30:00');
INSERT INTO `forum_likes` VALUES (38, 18, 'comment', 18, '2025-02-26 10:45:00');
INSERT INTO `forum_likes` VALUES (39, 19, 'comment', 19, '2025-02-27 15:20:00');
INSERT INTO `forum_likes` VALUES (40, 20, 'comment', 20, '2025-02-28 16:35:00');
INSERT INTO `forum_likes` VALUES (41, 21, 'post', 19, '2025-03-28 14:10:00');
INSERT INTO `forum_likes` VALUES (42, 22, 'post', 20, '2025-03-30 10:25:00');
INSERT INTO `forum_likes` VALUES (43, 23, 'post', 21, '2025-04-01 15:40:00');
INSERT INTO `forum_likes` VALUES (44, 24, 'post', 22, '2025-04-03 11:55:00');
INSERT INTO `forum_likes` VALUES (45, 25, 'post', 23, '2025-04-05 16:20:00');
INSERT INTO `forum_likes` VALUES (46, 26, 'post', 24, '2025-04-08 12:15:00');
INSERT INTO `forum_likes` VALUES (47, 27, 'post', 25, '2025-04-10 17:30:00');
INSERT INTO `forum_likes` VALUES (48, 28, 'post', 1, '2025-04-12 13:45:00');
INSERT INTO `forum_likes` VALUES (49, 29, 'post', 2, '2025-04-15 09:10:00');
INSERT INTO `forum_likes` VALUES (50, 30, 'post', 3, '2025-04-18 14:25:00');

-- ----------------------------
-- Table structure for forum_posts
-- ----------------------------
DROP TABLE IF EXISTS `forum_posts`;
CREATE TABLE `forum_posts`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帖子内容',
  `author_id` bigint NOT NULL COMMENT '作者ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者姓名',
  `category_id` int NULL DEFAULT NULL COMMENT '分类ID',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签，逗号分隔',
  `view_count` int NULL DEFAULT 0 COMMENT '浏览次数',
  `like_count` int NULL DEFAULT 0 COMMENT '点赞数',
  `comment_count` int NULL DEFAULT 0 COMMENT '评论数',
  `is_top` tinyint NULL DEFAULT 0 COMMENT '是否置顶(0-否,1-是)',
  `status` enum('draft','published','deleted') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'published' COMMENT '状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_author_id`(`author_id` ASC) USING BTREE,
  INDEX `idx_category_id`(`category_id` ASC) USING BTREE,
  INDEX `idx_status`(`status` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛帖子表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum_posts
-- ----------------------------
INSERT INTO `forum_posts` VALUES (3, '最新《数据安全法》对企业的影响', '《数据安全法》自2021年9月1日起施行，对企业数据合规提出了新要求。本文解读法律要点，分析企业应如何建立数据安全管理制度...', 4, '赵敏', 3, '数据安全法,企业合规,数据保护', 2100, 156, 42, 1, 'published', '2025-02-15 09:45:00', '2025-02-25 16:10:00');
INSERT INTO `forum_posts` VALUES (4, '刑事案件中非法证据排除规则适用', '非法证据排除是刑事辩护的重要武器。本文结合最高法院指导案例，分析实践中如何申请排除非法证据以及法官的审查标准...', 1, '张正义', 4, '刑事辩护,非法证据,程序正义', 850, 48, 12, 0, 'published', '2025-02-18 16:20:00', '2026-02-05 11:23:32');
INSERT INTO `forum_posts` VALUES (5, '青年律师如何快速成长', '作为从业5年的青年律师，分享我的成长经验：从案件管理、客户沟通到专业深耕，希望能给刚入行的同行一些启发...', 17, '林仲裁', 5, '青年律师,职业发展,经验分享', 920, 81, 20, 0, 'published', '2025-02-20 11:10:00', '2026-02-05 11:23:39');
INSERT INTO `forum_posts` VALUES (6, '民法典时代合同审查要点解析', '《民法典》对合同编进行了重大修改。本文梳理了合同审查的十个要点，包括格式条款、违约责任、争议解决等核心条款的审查技巧...', 7, '孙合同', 6, '民法典,合同审查,法律实务', 1750, 112, 35, 0, 'published', '2025-02-22 15:30:00', '2025-03-05 14:40:00');
INSERT INTO `forum_posts` VALUES (7, 'AI生成物的著作权保护问题探讨', '随着人工智能技术的发展，AI生成物是否受著作权保护成为热点问题。本文分析国内外相关案例，探讨法律应对之策...', 22, '高知产', 7, '人工智能,著作权,知识产权', 1430, 95, 28, 0, 'published', '2025-02-25 09:15:00', '2025-03-08 13:25:00');
INSERT INTO `forum_posts` VALUES (8, '劳动仲裁中的证据收集技巧', '劳动仲裁案件中，证据往往决定胜负。本文分享劳动合同、工资单、考勤记录等关键证据的收集方法及举证技巧...', 6, '陈明理', 4, '劳动仲裁,证据收集,劳动争议', 890, 56, 15, 0, 'published', '2025-02-28 13:45:00', '2025-03-10 10:50:00');
INSERT INTO `forum_posts` VALUES (9, '跨境电子商务的法律风险与防范', '跨境电商涉及海关、税务、消费者权益等多重法律问题。本文分析主要风险点，并提出合同设计、合规管理等防范措施...', 12, '陈国际', 2, '跨境电商,法律风险,国际贸易', 760, 42, 10, 0, 'published', '2025-03-02 10:25:00', '2025-03-12 16:05:00');
INSERT INTO `forum_posts` VALUES (10, '环境公益诉讼的现状与展望', '环境公益诉讼是环境保护的重要法律武器。本文分析近年典型案例，探讨起诉主体、举证责任、损害赔偿等实践问题...', 13, '杨环境', 7, '环境公益诉讼,环境保护,典型案例', 680, 38, 8, 0, 'published', '2025-03-05 14:50:00', '2025-03-15 11:20:00');
INSERT INTO `forum_posts` VALUES (11, '医疗纠纷调解的技巧与策略', '医疗纠纷调解需要法律与医学知识的结合。本文分享调解原则、沟通技巧以及赔偿方案设计的实践经验...', 14, '朱医疗', 2, '医疗纠纷,调解技巧,医患关系', 950, 67, 22, 0, 'published', '2025-03-08 11:35:00', '2026-02-05 09:32:49');
INSERT INTO `forum_posts` VALUES (12, '网络主播与MCN机构的法律关系分析', '网络直播行业快速发展，主播与MCN机构之间的法律关系复杂。本文分析不同合作模式下的法律性质及权益保护...', 29, '苏网络', 1, '网络主播,MCN,法律关系', 1120, 89, 30, 0, 'published', '2025-03-10 16:05:00', '2025-03-20 09:40:00');
INSERT INTO `forum_posts` VALUES (13, '企业税务合规管理的法律要点', '金税四期背景下，企业税务合规日益重要。本文分析主要税务风险点，提出合规管理体系建设的法律建议...', 16, '何税务', 3, '税务合规,金税四期,企业管理', 830, 51, 14, 0, 'published', '2025-03-12 09:50:00', '2025-03-22 12:55:00');
INSERT INTO `forum_posts` VALUES (14, '国际商事仲裁的优势与程序', '与诉讼相比，国际商事仲裁具有诸多优势。本文介绍仲裁特点、程序以及仲裁条款的起草要点...', 17, '林仲裁', 4, '国际仲裁,商事纠纷,争议解决', 720, 40, 9, 0, 'published', '2025-03-15 14:15:00', '2025-03-25 15:10:00');
INSERT INTO `forum_posts` VALUES (15, '刑事案件认罪认罚从宽制度的适用', '认罪认罚从宽制度改变了刑事司法实践。本文分析适用条件、律师作用以及当事人权利保障问题...', 18, '马刑事', 3, '认罪认罚,刑事制度,司法改革', 780, 45, 11, 0, 'published', '2025-03-18 10:40:00', '2025-03-28 10:25:00');
INSERT INTO `forum_posts` VALUES (16, '离婚冷静期制度的实践效果评估', '离婚冷静期制度实施已满三年，本文通过数据分析其实施效果，探讨制度完善方向...', 19, '宋离婚', 7, '离婚冷静期,婚姻法,社会效果', 1250, 92, 32, 0, 'published', '2025-03-20 15:20:00', '2025-03-30 13:45:00');
INSERT INTO `forum_posts` VALUES (17, '房地产项目并购的法律尽职调查', '房地产项目并购涉及复杂法律问题。本文分享尽职调查的重点内容、常见风险及应对策略...', 20, '黄房产', 2, '房地产,并购,尽职调查', 690, 39, 7, 0, 'published', '2025-03-22 11:55:00', '2025-04-01 16:30:00');
INSERT INTO `forum_posts` VALUES (18, '灵活用工模式下的劳动关系认定', '平台经济催生多种灵活用工模式。本文分析不同模式下劳动关系的认定标准及法律风险防范...', 21, '徐劳动', 1, '灵活用工,劳动关系,平台经济', 1040, 74, 26, 0, 'published', '2025-03-25 16:30:00', '2025-04-05 11:15:00');
INSERT INTO `forum_posts` VALUES (19, '商业秘密保护的法律策略', '商业秘密是企业核心竞争力的体现。本文从制度建设、合同保护、诉讼维权等角度探讨商业秘密保护策略...', 22, '高知产', 6, '商业秘密,知识产权,企业保护', 880, 58, 17, 0, 'published', '2025-03-28 13:10:00', '2025-04-08 14:20:00');
INSERT INTO `forum_posts` VALUES (20, '破产重整中债权人的权益保护', '企业破产重整涉及多方利益平衡。本文分析债权人在重整程序中的权利、表决机制及权益保护途径...', 23, '唐公司', 2, '破产重整,债权人,权益保护', 610, 34, 6, 0, 'published', '2025-03-30 09:45:00', '2025-04-10 09:50:00');
INSERT INTO `forum_posts` VALUES (21, '行政诉讼中的规范性文件审查', '行政诉讼中常涉及规范性文件的合法性审查。本文分析审查标准、程序及对案件的影响...', 24, '罗行政', 3, '行政诉讼,规范性文件,司法审查', 550, 31, 5, 0, 'published', '2025-04-01 14:25:00', '2025-04-12 12:40:00');
INSERT INTO `forum_posts` VALUES (22, '虚拟货币相关犯罪的法律认定', '虚拟货币犯罪呈现新特点。本文分析盗窃、诈骗、传销等涉虚拟货币犯罪的司法认定难点...', 25, '韩金融', 7, '虚拟货币,金融犯罪,司法认定', 1340, 98, 38, 0, 'published', '2025-04-03 10:05:00', '2025-04-15 15:05:00');
INSERT INTO `forum_posts` VALUES (23, '涉外婚姻的法律适用问题', '涉外婚姻涉及国际私法规则。本文分析结婚实质要件、形式要件以及离婚的法律适用问题...', 26, '谢国际', 1, '涉外婚姻,国际私法,法律适用', 740, 47, 13, 0, 'published', '2025-04-05 15:40:00', '2025-04-18 10:30:00');
INSERT INTO `forum_posts` VALUES (24, '药品专利链接制度的实施影响', '药品专利链接制度影响仿制药上市。本文分析制度内容、实施效果及对医药行业的影响...', 27, '董医疗', 3, '药品专利,仿制药,医药行业', 670, 41, 9, 0, 'published', '2025-04-08 11:20:00', '2025-04-20 13:15:00');
INSERT INTO `forum_posts` VALUES (25, '碳排放权交易的法律规制', '全国碳市场正式启动。本文分析碳排放权法律性质、交易规则及监管体系...', 28, '梁环境', 7, '碳排放权,碳交易,环境保护', 590, 36, 7, 0, 'published', '2025-04-10 16:50:00', '2025-04-22 16:45:00');
INSERT INTO `forum_posts` VALUES (28, '1234567', '345632456789', 1, '系统管理员', 1, NULL, 0, 0, 0, 0, 'published', '2026-02-05 09:35:34', '2026-02-05 09:35:34');

-- ----------------------------
-- Table structure for forum_views
-- ----------------------------
DROP TABLE IF EXISTS `forum_views`;
CREATE TABLE `forum_views`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '浏览记录ID',
  `post_id` bigint NOT NULL COMMENT '帖子ID',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID(可选，未登录用户可为空)',
  `ip_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '浏览时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_post_id`(`post_id` ASC) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_ip_address`(`ip_address` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛浏览记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum_views
-- ----------------------------
INSERT INTO `forum_views` VALUES (1, 1, 1, '192.168.1.100', '2025-02-10 14:31:00');
INSERT INTO `forum_views` VALUES (2, 1, 2, '192.168.1.101', '2025-02-10 15:45:00');
INSERT INTO `forum_views` VALUES (3, 1, 3, '192.168.1.102', '2025-02-11 09:20:00');
INSERT INTO `forum_views` VALUES (4, 2, 4, '192.168.1.103', '2025-02-12 10:16:00');
INSERT INTO `forum_views` VALUES (5, 2, 5, '192.168.1.104', '2025-02-13 14:30:00');
INSERT INTO `forum_views` VALUES (6, 3, 6, '192.168.1.105', '2025-02-15 09:46:00');
INSERT INTO `forum_views` VALUES (7, 3, 7, '192.168.1.106', '2025-02-16 11:25:00');
INSERT INTO `forum_views` VALUES (8, 4, 8, '192.168.1.107', '2025-02-18 16:21:00');
INSERT INTO `forum_views` VALUES (9, 4, 9, '192.168.1.108', '2025-02-19 10:15:00');
INSERT INTO `forum_views` VALUES (10, 5, 10, '192.168.1.109', '2025-02-20 11:11:00');
INSERT INTO `forum_views` VALUES (11, 5, 11, '192.168.1.110', '2025-02-21 14:40:00');
INSERT INTO `forum_views` VALUES (12, 6, 12, '192.168.1.111', '2025-02-22 15:31:00');
INSERT INTO `forum_views` VALUES (13, 6, 13, '192.168.1.112', '2025-02-23 09:25:00');
INSERT INTO `forum_views` VALUES (14, 7, 14, '192.168.1.113', '2025-02-25 09:16:00');
INSERT INTO `forum_views` VALUES (15, 7, 15, '192.168.1.114', '2025-02-26 13:30:00');
INSERT INTO `forum_views` VALUES (16, 8, 16, '192.168.1.115', '2025-02-28 13:46:00');
INSERT INTO `forum_views` VALUES (17, 8, 17, '192.168.1.116', '2025-03-01 15:20:00');
INSERT INTO `forum_views` VALUES (18, 9, 18, '192.168.1.117', '2025-03-02 10:26:00');
INSERT INTO `forum_views` VALUES (19, 9, 19, '192.168.1.118', '2025-03-03 11:45:00');
INSERT INTO `forum_views` VALUES (20, 10, 20, '192.168.1.119', '2025-03-05 14:51:00');
INSERT INTO `forum_views` VALUES (21, 10, 21, '192.168.1.120', '2025-03-06 16:10:00');
INSERT INTO `forum_views` VALUES (22, 11, 22, '192.168.1.121', '2025-03-08 11:36:00');
INSERT INTO `forum_views` VALUES (23, 11, 23, '192.168.1.122', '2025-03-09 14:25:00');
INSERT INTO `forum_views` VALUES (24, 12, 24, '192.168.1.123', '2025-03-10 16:06:00');
INSERT INTO `forum_views` VALUES (25, 12, 25, '192.168.1.124', '2025-03-11 10:30:00');
INSERT INTO `forum_views` VALUES (26, 13, 26, '192.168.1.125', '2025-03-12 09:51:00');
INSERT INTO `forum_views` VALUES (27, 13, 27, '192.168.1.126', '2025-03-13 15:40:00');
INSERT INTO `forum_views` VALUES (28, 14, 28, '192.168.1.127', '2025-03-15 14:16:00');
INSERT INTO `forum_views` VALUES (29, 14, 29, '192.168.1.128', '2025-03-16 11:25:00');
INSERT INTO `forum_views` VALUES (30, 15, 30, '192.168.1.129', '2025-03-18 10:41:00');
INSERT INTO `forum_views` VALUES (31, 15, 31, '192.168.1.130', '2025-03-19 14:20:00');
INSERT INTO `forum_views` VALUES (32, 16, 32, '192.168.1.131', '2025-03-20 15:21:00');
INSERT INTO `forum_views` VALUES (33, 16, 33, '192.168.1.132', '2025-03-21 09:30:00');
INSERT INTO `forum_views` VALUES (34, 17, 34, '192.168.1.133', '2025-03-22 11:56:00');
INSERT INTO `forum_views` VALUES (35, 17, 35, '192.168.1.134', '2025-03-23 16:15:00');
INSERT INTO `forum_views` VALUES (36, 18, 36, '192.168.1.135', '2025-03-25 16:31:00');
INSERT INTO `forum_views` VALUES (37, 18, 37, '192.168.1.136', '2025-03-26 10:40:00');
INSERT INTO `forum_views` VALUES (38, 19, 38, '192.168.1.137', '2025-03-28 13:11:00');
INSERT INTO `forum_views` VALUES (39, 19, 39, '192.168.1.138', '2025-03-29 14:25:00');
INSERT INTO `forum_views` VALUES (40, 20, 40, '192.168.1.139', '2025-03-30 09:46:00');
INSERT INTO `forum_views` VALUES (41, 20, 1, '192.168.1.100', '2025-03-31 11:30:00');
INSERT INTO `forum_views` VALUES (42, 21, 2, '192.168.1.101', '2025-04-01 14:26:00');
INSERT INTO `forum_views` VALUES (43, 21, 3, '192.168.1.102', '2025-04-02 15:45:00');
INSERT INTO `forum_views` VALUES (44, 22, 4, '192.168.1.103', '2025-04-03 10:06:00');
INSERT INTO `forum_views` VALUES (45, 22, 5, '192.168.1.104', '2025-04-04 13:20:00');
INSERT INTO `forum_views` VALUES (46, 23, 6, '192.168.1.105', '2025-04-05 15:41:00');
INSERT INTO `forum_views` VALUES (47, 23, 7, '192.168.1.106', '2025-04-06 09:35:00');
INSERT INTO `forum_views` VALUES (48, 24, 8, '192.168.1.107', '2025-04-08 11:21:00');
INSERT INTO `forum_views` VALUES (49, 25, 9, '192.168.1.108', '2025-04-10 16:51:00');

-- ----------------------------
-- Table structure for law_case
-- ----------------------------
DROP TABLE IF EXISTS `law_case`;
CREATE TABLE `law_case`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '案件id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '案件名',
  `category` int NULL DEFAULT NULL COMMENT '案件类型：1表示刑事案件，2表示民事案件，3表示行政案件',
  `client_id` bigint NULL DEFAULT NULL COMMENT '逻辑外键客户id',
  `is_final` int NULL DEFAULT NULL COMMENT '是否结案，0表示结案，1代表未结案',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '案件描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `lawer_id` bigint NULL DEFAULT NULL COMMENT '委托律师id',
  `is_entrust` int NULL DEFAULT NULL COMMENT '是否已经委托，0代表没有，1表示已委托',
  `audit_response` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核回复',
  `audit_status` int NULL DEFAULT NULL COMMENT '审核状态：0代表未审核，1代表已审核并通过，2代表已审核但由于某种原因未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of law_case
-- ----------------------------
INSERT INTO `law_case` VALUES (7, '孙八房屋买卖合同纠纷案', 1, 1, 1, '买方孙八起诉卖方周九，主张卖方隐瞒房屋抵押事实，要求解除合同并赔偿。', '2025-03-02 13:45:00', 1, 1, '合同纠纷事实清楚，同意接受委托。', 1);
INSERT INTO `law_case` VALUES (8, '吴十物业服务合同纠纷案', 1, 6, 0, '业主吴十起诉物业公司未履行维修义务，要求减免物业费并赔偿损失。', '2025-03-05 09:20:00', 1, 1, '物业服务纠纷常见，同意代理。', 1);
INSERT INTO `law_case` VALUES (9, '郑十一交通事故损害赔偿案', 2, 9, 0, '郑十一被货车撞伤，交警认定货车全责，双方就赔偿金额无法达成一致。', '2025-03-08 14:50:00', 9, 1, '人身损害赔偿案件，同意代理诉讼。', 1);
INSERT INTO `law_case` VALUES (10, '冯十二金融借款合同纠纷案', 2, 10, 1, '银行起诉冯十二未按约偿还贷款本息，要求提前收回贷款并实现抵押权。', '2025-03-10 11:30:00', 10, 1, '金融借款合同纠纷，材料齐全，同意代理。', 1);
INSERT INTO `law_case` VALUES (12, '杨十四反倾销调查应诉案', 2, 12, 0, '国内企业杨十四出口产品被欧盟发起反倾销调查，需要专业律师协助应诉。', '2025-03-15 13:40:00', 12, 1, '国际贸易案件复杂，需组建专业团队应对。', 1);
INSERT INTO `law_case` VALUES (13, '朱十五环境污染公益诉讼案', 2, 13, 0, '环保组织起诉化工厂朱十五违法排污，造成周边环境污染，要求停止侵害并赔偿。', '2025-03-18 15:45:00', 13, 1, '环境公益诉讼意义重大，同意代理。', 1);
INSERT INTO `law_case` VALUES (14, '秦十六医疗损害责任纠纷案', 2, 14, 1, '患者秦十六起诉医院手术失误致其伤残，要求医院承担损害赔偿责任。', '2025-03-20 09:55:00', 14, 1, '医疗纠纷专业性强，需医学专家辅助。', 1);
INSERT INTO `law_case` VALUES (15, '何十七网络数据泄露侵权案', 2, 15, 0, '何十七的个人信息被某平台泄露，起诉平台侵犯隐私权，要求赔礼道歉并赔偿。', '2025-03-22 13:20:00', 15, 1, '网络侵权案件新颖，同意代理。', 1);
INSERT INTO `law_case` VALUES (16, '林十八税务筹划合规审查案', 2, 16, 0, '企业林十八拟进行重大资产重组，需要律师对税务筹划方案进行合规审查。', '2025-03-25 15:50:00', 16, 1, '税务合规审查专业要求高，同意提供法律服务。', 1);
INSERT INTO `law_case` VALUES (17, '马十九商事仲裁案', 2, 17, 1, '马十九与合作伙伴因合资协议履行产生纠纷，根据仲裁条款提起商事仲裁。', '2025-03-28 10:30:00', 17, 1, '仲裁案件程序特殊，同意代理。', 1);
INSERT INTO `law_case` VALUES (18, '宋二十故意杀人案', 1, 18, 0, '被告人宋二十涉嫌故意杀害其妻子，案件事实复杂，存在多项疑点。', '2025-03-30 14:25:00', 18, 1, '死刑案件，需慎重审查，同意担任辩护人。', 1);
INSERT INTO `law_case` VALUES (19, '黄二十一家事调解案', 2, 19, 0, '黄二十一家庭内部因遗产继承产生纠纷，希望通过调解而非诉讼解决。', '2025-04-02 11:10:00', 19, 1, '家事调解有利于家庭和谐，同意提供调解服务。', 1);
INSERT INTO `law_case` VALUES (20, '徐二十二建筑工程合同纠纷案', 2, 20, 1, '承包人徐二十二起诉发包人拖欠工程款，工程已竣工验收合格。', '2025-04-05 15:55:00', 20, 1, '工程款纠纷常见，同意代理诉讼。', 1);
INSERT INTO `law_case` VALUES (21, '高二十三商业秘密侵权案', 2, 21, 0, '高二十三公司前员工带走技术资料加入竞争对手，涉嫌侵犯商业秘密。', '2025-04-08 10:40:00', 22, 1, '商业秘密案件取证困难，需制定周密策略。', 1);
INSERT INTO `law_case` VALUES (22, '唐二十四公司破产重整案', 2, 22, 0, '唐二十四公司资不抵债，向法院申请破产重整，需要专业律师担任管理人。', '2025-04-10 14:25:00', 23, 1, '破产重整案件复杂，同意担任管理人。', 1);
INSERT INTO `law_case` VALUES (23, '罗二十五行政处罚听证案', 3, 23, 0, '罗二十五因违规建设被规划部门处罚，申请举行听证程序陈述申辩。', '2025-04-12 11:30:00', 24, 1, '行政处罚听证代理，同意接受委托。', 1);
INSERT INTO `law_case` VALUES (24, '韩二十六非法吸收公众存款案', 1, 24, 0, '韩二十六涉嫌以高息为诱饵非法吸收公众存款，涉案金额巨大。', '2025-04-15 16:20:00', 25, 1, '涉众型经济犯罪，社会影响大，同意担任辩护人。', 1);
INSERT INTO `law_case` VALUES (25, '谢二十七涉外离婚案', 2, 25, 1, '谢二十七（中国籍）与配偶（美国籍）因感情破裂协议离婚，涉及跨境财产分割。', '2025-04-18 13:15:00', 26, 1, '涉外婚姻案件复杂，同意代理。', 1);
INSERT INTO `law_case` VALUES (26, '董二十八药品专利侵权案', 2, 26, 0, '董二十八公司起诉竞争对手侵犯其药品发明专利，要求停止侵权并赔偿损失。', '2025-04-20 10:50:00', 27, 1, '药品专利案件专业性强，同意代理。', 1);
INSERT INTO `law_case` VALUES (27, '梁二十九碳排放权交易纠纷案', 2, 27, 0, '梁二十九公司在碳排放权交易中与交易对方产生合同纠纷，要求继续履行合同。', '2025-04-22 15:35:00', 28, 1, '新型环境资源案件，具有代表性，同意代理。', 1);
INSERT INTO `law_case` VALUES (28, '苏三十电商平台责任纠纷案', 2, 28, 1, '消费者苏三十在电商平台购买到假冒产品，起诉平台要求承担连带责任。', '2025-04-25 11:20:00', 29, 1, '平台责任案件热点问题，同意代理。', 1);
INSERT INTO `law_case` VALUES (29, '潘三十一国际税收争议案', 2, 29, 0, '潘三十一公司在境外投资，与东道国税务当局就转让定价调整产生争议。', '2025-04-28 16:05:00', 30, 1, '国际税收争议专业性强，同意代理。', 1);
INSERT INTO `law_case` VALUES (30, '张三十二借款合同纠纷案', 2, 30, 0, '张三十二借给朋友50万元未还，起诉要求偿还本金及利息。', '2025-05-02 13:40:00', 1, 1, '民间借贷纠纷，事实清楚，同意代理。', 1);
INSERT INTO `law_case` VALUES (31, '李三十三离婚后财产纠纷案', 2, 31, 1, '李三十三与前妻离婚后发现未分割的夫妻共同财产，起诉要求重新分割。', '2025-05-05 10:15:00', 2, 1, '离婚后财产纠纷，同意代理。', 1);
INSERT INTO `law_case` VALUES (32, '王三十四股东出资纠纷案', 2, 32, 0, '王三十四作为公司股东未按约出资，被公司起诉要求履行出资义务并承担违约责任。', '2025-05-08 15:00:00', 3, 1, '股东出资纠纷，同意代理。', 1);
INSERT INTO `law_case` VALUES (33, '赵三十五商标异议复审案', 3, 33, 0, '赵三十五公司对商标局初步审定的某商标提出异议，商标局裁定异议不成立，申请复审。', '2025-05-10 11:45:00', 4, 1, '商标行政案件，同意代理复审。', 1);
INSERT INTO `law_case` VALUES (34, '刘三十六行政复议案', 3, 34, 0, '刘三十六对公安机关的行政处罚不服，向上一级公安机关申请行政复议。', '2025-05-12 16:30:00', 5, 1, '行政复议案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (35, '孙三十七工伤认定行政诉讼案', 3, 35, 1, '孙三十七工作中受伤，人社局不予认定工伤，提起行政诉讼要求撤销决定。', '2025-05-15 13:10:00', 6, 1, '工伤认定行政诉讼，同意代理。', 1);
INSERT INTO `law_case` VALUES (36, '周三十八合同诈骗案', 1, 36, 0, '周三十八以签订合同为名骗取对方财物，涉嫌合同诈骗罪被刑事拘留。', '2025-05-18 09:45:00', 7, 1, '经济犯罪案件，同意担任辩护人。', 1);
INSERT INTO `law_case` VALUES (37, '吴三十九物业管理纠纷案', 2, 37, 0, '吴三十九小区业主委员会起诉物业公司账目不清，要求公开账目并返还结余。', '2025-05-20 14:20:00', 8, 1, '物业纠纷案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (38, '郑四十产品质量责任案', 2, 38, 1, '郑四十购买的家电发生自燃造成财产损失，起诉生产商和销售商承担产品责任。', '2025-05-22 10:55:00', 9, 1, '产品质量案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (39, '冯四十一保险合同纠纷案', 2, 39, 0, '冯四十一车辆出险后保险公司拒赔，起诉保险公司要求履行保险合同。', '2025-05-25 15:40:00', 10, 1, '保险纠纷案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (40, '陈四十二船舶碰撞损害赔偿案', 2, 40, 0, '陈四十二的渔船与货轮发生碰撞沉没，起诉货轮船东要求赔偿损失。', '2025-05-28 12:25:00', 11, 1, '海事案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (41, '杨四十三反垄断调查应对案', 2, 1, 1, '杨四十三公司被反垄断执法机构立案调查，需要律师协助应对调查。', '2025-06-01 09:00:00', 12, 1, '反垄断案件专业性强，同意提供法律服务。', 1);
INSERT INTO `law_case` VALUES (42, '朱四十四医疗美容纠纷案', 2, 2, 0, '朱四十四在某医美机构进行整形手术失败，起诉机构医疗损害责任纠纷。', '2025-06-05 14:45:00', 14, 1, '医美纠纷案件增多，同意代理。', 1);
INSERT INTO `law_case` VALUES (43, '秦四十五个人信息保护公益诉讼案', 2, 3, 0, '秦四十五作为消费者代表起诉某App违规收集使用个人信息，提起公益诉讼。', '2025-06-08 11:30:00', 15, 1, '个人信息保护公益诉讼，具有示范意义，同意代理。', 1);
INSERT INTO `law_case` VALUES (44, '何四十六税务行政诉讼案', 3, 4, 1, '何四十六企业对税务机关的纳税决定不服，提起行政诉讼要求撤销。', '2025-06-10 16:15:00', 16, 1, '税务行政诉讼，同意代理。', 1);
INSERT INTO `law_case` VALUES (45, '林四十七国际投资仲裁案', 2, 5, 0, '林四十七公司在海外投资被东道国征收，根据投资协定提起国际投资仲裁。', '2025-06-12 13:50:00', 17, 1, '国际投资仲裁，同意代理。', 1);
INSERT INTO `law_case` VALUES (46, '马四十八毒品犯罪案', 1, 6, 0, '马四十八涉嫌贩卖毒品，数量较大，可能判处重刑。', '2025-06-15 10:25:00', 18, 1, '毒品犯罪案件，同意担任辩护人。', 1);
INSERT INTO `law_case` VALUES (47, '宋四十九遗嘱继承纠纷案', 2, 7, 1, '宋四十九兄弟姐妹因父亲遗嘱效力产生纠纷，起诉要求确认遗嘱无效。', '2025-06-18 15:10:00', 19, 1, '继承纠纷案件，同意代理。', 1);
INSERT INTO `law_case` VALUES (48, '黄五十建设工程质量纠纷案', 2, 8, 0, '黄五十购买的商品房出现严重质量问题，起诉开发商要求修复并赔偿。', '2025-06-20 11:55:00', 20, 1, '商品房质量纠纷，同意代理。', 1);
INSERT INTO `law_case` VALUES (49, '马家村税务案', 3, 13, 1, '无', '2026-02-02 13:14:27', 16, 2, '材料不全', 2);
INSERT INTO `law_case` VALUES (50, '何家村', 3, 3, 1, '', '2026-02-02 13:42:37', 4, 1, '2', 1);
INSERT INTO `law_case` VALUES (51, '刘家村', 2, 2, 1, '', '2026-02-02 13:43:03', 3, 1, '', 1);
INSERT INTO `law_case` VALUES (58, '李四与王五测试纠纷', 2, 2, 0, '', '2026-02-02 19:27:16', 3, 0, '符合起诉条件，同意接受委托代理。', 0);
INSERT INTO `law_case` VALUES (59, '12', 1, 1, 0, '', '2026-02-02 20:14:56', 3, 1, '', 1);
INSERT INTO `law_case` VALUES (60, '2', 1, 2, 0, '', '2026-02-02 20:59:28', 3, 2, '', 2);
INSERT INTO `law_case` VALUES (61, '2', 1, 2, 0, '', '2026-02-02 21:16:00', 3, 2, '', 2);

-- ----------------------------
-- Table structure for lawyer
-- ----------------------------
DROP TABLE IF EXISTS `lawyer`;
CREATE TABLE `lawyer`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '律师id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '律师姓名',
  `sex` smallint NULL DEFAULT NULL COMMENT '律师性别，1表示男，0表示女',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `identification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像地址',
  `biography` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
  `expenses` decimal(18, 2) NULL DEFAULT NULL COMMENT '律师费用【单位：元】',
  `business` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专项业务',
  `state` int NULL DEFAULT NULL COMMENT '0表示是游客状态，1表示入驻状态',
  `years` int NULL DEFAULT NULL COMMENT '工作年限',
  `create_time` datetime NULL DEFAULT NULL COMMENT '入驻时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lawyer
-- ----------------------------
INSERT INTO `lawyer` VALUES (1, '张正义', 1, '13900139001', NULL, '北京市朝阳区东三环中路', NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-15 10:00:00');
INSERT INTO `lawyer` VALUES (3, '王法明', 1, '13900139003', '110103197503033456', '广州市天河区体育东路', 'lawyer_003.jpg', '公司法资深律师，曾任多家上市公司法律顾问，擅长企业并购、股权架构设计。', 8000.00, '公司法,企业并购', 1, 25, '2019-11-10 09:15:00');
INSERT INTO `lawyer` VALUES (4, '赵维权', 1, '13900139004', '110104198804044567', '深圳市南山区科技南一路', 'lawyer_004.jpg', '知识产权专业律师，专利代理人资格，擅长专利侵权诉讼、商标异议复审。', 4500.00, '知识产权,专利诉讼', 1, 12, '2021-05-18 16:45:00');
INSERT INTO `lawyer` VALUES (5, '刘公正', 1, '13900139005', '110105199005055678', '杭州市西湖区文二路', 'lawyer_005.jpg', '行政法专业律师，浙江省行政法学会理事，擅长行政复议、行政诉讼。', 3500.00, '行政法,行政诉讼', 1, 10, '2021-08-22 11:20:00');
INSERT INTO `lawyer` VALUES (6, '陈明理', 1, '13900139006', '110106198606066789', '南京市鼓楼区山西路', 'lawyer_006.jpg', '劳动法专家，江苏省劳动法专业委员会副主任，擅长劳动争议仲裁、集体谈判。', 2800.00, '劳动法,劳动争议', 1, 14, '2020-07-30 13:40:00');
INSERT INTO `lawyer` VALUES (7, '孙合同', 1, '13900139007', '110107197907077890', '成都市武侯区人民南路', 'lawyer_007.jpg', '合同法资深律师，四川省合同法研究会常务理事，擅长重大合同谈判、合同纠纷诉讼。', 6000.00, '合同法,商事仲裁', 1, 21, '2019-09-12 15:10:00');
INSERT INTO `lawyer` VALUES (9, '吴侵权', 1, '13900139009', '110109198209099012', '西安市雁塔区小寨西路', 'lawyer_009.jpg', '侵权责任法专家，陕西省侵权法学会秘书长，擅长人身损害赔偿、产品责任诉讼。', 2700.00, '侵权责任,损害赔偿', 1, 13, '2020-10-08 14:55:00');
INSERT INTO `lawyer` VALUES (10, '郑金融', 1, '13900139010', '110110199310101123', '重庆市渝中区解放碑', 'lawyer_010.jpg', '金融证券律师，具有证券从业资格，擅长IPO、债券发行、金融衍生品交易。', 9000.00, '金融证券,资本市场', 1, 7, '2022-06-25 09:45:00');
INSERT INTO `lawyer` VALUES (11, '冯海商', 1, '13900139011', '110111197411111234', '天津市滨海新区塘沽', 'lawyer_011.jpg', '海事海商律师，中国海商法协会理事，擅长船舶碰撞、海上货物运输纠纷。', 5500.00, '海事海商,保险法', 1, 26, '2018-12-03 16:20:00');
INSERT INTO `lawyer` VALUES (12, '陈国际', 0, '13900139012', '110112198512121345', '青岛市市南区香港西路', 'lawyer_012.jpg', '国际贸易律师，精通英文和日文，擅长国际贸易纠纷、反倾销调查。', 7000.00, '国际贸易,跨境投资', 1, 11, '2021-03-19 12:05:00');
INSERT INTO `lawyer` VALUES (13, '杨环境', 1, '13900139013', '110113199613131456', '大连市中山区人民路', 'lawyer_013.jpg', '环境资源法律师，中华环保联合会法律专家，擅长环境公益诉讼、排污权交易。', 3800.00, '环境法,资源法', 1, 8, '2022-09-07 15:30:00');
INSERT INTO `lawyer` VALUES (14, '朱医疗', 0, '13900139014', '110114197714141567', '长沙市芙蓉区五一大道', 'lawyer_014.jpg', '医疗纠纷专业律师，医学学士+法律硕士，擅长医疗事故鉴定、医患纠纷调解。', 4200.00, '医疗纠纷,人身损害', 1, 18, '2020-04-11 11:15:00');
INSERT INTO `lawyer` VALUES (15, '秦网络', 1, '13900139015', '110115198815151678', '厦门市思明区湖滨北路', 'lawyer_015.jpg', '网络与数据法律师，中国网络空间安全协会法律顾问，擅长数据合规、网络安全法。', 4800.00, '网络法,数据合规', 1, 6, '2023-01-20 14:40:00');
INSERT INTO `lawyer` VALUES (16, '何税务', 1, '13900139016', '110116199916161789', '宁波市鄞州区钱湖南路', 'lawyer_016.jpg', '税务法律师，注册会计师，擅长税务筹划、税务争议解决。', 5200.00, '税法,税务筹划', 1, 5, '2023-04-15 10:25:00');
INSERT INTO `lawyer` VALUES (17, '林仲裁', 0, '13900139017', '110117197017171890', '福州市鼓楼区五四路', 'lawyer_017.jpg', '仲裁员、调解员，中国国际贸易仲裁委员会仲裁员，擅长商事仲裁、国际调解。', 6500.00, '仲裁,调解', 1, 30, '2015-08-30 13:50:00');
INSERT INTO `lawyer` VALUES (18, '马刑事', 1, '13900139018', '110118198118182001', '济南市历下区泺源大街', 'lawyer_018.jpg', '刑事辩护律师，山东省刑事辩护专业委员会委员，擅长职务犯罪、暴力犯罪辩护。', 4700.00, '刑事辩护,证据法', 1, 16, '2019-12-05 16:05:00');
INSERT INTO `lawyer` VALUES (19, '宋离婚', 0, '13900139019', '110119199219192112', '青岛市崂山区香港东路', 'lawyer_019.jpg', '婚姻家庭律师，青岛市妇联法律顾问，擅长离婚调解、家庭暴力保护令申请。', 2900.00, '婚姻家庭,妇女权益', 1, 9, '2022-03-28 09:30:00');
INSERT INTO `lawyer` VALUES (20, '黄房产', 1, '13900139020', '110120197320203223', '郑州市金水区农业路', 'lawyer_020.jpg', '房地产律师，河南省房地产业协会法律顾问，擅长房地产开发、建筑工程纠纷。', 5300.00, '房地产,建筑工程', 1, 22, '2018-06-14 12:45:00');
INSERT INTO `lawyer` VALUES (21, '徐劳动', 1, '13900139021', '110121198421214334', '合肥市蜀山区长江西路', 'lawyer_021.jpg', '劳动法律师，安徽省总工会法律顾问，擅长集体劳动合同、工伤认定。', 3100.00, '劳动法,社会保障', 1, 13, '2020-09-23 15:20:00');
INSERT INTO `lawyer` VALUES (22, '高知产', 0, '13900139022', '110122199522225445', '无锡市滨湖区蠡湖大道', 'lawyer_022.jpg', '知识产权律师，江苏省知识产权保护中心专家，擅长商业秘密保护、版权许可。', 4400.00, '知识产权,技术合同', 1, 11, '2021-07-17 10:55:00');
INSERT INTO `lawyer` VALUES (23, '唐公司', 1, '13900139023', '110123197623236556', '温州市鹿城区车站大道', 'lawyer_023.jpg', '公司法律师，浙江省企业法律顾问协会副会长，擅长公司治理、破产重整。', 5800.00, '公司法,破产法', 1, 24, '2017-11-08 14:15:00');
INSERT INTO `lawyer` VALUES (24, '罗行政', 1, '13900139024', '110124198724247667', '昆明市官渡区春城路', 'lawyer_024.jpg', '行政法律师，云南省政府法律顾问库成员，擅长行政许可、行政处罚复议。', 3600.00, '行政法,政府法律事务', 1, 17, '2019-05-19 11:40:00');
INSERT INTO `lawyer` VALUES (25, '韩金融', 0, '13900139025', '110125199825258778', '贵阳市观山湖区林城东路', 'lawyer_025.jpg', '金融犯罪辩护律师，贵州省金融犯罪研究中心研究员，擅长非法集资、洗钱罪辩护。', 4900.00, '金融犯罪,经济犯罪', 1, 8, '2022-08-12 16:25:00');
INSERT INTO `lawyer` VALUES (26, '谢国际', 1, '13900139026', '110126197926269889', '南昌市红谷滩新区赣江中大道', 'lawyer_026.jpg', '国际私法律师，精通国际私法规则，擅长涉外婚姻、继承法律事务。', 4100.00, '国际私法,涉外法律', 1, 19, '2018-10-31 09:50:00');
INSERT INTO `lawyer` VALUES (27, '董医疗', 0, '13900139027', '110127198027270990', '太原市小店区长治路', 'lawyer_027.jpg', '医疗法律师，山西省医疗纠纷调解委员会专家，擅长医疗过错鉴定、药品侵权。', 4300.00, '医疗法,药品法', 1, 14, '2020-12-07 13:05:00');
INSERT INTO `lawyer` VALUES (28, '梁环境', 1, '13900139028', '110128199128282101', '哈尔滨市南岗区红军街', 'lawyer_028.jpg', '环境法律师，黑龙江省环境资源法学会常务理事，擅长环境污染责任、生态赔偿。', 3900.00, '环境法,生态保护', 1, 12, '2021-02-14 15:30:00');
INSERT INTO `lawyer` VALUES (29, '苏网络', 0, '13900139029', '110129197229293212', '长春市朝阳区人民大街', 'lawyer_029.jpg', '电子商务法律师，吉林省电子商务协会法律顾问，擅长电商平台责任、电子合同。', 4600.00, '电子商务,互联网法', 1, 10, '2021-10-26 10:45:00');
INSERT INTO `lawyer` VALUES (30, '潘税务', 1, '13900139030', '110130198330304323', '沈阳市和平区南京北街', 'lawyer_030.jpg', '国际税务律师，OECD税收协定专家，擅长跨境税收安排、转让定价调整。', 7500.00, '国际税法,转让定价', 1, 15, '2019-07-03 14:00:00');

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '招聘信息id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '投递时间',
  `lawer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '律师名',
  `origin_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来源地',
  `resume` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简历链接',
  `is_agree` int NULL DEFAULT NULL COMMENT '是否录用，0代表拒绝，1代表同意，2表示待处理',
  `response` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回复内容',
  `em_id` bigint NULL DEFAULT NULL COMMENT '员工id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recruit
-- ----------------------------
INSERT INTO `recruit` VALUES (3, '2025-02-15 11:15:00', '王法理', '广州市天河区', 'resume_wangfali.pdf', 1, '王律师公司法实务经验丰富，同意录用。', 4);
INSERT INTO `recruit` VALUES (5, '2025-02-20 10:10:00', '刘公正', '杭州市西湖区', 'resume_liugongzheng.pdf', 1, '刘律师行政法专业水平高，同意录用。', 6);
INSERT INTO `recruit` VALUES (6, '2025-02-22 15:30:00', '陈明理', '南京市鼓楼区', 'resume_chenmingli.pdf', 1, '陈律师劳动法实务经验丰富，同意录用。', 7);
INSERT INTO `recruit` VALUES (7, '2025-02-25 13:45:00', '孙合同', '成都市武侯区', 'resume_sunhetong.pdf', 0, '孙律师的专长与本所现有业务重叠较多，暂时不考虑录用。', 8);
INSERT INTO `recruit` VALUES (8, '2025-02-28 09:20:00', '周产权', '武汉市武昌区', 'resume_zhouchanquan.pdf', 1, '周律师房地产法专业，同意录用。', 9);
INSERT INTO `recruit` VALUES (9, '2025-03-02 14:50:00', '吴侵权', '西安市雁塔区', 'resume_wuqinquan.pdf', 1, '吴律师侵权责任法专业，同意录用。', 10);
INSERT INTO `recruit` VALUES (10, '2025-03-05 11:30:00', '郑金融', '重庆市渝中区', 'resume_zhengjinrong.pdf', 0, '郑律师要求薪资过高，超出本所预算。', 11);
INSERT INTO `recruit` VALUES (11, '2025-03-08 16:15:00', '冯海商', '天津市滨海新区', 'resume_fenghaishang.pdf', 1, '冯律师海事海商法专业性强，同意录用。', 12);
INSERT INTO `recruit` VALUES (12, '2025-03-10 13:40:00', '陈国际', '青岛市市南区', 'resume_chenguoji.pdf', 1, '陈律师国际贸易法经验丰富，同意录用。', 13);
INSERT INTO `recruit` VALUES (13, '2025-03-12 15:45:00', '杨环境', '大连市中山区', 'resume_yanghuanjing.pdf', 1, '杨律师环境法专业，同意录用。', 2);
INSERT INTO `recruit` VALUES (14, '2025-03-15 09:55:00', '朱医疗', '长沙市芙蓉区', 'resume_zhuyiliao.pdf', 1, '朱律师医疗法专业，同意录用。', 3);
INSERT INTO `recruit` VALUES (15, '2025-03-18 13:20:00', '秦网络', '厦门市思明区', 'resume_qinwangluo.pdf', 1, '秦律师网络法专业，同意录用。', 4);
INSERT INTO `recruit` VALUES (16, '2025-03-20 15:50:00', '何税务', '宁波市鄞州区', 'resume_heshuiwu.pdf', 0, '何律师已有其他律所录用意向。', 5);
INSERT INTO `recruit` VALUES (17, '2025-03-22 10:30:00', '林仲裁', '福州市鼓楼区', 'resume_linzhongcai.pdf', 1, '林律师仲裁经验丰富，同意录用。', 6);
INSERT INTO `recruit` VALUES (18, '2025-03-25 14:25:00', '马刑事', '济南市历下区', 'resume_maxingshi.pdf', 1, '马律师刑事辩护专业，同意录用。', 7);
INSERT INTO `recruit` VALUES (19, '2025-03-28 11:10:00', '宋离婚', '青岛市崂山区', 'resume_songlihun.pdf', 1, '宋律师家事法专业，同意录用。', 8);
INSERT INTO `recruit` VALUES (20, '2025-03-30 15:55:00', '黄房产', '郑州市金水区', 'resume_huangfangchan.pdf', 1, '黄律师房地产法经验丰富，同意录用。', 9);

-- ----------------------------
-- Table structure for wage
-- ----------------------------
DROP TABLE IF EXISTS `wage`;
CREATE TABLE `wage`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '工资单号',
  `sal_paid` decimal(10, 2) NULL DEFAULT NULL COMMENT '已支付的工资',
  `sal_payable` decimal(10, 2) NULL DEFAULT NULL COMMENT '应该支付的工资',
  `em_id` bigint NULL DEFAULT NULL COMMENT '员工id',
  `lawer_id` bigint NULL DEFAULT NULL COMMENT '律师id',
  `sal_state` int NULL DEFAULT NULL COMMENT '支付状态，0表示未支付，1表示已支付一部分，2表示已支付完全',
  `create_time` date NULL DEFAULT NULL COMMENT '支付日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wage
-- ----------------------------
INSERT INTO `wage` VALUES (1, 8000.00, 8000.00, 2, NULL, 2, '2025-02-01');
INSERT INTO `wage` VALUES (2, 7500.00, 7500.00, 3, NULL, 2, '2025-02-01');
INSERT INTO `wage` VALUES (3, 7000.00, 7000.00, 4, NULL, 2, '2025-02-01');
INSERT INTO `wage` VALUES (4, 6500.00, 6500.00, 5, NULL, 2, '2025-02-01');
INSERT INTO `wage` VALUES (5, 6000.00, 6000.00, 6, NULL, 2, '2025-02-01');
INSERT INTO `wage` VALUES (6, 12000.00, 12000.00, NULL, 1, 2, '2025-02-05');
INSERT INTO `wage` VALUES (7, 10000.00, 10000.00, NULL, 2, 2, '2025-02-05');
INSERT INTO `wage` VALUES (8, 15000.00, 15000.00, NULL, 3, 2, '2025-02-05');
INSERT INTO `wage` VALUES (9, 11000.00, 11000.00, NULL, 4, 2, '2025-02-05');
INSERT INTO `wage` VALUES (10, 9000.00, 9000.00, NULL, 5, 2, '2025-02-05');
INSERT INTO `wage` VALUES (11, 8000.00, 8000.00, 2, NULL, 2, '2025-03-01');
INSERT INTO `wage` VALUES (12, 7500.00, 7500.00, 3, NULL, 2, '2025-03-01');
INSERT INTO `wage` VALUES (13, 7000.00, 7000.00, 4, NULL, 2, '2025-03-01');
INSERT INTO `wage` VALUES (14, 6500.00, 6500.00, 5, NULL, 2, '2025-03-01');
INSERT INTO `wage` VALUES (15, 6000.00, 6000.00, 6, NULL, 2, '2025-03-01');
INSERT INTO `wage` VALUES (16, 12000.00, 12000.00, NULL, 1, 2, '2025-03-05');
INSERT INTO `wage` VALUES (17, 10000.00, 10000.00, NULL, 2, 2, '2025-03-05');
INSERT INTO `wage` VALUES (18, 15000.00, 15000.00, NULL, 3, 2, '2025-03-05');
INSERT INTO `wage` VALUES (19, 11000.00, 11000.00, NULL, 4, 2, '2025-03-05');
INSERT INTO `wage` VALUES (20, 9000.00, 9000.00, NULL, 5, 2, '2025-03-05');
INSERT INTO `wage` VALUES (21, 8000.00, 8000.00, 2, NULL, 2, '2025-04-01');
INSERT INTO `wage` VALUES (22, 7500.00, 7500.00, 3, NULL, 2, '2025-04-01');
INSERT INTO `wage` VALUES (23, 7000.00, 7000.00, 4, NULL, 2, '2025-04-01');
INSERT INTO `wage` VALUES (24, 6500.00, 6500.00, 5, NULL, 2, '2025-04-01');
INSERT INTO `wage` VALUES (25, 6000.00, 6000.00, 6, NULL, 2, '2025-04-01');
INSERT INTO `wage` VALUES (26, 12000.00, 12000.00, NULL, 1, 2, '2025-04-05');
INSERT INTO `wage` VALUES (27, 10000.00, 10000.00, NULL, 2, 2, '2025-04-05');
INSERT INTO `wage` VALUES (28, 15000.00, 15000.00, NULL, 3, 2, '2025-04-05');
INSERT INTO `wage` VALUES (29, 11000.00, 11000.00, NULL, 4, 2, '2025-04-05');
INSERT INTO `wage` VALUES (30, 9000.00, 9000.00, NULL, 5, 2, '2025-04-05');
INSERT INTO `wage` VALUES (31, 8000.00, 8000.00, 2, NULL, 2, '2025-05-01');
INSERT INTO `wage` VALUES (32, 7500.00, 7500.00, 3, NULL, 2, '2025-05-01');
INSERT INTO `wage` VALUES (33, 7000.00, 7000.00, 4, NULL, 2, '2025-05-01');
INSERT INTO `wage` VALUES (34, 6500.00, 6500.00, 5, NULL, 2, '2025-05-01');
INSERT INTO `wage` VALUES (35, 6000.00, 6000.00, 6, NULL, 2, '2025-05-01');
INSERT INTO `wage` VALUES (36, 12000.00, 12000.00, NULL, 1, 2, '2025-05-05');
INSERT INTO `wage` VALUES (37, 10000.00, 10000.00, NULL, 2, 2, '2025-05-05');
INSERT INTO `wage` VALUES (38, 15000.00, 15000.00, NULL, 3, 2, '2025-05-05');
INSERT INTO `wage` VALUES (39, 11000.00, 11000.00, NULL, 4, 2, '2025-05-05');
INSERT INTO `wage` VALUES (40, 9000.00, 9000.00, NULL, 5, 2, '2025-05-05');
INSERT INTO `wage` VALUES (41, 8000.00, 8000.00, 2, NULL, 2, '2025-06-01');
INSERT INTO `wage` VALUES (42, 7500.00, 7500.00, 3, NULL, 2, '2025-06-01');
INSERT INTO `wage` VALUES (43, 7000.00, 7000.00, 4, NULL, 2, '2025-06-01');
INSERT INTO `wage` VALUES (44, 6500.00, 6500.00, 5, NULL, 2, '2025-06-01');
INSERT INTO `wage` VALUES (45, 6000.00, 6000.00, 6, NULL, 2, '2025-06-01');
INSERT INTO `wage` VALUES (46, 12000.00, 12000.00, NULL, 1, 2, '2025-06-05');
INSERT INTO `wage` VALUES (47, 10000.00, 10000.00, NULL, 2, 2, '2025-06-05');
INSERT INTO `wage` VALUES (48, 15000.00, 15000.00, NULL, 3, 2, '2025-06-05');
INSERT INTO `wage` VALUES (49, 11000.00, 11000.00, NULL, 4, 2, '2025-06-05');
INSERT INTO `wage` VALUES (50, 9000.00, 9000.00, NULL, 5, 2, '2025-06-05');

SET FOREIGN_KEY_CHECKS = 1;
