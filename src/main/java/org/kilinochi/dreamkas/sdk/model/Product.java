package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author arman.shamenov
 */
public class Product implements DreamkasSerializable {

    @NotNull
    private @Valid final UUID id;
    @NotNull
    private @Valid final String name;
    @NotNull
    private @Valid final ProductType type;
    @NotNull
    private @Valid final Long departmentId;
    @NotNull
    private @Valid final Long quantity;
    @NotNull
    private @Valid final List<Price> prices;
    @NotNull
    private @Valid final Boolean isMarked;

    @JsonCreator
    public Product(
            @NotNull @JsonProperty("id") UUID id,
            @NotNull @JsonProperty("name") String name,
            @NotNull @JsonProperty("type") ProductType type,
            @NotNull @JsonProperty("departmentId") Long departmentId,
            @NotNull @JsonProperty("quantity") Long quantity,
            @NotNull @JsonProperty("prices") List<Price> prices,
            @NotNull @JsonProperty("isMarked") Boolean isMarked) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.departmentId = departmentId;
        this.quantity = quantity;
        this.prices = prices;
        this.isMarked = isMarked;
    }

    @NotNull
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @NotNull
    @JsonProperty("departmentId")
    public Long getDepartmentId() {
        return departmentId;
    }

    @NotNull
    @JsonProperty("prices")
    public List<Price> getPrices() {
        return prices;
    }

    @NotNull
    @JsonProperty("quantity")
    public Long getQuantity() {
        return quantity;
    }

    @NotNull
    @JsonProperty("type")
    public ProductType getType() {
        return type;
    }

    @NotNull
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @NotNull
    @JsonProperty("isMarked")
    public Boolean isMarked() {
        return isMarked;
    }

}
