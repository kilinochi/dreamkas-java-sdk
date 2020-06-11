package org.kilinochi.dreamkas.sdk.model;

/**
 * @author arman.shamenov
 */
public interface DreamkasEnum extends DreamkasSerializable {
    /**
     * Get type of enum
     */
    String getValue();

    static <T extends Enum<T>> T create(Class<T> enumClass, String value) {
        return value == null ? null : Enum.valueOf(enumClass, value.toUpperCase());
    }
}
