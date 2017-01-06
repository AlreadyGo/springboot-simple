USE `test`;

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `description` varchar(50) NOT NULL DEFAULT '' COMMENT 'description',
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='role';

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='user';

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `send_info`;
CREATE TABLE `send_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) DEFAULT NULL,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=586 DEFAULT CHARSET=utf8;





INSERT INTO `permission` VALUES (47, 0, 'users', '/', '用户管理', '用户管理', NULL);
INSERT INTO `permission` VALUES (48, 1, 'users.users', '/main/users', '用户管理', '用户管理', 'glyphicon-user');
INSERT INTO `permission` VALUES (49, 1, 'users.roles', '/main/roles', '角色管理', '角色管理', 'glyphicon-eye-open');
INSERT INTO `permission` VALUES (50, 1, 'users.permissions', '/main/permissions', '权限管理', '权限管理', 'glyphicon-fire');
INSERT INTO `permission` VALUES (51, 2, 'users.user.save', '/backend/user/save', '用户管理>更新/添加', '', NULL);
INSERT INTO `permission` VALUES (52, 2, 'users.user.delete', '/backend/user/delete/**', '用户管理>删除', '', NULL);
INSERT INTO `permission` VALUES (53, 2, 'users.user.all', '/backend/user/all', '用户管理>查看所有', '', NULL);
INSERT INTO `permission` VALUES (54, 2, 'users.role.save', '/backend/role/save', '角色管理>更新/添加', '', NULL);
INSERT INTO `permission` VALUES (56, 2, 'users.role.delete', '/backend/role/delete/**', '角色管理>删除', '', NULL);
INSERT INTO `permission` VALUES (57, 2, 'users.role.all', '/backend/role/all', '角色管理>查看所有', '', NULL);
INSERT INTO `permission` VALUES (58, 2, 'users.permission.all', '/backend/permission/all', '权限管理>查看所有', '', NULL);
INSERT INTO `permission` VALUES (59, 2, 'users.permission.delete', '/backend/permission/delete/**', '权限管理>删除', '', NULL);
INSERT INTO `permission` VALUES (60, 2, 'users.permission.save', '/backend/permission/save', '权限管理>更新/添加', '', NULL);
INSERT INTO `permission` VALUES (61, 2, 'users.user.dispatch', '/backend/user/getRolesByUid/**', '用户管理>分配角色', '获取已分配角色', '');
INSERT INTO `permission` VALUES (62, 2, 'users.role.dispatch', '/backend/role/getPermissionIdsByRid/**', '角色管理>配置权限', '配置权限', '');
INSERT INTO `permission` VALUES (63, 2, 'users.role.dispatch', '/backend/role/dispatch', '角色管理>权限分配', '权限分配', '');
INSERT INTO `permission` VALUES (64, 2, 'users.user.dispatch', '/backend/user/dispatch', '用户管理>分配角色', '分配角色', '');
INSERT INTO `permission` VALUES (65, 2, 'users.user.status', '/backend/user/updateStatus', '用户管理>状态管理', '', '');
INSERT INTO `permission` VALUES (66, 2, 'users.role.status', '/backend/role/updateStatus', '角色管理>状态管理', '', '');
INSERT INTO `permission` VALUES (67, 0, 'customers', '/', '客户信息', '客户信息管理', '');
INSERT INTO `permission` VALUES (68, 0, 'orders', '/', '订单信息管理', '订单信息管理', '');
INSERT INTO `permission` VALUES (69, 0, 'accounts', '/', '结算信息管理', '结算信息管理', '');
INSERT INTO `permission` VALUES (70, 0, 'cost', '/', '成本信息管理', '成本信息管理', '');
INSERT INTO `permission` VALUES (71, 0, 'fundsApp', '/', '资金申请管理', '资金申请管理', '');
INSERT INTO `permission` VALUES (72, 0, 'fundsSum', '/', '资金统计管理', '资金统计管理', '');
INSERT INTO `permission` VALUES (73, 0, 'reports', '/', '报表管理', '报表管理', '');
INSERT INTO `permission` VALUES (74, 1, 'customers.sendInfo', '/main/customers/sendInfo', '客户信息管理>发货方信息', '发货方信息', 'glyphicon-list-alt');
INSERT INTO `permission` VALUES (76, 1, 'customers.deliveryManInfo', '/main/customers/deliveryManInfo', '客户信息管理>承运商信息', '承运商信息', 'glyphicon-list-alt');
INSERT INTO `permission` VALUES (77, 1, 'customers.personalInfo', '/main/customers/personalInfo', '客户信息管理>个体商户信息', '个体商户信息', 'glyphicon-list-alt');
INSERT INTO `role` VALUES ('管理员', '管理员', 11, 0);
INSERT INTO `role` VALUES ('操作员1', '操作员1', 12, 0);
INSERT INTO `role` VALUES ('操作员2', '操作员2', 17, 0);
INSERT INTO `role_permission` VALUES (11, 47);
INSERT INTO `role_permission` VALUES (11, 48);
INSERT INTO `role_permission` VALUES (11, 49);
INSERT INTO `role_permission` VALUES (11, 50);
INSERT INTO `role_permission` VALUES (11, 51);
INSERT INTO `role_permission` VALUES (11, 52);
INSERT INTO `role_permission` VALUES (11, 53);
INSERT INTO `role_permission` VALUES (11, 54);
INSERT INTO `role_permission` VALUES (11, 56);
INSERT INTO `role_permission` VALUES (11, 57);
INSERT INTO `role_permission` VALUES (11, 58);
INSERT INTO `role_permission` VALUES (11, 59);
INSERT INTO `role_permission` VALUES (11, 60);
INSERT INTO `role_permission` VALUES (11, 61);
INSERT INTO `role_permission` VALUES (11, 62);
INSERT INTO `role_permission` VALUES (11, 63);
INSERT INTO `role_permission` VALUES (11, 64);
INSERT INTO `role_permission` VALUES (11, 65);
INSERT INTO `role_permission` VALUES (11, 66);
INSERT INTO `role_permission` VALUES (11, 67);
INSERT INTO `role_permission` VALUES (11, 68);
INSERT INTO `role_permission` VALUES (11, 69);
INSERT INTO `role_permission` VALUES (11, 70);
INSERT INTO `role_permission` VALUES (11, 71);
INSERT INTO `role_permission` VALUES (11, 72);
INSERT INTO `role_permission` VALUES (11, 73);
INSERT INTO `role_permission` VALUES (11, 74);
INSERT INTO `role_permission` VALUES (11, 75);
INSERT INTO `role_permission` VALUES (11, 76);
INSERT INTO `role_permission` VALUES (11, 77);
INSERT INTO `role_permission` VALUES (12, 47);
INSERT INTO `role_permission` VALUES (12, 48);
INSERT INTO `role_permission` VALUES (12, 51);
INSERT INTO `role_permission` VALUES (16, 57);
INSERT INTO `role_permission` VALUES (17, 47);
INSERT INTO `role_permission` VALUES (17, 49);
INSERT INTO `user` VALUES ('admin', '123456', 'admin@163.com', '2016-12-28 15:16:00', '2017-1-5 14:23:26', 0, '2016-12-28 15:16:00', 27);
INSERT INTO `user` VALUES ('张三', '123456', 'zhangsan@163.com', '2016-12-29 17:30:20', NULL, 0, '2016-12-29 17:30:20', 28);
INSERT INTO `user` VALUES ('李四', '123456', 'lisi@163.com', '2016-12-29 17:32:55', NULL, 0, '2016-12-29 17:32:55', 29);
INSERT INTO `user` VALUES ('王五', '5', 'wangwu@163.com', '2016-12-29 17:34:53', NULL, 0, '2016-12-29 17:34:53', 31);
INSERT INTO `user` VALUES ('小哥哥', '123123', 'xgg@163.sss', '2017-1-3 14:45:15', NULL, 0, '2017-1-3 14:45:15', 32);
INSERT INTO `user` VALUES ('大兄弟', '123456', '1@11', '2017-1-4 13:45:27', '2017-1-4 14:28:44', 1, '2017-1-4 13:45:27', 33);
INSERT INTO `user_role` VALUES (27, 11);
INSERT INTO `user_role` VALUES (28, 12);
INSERT INTO `user_role` VALUES (31, 17);

