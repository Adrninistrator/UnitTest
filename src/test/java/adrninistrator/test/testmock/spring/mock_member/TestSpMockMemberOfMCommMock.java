package adrninistrator.test.testmock.spring.mock_member;

import adrninistrator.test.common.TestReplaceUtil;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.mockito.Mockito;

public class TestSpMockMemberOfMCommMock {

    public static void mock1(TestServiceB1 testServiceB1) {
        // 将对象testServiceB1中的TestServiceA1类型成员变量替换为Mock对象并返回
        TestServiceA1 testServiceA1InB1 = TestReplaceUtil.replaceMockMember(testServiceB1, TestServiceA1.class);
        // 对TestServiceA1类型成员变量进行Stub
        Mockito.when(testServiceA1InB1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
    }

    public static void mock2(TestServiceB1 testServiceB1) {
        // 将对象testServiceB1中的TestServiceA1类型成员变量替换为Mock对象并返回
        TestServiceA1 testServiceA1InB1 = TestReplaceUtil.replaceMockMember(testServiceB1, TestServiceA1.class);
        // 对TestServiceA1类型成员变量进行Stub
        Mockito.when(testServiceA1InB1.test3(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
    }

    private TestSpMockMemberOfMCommMock() {
        throw new IllegalStateException("illegal");
    }
}
