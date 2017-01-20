
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(200) NOT NULL,
  `measure` double(11,2) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `freight` double(11,2) DEFAULT NULL,
  `lading_cost` double(11,2) DEFAULT NULL,
  `delivery_cost` double(11,2) DEFAULT NULL,
  `other_cost` double(11,2) DEFAULT NULL,
  `sum` double(11,2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_order_num` (`order_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cost_info`
-- ----------------------------
DROP TABLE IF EXISTS `cost_info`;
CREATE TABLE `cost_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(200) NOT NULL,
  `transport_way` varchar(200) DEFAULT NULL,
  `receiving_way` varchar(200) DEFAULT NULL,
  `driver_name` varchar(200) DEFAULT NULL,
  `car_type` varchar(200) DEFAULT NULL,
  `car_rental` varchar(200) DEFAULT '',
  `delivery_man_name` varchar(200) DEFAULT NULL,
  `express_number` varchar(200) DEFAULT NULL,
  `telephone_num` varchar(200) DEFAULT NULL,
  `shipping_cost` varchar(200) DEFAULT NULL,
  `receiving_cost` varchar(200) DEFAULT NULL,
  `transport_cost` varchar(200) DEFAULT NULL,
  `delivery_cost` varchar(200) DEFAULT NULL,
  `other_cost` varchar(200) DEFAULT NULL,
  `total_cost` varchar(200) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `cost_status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `delivery_man_info`
-- ----------------------------
DROP TABLE IF EXISTS `delivery_man_info`;
CREATE TABLE `delivery_man_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `service_scope` varchar(200) DEFAULT NULL,
  `route_province` varchar(200) DEFAULT NULL,
  `route_city` varchar(200) DEFAULT NULL,
  `origin_link_way` varchar(200) DEFAULT NULL,
  `agency_link_way` varchar(200) DEFAULT NULL,
  `main_link` varchar(200) DEFAULT NULL,
  `contract` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_code_name` (`code`,`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `funds_statistics_info`
-- ----------------------------
DROP TABLE IF EXISTS `funds_statistics_info`;
CREATE TABLE `funds_statistics_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_date` datetime DEFAULT NULL,
  `discount_netting` varchar(200) DEFAULT NULL,
  `paid_trunk` varchar(200) DEFAULT NULL,
  `balances_trunk` varchar(200) DEFAULT NULL,
  `clearing_form` varchar(200) DEFAULT NULL,
  `paid_short` varchar(200) DEFAULT NULL,
  `balances_short` varchar(200) DEFAULT NULL,
  `rebate_amount` varchar(200) DEFAULT NULL,
  `charge_situation` varchar(200) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `order_num` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_date` varchar(200) DEFAULT NULL,
  `customer_code` varchar(200) DEFAULT NULL,
  `sender` varchar(200) DEFAULT NULL,
  `order_num` varchar(200) DEFAULT NULL,
  `origin_address` varchar(200) DEFAULT NULL,
  `destination_city` varchar(200) DEFAULT NULL,
  `receiver_com` varchar(200) DEFAULT NULL,
  `receiver_person` varchar(200) DEFAULT NULL,
  `telephone_num` varchar(200) DEFAULT NULL,
  `destination_address` varchar(200) DEFAULT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `wrap` varchar(200) DEFAULT NULL,
  `count` tinyint(2) DEFAULT NULL,
  `weight` tinyint(2) DEFAULT NULL,
  `volume` tinyint(2) DEFAULT NULL,
  `receive_date` varchar(200) DEFAULT NULL,
  `settle_way` varchar(200) DEFAULT NULL,
  `amount` tinyint(2) DEFAULT NULL,
  `is_settled` tinyint(2) DEFAULT NULL,
  `is_cost_calc` tinyint(2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_order_num` (`order_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `permission_type` tinyint(2) NOT NULL,
  `value` varchar(200) NOT NULL,
  `url` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `style` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `personal_info`
-- ----------------------------
DROP TABLE IF EXISTS `personal_info`;
CREATE TABLE `personal_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route` varchar(200) DEFAULT NULL,
  `driver_name` varchar(200) NOT NULL,
  `car_num` varchar(200) NOT NULL,
  `telephone_num` varchar(200) DEFAULT NULL,
  `car_type` varchar(200) DEFAULT NULL,
  `car_team` varchar(200) DEFAULT NULL,
  `bank_num` varchar(200) DEFAULT NULL,
  `order_rate` varchar(200) DEFAULT NULL,
  `service_ability` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `description` varchar(50) NOT NULL DEFAULT '' COMMENT 'description',
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='role';

-- ----------------------------
--  Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `send_info`
-- ----------------------------
DROP TABLE IF EXISTS `send_info`;
CREATE TABLE `send_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `account_measure` varchar(200) DEFAULT NULL,
  `product_type` varchar(50) DEFAULT NULL,
  `goods_type` varchar(50) DEFAULT NULL,
  `biz_type` varchar(50) DEFAULT NULL,
  `swap_type` varchar(50) DEFAULT NULL,
  `receiver_type` varchar(50) DEFAULT NULL,
  `biz_desc` varchar(300) DEFAULT NULL,
  `base_link` varchar(200) DEFAULT NULL,
  `base_link_way` varchar(200) DEFAULT NULL,
  `main_link` varchar(200) DEFAULT NULL,
  `main_link_way` varchar(200) DEFAULT NULL,
  `base_goods_address` varchar(200) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name_code` (`name`,`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=959 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `upload_result`
-- ----------------------------
DROP TABLE IF EXISTS `upload_result`;
CREATE TABLE `upload_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `detail` text,
  `upload_type` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT 'password',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT 'email',
  `create_date` datetime DEFAULT NULL COMMENT 'createDate',
  `update_date` datetime DEFAULT NULL COMMENT 'updateDate',
  `status` tinyint(4) DEFAULT NULL COMMENT 'status',
  `last_login` datetime DEFAULT NULL COMMENT 'more1',
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='user';

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Event definition for `upload_result_truncate`
-- ----------------------------
DROP EVENT IF EXISTS `upload_result_truncate`;
CREATE DEFINER=`root`@`localhost` EVENT `upload_result_truncate` ON SCHEDULE EVERY 1 DAY STARTS '2017-01-20 10:25:57' ON COMPLETION NOT PRESERVE ENABLE DO DELETE from upload_result where create_date < date_add(now(),INTERVAL -7 DAY);

-- ----------------------------
--  Records
-- ----------------------------
INSERT INTO `account` VALUES ('16','A-20161201-1',NULL,NULL,NULL,NULL,NULL,'111.00',NULL,'2017-01-20 13:55:00','2017-01-20 14:11:08'), ('17','A-20161201-2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-01-20 13:55:26','2017-01-20 14:10:38');
INSERT INTO `cost_info` VALUES ('24','A-20161201-1','','','','','','','','','','','','','','0','2017-01-20 13:55:04','2017-01-20 13:55:04','2'), ('25','A-20161201-2','','','','','','','','','','','','','','0','2017-01-20 13:55:29','2017-01-20 14:10:20','0');
INSERT INTO `order_info` VALUES ('41','2016年12月01日','1','上海涌锐','A-20161201-1','中创仓库','常州','常州礼江休闲食品商行','籍兰萍','13606115605','常州市凌家塘市场江陵路5栋（副食品区东大门北面）','巧克力','纸箱','50',NULL,NULL,'42706','到付',NULL,NULL,NULL,'2017-01-20 13:47:40','2017-01-20 13:47:40'), ('42','2016年12月01日','1','上海涌锐','A-20161201-2','中创仓库','上海','上海九点半','蒋虎','18916220006','上海市星华公路2365号红楼五楼','巧克力','纸箱','100',NULL,NULL,'42705','月结',NULL,NULL,NULL,'2017-01-20 13:47:40','2017-01-20 13:47:40');
INSERT INTO `permission` VALUES ('47','0','users','/','用户管理','用户管理',NULL), ('48','1','users.user','/main/users','用户管理','用户管理','glyphicon-user'), ('49','1','users.role','/main/roles','角色管理','角色管理','glyphicon-eye-open'), ('50','1','users.permission','/main/permissions','权限管理','权限管理','glyphicon-fire'), ('51','2','users.user.save','/backend/user/save','用户管理>更新/添加','',NULL), ('52','2','users.user.delete','/backend/user/delete/**','用户管理>删除','',NULL), ('53','2','users.user.all','/backend/user/all','用户管理>查看所有','',NULL), ('54','2','users.role.save','/backend/role/save','角色管理>更新/添加','',NULL), ('56','2','users.role.delete','/backend/role/delete/**','角色管理>删除','',NULL), ('57','2','users.role.all','/backend/role/all','角色管理>查看所有','',NULL), ('58','2','users.permission.all','/backend/permission/all','权限管理>查看所有','',NULL), ('59','2','users.permission.delete','/backend/permission/delete/**','权限管理>删除','',NULL), ('60','2','users.permission.save','/backend/permission/save','权限管理>更新/添加','',NULL), ('61','2','users.user.dispatch','/backend/user/getRolesByUid/**','用户管理>分配角色','获取已分配角色',''), ('62','2','users.role.dispatch','/backend/role/getPermissionIdsByRid/**','角色管理>配置权限','配置权限',''), ('63','2','users.role.dispatch','/backend/role/dispatch','角色管理>权限分配','权限分配',''), ('64','2','users.user.dispatch','/backend/user/dispatch','用户管理>分配角色','分配角色',''), ('65','2','users.user.status','/backend/user/updateStatus','用户管理>状态管理','',''), ('66','2','users.role.status','/backend/role/updateStatus','角色管理>状态管理','',''), ('67','0','customers','/','客户信息','客户信息管理',''), ('68','0','orders','/','订单信息管理','订单信息管理',''), ('69','0','accounts','/','结算信息管理','结算信息管理',''), ('70','0','cost','/','成本信息管理','成本信息管理',''), ('71','0','fundsApp','/','资金申请管理','资金申请管理',''), ('72','0','fundsSum','/','资金统计管理','资金统计管理',''), ('73','0','reports','/','报表管理','报表管理',''), ('74','1','customers.sendInfo','/main/customers/sendInfo','客户信息管理>发货方信息','发货方信息','glyphicon-list-alt'), ('76','1','customers.deliveryManInfo','/main/customers/deliveryManInfo','客户信息管理>承运商信息','承运商信息','glyphicon-list-alt'), ('77','1','customers.personalInfo','/main/customers/personalInfo','客户信息管理>个体商户信息','个体商户信息','glyphicon-list-alt'), ('78','1','orders.order','/main/orders','订单管理>订单管理','订单管理','glyphicon-list-alt'), ('79','1','fundsApp.fundsApplication','/main/fundsApp/fundsApplication','资金申请管理>资金申请','资金申请','glyphicon-list-alt'), ('80','1','fundsSum.fundsStatistics','/main/fundsSum/fundsStatistics','资金统计管理>资金统计','资金统计','glyphicon-list-alt'), ('81','1','cost.costMaintain','/main/cost/costMaintain','成本信息管理>成本维护','成本维护','glyphicon-list-alt'), ('82','1','accounts.account','/main/accounts','结算信息管理>结算信息','结算信息','glyphicon-list-alt'), ('83','2','orders.order.all','/backend/orderInfo/all','订单管理>订单管理>所有订单>查询（all）','',''), ('84','2','customers.sendInfo.all','/backend/sendInfo/all','客户信息管理>发货方信息>查询（all）','',''), ('85','2','customers.sendInfo.save','/backend/sendInfo/save','客户信息管理>发货方信息>添加 编辑（save）','',''), ('86','2','customers.sendInfo.upload','/backend/sendInfo/upload','客户信息管理>发货方信息>上传（upload）','',''), ('88','2','customers.sendInfo.delete','/backend/sendInfo/delete/**','客户信息管理>发货方信息>删除（）','',''), ('89','2','customers.deliveryManInfo.all','/backend/deliveryManInfo/all','客户信息管理>承运商信息>查询（all）','',''), ('90','2','customers.deliveryManInfo.save','/backend/deliveryManInfo/save','客户信息管理>承运商信息>编辑 添加（save）','',''), ('91','2','customers.deliveryManInfo.uoload','/backend/deliveryManInfo/upload','客户信息管理>承运商信息>上传','',''), ('92','2','customers.deliveryManInfo.delete','/backend/deliveryManInfo/delete/**','客户信息管理>承运商信息>删除(delete)','',''), ('93','2','customers.deliveryManInfo.view','/backend/uploadResult/view/**','客户信息管理>承运商信息>上传一览(view)','',''), ('94','2','customers.personalInfo.all','/backend/personalInfo/all','客户信息管理>个体商户信息>查询（all）','',''), ('95','2','customers.personalInfo.save','/backend/personalInfo/save','客户信息管理>个体商户信息>编辑 添加（save）','',''), ('96','2','customers.personalInfo.upload','/backend/personalInfo/upload','客户信息管理>个体商户信息>上传（upload）','',''), ('97','2','customers.personalInfo.delete','/backend/personalInfo/delete/**','客户信息管理>个体商户信息>删除（delete）','',''), ('98','2','customers.personalInfo.view','/backend/uploadResult/view/**','客户信息管理>个体商户信息>上传一览（view）','',''), ('99','2','orders.order.save','/backend/orderInfo/save','订单管理>订单管理>编辑 添加（save）','',''), ('100','2','orders.order.upload','/backend/orderInfo/upload','订单管理>订单管理>上传（upload）','',''), ('101','2','orders.order.delete','/backend/orderInfo/delete/**','订单管理>订单管理>删除（delete）','',''), ('102','2','accounts.account.all','/backend/account/all','结算信息管理>结算信息>查询（all）','',''), ('103','2','accounts.account.save','/backend/account/save','结算信息管理>结算信息>编辑（save）','',''), ('104','2','cost.costMaintain.all','/backend/costMaintainInfo/all','成本信息管理>成本维护>查询（all）','',''), ('105','2','cost.costMaintain.delete','/backend/costMaintainInfo/delete/**','成本信息管理>成本维护>删除（delete）','',''), ('106','1','fundsApp.fundsCheck','/main/fundsApp/fundsCheck','资金申请管理>资金申请审批','资金申请审批','glyphicon-list-alt'), ('107','2','fundsSum.fundsStatistics.save','/backend/fundsStatistics/save','资金统计管理>资金统计>编辑(save)','',''), ('108','2','fundsSum.fundsStatistics.delete','/backend/fundsStatistics/delete/**','资金统计管理>资金统计>删除（delete）','',''), ('109','2','cost.costMaintain.submitCostStatus','/backend/fundsApp/submitCostStatus','成本信息管理>成本维护>提交成本（submitCostStatus）','',''), ('110','2','fundsApp.fundsApplication.applyCostStatus','/backend/fundsApp/applyCostStatus','资金申请管理>资金申请>申请成本（applyCostStatus）','',''), ('111','2','fundsApp.fundsCheck.checkCostStatus','/backend/fundsApp/checkCostStatus','资金申请管理>资金申请审批>批准申请成本（submitCostStatus）','',''), ('112','2','cost.costMaintain.save','/backend/costMaintainInfo/save','成本信息管理>成本维护>编辑 添加（save）','',''), ('113','2','accounts.account.delete','/backend/account/delete/**','结算信息管理>结算信息>删除（delete）','',''), ('114','2','fundsSum.fundsStatistics.all','/backend/fundsStatistics/all','资金统计管理>资金统计>查询（all）','',''), ('116','2','customers.sendInfo.view','/backend/uploadResult/view/**','客户信息管理>发货方信息>上传一览(/view/{id})','','');
INSERT INTO `role` VALUES ('管理员','管理员','11','0'), ('操作员','操作员','18','0'), ('复核员','复核员','19','0'), ('法人','法人','20','0');
INSERT INTO `role_permission` VALUES ('11','47'), ('11','48'), ('11','49'), ('11','50'), ('11','51'), ('11','52'), ('11','53'), ('11','54'), ('11','56'), ('11','57'), ('11','58'), ('11','59'), ('11','60'), ('11','61'), ('11','62'), ('11','63'), ('11','64'), ('11','65'), ('11','66'), ('11','67'), ('11','68'), ('11','69'), ('11','70'), ('11','71'), ('11','72'), ('11','73'), ('11','74'), ('11','75'), ('11','76'), ('11','77'), ('11','78'), ('11','79'), ('11','80'), ('11','81'), ('11','82'), ('11','83'), ('11','84'), ('11','85'), ('11','86'), ('11','87'), ('11','88'), ('11','89'), ('11','90'), ('11','91'), ('11','92'), ('11','93'), ('11','94'), ('11','95'), ('11','96'), ('11','97'), ('11','98'), ('11','99'), ('11','100'), ('11','101'), ('11','102'), ('11','103'), ('11','104'), ('11','105'), ('11','106'), ('11','107'), ('11','108'), ('11','109'), ('11','110'), ('11','111'), ('11','112'), ('11','113'), ('11','114'), ('11','115'), ('12','47'), ('12','48'), ('12','51'), ('16','57'), ('17','47'), ('17','49'), ('18','67'), ('18','68'), ('18','74'), ('18','76'), ('18','77'), ('18','78'), ('18','83'), ('18','84'), ('18','85'), ('18','86'), ('18','87'), ('18','88'), ('18','89'), ('18','90'), ('18','91'), ('18','92'), ('18','93'), ('18','94'), ('18','95'), ('18','96'), ('18','97'), ('18','98'), ('18','99'), ('18','100'), ('18','101'), ('18','115');
INSERT INTO `role_permission` VALUES ('18','116'), ('19','69'), ('19','70'), ('19','81'), ('19','82'), ('19','83'), ('19','102'), ('19','103'), ('19','104'), ('19','105'), ('19','109'), ('19','112'), ('19','113'), ('19','114'), ('20','71'), ('20','104'), ('20','106'), ('20','111');
INSERT INTO `send_info` VALUES ('950','1','上海涌锐','','垃圾袋/包材','重货/泡货','运输','托盘/箱','经销商/代加工','上海发北京/深圳，山东','张根峰（物流主管）','TEL:59703531/13918138682','','','上海市青浦工业园新技路777号','2017-01-20 13:47:33','2017-01-20 13:47:33'), ('951','2','美馨','','湿巾','重泡货','仓储+运输','箱','经销商仓库','上海发温州/武汉/义乌','徐维18665561281/周新翠17717082916','','','','上海松江天马沈砖公路3129弄5号楼/松江大港镇昆港公路1088号','2017-01-20 13:47:33','2017-01-20 13:47:33'), ('952','3','苏州约瑟夫','','湿巾','重货','运输','箱','经销商仓库/门店','上海发全国各地','各销售助理','','','','上海松江天马沈砖公路3129弄5号楼/松江大港镇昆港公路1088号','2017-01-20 13:47:33','2017-01-20 13:47:33'), ('953','4','上海樵泉','','韩国牛奶','重货','运输','箱','经销商仓库/商超','上海发江浙常温牛奶和冷藏整车运输','吴群群021-60705215/18501751542','张经理：13901989184仓库张主管13621972321','','','松江九亭涞亭南路90号/上海市青浦区胜利路399号 张磊15202198400','2017-01-20 13:47:33','2017-01-20 13:47:33'), ('954','5','益海嘉里','','金龙鱼油','重货','铁路运输','箱','','铁路运输','徐斌18918991416','','','','浦东高东路118号/浦东仓库','2017-01-20 13:47:33','2017-01-20 13:47:33'), ('955','6','南京中外运','','金龙鱼豆浆粉','重货','运输','箱','','豆浆份发全国','郑先生18952568653','中外运陶先生15850679338','','','高东路118号4号门','2017-01-20 13:47:34','2017-01-20 13:47:34'), ('956','7','天马汪老板','','泡沫板','泡货','运输','个','','蚌埠','朱军堂','13909622769','','','天马天宅路156号','2017-01-20 13:47:34','2017-01-20 13:47:34'), ('957','8','佰皆百食品','','食品','','运输','箱','','','','','','','','2017-01-20 13:47:34','2017-01-20 13:47:34'), ('958','9','天孚真空','','机械软管','','运输','托盘/箱','','东莞','黄延玲','13559726641/0769-83226777/0769-83221603','','','东莞寮步镇华南工业城','2017-01-20 13:47:34','2017-01-20 13:47:34');
INSERT INTO `upload_result` VALUES ('82','2017-01-20 11:14:48','[{\"updateDate\":1484882088080,\"sendDate\":\"经过编码不可见字符\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"姓名\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"证书号\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"IC卡号\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"10：法人\\r\\n12：操作员\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"前2位\\r\\nSH：代表SHCA\\r\\nCA：代表CECA卡\\r\\n后2位：\\r\\nWQ：代表渥奇卡\\r\\nCM：代表com口卡\\r\\nUB：USB读卡器卡\\r\\n\\r\\n目前默认：CAUB\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"性别\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"电话\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"传真\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"E-MAIL\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"地址\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"邮编\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"用户状态\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"创建时间\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"更新时间\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"备用域1\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"备用域2\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"备用域3\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"证书公钥\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"SIM_ID\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"sendDate\":\"最后一次登录时间\",\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"createDate\":1484882088080,\"status\":\"失败\"},{\"updateDate\":1484882088080,\"createDate\":1484882088080,\"status\":\"失败\"}]','3'), ('83','2017-01-20 13:45:52','[{\"updateDate\":1484891152622,\"sendDate\":\"经过编码不可见字符\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"姓名\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"证书号\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"IC卡号\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"10：法人\\r\\n12：操作员\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"前2位\\r\\nSH：代表SHCA\\r\\nCA：代表CECA卡\\r\\n后2位：\\r\\nWQ：代表渥奇卡\\r\\nCM：代表com口卡\\r\\nUB：USB读卡器卡\\r\\n\\r\\n目前默认：CAUB\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"性别\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"电话\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"传真\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"E-MAIL\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"地址\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"邮编\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"用户状态\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"创建时间\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"更新时间\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"备用域1\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"备用域2\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"备用域3\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"证书公钥\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"SIM_ID\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"sendDate\":\"最后一次登录时间\",\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"createDate\":1484891152622,\"status\":\"失败\"},{\"updateDate\":1484891152622,\"createDate\":1484891152622,\"status\":\"失败\"}]','3'), ('84','2017-01-20 13:46:22','[{\"updateDate\":1484891182647,\"destinationAddress\":\"常州市凌家塘市场江陵路5栋（副食品区东大门北面）\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"13606115605\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-1\",\"productName\":\"巧克力\",\"receiverPerson\":\"籍兰萍\",\"settleWay\":\"到付\",\"createDate\":1484891182647,\"count\":50,\"receiveDate\":\"42706\",\"destinationCity\":\"常州\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"常州礼江休闲食品商行\",\"status\":\"失败\"},{\"updateDate\":1484891182647,\"destinationAddress\":\"上海市星华公路2365号红楼五楼\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"18916220006\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-2\",\"productName\":\"巧克力\",\"receiverPerson\":\"蒋虎\",\"settleWay\":\"月结\",\"createDate\":1484891182647,\"count\":100,\"receiveDate\":\"42705\",\"destinationCity\":\"上海\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"上海九点半\",\"status\":\"失败\"}]','3'), ('85','2017-01-20 13:46:29','[{\"updateDate\":1484891189034,\"destinationAddress\":\"常州市凌家塘市场江陵路5栋（副食品区东大门北面）\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"13606115605\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-1\",\"productName\":\"巧克力\",\"receiverPerson\":\"籍兰萍\",\"settleWay\":\"到付\",\"createDate\":1484891189034,\"count\":50,\"receiveDate\":\"42706\",\"destinationCity\":\"常州\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"常州礼江休闲食品商行\",\"status\":\"失败\"},{\"updateDate\":1484891189034,\"destinationAddress\":\"上海市星华公路2365号红楼五楼\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"18916220006\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-2\",\"productName\":\"巧克力\",\"receiverPerson\":\"蒋虎\",\"settleWay\":\"月结\",\"createDate\":1484891189034,\"count\":100,\"receiveDate\":\"42705\",\"destinationCity\":\"上海\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"上海九点半\",\"status\":\"失败\"}]','3'), ('86','2017-01-20 13:47:23','[{\"updateDate\":1484891243352,\"destinationAddress\":\"常州市凌家塘市场江陵路5栋（副食品区东大门北面）\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"13606115605\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-1\",\"productName\":\"巧克力\",\"receiverPerson\":\"籍兰萍\",\"settleWay\":\"到付\",\"createDate\":1484891243352,\"count\":50,\"receiveDate\":\"42706\",\"destinationCity\":\"常州\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"常州礼江休闲食品商行\",\"status\":\"失败\"},{\"updateDate\":1484891243352,\"destinationAddress\":\"上海市星华公路2365号红楼五楼\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"18916220006\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-2\",\"productName\":\"巧克力\",\"receiverPerson\":\"蒋虎\",\"settleWay\":\"月结\",\"createDate\":1484891243352,\"count\":100,\"receiveDate\":\"42705\",\"destinationCity\":\"上海\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"上海九点半\",\"status\":\"失败\"}]','3'), ('87','2017-01-20 13:47:34','[{\"updateDate\":1484891253766,\"bizDesc\":\"上海发北京/深圳，山东\",\"bizType\":\"运输\",\"code\":\"1\",\"mainLink\":\"\",\"swapType\":\"托盘/箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"上海市青浦工业园新技路777号\",\"baseLink\":\"张根峰（物流主管）\",\"goodsType\":\"重货/泡货\",\"mainLinkWay\":\"\",\"receiverType\":\"经销商/代加工\",\"name\":\"上海涌锐\",\"id\":950,\"productType\":\"垃圾袋/包材\",\"baseLinkWay\":\"TEL:59703531/13918138682\",\"createDate\":1484891253766,\"status\":\"成功\"},{\"updateDate\":1484891253813,\"bizDesc\":\"上海发温州/武汉/义乌\",\"bizType\":\"仓储+运输\",\"code\":\"2\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"上海松江天马沈砖公路3129弄5号楼/松江大港镇昆港公路1088号\",\"baseLink\":\"徐维18665561281/周新翠17717082916\",\"goodsType\":\"重泡货\",\"mainLinkWay\":\"\",\"receiverType\":\"经销商仓库\",\"name\":\"美馨\",\"id\":951,\"productType\":\"湿巾\",\"baseLinkWay\":\"\",\"createDate\":1484891253813,\"status\":\"成功\"},{\"updateDate\":1484891253844,\"bizDesc\":\"上海发全国各地\",\"bizType\":\"运输\",\"code\":\"3\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"上海松江天马沈砖公路3129弄5号楼/松江大港镇昆港公路1088号\",\"baseLink\":\"各销售助理\",\"goodsType\":\"重货\",\"mainLinkWay\":\"\",\"receiverType\":\"经销商仓库/门店\",\"name\":\"苏州约瑟夫\",\"id\":952,\"productType\":\"湿巾\",\"baseLinkWay\":\"\",\"createDate\":1484891253844,\"status\":\"成功\"},{\"updateDate\":1484891253875,\"bizDesc\":\"上海发江浙常温牛奶和冷藏整车运输\",\"bizType\":\"运输\",\"code\":\"4\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"松江九亭涞亭南路90号/上海市青浦区胜利路399号 张磊15202198400\",\"baseLink\":\"吴群群021-60705215/18501751542\",\"goodsType\":\"重货\",\"mainLinkWay\":\"\",\"receiverType\":\"经销商仓库/商超\",\"name\":\"上海樵泉\",\"id\":953,\"productType\":\"韩国牛奶\",\"baseLinkWay\":\"张经理：13901989184仓库张主管13621972321\",\"createDate\":1484891253875,\"status\":\"成功\"},{\"updateDate\":1484891253922,\"bizDesc\":\"铁路运输\",\"bizType\":\"铁路运输\",\"code\":\"5\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"浦东高东路118号/浦东仓库\",\"baseLink\":\"徐斌18918991416\",\"goodsType\":\"重货\",\"mainLinkWay\":\"\",\"receiverType\":\"\",\"name\":\"益海嘉里\",\"id\":954,\"productType\":\"金龙鱼油\",\"baseLinkWay\":\"\",\"createDate\":1484891253922,\"status\":\"成功\"},{\"updateDate\":1484891254016,\"bizDesc\":\"豆浆份发全国\",\"bizType\":\"运输\",\"code\":\"6\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"高东路118号4号门\",\"baseLink\":\"郑先生18952568653\",\"goodsType\":\"重货\",\"mainLinkWay\":\"\",\"receiverType\":\"\",\"name\":\"南京中外运\",\"id\":955,\"productType\":\"金龙鱼豆浆粉\",\"baseLinkWay\":\"中外运陶先生15850679338\",\"createDate\":1484891254016,\"status\":\"成功\"},{\"updateDate\":1484891254047,\"bizDesc\":\"蚌埠\",\"bizType\":\"运输\",\"code\":\"7\",\"mainLink\":\"\",\"swapType\":\"个\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"天马天宅路156号\",\"baseLink\":\"朱军堂\",\"goodsType\":\"泡货\",\"mainLinkWay\":\"\",\"receiverType\":\"\",\"name\":\"天马汪老板\",\"id\":956,\"productType\":\"泡沫板\",\"baseLinkWay\":\"13909622769\",\"createDate\":1484891254047,\"status\":\"成功\"},{\"updateDate\":1484891254078,\"bizDesc\":\"\",\"bizType\":\"运输\",\"code\":\"8\",\"mainLink\":\"\",\"swapType\":\"箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"\",\"baseLink\":\"\",\"goodsType\":\"\",\"mainLinkWay\":\"\",\"receiverType\":\"\",\"name\":\"佰皆百食品\",\"id\":957,\"productType\":\"食品\",\"baseLinkWay\":\"\",\"createDate\":1484891254078,\"status\":\"成功\"},{\"updateDate\":1484891254125,\"bizDesc\":\"东莞\",\"bizType\":\"运输\",\"code\":\"9\",\"mainLink\":\"\",\"swapType\":\"托盘/箱\",\"accountMeasure\":\"\",\"baseGoodsAddress\":\"东莞寮步镇华南工业城\",\"baseLink\":\"黄延玲\",\"goodsType\":\"\",\"mainLinkWay\":\"\",\"receiverType\":\"\",\"name\":\"天孚真空\",\"id\":958,\"productType\":\"机械软管\",\"baseLinkWay\":\"13559726641/0769-83226777/0769-83221603\",\"createDate\":1484891254125,\"status\":\"成功\"}]','0'), ('88','2017-01-20 13:47:40','[{\"updateDate\":1484891260270,\"destinationAddress\":\"常州市凌家塘市场江陵路5栋（副食品区东大门北面）\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"13606115605\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-1\",\"productName\":\"巧克力\",\"receiverPerson\":\"籍兰萍\",\"id\":41,\"settleWay\":\"到付\",\"createDate\":1484891260270,\"count\":50,\"receiveDate\":\"42706\",\"destinationCity\":\"常州\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"常州礼江休闲食品商行\",\"status\":\"成功\"},{\"updateDate\":1484891260356,\"destinationAddress\":\"上海市星华公路2365号红楼五楼\",\"sendDate\":\"2016年12月01日\",\"telephoneNum\":\"18916220006\",\"originAddress\":\"中创仓库\",\"customerCode\":\"1\",\"orderNum\":\"A-20161201-2\",\"productName\":\"巧克力\",\"receiverPerson\":\"蒋虎\",\"id\":42,\"settleWay\":\"月结\",\"createDate\":1484891260356,\"count\":100,\"receiveDate\":\"42705\",\"destinationCity\":\"上海\",\"sender\":\"上海涌锐\",\"wrap\":\"纸箱\",\"receiverCom\":\"上海九点半\",\"status\":\"成功\"}]','3');
INSERT INTO `user` VALUES ('admin','123456','admin@163.com','2016-12-28 15:16:00','2017-01-05 14:23:26','0','2016-12-28 15:16:00','27'), ('operator','123456','operator@operator.com','2017-01-20 11:25:57',NULL,'0','2017-01-20 11:25:57','36'), ('checker','123456','checker@checker.com','2017-01-20 11:26:42',NULL,'0','2017-01-20 11:26:42','37'), ('corporation','123456','corporation@corporation.com','2017-01-20 11:27:22',NULL,'0','2017-01-20 11:27:22','38');
INSERT INTO `user_role` VALUES ('27','11'), ('36','18'), ('37','19'), ('38','20');
