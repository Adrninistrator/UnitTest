package adrninistrator.test.testmock.static1.mock.private1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest({TestStaticPrivateNonVoid1.class})
public abstract class TestStaticPrivateNonVoidBase extends TestMockNoSpBase {

    @Before
    public void initTestStaticPrivateNonVoidBase() {
        PowerMockito.mockStatic(TestStaticPrivateNonVoid1.class);
    }
}
