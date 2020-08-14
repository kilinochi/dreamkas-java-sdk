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
    @Nullable
    private final String hash;
    @NotNull
    private @Valid final ProductType type;
    @NotNull
    private @Valid final Long quantity;
    @Nullable
    private final Meta meta;
    @NotNull
    private @Valid final LocalDateTime createdAt;
    @NotNull
    private @Valid final LocalDateTime updatedAt;
    @Nullable
    private final String imageUrl;
    @Nullable
    private @Valid final Long departmentId;
    @NotNull
    private @Valid final Long price;
    @NotNull
    private @Valid final String unit;
    @NotNull
    private @Valid final Boolean isMarked;
    @Nullable
    private final Tax tax;
    @NotNull
    private @Valid final List<Price> prices;
    @NotNull
    private final List<@Valid String> barcodes;
    @Nullable
    private @Valid final Department department;

    @JsonCreator
    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("hash") String hash,
                   @JsonProperty("type") ProductType type,
                   @JsonProperty("quantity") Long quantity,
                   @JsonProperty("meta") Meta meta,
                   @JsonProperty("createdAt") LocalDateTime createdAt,
                   @JsonProperty("updatedAt") LocalDateTime updatedAt,
                   @JsonProperty("imageUrl") String imageUrl,
                   @JsonProperty("departmentId") Long departmentId,
                   @JsonProperty("price") Long price,
                   @JsonProperty("unit") String unit,
                   @JsonProperty("isMarked") Boolean isMarked,
                   @JsonProperty("tax") Tax tax,
                   @JsonProperty("prices") List<Price> prices,
                   @JsonProperty("barcodes") List<@Valid String> barcodes,
                   @JsonProperty("department") Department department) {
        this.id = id;
        this.name = name;
        this.hash = hash;
        this.type = type;
        this.quantity = quantity;
        this.meta = meta;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imageUrl = imageUrl;
        this.departmentId = departmentId;
        this.price = price;
        this.unit = unit;
        this.isMarked = isMarked;
        this.tax = tax;
        this.prices = prices;
        this.barcodes = barcodes;
        this.department = department;
    }

    @NotNull
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Nullable
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

    @Nullable
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

    @JsonProperty("hash")
    public @Nullable String getHash() {
        return hash;
    }

    @JsonProperty("imageUrl")
    public @Nullable String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("price")
    public @NotNull Long getPrice() {
        return price;
    }

    @JsonProperty("unit")
    public @NotNull String getUnit() {
        return unit;
    }

    @JsonProperty("department")
    public @Nullable Department getDepartment() {
        return department;
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
                .append(hash, product.hash)
                .append(type, product.type)
                .append(quantity, product.quantity)
                .append(meta, product.meta)
                .append(createdAt, product.createdAt)
                .append(updatedAt, product.updatedAt)
                .append(imageUrl, product.imageUrl)
                .append(departmentId, product.departmentId)
                .append(price, product.price)
                .append(tax, product.tax)
                .append(unit, product.unit)
                .append(isMarked, product.isMarked)
                .append(department, product.department)
                .append(prices, product.prices)
                .append(barcodes, product.barcodes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(hash)
                .append(type)
                .append(quantity)
                .append(meta)
                .append(createdAt)
                .append(updatedAt)
                .append(imageUrl)
                .append(departmentId)
                .append(price)
                .append(tax)
                .append(unit)
                .append(isMarked)
                .append(department)
                .append(prices)
                .append(barcodes)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("hash", hash)
                .append("type", type)
                .append("quantity", quantity)
                .append("meta", meta)
                .append("createdAt", createdAt)
                .append("updatedAt", updatedAt)
                .append("imageUrl", imageUrl)
                .append("departmentId", departmentId)
                .append("price", price)
                .append("tax", tax)
                .append("unit", unit)
                .append("isMarked", isMarked)
                .append("department", department)
                .append("prices", prices)
                .append("barcodes", barcodes)
                .toString();
    }
}
