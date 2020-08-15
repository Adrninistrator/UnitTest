package adrninistrator.test.testmock.test_rpc;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.test_rpc.answer.AnswerRpcCall;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestCallRpcService;
import com.adrninistrator.static1.TestStaticRpcUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

// 模拟通过静态方法进行RPC调用的Mock
@PrepareForTest({TestStaticRpcUtil.class})
public class TestRpcCallStatic extends TestMockBase {

    @Autowired
    private TestCallRpcService testCallRpcService;

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticRpcUtil.class);
    }

    @Test
    public void test() {

        AnswerRpcCall answer1 = new AnswerRpcCall(TestConstants.FLAG1);
        AnswerRpcCall answer2 = new AnswerRpcCall(TestConstants.FLAG2);

        List<String> reqList1 = answer1.getReqList();
        List<String> reqList2 = answer2.getReqList();

        // 分别对服务FLAG1、服务FLAG2进行Mock，指定对应的Answer，answer1、answer2
        Mockito.when(TestStaticRpcUtil.rpcCall(Mockito.eq(TestConstants.FLAG1), Mockito.anyString())).thenAnswer(answer1);
        Mockito.when(TestStaticRpcUtil.rpcCall(Mockito.eq(TestConstants.FLAG2), Mockito.anyString())).thenAnswer(answer2);

        // 调用服务FLAG1
        String result1 = testCallRpcService.callStatic(TestConstants.FLAG1, TestConstants.FLAG1);

        // 服务FLAG1返回被Mock的值，获得调用次数为1，及调用参数
        assertEquals(TestConstants.FLAG1, result1);
        assertEquals(1, reqList1.size());
        assertEquals(TestConstants.FLAG1, reqList1.get(0));

        // 服务FLAG2未被调用
        assertEquals(0, reqList2.size());

        // 调用服务FLAG2
        String result2 = testCallRpcService.callStatic(TestConstants.FLAG2, TestConstants.FLAG2);

        // 服务FLAG2返回被Mock的值，获得调用次数为1，及调用参数
        assertEquals(TestConstants.FLAG2, result2);
        assertEquals(1, reqList2.size());
        assertEquals(TestConstants.FLAG2, reqList2.get(0));

        // 再次调用服务FLAG1
        result1 = testCallRpcService.callStatic(TestConstants.FLAG1, TestConstants.FLAG3);

        // 服务FLAG1返回被Mock的值，获得调用次数为1，及调用参数
        assertEquals(TestConstants.FLAG1, result1);
        assertEquals(2, reqList1.size());
        assertEquals(TestConstants.FLAG1, reqList1.get(0));
        assertEquals(TestConstants.FLAG3, reqList1.get(1));
    }
}
