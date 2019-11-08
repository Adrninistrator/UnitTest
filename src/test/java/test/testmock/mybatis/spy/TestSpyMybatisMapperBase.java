package test.testmock.mybatis.spy;

import com.test.dao.TestTableMapper;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpyMybatisMapperBase extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapperBase.class);

    @Autowired
    protected TestTableMapper testTableMapper;

    protected MapperProxy<TestTableMapper> proxySpy;

    @Before
    public void initTestSpyMybatisMapperBase() {

        //获取Mapper中的MapperProxy对象，名称为"h"，类型为MapperProxy<T>
        MapperProxy<TestTableMapper> mapperProxy = Whitebox.getInternalState(testTableMapper, "h");

        Assert.assertNotNull(mapperProxy);

        logger.info("mapperProxy: {}", mapperProxy);

        //获取MapperProxy中的mapperInterface对象，应为TestTableMapper类
        Class<TestTableMapper> mapperClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");

        Assert.assertEquals(TestTableMapper.class.getName(), mapperClass.getName());

        logger.info("mapperClass: {}", mapperClass);

        //对MapperProxy进行spy，执行成功，后续可对Spy产生的对象进行Stub
        proxySpy = Mockito.spy(mapperProxy);

        Whitebox.setInternalState(testTableMapper, proxySpy);
    }
}
