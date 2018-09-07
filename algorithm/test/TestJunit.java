import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {

    public int test1() {
        return 2;
    }

    public void hello() {
        System.out.println("hello,junit");
    }

    @Test
    public void testHello() {
        hello();
        assertEquals(1,test1());
    }
}
