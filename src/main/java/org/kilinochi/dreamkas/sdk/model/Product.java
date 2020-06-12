package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class Product implements DreamkasSerializable {

    @NotNull
    private @Valid final UUID id;
    @NotNull
    private @Valid final String name;
    @NotNull
    private @Valid final ProductType type;
    @NotNull
    private @Valid final Long departmentId;
    @NotNull
    private @Valid final Long quantity;
    @NotNull
    private @Valid final List<Price> prices;
    @NotNull
    private @Valid final Boolean isMarked;
    @Nullable
    private final Meta meta;
    @NotNull
    private @Valid final List<String> barcodes;
    @NotNull
    private @Valid final Tax tax;
    @NotNull
    private @Valid final LocalDateTime createdAt;
    @NotNull
    private @Valid final LocalDateTime updatedAt;

    @JsonCreator
    public Product(
            @NotNull @JsonProperty("id") UUID id,
            @NotNull @JsonProperty("name") String name,
            @NotNull @JsonProperty("type") ProductType type,
            @NotNull @JsonProperty("departmentId") Long departmentId,
            @NotNull @JsonProperty("quantity") Long quantity,
            @NotNull @JsonProperty("prices") List<Price> prices,
            @NotNull @JsonProperty("isMarked") Boolean isMarked,
            @Nullable @JsonProperty("meta") Meta meta,
            @NotNull @JsonProperty("barcodes") @Valid List<String> barcodes,
            @NotNull @JsonProperty("tax") @Valid Tax tax,
            @NotNull @JsonProperty("createdAt") @Valid LocalDateTime createdAt,
            @NotNull @JsonProperty("updatedAt") @Valid LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.departmentId = departmentId;
        this.quantity = quantity;
        this.prices = prices;
        this.isMarked = isMarked;
        this.meta = meta;
        this.barcodes = barcodes;
        this.tax = tax;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @NotNull
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @NotNull
    @JsonProperty("departmentId")
    public Long getDepartmentId() {
        return departmentId;
    }

    @NotNull
    @JsonProperty("prices")
    public List<Price> getPrices() {
        return prices;
    }

    @NotNull
    @JsonProperty("quantity")
    public Long getQuantity() {
        return quantity;
    }

    @NotNull
    @JsonProperty("type")
    public ProductType getType() {
        return type;
    }

    @NotNull
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @NotNull
    @JsonProperty("isMarked")
    public Boolean isMarked() {
        return isMarked;
    }

    @NotNull
    @JsonProperty("barcodes")
    public List<String> getBarcodes() {
        return barcodes;
    }

    @Nullable
    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @NotNull
    @JsonProperty("tax")
    public Tax getTax() {
        return tax;
    }

    @NotNull
    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @NotNull
    @JsonProperty("updatedAt")
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("type", type)
                .append("departmentId", departmentId)
                .append("quantity", quantity)
                .append("prices", prices)
                .append("isMarked", isMarked)
                .append("meta", meta)
                .append("barcodes", barcodes)
                .append("tax", tax)
                .append("createdAt", createdAt)
                .append("updatedAt", updatedAt)
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

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(id, product.id)
                .append(name, product.name)
                .append(type, product.type)
                .append(departmentId, product.departmentId)
                .append(quantity, product.quantity)
                .append(prices, product.prices)
                .append(isMarked, product.isMarked)
                .append(meta, product.meta)
                .append(barcodes, product.barcodes)
                .append(tax, product.tax)
                .append(createdAt, product.createdAt)
                .append(updatedAt, product.updatedAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(type)
                .append(departmentId)
                .append(quantity)
                .append(prices)
                .append(isMarked)
                .append(meta)
                .append(barcodes)
                .append(tax)
                .append(createdAt)
                .append(updatedAt)
                .toHashCode();
    }
}
