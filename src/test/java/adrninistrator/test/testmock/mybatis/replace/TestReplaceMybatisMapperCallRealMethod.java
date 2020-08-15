package adrninistrator.test.testmock.mybatis.replace;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

// 对MapperProxy进行replace操作，对于TestTableMapper的selectByPrimaryKey方法进行处理，根据调用参数决定执行真实方法或返回指定值
public class TestReplaceMybatisMapperCallRealMethod extends TestReplaceMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestReplaceMybatisMapperCallRealMethod.class);

    private String time;

    @Before
    public void init() {
        time = String.valueOf(System.currentTimeMillis());

        TestTableEntity insertEntity = new TestTableEntity();
        insertEntity.setId(time);
        insertEntity.setFlag(time);

        int row = testTableMapper.insert(insertEntity);

        assertEquals(1, row);
    }

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(MapperProxy.class, "invoke")).with((proxy, method, args) -> {

            MapperProxy mapperProxy = (MapperProxy) proxy;

            Class<Object> mapperInterfaceClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");
            logger.info("mapperInterfaceClass: {}", mapperInterfaceClass);

            // 当不是TestTableMapper时，执行真实方法
            if (!TestTableMapper.class.equals(mapperInterfaceClass)) {
                return method.invoke(proxy, args);
            }

            // args的参数2为被调用的Mapper对象的方法
            assertTrue(args[1] instanceof Method);
            Method method1 = (Method) args[1];

            logger.info("args[1]: {}", method1);

            // 当不是调用selectByPrimaryKey方法时，执行真实方法
            if (!"selectByPrimaryKey".equals(method1.getName())) {
                return method.invoke(proxy, args);
            }

            Object[] args2 = (Object[]) args[2];

            // 特定参数执行真实方法
            if (time.equals(args2[0])) {
                return method.invoke(proxy, args);
            }

            // 其他情况返回指定值
            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        });

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        assertNotNull(testTableEntity);
        assertEquals(time, testTableEntity.getId());
        assertEquals(time, testTableEntity.getFlag());

        testTableEntity = testTableMapper.selectByPrimaryKey("");

        assertNotNull(testTableEntity);
        assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
