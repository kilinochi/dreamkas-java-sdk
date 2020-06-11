package org.kilinochi.dreamkas.sdk.jackson;

import org.jetbrains.annotations.NotNull;
import org.kilinochi.dreamkas.sdk.exception.SerializationException;

import java.io.InputStream;
import java.util.Collection;

/**
 * @author arman.shamenov
 */
public interface Serializer {

    @NotNull
    byte[] serialize(@NotNull Object object) throws SerializationException;

    @NotNull
    String serializeToString(@NotNull Object object) throws SerializationException;

    @NotNull
    <T> Collection<T> deserialize(String data, Class<? extends Collection<T>> collectionType, Class<T> classType) throws SerializationException;

    @NotNull
    <T> T deserialize(@NotNull String data, Class<T> responseType) throws SerializationException;

    @NotNull
    <T> T deserialize(@NotNull InputStream data, Class<T> responseType) throws SerializationException;

    @NotNull
    <T> T deserialize(@NotNull byte[] data, Class<T> responseType) throws SerializationException;

}
