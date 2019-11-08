package test.testmock.spring.spy_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//替换变量时防止丢弃Stub操作，反例
public class TestSpSpyMemberOfM4Run extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Autowired
    private TestServiceA1 testServiceA1;

    @Before
    public void init() {

        String str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        StringBuffer stringBuffer = new StringBuffer();

        testServiceB1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());
    }

    @Test
    public void test() {

        TestSpSpyMemberOfM4Spy.mock1(testServiceB1, testServiceA1);

        String str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        TestSpSpyMemberOfM4Spy.mock2(testServiceB1, testServiceA1);

        str = testServiceB1.test3("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        //对test1方法的Stub被丢弃
        str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
