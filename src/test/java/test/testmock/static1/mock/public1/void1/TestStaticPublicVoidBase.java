package test.testmock.static1.mock.public1.void1;

import com.test.static1.TestStaticPublicVoid1;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

@PrepareForTest({TestStaticPublicVoid1.class})
public abstract class TestStaticPublicVoidBase extends TestMockNoSpBase {

    @Before
    public void initTestStaticPublicVoidBase() {

        PowerMockito.mockStatic(TestStaticPublicVoid1.class);
    }
}
