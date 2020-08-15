package com.adrninistrator.service;

public interface TestCallRpcService {

    String callStatic(String serviceInfo, String req);

    String callService(String serviceInfo, String req);
}
