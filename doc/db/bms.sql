CREATE TABLE `bms_sequence` (
  `SEQ_NAME` varchar(50) NOT NULL COMMENT '序列名称',
  `CURRENT_VAL` int(11) NOT NULL COMMENT '当前值',
  `INCREMENT_VAL` int(11) NOT NULL DEFAULT '1' COMMENT '增长值',
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `bms_ts_dept` (
  `DEPT_ID` varchar(10) NOT NULL COMMENT '部门编号',
  `DEPT_CODE` varchar(50) NOT NULL COMMENT '部门代码',
  `DEPT_LEVEL` varchar(10) NOT NULL COMMENT '部门级别',
  `DEPT_NAME` varchar(50) NOT NULL COMMENT '部门名称',
  `DEPT_ADDRESS` varchar(100) DEFAULT NULL COMMENT '部门地址',
  `UP_DEPT_ID` varchar(50) DEFAULT NULL COMMENT '上级部门',
  `MEMO` varchar(500) DEFAULT NULL COMMENT '备注',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '状态：VALID有效/DISABLE失效',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始时间：YYYY-MM-DD HH:MI:SS',
  `LUPD_USER` varchar(20) DEFAULT NULL COMMENT '最后更改人',
  `LUPD_TIME` varchar(20) DEFAULT NULL COMMENT '最后更改时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-部门表';
-- ----------------------------
-- Records of bms_ts_dept
-- ----------------------------
INSERT INTO `bms_ts_dept` VALUES ('D0001', 'TECH', '1', '技术部', '深圳', 'GYZB', '技术', 'VALID', '', '2015-05-29 17:08:49', 'U000003', '2015-06-16 09:42:34');
INSERT INTO `bms_ts_dept` VALUES ('D0002', 'PERS', '1', '人事部', '深圳', 'GYZB', '人事管理', 'VALID', 'U000003', '2015-05-29 17:08:49', 'U000003', '2015-05-29 16:10:20');
INSERT INTO `bms_ts_dept` VALUES ('D0003', 'OPER', '1', '运营部', '深圳', 'GYZB', '运营', 'VALID', 'U000003', '2015-05-29 17:08:49', 'U000003', '2015-06-10 14:52:16');
INSERT INTO `bms_ts_dept` VALUES ('D0004', 'FINA', '1', '财务部', '深圳', 'GYZB', '财务部', 'VALID', 'U000003', '2015-05-29 15:13:44', 'U000003', '2015-05-29 16:08:59');
INSERT INTO `bms_ts_dept` VALUES ('D0005', 'PROD', '1', '生产管理部', '深圳', 'GYZB', '生产管理部', 'VALID', 'U000003', '2015-05-29 16:06:18', 'U000003', '2015-06-17 11:17:12');
INSERT INTO `bms_ts_dept` VALUES ('D0006', 'PLAN', '1', '企划部', '深圳', 'GYZB', '企划部', 'VALID', 'U000003', '2015-05-29 17:08:49', 'U000003', '2015-05-29 17:08:49');
INSERT INTO `bms_ts_dept` VALUES ('D0007', 'BZD', '1', '不知道啥', '深圳', 'GYZB', '', 'DISABLE', 'U000003', '2015-06-25 09:53:37', 'U000003', '2015-06-25 09:53:49');


CREATE TABLE `bms_ts_function` (
  `FUNCTION_ID` varchar(20) NOT NULL COMMENT '功能编号',
  `FUNCTION_NAME` varchar(50) NOT NULL COMMENT '功能名称',
  `PARENT_FUNCTION_ID` varchar(20) DEFAULT NULL COMMENT '上级编号',
  `FUNCTION_LEVEL` smallint(6) NOT NULL COMMENT '功能级别',
  `FUNCTION_URL` varchar(100) DEFAULT NULL COMMENT 'URL',
  `FUNCTION_ORDER` smallint(6) DEFAULT NULL COMMENT '功能排序',
  `IS_MENU` char(1) NOT NULL COMMENT '是否是菜单Y是/N否',
  `IS_VALID` char(1) NOT NULL COMMENT '是否有效Y有效，N无效',
  `ACCESS_TYPE` char(1) DEFAULT NULL COMMENT '是否要授权，Y需要，N不需要',
  `ICON_CLASS` varchar(50) DEFAULT NULL COMMENT '图标样式',
  `MEMO` varchar(500) DEFAULT NULL COMMENT '备注',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始时间：YYYY-MM-DD HH:MI:SS',
  `LUPD_USER` varchar(20) DEFAULT NULL COMMENT '最后更改人',
  `LUPD_TIME` varchar(20) DEFAULT NULL COMMENT '最后更改时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`FUNCTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-菜单功能表';


INSERT INTO `bms_ts_function` VALUES ('100', '平台demo', null, '1', null, '0', 'Y', 'Y', 'N', 'icon-list-alt', null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('10001', '文件上传', '100', '2', '/demo/fileupload', '1', 'Y', 'Y', 'N', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('101', '系统管理', null, '1', null, '1', 'Y', 'Y', 'Y', 'icon-list', null, 'SYSAUTO', '2015-05-08 16:22:30', null, null);
INSERT INTO `bms_ts_function` VALUES ('10101', '用户管理', '101', '2', '/system/user/list', '1', 'Y', 'Y', 'Y', '', '', '', '', '', '');
INSERT INTO `bms_ts_function` VALUES ('1010101', '用户新增', '10101', '3', '/system/user/add', '1', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010102', '用户删除', '10101', '3', '/system/user/delete', '2', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010103', '用户修改', '10101', '3', '/system/user/edit', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010104', '用户角色查询', '10101', '3', '/system/user/search', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('10102', '角色管理', '101', '2', '/system/role/list', '2', 'Y', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010201', '角色新增', '10102', '3', '/system/role/add', '1', 'N', 'Y', 'Y', '', '', '', '', '', '');
INSERT INTO `bms_ts_function` VALUES ('1010202', '角色修改', '10102', '3', '/system/role/edit', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010203', '角色删除', '10102', '3', '/system/role/delete', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010204', '角色菜单查询', '10102', '3', '/system/role/function', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('10103', '菜单管理', '101', '2', '/system/function/list', '1', 'Y', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010301', '菜单增加', '10103', '3', '/system/function/add', '1', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010302', '菜单修改', '10103', '3', '/system/function/edit', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010303', '菜单删除', '10103', '3', '/system/function/delete', '2', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('10104', '部门管理', '101', '2', '/system/dept/list', '4', 'Y', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010401', '新增部门', '10104', '3', '/system/dept/add', '1', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010402', '部门修改', '10104', '3', '/system/dept/edit', '2', 'N', 'Y', 'Y', null, null, null, null, null, null);
INSERT INTO `bms_ts_function` VALUES ('1010403', '部门删除', '10104', '3', '/system/dept/delete', '3', 'N', 'Y', 'Y', null, null, null, null, null, null);


CREATE TABLE `bms_ts_role` (
  `ROLE_ID` varchar(20) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称',
  `MEMO` varchar(500) DEFAULT NULL COMMENT '角色说明',
  `IS_VALID` char(1) NOT NULL COMMENT '是否有效:Y/N',
  `INDEX_PAGE` varchar(50) DEFAULT NULL COMMENT '登陆以后默认进入页面',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始时间：YYYY-MM-DD HH:MI:SS',
  `LUPD_USER` varchar(20) DEFAULT NULL COMMENT '最后更改人',
  `LUPD_TIME` varchar(20) DEFAULT NULL COMMENT '最后更改时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-角色表';
-- ----------------------------
-- Records of bms_ts_role
-- ----------------------------
INSERT INTO `bms_ts_role` VALUES ('101', '管理员', '老大大', 'Y', null, 'U000001', '2015-05-08 10:20:35', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role` VALUES ('102', '普通员工', '普通员工', 'Y', null, 'U000002', '2015-05-26 14:06:29', 'U000002', '2015-06-17 10:00:46');
INSERT INTO `bms_ts_role` VALUES ('103', '特级员工', '特级员工', 'N', null, 'U000002', '2015-05-26 18:57:14', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role` VALUES ('104', '高级员工', '高级员工', 'Y', null, 'U000002', '2015-05-26 19:48:51', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role` VALUES ('105', 'wasadmin', 'wasadmin', 'N', null, 'U000003', '2015-05-27 13:35:05', 'U000003', '2015-05-29 17:24:25');
INSERT INTO `bms_ts_role` VALUES ('106', '商户管理员', '商户管理员', 'Y', null, 'U000003', '2015-05-27 19:27:38', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role` VALUES ('107', '风险评估管理员', '风险评估管理员', 'Y', null, 'U000003', '2015-06-17 10:47:19', 'U000003', '2015-06-17 10:47:31');

CREATE TABLE `bms_ts_role_function` (
  `ROLE_ID` varchar(20) NOT NULL COMMENT '角色编号',
  `FUNCTION_ID` varchar(20) NOT NULL COMMENT '功能编号',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`ROLE_ID`,`FUNCTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-角色与菜单对应表';
-- ----------------------------
-- Records of bms_ts_role_function
-- ----------------------------
INSERT INTO `bms_ts_role_function` VALUES ('101', '100', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10001', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010103', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010104', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010201', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010202', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010203', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010204', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10103', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010301', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010302', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010303', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10104', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010401', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010402', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1010403', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10201', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020103', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020104', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020105', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020106', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020107', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020108', null, null);
INSERT INTO `bms_ts_role_function` VALUES ('101', '10202', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020201', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020202', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020203', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10203', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020301', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020302', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020303', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10204', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020401', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020402', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020403', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10205', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020501', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020502', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020503', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020504', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10206', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020601', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020602', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020603', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10207', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020701', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020702', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020703', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1020704', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '103', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10301', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030103', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030104', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030105', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10302', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10303', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10304', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10305', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030501', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030502', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030503', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10306', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030601', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030602', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030603', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030604', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030605', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10307', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030701', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030702', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030703', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1030704', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '104', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10401', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1040101', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1040102', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '105', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10501', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10502', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050201', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050202', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050203', 'U000004', '2015-07-01 11:16:23');
INSERT INTO `bms_ts_role_function` VALUES ('101', '10503', null, null);
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050301', null, null);
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050302', null, null);
INSERT INTO `bms_ts_role_function` VALUES ('101', '1050303', null, null);
INSERT INTO `bms_ts_role_function` VALUES ('103', '100', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '101', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '10101', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010101', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010102', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010103', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010104', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '10102', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010201', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010202', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010203', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010204', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '10103', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010301', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010302', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1010303', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '10104', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('103', '1111', 'U000003', '2015-05-28 15:51:34');
INSERT INTO `bms_ts_role_function` VALUES ('104', '102', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '10201', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020101', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020102', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020103', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020104', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020105', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020106', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '10202', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020201', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020202', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020203', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '10203', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020301', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020302', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020303', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '10204', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020401', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020402', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020403', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '10205', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020501', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020502', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('104', '1020503', 'U000002', '2015-05-26 19:48:57');
INSERT INTO `bms_ts_role_function` VALUES ('106', '100', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10001', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '101', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10101', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010101', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010102', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010103', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010104', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10102', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010201', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010202', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010203', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010204', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10103', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010301', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010302', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010303', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10104', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010401', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010402', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1010403', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '102', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10201', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020101', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020102', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020103', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020104', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020105', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020106', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10202', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020201', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020202', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020203', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10203', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020301', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020302', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020303', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10204', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020401', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020402', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020403', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10205', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020501', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020502', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020503', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10206', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020601', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020602', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020603', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10207', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020701', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020702', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020703', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1020704', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '103', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10301', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10302', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10303', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10304', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10305', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '10306', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1030601', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1030602', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('106', '1030603', 'U000003', '2015-06-17 09:33:22');
INSERT INTO `bms_ts_role_function` VALUES ('107', '100', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10001', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '101', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10101', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010101', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010102', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010103', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010104', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10102', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010201', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010202', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010203', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010204', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10103', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010301', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010302', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010303', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10104', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010401', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010402', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1010403', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '102', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10201', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020101', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020102', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020103', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020104', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020105', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020106', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10202', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020201', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020202', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020203', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10203', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020301', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020302', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020303', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10204', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020401', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020402', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020403', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10205', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020501', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020502', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020503', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10206', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020601', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020602', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020603', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10207', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020701', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020702', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020703', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1020704', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '103', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10301', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10302', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10303', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10304', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10305', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '10306', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1030601', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1030602', 'U000003', '2015-06-17 10:47:31');
INSERT INTO `bms_ts_role_function` VALUES ('107', '1030603', 'U000003', '2015-06-17 10:47:31');


CREATE TABLE `bms_ts_user` (
  `USER_ID` varchar(20) NOT NULL COMMENT '用户编号',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  `REAL_NAME` varchar(20) NOT NULL COMMENT '真实姓名',
  `NICK_NAME` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `DEPT_ID` varchar(20) NOT NULL COMMENT '部门编号',
  `SEX` varchar(5) NOT NULL COMMENT '性别：MEN男/WOMEN女',
  `WORK_PHONE` varchar(20) DEFAULT NULL COMMENT '工作号码',
  `SELF_PHONE` varchar(20) DEFAULT NULL COMMENT '个人号码',
  `WORK_EMAIL` varchar(50) DEFAULT NULL COMMENT '工作邮箱',
  `SELF_EMAIL` varchar(50) DEFAULT NULL COMMENT '个人邮箱',
  `STATUS` varchar(10) NOT NULL COMMENT '状态：生效VALID/冻结FREEZE/离职LEAVE/已登录LOGIN',
  `MEMO` varchar(500) DEFAULT NULL COMMENT '备注',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始写入时间：YYYY-MM-DD HH:MI:SS',
  `LUPD_USER` varchar(20) DEFAULT NULL COMMENT '最后更改人',
  `LUPD_TIME` varchar(20) DEFAULT NULL COMMENT '最后更改时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-用户表';
-- ----------------------------
-- Records of bms_ts_user
-- ----------------------------
INSERT INTO `bms_ts_user` VALUES ('U000001', '3527E65C7E989D73611ED9E00B6185E7', '马会全', '小马', 'D0001', 'MEN', '13688888888', '13688888888', 'mahq@szgyzb.com', 'mahq@szgyzb.com', 'LOGIN', '', 'U000003', '2015-05-08 14:48:57', 'U000003', '2015-06-24 09:19:09');


CREATE TABLE `bms_ts_user_role` (
  `USER_ID` varchar(20) NOT NULL COMMENT '用户编号',
  `ROLE_ID` varchar(20) NOT NULL COMMENT '角色编号',
  `INST_USER` varchar(20) DEFAULT NULL COMMENT '初始写入人',
  `INST_TIME` varchar(20) DEFAULT NULL COMMENT '初始时间：YYYY-MM-DD HH:MI:SS',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统-用户与角色对应表';
-- ----------------------------
-- Records of bms_ts_user_role
-- ----------------------------
INSERT INTO `bms_ts_user_role` VALUES ('U000001', '101', 'U000003', '2015-06-16 17:29:55');

