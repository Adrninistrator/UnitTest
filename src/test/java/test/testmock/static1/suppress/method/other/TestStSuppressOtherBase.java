package test.testmock.static1.suppress.method.other;

import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

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

        Assert.assertNull(str);

        str = TestStaticPublicNonVoid1.getFlag2();

        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        String str = testPublicNonVoidService1.getStaticFlag();

        Assert.assertNull(str);

        str = testPublicNonVoidService1.getStaticFlag2();

        Assert.assertNull(str);
    }

    @Test
    public void test3() {

        String str = TestStaticPublicNonVoid1.test1("", null);

        Assert.assertNull(str);
    }

    @Test
    public void test4() {

        String str = testPublicNonVoidService1.testStatic1("", null);

        Assert.assertNull(str);
    }

    protected abstract void doInit();
}
