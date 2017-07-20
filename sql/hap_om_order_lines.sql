/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : hap_dev

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-01-15 13:39:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hap_om_order_lines`
-- ----------------------------
DROP TABLE IF EXISTS `hap_om_order_lines`;
CREATE TABLE `hap_om_order_lines` (
  `LINE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单行ID',
  `HEADER_ID` bigint(20) NOT NULL COMMENT '订单头ID',
  `LINE_NUMBER` bigint(20) NOT NULL COMMENT '行号',
  `INVENTORY_ITEM_ID` bigint(20) NOT NULL COMMENT '产品ID',
  `ORDERD_QUANTITY` bigint(20) NOT NULL COMMENT '数量',
  `ORDER_QUANTITY_UOM` varchar(30) NOT NULL COMMENT '产品单位',
  `UNIT_SELLING_PRICE` bigint(20) NOT NULL COMMENT '销售单价',
  `DESCRIPTION` varchar(240) NOT NULL COMMENT '备注',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '公司ID',
  `ADDITION1` varchar(150) DEFAULT NULL COMMENT '附加信息1',
  `ADDITION2` varchar(150) DEFAULT NULL COMMENT '附加信息2',
  `ADDITION3` varchar(150) DEFAULT NULL COMMENT '附加信息3',
  `ADDITION4` varchar(150) DEFAULT NULL COMMENT '附加信息4',
  `ADDITION5` varchar(150) DEFAULT NULL COMMENT '附加信息5',
  `OBJECT_VERSION_NUMBER` decimal(20,0) DEFAULT '1' COMMENT '行版本号，用来处理锁',
  `REQUEST_ID` bigint(20) DEFAULT '-1' COMMENT '请求号',
  `PROGRAM_ID` bigint(20) DEFAULT '-1',
  `CREATION_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` decimal(20,0) DEFAULT '-1',
  `LAST_UPDATED_BY` decimal(20,0) DEFAULT '-1',
  `LAST_UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE_LOGIN` decimal(20,0) DEFAULT NULL,
  `ATTRIBUTE_CATEGORY` varchar(30) DEFAULT NULL,
  `ATTRIBUTE1` varchar(240) DEFAULT NULL,
  `ATTRIBUTE2` varchar(240) DEFAULT NULL,
  `ATTRIBUTE3` varchar(240) DEFAULT NULL,
  `ATTRIBUTE4` varchar(240) DEFAULT NULL,
  `ATTRIBUTE5` varchar(240) DEFAULT NULL,
  `ATTRIBUTE6` varchar(240) DEFAULT NULL,
  `ATTRIBUTE7` varchar(240) DEFAULT NULL,
  `ATTRIBUTE8` varchar(240) DEFAULT NULL,
  `ATTRIBUTE9` varchar(240) DEFAULT NULL,
  `ATTRIBUTE10` varchar(240) DEFAULT NULL,
  `ATTRIBUTE11` varchar(240) DEFAULT NULL,
  `ATTRIBUTE12` varchar(240) DEFAULT NULL,
  `ATTRIBUTE13` varchar(240) DEFAULT NULL,
  `ATTRIBUTE14` varchar(240) DEFAULT NULL,
  `ATTRIBUTE15` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`LINE_ID`),
  KEY `HAP_OM_ORDER_LINES _N1` (`HEADER_ID`),
  KEY `HAP_OM_ORDER_LINES _N2` (`INVENTORY_ITEM_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='销售订单行表';

-- ----------------------------
-- Records of hap_om_order_lines
-- ----------------------------
INSERT INTO `hap_om_order_lines` VALUES ('1', '1', '170101', '10001', '2', 'day', '600', '订单01的子订单1', '101', null, null, null, null, null, '1', '-1', '-1', '2017-01-13 19:53:44', '-1', '-1', '2017-01-13 19:53:44', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hap_om_order_lines` VALUES ('2', '1', '170102', '10002', '5', 'day', '1000', '订单01的子订单2', '101', null, null, null, null, null, '1', '-1', '-1', '2017-01-13 19:54:49', '-1', '-1', '2017-01-13 19:54:49', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
