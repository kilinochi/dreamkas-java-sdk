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
public class Shop implements DreamkasSerializable {
    @NotNull
    private @Valid final Long id;
    @NotNull
    private @Valid final Long sort;
    @NotNull
    private @Valid final String name;

    @JsonCreator
    public Shop(
            @NotNull @JsonProperty("id") Long id,
            @NotNull @JsonProperty("sort") Long sort,
            @NotNull @JsonProperty("name") String name) {
        this.id = id;
        this.sort = sort;
        this.name = name;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
    }

    @JsonProperty("id")
    public @NotNull Long getId() {
        return id;
    }

    @JsonProperty("sort")
    public @NotNull Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("sort", sort)
                .append("name", name)
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

        Shop shop = (Shop) o;

        return new EqualsBuilder()
                .append(id, shop.id)
                .append(sort, shop.sort)
                .append(name, shop.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(sort)
                .append(name)
                .toHashCode();
    }
}
