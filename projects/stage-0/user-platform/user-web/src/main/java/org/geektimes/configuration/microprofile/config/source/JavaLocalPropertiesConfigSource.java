package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaLocalPropertiesConfigSource implements ConfigSource {
    private final Map<String, String> properties;

    public JavaLocalPropertiesConfigSource() {
        Properties prop = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("META-INF/config.properties")) {
            // 读取本地文件配置
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("读取本地配置文件[META-INF/config.properties]失败, 原因：" + e.getMessage());
        }
        Map systemProperties = prop;
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
        return "Local config file properities ";
    }
}
