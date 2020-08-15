package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThrows;

// 测试Mockito的Stub操作支持的对象
public class TestStubSupport extends TestMockBase {

    private TestNonStaticNoArg1 testNonStaticNoArg1 = new TestNonStaticNoArg1();

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        // 应出现指定异常
        assertThrows(Exception.class, () ->
                Mockito.when(testNonStaticNoArg1.test1()).thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test2() {
        // 应出现指定异常
        assertThrows(Exception.class, () ->
                Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1).test1(Mockito.anyString())
        );
    }
}
