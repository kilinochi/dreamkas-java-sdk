package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum PaymentType implements DreamkasEnum {
    /**
     * Наличные
     */
    CASH("cash"),
    /**
     * Безналичные
     */
    CASHLESS("cashless"),
    /**
     * Аванс
     */
    PREPAID("prepaid"),
    /**
     * Кредит
     */
    CREDIT("credit"),
    /**
     * Встречное предоставление
     */
    CONSIDERATION("consideration");


    private final String value;

    PaymentType(String value) {
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
    public static PaymentType create(String text) {
        return DreamkasEnum.create(PaymentType.class, text);
    }
}
