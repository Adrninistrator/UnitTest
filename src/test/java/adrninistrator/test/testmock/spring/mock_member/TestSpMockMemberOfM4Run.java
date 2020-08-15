package adrninistrator.test.testmock.spring.mock_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 替换变量时防止丢弃Stub操作，反例
public class TestSpMockMemberOfM4Run extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

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
        TestSpMockMemberOfM4Mock.mock1(testServiceB1);

        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);

        TestSpMockMemberOfM4Mock.mock2(testServiceB1);

        str = testServiceB1.test3("");
        assertEquals(TestConstants.MOCKED, str);

        // 对test1方法的Stub被丢弃
        str = testServiceB1.test1("");
        assertNull(str);
    }
}
