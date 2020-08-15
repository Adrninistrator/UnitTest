package adrninistrator.test.testmock.spring.replace.public1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertThrows;

// Replace公有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePuNV3 extends TestSpStubBase {

    @Test
    public void test() {
        // PowerMockito.replace().with()方法，要求被替换的方法，及替换后的方法均为静态方法，因此会报错
        assertThrows(Exception.class, () ->
                PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).with
                        (PowerMockito.method(TestSpReplacePuNV3.class, "replace_test1"))
        );
    }

    public static String replace_test1(String str) {
        return null;
    }
}
