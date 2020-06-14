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
public class SubscriptionRequestBody implements DreamkasSerializable {
    @NotNull
    private final @Valid String url;
    @NotNull
    private final @Valid WebhookTypes types;
    @NotNull
    private final @Valid Boolean isActive;

    @JsonCreator
    public SubscriptionRequestBody(@NotNull @JsonProperty("url") String url,
                                   @NotNull @JsonProperty("types") WebhookTypes types,
                                   @NotNull @JsonProperty("isActive") Boolean isActive) {
        this.url = url;
        this.types = types;
        this.isActive = isActive;
    }

    @JsonProperty("types")
    public @NotNull WebhookTypes getTypes() {
        return types;
    }

    @JsonProperty("url")
    public @NotNull String getUrl() {
        return url;
    }

    @JsonProperty("isActive")
    public @NotNull Boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("url", url)
                .append("types", types)
                .append("isActive", isActive)
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

        SubscriptionRequestBody that = (SubscriptionRequestBody) o;

        return new EqualsBuilder()
                .append(url, that.url)
                .append(types, that.types)
                .append(isActive, that.isActive)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(url)
                .append(types)
                .append(isActive)
                .toHashCode();
    }
}
