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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 获取Mapper对象中的MapperProxy对象，对其Spy对象的方法进行Stub，在Answer中检查调用参数
public class TestSpyMybatisMapperCheckArgs extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapperCheckArgs.class);

    @Before
    public void init() throws Throwable {

        PowerMockito.doAnswer(invocation -> {

            Method method = invocation.getArgument(1);
            Object[] objects = invocation.getArgument(2);

            // 参数2为被调用的Mapper对象的方法
            assertEquals("selectRecord", method.getName());
            logger.info("method: {}", method);

            assertEquals(2, objects.length);
            String arg1 = (String) objects[0];
            String arg2 = (String) objects[1];

            // 参数3为调用Mapper对象的方法时传入的参数
            assertEquals(TestConstants.FLAG1, arg1);
            assertEquals(TestConstants.FLAG2, arg2);

            logger.info("objects: {}", Arrays.toString(objects));

            return null;
        }).when(proxySpy).invoke(Mockito.any(Object.class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {
        TestTableEntity testTableEntity = testTableMapper.selectRecord(TestConstants.FLAG1, TestConstants.FLAG2);
        assertNull(testTableEntity);
    }
}
