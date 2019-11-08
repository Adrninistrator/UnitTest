package test.testmock.static1.replace.private1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPrivateNonVoidService1;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Replace间接调用生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStReplacePrNV4 extends TestMockBase {

    @Autowired
    private TestPrivateNonVoidService1 testPrivateNonVoidService1;

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePrNV4.class, "replace_test1"));

        String str = testPrivateNonVoidService1.testStatic1("", null);

        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    private static String replace_test1(String str, TestTableEntity testTableEntity) {

        return TestConstants.MOCKED;
    }
}
