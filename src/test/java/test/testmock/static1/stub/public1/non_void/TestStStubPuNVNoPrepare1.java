package test.testmock.static1.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

//不使用@PrepareForTest注解指定被Stub方法所在类，Stub不生效
public class TestStStubPuNVNoPrepare1 extends TestStStubPuNVBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", null);

        //由于没有通过@PrepareForTest指定TestStaticPublicNonVoid1.class，因此PowerMockito.stub不生效
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
