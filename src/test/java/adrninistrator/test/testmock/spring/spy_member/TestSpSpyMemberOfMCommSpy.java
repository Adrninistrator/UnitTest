package adrninistrator.test.testmock.spring.spy_member;

import adrninistrator.test.common.TestReplaceUtil;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.mockito.Mockito;

public class TestSpSpyMemberOfMCommSpy {

    public static void spy1(TestServiceB1 testServiceB1) {
        // 将对象testServiceB1中的TestServiceA1类型成员变量替换为Spy对象并返回
        TestServiceA1 testServiceA1InB1 = TestReplaceUtil.replaceSpyMember(testServiceB1, TestServiceA1.class);
        // 对TestServiceA1类型成员变量进行Stub
        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1InB1).test1(Mockito.anyString());
    }

    public static void spy2(TestServiceB1 testServiceB1) {
        // 将对象testServiceB1中的TestServiceA1类型成员变量替换为Spy对象并返回
        TestServiceA1 testServiceA1InB1 = TestReplaceUtil.replaceSpyMember(testServiceB1, TestServiceA1.class);
        // 对TestServiceA1类型成员变量进行Stub
        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1InB1).test3(Mockito.anyString());
    }

    private TestSpSpyMemberOfMCommSpy() {
        throw new IllegalStateException("illegal");
    }
}
