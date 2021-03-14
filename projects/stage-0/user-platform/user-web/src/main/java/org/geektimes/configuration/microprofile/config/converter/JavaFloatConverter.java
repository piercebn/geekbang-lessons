package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

public class JavaFloatConverter implements Converter<Float> {
    @Override
    public Float convert(String value) throws IllegalArgumentException, NullPointerException {
        System.out.println("JavaFloatConverter : " + value);
        return Float.valueOf(value);
    }
}
