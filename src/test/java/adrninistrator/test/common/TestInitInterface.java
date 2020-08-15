package adrninistrator.test.common;

// 自定义执行初始化操作的接口，在每个继承TestMockBase类的@Test方法前执行
public interface TestInitInterface {

    // 执行初始化操作
    void init();
}
