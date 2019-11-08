package test.testmock.mybatis.delegatesto;

import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMybatisDelegate {

    @Autowired
    private TestTableMapper testTableMapper;

    private String time;

    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    public int insert(TestTableEntity record) {

        if (record == null) {
            return 0;
        }

        if (time.equals(record.getId()) && time.equals(record.getFlag())) {
            return testTableMapper.insert(record);
        }

        return 0;
    }

    public int insertSelective(TestTableEntity record) {
        return 0;
    }

    public TestTableEntity selectByPrimaryKey(String id) {

        if (time.equals(id)) {
            return testTableMapper.selectByPrimaryKey(id);
        }

        return null;
    }

    public int updateByPrimaryKeySelective(TestTableEntity record) {
        return 0;
    }

    public int updateByPrimaryKey(TestTableEntity record) {
        return 0;
    }

    public TestTableEntity selectRecord(@Param("id1") String id1, @Param("id2") String id2) {
        return null;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
