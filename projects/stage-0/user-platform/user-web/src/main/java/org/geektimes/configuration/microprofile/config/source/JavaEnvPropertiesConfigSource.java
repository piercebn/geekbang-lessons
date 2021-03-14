package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaEnvPropertiesConfigSource implements ConfigSource {
    private final Map<String, String> properties;

    public JavaEnvPropertiesConfigSource() {
        Map systemProperties = System.getenv();
        this.properties = new HashMap<>(systemProperties);
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "OS env properities";
    }
}
