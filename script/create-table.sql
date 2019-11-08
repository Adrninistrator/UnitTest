CREATE TABLE test_table (
  id varchar(32) NOT NULL COMMENT 'id',
  flag varchar(32) NOT NULL COMMENT 'flag',
  create_time DATETIME(3) NOT NULL COMMENT 'create_time',
  update_time DATETIME(3) NOT NULL COMMENT 'update_time',
  PRIMARY KEY (id),
  index idx_test_table1 (flag)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='测试数据库表';
