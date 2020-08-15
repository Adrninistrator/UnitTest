package adrninistrator.test.testmock.static1.mock.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestStPuNVThenThrow extends TestStaticPublicNonVoidBase {

    @Test
    public void test1() {
        // TestStaticPublicNonVoid1.test1未声明抛出异常，thenThrow可以指定RuntimeException或其子类
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenThrow(new RuntimeException(TestConstants.MOCKED));

        // 应出现指定异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid1.test1("", new TestTableEntity())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() {
        // TestStaticPublicNonVoid1.test1未声明抛出异常，thenThrow可以指定RuntimeException或其子类
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenThrow(new IndexOutOfBoundsException(TestConstants.MOCKED));

        // 应出现指定异常
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () ->
                TestStaticPublicNonVoid1.test1("", new TestTableEntity())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test3() throws FileNotFoundException {

        // TestStaticPublicNonVoid1.test2有声明抛出FileNotFoundException异常，thenThrow指定的异常类型需要与方法声明的异常类型相符
        Mockito.when(TestStaticPublicNonVoid1.test2(Mockito.anyString())).thenThrow(new FileNotFoundException
                (TestConstants.MOCKED));

        // 应出现指定异常
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                TestStaticPublicNonVoid1.test2("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
