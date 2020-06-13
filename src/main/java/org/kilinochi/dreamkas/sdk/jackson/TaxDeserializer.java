package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import org.kilinochi.dreamkas.sdk.model.Tax;

import java.io.IOException;

/**
 * @author arman.shamenov
 */
public class TaxDeserializer extends StdDeserializer<Tax> {

    public TaxDeserializer(Class<?> vc) {
        super(vc);
    }

    public TaxDeserializer() {
        this(Tax.class);
    }

    @Override
    public Tax deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonToken currentToken = jp.getCurrentToken();

        if (currentToken.isNumeric()) {
            Integer value = jp.getIntValue();
            return Tax.create(value);
        }

        String value = jp.getText();
        return Tax.create(value);
    }
}
