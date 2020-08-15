package adrninistrator.test.testdatabase;

import adrninistrator.test.common.TestIdGen;
import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestTxService1;
import com.adrninistrator.service.impl.TestTxService1Impl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

// 将使用事务的类的实例的Mapper对象进行替换，错误的替换方法
public class TestDatabaseTxMockMemWrong extends TestMockBase {

    @Autowired
    private TestTxService1 testTxService1;

    @Autowired
    private TestTableMapper testTableMapper;

    @Before
    public void init() {
        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapperMock.insert(Mockito.any(TestTableEntity.class))).thenAnswer(invocation -> {
            TestTableEntity arg1 = invocation.getArgument(0);
            return testTableMapper.insert(arg1);
        });

        // 对TestTxService1Impl类中的TestTableMapper对象的updateByPrimaryKeySelective方法进行Stub，使TestTableMapper.test()方法在执行第二次数据库操作时出现异常
        Mockito.when(testTableMapperMock.updateByPrimaryKeySelective(Mockito.any(TestTableEntity.class))).thenThrow
                (new RuntimeException(TestConstants.MOCKED));

        Mockito.when(testTableMapperMock.selectByPrimaryKey(Mockito.anyString())).thenAnswer(invocation -> {
            String arg1 = invocation.getArgument(0);
            return testTableMapper.selectByPrimaryKey(arg1);
        });

        if (testTxService1.getClass().getName().contains(TestTxService1Impl.class.getSimpleName())) {
            // AOP代理对象类名中包含原始类名，说明使用CGLIB代理
            Whitebox.setInternalState(testTxService1, testTableMapperMock);
        } else {
            // AOP代理对象类名中不包含原始类名，说明使用JDK动态代理
            assertThrows(FieldNotFoundException.class, () ->
                    Whitebox.setInternalState(testTxService1, testTableMapperMock)
            );
        }
    }

    @Test
    public void testWithTx() {
        String id = TestIdGen.genId();

        // 由于对TestTxService1对象中的TestTableMapper对象替换不成功，因此TestTxService1.test()方法执行未出现异常，两次数据库操作执行完毕
        testTxService1.withTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    @Test
    public void testWithOutTx() {
        String id = TestIdGen.genId();

        // 由于对TestTxService1对象中的TestTableMapper对象替换不成功，因此TestTxService1.test()方法执行未出现异常，两次数据库操作执行完毕
        testTxService1.withOutTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }
}
