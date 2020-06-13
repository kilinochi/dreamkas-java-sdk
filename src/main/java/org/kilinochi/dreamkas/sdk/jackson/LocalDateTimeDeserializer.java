package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author arman.shamenov
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    public static final LocalDateTime START_DAY = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();

    private static final DateTimeFormatter ISO_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter ISO_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    public LocalDateTimeDeserializer(Class<LocalDateTime> src) {
        super(src);
    }

    public LocalDateTimeDeserializer() {
        this(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();

        if (value == null || value.isEmpty()) {
            return START_DAY;
        }

        if (value.endsWith("Z")) {
            return LocalDateTime.parse(value, ISO_2);
        }
        return LocalDateTime.parse(value, ISO_1);
    }
}
