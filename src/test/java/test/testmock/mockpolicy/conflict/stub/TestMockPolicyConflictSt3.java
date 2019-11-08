package test.testmock.mockpolicy.conflict.stub;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub2;

@MockPolicy({TestPolicyStub2.class})
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestMockPolicyConflictSt3 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test2() {

        String str = testPublicNonVoidService1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
