package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.jetbrains.annotations.NotNull;
import org.kilinochi.dreamkas.sdk.exception.SerializationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * @author arman.shamenov
 */
public class JacksonSerializer implements Serializer {
    private final ObjectMapper mapper;

    public JacksonSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public JacksonSerializer() {
        this(new ObjectMapper());
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }


    @NotNull
    @Override
    public byte[] serialize(@NotNull Object object) throws SerializationException {
        try {
            return mapper.writer().writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @NotNull
    @Override
    public String serializeToString(@NotNull Object object) throws SerializationException {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @NotNull
    @Override
    public <T> Collection<T> deserialize(String data, Class<? extends Collection<T>> collectionType, Class<T> classType) throws SerializationException {
        CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(collectionType, classType);
        Collection<T> res;
        try {
             res = mapper.readValue(data, typeReference);
        } catch (IOException e) {
            throw new SerializationException(e);
        }

        return res;
    }

    @NotNull
    @Override
    public <T> T deserialize(@NotNull String data, Class<T> responseType) throws SerializationException {
        try {
            ObjectReader reader = mapper.reader();
            JsonNode json = reader.readTree(data);
            return reader.treeToValue(json, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @NotNull
    @Override
    public <T> T deserialize(@NotNull InputStream data, Class<T> responseType) throws SerializationException {
        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @NotNull
    @Override
    public <T> T deserialize(@NotNull byte[] data, Class<T> responseType) throws SerializationException {
        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
