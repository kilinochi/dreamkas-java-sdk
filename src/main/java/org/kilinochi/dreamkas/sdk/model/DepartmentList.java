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
public class DepartmentList implements DreamkasSerializable {
    @NotNull
    private final List<@Valid Department> departments;

    @JsonCreator
    public DepartmentList(@NotNull @JsonProperty("departments") List<Department> departments) {
        this.departments = departments;
    }

    @NotNull
    @JsonProperty("departments")
    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("departments", departments)
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

        DepartmentList that = (DepartmentList) o;

        return new EqualsBuilder()
                .append(departments, that.departments)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(departments)
                .toHashCode();
    }
}
