/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : library_management

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-19 21:54:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `status` int(8) DEFAULT NULL COMMENT '借阅状态',
  `pubhouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '决策支持系统', '数理科学', '贾晓丰', '1', '清华大学出版社');
INSERT INTO `book` VALUES ('2', '供应链管理', '经济', '马士华', '1', '机械工业出版社');
INSERT INTO `book` VALUES ('3', 'oracle数据库设计', '计算机', '李明俊', '1', '哈尔滨工业大学出版社');
INSERT INTO `book` VALUES ('4', 'JSP程序设计', '计算机', '刘何秀', '0', '人民邮电出版社');
INSERT INTO `book` VALUES ('5', '电子商务技术安全', '计算机', '张爱菊', '0', '清华大学出版社');

-- ----------------------------
-- Table structure for borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `borrow_record`;
CREATE TABLE `borrow_record` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `borrow_time` int(11) DEFAULT NULL COMMENT '借阅时间 单位 天',
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_record
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(60) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL,
  `faculty` tinyint(255) DEFAULT NULL COMMENT '院系',
  `sex` varchar(40) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `head_sulpture` varchar(255) DEFAULT NULL COMMENT '头像存储路径',
  `personality_word` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telePhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201545061250', '小红', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `student` VALUES ('201651025050', '李杨洋', 'e10adc3949ba59abbe56e057f20f883e', '2016', '电子商务', null, '女', '猫性', null, '认真生活', '1998-04-22', '1030617952@qq.com', '18845786461');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员');
