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




INSERT INTO `permission` VALUES (47, 0, 'users', '/', '用户管理(一级菜单)', '用户管理', NULL);
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
INSERT INTO `role_permission` VALUES (12, 47);
INSERT INTO `role_permission` VALUES (12, 48);
INSERT INTO `role_permission` VALUES (12, 51);
INSERT INTO `role_permission` VALUES (16, 57);
INSERT INTO `role_permission` VALUES (17, 47);
INSERT INTO `role_permission` VALUES (17, 49);
INSERT INTO `user` VALUES ('admin', '123456', 'admin@163.com', '2016-12-28 15:16:00', NULL, 0, '2016-12-28 15:16:00', 27);
INSERT INTO `user` VALUES ('张三', '123456', 'zhangsan@163.com', '2016-12-29 17:30:20', NULL, 1, '2016-12-29 17:30:20', 28);
INSERT INTO `user` VALUES ('李四', '123456', 'lisi@163.com', '2016-12-29 17:32:55', NULL, 0, '2016-12-29 17:32:55', 29);
INSERT INTO `user` VALUES ('王五', '123456', 'wangwu@163.com', '2016-12-29 17:34:53', NULL, 0, '2016-12-29 17:34:53', 31);
INSERT INTO `user_role` VALUES (27, 11);
INSERT INTO `user_role` VALUES (27, 12);
INSERT INTO `user_role` VALUES (27, 17);
INSERT INTO `user_role` VALUES (28, 12);
INSERT INTO `user_role` VALUES (31, 17);
