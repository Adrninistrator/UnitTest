package adrninistrator.test.testmock.static1.effective.mock;

import adrninistrator.test.testmock.static1.effective.base.TestStEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Mockito.when()与PowerMockito.stub().toThrow()的生效情况
// 不满足Mockito.when()的条件，且执行真实方法
public class TestStEffectiveMockStThr2CallReal extends TestStEffectiveBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class, new CallsRealMethods());
    }

    @Test
    public void test() throws Exception {

        PowerMockito.doReturn(TestConstants.FLAG1).when(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4, TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        // PowerMockito.doReturn().when()条件不满足，执行真实方法，PowerMockito.stub().toThrow()生效，抛出异常
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                TestStaticPublicNonVoid1.test4("")
        );
        assertEquals(TestConstants.FLAG2, exception.getMessage());
    }
}
