package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//将真实方法替换为目标方法，间接调用Replace生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVMethod2 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePuNVMethod2.class, "replace_test1"));

        String str = testPublicNonVoidService1.testStatic1("", null);

        Assert.assertEquals(TestConstants.MOCKED, str);

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    public static String replace_test1(String str, TestTableEntity testTableEntity) {

        return TestConstants.MOCKED;
    }
}
