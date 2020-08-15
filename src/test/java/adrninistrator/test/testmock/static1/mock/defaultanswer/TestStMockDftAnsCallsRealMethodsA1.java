package adrninistrator.test.testmock.static1.mock.defaultanswer;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer为执行真实方法
    使用Mockito.CALLS_REAL_METHODS
*/
public class TestStMockDftAnsCallsRealMethodsA1 extends TestStMockDftAnsCallsRealMethodsBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, Mockito.CALLS_REAL_METHODS);
    }

    // 被Stub的方法不受默认Answer的影响
    @Test
    public void test() {
        Map<String, String> mapMock = new HashMap<>(1);
        mapMock.put(TestConstants.MOCKED, TestConstants.MOCKED);

        Mockito.when(TestStaticPublicNonVoid2.testMap(Mockito.anyString())).thenReturn(mapMock);

        Map map = TestStaticPublicNonVoid2.testMap("");
        assertEquals(1, map.size());
        assertEquals(TestConstants.MOCKED, map.get(TestConstants.MOCKED));
    }
}
