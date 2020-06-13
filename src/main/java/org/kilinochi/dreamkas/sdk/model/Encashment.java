package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author arman.shamenov
 * Внесение / изъятие денег из кассы
 */
public class Encashment implements DreamkasSerializable {
    @NotNull
    private @Valid final Long deviceId;
    @NotNull
    private @Valid final Long shopId;
    @NotNull
    private @Valid final EncashmentType type;
    @NotNull
    private @Valid final String shiftId;
    @NotNull
    private @Valid final Cashier cashier;
    @NotNull
    private @Valid final Long sum;
    @NotNull
    private @Valid final LocalDateTime localDate;
    @NotNull
    private @Valid final LocalDateTime date;

    @JsonCreator
    public Encashment(@NotNull @JsonProperty("deviceId") Long deviceId,
                      @NotNull @JsonProperty("shopId") Long shopId,
                      @NotNull @JsonProperty("type") EncashmentType type,
                      @NotNull @JsonProperty("shiftId") String shiftId,
                      @NotNull @JsonProperty("cashier") Cashier cashier,
                      @NotNull @JsonProperty("sum") Long sum,
                      @NotNull @JsonProperty("localDate") LocalDateTime localDate,
                      @NotNull @JsonProperty("date") LocalDateTime date) {
        this.deviceId = deviceId;
        this.shopId = shopId;
        this.type = type;
        this.shiftId = shiftId;
        this.cashier = cashier;
        this.sum = sum;
        this.localDate = localDate;
        this.date = date;
    }

    @JsonProperty("deviceId")
    public @NotNull Long getDeviceId() {
        return deviceId;
    }

    @JsonProperty("shopId")
    public @NotNull Long getShopId() {
        return shopId;
    }

    @JsonProperty("type")
    public @NotNull EncashmentType getType() {
        return type;
    }

    @JsonProperty("shiftId")
    public @NotNull String getShiftId() {
        return shiftId;
    }

    @JsonProperty("cashier")
    public @NotNull Cashier getCashier() {
        return cashier;
    }

    @JsonProperty("sum")
    public @NotNull Long getSum() {
        return sum;
    }

    @JsonProperty("localDate")
    public @NotNull LocalDateTime getLocalDate() {
        return localDate;
    }

    @JsonProperty("date")
    public @NotNull LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("deviceId", deviceId)
                .append("shopId", shopId)
                .append("type", type)
                .append("shiftId", shiftId)
                .append("cashier", cashier)
                .append("sum", sum)
                .append("localDate", localDate)
                .append("date", date)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Encashment that = (Encashment) o;

        return new EqualsBuilder()
                .append(deviceId, that.deviceId)
                .append(shopId, that.shopId)
                .append(type, that.type)
                .append(shiftId, that.shiftId)
                .append(cashier, that.cashier)
                .append(sum, that.sum)
                .append(localDate, that.localDate)
                .append(date, that.date)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(deviceId)
                .append(shopId)
                .append(type)
                .append(shiftId)
                .append(cashier)
                .append(sum)
                .append(localDate)
                .append(date)
                .toHashCode();
    }
}
