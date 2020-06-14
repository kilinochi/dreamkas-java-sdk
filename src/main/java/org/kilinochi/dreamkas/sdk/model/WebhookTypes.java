package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;

public class WebhookTypes implements DreamkasSerializable {
    @NotNull
    private final @Valid Boolean products;
    @NotNull
    private final @Valid Boolean devices;
    @NotNull
    private final @Valid Boolean encashments;
    @NotNull
    private final @Valid Boolean receipts;
    @NotNull
    private final @Valid Boolean shifts;
    @NotNull
    private final @Valid Boolean operations;
    @NotNull
    private final @Valid Boolean deviceRegistrations;

    @JsonCreator
    public WebhookTypes(@NotNull @JsonProperty("products") Boolean products,
                        @NotNull @JsonProperty("devices") Boolean devices,
                        @NotNull @JsonProperty("encashments") Boolean encashments,
                        @NotNull @JsonProperty("receipts") Boolean receipts,
                        @NotNull @JsonProperty("shifts") Boolean shifts,
                        @NotNull @JsonProperty("operations") Boolean operations,
                        @NotNull @JsonProperty("deviceRegistrations") Boolean deviceRegistrations) {
        this.products = products;
        this.devices = devices;
        this.encashments = encashments;
        this.receipts = receipts;
        this.shifts = shifts;
        this.operations = operations;
        this.deviceRegistrations = deviceRegistrations;
    }

    @NotNull
    @JsonProperty("products")
    public Boolean isProducts() {
        return products;
    }

    @NotNull
    @JsonProperty("devices")
    public Boolean isDevices() {
        return devices;
    }

    @NotNull
    @JsonProperty("encashments")
    public Boolean isEncashments() {
        return encashments;
    }

    @NotNull
    @JsonProperty("receipts")
    public Boolean isReceipts() {
        return receipts;
    }

    @NotNull
    @JsonProperty("shifts")
    public Boolean isShifts() {
        return shifts;
    }

    @NotNull
    @JsonProperty("operations")
    public Boolean isOperations() {
        return operations;
    }

    @NotNull
    @JsonProperty("deviceRegistrations")
    public Boolean isDeviceRegistrations() {
        return deviceRegistrations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("products", products)
                .append("devices", devices)
                .append("encashments", encashments)
                .append("receipts", receipts)
                .append("shifts", shifts)
                .append("operations", operations)
                .append("deviceRegistrations", deviceRegistrations)
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

        WebhookTypes that = (WebhookTypes) o;

        return new EqualsBuilder()
                .append(products, that.products)
                .append(devices, that.devices)
                .append(encashments, that.encashments)
                .append(receipts, that.receipts)
                .append(shifts, that.shifts)
                .append(operations, that.operations)
                .append(deviceRegistrations, that.deviceRegistrations)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(products)
                .append(devices)
                .append(encashments)
                .append(receipts)
                .append(shifts)
                .append(operations)
                .append(deviceRegistrations)
                .toHashCode();
    }
}
