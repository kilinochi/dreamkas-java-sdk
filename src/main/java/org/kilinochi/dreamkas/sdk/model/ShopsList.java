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
public class ShopsList implements DreamkasSerializable {
    @NotNull
    private final List<@Valid Shop> shops;

    @JsonCreator
    public ShopsList(@NotNull @JsonProperty("shops") List<Shop> shops) {
        this.shops = shops;
    }

    @NotNull
    @JsonProperty("shops")
    public List<Shop> getShops() {
        return shops;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("shops", shops)
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

        ShopsList shopsList = (ShopsList) o;

        return new EqualsBuilder()
                .append(shops, shopsList.shops)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(shops)
                .toHashCode();
    }
}
