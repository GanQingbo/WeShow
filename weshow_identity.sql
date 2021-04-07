create table identity
(
    id      bigint auto_increment
        primary key,
    user_id bigint      not null comment '用户id',
    number  varchar(20) not null comment '身份证号'
)
    comment '用户身份证表';

INSERT INTO weshow.identity (id, user_id, number) VALUES (1, 1, '4409211113332313');
create table order_list
(
    id            bigint auto_increment comment '订单id'
        primary key,
    order_sn      char(100)                                not null comment '订单号',
    user_id       bigint                                   not null comment '用户id',
    show_id       bigint                                   not null comment '演出id',
    id_number     varchar(20)                              not null comment '身份证号',
    ticket_id     bigint                                   not null comment '售票id',
    seat_no       int                                      null comment '座位号，按售票顺序生成',
    order_amount  decimal(18, 4) default 0.0000            not null comment '订单总金额',
    order_status  tinyint        default 0                 not null comment '订单状态,0待支付，1已支付，2已关闭，3无效订单',
    delete_status tinyint        default 0                 not null comment '删除状态，0未删除，1已删除',
    create_time   datetime       default CURRENT_TIMESTAMP not null comment '订单创建时间',
    update_time   datetime                                 null comment '订单修改时间',
    payment_time  datetime                                 null comment '支付时间',
    payment_type  tinyint                                  null comment '支付方式，1支付宝，2微信'
)
    charset = utf8;

INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (778, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:48', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (779, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:52', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (780, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:55', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (781, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:55', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (782, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:56', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (783, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:04:57', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (784, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (785, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (786, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (787, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (788, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (789, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (790, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (791, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (792, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (793, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (794, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (795, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (796, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (797, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (798, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (799, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:09', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (800, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (801, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (802, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (803, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (804, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (805, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (806, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (807, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (808, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (809, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (810, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (811, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (812, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (813, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (814, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (815, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (816, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (817, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (818, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (819, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (820, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (821, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (822, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (823, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (824, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (825, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (826, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (827, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (828, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (829, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (830, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (831, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (832, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (833, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (834, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (835, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (836, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (837, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (838, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (839, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (840, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (841, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (842, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (843, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (844, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (845, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (846, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (847, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (848, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (849, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (850, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (851, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (852, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (853, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (854, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (855, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (856, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (857, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (858, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (859, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (860, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (861, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (862, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (863, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (864, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (865, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (866, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (867, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (868, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (869, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (870, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (871, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (872, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (873, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (874, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (875, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (876, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:10', null, null, null);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, id_number, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (877, '0027', 1001, 2, '440921199804517414', 6, null, 168.0000, 0, 0, '2021-03-23 00:06:12', null, null, null);
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
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (10, 20020, null, '2021-03-18 23:04:59', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (11, 20020, null, '2021-03-18 23:04:59', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (12, 20020, null, '2021-03-18 23:05:00', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (13, 20020, null, '2021-03-18 23:05:00', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (14, 20020, null, '2021-03-18 23:05:01', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (15, 20020, null, '2021-03-18 23:05:01', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (16, 20020, null, '2021-03-18 23:05:02', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (17, 20020, null, '2021-03-18 23:05:03', null, 0, null);
INSERT INTO weshow.order_return (id, order_id, admin_id, create_time, handle_time, return_status, return_money) VALUES (18, 20020, null, '2021-03-18 23:05:03', null, 0, null);
create table payment
(
    id             bigint auto_increment
        primary key,
    order_sn       char(100)                          not null comment '订单号',
    alipay_no      varchar(50)                        not null comment '支付宝流水号',
    total_amount   decimal(18, 4)                     not null comment '支付金额',
    payment_status varchar(20)                        not null comment '支付状态',
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    confirm_time   datetime                           null comment '确认时间',
    callback_time  datetime                           null comment '回调时间'
)
    charset = utf8;


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
    comment '首页推荐';

INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (1, 1, '2021-03-31 12:43:36');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (2, 2, '2021-03-31 12:43:36');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (3, 3, '2021-03-31 12:43:36');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (13, 16, '2021-04-01 14:47:05');
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
    id      bigint auto_increment comment 'id'
        primary key,
    show_id bigint       not null comment '演出id',
    user_id bigint       not null comment '用户id',
    comment varchar(500) null comment '用户评论'
)
    comment '评论表';


create table show_heat
(
    id       bigint auto_increment comment 'id
'
        primary key,
    show_id  bigint not null comment '演出id',
    clicks   int    null comment '点击数',
    likes    int    null comment '点赞数',
    comments int    null comment '评论数',
    heat     int    null comment '总热度'
)
    comment '演出热度';


create table show_list
(
    id             bigint auto_increment comment 'id'
        primary key,
    showtype_id    bigint                             not null comment '演出类型id',
    show_name      varchar(100)                       not null comment '演出名',
    show_intro     varchar(500)                       null comment '简介',
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

INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (1, 1, '贰叁叁脱口秀', null, '笑声收割机', '上海市', '上海市Track Time', '2021-02-25 14:00:00', '2021-02-27 15:30:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/55ac208d-9f4f-42e9-b2c8-e591a2c6efea.webp', '17344774527', '2021-02-25 09:53:14');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (2, 2, '白夜行', null, '韩雪、刘令飞', '北京市', '北京天桥艺术中心大剧场', '2021-03-13 14:00:00', '2021-03-13 17:00:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/35498f57-edbc-49ae-9295-0cd86aebf379.webp', null, '2021-02-25 09:56:01');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (3, 2, '白夜行', null, '韩雪、刘令飞', '北京市', '北京天桥艺术中心大剧场', '2021-03-13 19:30:00', '2021-03-13 22:30:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/16165088-1588-493a-a597-93f39265877a.jpg', null, '2021-02-25 09:56:53');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (4, 1, '"共同渡过"缅怀张国荣金曲演唱会', null, 'Harmony', '广州市', '广州中山纪念堂', '2021-04-01 19:30:00', null, null, null, '2021-02-26 11:03:03');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (7, 1, '测试json', '', '五月天', '信宜', '玉都公园', '2021-03-01 14:00:00', '2021-03-31 00:00:00', null, null, '2021-03-01 15:55:39');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (8, 1, '测试json', '', '周杰伦', '茂名', '玉都公园', '2021-03-01 14:00:00', '2021-03-28 00:00:00', null, null, '2021-03-01 17:15:06');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (9, 1, '测试json', '', '周杰伦', '茂名', '玉都公园', '2021-03-01 14:00:00', null, null, null, '2021-03-01 17:15:37');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (10, 1, '摩天轮', '测试·····', '周二伦', '深圳', '深圳体育馆', '2021-03-26 14:00:00', null, null, '17302246837', '2021-03-01 17:15:38');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (11, 1, '测试json', '', '周杰伦', '茂名', '玉都公园', '2021-03-01 14:00:00', null, null, null, '2021-03-01 17:15:38');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (13, 1, '测试222', '', '吴亦凡', '茂名', '玉都公园', '2021-03-01 14:00:00', null, null, null, '2021-03-01 17:15:40');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (14, 1, '测试json', '', '周杰伦', '茂名', '玉都公园', '2021-03-01 14:00:00', null, null, null, '2021-03-01 17:15:41');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (15, 5, '兵乓球比赛', null, '广东队、广西队', '深圳', '体育中心', '2021-04-25 09:30:00', null, null, null, '2021-03-03 22:43:29');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (16, 4, '芭蕾比赛', null, '测试1', '深圳', '体育中心', '2021-04-25 09:30:00', '2021-04-25 14:30:00', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/de6fc139-8033-43d6-aec7-6010be87b606.jpg', '17554454646', '2021-03-03 23:22:10');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (17, 6, '123', '', 'admin', '东莞', '广东省东莞市松山湖管委会大学路1号', '2021-03-15 06:00:00', null, '', '17306685412', '2021-03-05 09:37:26');
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (18, 1, '测试json', '', 'liuss', '茂名', '玉都公园', '2021-03-01 14:00:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/cbafbfcf-11c8-4bbc-82b4-6b0fce66e06c.jpg', '12345678900', '2021-03-05 10:17:04');
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
    show_id       bigint                             not null comment '演出id',
    seat_type     varchar(50)                        null comment '座位类型',
    seat_price    decimal(18, 4)                     null comment '座位价格',
    seat_number   int                                not null comment '座位数量',
    current_no    int      default 1                 not null comment '当前座位号',
    seat_surplus  int                                not null comment '剩余座位数量',
    return_status tinyint  default 0                 null comment '退座的是否已售完，0已售完，1未售完',
    sell_time     datetime                           null comment '开售时间',
    create_time   datetime default CURRENT_TIMESTAMP not null
)
    charset = utf8;

INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (1, 1, 'A区', 170.0000, 50, 1, 50, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (2, 1, 'B区', 99.0000, 50, 3, 48, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (3, 10, null, 150.0000, 150, 31, 100, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (4, 10, null, 100.0000, 50, 26, 25, 0, '2021-03-11 13:20:38', '2021-03-11 13:20:38');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (5, 2, null, 50.0000, 50, 51, 50, 0, '2021-03-29 14:00:00', '2021-03-16 10:57:25');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (6, 4, null, 168.0000, 100, 101, 0, 0, '2021-03-11 13:20:38', '2021-03-22 15:20:59');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, return_status, sell_time, create_time) VALUES (7, 4, '天台', 50.0000, 100, 1, 100, 0, '2021-03-30 00:00:00', '2021-03-29 01:19:35');
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

INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (1, 'admin', '123456', 'admin', '17306686352', null, 0, '2021-02-25 08:48:30');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (2, 'usertest', '111111', 'user1', '11111111111', null, 1, '2021-02-25 08:48:57');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (4, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:02');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (5, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:03');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (6, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:04');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (7, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:04');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (8, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:05');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (9, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:05');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (10, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:06');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (11, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:06');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (12, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:07');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (13, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:07');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (14, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:08');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (15, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:08');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (16, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:09');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (17, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:09');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (18, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:10');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (19, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:10');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (20, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:11');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (21, 'theman', '123456', '靓仔', '17306688888', null, 1, '2021-03-18 14:26:31');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (22, 'theman', '123456', '靓仔', '17306688888', null, 1, '2021-03-18 14:26:32');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (24, 'updatetestman', '123456', '靓仔', '17306688888', null, 0, '2021-03-18 14:26:33');
create table user_role
(
    id            bigint auto_increment comment 'id'
        primary key,
    user_id       bigint            not null,
    role_id       bigint            not null,
    status_delete tinyint default 0 null comment '删除状态，0未删除，1已删除'
)
    charset = utf8;

