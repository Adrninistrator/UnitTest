package adrninistrator.test.testmock.test_rpc.answer;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// 模拟对RPC调用进行Mock的Answer
public class AnswerRpcCall implements Answer {

    private static final Logger logger = LoggerFactory.getLogger(AnswerRpcCall.class);

    // 保存请求内容的列表
    private List<String> reqList = new ArrayList<>();

    // Mock后的返回
    private String mockedRsp;

    public AnswerRpcCall(String mockedRsp) {
        this.mockedRsp = mockedRsp;
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {

        String serviceInfo = invocation.getArgument(0);
        String req = invocation.getArgument(1);

        logger.info("### serviceInfo: {} req: {}", serviceInfo, req);

        reqList.add(req);

        // 使用Mock后的返回
        return mockedRsp;
    }

    public List<String> getReqList() {
        return reqList;
    }
}
