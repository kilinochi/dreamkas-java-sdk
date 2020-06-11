package org.kilinochi.dreamkas.sdk.queries;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author arman.shamenov
 */
public class QueryParam<T> {
    @NotNull
    private final String name;
    @Nullable
    private T value;
    private boolean isRequired;

    public QueryParam(@NotNull String name, @NotNull DreamkasQuery<?> holder) {
        this(name, null, holder);
    }

    public QueryParam(@NotNull String name, @Nullable T defaultValue, @NotNull DreamkasQuery<?> holder) {
        this.name = name;
        this.value = defaultValue;
        holder.addParam(this);
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public T getValue() {
        return value;
    }

    public void setValue(@Nullable T value) {
        this.value = value;
    }

    @NotNull
    public QueryParam<T> required() {
        this.isRequired = true;
        return this;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public String format() {
        return String.valueOf(value);
    }
}
