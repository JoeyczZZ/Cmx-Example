CREATE DATABASE cmx;

create table `auth_user` (
    `id` varchar(32) not null primary key comment 'id',
    `account` varchar(32) not null comment '账号',
    `password` varchar(128) not null comment '密码',
    `deleted` tinyint(1) not null default 0 comment '是否删除',
    `created_at` datetime not null comment '创建时间',
    `updated_at` datetime not null comment '更新时间',
    `updated_by` varchar(32) not null comment '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';