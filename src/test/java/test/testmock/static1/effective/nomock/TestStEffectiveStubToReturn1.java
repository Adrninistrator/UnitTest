package test.testmock.static1.effective.nomock;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.static1.effective.base.TestStEffectiveBase;

//PowerMockito.stub().toReturn()执行多次的生效情况
public class TestStEffectiveStubToReturn1 extends TestStEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.FLAG2);

        //最后一次PowerMockito.stub().toReturn()生效
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
