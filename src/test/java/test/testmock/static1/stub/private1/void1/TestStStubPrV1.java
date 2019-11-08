package test.testmock.static1.stub.private1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockNoSpBase;

import java.io.FileNotFoundException;

//Stub生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStStubPrV1 extends TestMockNoSpBase {

    @Before
    public void init() {

        TestStaticPrivateVoid1.testPublic1(new StringBuffer());
    }

    @Test
    public void test() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.MOCKED));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPrivateVoid1.testPublic1(new StringBuffer());
    }
}
