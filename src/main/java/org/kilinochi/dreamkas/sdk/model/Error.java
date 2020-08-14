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
public class Error implements DreamkasSerializable {

    @NotNull
    private final @Valid Integer status;
    @NotNull
    private final @Valid String code;
    @NotNull
    private final @Valid String message;

    @JsonCreator
    public Error(@JsonProperty("status") Integer status,
                 @JsonProperty("code") String code,
                 @JsonProperty("message") String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @JsonProperty("status")
    public @NotNull Integer getStatus() {
        return status;
    }

    @JsonProperty("code")
    public @NotNull String getCode() {
        return code;
    }

    @JsonProperty("message")
    public @NotNull String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Error error = (Error) o;

        return new EqualsBuilder()
                .append(status, error.status)
                .append(code, error.code)
                .append(message, error.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(status)
                .append(code)
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("code", code)
                .append("message", message)
                .toString();
    }
}
