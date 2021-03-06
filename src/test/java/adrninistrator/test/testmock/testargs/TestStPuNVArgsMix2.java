package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 与ArgumentMatchers类的方法一起使用，当需要指定值时，可以使用Mockito.eq()方法
public class TestStPuNVArgsMix2 extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.eq(TestConstants.FLAG1), Mockito.any(TestTableEntity
                .class))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.eq(testTableEntity))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test3() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.eq(TestConstants.FLAG1), Mockito.eq(testTableEntity)))
                .thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test4() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.startsWith(TestConstants.FLAG1), Mockito.eq
                (testTableEntity))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test5() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.isNotNull(), Mockito.eq(testTableEntity))).thenReturn
                (TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test6() {
        TestTableEntity testTableEntity = new TestTableEntity();

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument)),
                Mockito.eq(testTableEntity))).thenReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);
        assertEquals(TestConstants.MOCKED, str);
    }
}
