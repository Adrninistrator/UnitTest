package test.testmock.mybatis.spy;

import com.test.common.TestConstants;
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

public class TestSpyMybatisMapper3 extends TestSpyMybatisMapperBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpyMybatisMapper3.class);

    @Before
    public void init() throws Throwable {

        PowerMockito.doAnswer(invocation -> {

            Object[] objects = TestCommonUtil.getMockArg(invocation, 2, Object[].class);

            Assert.assertEquals(2, objects.length);
            String arg1 = (String) objects[0];
            String arg2 = (String) objects[1];

            //参数3为调用Mapper对象的方法时传入的参数
            Assert.assertEquals(TestConstants.FLAG1, arg1);
            Assert.assertEquals(TestConstants.FLAG2, arg2);

            logger.info("objects: {}", Arrays.toString(objects));

            return null;
        }).when(proxySpy).invoke(Mockito.any(Object.class), Mockito.any(Method.class), Mockito.any(Object[].class));
    }

    @Test
    public void test() {

        testTableMapper.selectRecord(TestConstants.FLAG1, TestConstants.FLAG2);
    }
}
