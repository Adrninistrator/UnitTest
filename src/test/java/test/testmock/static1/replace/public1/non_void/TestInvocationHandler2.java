package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestInvocationHandler2 implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(TestInvocationHandler2.class);

    private boolean called = false;

    public boolean isCalled() {
        return called;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("proxy :{}", proxy);
        logger.info("method :{}", method);
        logger.info("args :{}", Arrays.toString(args));

        Assert.assertEquals(2, args.length);

        String arg1 = (String) args[0];

        if (TestConstants.FLAG1.equals(arg1)) {
            called = true;
        }

        return TestConstants.MOCKED;
    }
}
