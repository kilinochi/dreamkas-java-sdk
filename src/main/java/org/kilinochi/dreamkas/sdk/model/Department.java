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
public class Department implements DreamkasSerializable {
    @NotNull
    private final @Valid String name;
    @NotNull
    private final @Valid Tax tax;
    @NotNull
    private final @Valid Long id;

    @JsonCreator
    public Department(@NotNull @JsonProperty("name") String name,
                      @NotNull @JsonProperty("tax") Tax tax,
                      @NotNull @JsonProperty("id") Long id) {
        this.name = name;
        this.tax = tax;
        this.id = id;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
    }

    @JsonProperty("id")
    public @NotNull Long getId() {
        return id;
    }

    @JsonProperty("tax")
    public @NotNull Tax getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("tax", tax)
                .append("id", id)
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

        Department that = (Department) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(tax, that.tax)
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(tax)
                .append(id)
                .toHashCode();
    }
}
