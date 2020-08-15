package adrninistrator.testsuite.testmock.spring.mock_member;

import adrninistrator.test.testmock.spring.mock_member.TestSpMockMember;
import adrninistrator.test.testmock.spring.mock_member.TestSpMockMemberOfM1;
import adrninistrator.test.testmock.spring.mock_member.TestSpMockMemberOfM2;
import adrninistrator.test.testmock.spring.mock_member.TestSpMockMemberOrder;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        TestSpMockMember.class,
        TestSpMockMemberOfM1.class,
        TestSpMockMemberOfM2.class,
        TestSpMockMemberOrder.class
})
public class TestSuiteTMSpMM {
}
