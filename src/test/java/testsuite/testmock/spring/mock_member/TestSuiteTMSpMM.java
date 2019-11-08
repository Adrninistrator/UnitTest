package testsuite.testmock.spring.mock_member;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.testmock.spring.mock_member.TestSpMockMember;
import test.testmock.spring.mock_member.TestSpMockMemberOfM1;
import test.testmock.spring.mock_member.TestSpMockMemberOfM2;
import test.testmock.spring.mock_member.TestSpMockMemberOrder;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        TestSpMockMember.class,
        TestSpMockMemberOfM1.class,
        TestSpMockMemberOfM2.class,
        TestSpMockMemberOrder.class
})
public class TestSuiteTMSpMM {
}
