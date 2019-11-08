CREATE TABLE test_table (
  id varchar(32) NOT NULL COMMENT 'id',
  flag varchar(32) NOT NULL COMMENT 'flag',
  PRIMARY KEY (id),
  index idx_test_table1 (flag)
) COMMENT='测试数据库表';
