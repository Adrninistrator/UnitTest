package test.testmock.static1.stub.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockNoSpBase;

import java.io.FileNotFoundException;

//Stub生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStStubPuV1 extends TestMockNoSpBase {

    @Before
    public void init() {

        TestStaticPublicVoid1.test1(new StringBuffer());
    }

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).toThrow(
                (new FileNotFoundException(TestConstants.MOCKED)));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicVoid1.test1(new StringBuffer());
    }
}
