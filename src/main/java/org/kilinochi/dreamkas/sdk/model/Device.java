package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.jetbrains.annotations.NotNull;

/**
 * @author arman.shamenov
 */
public class Device implements DreamkasSerializable {
    @NotNull
    private final String name;
    @NotNull
    private final Long groupId;
    @NotNull
    private final Long sort;
    @NotNull
    private final Long id;
    @NotNull
    private final Integer timezoneOffset;

    @JsonCreator
    public Device(@NotNull String name,
                  @NotNull Long groupId,
                  @NotNull Long sort,
                  @NotNull Long id,
                  @NotNull Integer timezoneOffset) {
        this.name = name;
        this.groupId = groupId;
        this.sort = sort;
        this.id = id;
        this.timezoneOffset = timezoneOffset;
    }
}
