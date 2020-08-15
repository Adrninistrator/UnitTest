package adrninistrator.test.testmock.static1.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertThrows;

// 不使用@PrepareForTest注解指定TestStaticPublicNonVoid1.class
// 执行PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);方法会出现异常
public class TestStPuNVNoPrepare extends TestMockNoSpBase {

    @Test
    public void test() {
        assertThrows(Exception.class, () ->
                PowerMockito.mockStatic(TestStaticPublicNonVoid1.class)
        );
    }
}
