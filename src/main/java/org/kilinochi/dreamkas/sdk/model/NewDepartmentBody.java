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
public class NewDepartmentBody implements DreamkasSerializable {
    @NotNull
    private final @Valid String name;
    @NotNull
    private final @Valid Tax tax;

    @JsonCreator
    public NewDepartmentBody(@NotNull @JsonProperty("name") String name,
                             @NotNull @JsonProperty("tax") Tax tax) {
        this.name = name;
        this.tax = tax;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
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

        NewDepartmentBody that = (NewDepartmentBody) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(tax, that.tax)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(tax)
                .toHashCode();
    }
}
