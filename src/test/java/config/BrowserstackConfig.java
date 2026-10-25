package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("bs.username")
    String username();

    @Key("bs.accessKey")
    String accessKey();

    @Key("bs.appUrl")
    String appUrl();

    @Key("bs.deviceName")
    String deviceName();

    @Key("bs.osVersion")
    String osVersion();

    @Key("ios.deviceName")
    String iosDeviceName();

    @Key("ios.Version")
    String iosVersion();

    @Key("ios.appUrl")
    String iosAppUrl();

}