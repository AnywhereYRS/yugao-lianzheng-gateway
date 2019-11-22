use yugao_lianzheng;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `lianzheng_dongtai`;
CREATE TABLE `lianzheng_dongtai`  (
  `lianzheng_dongtai_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，廉政动态的唯一标识',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '廉政动态的标题',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '廉政动态的内容',
  `type` int NOT NULL DEFAULT 0 COMMENT '廉政动态的类型',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：0-草稿，1-已发布，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_dongtai_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政动态主体信息' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_dongtai_img`;
CREATE TABLE `lianzheng_dongtai_img`  (
  `lianzheng_dongtai_img_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，廉政动态图片的唯一标识',
  `lianzheng_dongtai_id` bigint(20) NOT NULL COMMENT '关联外键，廉政动态的唯一标识',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '图片保存路径',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '图片名称',
  `size` bigint(20) NULL COMMENT '图片大小（kb）',
  `suffix` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '文件后缀',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_dongtai_img_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政动态图片列表，一个廉政动态主体必须至少有一张图片' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_contact`;
CREATE TABLE `lianzheng_contact`  (
  `lianzheng_contact_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `tel_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系地址',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系人邮箱',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_contact_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政信箱' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference`;
CREATE TABLE `lianzheng_reference`  (
  `lianzheng_reference_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '廉政资料的标题或名称',
  `type` int NOT NULL COMMENT '类别，对应lianzheng_reference_type中的数据',
  `department` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '部门ID，针对部门资料',
  `project` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '项目ID，针对工程项目资料类型',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '项目名称，针对工程项目资料类型',
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '内容和说明',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：1-正常，-1-删除，0-草稿',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料主体信息' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_type`;
CREATE TABLE `lianzheng_reference_type`  (
  `lianzheng_reference_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '本阶段包括：集团资料，部门资料，项目资料',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料类型' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_file_type`;
CREATE TABLE `lianzheng_reference_file_type`  (
  `lianzheng_reference_file_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '本阶段包括：廉政专题教育会图文资料、廉政约谈图文资料、廉洁从业承诺书、廉政交底现场照片、廉政告知函',
  `lianzheng_reference_type_id` varchar(255) NOT NULL COMMENT '指定哪些廉政资料类型可以上传该类别的附件，多类型用英文逗号(,)分割',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_file_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料的附件类型' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_effective_period`;
CREATE TABLE `lianzheng_reference_effective_period`  (
  `lianzheng_reference_effective_period_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `lianzheng_reference_id` bigint(20) NOT NULL COMMENT '廉政主体信息的id',
  `date_from` datetime(0) NOT NULL COMMENT '开始时间',
  `date_to` datetime(0) NOT NULL COMMENT '结束时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_effective_period_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料的生效时段（针对廉政告知函）' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_undo`;
CREATE TABLE `lianzheng_undo`  (
  `lianzheng_undo_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `lianzheng_reference_id` bigint(20) NOT NULL COMMENT '廉政主体信息的id',
  `type` int NOT NULL COMMENT '类型：1-待阅，2-待办',
  `due_by` bigint(20) NOT NULL COMMENT '任务预计处理人',
  `finished_by` bigint(20) NULL COMMENT '任务实际处理人',
  `due_at` datetime(0) NULL COMMENT '任务预计完成时间',
  `finished_at` datetime(0) NULL COMMENT '任务完成时间',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：1-已完成，-1-删除，0-未完成',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_undo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '待办或待阅事项' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_file`;
CREATE TABLE `lianzheng_file`  (
  `lianzheng_file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `business_id` bigint(20) NOT NULL COMMENT '业务主键id',
  `module_id` bigint(20) NOT NULL COMMENT '根据business_id和module_id来确定附件属于哪个具体的廉政业务',
  `bucket` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件仓库（oss仓库）',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `suffix` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件后缀',
  `size` bigint(20) NULL DEFAULT NULL COMMENT '文件大小（kb）',
  `final_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件唯一标识id',
  `path` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储路径',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_file_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '廉政附件信息。通用，廉政资料，廉政动态等涉及附件上传的板块都直接使用该表' ROW_FORMAT = Dynamic;


use yugao_lianzheng;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `lianzheng_dongtai`;
CREATE TABLE `lianzheng_dongtai`  (
  `lianzheng_dongtai_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，廉政动态的唯一标识',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '廉政动态的标题',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '廉政动态的内容',
  `type` int NOT NULL DEFAULT 0 COMMENT '廉政动态的类型',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：0-草稿，1-已发布，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_dongtai_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政动态主体信息' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_dongtai_img`;
CREATE TABLE `lianzheng_dongtai_img`  (
  `lianzheng_dongtai_img_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，廉政动态图片的唯一标识',
  `lianzheng_dongtai_id` bigint(20) NOT NULL COMMENT '关联外键，廉政动态的唯一标识',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '图片保存路径',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '图片名称',
  `size` bigint(20) NULL COMMENT '图片大小（kb）',
  `suffix` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '文件后缀',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_dongtai_img_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政动态图片列表，一个廉政动态主体必须至少有一张图片' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_contact`;
CREATE TABLE `lianzheng_contact`  (
  `lianzheng_contact_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `tel_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系地址',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '联系人邮箱',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_contact_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政信箱' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference`;
CREATE TABLE `lianzheng_reference`  (
  `lianzheng_reference_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '廉政资料的标题或名称',
  `type` int NOT NULL COMMENT '类别，对应lianzheng_reference_type中的数据',
  `department` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '部门ID，针对部门资料',
  `project` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '项目ID，针对工程项目资料类型',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '项目名称，针对工程项目资料类型',
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '内容和说明',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：1-正常，-1-删除，0-草稿',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料主体信息' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_type`;
CREATE TABLE `lianzheng_reference_type`  (
  `lianzheng_reference_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '本阶段包括：集团资料，部门资料，项目资料',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料类型' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_file_type`;
CREATE TABLE `lianzheng_reference_file_type`  (
  `lianzheng_reference_file_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '本阶段包括：廉政专题教育会图文资料、廉政约谈图文资料、廉洁从业承诺书、廉政交底现场照片、廉政告知函',
  `lianzheng_reference_type_id` varchar(255) NOT NULL COMMENT '指定哪些廉政资料类型可以上传该类别的附件，多类型用英文逗号(,)分割',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_file_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料的附件类型' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_reference_effective_period`;
CREATE TABLE `lianzheng_reference_effective_period`  (
  `lianzheng_reference_effective_period_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `lianzheng_reference_id` bigint(20) NOT NULL COMMENT '廉政主体信息的id',
  `date_from` datetime(0) NOT NULL COMMENT '开始时间',
  `date_to` datetime(0) NOT NULL COMMENT '结束时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_reference_effective_period_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '廉政资料的生效时段（针对廉政告知函）' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_undo`;
CREATE TABLE `lianzheng_undo`  (
  `lianzheng_undo_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `lianzheng_reference_id` bigint(20) NOT NULL COMMENT '廉政主体信息的id',
  `type` int NOT NULL COMMENT '类型：1-待阅，2-待办',
  `due_by` bigint(20) NOT NULL COMMENT '任务预计处理人',
  `finished_by` bigint(20) NULL COMMENT '任务实际处理人',
  `due_at` datetime(0) NULL COMMENT '任务预计完成时间',
  `finished_at` datetime(0) NULL COMMENT '任务完成时间',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态：1-已完成，-1-删除，0-未完成',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_undo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '待办或待阅事项' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `lianzheng_file`;
CREATE TABLE `lianzheng_file`  (
  `lianzheng_file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，唯一标识',
  `business_id` bigint(20) NOT NULL COMMENT '业务主键id',
  `module_id` bigint(20) NOT NULL COMMENT '根据business_id和module_id来确定附件属于哪个具体的廉政业务',
  `bucket` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件仓库（oss仓库）',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `suffix` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件后缀',
  `size` bigint(20) NULL DEFAULT NULL COMMENT '文件大小（kb）',
  `final_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件唯一标识id',
  `path` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储路径',
  `created_by` bigint(20) NOT NULL COMMENT '创建者id',
  `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` bigint(20) NULL COMMENT '最后一次修改者id',
  `updated_at` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次修改时间',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态：1-正常，-1-删除',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`lianzheng_file_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '廉政附件信息。通用，廉政资料，廉政动态等涉及附件上传的板块都直接使用该表' ROW_FORMAT = Dynamic;


