package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;

/**
 * @author arman.shamenov
 */
public class ReceiptPayment implements DreamkasSerializable {
    @NotNull
    private final @Valid PaymentType type;
    @NotNull
    private final @Valid Long amount;

    @JsonCreator
    public ReceiptPayment(@NotNull @JsonProperty("type") PaymentType type,
                          @NotNull @JsonProperty("amount") Long amount) {
        this.type = type;
        this.amount = amount;
    }

    @JsonProperty("type")
    public @NotNull Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public @NotNull PaymentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReceiptPayment that = (ReceiptPayment) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(amount, that.amount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("amount", amount)
                .toString();
    }
}
