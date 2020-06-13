package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum TaxV2 implements DreamkasEnum {

    /**
     * Не облагается НДС
     */
    NDS_NO_TAX("NDS_NO_TAX"),
    /**
     * НДС 0%
     */
    NDS_0("NDS_0"),
    /**
     * НДС 10%
     */
    NDS_10("NDS_10"),
    /**
     * НДС 20%
     */
    NDS_20("NDS_20"),
    /**
     * НДС 10 / 110%
     */
    NDS_10_CALCULATED("NDS_10_CALCULATED"),
    /**
     * НДС 20 / 120%
     */
    NDS_20_CALCULATED("NDS_20_CALCULATED"),
    /**
     * Смешанный НДС в категории
     */
    NDS_MIXED("NDS_MIXED");

    private final String value;

    TaxV2(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaxV2 create(String text) {
        return DreamkasEnum.create(TaxV2.class, text);
    }
}
