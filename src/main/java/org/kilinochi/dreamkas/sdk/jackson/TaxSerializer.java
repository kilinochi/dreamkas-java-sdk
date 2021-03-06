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
        if (value == null) {
            generator.writeNull();;
            return;
        }

        switch (value) {
            case NDS_NO_TAX_V1: {
                generator.writeNull();
                break;
            }
            case NDS_0_V1: {
                generator.writeNumber(0);
                break;
            }
            case NDS_10_V1: {
                generator.writeNumber(10);
                break;
            }
            case NDS_18_V1: {
                generator.writeNumber(18);
                break;
            }
            case NDS_20_V1: {
                generator.writeNumber(20);
                break;
            }
            case NDS_10_CALCULATED_V1: {
                generator.writeNumber(110);
                break;
            }
            case NDS_20_CALCULATED_V1: {
                generator.writeNumber(120);
                break;
            }
            case NDS_MIXED_V1: {
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
