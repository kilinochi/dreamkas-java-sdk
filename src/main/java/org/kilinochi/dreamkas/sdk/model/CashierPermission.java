package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author arman.shamenov
 */
public enum  CashierPermission implements DreamkasEnum {
    /**
     * Продажа
     */
    SALE("sale"),
    /**
     * Возврат
     */
    REFUND("refund"),
    /**
     * Изменение
     */
    SHIFT("shift"),
    /**
     * ЕГАИС
     */
    EGAIS_ACCEPTANCE("egais_acceptance"),
    /**
     * Настройки
     */
    SETTINGS("settings"),
    /**
     * Изменение цены
     */
    PRICE_CHANGE("price_change"),
    /**
     * Уменьшение количества
     */
    QUANTITY_DECREASE("quantity_decrease"),
    /**
     * Заказ-наряд
     */
    CLEAR_PURCHASE("cleat_purchase"),
    /**
     * Изменение НДС
     */
    TAX_SYSTEM_CHANGE("tax_system_change"),
    /**
     * Удаление прихода
     */
    DEFER_DELETE("defer_delete");

    private final String value;

    CashierPermission(String value) {
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
    public static CashierPermission create(String text) {
        return DreamkasEnum.create(CashierPermission.class, text);
    }
}
