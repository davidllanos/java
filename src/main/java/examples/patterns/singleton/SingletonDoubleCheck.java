/*
 * SingletonDoubleCheck.java
 *
 * 2013, Telefonica I+D, all rights reserved
 */
package examples.patterns.singleton;

/**
 * @author davidllanos
 * 
 *         http://www.ibm.com/developerworks/java/library/j-dcl/index.html
 *         http://en.wikipedia.org/wiki/Double-checked_locking
 * 
 */
public final class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck instance = null;
    private long timestamp;

    private SingletonDoubleCheck() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Get instance (singleton)
     */
    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                // double checked locking - because second check of Singleton instance with lock
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    /**
     * Get timestamp when the instance was created
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Override clone method to avoid duplicate the singleton
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
