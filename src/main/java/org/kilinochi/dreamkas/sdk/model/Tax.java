package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.Nullable;

/**
 * @author arman.shamenov
 */
public enum Tax implements DreamkasEnum {

    /**
     * 0% НДС (Версия API 1)
     */
    ZERO_TAX_V1("zero_tax"),
    /**
     * 10% НДС (Версия API 1)
     */
    TEN_TAX_V1("ten_tax"),
    /**
     * 18% НДС (Версия API 1)
     */
    EIGHTEEN_TAX_V1("eighteen_tax"),
    /**
     * 20% НДС (Версия API 1)
     */
    TWENTY_TAX_V1("twenty_tax"),
    /**
     * 10% / 110% НДС (Версия API 1)
     */
    ONE_HUNDRED_TEN_V1("one_hundred_ten"),
    /**
     * 20% / 120% НДС (Версия API 1)
     */
    ONE_HUNDRED_TWENTY_V1("one_hundred_twenty"),
    /**
     * смешанный НДС (Версия API 1)
     */
    MIXED_V1("mixed"),


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
    NDS_MIXED("NDS_MIXED"),

    /**
     * Null
     */
    NULL("NULL");

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

    public static Tax create(@Nullable Integer count) {
        if (count == null) {
            return NULL;
        }

        switch (count) {
            case -1: {
                return MIXED_V1;
            }
            case 0: {
                return ZERO_TAX_V1;
            }
            case 10: {
                return TEN_TAX_V1;
            }
            case 18: {
                return EIGHTEEN_TAX_V1;
            }
            case 20: {
                return TWENTY_TAX_V1;
            }
            case 110: {
                return ONE_HUNDRED_TEN_V1;
            }
            case 120: {
                return ONE_HUNDRED_TWENTY_V1;
            }
            default: {
                return NULL;
            }
        }
    }
}
