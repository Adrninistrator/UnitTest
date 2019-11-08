package test.testmock.mybatis.replace;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReplaceMybatisMapper1 extends TestReplaceMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestReplaceMybatisMapper1.class);

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(MapperProxy.class, "invoke")).with((proxy, method, args) -> {

            //参数1为MapperProxy
            Assert.assertTrue(proxy instanceof MapperProxy);
            logger.info("proxy: {}", proxy);

            MapperProxy mapperProxy = (MapperProxy) proxy;

            Class<Object> mapperInterfaceClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");

            logger.info("mapperInterfaceClass: {}", mapperInterfaceClass);

            //参数2为invoke方法
            Assert.assertTrue(method instanceof Method);
            Assert.assertEquals("invoke", method.getName());
            logger.info("method: {}", method);

            //参数3为调用参数列表
            Assert.assertEquals(3, args.length);
            logger.info("args: {}", Arrays.toString(args));

            logger.info(args[0].getClass().getName());

            //args的参数1为
            Assert.assertTrue(args[0].getClass().getName().contains("com.sun.proxy.$Proxy"));
            logger.info("args[0]: {}", args[0]);

            //args的参数2为被调用的testTableMapper对象的方法selectByPrimaryKey
            Assert.assertTrue(args[1] instanceof Method);
            Method method1 = (Method) args[1];
            Assert.assertEquals("selectByPrimaryKey", method1.getName());
            logger.info("args[1]: {}", method1);

            //args的参数3为调用Mapper对象的方法时传入的参数列表
            Assert.assertTrue(args[2] instanceof Object[]);
            Object[] args2 = (Object[]) args[2];
            Assert.assertEquals(1, args2.length);
            logger.info("args[2]: {}", Arrays.toString(args2));

            //当不是TestTableMapper时，执行真实方法
            if (!TestTableMapper.class.equals(mapperInterfaceClass)) {

                return method.invoke(proxy, args);
            }

            Assert.assertEquals(TestConstants.FLAG1, args2[0]);

            //其他情况返回指定值
            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        });

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);

        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
