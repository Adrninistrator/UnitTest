package test.testmock.mybatis.replace;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestReplaceMybatisMapper2 extends TestReplaceMybatisMapperBase {

    private String time;

    @Before
    public void init() {

        time = String.valueOf(System.currentTimeMillis());

        TestTableEntity insertEntity = new TestTableEntity();
        insertEntity.setId(time);
        insertEntity.setFlag(time);

        int row = testTableMapper.insert(insertEntity);

        Assert.assertEquals(1, row);
    }

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(MapperProxy.class, "invoke")).with((proxy, method, args) -> {

            MapperProxy mapperProxy = (MapperProxy) proxy;

            Class<Object> mapperInterfaceClass = Whitebox.getInternalState(mapperProxy, "mapperInterface");

            //当不是TestTableMapper时，执行真实方法
            if (!TestTableMapper.class.equals(mapperInterfaceClass)) {

                return method.invoke(proxy, args);
            }

            Object[] args2 = (Object[]) args[2];

            //特定参数执行真实方法
            if (time.equals(args2[0])) {

                return method.invoke(proxy, args);
            }

            //其他情况返回指定值
            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.MOCKED);
            testTableEntity.setFlag(TestConstants.MOCKED);

            return testTableEntity;
        });

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(time);

        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(time, testTableEntity.getId());
        Assert.assertEquals(time, testTableEntity.getFlag());

        testTableEntity = testTableMapper.selectByPrimaryKey("");

        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());
    }
}
