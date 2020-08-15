package adrninistrator.test.testframework.junit.assert1.matchers;

import com.adrninistrator.dao.entity.TestTableEntity;

public class TestMatcherTestTableEntity2 extends TestMatcherSimple<TestTableEntity> {

    private String id;
    private String flag;

    public TestMatcherTestTableEntity2(String id, String flag) {
        this.id = id;
        this.flag = flag;
    }

    @Override
    public boolean matches2(TestTableEntity item) {
        return id.equals(item.getId()) && flag.equals(item.getFlag());
    }
}
