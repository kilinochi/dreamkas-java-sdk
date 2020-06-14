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
public class WebhooksList implements DreamkasSerializable {
    @NotNull
    private final List<@Valid Webhook> webhooks;

    @JsonCreator
    public WebhooksList(@JsonProperty("webhooks") @NotNull List<@Valid Webhook> webhooks) {
        this.webhooks = webhooks;
    }

    @JsonProperty("webhooks")
    public @NotNull List<Webhook> getWebhooks() {
        return webhooks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("webhooks", webhooks)
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

        WebhooksList that = (WebhooksList) o;

        return new EqualsBuilder()
                .append(webhooks, that.webhooks)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(webhooks)
                .toHashCode();
    }
}
