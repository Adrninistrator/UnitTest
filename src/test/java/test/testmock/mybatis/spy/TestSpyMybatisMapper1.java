package test.testmock.mybatis.spy;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.common.TestCommonUtil;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestSpyMybatisMapper1 extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapper1.class);

    private String time;

    @Before
    public void init() throws Throwable {

        time = String.valueOf(System.currentTimeMillis());
        logger.info("time: {}", time);

        PowerMockito.doAnswer(invocation -> {

            Object object = TestCommonUtil.getMockArg(invocation, 0, Object.class);
            Method method = TestCommonUtil.getMockArg(invocation, 1, Method.class);
            Object[] objects = TestCommonUtil.getMockArg(invocation, 2, Object[].class);

            //参数1为Mapper对象
            Assert.assertEquals(testTableMapper.getClass(), object.getClass());
            TestCommonUtil.compareObj(testTableMapper, object, true);
            logger.info("object: {}", object);

            //参数2为被调用的Mapper对象的方法
            Assert.assertEquals("selectByPrimaryKey", method.getName());
            logger.info("method: {}", method);

            //参数3为调用Mapper对象的方法时传入的参数
            Assert.assertEquals(1, objects.length);
            logger.info("objects: {}", Arrays.toString(objects));

            Assert.assertEquals(1, objects.length);
            String arg = (String) objects[0];

            if (TestConstants.FLAG1.equals(arg)) {

                TestTableEntity testTableEntity = new TestTableEntity();
                testTableEntity.setId(TestConstants.MOCKED);
                testTableEntity.setFlag(TestConstants.MOCKED);

                return testTableEntity;
            }

            Assert.assertEquals(time, arg);

            TestTableEntity testTableEntity = new TestTableEntity();
            testTableEntity.setId(TestConstants.FLAG1);
            testTableEntity.setFlag(TestConstants.FLAG1);

            return testTableEntity;
        }).when(proxySpy).invoke(Mockito.any(Object.class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {

        TestTableEntity testTableEntity = testTableMapper.selectByPrimaryKey(TestConstants.FLAG1);
        //调用参数为TestConstants.FLAG1，在Answer中会返回Mock后的数据
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getId());
        Assert.assertEquals(TestConstants.MOCKED, testTableEntity.getFlag());

        testTableEntity = testTableMapper.selectByPrimaryKey(time);
        //调用参数非TestConstants.FLAG1，在Answer中会返回Mock后的数据
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.FLAG1, testTableEntity.getId());
        Assert.assertEquals(TestConstants.FLAG1, testTableEntity.getFlag());
    }
}
