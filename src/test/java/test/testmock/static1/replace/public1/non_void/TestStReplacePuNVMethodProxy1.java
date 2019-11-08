package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.MethodProxy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVMethodProxy1 extends TestMockNoSpBase {

    @Test
    public void test() {

        MethodProxy.proxy(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1),
                new TestInvocationHandler1());

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG1);

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, testTableEntity);

        //MethodProxy.proxy也支持Replace，传入参数为Method
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
