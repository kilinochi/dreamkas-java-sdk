package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum Tax implements DreamkasEnum {

    /**
     * Не облагается НДС (Версия API 1)
     */
    NDS_NO_TAX_V1("NDS_NO_TAX_V1"),
    /**
     * 0% НДС (Версия API 1)
     */
    NDS_0_V1("NDS_0_V1"),
    /**
     * 10% НДС (Версия API 1)
     */
    NDS_10_V1("NDS_10_V1"),
    /**
     * 18% НДС (Версия API 1)
     */
    NDS_18_V1("NDS_18_V1"),
    /**
     * 20% НДС (Версия API 1)
     */
    NDS_20_V1("NDS_10_V1"),
    /**
     * 10% / 110% НДС (Версия API 1)
     */
    NDS_10_CALCULATED_V1("NDS_10_CALCULATED_V1"),
    /**
     * 20% / 120% НДС (Версия API 1)
     */
    NDS_20_CALCULATED_V1("NDS_10_CALCULATED_V1"),
    /**
     * Смешанный НДС в категории (Версия API 1)
     */
    NDS_MIXED_V1("NDS_MIXED_V1"),


    /**
     * Не облагается НДС (Версия API 2)
     */
    NDS_NO_TAX("NDS_NO_TAX"),
    /**
     * НДС 0% (Версия API 2)
     */
    NDS_0("NDS_0"),
    /**
     * НДС 10% (Версия API 2)
     */
    NDS_10("NDS_10"),
    /**
     * НДС 20% (Версия API 2)
     */
    NDS_20("NDS_20"),
    /**
     * НДС 10 / 110% (Версия API 2)
     */
    NDS_10_CALCULATED("NDS_10_CALCULATED"),
    /**
     * НДС 20 / 120% (Версия API 2)
     */
    NDS_20_CALCULATED("NDS_20_CALCULATED"),
    /**
     * Смешанный НДС в категории (Версия API 2)
     */
    NDS_MIXED("NDS_MIXED");

    private final String value;

    Tax(String value) {
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

    public static Tax create(String text) {
        return DreamkasEnum.create(Tax.class, text);
    }

    public static Tax create(Integer count) {

        switch (count) {
            case -1: {
                return NDS_MIXED_V1;
            }
            case 0: {
                return NDS_0_V1;
            }
            case 10: {
                return NDS_10_V1;
            }
            case 18: {
                return NDS_18_V1;
            }
            case 20: {
                return NDS_20_V1;
            }
            case 110: {
                return NDS_10_CALCULATED_V1;
            }
            case 120: {
                return NDS_20_CALCULATED_V1;
            }
            default: {
                return NDS_NO_TAX_V1;
            }
        }
    }
}
