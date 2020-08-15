package com.adrninistrator.static1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 模拟RPC调用的工具类，静态方法
public class TestStaticRpcUtil {

    private static final Logger logger = LoggerFactory.getLogger(TestStaticRpcUtil.class);

    /**
     * 模拟RPC调用的简单方法
     *
     * @param serviceInfo 远程服务信息，如URL、Topic等
     * @param req         请求内容
     * @return 返回内容
     */
    public static String rpcCall(String serviceInfo, String req) {

        logger.info("serviceInfo: {} req: {}", serviceInfo, req);

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    private TestStaticRpcUtil() {
        throw new IllegalStateException("illegal");
    }
}
