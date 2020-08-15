package com.adrninistrator.non_static;

// 存在一个构造函数
public class TestNonStatic3 {

    protected TestNonStatic1 testNonStatic1;

    public TestNonStatic3() {
        testNonStatic1 = new TestNonStatic1();
    }

    public TestNonStatic1 getTestNonStatic1() {
        return testNonStatic1;
    }
}
