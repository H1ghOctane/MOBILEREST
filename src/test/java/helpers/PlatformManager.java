package helpers;

public class PlatformManager {

    private PlatformManager() {
    }

    public static String platform() {
        return System.getProperty(
                "platform",
                "android"
        );
    }

    public static boolean isIos() {
        return "ios".equalsIgnoreCase(
                platform()
        );
    }

    public static boolean isAndroid() {
        return !isIos();
    }
}