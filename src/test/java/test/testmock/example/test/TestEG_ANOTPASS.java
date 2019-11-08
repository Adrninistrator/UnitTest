package test.testmock.example.test;

import com.test.service.example.TestServiceEG4;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.example.policy.TestPolicyEGANotPass;

@MockPolicy({TestPolicyEGANotPass.class})
public class TestEG_ANOTPASS extends TestMockBase {

    @Autowired
    private TestServiceEG4 testServiceEG4;

    @Test
    public void test() {

        String str = testServiceEG4.test("");

        Assert.assertNull(str);
    }
}
