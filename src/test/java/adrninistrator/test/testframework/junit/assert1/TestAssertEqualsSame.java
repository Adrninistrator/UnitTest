package adrninistrator.test.testframework.junit.assert1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
    assertEquals/assertNotEquals：判断对象的值是否相同/不同
    assertSame/assertNotSame：判断是否是/不是同一个对象
 */
public class TestAssertEqualsSame {

    private Integer integer1 = Integer.valueOf(10000);

    private Integer integer2 = Integer.valueOf(10000);

    private Integer integer3 = integer1;

    @Before
    public void init() {
        assertNotSame(integer1, integer2);

        assertSame(integer1, integer3);
    }

    @Test
    public void test() {
        // 需要使用大于127的数字，否则Integer会有缓存
        assertEquals(integer1, integer2);

        assertNotSame(integer1, integer2);

        assertEquals(integer1, integer3);

        assertSame(integer1, integer3);
    }
}
