package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;

/**
 * @author arman.shamenov
 */
public class NewShopBody implements DreamkasSerializable {
    @Nullable
    private final @Valid String name;
    @Nullable
    private final @Valid Long sort;

    @JsonCreator
    public NewShopBody(@Nullable @JsonProperty("name") String name,
                       @Nullable @JsonProperty("sort") Long sort) {
        this.name = name;
        this.sort = sort;
    }

    @JsonProperty("name")
    public @Nullable String getName() {
        return name;
    }

    @JsonProperty("sort")
    public @Nullable Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("sort", sort)
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

        NewShopBody that = (NewShopBody) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(sort, that.sort)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(sort)
                .toHashCode();
    }
}
