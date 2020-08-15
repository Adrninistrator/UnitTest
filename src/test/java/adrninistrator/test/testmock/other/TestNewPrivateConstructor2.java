package adrninistrator.test.testmock.other;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.private_constructor.TestPrivateConstructor2;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestNewPrivateConstructor2 extends TestMockNoSpBase {

    @Test
    public void test1() {
        // Whitebox.newInstance()方法不会调用构造函数
        TestPrivateConstructor2 testPrivateConstructor2 = Whitebox.newInstance(TestPrivateConstructor2.class);

        assertNull(testPrivateConstructor2.getFlag());
    }

    @Test
    public void test2() throws Exception {

        // Whitebox.invokeConstructor()方法会调用构造函数
        TestPrivateConstructor2 testPrivateConstructor2 = Whitebox.invokeConstructor(TestPrivateConstructor2.class);

        assertEquals(TestConstants.FLAG1, testPrivateConstructor2.getFlag());
    }
}
