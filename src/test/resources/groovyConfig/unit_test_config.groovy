test_mode {

//    jdbc {
//        driver = 数据库驱动名称
//        url = 数据库地址
//        username = 数据库用户名
//        password = 数据库密码
//    }
//    import_jpa = 引入JPA配置
//    test_include = 测试类包含范围（数组）
//    test_exclude = 测试类排除范围（数组）
//    jacoco_include = 生成代码覆盖率的类包含范围 （ 数组 ）
//    jacoco_exclude = 生成代码覆盖率的类排除范围 （ 数组 ）

    //使用H2数据库，文件模式
    use_h2_file {
        jdbc {
            driver = 'org.h2.Driver'
            url = 'jdbc:h2:file:./build/h2db;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;INIT=RUNSCRIPT FROM \'classpath:sql/create_table.sql\''
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //使用H2数据库，内存模式
    use_h2_mem {
        jdbc {
            driver = 'org.h2.Driver'
            url = 'jdbc:h2:mem:;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;INIT=RUNSCRIPT FROM \'classpath:sql/create_table.sql\''
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //使用H2数据库及JPA，文件模式
    use_h2_file_jpa {
        jdbc {
            driver = 'org.h2.Driver'
            url = 'jdbc:h2:file:./build/h2db;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;INIT=CREATE SCHEMA IF NOT EXISTS TEST\\\\;SET SCHEMA TEST'
            username = ''
            password = ''
        }
        import_jpa = '<import resource="springJpa/springJpa.xml"/>'
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //使用H2数据库及JPA，内存模式
    use_h2_mem_jpa {
        jdbc {
            driver = 'org.h2.Driver'
            url = 'jdbc:h2:mem:;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE'
            username = ''
            password = ''
        }
        import_jpa = '<import resource="springJpa/springJpa.xml"/>'
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //使用MySQL数据库
    use_mysql {
        jdbc {
            driver = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://127.0.0.1:3306/testdb?useunicode=true&characterEncoding=utf8&allowMultiQueries=true&useAffectedRows=true'
            username = 'test'
            password = '123456'
        }
        import_jpa = ''
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //使用MySQL数据库及JPA
    use_mysql_jpa {
        jdbc {
            driver = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://127.0.0.1:3306/testdb?useunicode=true&characterEncoding=utf8&allowMultiQueries=true&useAffectedRows=true'
            username = 'test'
            password = '123456'
        }
        import_jpa = '<import resource="springJpa/springJpa.xml"/>'
        test_include = ['adrninistrator/test/testdatabase/**', 'adrninistrator/test/testmock/mybatis/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/dao/**']
        jacoco_exclude = []
    }

    //快速测试少量测试类
    fast {
        jdbc {
            driver = 'com.alibaba.druid.mock.MockDriver'
            url = 'jdbc:mock://'
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['adrninistrator/test/testmock/spring/spy_member/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**', 'com/adrninistrator/applicationlistener/**']
        jacoco_exclude = ['**/TestPrivateNonVoidService1**']
    }

    //测试Suite
    suite {
        jdbc {
            driver = 'com.alibaba.druid.mock.MockDriver'
            url = 'jdbc:mock://'
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['**/TestSuite**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/util/**', 'com/adrninistrator/static1/**']
        jacoco_exclude = []
    }

    //测试Spring Context是否使用缓存
    spring {
        jdbc {
            driver = 'com.alibaba.druid.mock.MockDriver'
            url = 'jdbc:mock://'
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['adrninistrator/test/testframework/spring/test/**']
        test_exclude = []
        jacoco_include = ['com/adrninistrator/service/**']
        jacoco_exclude = []
    }

    //默认情况
    default_mode {
        jdbc {
            driver = 'com.alibaba.druid.mock.MockDriver'
            url = 'jdbc:mock://'
            username = ''
            password = ''
        }
        import_jpa = ''
        test_include = ['**']
        test_exclude = ['adrninistrator/test/testdatabase/**',
                        'adrninistrator/test/testmock/mybatis/**',
                        '**/TestSuite**',
                        '**/metaspace_oom/**',
                        '**/test_jpa/**']
        jacoco_include = ['**']
        jacoco_exclude = []
    }
}