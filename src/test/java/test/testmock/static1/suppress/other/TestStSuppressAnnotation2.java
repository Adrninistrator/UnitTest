package test.testmock.static1.suppress.other;

import com.test.static1.TestStaticPublicNonVoid4;
import org.junit.Assert;
import org.junit.Test;
import test.testmock.base.TestMockNoSpBase;

//不使用@SuppressStaticInitializationFor注解，对应类的静态初始化方法未被禁止
public class TestStSuppressAnnotation2 extends TestMockNoSpBase {

    @Test
    public void test() {

        Assert.assertTrue(TestStaticPublicNonVoid4.isRun());
    }
}
