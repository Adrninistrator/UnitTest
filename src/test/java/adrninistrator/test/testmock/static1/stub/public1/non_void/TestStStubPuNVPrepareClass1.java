package adrninistrator.test.testmock.static1.stub.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 在类级别使用@PrepareForTest注解指定被Stub方法所在类，Stub生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStStubPuNVPrepareClass1 extends TestStStubPuNVBase {

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", null);

        // 在类上指定@PrepareForTest({TestStaticPublicNonVoid1.class})，PowerMockito.stub生效
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        // PowerMockito.method可以指定方法参数
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1,
                String.class, TestTableEntity.class)).toThrow(new RuntimeException(TestConstants.MOCKED));

        // PowerMockito.stub.toThrow生效
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid1.test1("", null)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
