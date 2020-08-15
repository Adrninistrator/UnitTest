package adrninistrator.test.testmock.non_static.mock.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.non_static.TestNonStatic1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

/*
    对原始对象进行Stub
    Stub操作需要对Mock或Spy对象执行，不支持对原始对象执行
 */
public class TestNStMockRaw extends TestMockNoSpBase {

    @Test
    public void test() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        assertThrows(Exception.class, () ->
                Mockito.when(testNonStatic1.test1()).thenReturn(null)
        );
    }
}
