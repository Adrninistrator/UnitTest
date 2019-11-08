package test.testmock.static1.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

//PowerMockito.stub()方法可以在不包含@Test、@Before、@PrepareForTest注解的方法中执行
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStStubPuNVRun1 extends TestStStubPuNVBase {

    @Test
    public void test1() {

        TestStStubPuNVStub1.stub();

        String str = TestStaticPublicNonVoid1.test1("", null);

        //在类上指定@PrepareForTest({TestStaticPublicNonVoid1.class})，PowerMockito.stub生效
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
