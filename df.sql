
CREATE TABLE `df_agent` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `agent_name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `gender` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性别',
  `agent_phone` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
  `open_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信openId',
  `parent_open_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '父级代理id',
  `ancestor_open_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '一级代理id',
  `nick_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `province` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省份',
  `city` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '城市',
  `sender_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发件人姓名',
  `sender_phone` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '发件人电话',
  `remark` varchar(2048) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '备注',
  `join_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入时间',
  KEY `open_ids` (`open_id`,`parent_open_id`,`ancestor_open_id`) USING BTREE,
  KEY `jtime` (`join_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='代理信息';

CREATE TABLE `df_rate` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `rate_from` DECIMAL(12,2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '提成层级',
  `rate` DECIMAL(4,2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '提成比例',
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='提成信息';

CREATE TABLE `df_order` (
  `id` bigint primary key,
  `agent_open_id` varchar(100) NOT NULL COMMENT '代理人微信id',
  `buyer_open_id` varchar(100) NOT NULL COMMENT '购买人微信id',
  `buyer_name` varchar(100) NOT NULL COMMENT '收货人姓名',
  `buyer_phone` varchar(100) NOT NULL COMMENT '收货人电话',
  `province` varchar(100) NOT NULL COMMENT '收货地址-省',
  `city` varchar(100) NOT NULL COMMENT '收货地址-市',
  `county` varchar(100) NOT NULL COMMENT '收货地址-区县',
  `detail_info` varchar(100) NOT NULL COMMENT '收货地址-详细地址',
  `postal_code` varchar(100) COMMENT '收货地址-邮编',
  `total_quantity` int NOT NULL COMMENT '订单包含商品总数',
  `original_total` decimal(12,2) NOT NULL COMMENT '原始金额',
  `discount` decimal(12,2) COMMENT '折扣',
  `real_total` decimal(12,2) NOT NULL COMMENT '实际金额',
  `order_status` varchar(20) NOT NULL COMMENT '订单状态（下单，付款，邮寄，结束）',
  `remark` varchar(2048) COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `id` (`id`) USING BTREE,
  KEY `ctime` (`created_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单信息';


CREATE TABLE `df_order_line` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `product_id` bigint NOT NULL COMMENT '水果id',
  `product_name` varchar(100) NOT NULL COMMENT '水果名称',
  `line_status` varchar(20) NOT NULL COMMENT '订单状态（下单，付款，邮寄，结束）',
  `quantity` int NOT NULL COMMENT '数量',
  `original_price` decimal(12,2) NOT NULL COMMENT '原始金额',
  `real_price` decimal(12,2) NOT NULL COMMENT '实际金额',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `id` (`id`) USING BTREE,
  KEY `ctime` (`created_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单下各个商品详细信息';


CREATE TABLE `df_admin` (
  `open_id` varchar(100) COLLATE utf8mb4_unicode_ci COMMENT '微信openId',
  `admin_name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `admin_phone` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
  `remark` varchar(2048) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '备注',
  `join_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入时间',
  KEY `phone` (`admin_phone`) USING BTREE,
  KEY `jtime` (`join_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员信息';


create table df_agent_price (
  `agent_open_id` varchar(100) NOT NULL COMMENT '代理人微信id',
  `product_id` bigint NOT NULL COMMENT '水果id',
  `agent_price` decimal(12,2) NOT NULL COMMENT '自定义价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='代理价信息';

create table df_product (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `attIds` bigint default 0 COMMENT '属性Id集合',
  `product_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '水果名称',
  `description` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '水果描述',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '备注',
  `image_url` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片地址',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `f_id` (`id`) USING BTREE,
  KEY `ctime` (`created_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='水果信息';


create table df_product_price (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `valIds` varchar(100) NOT NULL default '' COMMENT '属性值Id集合',
  `agent_price` decimal(12,2) NOT NULL COMMENT '代理价',
  `sale_price` decimal(12,2) NOT NULL COMMENT '零售价',
  `description` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '水果描述',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '备注',
  `image_url` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片地址',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `f_id` (`id`) USING BTREE,
  KEY `ctime` (`update_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='水果信息';

create table df_product_attr (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `attr` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '属性名称',
  KEY `aid` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='水果属性表';


create table df_product_attr_val (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `attid` bigint ,
  `val` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '属性值',
  KEY `vid` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='属性名称表';
