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
 */
public class DevicesList implements DreamkasSerializable {

    @NotNull
    private final List<@Valid Device> devices;

    @JsonCreator
    public DevicesList(@NotNull @JsonProperty("devices") List<Device> devices) {
        this.devices = devices;
    }

    @JsonProperty("devices")
    public @NotNull List<Device> getDevices() {
        return devices;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("devices", devices)
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

        DevicesList that = (DevicesList) o;

        return new EqualsBuilder()
                .append(devices, that.devices)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(devices)
                .toHashCode();
    }
}
