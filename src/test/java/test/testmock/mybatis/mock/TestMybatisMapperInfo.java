package test.testmock.mybatis.mock;

import com.test.dao.TestTableMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestMybatisMapperInfo extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMybatisMapperInfo.class);

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {

        String mapperClassName = testTableMapper.getClass().getName();

        Assert.assertNotEquals(TestTableMapper.class.getName(), mapperClassName);
        Assert.assertTrue(mapperClassName.contains("com.sun.proxy.$Proxy"));

        logger.info("mapperClassName: {} {}", mapperClassName, TestTableMapper.class.getName());
    }
}
