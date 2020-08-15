package adrninistrator.test.base;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

// 数据相关测试基类，测试方法结束时数据库相关操作默认自动回滚
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@Transactional
public abstract class TestDbRollbackBase extends TestDbBase {
}
