/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50634
Source Host           : 127.0.0.1:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-01-03 17:02:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classs
-- ----------------------------
DROP TABLE IF EXISTS `classs`;
CREATE TABLE `classs` (
  `c_uuid` varchar(18) NOT NULL,
  `c_name` varchar(255) NOT NULL,
  PRIMARY KEY (`c_uuid`,`c_name`),
  UNIQUE KEY `sy_c_name` (`c_name`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classs
-- ----------------------------
INSERT INTO `classs` VALUES ('24838094943420421', '计应143');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(255) DEFAULT NULL,
  `resources` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test1` varchar(255) DEFAULT NULL,
  `test2` varchar(255) DEFAULT NULL,
  `test3` varchar(255) DEFAULT NULL,
  `test4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_table
-- ----------------------------
INSERT INTO `test_table` VALUES ('1', '123', 'asd', 'abc', 'xyz');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_uuid` varchar(36) NOT NULL,
  `username` varchar(18) NOT NULL,
  `password` varchar(18) NOT NULL,
  `is_delete` int(1) NOT NULL COMMENT '0 是',
  `create_date` datetime(6) DEFAULT NULL,
  `c_uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`u_uuid`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24838094943420424', 'adminstrator', 'soft', '0', '2016-11-30 17:10:02.896000', '24838094943420421');

-- ----------------------------
-- Table structure for user_recources
-- ----------------------------
DROP TABLE IF EXISTS `user_recources`;
CREATE TABLE `user_recources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_uuid` varchar(255) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_recources
-- ----------------------------
