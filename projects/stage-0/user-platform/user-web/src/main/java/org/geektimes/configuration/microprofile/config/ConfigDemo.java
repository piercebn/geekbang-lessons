package org.geektimes.configuration.microprofile.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ConfigDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<ConfigProviderResolver> serviceLoader = ServiceLoader.load(ConfigProviderResolver.class, classLoader);
        Iterator<ConfigProviderResolver> iterator = serviceLoader.iterator();
        if (iterator.hasNext()) {
            // 获取 ConfigProviderResolver SPI 第一个实现
            ConfigProviderResolver configProviderResolver = iterator.next();
            Config config = configProviderResolver.getConfig(classLoader);
            String appName = config.getValue("application.name", String.class);
            Integer majorVerison = config.getValue("application.version.major", Integer.class);
            Integer minorVerison = config.getValue("application.version.minor", Integer.class);
            Float verison = config.getValue("application.version", Float.class);
            System.out.println("application.name : " + appName);
            System.out.println("application.version.major : " + majorVerison);
            System.out.println("application.version.minor : " + minorVerison);
            System.out.println("application.version : " + verison);
        }
    }
}
