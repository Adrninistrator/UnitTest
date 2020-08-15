package com.adrninistrator.service.impl;

import com.adrninistrator.service.TestCallRpcService;
import com.adrninistrator.service.TestRpcService;
import com.adrninistrator.static1.TestStaticRpcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCallRpcServiceImpl implements TestCallRpcService {

    @Autowired
    private TestRpcService testRpcService;

    @Override
    public String callStatic(String serviceInfo, String req) {
        return TestStaticRpcUtil.rpcCall(serviceInfo, req);
    }

    @Override
    public String callService(String serviceInfo, String req) {
        return testRpcService.rpcCall(serviceInfo, req);
    }
}
