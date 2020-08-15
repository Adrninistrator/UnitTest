package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.private_constructor.TestPrivateConstructor1;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.*;

// 创建构造函数为私有的类的实例
public class TestNewPrivateConstructor1 extends TestMockNoSpBase {

    @Test
    public void test1() {
        // Whitebox.newInstance()方法不会调用构造函数
        TestPrivateConstructor1 testPrivateConstructor1 = Whitebox.newInstance(TestPrivateConstructor1.class);

        assertNotNull(testPrivateConstructor1);
        assertTrue(testPrivateConstructor1 instanceof TestPrivateConstructor1);

        TestPrivateConstructor1 TestPrivateConstructor12 = Whitebox.newInstance(TestPrivateConstructor1.class);

        assertNotNull(TestPrivateConstructor12);
        assertTrue(TestPrivateConstructor12 instanceof TestPrivateConstructor1);

        assertNotSame(testPrivateConstructor1, TestPrivateConstructor12);
    }

    @Test
    public void test2() throws Exception {
        // Whitebox.invokeConstructor()方法会调用构造函数，在构造函数中会抛出异常
        assertThrows(Exception.class, () ->
                Whitebox.invokeConstructor(TestPrivateConstructor1.class)
        );
    }
}
