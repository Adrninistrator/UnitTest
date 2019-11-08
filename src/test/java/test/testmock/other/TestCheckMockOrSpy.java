package test.testmock.other;

import com.test.non_static.TestNonStaticNoArg1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.base.TestMockBase;

public class TestCheckMockOrSpy extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestCheckMockOrSpy.class);

    private TestNonStaticNoArg1 testNonStaticNoArg1Mock = Mockito.mock(TestNonStaticNoArg1.class);

    private TestNonStaticNoArg1 testNonStaticNoArg1Spy = Mockito.spy(TestNonStaticNoArg1.class);

    private String className = TestNonStaticNoArg1.class.getName();

    //Mock产生的对象的类名与原类名不相同
    @Test
    public void test1() {

        String mockClass = testNonStaticNoArg1Mock.getClass().getName();

        logger.info("{} {}", mockClass, className);

        Assert.assertNotEquals(mockClass, className);
    }

    //Spy产生的对象的类名与原类名不相同
    @Test
    public void test2() {

        String spyClass = testNonStaticNoArg1Spy.getClass().getName();

        logger.info("{} {}", spyClass, className);

        Assert.assertNotEquals(spyClass, className);
    }
}
