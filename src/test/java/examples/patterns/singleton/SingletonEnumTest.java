/*
 * SingletonEnumTest.java
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
public class SingletonEnumTest extends TestCase {

    /**
     * Create the test case
     * 
     * @param testName
     *            name of the test case
     */
    public SingletonEnumTest(String testName) {
        super(testName);
    }

    /**
     * Assembles and returns a test suite for all the test methods of this test case.
     * 
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SingletonEnumTest.class);
    }

    /**
     * 
     */
    public void testSingletonEnum() {
        SingletonEnum firstSingletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum secondSingletonEnum = SingletonEnum.INSTANCE;
        assertTrue(firstSingletonEnum == secondSingletonEnum);
    }

}
