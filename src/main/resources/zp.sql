CREATE DATABASE /*!32312 IF NOT EXISTS*/`zp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zp`;
-- ----------------------------
-- Table structure for `relation`
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `relationid` bigint(11) NOT NULL AUTO_INCREMENT,
  `followid` bigint(11) NOT NULL,
  `fromid` bigint(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`relationid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES ('1', '3', '2', '0');
INSERT INTO `relation` VALUES ('2', '4', '2', '0');
INSERT INTO `relation` VALUES ('3', '7', '6', '0');
INSERT INTO `relation` VALUES ('4', '6', '4', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '小明', '1999-08-04', '福建厦门中山路', '好吃的很多，你也去吧', '2021-08-28 18:33:37');
INSERT INTO `user` VALUES ('3', '小马哥', '1992-08-21', '厦门思明区', '你在东海撒谎覅图库噶时光', '2021-08-29 03:32:59');
INSERT INTO `user` VALUES ('4', '大中哥', '1992-08-21', '湖北武汉江夏区', '你在搞末子光', '2021-08-29 03:36:13');
INSERT INTO `user` VALUES ('6', '七七', '1997-08-21', '四川省成都市武侯区', '你在做啥子嘛', '2021-08-29 03:37:27');
INSERT INTO `user` VALUES ('7', '芳芳', '1996-02-21', '陕西省西安市', '我就改改文字肉夹馍在你心里是什么地位', '2021-08-29 03:37:58');
INSERT INTO `user` VALUES ('8', '大大米', '1986-06-21', '广东省佛山市', '叶师傅你也在啊啊师傅', '2021-08-29 04:29:26');
INSERT INTO `user` VALUES ('10', '哇大奖', '1995-04-20', '山东省青岛市', '机嗯哪咋地阿娇哦我法', '2021-08-29 05:16:58');
INSERT INTO `user` VALUES ('11', '大溪地', '1995-11-20', '山东省菏泽市', '都爱就松动i阿斯弗阿斯弗', '2021-08-29 05:30:30');
