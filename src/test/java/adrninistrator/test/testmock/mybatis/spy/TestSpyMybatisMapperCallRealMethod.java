package adrninistrator.test.testmock.mybatis.spy;

import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 获取Mapper对象中的MapperProxy对象，对其Spy对象的方法进行Stub，执行真实方法
public class TestSpyMybatisMapperCallRealMethod extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapperCallRealMethod.class);

    private String time;

    @Before
    public void init() throws Throwable {

        time = String.valueOf(System.currentTimeMillis());
        logger.info("time: {}", time);

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(time);
        testTableEntity.setFlag(time);

        // 向数据库插入数据
        int row = testTableMapper.insert(testTableEntity);

        assertEquals(1, row);

        // 执行真实方法
        PowerMockito.doAnswer(invocation -> invocation.callRealMethod()).when(proxySpy).invoke(Mockito.any(Object
                .class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {
        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        // 在Answer中通过invocation.callRealMethod执行真实方法，返回数据应非空
        assertNotNull(testTableEntity);

        logger.info("testTableEntity: {}", testTableEntity);

        assertEquals(time, testTableEntity.getFlag());
    }
}
