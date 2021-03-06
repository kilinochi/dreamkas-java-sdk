package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class NewProductBody implements DreamkasSerializable {

    @Nullable
    private @Valid final UUID id;
    @Nullable
    private @Valid final String name;
    @NotNull
    private @Valid final ProductType type;
    @NotNull
    private @Valid final Long departmentId;
    @NotNull
    private @Valid final Long quantity;
    @NotNull
    private final List<@Valid Price> prices;
    @NotNull
    private @Valid final Boolean isMarked;
    @Nullable
    private final Meta meta;
    @NotNull
    private @Valid final List<String> barcodes;
    @Nullable
    private final Tax tax;

    @JsonCreator
    public NewProductBody(
            @Nullable @JsonProperty("id") UUID id,
            @Nullable @JsonProperty("name") String name,
            @NotNull @JsonProperty("type") ProductType type,
            @NotNull @JsonProperty("departmentId") Long departmentId,
            @NotNull @JsonProperty("quantity") Long quantity,
            @NotNull @JsonProperty("prices") List<Price> prices,
            @NotNull @JsonProperty("isMarked") Boolean isMarked,
            @Nullable @JsonProperty("meta") Meta meta,
            @NotNull @JsonProperty("barcodes") List<String> barcodes,
            @Nullable @JsonProperty("tax") Tax tax) {
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
    }

    @Nullable
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

    @Nullable
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

        NewProductBody product = (NewProductBody) o;

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
                .toHashCode();
    }
}
