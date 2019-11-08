package test.testmock.static1.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassEquals;

//抛出异常，TestStaticPrivateNonVoid1.test1未声明抛出异常，可以指定thenThrow RuntimeException
public class TestStPrNVThenThrow1 extends TestStaticPrivateNonVoidBase {

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.anyString(),
                Mockito.any(TestTableEntity.class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, "", new
                TestTableEntity());
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        //指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.anyString(),
                Mockito.any(TestTableEntity.class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPrivateNonVoid1.testPublic1("", new TestTableEntity());
    }
}
