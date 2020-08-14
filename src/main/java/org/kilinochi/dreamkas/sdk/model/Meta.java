package org.kilinochi.dreamkas.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;

/**
 * Alcohol meta info
 *
 * @author arman.shamenov
 */
public class Meta implements DreamkasSerializable {

    public static Meta EMPTY = new Meta(null, null, null ,null, null, null,null);

    @Nullable
    private final @Valid String code;
    @Nullable
    private final @Valid String typeCode;
    @Nullable
    private final @Valid Integer volume;
    // 1-1000
    @Nullable
    private final @Valid Integer alc;
    @Nullable
    private final @Valid String originCountryCode;
    @Nullable
    private final @Valid String customEntryNum;
    @Nullable
    private final @Valid Integer exciseDuty;

    @JsonCreator
    public Meta(@JsonProperty("code") @Nullable @Valid String code,
                @JsonProperty("typeCode") @Nullable @Valid String typeCode,
                @JsonProperty("volume") @Nullable @Valid Integer volume,
                @JsonProperty("alc") @Nullable @Valid Integer alc,
                @JsonProperty("originCountryCode") @Nullable @Valid String originCountryCode,
                @JsonProperty("customEntryNum") @Nullable @Valid String customEntryNum,
                @JsonProperty("exciseDuty") @Nullable @Valid Integer exciseDuty) {
        this.code = code;
        this.typeCode = typeCode;
        this.volume = volume;
        this.alc = alc;
        this.originCountryCode = originCountryCode;
        this.customEntryNum = customEntryNum;
        this.exciseDuty = exciseDuty;
    }

    @Nullable
    @JsonProperty("alc")
    public Integer getAlc() {
        return alc;
    }

    @Nullable
    @JsonProperty("exciseDuty")
    public Integer getExciseDuty() {
        return exciseDuty;
    }

    @Nullable
    @JsonProperty("volume")
    public Integer getVolume() {
        return volume;
    }

    @Nullable
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @Nullable
    @JsonProperty("customEntryNum")
    public String getCustomEntryNum() {
        return customEntryNum;
    }

    @Nullable
    @JsonProperty("originCountryCode")
    public String getOriginCountryCode() {
        return originCountryCode;
    }

    @Nullable
    @JsonProperty("typeCode")
    public String getTypeCode() {
        return typeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Meta meta = (Meta) o;

        return new EqualsBuilder()
                .append(code, meta.code)
                .append(typeCode, meta.typeCode)
                .append(volume, meta.volume)
                .append(alc, meta.alc)
                .append(originCountryCode, meta.originCountryCode)
                .append(customEntryNum, meta.customEntryNum)
                .append(exciseDuty, meta.exciseDuty)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(typeCode)
                .append(volume)
                .append(alc)
                .append(originCountryCode)
                .append(customEntryNum)
                .append(exciseDuty)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("typeCode", typeCode)
                .append("volume", volume)
                .append("alc", alc)
                .append("originCountryCode", originCountryCode)
                .append("customEntryNum", customEntryNum)
                .append("exciseDuty", exciseDuty)
                .toString();
    }
}
