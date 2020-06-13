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
 */
public class QueryResponse implements DreamkasSerializable {
    @NotNull
    private final @Valid LocalDateTime from;
    @NotNull
    private final @Valid LocalDateTime to;
    @NotNull
    private final @Valid Long limit;
    @NotNull
    private final @Valid Long offset;

    @JsonCreator
    public QueryResponse(@NotNull @JsonProperty("from") LocalDateTime from,
                         @NotNull @JsonProperty("to") LocalDateTime to,
                         @NotNull @JsonProperty("limit") Long limit,
                         @NotNull @JsonProperty("offset") Long offset) {
        this.from = from;
        this.to = to;
        this.limit = limit;
        this.offset = offset;
    }

    @JsonProperty("from")
    public @NotNull LocalDateTime getFrom() {
        return from;
    }

    @JsonProperty("to")
    public @NotNull LocalDateTime getTo() {
        return to;
    }

    @JsonProperty("limit")
    public @NotNull Long getLimit() {
        return limit;
    }

    @JsonProperty("offset")
    public @NotNull Long getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("from", from)
                .append("to", to)
                .append("limit", limit)
                .append("offset", offset)
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

        QueryResponse that = (QueryResponse) o;

        return new EqualsBuilder()
                .append(from, that.from)
                .append(to, that.to)
                .append(limit, that.limit)
                .append(offset, that.offset)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(from)
                .append(to)
                .append(limit)
                .append(offset)
                .toHashCode();
    }
}
