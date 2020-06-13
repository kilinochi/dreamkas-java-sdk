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
public class Device implements DreamkasSerializable {
    @NotNull
    private @Valid final String name;
    @NotNull
    private @Valid final Long groupId;
    @NotNull
    private @Valid final Long sort;
    @NotNull
    private @Valid final Long id;
    @NotNull
    private @Valid final Integer timezoneOffset;

    @JsonCreator
    public Device(@NotNull @JsonProperty("name") String name,
                  @NotNull @JsonProperty("groupId") Long groupId,
                  @NotNull @JsonProperty("sort") Long sort,
                  @NotNull @JsonProperty("id") Long id,
                  @NotNull @JsonProperty("timezoneOffset") Integer timezoneOffset) {
        this.name = name;
        this.groupId = groupId;
        this.sort = sort;
        this.id = id;
        this.timezoneOffset = timezoneOffset;
    }

    @JsonProperty("id")
    public @NotNull Long getId() {
        return id;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
    }

    @JsonProperty("timezoneOffset")
    public @NotNull Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    @JsonProperty("groupId")
    public @NotNull Long getGroupId() {
        return groupId;
    }

    @JsonProperty("sort")
    public @NotNull Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("groupId", groupId)
                .append("sort", sort)
                .append("id", id)
                .append("timezoneOffset", timezoneOffset)
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

        Device device = (Device) o;

        return new EqualsBuilder()
                .append(name, device.name)
                .append(groupId, device.groupId)
                .append(sort, device.sort)
                .append(id, device.id)
                .append(timezoneOffset, device.timezoneOffset)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(groupId)
                .append(sort)
                .append(id)
                .append(timezoneOffset)
                .toHashCode();
    }
}
