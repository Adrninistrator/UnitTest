package adrninistrator.test.testmock.spring.spy_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 替换变量时防止丢弃Stub操作，正例，使用公共方法
public class TestSpSpyMemberOfMCommRun extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Test
    public void test() {
        TestSpSpyMemberOfMCommSpy.spy1(testServiceB1);

        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);

        TestSpSpyMemberOfMCommSpy.spy2(testServiceB1);

        str = testServiceB1.test3("");
        assertEquals(TestConstants.MOCKED, str);

        // 对test1方法的Stub未被丢弃
        str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
