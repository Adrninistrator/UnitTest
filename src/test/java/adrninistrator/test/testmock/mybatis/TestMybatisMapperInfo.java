package adrninistrator.test.testmock.mybatis;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

// 查看Mybatis Mapper类名
public class TestMybatisMapperInfo extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestMybatisMapperInfo.class);

    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void test() {
        assertNotEquals(TestTableMapper.class, testTableMapper.getClass());

        String mapperClassName = testTableMapper.getClass().getName();
        assertTrue(mapperClassName.contains("com.sun.proxy.$Proxy"));

        logger.info("mapperClassName: {} {}", mapperClassName, TestTableMapper.class.getName());
    }
}
