package org.springframework.test.context.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;

// 使用事务的测试执行监听器，未出现异常时回滚数据库操作，出现异常时不回滚数据操作
public class TransactionalTestErrorSkipExecutionListener extends TransactionalTestExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionalTestErrorSkipExecutionListener.class);

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        String testClassName = testContext.getTestClass().getSimpleName();
        String testMethodName = testContext.getTestMethod().getName();

        boolean commit = false;

        Throwable throwable = testContext.getTestException();
        if (throwable != null) {
            logger.info("出现异常，不回滚（提交）数据库操作 {}.{}() {} {}", testClassName, testMethodName, throwable.getClass().getSimpleName(),
                    throwable.getMessage());
            commit = true;
        } else {
            logger.info("未出现异常，回滚（不提交）数据库操作 {}.{}()", testClassName, testMethodName);
        }

        TransactionContext txContext = TransactionContextHolder.getCurrentTransactionContext();
        if (txContext != null && commit) {
            // 不回滚（提交）数据库操作时，修改TransactionContext的flaggedForRollback变量为false，使其执行commit而不是rollback
            txContext.setFlaggedForRollback(false);
        }

        super.afterTestMethod(testContext);
    }
}
