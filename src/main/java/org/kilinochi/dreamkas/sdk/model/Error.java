package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author arman.shamenov
 */
public class Error implements DreamkasSerializable {

    private @Valid String error;
    @NotNull
    private final @Valid String code;
    @NotNull
    private final @Valid String message;

    @JsonCreator
    public Error(@JsonProperty("code") String code, @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Error
     * @return error
     **/
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    /**
     * Error code
     * @return code
     **/
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * Human-readable description
     * @return message
     **/
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("error", error)
                .append("code", code)
                .append("message", message)
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

        Error error1 = (Error) o;

        return new EqualsBuilder()
                .append(error, error1.error)
                .append(code, error1.code)
                .append(message, error1.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(error)
                .append(code)
                .append(message)
                .toHashCode();
    }
}
