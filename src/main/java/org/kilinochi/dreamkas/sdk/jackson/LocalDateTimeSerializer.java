package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author arman.shamenov
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
    private static final DateTimeFormatter ISO_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter ISO_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    public LocalDateTimeSerializer() {
        this(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.format(ISO_2));
    }
}
