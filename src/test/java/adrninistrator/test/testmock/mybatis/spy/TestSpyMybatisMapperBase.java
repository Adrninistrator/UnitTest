package adrninistrator.test.testmock.mybatis.spy;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.dao.TestTableMapper;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class TestSpyMybatisMapperBase extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapperBase.class);

    @Autowired
    protected TestTableMapper testTableMapper;

    protected MapperProxy<TestTableMapper> proxySpy;

    @Before
    public void initTestSpyMybatisMapperBase() {
        // 获取Mapper对象中的MapperProxy对象，类型为MapperProxy<T>，名称为"h"
        MapperProxy<TestTableMapper> mapperProxy = Whitebox.getInternalState(testTableMapper, "h");

        assertNotNull(mapperProxy);

        logger.info("mapperProxy: {}", mapperProxy);

        // 获取MapperProxy中的mapperInterface对象，应为对应的Mapper对象
        Class<TestTableMapper> mapperClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");
        assertEquals(TestTableMapper.class, mapperClass);

        logger.info("mapperClass: {}", mapperClass);

        // 对MapperProxy进行spy，执行成功，后续可对Spy产生的对象进行Stub
        proxySpy = Mockito.spy(mapperProxy);

        Whitebox.setInternalState(testTableMapper, proxySpy);
    }
}
