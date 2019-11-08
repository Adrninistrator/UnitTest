package test.testmock.static1.mock.public1.non_void;

import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;

//不使用@PrepareForTest注解指定TestStaticPublicNonVoid1.class
//执行PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);方法会出现异常
public class TestStPuNVNoPrepare extends TestMockNoSpBase {

    @Test
    public void test() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }
}
