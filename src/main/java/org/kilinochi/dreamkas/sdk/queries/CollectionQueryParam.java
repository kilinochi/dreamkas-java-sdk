package org.kilinochi.dreamkas.sdk.queries;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author arman.shamenov
 */
public class CollectionQueryParam<T> extends QueryParam<Collection<T>> {

    public CollectionQueryParam(@NotNull String name, @NotNull DreamkasQuery<?> holder) {
        super(name, holder);
    }

    @Override
    public String format() {
        Collection<T> value = getValue();
        if (value == null) {
            return "";
        }

        return value.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
