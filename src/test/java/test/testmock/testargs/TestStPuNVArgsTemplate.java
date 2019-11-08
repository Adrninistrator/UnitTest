package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

import java.io.FileNotFoundException;

//参数为范型
@PrepareForTest({TestStaticPublicNonVoid3.class})
public class TestStPuNVArgsTemplate extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid3.class, new CallsRealMethods());
    }

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid3.test1(new RuntimeException());
        Assert.assertEquals(RuntimeException.class.getSimpleName(), str);

        Mockito.when(TestStaticPublicNonVoid3.test1(Mockito.any(RuntimeException.class))).thenReturn(TestConstants
                .MOCKED);

        str = TestStaticPublicNonVoid3.test1(new RuntimeException());
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test1(new FileNotFoundException());
        Assert.assertEquals(FileNotFoundException.class.getSimpleName(), str);
    }

    @Test
    public void test2() {

        String str = TestStaticPublicNonVoid3.test2(new RuntimeException());
        Assert.assertEquals(RuntimeException.class.getSimpleName(), str);

        Mockito.when(TestStaticPublicNonVoid3.test2(Mockito.any(Exception.class))).thenReturn(TestConstants
                .MOCKED);

        str = TestStaticPublicNonVoid3.test2(new RuntimeException());
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = TestStaticPublicNonVoid3.test2(new FileNotFoundException());
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
