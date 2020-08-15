package adrninistrator.test.testmock.mybatis.spy;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

// 获取Mapper对象中的MapperProxy对象，对其Spy对象的selectByPrimaryKey方法进行Stub
public class TestSpyMybatisMapperGetArgs extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapperGetArgs.class);

    private String time;

    @Before
    public void init() throws Throwable {

        time = String.valueOf(System.currentTimeMillis());
        logger.info("time: {}", time);

        PowerMockito.doAnswer(invocation -> {

            Object object = invocation.getArgument(0);
            Method method = invocation.getArgument(1);
            Object[] objects = invocation.getArgument(2);

            // 参数1为Mapper对象
            assertEquals(testTableMapper.getClass(), object.getClass());
            assertSame(testTableMapper, object);
            logger.info("object: {}", object);

            // 参数2为被调用的Mapper对象的方法
            assertEquals("selectByPrimaryKey", method.getName());
            logger.info("method: {}", method);

            // 参数3为调用Mapper对象的方法时传入的参数
            assertEquals(1, objects.length);
            logger.info("objects: {}", Arrays.toString(objects));

            String arg = (String) objects[0];

            if (TestConstants.FLAG1.equals(arg)) {
                TestTableEntity testTableEntity = new TestTableEntity();
                testTableEntity.setId(TestConstants.FLAG1);
                testTableEntity.setFlag(TestConstants.FLAG1);

                return testTableEntity;
            }

            assertEquals(time, arg);

            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        }).when(proxySpy).invoke(Mockito.any(Object.class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {
        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        // 调用参数为TestConstants.FLAG1，在Answer中会返回Stub指定的数据
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG1, testTableEntity.getId());
        assertEquals(TestConstants.FLAG1, testTableEntity.getFlag());

        testTableEntity = testTableMapper.selectByPrimaryKey(time);
        // 调用参数非TestConstants.FLAG1，在Answer中会返回Stub指定的数据
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
