package test.testmock.static1.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;

import java.io.FileNotFoundException;

//抛出异常
public class TestStPuNVThenThrow extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {

        //TestStaticPublicNonVoid1.test1未声明抛出异常，thenThrow可以指定RuntimeException或其子类
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenThrow(new RuntimeException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid1.test1("", new TestTableEntity());
    }

    @Test
    public void test2() {

        //TestStaticPublicNonVoid1.test1未声明抛出异常，thenThrow可以指定RuntimeException或其子类
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenThrow(new IndexOutOfBoundsException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(IndexOutOfBoundsException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid1.test1("", new TestTableEntity());
    }

    @Test
    public void test3() throws FileNotFoundException {

        //TestStaticPublicNonVoid1.test2有声明抛出FileNotFoundException异常，thenThrow指定的异常类型需要与方法声明的异常类型相符
        Mockito.when(TestStaticPublicNonVoid1.test2(Mockito.anyString())).thenThrow(new FileNotFoundException
                (TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid1.test2("");
    }
}
