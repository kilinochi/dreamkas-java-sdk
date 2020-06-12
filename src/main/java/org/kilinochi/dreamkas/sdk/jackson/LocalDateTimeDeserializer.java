package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * @author arman.shamenov
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private final Supplier<DateTimeFormatter> formatter;

    public LocalDateTimeDeserializer(Class<LocalDateTime> src,
                                     Supplier<DateTimeFormatter> formatter) {
        super(src);
        this.formatter = formatter;
    }

    public LocalDateTimeDeserializer() {
        this(LocalDateTime.class, () -> DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }

    // yyyy-MM-dd'T'HH:mm:ss.SSS default

    public LocalDateTimeDeserializer(Class<LocalDateTime> src) {
        this(src, () -> DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return LocalDateTime.parse(value, formatter.get());
    }
}
