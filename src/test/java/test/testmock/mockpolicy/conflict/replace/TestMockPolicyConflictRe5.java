package test.testmock.mockpolicy.conflict.replace;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.static1.TestStaticPublicNonVoid2;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.replace.TestPolicyReplace1;

@MockPolicy({TestPolicyReplace1.class})
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestMockPolicyConflictRe5 extends TestMockBase {

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
