package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum ProductType implements DreamkasEnum {
    /**
     * штучный
     */
    COUNTABLE("countable"),
    /**
     * весовой
     */
    SCALABLE("scalable"),
    /**
     * алкоголь
     */
    ALCOHOL("alcohol"),
    /**
     * одежда
     */
    CLOTHES("clothes"),
    /**
     * обувь
     */
    SHOES("shoes"),
    /**
     * услуга
     */
    SERVICE("service"),
    /**
     * табак
     */
    TOBACCO("tobacco")
    ;

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String getValue() {
        return value.toUpperCase();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ProductType create(String text) {
        return DreamkasEnum.create(ProductType.class, text);
    }
}
