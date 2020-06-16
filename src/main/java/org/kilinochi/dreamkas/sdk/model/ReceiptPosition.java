package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class ReceiptPosition implements DreamkasSerializable {
    @NotNull
    private final @Valid UUID id;
    @NotNull
    private final @Valid String name;
    @NotNull
    private final @Valid ProductType type;
    @NotNull
    private final @Valid Long quantity;
    @NotNull
    private final @Valid Long price;
    @NotNull
    private final @Valid Long discount;
    @NotNull
    private final @Valid String barcode;
    @NotNull
    private final @Valid String exciseBarcode;
    @NotNull
    private final @Valid String vendorCode;
    @Nullable
    private final Tax tax;
    @NotNull
    private final @Valid Long departmentId;

    @JsonCreator
    public ReceiptPosition(@NotNull @JsonProperty("id") UUID id,
                           @NotNull @JsonProperty("name") String name,
                           @NotNull @JsonProperty("type") ProductType type,
                           @NotNull @JsonProperty("quantity") Long quantity,
                           @NotNull @JsonProperty("price") Long price,
                           @NotNull @JsonProperty("discount") Long discount,
                           @NotNull @JsonProperty("barcode") String barcode,
                           @NotNull @JsonProperty("exciseBarcode") String exciseBarcode,
                           @NotNull @JsonProperty("vendorCode") String vendorCode,
                           @Nullable @JsonProperty("tax") Tax tax,
                           @NotNull @JsonProperty("departmentId") Long departmentId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.barcode = barcode;
        this.exciseBarcode = exciseBarcode;
        this.vendorCode = vendorCode;
        this.tax = tax;
        this.departmentId = departmentId;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
    }

    @JsonProperty("id")
    public @NotNull UUID getId() {
        return id;
    }

    @JsonProperty("departmentId")
    public @NotNull Long getDepartmentId() {
        return departmentId;
    }

    @JsonProperty("discount")
    public @NotNull Long getDiscount() {
        return discount;
    }

    @JsonProperty("price")
    public @NotNull Long getPrice() {
        return price;
    }

    @JsonProperty("quantity")
    public @NotNull Long getQuantity() {
        return quantity;
    }

    @JsonProperty("type")
    public @NotNull ProductType getType() {
        return type;
    }

    @JsonProperty("barcode")
    public @NotNull String getBarcode() {
        return barcode;
    }

    @JsonProperty("exciseBarcode")
    public @NotNull String getExciseBarcode() {
        return exciseBarcode;
    }

    @JsonProperty("vendorCode")
    public @NotNull String getVendorCode() {
        return vendorCode;
    }

    @JsonProperty("tax")
    public @Nullable Tax getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("type", type)
                .append("quantity", quantity)
                .append("price", price)
                .append("discount", discount)
                .append("barcode", barcode)
                .append("exciseBarcode", exciseBarcode)
                .append("vendorCode", vendorCode)
                .append("tax", tax)
                .append("departmentId", departmentId)
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

        ReceiptPosition that = (ReceiptPosition) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(type, that.type)
                .append(quantity, that.quantity)
                .append(price, that.price)
                .append(discount, that.discount)
                .append(barcode, that.barcode)
                .append(exciseBarcode, that.exciseBarcode)
                .append(vendorCode, that.vendorCode)
                .append(tax, that.tax)
                .append(departmentId, that.departmentId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(type)
                .append(quantity)
                .append(price)
                .append(discount)
                .append(barcode)
                .append(exciseBarcode)
                .append(vendorCode)
                .append(tax)
                .append(departmentId)
                .toHashCode();
    }
}
