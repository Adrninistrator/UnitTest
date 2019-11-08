package com.test.non_static;

//存在多个构造函数
public class TestNonStatic4 extends TestNonStatic3 {

    public TestNonStatic4() {
        super();
    }

    public TestNonStatic4(String str) {

        testNonStatic1 = new TestNonStatic1();
    }
}
