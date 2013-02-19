/*
 * SingletonPublicFinalField.java
 *
 * 2013, Telefonica I+D, all rights reserved
 */
package examples.patterns.singleton;

/**
 * @author davidllanos
 * 
 *         Effective Java Second Edition
 * 
 */
public final class SingletonPublicFinalField {
    public static final SingletonPublicFinalField INSTANCE = new SingletonPublicFinalField();

    private SingletonPublicFinalField() {
    }

}
