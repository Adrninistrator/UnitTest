package test.testmock.static1.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassEquals;

import java.io.FileNotFoundException;

//抛出异常，TestStaticPrivateNonVoid1.test2声明抛出FileNotFoundException异常，可以指定thenThrow FileNotFoundException
public class TestStPrNVThenThrow2 extends TestStaticPrivateNonVoidBase {

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST2, Mockito.anyString())
                .thenThrow(new FileNotFoundException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST2, "");
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        //指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic2(Mockito.anyString())).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST2, Mockito.anyString())
                .thenThrow(new FileNotFoundException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPrivateNonVoid1.testPublic2("");
    }
}
