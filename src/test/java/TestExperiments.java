import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 01.12.2014.
 */
public class TestExperiments {

    @Test
    public void testExperiment() {
        assertEquals("Demo", "Demo");
        assertNotEquals("Demo ", "Demo");


    }

    @Test
    public void testExperiment2() {

        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void testExperiment3() {
        assertNull(null);
        assertNotNull(0);
    }

    @Test
    public void testExperiment4() {

        Object a = new Object();
        Object b = a;

        Object c = new Object();

        assertSame("This objects are equal", a, b);
        assertNotSame("This objects are NOT equal", a, c);
    }

    @Test
    public void testExperiment5() {

        assertThat("Help! Integers don't work", 0, is(0));

        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }



}


