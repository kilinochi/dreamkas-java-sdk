package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.util.List;

/**
 * @author arman.shamenov
 */
public class EncashmentsList implements DreamkasSerializable {

    @NotNull
    private final @Valid QueryResponse queryResponse;
    @NotNull
    private final List<@Valid Encashment> data;

    public EncashmentsList(@NotNull @JsonProperty("query") QueryResponse queryResponse,
                           @NotNull @JsonProperty("data") List<Encashment> data) {
        this.queryResponse = queryResponse;
        this.data = data;
    }

    @JsonProperty("query")
    public @NotNull List<Encashment> getData() {
        return data;
    }

    @JsonProperty("data")
    public @NotNull QueryResponse getQueryResponse() {
        return queryResponse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("queryResponse", queryResponse)
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

        EncashmentsList that = (EncashmentsList) o;

        return new EqualsBuilder()
                .append(queryResponse, that.queryResponse)
                .append(data, that.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(queryResponse)
                .append(data)
                .toHashCode();
    }
}
