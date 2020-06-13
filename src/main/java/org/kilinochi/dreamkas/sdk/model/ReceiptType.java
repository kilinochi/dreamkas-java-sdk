package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */

public enum ReceiptType implements DreamkasEnum {
    /**
     * Приход
     */
    SALE("sale"),
    /**
     * Возврат прихода
     */
    REFUND("refund"),
    /**
     * Расход
     */
    OUTFLOW("outflow"),
    /**
     * Возврат расхода
     */
    OUTFLOW_REFUND("outflow_refund");

    private final String value;

    ReceiptType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ReceiptType create(String text) {
        return DreamkasEnum.create(ReceiptType.class, text);
    }
}
