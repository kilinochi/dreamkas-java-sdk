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
public class ProductList implements DreamkasCollection<Product> {
    @NotNull
    private final List<@Valid Product> products;

    @JsonCreator
    public ProductList(@NotNull @JsonProperty("products") List<@Valid Product> products) {
        this.products = products;
    }

    @JsonProperty("products")
    public @NotNull List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("products", products)
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

        ProductList that = (ProductList) o;

        return new EqualsBuilder()
                .append(products, that.products)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(products)
                .toHashCode();
    }

    @Override
    public Class<Product> getType() {
        return Product.class;
    }
}
