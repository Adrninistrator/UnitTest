package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestInvocationHandler1 implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(TestInvocationHandler1.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("proxy :{}", proxy);
        logger.info("method :{}", method);
        logger.info("args :{}", Arrays.toString(args));

        Assert.assertEquals(2, args.length);

        String arg1 = (String) args[0];

        Assert.assertEquals(TestConstants.FLAG1, arg1);

        TestTableEntity arg2 = (TestTableEntity) args[1];

        Assert.assertEquals(TestConstants.FLAG1, arg2.getId());
        Assert.assertEquals(TestConstants.FLAG1, arg2.getFlag());

        return TestConstants.MOCKED;
    }
}
