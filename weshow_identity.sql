create table identity
(
    id      bigint auto_increment
        primary key,
    user_id bigint                      not null comment '用户id',
    number  varchar(20) charset utf8mb4 not null comment '身份证号',
    name    varchar(10) charset utf8mb4 not null comment '姓名'
)
    comment '用户身份证表' charset = latin1;

INSERT INTO weshow.identity (id, user_id, number, name) VALUES (3, 26, '123456789123456789', '测试1');
INSERT INTO weshow.identity (id, user_id, number, name) VALUES (4, 26, '440921477979464646', '陈松松');
create table order_list
(
    id            bigint auto_increment comment '订单id'
        primary key,
    order_sn      char(100)                                not null comment '订单号',
    user_id       bigint                                   not null comment '用户id',
    show_id       bigint                                   not null comment '演出id',
    ticket_id     bigint                                   not null comment '售票id',
    seat_no       int                                      null comment '座位号，按售票顺序生成',
    order_amount  decimal(18, 4) default 0.0000            not null comment '订单总金额',
    order_status  tinyint        default 0                 not null comment '订单状态,0待支付，1已支付，2退票中，3已退票，4已关闭',
    delete_status tinyint        default 0                 not null comment '删除状态，0未删除，1已删除',
    create_time   datetime       default CURRENT_TIMESTAMP not null comment '订单创建时间',
    update_time   datetime                                 null comment '订单修改时间',
    payment_time  datetime                                 null comment '支付时间',
    payment_type  tinyint                                  null comment '支付方式，1支付宝，2微信'
)
    charset = utf8;

INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (919, '1382920940823908352', 26, 30, 8, null, 160.0000, 1, 0, '2021-04-16 12:57:00', null, '2021-04-16 12:57:00', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (920, '1382947889759784960', 26, 28, 15, null, 200.0000, 1, 0, '2021-04-16 14:44:05', null, '2021-04-16 14:44:06', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (922, '1385478166147108864', 26, 32, 18, null, 80.0000, 0, 1, '2021-04-23 14:18:30', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (923, '1385482573110710272', 26, 32, 18, null, 80.0000, 2, 1, '2021-04-23 14:36:01', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (924, '1385593866396241920', 26, 29, 16, null, 80.0000, 3, 1, '2021-04-23 21:58:15', null, '2021-04-23 21:58:16', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (925, '1385598206867542016', 26, 29, 16, null, 80.0000, 3, 1, '2021-04-23 22:15:30', null, '2021-04-23 22:15:30', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (926, '1385622909099315200', 26, 29, 16, null, 160.0000, 3, 1, '2021-04-23 23:53:40', null, '2021-04-23 23:53:40', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (927, '1385624411641614336', 26, 29, 16, null, 160.0000, 3, 0, '2021-04-23 23:59:38', null, '2021-04-23 23:59:39', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (928, '1385626029472747520', 26, 32, 18, null, 160.0000, 3, 0, '2021-04-24 00:06:04', null, '2021-04-24 00:06:04', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (929, '1386120852675891200', 26, 26, 13, null, 30.0000, 1, 0, '2021-04-25 08:52:19', null, '2021-04-25 08:52:20', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (930, '1386126109283848192', 26, 26, 13, null, 30.0000, 1, 0, '2021-04-25 09:13:12', null, '2021-04-25 09:13:13', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (931, '1386145137415032832', 26, 29, 16, null, 160.0000, 1, 0, '2021-04-25 10:28:48', null, '2021-04-25 10:28:49', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (932, '1393052775042125824', 26, 31, 17, null, 160.0000, 1, 0, '2021-05-14 11:57:18', null, '2021-05-14 11:57:19', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (933, '1393057904818524160', 26, 44, 34, null, 1400.0000, 3, 1, '2021-05-14 12:17:40', null, '2021-05-14 12:17:41', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (934, '1393063083152379904', 26, 44, 36, null, 4000.0000, 3, 1, '2021-05-14 12:38:15', null, '2021-05-14 12:38:16', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (935, '1393065915486179328', 26, 44, 35, null, 3400.0000, 3, 1, '2021-05-14 12:49:30', null, '2021-05-14 12:49:31', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (936, '1393066673824731136', 26, 44, 36, null, 4000.0000, 3, 0, '2021-05-14 12:52:31', null, '2021-05-14 12:52:32', 1);
create table order_return
(
    id            bigint auto_increment comment 'id'
        primary key,
    order_id      bigint                             not null comment '订单id',
    admin_id      bigint                             null comment '处理人id',
    create_time   datetime default CURRENT_TIMESTAMP null comment '申请时间',
    handle_time   datetime                           null on update CURRENT_TIMESTAMP comment '处理时间',
    return_status tinyint  default 0                 not null comment '退票状态，0待处理，1已退票，2已拒绝',
    return_money  decimal(18, 4)                     null comment '退款金额'
)
    charset = utf8;

INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (1, 20014, 1001, '2021-03-18 23:04:30', '2021-03-18 23:51:34', 1, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (2, 20015, 1001, '2021-03-18 23:04:35', '2021-03-18 23:51:42', 1, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (3, 20016, 1001, '2021-03-18 23:04:41', '2021-03-18 23:51:44', 2, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (4, 20017, 1001, '2021-03-18 23:04:45', '2021-03-18 23:51:57', 1, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (5, 20018, 1001, '2021-03-18 23:04:48', '2021-03-19 00:39:19', 1, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (6, 20019, null, '2021-03-18 23:04:51', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (7, 20019, null, '2021-03-18 23:04:53', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (8, 20019, null, '2021-03-18 23:04:53', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (9, 20020, null, '2021-03-18 23:04:58', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (10, 20020, 1001, '2021-03-18 23:04:59', '2021-04-23 16:52:53', 1, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (11, 20020, null, '2021-03-18 23:04:59', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (12, 20020, null, '2021-03-18 23:05:00', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (13, 20020, null, '2021-03-18 23:05:00', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (14, 20020, null, '2021-03-18 23:05:01', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (15, 20020, null, '2021-03-18 23:05:01', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (16, 20020, null, '2021-03-18 23:05:02', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (17, 20020, null, '2021-03-18 23:05:03', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (18, 20020, null, '2021-03-18 23:05:03', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (19, 922, 1001, '2021-04-23 14:19:37', '2021-04-23 16:52:52', 1, 80.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (20, 923, 1001, '2021-04-23 14:36:10', '2021-04-23 16:52:58', 1, 80.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (21, 924, 1001, '2021-04-23 22:18:45', '2021-04-23 23:18:52', 1, 80.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (22, 925, 1001, '2021-04-23 23:19:34', '2021-04-23 23:21:07', 1, 80.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (23, 926, 1001, '2021-04-23 23:55:11', '2021-04-23 23:55:27', 1, 160.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (24, 927, 1001, '2021-04-24 00:00:01', '2021-04-24 00:00:10', 1, 160.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (25, 928, 1001, '2021-04-24 00:06:34', '2021-04-24 00:06:40', 1, 160.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (26, 933, 1001, '2021-05-14 12:18:11', '2021-05-14 12:20:32', 1, 1400.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (27, 934, 1001, '2021-05-14 12:39:22', '2021-05-14 12:39:28', 1, 4000.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (28, 935, 1001, '2021-05-14 12:49:59', '2021-05-14 12:50:57', 1, 3400.0000);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (29, 936, 1001, '2021-05-14 12:53:04', '2021-05-14 12:55:11', 1, 4000.0000);
create table permission
(
    id               bigint auto_increment comment 'id'
        primary key,
    pid              bigint                                null comment '上级id',
    persmission_name varchar(20) default '0'               null comment '名称',
    permission_type  tinyint                               null comment '类型，1菜单，2按钮',
    permission_value varchar(50)                           null comment '权限值',
    path             varchar(100)                          null comment '访问路径',
    component        varchar(100)                          null comment '组件路径',
    icon             varchar(50)                           null comment '图标',
    status           tinyint     default 1                 null comment '状态，0禁止，1正常',
    status_delete    tinyint     default 0                 null comment '是否被删除，0未删除，1已删除',
    create_time      datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    modified_time    datetime                              null comment '修改时间'
)
    charset = utf8;


create table recommend
(
    id          bigint auto_increment
        primary key,
    show_id     bigint                             null comment '演出id',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '首页推荐' charset = latin1;

INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (2, 2, '2021-03-31 12:43:36');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (4, 30, '2021-04-12 18:08:00');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (5, 27, '2021-04-12 18:08:12');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (6, 34, '2021-04-23 22:47:57');
create table role
(
    id            bigint auto_increment comment 'id'
        primary key,
    role_name     varchar(20)       not null comment '角色名',
    role_code     varchar(20)       null comment '角色编码',
    remark        varchar(255)      null comment '备注',
    status_delete tinyint default 0 null comment '删除状态，0未删除，1已删除'
)
    charset = utf8;


create table role_permission
(
    id            bigint auto_increment comment 'id'
        primary key,
    role_id       bigint            not null comment '角色id',
    permission_id bigint            not null comment '权限id',
    status_delete tinyint default 0 null comment '删除状态，0未删除，1已删除'
)
    charset = utf8;


create table show_comment
(
    id          bigint auto_increment comment 'id'
        primary key,
    show_id     bigint                             not null comment '演出id',
    user_id     bigint                             not null comment '用户id',
    comments    varchar(500) charset utf8mb4       null comment '用户评论',
    create_time datetime default CURRENT_TIMESTAMP not null
)
    comment '评论表' charset = latin1;

INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (7, 31, 26, '22222', '2021-04-23 01:40:27');
INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (9, 30, 26, 'Hello World', '2021-04-23 11:48:55');
INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (10, 26, 27, '77777后撤步', '2021-04-24 18:11:57');
INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (11, 26, 26, '哈哈哈哈', '2021-04-24 18:12:25');
INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (12, 34, 27, '好想看！！！', '2021-04-25 10:15:51');
INSERT INTO weshow.show_comment (id, show_id, user_id, comments, create_time) VALUES (14, 35, 26, '211113', '2021-05-14 12:34:22');
create table show_heat
(
    id       bigint auto_increment comment 'id
'
        primary key,
    show_id  bigint        not null comment '演出id',
    clicks   int default 0 null comment '点击数',
    likes    int default 0 null comment '点赞数',
    comments int default 0 null comment '评论数',
    heat     int default 0 null comment '总热度'
)
    comment '演出热度' charset = latin1;

INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (1, 23, 20, 0, 0, 20);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (2, 1, 11, 0, 0, 11);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (3, 24, 2, 0, 0, 2);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (4, 25, 26, 1, 0, 27);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (5, 26, 21, 0, 0, 21);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (6, 27, 3, 0, 0, 3);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (7, 28, 7, 0, 0, 7);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (8, 29, 45, 0, 0, 45);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (9, 30, 245, 1, 0, 246);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (10, 31, 47, 1, 0, 48);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (11, 32, 145, 1, 0, 146);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (12, 33, 10, 0, 0, 10);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (13, 2, 1, 0, 0, 1);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (14, 3, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (15, 4, 50, 0, 0, 50);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (16, 34, 16, 0, 0, 16);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (17, 35, 17, 0, 0, 17);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (18, 36, 5, 0, 0, 5);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (19, 37, 8, 0, 0, 8);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (20, 38, 2, 0, 0, 2);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (21, 39, 1, 0, 0, 1);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (22, 40, 1, 0, 0, 1);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (23, 41, 1, 0, 0, 1);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (24, 42, 2, 0, 0, 2);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (25, 43, 1, 0, 0, 1);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (26, 44, 36, 1, 0, 37);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (27, 45, 8, 1, 0, 9);
create table show_list
(
    id             bigint auto_increment comment 'id'
        primary key,
    showtype_id    bigint                             not null comment '演出类型id',
    show_name      varchar(100)                       not null comment '演出名',
    show_intro     varchar(5000)                      null comment '简介',
    show_performer varchar(255)                       not null comment '演出者',
    show_city      varchar(20)                        not null comment '演出城市',
    show_place     varchar(255)                       not null comment '演出地点',
    show_time      datetime                           not null comment '演出时间',
    end_time       datetime                           null comment '结束时间',
    show_poster    varchar(500)                       null comment '演出海报',
    show_mobile    varchar(20)                        null comment '联系方式',
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
    charset = utf8;

INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (1, 1, '贰叁叁脱口秀', null, '笑声收割机', '上海', '上海市Track Time', '2021-07-25 14:00:00', '2021-02-27 15:30:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/55ac208d-9f4f-42e9-b2c8-e591a2c6efea.webp', '17344774527', '2021-02-25 09:53:14');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (2, 2, '白夜行', null, '韩雪、刘令飞', '北京', '北京天桥艺术中心大剧场', '2021-03-13 14:00:00', '2021-03-13 17:00:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/35498f57-edbc-49ae-9295-0cd86aebf379.webp', '88866888888', '2021-02-25 09:56:01');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (3, 2, '白夜行', null, '韩雪、刘令飞', '北京', '北京天桥艺术中心大剧场', '2021-04-13 19:30:00', '2021-03-13 22:30:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/16165088-1588-493a-a597-93f39265877a.jpg', '88866666666', '2021-02-25 09:56:53');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (4, 1, '"共同渡过"缅怀张国荣金曲演唱会', '11', 'Harmony', '广州', '广州中山纪念堂', '2021-04-01 19:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/3e0b11c7-5f18-4802-ae1a-7885245388fa.jpg', '17474747474', '2021-02-26 11:03:03');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (23, 5, '阿黛尔&艾德希兰 致敬音乐会', '2020 珍珠致敬音乐会系列火力全开，LIVE 粉丝的极致音乐狂潮，火热预售中！

热度高居不下的珍珠招牌Live现场

时代天王偶像致敬之夜

下班放松的必备打卡Live 

现场场场惊喜，场场感动

 

跟着熟悉的节奏旋律

珍珠剧场2020年12月2日 &  12月16日 & 12月30日再度起航

 

听腻了国语LIVE的你，需要来THE PEARL唤醒一下你的【国际细胞】收到无数热评追捧的Adele& Ed Sheeran tribute 之夜。由珍珠剧场王牌乐队RED STAR倾力打造，联合惊喜嘉宾，从外貌到唱功都让你高呼惊绝的现场，期待你的加入！

位列2020 THE PEARL珍珠现场音乐会热门榜单排行TOP 前三名，Adele & Ed Sheeran 致敬音乐会现场一经开启便获得观众们的一致好评，接连售罄，场场感动。下半年预热二度发车，惊喜连连，向偶像致敬！

 

有着格莱美“宠儿”之称的Adele阿黛尔，与才华横溢的年轻创作歌手Ed Sheeran 艾德希兰，两个非同一时期的创作型歌手，但都拥有21世纪唱片销量之王的称号，深受粉丝们追捧与喜爱。

当两股不同的魅力碰撞在一起，现场将会摩擦出怎样的火花？

 

由THE PEARL 珍珠剧场音乐全能王RED STAR 联合DAVE STONE 倾情演绎，致敬时代偶像。

 

除了现场天籁般的听觉享受外，两位在外形上也极度相似，加入这场名副其实的视听盛宴，红遍全球的经典旋律 Rolling in the deep…shape of you …以及更多…你将一一在现场感受音乐家们用音乐传递出的激情与热爱，让我们共同向时代偶像致敬，快乐回归，迟到的狂欢不容错过！

 

活动地点：上海市虹口区乍浦路471号靠近武进路，地铁10号线2号出口，步行200米。', 'DAVE STONE', '上海', '珍珠剧场The Pearl', '2021-04-21 20:00:00', '2021-04-22 02:00:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/60b4c054-c3f9-49eb-b1bd-d2f24d52b151.webp', '18293337373', '2021-04-11 18:03:14');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (24, 1, '《不知所措》《善变》《爱，存在》原唱——王靖雯个人专场', '19岁，对于大多数女孩来说，是上大学的第二年，可能正在为了四六级、爱豆、专业课绩点、男朋友、寝室关系、秃头而发愁。

19岁，对于王靖雯来说，是灰烬中燃起的星光，正在为了权衡生活与梦想的重量而发愁的她，初次触到了梦想的形状。

19岁，对于你来说，是什么？是否也正在“不知所措”呢？

 

几个月前的王靖雯还只是一个爱唱歌的东北姑娘，还在为自己的生计盘算着，从糕点店辞职，再到酒吧驻唱，勉强维持着日常生活。低头打工，抬头看路。王靖雯从未忘记过自己对唱歌的向往，在所剩无几的空余时间里，她会发布自己的翻唱作品到一些短视频平台上，借以慰藉与喘息。

 

幸好生活没有辜负王靖雯，凭着极具辨识度的嗓音，音乐公司「HIKOON MUSIC」在今年5月份发现了她，并和她正式签约，由此王靖雯正式开启了自己的音乐职业道路。7月27日，在公司的帮助下，王靖雯终于发行了第一首完全属于自己的原唱作品《不知所措》。

 

最灿烂的烟火总是先坠落，越是暖的经过反而越折磨。

很快，《不知所措》掀起了一场"情歌风暴"。不仅在QQ音乐和快手两大平台均斩获破亿播放量，更是凭借超2.2亿播放量、800万收藏量的惊人成绩，登顶QQ音乐热歌榜、流行指数榜等五大榜单。风靡QQ音乐的同时，《不知所措》也一路火出圈，刷屏快手等短视频平台，成为今夏必听的情歌。不同于以往的翻唱歌曲，略带沙哑的女嗓音伴随着悠扬的琴曲让听者无一不沉浸于歌曲的情愫中。

 

在发布这首《不知所措》之前，王靖雯不胖一直有在翻唱这类歌曲。6月中旬，其翻唱由魏奇奇演唱的《流星花园》电视剧插曲《爱，存在》即属于同类主题的歌曲。她表示，该歌曲刚刚发行的时候她就一直单曲循环听了很久，“很多人应该也都很喜欢这首作品，可能是她翻唱的版本带给了大家新的感觉，赋予了一种新的味道。”', '王靖雯', '济南', '济南 Caper Land雀跃之地音乐现场', '2021-05-22 19:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/2419fa2f-7470-4102-b00b-c8135a4dff2f.webp', '12938383333', '2021-04-11 18:12:06');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (25, 5, '草台回声「呦呦麓鸣」 2021音乐会-成都麓湖专场', '2021用音乐开启新的一年，当"解忧爵士"Mr. Miss,遇上音乐诗人莫西子诗加上假斯文FakeGentle的自由不羁有思考、有力量、有自由用声音武装到灵魂，3月27日在成都麓湖水上剧场，新一年的快乐从这里开始！', 'Mr. Miss,莫西子诗,假斯文', '成都', '成都麓湖水上剧场', '2021-05-18 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/623ff35f-ca0f-4cf6-9124-6c50d9e654a9.webp', '19282337373', '2021-04-11 18:17:17');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (26, 6, '广州市第一届高中说唱表演赛', null, '高中生', '广州', '广州市海珠区新港东路1066号中州中心国茶荟负一层TU凸空间', '2021-05-01 17:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/8fe6fbc0-c44a-4f33-b087-638b9d66fa51.webp', '17444465626', '2021-04-12 15:41:52');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (27, 5, '夜猫俱乐部 · 梦幻歌舞厅 · 全场畅饮', '歌舞厅随着改革开发的风潮席卷了上个世纪七八十年代，在那个身体解禁年代，小心翼翼画着优美华尔兹的圈，随着音乐摇摆出属于自己的舞步，是当时的年青男女喜闻乐见的集体社交活动。', 'Moony慕尼、showN、DJ PD、DJ sota_iw', '广州', '广州市海珠区新巷东路1088号六元素体验天地一层', '2021-05-01 19:00:00', '2021-05-02 23:00:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/1f01dea7-a2b3-4119-8b7a-08c903a94d80.webp', '17777777777', '2021-04-12 15:47:05');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (28, 2, '2021开年大戏 《尘埃落定》【复活经典 九维钜献】', '长篇小说《尘埃落定》是当代著名作家阿来的代表作，以一个有先知先觉能力的傻子少爷的视角，讲述雪域高原上最后一个土司家族的崩溃，以诗性灵动的语言，书写了一个时代尘埃起落的寓言。

把经典搬上舞台，用诗意的语言忠于原著，展现一部置于天地之间恢弘大作。让我们于文明尘埃里，令诗意重生，为众生立传，为万物命名，于命运无常来临之前，见天地、见苍生、见自己。

 
《尘埃落定》是什么？


作为第五届茅盾文学奖获奖作品，《尘埃落定》是第一部也是一部获奖的藏族小说，拥有中、英、法、德、意等十五国译本，写满生与死、智慧与愚妄、情欲与权力、爱情与背叛、信仰与奴役、复仇与诅咒、枪炮与糜烂之毒、魔幻与现实、万物与众生。豆瓣读书评分高达9.1，销量逾百万册。

这是一部古老文明边缘的“权力游戏”，也是一部中国版的“百年孤独”，让一位诞生于四川藏区的“阿甘式”人物，带领众生回归那个天真未凿、众生皆妄、万物有灵的魔幻时代，重新感受那段土司文明末路时的荒蛮刚勇与血性浪漫。', '四川人民艺术剧院', '广州', '广州大剧院歌剧厅', '2021-04-23 19:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/9aa0128d-0caa-496d-ba9e-957d9cc46b0a.webp', '17488976466', '2021-04-12 15:49:31');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (29, 2, '开心麻花首部悬疑惊悚喜剧《醉后赢家》', null, '开心麻花', '广州', '广东省友谊剧院', '2021-04-30 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/f707e176-7106-49b8-8be7-b3aa6b1269d1.webp', '17464644545', '2021-04-12 15:52:38');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (30, 2, '日本圆谷版奥特曼系列舞台剧——《奥特传奇之英雄归来》杭州站', '托雷基亚想得到卢克多 行星强大的科技力量，来完成自己【扰乱宇宙】的野心，于是他开展了残忍的侵略计划。

为保护卢克多 的和平，奥特战士们和托雷基亚展开了战斗。不料遭遇到邪恶军团的埋伏，受到重创，甚至还被分别击飞到三个星球，失去了力量。

卢克多 少女法拉持有的家族秘传水晶，拥有着不可思议的力量。在被托雷基亚追杀之际，正是奥特战士们保护了她。为了拯救故乡，法拉踏上了寻找奥特战士的旅程。

而在同一时间，奥特战士们分别在三颗星球上遇到了三位性格迥异的当地人。他们有的是地球防卫队队员，有的是厌恶战争的少年，还有性格软弱的猎人。这些新伙伴将和奥特战士们如何相处？法拉能够顺利找到奥特战士，并帮助他们恢复力量吗？托雷基亚的邪恶计划会得到阻止，让卢克多最终恢复往日和平吗？

还有更多秘密，都藏在故事里……', '圆谷', '杭州', '杭州剧院', '2021-04-24 10:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/ec005b2c-b028-4bce-a670-814b0bde545c.webp', '14848646464', '2021-04-12 15:55:46');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (31, 5, '音乐的奥妙——宫崎骏の久石让经典动漫亲子音乐会', '献给孩子成长的礼物
给孩子一把钥匙，开启孩子音乐梦想！
近距离、大乐队、私家亲子音乐会
Memory of love and music
音乐的奥妙——宫崎骏の久石让经典动漫亲子音乐会


“当久石让的经典遇上宫崎骏的童话”
一场国际范儿的高端合家欢音乐会

在这个Summer，乘着纸飞行机，从哈尔的移动城堡出发，与千寻穿越过风之谷，和魔女徜徉在神秘的天空之城，带天真童趣的龙猫在旋转木马上放飞童梦……
感谢音乐大师与动漫巨匠碰撞出传世经典的火花，它曾经给我们童年创造了许多美好的回忆，如今它将再度为您和宝贝刻画一段记忆中的永恒。


精选曲目：
1、天空之城
2、龙猫
3、菊次郎的夏天
4、千与千寻
5、魔女宅急便
6、幽灵公主
7、风之谷
8、悬崖上的金鱼姬
9、哈尔的移动城堡 —— 人生的旋轉木馬
10、起风了 —— 纸飞行机
*曲目以当天演出为准。', '巴洛克管弦乐团', '广州', '广州市星海音乐厅室内乐演奏厅', '2021-05-16 10:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/86ce105e-d37b-47db-a4e0-5ed4d69c7541.webp', '14478978997', '2021-04-12 16:01:38');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (32, 7, '子弹飞王者征途X6格斗冠军赛（选拔赛）', '4月17日晚19:00，子弹飞王者征途X6选拔赛即将震撼开打！五场比赛，十位选手，圆梦起航，谁能脱颖而出？

选手已准备就绪，大战一触即发！', '孙柏 VS 李德扬，周文云 VS 刘玉涛， 马烨 VS 王子剑，吴昌硕 VS 徐允志', '北京', '中国·北京宋庄子弹飞大宋拳场', '2021-05-01 19:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/92c70ae4-c205-47b1-aa8e-f341a2320076.webp', '14477979798', '2021-04-12 16:06:16');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (33, 7, '2020东京奥运会女足亚洲区预选赛附加赛（第二回合）', null, 'CHINA PR 中国  vs   OREA REPUBLIC 韩国', '苏州', '苏州市苏州工业园区中新大道东999号奥林匹克体育中心体育场', '2021-04-13 16:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/8dcaf99d-0b53-4330-998f-c22e8f4f9e03.webp', '17987979797', '2021-04-12 16:08:12');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (34, 1, 'YOLII有理｜「山河令」雪沉xBloody Woods 联合巡演 北京站', null, '雪沉、Bloody Woods', '北京', 'MAO Livehouse北京 ', '2021-05-23 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/6d869cba-f979-4d3c-848b-512239e1b28e.webp', '14654644646', '2021-04-23 16:46:15');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (35, 2, '赖声川编导、何炅×黄忆慈话剧《水中之书》', '2009年，赖声川应中国香港话剧团之邀创作了《水中之书》，这是一部探讨和反思生命价值和意义的作品，围绕金融风暴之后归国创业的主人公，如何在一次偶遇后重新审视自我，改变了人生的轨迹。2016年上剧场复排版《水中之书》对原剧进行了较大的修改，通过反转主角性别，重新设定配角故事线等，让剧情变得更直接、纯粹，赖声川导演亦坦陈："经历了七年，这个作品终于完整了！"', '何炅×黄忆慈', '北京', '天桥艺术中心-大剧场', '2021-07-10 19:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/3dac0892-16f7-4ccc-9bec-fd5e7c88a5e5.webp', '17646441114', '2021-04-24 16:10:18');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (36, 5, '超燃史诗钢琴交响音乐会《Victory》', '《Victory》的创作团队是Two Steps from Hell（又名两步逃离地狱或者地狱边缘）。其在2006年3月正式坐落于美国洛杉矶，是一家专门制作音乐的公司，由尼克菲尼克斯和托马斯·J·柏格森共同创办，他们的音乐类型属于原创配乐。

由于其公司吸收了很多人才，使得其音乐在世界范围内十分出名，《Victory》、《Star Sky》、《Empier Of Angels》等等都是相当出名的作品。', 'N STAR跨界乐团', '深圳', '深圳保利剧院', '2021-05-04 14:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/bb242a6a-e152-4239-b868-ee656e76ec05.webp', '14799616164', '2021-04-24 16:13:39');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (37, 5, '《天空之城》久石让&宫崎骏动漫经典音乐作品演奏会', '经典旋律全新演绎，音乐启蒙最佳选择，

一代宗师匠心独具，大师改编精彩非凡。

宫崎骏与久石让，一位是日本动画电影的领军人物；一位是被誉为“东方威廉姆斯”的日本电影配乐大师。他们是艺术里的天作之合，一同成就了日本动漫史上永恒的经典。他们是世界动漫史上的传奇，他们将世界动漫带入了一个黄金时代。感动了几代人，留下了美好无比的童年回忆。本场音乐会由独具一格的跨界表演乐团爱乐汇轻音乐团以室内乐的形式重新演绎。
久石让，中国年轻一代的动漫迷们都不陌生。久石让的音乐，有一种能勾起心底最纯真的力量，被人们称为触动灵魂的乐者。久石让与宫崎骏的黄金组合创作的《天空之城》、《千与千寻》、《龙猫》、《哈尔的移动城堡》、《幽灵公主》等经典作品深受广大青年朋友的喜爱。天空之城、千与千寻中的经典配乐更是常常作为背景音乐在众多场合中被引用。此外久石让更在电影配乐领域与多位著名导演合作，创作了《菊次郎的夏天》《太阳照常升起》等电影配乐佳作。

这次我们精挑细选出来的每一首作品都很符合音乐会的主题。演奏的内容是根据原曲，邀请了优秀作曲家富有针对性地重新做了编配，打造成适合于爱乐汇轻音乐团演奏的版本：充满天真童趣的《龙猫》、音乐色彩斑斓又不失大和民族特色的《千与千寻》、糅合了美国乡村音乐与民谣风格的《魔女宅急便》、以及融合探戈元素的《天空之城》，可以说是将散落的宝石精心串联起来了；其中的配乐可以说是不俗但是易懂，旋律给人独特的情感享受，有很大的年龄宽容度，不同的观众都可以从中得到美妙的体验。绝对可以让大家重温经典，进一步加深对大师作品的理解，获得真正美好的享受。这一夜，爱乐汇轻音乐团将带着我们，乘着娜乌西卡的飞行器穿越过风之谷，徜徉在萤光闪烁的山林中，再搭乘安静的旧式火车滑过寂静水面，奔向奇妙的神隐之乡……', '爱乐汇轻音乐团', '深圳', '华夏艺术中心大剧院', '2021-04-30 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/19489046-837a-4d1e-8b0f-2c9032230665.webp', '13946464646', '2021-04-24 16:17:16');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (38, 5, '《四月是你的谎言》——“公生”与“薰”的钢琴小提琴唯美经典音乐集', '如果你看过《四月是你的谎言》，
相信你一定会来听音乐会，
这是一场《四谎》乐迷见面会。
如果你没有看过《四月是你的谎言》，
那你一定要看完再来听音乐会，
这是一场钢琴与小提琴的浪漫邂逅。
钢琴：童心
童心，美国茱莉亚音乐学院钢琴硕士；美国耶鲁大学计算机和电子工程系学士；"乐星人"音乐教育平台创始人；美国耶鲁大学谢菲尔德工程杰出学者奖、纽约州长奖获得者；美国国家荣誉协会成员；Kismo人工智能机器人实验室成员；中国"天鹅计划领军人才"。 童心是钢琴大师傅聪先生的关门弟子之一，他的独奏音乐会足迹曾遍布欧、亚、美三大洲。 他获得过包括伍德米尔、芝加哥、辛辛那提世界钢琴大赛在内的多个国际钢琴比赛的大奖。他还代表中国进入钢琴界的奥利匹克-华沙"肖邦国际钢琴大赛"并一举进入决赛圈。童心演奏的巴赫《哥德堡变奏曲》曾破例获得了茱莉亚音乐学院年度最佳音乐会大奖，演出实况录音在纽约古典电台循环播放。在音乐学习的道路上，他还得到了著名钢琴教育家赵晓生教授、但昭义教授、美国传奇钢琴大师Jerome Lowenthal、PeterSerkin、RichardGoode等多位钢琴界前辈的悉心教导。 与此同时，童心还曾就读于美国耶鲁大学电子工程及计算机系，主要研究人工智能机器人，并获得耶鲁大学谢菲尔德工程杰出学者奖、纽约州特别颁发的"杰出学术奖"以及州长"杰出人才奖"。童心的多项科技发明专利也曾被《人民日报》报道，并获得了"天鹅计划领军人才"称号等。
小提琴：钱悦

​青年小提琴演奏家钱悦的演出足迹遍布世界各地。她曾在纽约茱莉亚音乐学院摩斯（Morse）音乐厅，洛杉矶南加州大学纽曼（Newman）音乐厅，上海音乐厅，北京中山音乐堂，深圳音乐厅等多地举办独奏音乐会，还曾受小提琴大师宓多里（Midori）女士及当地音乐家协会邀请，赴洛杉矶、墨西哥、斯里兰卡等地参与公益演出和教学交流活动，受到当地民众的广泛好评。自2019年起，钱悦应邀参加北京现代音乐节，美国茱莉亚音乐学院“FOCUS！”音乐节以及广西东盟音乐周等，与北京当代乐团（Beijing Contemporary Soloists）一同上演了叶小刚、瞿小松、莫五平、陈牧生和Hans Abrahamsen等多位中外著名当代作曲家的优秀作品。后又随团赴四川音乐学院、广西南宁艺术学院演出并参与教学交流活动。
', '童心、钱悦', '深圳', '深圳音乐厅-演奏大厅', '2021-05-15 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/5cb0614a-f964-4b71-944d-cc735e78b6a0.webp', '14797979795', '2021-04-24 16:21:10');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (39, 3, '吉林省德云社·红事会-《相声大会》-长春', '春城人民有耳福了，万众瞩目的吉林德云社，在二道区政府的大力支持下，将在年后花开春城，届时郭德纲将携手于谦一起为春城人民带来无数的欢声笑语，红事会餐饮集团携手德云社，倾力打造的吉林德云社，是推动春城人民精神文明建设的创举，让春城人民在紧张忙碌的生活中，多了一个可以放松心情，收获快乐的去处。

剧场装修古色古香，舒适自然。能容纳近350人，舞台灯光先进，并设有中央空调，保安监控和楼宇自控系统。舞台有超大面积的LED平面显示屏，高质量的建造声学、灯光、电声设计，足以满足任何演出要求。剧场门口，首先映入眼帘的是，门口的两尊白色石象，和朱红色大门，正应"朱门为客启，白象引祥来。"各位春城的纲丝，年后我们不见不散。以后的每个周二至周日，让我们一起来德云社，在笑声中度过。', '德云社', '长春', '长春德云社剧场', '2021-05-25 19:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/32eb8c7e-25a5-4980-8e53-04b56120062b.webp', '13649979552', '2021-04-24 16:23:29');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (40, 7, '万国体育-儿童击剑课', '万国体育2006年8月成立于北京，前身为万国击剑，起步于击剑运动培训。万国体育旨在促进击剑运动和击剑文化在中国的普及发展，为广大青少年和成年人群提供专业化、高品质的击剑培训服务，被授予“国家级青少年体育俱乐部”称号。

 

万国体育秉承“铸剑育人、承载未来”之理念，希望让更多的大众认识并了解这项力量与智慧并存的运动。让青少年通过击剑得到体魄的锻炼、品格的塑造及潜能的发掘，使其成为健康、高尚、坚韧和睿智的一代。

 

万国体育拥有以前国家男子重剑队主教练肖剑、前加拿大国家队及奥林匹克队教练米歇尔·德苏罗、原国家队男子重剑组教练胡焕强、为代表的，包括多名前国家击剑队主教练、国际和国内的击剑冠军在内的近500人的教练团队。

 

公司建立了包括体能、技术、实战课程在内的完整教学课程体系和赛事考级体系，六大板块包括：公共和私教课程、学员分级和考级、课外辅助活动、教练员培训、电教课程、实战及赛事参与。

 

成立十余年来，分别在全国各一、二线核心城市（目前为北京、深圳、广州、上海、佛山、西安、杭州、武汉、成都、重庆、合肥、郑州）开设了23家击剑培训中心，在册会员共计近3万人，累计培养会员约15万人。场馆总面积超过13万平方米，拥有超过600条的国际比赛标准剑道。', '万国体育', '北京', '北京海淀综合运动中心', '2021-05-30 08:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/41ccaa88-0534-4ffb-8f72-c0953f3266bb.webp', '13777777465', '2021-04-24 16:28:07');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (41, 7, '北京冠军跳伞', null, '跳伞冠军', '张家口', '丹霞飞行小镇', '2021-10-01 00:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/51189a65-034e-4972-bc38-783e7b76461d.webp', '14646134642', '2021-04-24 16:30:57');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (42, 6, '机核网核聚变 2021 北京站', '新冒险——「弧光行动」启动！

「弧光行动」是核聚变现场首次尝试的“大型线上+线下实景互动冒险游戏”。

来到核聚变现场，使用「弧光行动」小程序，你不仅可以根据剧情完成线上游戏任务，还能在线下进行实景探索，其中有解谜的脑力考验，也有线下调查的观察力比拼，既可以组队也可以独自勇敢前行。当你看到这儿的一刻，冒险就已经开始，我们邀请你一起参加。', '无', '北京', '北京亦创国际会展中心', '2021-06-13 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/4c870b78-ebf3-4a06-a30f-abe7e800f10e.webp', '14644651615', '2021-04-24 16:33:49');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (43, 5, '周杰伦作品音乐剧《不能说的秘密》', '周杰伦作品音乐剧《不能说的秘密》是由百老汇托尼奖导演得主John Rando执导、知名小说家Marc Acito编剧的优质华语原创音乐剧。为了让舞台剧观众在重温经典中感受新的惊喜，《不能说的秘密》从周杰伦出道16年专辑中，选取25首歌曲。每一首都是脍炙人口的周氏经典，《晴天》和《双节棍》列于曲目表中。 　　请美国百老汇托尼奖得主团队助力舞台化，联手打造亚洲原创音乐剧标杆。 　　托尼奖导演John Rando、美国知名小说家Marc Acito编剧、受推崇的舞蹈家Zach Woodlee、托尼奖舞美布景Beowulf Boritt，以《KINKY BOOTS》获得托尼奖音响设计的John Shivers，制作人Marc Routh及Simone Genatt担任制作人。

 

全剧选取了二十多首周杰伦各种不同风格的歌曲，担负起了每一幕每一场讲故事的剧情转折衔接，同时引入了百老汇经典的大场面群舞，强化故事里关于爱情与亲情最感动人的时刻。音乐剧中不仅加入了电影中所没有的大量歌曲元素，还打造了一个出乎意料却又让人笑中带泪的新结局。', '美国百老汇主创团队', '杭州', '余杭大剧院', '2021-07-16 19:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/7e663f5c-2f35-4ba1-9a8c-b9b81402fbe3.webp', '14793464444', '2021-04-26 01:23:19');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (44, 1, '周杰伦2020嘉年华世界巡回演唱会--海口站', '历时三年的周杰伦「地表最强」世界巡回演唱会，今年5月在巴黎划下完美句号，周杰伦与全球歌迷一起缔造120场无可取代的回忆！今年10月他的第八套世界巡回演唱会即将启动，已与制作团队开过无数次会议的他，将再度以超乎常人的毅力、超越自我的创意带來他的最新一套演唱会：周杰伦「嘉年华」世界巡回演唱会！这场演唱会同时也是他迈向乐坛20年的一场深具意义的演唱会！为了庆祝20周年，演唱会将以欢乐的元素作为主轴，总是引领风潮、总是令人惊呼连连的周杰伦，会有什么出人意外的惊喜、与歌迷一同迎向自己在乐坛的20年？令全球万千乐迷屏息以待！

改变世界往往在一瞬之间，当苹果掉到牛顿头上的时候，或者是当周杰伦的手放在钢琴上的那一刻！周杰伦出道的20年，绝对是华语流行乐坛重要的20年！庆祝辉煌20年的时刻，周杰伦将带领粉丝进入他怎样的音乐世界呢？最新出炉的演唱会海报，歌迷已经可以一窥「嘉年华」演唱会充满欢乐元素的风貌，海报中帘幕拉开，周杰伦神秘且自信地手捧水晶球，而水晶球里又有一个周杰伦漂浮其中，引人好奇！背景的游乐园，摩天轮、旋转木马…彷彿已经转动着，周杰伦的首张专辑封面、牛仔帽、水手救生圈、彩色气球、忍者飞镖......等诸多音乐作品的元素也跃然纸上，在预告这场精彩绝伦的「嘉年华」即将开展……

周杰伦的每一场演唱会都在视觉、听觉上给歌迷带来巨大的震撼。而全新主题的巡演也会向更高的极限挑战，不知道天王这次又准备带来怎样的惊喜！
全新主题、全新造型、全新视听盛宴！请广大歌迷们拭目以待。Amazing！Unbelievable！一起期待吧！', '周杰伦', '海口', '海口市五源河体育中心体育场', '2021-08-05 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/c7ea6d8a-b082-40ff-aad7-550676d6180d.webp', '18022839813', '2021-04-26 01:25:04');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (45, 1, '周杰伦【嘉年华】世界巡回演唱会 信宜站', '"嘉年华"全新巡演是周杰伦庆祝出道20年的演唱会，整场演出为歌迷打造fantasy的音乐王国，将有多首经典歌曲引爆全场，带来空前盛况。', '周杰伦', '信宜', '玉都大剧院', '2025-05-20 20:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/898a70f0-d86f-4a4a-9513-9c93662264e7.webp', '18244969528', '2021-04-26 01:26:37');
create table showtype
(
    id        bigint auto_increment
        primary key,
    show_type varchar(20) null comment '演出类型'
)
    charset = utf8;

INSERT INTO weshow.showtype (id, show_type) VALUES (1, '演唱会');
INSERT INTO weshow.showtype (id, show_type) VALUES (2, '话剧歌剧');
INSERT INTO weshow.showtype (id, show_type) VALUES (3, '曲苑杂坛');
INSERT INTO weshow.showtype (id, show_type) VALUES (4, '舞蹈芭蕾');
INSERT INTO weshow.showtype (id, show_type) VALUES (5, '音乐会');
INSERT INTO weshow.showtype (id, show_type) VALUES (6, '休闲展览');
INSERT INTO weshow.showtype (id, show_type) VALUES (7, '体育比赛');
create table ticket
(
    id            bigint auto_increment comment 'id'
        primary key,
    show_id       bigint                                not null comment '演出id',
    seat_type     varchar(50) default '默认'              null comment '座位类型',
    seat_price    decimal(18, 4)                        null comment '座位价格',
    seat_number   int                                   not null comment '座位数量',
    current_no    int         default 1                 not null comment '当前座位号',
    seat_surplus  int                                   not null comment '剩余座位数量',
    seat_locked   int         default 0                 null comment '当前锁定的座位数',
    return_status tinyint     default 0                 null comment '退座的是否已售完，0已售完，1未售完',
    sell_time     datetime    default CURRENT_TIMESTAMP not null comment '开售时间',
    create_time   datetime    default CURRENT_TIMESTAMP not null
)
    charset = utf8;

INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (1, 1, 'A区', 170.0000, 100, 1, 100, 0, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (2, 1, 'B区', 99.0000, 50, 3, 48, 0, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (3, 10, '默认', 150.0000, 150, 31, 100, 0, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (4, 10, '默认', 100.0000, 50, 26, 25, 0, 0, '2021-03-11 13:20:38', '2021-03-11 13:20:38');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (5, 2, '默认', 50.0000, 50, 51, 50, 0, 0, '2021-03-29 14:00:00', '2021-03-16 10:57:25');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (6, 4, '默认', 168.0000, 100, 101, 0, 0, 0, '2021-03-11 13:20:38', '2021-03-22 15:20:59');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (7, 4, '天台', 50.0000, 100, 1, 100, 0, 0, '2021-03-30 00:00:00', '2021-03-29 01:19:35');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (8, 30, '默认', 80.0000, 200, 1, 191, 6, 0, '2021-04-10 00:00:00', '2021-04-13 08:56:51');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (9, 23, '默认', 120.0000, 200, 1, 200, 0, 0, '2021-04-10 00:00:00', '2021-04-13 08:58:22');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (10, 24, '预售', 80.0000, 100, 1, 100, 0, 0, '2021-04-15 13:00:00', '2021-04-13 08:59:04');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (11, 24, '现场', 100.0000, 150, 1, 150, 0, 0, '2021-05-21 00:00:00', '2021-04-13 08:59:36');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (12, 25, '默认', 50.0000, 100, 1, 100, 0, 0, '2021-05-01 00:00:00', '2021-04-13 09:03:06');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (13, 26, '默认', 30.0000, 250, 1, 246, 0, 0, '2021-04-15 00:00:00', '2021-04-13 09:03:17');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (14, 27, '默认', 10.0000, 300, 1, 300, 0, 0, '2021-04-13 00:00:00', '2021-04-13 09:03:31');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (15, 28, '默认', 200.0000, 200, 1, 199, 0, 0, '2021-04-09 00:00:00', '2021-04-13 09:03:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (16, 29, '默认', 80.0000, 300, 1, 298, 0, 0, '2021-04-16 00:00:00', '2021-04-13 09:04:05');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (17, 31, '默认', 80.0000, 150, 1, 148, 0, 0, '2021-05-02 00:00:00', '2021-04-13 09:04:23');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (18, 32, '默认', 80.0000, 200, 1, 200, 0, 0, '2021-04-17 00:00:00', '2021-04-13 09:04:48');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (19, 33, 'A', 200.0000, 100, 1, 100, 0, 0, '2021-03-30 00:00:00', '2021-04-13 09:05:20');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (20, 33, 'B', 150.0000, 500, 1, 500, 0, 0, '2021-03-30 00:00:00', '2021-04-13 09:05:36');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (21, 34, '现场', 120.0000, 100, 1, 100, 0, 0, '2021-04-30 00:00:00', '2021-04-23 16:46:52');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (22, 36, '默认', 180.0000, 200, 1, 200, 0, 0, '2021-04-24 00:00:00', '2021-04-24 16:37:12');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (24, 35, '默认', 299.0000, 300, 1, 300, 0, 0, '2021-04-24 00:00:00', '2021-04-24 16:51:08');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (25, 37, '普通', 150.0000, 300, 1, 300, 0, 0, '2021-05-18 00:00:00', '2021-04-24 16:52:31');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (26, 37, 'VIP', 299.0000, 100, 1, 100, 0, 0, '2021-05-15 00:00:00', '2021-04-24 16:52:58');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (27, 38, '默认', 60.0000, 500, 1, 500, 0, 0, '2021-04-24 00:00:00', '2021-04-24 16:53:22');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (28, 39, '默认', 30.0000, 500, 1, 500, 0, 0, '2021-04-24 00:00:00', '2021-04-24 16:53:37');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (29, 40, '默认', 100.0000, 50, 1, 50, 0, 0, '2021-04-25 00:00:00', '2021-04-24 16:53:54');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (30, 41, '默认', 2999.0000, 1000, 1, 1000, 0, 0, '2021-04-01 00:00:00', '2021-04-24 16:54:18');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (31, 42, '默认', 79.0000, 100000, 1, 100000, 0, 0, '2021-04-01 00:00:00', '2021-04-24 16:54:39');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (32, 43, '默认', 150.0000, 200, 1, 200, 0, 0, '2021-04-30 00:00:00', '2021-04-26 01:27:16');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (33, 44, '看台', 500.0000, 500, 1, 500, 0, 0, '2021-04-26 00:00:00', '2021-04-26 01:27:39');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (34, 44, '看台', 700.0000, 500, 1, 500, 0, 0, '2021-04-26 00:00:00', '2021-04-26 01:28:00');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (35, 44, '内场', 1700.0000, 1000, 1, 1000, 0, 0, '2021-04-26 01:28:14', '2021-04-26 01:28:14');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (36, 44, '内场', 2000.0000, 500, 1, 500, 0, 0, '2021-04-26 01:28:30', '2021-04-26 01:28:30');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (37, 45, '1V1', 9999999.0000, 1, 1, 1, 0, 0, '2021-08-05 00:00:00', '2021-04-26 01:29:24');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (38, 35, '默认', 100.0000, 50, 1, 50, 0, 0, '2021-05-16 00:00:00', '2021-05-14 12:19:52');
create table ticket_return
(
    id          bigint auto_increment
        primary key,
    ticket_id   bigint                             not null comment 'ticket 的id',
    seat_no     int                                not null comment '座位号',
    create_time datetime default CURRENT_TIMESTAMP not null
)
    comment '退票成功的座位再次出售' charset = utf8;

INSERT INTO weshow.ticket_return (id, ticket_id, seat_no, create_time) VALUES (1, 1, 32, '2021-03-11 10:13:28');
INSERT INTO weshow.ticket_return (id, ticket_id, seat_no, create_time) VALUES (2, 1, 31, '2021-03-11 10:13:28');
INSERT INTO weshow.ticket_return (id, ticket_id, seat_no, create_time) VALUES (3, 2, 20, '2021-03-11 10:13:28');
INSERT INTO weshow.ticket_return (id, ticket_id, seat_no, create_time) VALUES (4, 10, 11, '2021-03-11 10:20:12');
create table ticket_sell
(
    id              bigint auto_increment
        primary key,
    show_id         bigint      not null comment '演出id',
    identity_number varchar(20) not null comment '身份证号'
)
    comment '售票表，订单-票-人，三表中间表，一个订单最多可买两张票' charset = latin1;

INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (1, 26, '123456789123456789');
INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (2, 26, '440921477979464646');
INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (3, 29, '123456789123456789');
INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (4, 29, '440921477979464646');
INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (5, 31, '123456789123456789');
INSERT INTO weshow.ticket_sell (id, show_id, identity_number) VALUES (6, 31, '440921477979464646');
create table user
(
    id          bigint auto_increment comment '用户id'
        primary key,
    username    varchar(100)                       not null comment '用户名',
    password    varchar(100)                       not null comment '密码',
    nickname    varchar(100)                       null comment '昵称',
    mobile      varchar(20)                        not null comment '手机号',
    header      varchar(500)                       null comment '头像',
    status      tinyint  default 1                 null comment '启用状态，0禁用，1正常，2已删除',
    create_time datetime default CURRENT_TIMESTAMP not null comment '注册时间'
)
    charset = utf8;

INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (1, 'admin', '123456', 'admin', '17306686222', null, 0, '2021-02-25 08:48:30');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (26, 'teset1', 'e10adc3949ba59abbe56e057f20f883e', 'Jay汪', '17306686352', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/userDefault.jpg', 1, '2021-04-13 23:10:41');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (27, 'test2', 'e10adc3949ba59abbe56e057f20f883e', '路人W', '13450376238', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/userDefault.jpg', 1, '2021-04-24 18:10:09');
create table user_role
(
    id            bigint auto_increment comment 'id'
        primary key,
    user_id       bigint            not null,
    role_id       bigint            not null,
    status_delete tinyint default 0 null comment '删除状态，0未删除，1已删除'
)
    charset = utf8;


create table user_show
(
    id      bigint auto_increment
        primary key,
    user_id bigint not null comment '用户id',
    show_id bigint not null comment '演出id'
)
    comment '用户收藏的演出中间表' charset = latin1;

INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (8, 26, 25);
INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (9, 26, 30);
INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (10, 26, 32);
INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (11, 26, 45);
INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (12, 26, 31);
INSERT INTO weshow.user_show (id, user_id, show_id) VALUES (16, 26, 44);