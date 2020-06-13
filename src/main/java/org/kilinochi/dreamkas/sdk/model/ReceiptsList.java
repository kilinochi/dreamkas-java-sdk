package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.util.List;

/**
 * @author arman.shamenov
 * Чеки
 */
public class ReceiptsList implements DreamkasSerializable {

    @NotNull
    private final @Valid ReceiptQuery receiptQuery;
    @NotNull
    private final List<@Valid Receipt> data;

    @JsonCreator
    public ReceiptsList(@NotNull @JsonProperty("query") ReceiptQuery receiptQuery,
                        @NotNull @JsonProperty("data") List<Receipt> data) {
        this.receiptQuery = receiptQuery;
        this.data = data;
    }

    @JsonProperty("data")
    public @NotNull List<Receipt> getData() {
        return data;
    }

    @JsonProperty("query")
    public @NotNull ReceiptQuery getReceiptQuery() {
        return receiptQuery;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("receiptQuery", receiptQuery)
                .append("data", data)
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

        ReceiptsList receiptsList = (ReceiptsList) o;

        return new EqualsBuilder()
                .append(receiptQuery, receiptsList.receiptQuery)
                .append(data, receiptsList.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(receiptQuery)
                .append(data)
                .toHashCode();
    }
}
