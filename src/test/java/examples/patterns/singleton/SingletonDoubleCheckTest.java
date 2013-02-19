/*
 * SingletonDoubleCheckTest.java
 *
 * 2013, Telefonica I+D, all rights reserved
 */
package examples.patterns.singleton;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author davidllanos
 * 
 */
public class SingletonDoubleCheckTest extends TestCase {

    /*
     * Create the test case
     * 
     * @param testName
     * name of the test case
     */
    public SingletonDoubleCheckTest(String testName) {
        super(testName);
    }

    /*
     * Assembles and returns a test suite for all the test methods of this test case.
     * 
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SingletonDoubleCheckTest.class);
    }

    /*
     * Test SingletonDoubleCheck to check that the instance is the same for two different invocations
     */
    public void testSingletonDoubleCheck() {
        SingletonDoubleCheck singletonDoubleCheck = SingletonDoubleCheck.getInstance();
        long timestamp = singletonDoubleCheck.getTimestamp();
        SingletonDoubleCheck newSingletonDoubleCheck = SingletonDoubleCheck.getInstance();
        assertEquals(timestamp, newSingletonDoubleCheck.getTimestamp());
        assertEquals(singletonDoubleCheck, newSingletonDoubleCheck);
    }

    /*
     * Test SingletonDoubleCheck to check that the instance is the same for multithread invocations
     */
    public void testSingletonDoubleCheckMultithread() {
        SingletonDoubleCheck singletonDoubleCheck = SingletonDoubleCheck.getInstance();
        long timestamp = singletonDoubleCheck.getTimestamp();

        for (int i = 0; i < 10000; i++) {
            new SingletonThrower();
        }

        SingletonDoubleCheck newSingletonDoubleCheck = SingletonDoubleCheck.getInstance();
        assertEquals(timestamp, newSingletonDoubleCheck.getTimestamp());
        assertEquals(singletonDoubleCheck, newSingletonDoubleCheck);
    }

    /*
     * Test SingletonDoubleCheck to check that it is not clonable
     */
    public void testSingletonDoubleCheckNoClonable() {
        SingletonDoubleCheck singletonDoubleCheck = SingletonDoubleCheck.getInstance();
        try {
            singletonDoubleCheck.clone();
            fail("Should raise a ProductNotFoundException");
        } catch (CloneNotSupportedException e) {
            // successful test
        }
    }

}

class SingletonThrower extends Thread {

    SingletonThrower() {
        this.start();
    }

    public void run() {
        SingletonDoubleCheck.getInstance();
    }

}
