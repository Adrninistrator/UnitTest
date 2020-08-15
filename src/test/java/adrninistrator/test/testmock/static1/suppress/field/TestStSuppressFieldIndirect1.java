package adrninistrator.test.testmock.static1.suppress.field;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 间接调用使用了被Suppress的属性的方法，Suppress也生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldIndirect1 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = testPublicNonVoidService1.getStaticFlag();

        assertNull(str);

        str = testPublicNonVoidService1.getStaticFlag2();

        assertEquals(TestConstants.MINUS + "null", str);
    }
}
