package com.adrninistrator.service.impl;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestRpcService;
import com.adrninistrator.util.TestCallTimesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// 模拟RPC调用的服务
@Service
public class TestRpcServiceImpl implements TestRpcService {

    private static final Logger logger = LoggerFactory.getLogger(TestRpcServiceImpl.class);

    /**
     * 模拟RPC调用的简单方法
     *
     * @param serviceInfo 远程服务信息，如URL、Topic等
     * @param req         请求内容
     * @return 返回内容
     */
    @Override
    public String rpcCall(String serviceInfo, String req) {

        logger.info("serviceInfo: {} req: {}", serviceInfo, req);

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }
}
