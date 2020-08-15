package adrninistrator.test.testmock.static1.suppress.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid4;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

// 不使用@SuppressStaticInitializationFor注解，对应类的静态初始化方法未被禁止
public class TestStSuppressAnnotation2 extends TestMockNoSpBase {

    @Test
    public void test() {
        assertTrue(TestStaticPublicNonVoid4.isRun());
    }
}
