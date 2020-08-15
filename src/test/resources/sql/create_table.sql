CREATE SCHEMA IF NOT EXISTS TEST;
SET SCHEMA TEST;

CREATE TABLE IF NOT EXISTS test_table
(
   id             varchar(32) NOT NULL COMMENT 'id',
   flag           varchar(32) NOT NULL COMMENT 'flag',
   create_time    DATETIME(3) NOT NULL COMMENT 'create_time',
   update_time    DATETIME(3) NOT NULL COMMENT 'update_time',
   PRIMARY KEY(id),
   INDEX idx_test_table_1 (flag)
)
COMMENT = '测试数据库表';

CREATE TABLE IF NOT EXISTS test_table2
(
   id            varchar(20) NOT NULL COMMENT '测试-id',
   char1         char NOT NULL COMMENT '测试-char1',
   char2         char(30) NOT NULL COMMENT '测试-char2',
   blob1         blob COMMENT '测试-blob1',
   blob2         blob(100) COMMENT '测试-blob2',
   text1         text COMMENT '测试-text1',
   text2         text(200) COMMENT '测试-text2',
   int_1         int COMMENT '测试-int_1',
   int_2         int(8) COMMENT '测试-int_2',
   decimal1      decimal COMMENT '测试-decimal1',
   decimal2      decimal(18,2) COMMENT '测试-decimal2',
   datetime1     datetime COMMENT '测试-datetime1',
   datetime2     datetime(3) COMMENT '测试-datetime2',
   timestamp1    timestamp COMMENT '测试-timestamp1',
   timestamp2    timestamp(3) COMMENT '测试-timestamp2',
   PRIMARY KEY(id),
   INDEX idx_test_table2_1 (datetime1),
   UNIQUE INDEX uni_test_table2(char1, char2)
)
COMMENT = '测试数据库表2';

CREATE TABLE IF NOT EXISTS test_table3
(
   id             varchar(32) NOT NULL COMMENT 'id',
   flag           varchar(32) NOT NULL COMMENT 'flag',
   create_time    DATETIME(3) NOT NULL COMMENT 'create_time',
   update_time    DATETIME(3) NOT NULL COMMENT 'update_time',
   PRIMARY KEY(id, flag),
   INDEX idx_test_table3_1 (create_time)
)
COMMENT = '测试数据库表3';