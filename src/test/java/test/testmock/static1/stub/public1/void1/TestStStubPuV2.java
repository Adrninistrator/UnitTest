package test.testmock.static1.stub.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

import java.io.FileNotFoundException;

//Stub间接调用生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStStubPuV2 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Before
    public void init() {

        testPublicVoidService1.test1(new StringBuffer());
    }

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).toThrow(
                (new FileNotFoundException(TestConstants.MOCKED)));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassEquals(FileNotFoundException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1.testStatic1(new StringBuffer());
    }
}
