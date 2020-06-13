package org.kilinochi.dreamkas.sdk.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.kilinochi.dreamkas.sdk.model.Tax;

import java.io.IOException;

/**
 * @author arman.shamenov
 */
public class TaxSerializer extends StdSerializer<Tax> {

    public TaxSerializer(Class<Tax> t) {
        super(t);
    }

    public TaxSerializer() {
        this(Tax.class);
    }

    @Override
    public void serialize(Tax value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        switch (value) {
            case NULL: {
                generator.writeNumber(-2);
                break;
            }
            case ZERO_TAX_V1: {
                generator.writeNumber(0);
                break;
            }
            case TEN_TAX_V1: {
                generator.writeNumber(10);
                break;
            }
            case EIGHTEEN_TAX_V1: {
                generator.writeNumber(18);
                break;
            }
            case TWENTY_TAX_V1: {
                generator.writeNumber(20);
                break;
            }
            case ONE_HUNDRED_TEN_V1: {
                generator.writeNumber(110);
                break;
            }
            case ONE_HUNDRED_TWENTY_V1: {
                generator.writeNumber(120);
                break;
            }
            case MIXED_V1: {
                generator.writeNumber(-1);
                break;
            }
            default: {
                generator.writeString(value.getValue().toUpperCase());
                break;
            }
        }
    }
}
