package adrninistrator.test.testmock.static1.suppress.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid4;
import org.junit.Test;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;

import static org.junit.Assert.assertFalse;

// 使用@SuppressStaticInitializationFor注解，对应类的静态初始化方法被禁止
@SuppressStaticInitializationFor({"com.adrninistrator.static1.TestStaticPublicNonVoid4"})
public class TestStSuppressAnnotation1 extends TestMockNoSpBase {

    @Test
    public void test() {
        assertFalse(TestStaticPublicNonVoid4.isRun());
    }
}
