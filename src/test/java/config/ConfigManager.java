package config;


import org.aeonbits.owner.ConfigFactory;

public class ConfigManager {
    public static final BrowserstackConfig BS_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
}