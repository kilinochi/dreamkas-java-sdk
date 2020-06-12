package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  ProductTypeV2 implements DreamkasEnum {
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

    ProductTypeV2(String value) {
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
    public static ProductTypeV2 create(String text) {
        return DreamkasEnum.create(ProductTypeV2.class, text);
    }
}
