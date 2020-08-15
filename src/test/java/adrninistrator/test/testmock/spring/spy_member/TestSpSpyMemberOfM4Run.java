package adrninistrator.test.testmock.spring.spy_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 替换变量时防止丢弃Stub操作，反例
public class TestSpSpyMemberOfM4Run extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Autowired
    private TestServiceA1 testServiceA1;

    @Before
    public void init() {
        String str = testServiceB1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        StringBuilder stringBuilder = new StringBuilder();

        testServiceB1.test2(stringBuilder);
        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }

    @Test
    public void test() {
        TestSpSpyMemberOfM4Spy.spy1(testServiceB1, testServiceA1);

        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);

        TestSpSpyMemberOfM4Spy.spy2(testServiceB1, testServiceA1);

        str = testServiceB1.test3("");
        assertEquals(TestConstants.MOCKED, str);

        // 对test1方法的Stub被丢弃
        str = testServiceB1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
