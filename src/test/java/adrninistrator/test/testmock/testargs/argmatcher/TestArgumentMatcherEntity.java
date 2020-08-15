package adrninistrator.test.testmock.testargs.argmatcher;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.mockito.ArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestArgumentMatcherEntity implements ArgumentMatcher<TestTableEntity> {

    private static final Logger logger = LoggerFactory.getLogger(TestArgumentMatcherEntity.class);

    @Override
    public boolean matches(TestTableEntity argument) {
        logger.info("argument: {}", argument);

        if (argument == null) {
            return false;
        }

        return TestConstants.FLAG1.equals(argument.getFlag());
    }
}
