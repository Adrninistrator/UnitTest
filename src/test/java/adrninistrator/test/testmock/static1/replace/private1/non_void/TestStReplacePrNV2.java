package adrninistrator.test.testmock.static1.replace.private1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Replace生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStReplacePrNV2 extends TestMockNoSpBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePrNV2.class, "replace_test1"));

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        assertEquals(TestConstants.MOCKED, str);
    }

    private static String replace_test1(String str, TestTableEntity testTableEntity) {
        return TestConstants.MOCKED;
    }
}
