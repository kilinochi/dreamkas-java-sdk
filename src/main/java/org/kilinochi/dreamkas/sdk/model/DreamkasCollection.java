package org.kilinochi.dreamkas.sdk.model;

/**
 * @author arman.shamenov
 */
public interface DreamkasCollection<T> extends DreamkasSerializable {
    Class<T> getType();
}
