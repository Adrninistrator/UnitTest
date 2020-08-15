package adrninistrator.test.testdatabase;

import adrninistrator.test.common.TestIdGen;
import com.adrninistrator.dao.entity.TestTableEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDbEntityGen {

    public static TestTableEntity genEntity1(String id, String flag) {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(id);
        testTableEntity.setFlag(flag);
        return testTableEntity;
    }

    public static List<TestTableEntity> genList1(int num, String flag) {
        List<TestTableEntity> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(genEntity1(TestIdGen.genId(), flag));
        }
        return list;
    }

    // 返回一个元素数量相同的list，id不变，flag值变为id值
    public static List<TestTableEntity> copyList1(List<TestTableEntity> srcList) {
        List<TestTableEntity> list = new ArrayList<>(srcList.size());

        for (int i = 0; i < srcList.size(); i++) {
            list.add(genEntity1(srcList.get(i).getId(), srcList.get(i).getId()));
        }
        return list;
    }

    public static TestTableEntity genEntity1WithTime(String id, String flag, Date createTime, Date updateTime) {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setId(id);
        testTableEntity.setFlag(flag);
        testTableEntity.setCreateTime(createTime);
        testTableEntity.setUpdateTime(updateTime);
        return testTableEntity;
    }

    public static List<TestTableEntity> genList1WithTime(int num, String flag, Date createTime, Date updateTime) {
        List<TestTableEntity> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(genEntity1WithTime(TestIdGen.genId(), flag, createTime, updateTime));
        }
        return list;
    }

    // 返回一个元素数量相同的list，id、create_time、update_time不变，flag值变为id值
    public static List<TestTableEntity> copyList1WithTime(List<TestTableEntity> srcList) {
        List<TestTableEntity> list = new ArrayList<>(srcList.size());

        for (int i = 0; i < srcList.size(); i++) {
            TestTableEntity testTableEntity = srcList.get(i);
            list.add(genEntity1WithTime(testTableEntity.getId(), testTableEntity.getId(), testTableEntity.getCreateTime(),
                    testTableEntity.getUpdateTime()));
        }
        return list;
    }

    private TestDbEntityGen() {
        throw new IllegalStateException("illegal");
    }
}
