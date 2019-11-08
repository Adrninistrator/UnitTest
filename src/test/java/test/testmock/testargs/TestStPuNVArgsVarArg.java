package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//变长参数
@PrepareForTest({TestStaticPublicNonVoid3.class})
public class TestStPuNVArgsVarArg extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid3.class);
    }

    //可以分别设置参数数量在不同情况下的处理
    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.anyString())).thenReturn(TestConstants
                .FLAG1);

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.anyString(), Mockito.anyString())).thenReturn(TestConstants
                .FLAG2);

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(TestConstants.FLAG3);

        String str = TestStaticPublicNonVoid3.test3("");
        Assert.assertEquals(TestConstants.FLAG1, str);

        str = TestStaticPublicNonVoid3.test3("", "");
        Assert.assertEquals(TestConstants.FLAG2, str);

        str = TestStaticPublicNonVoid3.test3("", "", "");
        Assert.assertEquals(TestConstants.FLAG3, str);
    }

    //Mockito.any()方法能够匹配任意数量的任意参数
    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.any(), Mockito.any())).thenReturn(TestConstants
                .MOCKED);

        String str = TestStaticPublicNonVoid3.test3("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test3("", "");
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test3("", "", "");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test3() {

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.anyString())).thenReturn(TestConstants
                .MOCKED);

        String str = TestStaticPublicNonVoid3.test3("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test3("", "");
        Assert.assertNull(str);
    }

    @Test
    public void test4() {

        Mockito.when(TestStaticPublicNonVoid3.test3(Mockito.any(String.class))).thenReturn(TestConstants
                .MOCKED);

        String str = TestStaticPublicNonVoid3.test3("");
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test3("", "");
        Assert.assertNull(str);
    }
}
