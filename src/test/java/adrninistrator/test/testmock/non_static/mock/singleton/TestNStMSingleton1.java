package adrninistrator.test.testmock.non_static.mock.singleton;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticSingleton1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// 对单例模式的类进行Stub
@PrepareForTest({TestNonStaticSingleton1.class})
public class TestNStMSingleton1 extends TestMockNoSpBase {

    @Test
    public void test1() {
        PowerMockito.mockStatic(TestNonStaticSingleton1.class);

        TestNonStaticSingleton1 testNonStaticSingleton1Mock = Mockito.mock(TestNonStaticSingleton1.class);

        // 对获取实例的静态方法进行Stub
        Mockito.when(TestNonStaticSingleton1.getInstance()).thenReturn(testNonStaticSingleton1Mock);

        Mockito.when(testNonStaticSingleton1Mock.test1()).thenReturn(TestConstants.MOCKED);

        String str = TestNonStaticSingleton1.getInstance().test1();
        assertEquals(TestConstants.MOCKED, str);
    }

}
