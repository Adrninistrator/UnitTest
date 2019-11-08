package test.testmock.testargs;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//ArgumentMatchers类的方法不能与指定值一起使用
public class TestStPuNVArgsMix1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, Mockito.any(TestTableEntity
                .class))).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test2() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), new TestTableEntity())).thenReturn(TestConstants.MOCKED);
    }

    @Test
    public void test3() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.eq(TestConstants.FLAG1), testTableEntity)).thenReturn
                (TestConstants.MOCKED);
    }

    @Test
    public void test4() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.startsWith(TestConstants.FLAG1), testTableEntity))
                .thenReturn
                        (TestConstants.MOCKED);
    }

    @Test
    public void test5() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.isNotNull(), testTableEntity)).thenReturn
                (TestConstants.MOCKED);
    }

    @Test
    public void test6() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument)),
                testTableEntity)).thenReturn(TestConstants.MOCKED);
    }
}
