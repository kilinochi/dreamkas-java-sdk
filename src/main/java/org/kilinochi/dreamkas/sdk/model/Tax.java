package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.Nullable;

/**
 * НДС
 *
 * @author arman.shamenov
 */
public enum Tax implements DreamkasEnum {
    /**
     * НДС 0%
     */
    ZERO("zero"),

    /**
     * НДС 10%
     */
    TEN("ten"),

    /**
     * НДС 20%
     */
    TWENTY("twenty"),

    /**
     * НДС 110%
     */
    ONE_HUNDRED_AND_TEN("one_hundred_and_ten"),

    /**
     * НДС 120%
     */
    ONE_HUNDRED_AND_TWENTY("one_hundred_and_twenty"),

    /**
     * null
     */
    NULL("null")
    ;

    private final String value;

    Tax(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Tax create(@Nullable Integer count) {

        if (count == null) {
            return NULL;
        }

        String value;
        switch (count) {
            case 0: {
                value = "zero";
                break;
            }
            case 10: {
                value = "ten";
                break;
            }
            case 20: {
                value = "twenty";
                break;
            }
            case 110: {
                value = "one_hundred_and_ten";
                break;
            }
            case 120: {
                value = "one_hundred_and_twenty";
                break;
            }
            default: {
                return NULL;
            }
        }

        return DreamkasEnum.create(Tax.class, value);
    }
}
