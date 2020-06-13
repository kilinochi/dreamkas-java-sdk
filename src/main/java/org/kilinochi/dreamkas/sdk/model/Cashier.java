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
public class Cashier implements DreamkasSerializable {
    @NotNull
    private final @Valid String tabNumber;
    @NotNull
    private final @Valid String name;
    @NotNull
    private final @Valid String inn;
    @NotNull
    private final @Valid String card;
    @NotNull
    private final @Valid String password;
    @NotNull
    private final @Valid String role;
    @NotNull
    private final List<@Valid CashierPermission> permissions;

    @JsonCreator
    public Cashier(@JsonProperty("tabNumber") @NotNull String tabNumber,
                   @JsonProperty("name") @NotNull String name,
                   @JsonProperty("inn") @NotNull String inn,
                   @JsonProperty("card") @NotNull String card,
                   @JsonProperty("password") @NotNull String password,
                   @JsonProperty("role") @NotNull String role,
                   @JsonProperty("permissions") @NotNull List<CashierPermission> permissions) {
        this.tabNumber = tabNumber;
        this.name = name;
        this.inn = inn;
        this.card = card;
        this.password = password;
        this.role = role;
        this.permissions = permissions;
    }

    @JsonProperty("name")
    public @NotNull String getName() {
        return name;
    }

    @JsonProperty("permissions")
    public @NotNull List<CashierPermission> getPermissions() {
        return permissions;
    }

    @JsonProperty("card")
    public @NotNull String getCard() {
        return card;
    }

    @JsonProperty("inn")
    public @NotNull String getInn() {
        return inn;
    }

    @JsonProperty("password")
    public @NotNull String getPassword() {
        return password;
    }

    @JsonProperty("role")
    public @NotNull String getRole() {
        return role;
    }

    @JsonProperty("tabNumber")
    public @NotNull String getTabNumber() {
        return tabNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tabNumber", tabNumber)
                .append("name", name)
                .append("inn", inn)
                .append("card", card)
                .append("password", password)
                .append("role", role)
                .append("permissions", permissions)
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

        Cashier cashier = (Cashier) o;

        return new EqualsBuilder()
                .append(tabNumber, cashier.tabNumber)
                .append(name, cashier.name)
                .append(inn, cashier.inn)
                .append(card, cashier.card)
                .append(password, cashier.password)
                .append(role, cashier.role)
                .append(permissions, cashier.permissions)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(tabNumber)
                .append(name)
                .append(inn)
                .append(card)
                .append(password)
                .append(role)
                .append(permissions)
                .toHashCode();
    }
}
