package adrninistrator.test.testmock.test_rpc;

import adrninistrator.test.common.TestReplaceUtil;
import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.test_rpc.answer.AnswerRpcCall;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestCallRpcService;
import com.adrninistrator.service.TestRpcService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

// 模拟通过Spring服务进行RPC调用的Mock
public class TestRpcCallService extends TestMockBase {

    @Autowired
    private TestCallRpcService testCallRpcService;

    @Test
    public void test() {

        TestRpcService testRpcServiceMock = TestReplaceUtil.replaceMockMember(testCallRpcService, TestRpcService.class);

        AnswerRpcCall answer1 = new AnswerRpcCall(TestConstants.FLAG1);

        List<String> reqList1 = answer1.getReqList();

        // 分别对服务FLAG1、服务FLAG2进行Mock，指定对应的Answer，answer1、answer2
        Mockito.when(testRpcServiceMock.rpcCall(Mockito.eq(TestConstants.FLAG1), Mockito.anyString())).thenAnswer(answer1);

        // 调用服务FLAG1
        String result1 = testCallRpcService.callService(TestConstants.FLAG1, TestConstants.FLAG1);

        // 服务FLAG1返回被Mock的值，获得调用次数为1，及调用参数
        assertEquals(TestConstants.FLAG1, result1);
        assertEquals(1, reqList1.size());
        assertEquals(TestConstants.FLAG1, reqList1.get(0));
    }
}
