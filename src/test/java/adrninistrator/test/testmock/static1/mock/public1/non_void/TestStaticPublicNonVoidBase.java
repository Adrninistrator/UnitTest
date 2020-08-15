package adrninistrator.test.testmock.static1.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public abstract class TestStaticPublicNonVoidBase extends TestMockNoSpBase {

    @Before
    public void initTestStaticPublicNonVoidBase() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }
}
