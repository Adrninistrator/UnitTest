package test.testmock.mockpolicy.suppress;

import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.suppress.TestPolicySuppress2;

@MockPolicy(TestPolicySuppress2.class)
public class TestMockPolicySuppress2 extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.getFlag();
        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        //通过反射获取testServiceB1中的testServiceA1对象非空
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, "testServiceA1");
        Assert.assertNotNull(testServiceA1InB1);

        //由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        testServiceB1.test1("");
    }
}
