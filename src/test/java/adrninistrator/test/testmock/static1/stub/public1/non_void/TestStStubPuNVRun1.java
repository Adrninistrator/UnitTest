package adrninistrator.test.testmock.static1.stub.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// PowerMockito.stub()方法可以在不包含@Test、@Before、@PrepareForTest注解的方法中执行
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStStubPuNVRun1 extends TestStStubPuNVBase {

    @Test
    public void test1() {
        TestStStubPuNVStub1.stub();

        String str = TestStaticPublicNonVoid1.test1("", null);

        // 在类上指定@PrepareForTest({TestStaticPublicNonVoid1.class})，PowerMockito.stub生效
        assertEquals(TestConstants.MOCKED, str);
    }
}
