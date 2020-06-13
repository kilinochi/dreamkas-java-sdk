package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum EncashmentType implements DreamkasEnum {
    /**
     * Внесение денег
     */
    MONEY_IN("money_in"),
    /**
     * Изъятие денег
     */
    MONEY_OUT("money_out");

    private final String value;

    EncashmentType(String value) {
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
    public static EncashmentType create(String text) {
        return DreamkasEnum.create(EncashmentType.class, text);
    }
}
