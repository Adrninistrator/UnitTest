package adrninistrator.test.testmock.static1.effective.nomock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// PowerMockito.replace().with()执行多次的生效情况
public class TestStEffectiveReplace1 extends TestStEffectiveBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG2);

        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());

        // 最后一次PowerMockito.replace生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
