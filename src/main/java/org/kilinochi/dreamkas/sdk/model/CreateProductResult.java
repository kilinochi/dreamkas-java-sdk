package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class CreateProductResult implements DreamkasSerializable {

    @NotNull
    private final @Valid UUID uuid;

    public CreateProductResult(@NotNull @JsonProperty("id") UUID uuid) {
        this.uuid = uuid;
    }

    @NotNull
    @JsonProperty("id")
    public UUID getUuid() {
        return uuid;
    }
}
