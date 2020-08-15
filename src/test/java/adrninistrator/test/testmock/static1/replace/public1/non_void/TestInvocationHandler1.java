package adrninistrator.test.testmock.static1.replace.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestInvocationHandler1 implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(TestInvocationHandler1.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("proxy :{}", proxy);
        logger.info("method :{}", method);
        logger.info("args :{}", Arrays.toString(args));

        assertEquals(2, args.length);

        String arg1 = (String) args[0];

        assertEquals(TestConstants.FLAG1, arg1);

        TestTableEntity arg2 = (TestTableEntity) args[1];

        assertEquals(TestConstants.FLAG1, arg2.getId());
        assertEquals(TestConstants.FLAG1, arg2.getFlag());

        return TestConstants.MOCKED;
    }
}
