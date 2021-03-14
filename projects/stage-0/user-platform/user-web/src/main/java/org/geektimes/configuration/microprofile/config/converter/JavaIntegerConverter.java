package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

public class JavaIntegerConverter implements Converter<Integer> {
    @Override
    public Integer convert(String value) throws IllegalArgumentException, NullPointerException {
        System.out.println("JavaIntegerConverter : " + value);
        return Integer.parseInt(value);
    }
}
