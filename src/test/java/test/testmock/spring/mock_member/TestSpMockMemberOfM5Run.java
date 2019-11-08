package test.testmock.spring.mock_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceB1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//替换变量时防止丢弃Stub操作，正例
public class TestSpMockMemberOfM5Run extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

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

        TestSpMockMemberOfM5Mock.mock1(testServiceB1);

        String str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        TestSpMockMemberOfM5Mock.mock2(testServiceB1);

        str = testServiceB1.test3("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        //对test1方法的Stub未被丢弃
        str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
