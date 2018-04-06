package moe.ijnji;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RootServletTest extends TestCase {

    public RootServletTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(RootServletTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }
}
