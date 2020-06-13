package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author arman.shamenov
 */
public class Receipt implements DreamkasSerializable {
    @NotNull
    private final @Valid Long id;
    @NotNull
    private final @Valid ReceiptType type;
    @NotNull
    private final @Valid Integer amount;
    @NotNull
    private final @Valid Integer discount;
    @NotNull
    private final @Valid Long deviceId;
    @NotNull
    private final @Valid Long shopId;
    @NotNull
    private final @Valid String operationId;
    @NotNull
    private final @Valid Long shiftId;
    @NotNull
    private final @Valid Long number;
    @NotNull
    private final @Valid LocalDateTime localDate;
    @NotNull
    private final @Valid LocalDateTime date;
    @NotNull
    private final List<@Valid ReceiptPayment> payments;
    @NotNull
    private final List<@Valid ReceiptPosition> positions;
    @NotNull
    private final @Valid Cashier cashier;
    @NotNull
    private final @Valid String checkURL;
    @NotNull
    private final @Valid String fiscalDocumentNumber;
    @NotNull
    private final @Valid String fiscalDocumentSign;
    @NotNull
    private final @Valid String fnNumber;
    @NotNull
    private final @Valid String registryNumber;

    @JsonCreator
    public Receipt(@NotNull @JsonProperty("id") Long id,
                   @NotNull @JsonProperty("type") ReceiptType type,
                   @NotNull @JsonProperty("amount") Integer amount,
                   @NotNull @JsonProperty("discount") Integer discount,
                   @NotNull @JsonProperty("deviceId") Long deviceId,
                   @NotNull @JsonProperty("shopId") Long shopId,
                   @NotNull @JsonProperty("operationId") String operationId,
                   @NotNull @JsonProperty("shiftId") Long shiftId,
                   @NotNull @JsonProperty("number") Long number,
                   @NotNull @JsonProperty("localDate") LocalDateTime localDate,
                   @NotNull @JsonProperty("date") LocalDateTime date,
                   @NotNull @JsonProperty("payments") List<ReceiptPayment> payments,
                   @NotNull @JsonProperty("positions") List<ReceiptPosition> positions,
                   @NotNull @JsonProperty("cashier") Cashier cashier,
                   @NotNull @JsonProperty("checkURL") String checkURL,
                   @NotNull @JsonProperty("fiscalDocumentNumber") String fiscalDocumentNumber,
                   @NotNull @JsonProperty("fiscalDocumentSign") String fiscalDocumentSign,
                   @NotNull @JsonProperty("fnNumber") String fnNumber,
                   @NotNull @JsonProperty("registryNumber") String registryNumber) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.discount = discount;
        this.deviceId = deviceId;
        this.shopId = shopId;
        this.operationId = operationId;
        this.shiftId = shiftId;
        this.number = number;
        this.localDate = localDate;
        this.date = date;
        this.payments = payments;
        this.positions = positions;
        this.cashier = cashier;
        this.checkURL = checkURL;
        this.fiscalDocumentNumber = fiscalDocumentNumber;
        this.fiscalDocumentSign = fiscalDocumentSign;
        this.fnNumber = fnNumber;
        this.registryNumber = registryNumber;
    }

    @JsonProperty("id")
    public @NotNull Long getId() {
        return id;
    }

    @JsonProperty("type")
    public @NotNull ReceiptType getType() {
        return type;
    }

    @JsonProperty("amount")
    public @NotNull Integer getAmount() {
        return amount;
    }

    @JsonProperty("discount")
    public @NotNull Integer getDiscount() {
        return discount;
    }

    @JsonProperty("deviceId")
    public @NotNull Long getDeviceId() {
        return deviceId;
    }

    @JsonProperty("shopId")
    public @NotNull Long getShopId() {
        return shopId;
    }

    @JsonProperty("operationId")
    public @NotNull String getOperationId() {
        return operationId;
    }

    @JsonProperty("shiftId")
    public @NotNull Long getShiftId() {
        return shiftId;
    }

    @JsonProperty("number")
    public @NotNull Long getNumber() {
        return number;
    }

    @JsonProperty("localDate")
    public @NotNull LocalDateTime getLocalDate() {
        return localDate;
    }

    @JsonProperty("date")
    public @NotNull LocalDateTime getDate() {
        return date;
    }

    @JsonProperty("payments")
    public @NotNull List<ReceiptPayment> getPayments() {
        return payments;
    }

    @JsonProperty("positions")
    public @NotNull List<ReceiptPosition> getPositions() {
        return positions;
    }

    @JsonProperty("cashier")
    public @NotNull Cashier getCashier() {
        return cashier;
    }

    @JsonProperty("checkURL")
    public @NotNull String getCheckURL() {
        return checkURL;
    }

    @JsonProperty("fiscalDocumentNumber")
    public @NotNull String getFiscalDocumentNumber() {
        return fiscalDocumentNumber;
    }

    @JsonProperty("fiscalDocumentSign")
    public @NotNull String getFiscalDocumentSign() {
        return fiscalDocumentSign;
    }

    @JsonProperty("fnNumber")
    public @NotNull String getFnNumber() {
        return fnNumber;
    }

    @JsonProperty("registryNumber")
    public @NotNull String getRegistryNumber() {
        return registryNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("type", type)
                .append("amount", amount)
                .append("discount", discount)
                .append("deviceId", deviceId)
                .append("shopId", shopId)
                .append("operationId", operationId)
                .append("shiftId", shiftId)
                .append("number", number)
                .append("localDate", localDate)
                .append("date", date)
                .append("payments", payments)
                .append("positions", positions)
                .append("cashier", cashier)
                .append("checkURL", checkURL)
                .append("fiscalDocumentNumber", fiscalDocumentNumber)
                .append("fiscalDocumentSign", fiscalDocumentSign)
                .append("fnNumber", fnNumber)
                .append("registryNumber", registryNumber)
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

        Receipt that = (Receipt) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(type, that.type)
                .append(amount, that.amount)
                .append(discount, that.discount)
                .append(deviceId, that.deviceId)
                .append(shopId, that.shopId)
                .append(operationId, that.operationId)
                .append(shiftId, that.shiftId)
                .append(number, that.number)
                .append(localDate, that.localDate)
                .append(date, that.date)
                .append(payments, that.payments)
                .append(positions, that.positions)
                .append(cashier, that.cashier)
                .append(checkURL, that.checkURL)
                .append(fiscalDocumentNumber, that.fiscalDocumentNumber)
                .append(fiscalDocumentSign, that.fiscalDocumentSign)
                .append(fnNumber, that.fnNumber)
                .append(registryNumber, that.registryNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(type)
                .append(amount)
                .append(discount)
                .append(deviceId)
                .append(shopId)
                .append(operationId)
                .append(shiftId)
                .append(number)
                .append(localDate)
                .append(date)
                .append(payments)
                .append(positions)
                .append(cashier)
                .append(checkURL)
                .append(fiscalDocumentNumber)
                .append(fiscalDocumentSign)
                .append(fnNumber)
                .append(registryNumber)
                .toHashCode();
    }
}
