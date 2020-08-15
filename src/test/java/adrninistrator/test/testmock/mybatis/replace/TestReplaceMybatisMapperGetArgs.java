package adrninistrator.test.testmock.mybatis.replace;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

// 对MapperProxy进行replace操作，对于TestTableMapper的selectByPrimaryKey方法进行处理，返回指定的值
public class TestReplaceMybatisMapperGetArgs extends TestReplaceMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestReplaceMybatisMapperGetArgs.class);

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(MapperProxy.class, "invoke")).with((proxy, method, args) -> {

            // 参数1为MapperProxy
            assertTrue(proxy instanceof MapperProxy);
            logger.info("proxy: {}", proxy);

            MapperProxy mapperProxy = (MapperProxy) proxy;

            Class<Object> mapperInterfaceClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");
            logger.info("mapperInterfaceClass: {}", mapperInterfaceClass);

            // 当不是调用TestTableMapper时，执行真实方法
            if (!TestTableMapper.class.equals(mapperInterfaceClass)) {
                return method.invoke(proxy, args);
            }

            // 参数2为invoke方法
            assertTrue(method instanceof Method);
            assertEquals("invoke", method.getName());
            logger.info("method: {}", method);

            // 参数3为调用参数列表
            assertEquals(3, args.length);
            logger.info("args: {}", Arrays.toString(args));

            // args的参数1为被调用的Mapper对象
            assertEquals(testTableMapper.getClass(), args[0].getClass());
            assertSame(testTableMapper, args[0]);
            logger.info("args[0]: {} {}", args[0], args[0].getClass().getName());

            // args的参数2为被调用的Mapper对象的方法
            assertTrue(args[1] instanceof Method);
            Method method1 = (Method) args[1];

            logger.info("args[1]: {}", method1);

            // 当不是调用selectByPrimaryKey方法时，执行真实方法
            if (!"selectByPrimaryKey".equals(method1.getName())) {
                return method.invoke(proxy, args);
            }

            // args的参数3为调用Mapper对象的方法时传入的参数列表
            assertTrue(args[2] instanceof Object[]);
            Object[] args2 = (Object[]) args[2];
            assertEquals(1, args2.length);
            logger.info("args[2]: {}", Arrays.toString(args2));

            assertEquals(TestConstants.FLAG1, args2[0]);

            // 其他情况返回指定值
            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        });

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);

        assertNotNull(testTableEntity);
        assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
