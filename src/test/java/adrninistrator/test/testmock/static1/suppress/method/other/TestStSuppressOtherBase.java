package adrninistrator.test.testmock.static1.suppress.method.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public abstract class TestStSuppressOtherBase extends TestMockBase {

    @Autowired
    protected TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        doInit();
    }

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.getFlag();

        assertNull(str);

        str = TestStaticPublicNonVoid1.getFlag2();

        assertNull(str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.getStaticFlag();

        assertNull(str);

        str = testPublicNonVoidService1.getStaticFlag2();

        assertNull(str);
    }

    @Test
    public void test3() {
        String str = TestStaticPublicNonVoid1.test1("", null);

        assertNull(str);
    }

    @Test
    public void test4() {
        String str = testPublicNonVoidService1.testStatic1("", null);

        assertNull(str);
    }

    protected abstract void doInit();
}
