package test.testmock.non_static.mock.singleton;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStaticSingleton1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//对单例模式的类进行Stub
@PrepareForTest({TestNonStaticSingleton1.class})
public class TestNStMSingleton1 extends TestMockNoSpBase {

    @Test
    public void test1() {

        PowerMockito.mockStatic(TestNonStaticSingleton1.class);

        TestNonStaticSingleton1 testNonStaticSingleton1Mock = Mockito.mock(TestNonStaticSingleton1.class);

        //对获取实例的静态方法进行Stub
        Mockito.when(TestNonStaticSingleton1.getInstance()).thenReturn(testNonStaticSingleton1Mock);

        Mockito.when(testNonStaticSingleton1Mock.test1()).thenReturn(TestConstants.MOCKED);

        String str = TestNonStaticSingleton1.getInstance().test1();
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

}
