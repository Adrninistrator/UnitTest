package test.testmock.static1.suppress.other;

import com.test.static1.TestStaticPublicNonVoid4;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import test.testmock.base.TestMockNoSpBase;

//使用@SuppressStaticInitializationFor注解，对应类的静态初始化方法被禁止
@SuppressStaticInitializationFor({"com.test.static1.TestStaticPublicNonVoid4"})
public class TestStSuppressAnnotation1 extends TestMockNoSpBase {

    @Test
    public void test() {

        Assert.assertFalse(TestStaticPublicNonVoid4.isRun());
    }
}
