/*
 * SingletonPublicFinalFieldTest.java
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
public class SingletonPublicFinalFieldTest extends TestCase {

    /**
     * Create the test case
     * 
     * @param testName
     *            name of the test case
     */
    public SingletonPublicFinalFieldTest(String testName) {
        super(testName);
    }

    /**
     * Assembles and returns a test suite for all the test methods of this test case.
     * 
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SingletonPublicFinalFieldTest.class);
    }

    /**
     * 
     */
    public void testSingletonDoubleCheck() {
        SingletonPublicFinalField firstSingletonPublicFinalField = SingletonPublicFinalField.INSTANCE;
        SingletonPublicFinalField secondSingletonPublicFinalField = SingletonPublicFinalField.INSTANCE;
        assertTrue(firstSingletonPublicFinalField == secondSingletonPublicFinalField);
    }

}
