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
public class Price implements DreamkasSerializable {
    @NotNull
    private @Valid final Long deviceId;
    @NotNull
    private @Valid final Long value;

    @JsonCreator
    public Price(
            @NotNull @JsonProperty("deviceId") Long deviceId,
            @NotNull @JsonProperty("value") Long value) {
        this.deviceId = deviceId;
        this.value = value;
    }

    @NotNull
    @JsonProperty("deviceId")
    public Long getDeviceId() {
        return deviceId;
    }

    @NotNull
    @JsonProperty("value")
    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("deviceId", deviceId)
                .append("value", value)
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

        Price price = (Price) o;

        return new EqualsBuilder()
                .append(deviceId, price.deviceId)
                .append(value, price.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(deviceId)
                .append(value)
                .toHashCode();
    }
}
