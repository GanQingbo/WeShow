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

INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (919, '1382920940823908352', 26, 30, 8, null, 160.0000, 1, 0, '2021-04-16 12:57:00', null, '2021-04-16 12:57:00', 1);
INSERT INTO weshow.order_list (id, order_sn, user_id, show_id, ticket_id, seat_no, order_amount, order_status, delete_status, create_time, update_time, payment_time, payment_type) VALUES (920, '1382947889759784960', 26, 28, 15, null, 200.0000, 1, 0, '2021-04-16 14:44:05', null, '2021-04-16 14:44:06', 1);
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
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (4, 30, '2021-04-12 18:08:00');
INSERT INTO weshow.recommend (id, show_id, create_time) VALUES (5, 27, '2021-04-12 18:08:12');
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
    show_id  bigint        not null comment '演出id',
    clicks   int default 0 null comment '点击数',
    likes    int default 0 null comment '点赞数',
    comments int default 0 null comment '评论数',
    heat     int default 0 null comment '总热度'
)
    comment '演出热度';

INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (1, 23, 20, 0, 0, 20);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (2, 1, 10, 0, 0, 10);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (3, 24, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (4, 25, 15, 0, 0, 15);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (5, 26, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (6, 27, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (7, 28, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (8, 29, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (9, 30, 150, 0, 0, 150);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (10, 31, 22, 0, 0, 22);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (11, 32, 101, 0, 0, 101);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (12, 33, 10, 0, 0, 10);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (13, 2, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (14, 3, 0, 0, 0, 0);
INSERT INTO weshow.show_heat (id, show_id, clicks, likes, comments, heat) VALUES (15, 4, 50, 0, 0, 50);
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
INSERT INTO weshow.show_list (id, showtype_id, show_name, show_intro, show_performer, show_city, show_place, show_time, end_time, show_poster, show_mobile, create_time) VALUES (4, 1, '"共同渡过"缅怀张国荣金曲演唱会', null, 'Harmony', '广州', '广州中山纪念堂', '2021-04-01 19:30:00', null, 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/poster/3e0b11c7-5f18-4802-ae1a-7885245388fa.jpg', '17474747474', '2021-02-26 11:03:03');
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

INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (1, 1, 'A区', 170.0000, 50, 1, 50, 0, 0, '2021-03-11 13:20:38', '2021-03-11 09:35:47');
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
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (13, 26, '默认', 30.0000, 250, 1, 248, 0, 0, '2021-04-15 00:00:00', '2021-04-13 09:03:17');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (14, 27, '默认', 10.0000, 300, 1, 300, 0, 0, '2021-04-13 00:00:00', '2021-04-13 09:03:31');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (15, 28, '默认', 200.0000, 200, 1, 199, 0, 0, '2021-04-09 00:00:00', '2021-04-13 09:03:47');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (16, 29, '默认', 80.0000, 300, 1, 300, 0, 0, '2021-04-16 00:00:00', '2021-04-13 09:04:05');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (17, 31, '默认', 80.0000, 150, 1, 150, 0, 0, '2021-05-02 00:00:00', '2021-04-13 09:04:23');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (18, 32, '默认', 80.0000, 200, 1, 200, 0, 0, '2021-04-17 00:00:00', '2021-04-13 09:04:48');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (19, 33, 'A', 200.0000, 100, 1, 100, 0, 0, '2021-03-30 00:00:00', '2021-04-13 09:05:20');
INSERT INTO weshow.ticket (id, show_id, seat_type, seat_price, seat_number, current_no, seat_surplus, seat_locked, return_status, sell_time, create_time) VALUES (20, 33, 'B', 150.0000, 500, 1, 500, 0, 0, '2021-03-30 00:00:00', '2021-04-13 09:05:36');
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
    order_id        bigint      not null comment '订单id',
    ticket_id       bigint      not null comment '座位表id',
    identity_number varchar(20) not null comment '身份证号'
)
    comment '售票表，订单-票-人，三表中间表，一个订单最多可买两张票';


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
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (2, 'usertest', '111111', 'user1', '11111111111', null, 1, '2021-02-25 08:48:57');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (4, 'testman', '123456', '测试仔', '17306688888', null, 1, '2021-03-18 14:26:02');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (21, 'theman', '123456', '靓仔', '18244969528', null, 1, '2021-03-18 14:26:31');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (22, 'yesman', '123456', '靓仔', '19999999999', null, 1, '2021-03-18 14:26:32');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (24, 'updatetestman', '123456', '靓仔', '17306686666', null, 0, '2021-03-18 14:26:33');
INSERT INTO weshow.user (id, username, password, nickname, mobile, header, status, create_time) VALUES (26, 'teset1', 'e10adc3949ba59abbe56e057f20f883e', 'WeShow用户17306686352', '17306686352', 'https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/userDefault.jpg', 1, '2021-04-13 23:10:41');
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
    comment '用户收藏的演出中间表';

