package adrninistrator.test.testmock.static1.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest({TestStaticPublicVoid1.class})
public abstract class TestStaticPublicVoidBase extends TestMockNoSpBase {

    @Before
    public void initTestStaticPublicVoidBase() {
        PowerMockito.mockStatic(TestStaticPublicVoid1.class);
    }
}
