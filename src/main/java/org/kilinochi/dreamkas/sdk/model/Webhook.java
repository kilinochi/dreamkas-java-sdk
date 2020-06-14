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
public class Webhook implements DreamkasSerializable {
    @NotNull
    private final @Valid String url;
    @NotNull
    private final @Valid String id;
    @NotNull
    private final @Valid WebhookTypes types;

    @JsonCreator
    public Webhook(@JsonProperty("url") @NotNull String url,
                   @JsonProperty("id") @NotNull String id,
                   @JsonProperty("types") @NotNull WebhookTypes types) {
        this.url = url;
        this.id = id;
        this.types = types;
    }

    @JsonProperty("url")
    public @NotNull String getUrl() {
        return url;
    }

    @JsonProperty("id")
    public @NotNull String getId() {
        return id;
    }

    @JsonProperty("types")
    public @NotNull WebhookTypes getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("url", url)
                .append("id", id)
                .append("types", types)
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

        Webhook webhook = (Webhook) o;

        return new EqualsBuilder()
                .append(url, webhook.url)
                .append(id, webhook.id)
                .append(types, webhook.types)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(url)
                .append(id)
                .append(types)
                .toHashCode();
    }
}
