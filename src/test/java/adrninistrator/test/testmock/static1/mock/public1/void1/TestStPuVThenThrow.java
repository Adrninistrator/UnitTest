package adrninistrator.test.testmock.static1.mock.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestStPuVThenThrow extends TestStaticPublicVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        // 应出现指定异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicVoid1.test1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
