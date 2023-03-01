# 建立钱包数据库
create schema purse;

# 创建用户信息表
create table purse.user
(
    id          bigint auto_increment comment '用户id',
    user_account   varchar(20)                         not null comment '用户账号',
    money       bigint    default 0                 not null comment '用户余额',
    version     tinyint   default 1                 not null comment '版本号',
    deleted     int       default 0                 not null comment '是否删除（0-存在，1-删除）',
    create_time timestamp default current_timestamp not null comment '创建时间',
    update_time timestamp default current_timestamp null on update current_timestamp comment '修改时间',
    constraint user_pk
        primary key (id)
)
    comment '用户信息表';

# 创建用户消费记录表
create table purse.history
(
    id           bigint auto_increment comment '交易条目序号',
    user_account varchar(20)                         not null comment '用户账号',
    user_action  tinyint   default 0                 not null comment '0-未知 1-消费 2-退款',
    changed_money        bigint    default 0                 not null comment '操作金额数',
    total_money          bigint    default 0                 not null comment '总金额数',
    create_time  timestamp default current_timestamp not null comment '操作时间',
    constraint history_pk
        primary key (id)
)
    comment '历史交易明细表';