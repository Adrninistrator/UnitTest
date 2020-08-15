package adrninistrator.test.testmock.testargs;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

// ArgumentMatchers类的方法不能与指定值一起使用
public class TestStPuNVArgsMix1 extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, Mockito.any(TestTableEntity
                        .class))).thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test2() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), new TestTableEntity())).thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test3() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.eq(TestConstants.FLAG1), new TestTableEntity())).thenReturn
                        (TestConstants.MOCKED)
        );
    }

    @Test
    public void test4() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.startsWith(TestConstants.FLAG1), new TestTableEntity()))
                        .thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test5() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.isNotNull(), new TestTableEntity())).thenReturn
                        (TestConstants.MOCKED)
        );
    }

    @Test
    public void test6() {
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.argThat(argument -> TestConstants.FLAG1.equals(argument)),
                        new TestTableEntity())).thenReturn(TestConstants.MOCKED)
        );
    }
}
