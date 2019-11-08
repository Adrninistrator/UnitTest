package test.testmock.static1.mock.private1.void1;

import com.test.static1.TestStaticPrivateVoid1;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

@PrepareForTest({TestStaticPrivateVoid1.class})
public abstract class TestStaticPrivateVoidBase extends TestMockNoSpBase {

    @Before
    public void initTestStaticPrivateVoidBase() {

        PowerMockito.mockStatic(TestStaticPrivateVoid1.class);
    }
}
