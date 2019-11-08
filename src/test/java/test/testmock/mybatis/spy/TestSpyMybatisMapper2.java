package test.testmock.mybatis.spy;

import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestSpyMybatisMapper2 extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapper2.class);

    private String time;

    @Before
    public void init() throws Throwable {

        time = String.valueOf(System.currentTimeMillis());
        logger.info("time: {}", time);

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(time);
        testTableEntity.setFlag(time);

        //向数据库插入数据
        int row = testTableMapper.insert(testTableEntity);

        Assert.assertEquals(1, row);

        //执行真实方法
        PowerMockito.doAnswer(invocation -> invocation.callRealMethod()).when(proxySpy).invoke(Mockito.any(Object
                .class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        //在Answer中通过invocation.callRealMethod执行真实方法，返回数据应非空
        Assert.assertNotNull(testTableEntity);

        logger.info("testTableEntity: {}", testTableEntity);

        Assert.assertEquals(time, testTableEntity.getFlag());
    }
}
