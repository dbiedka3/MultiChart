package config;

public class GlobalConfig implements GlobalConstants {


    private static GlobalConfig globalConfig;


    private GlobalConfig() {
    }


    public static GlobalConfig getInstance() {

        if (globalConfig == null) {
            globalConfig = new GlobalConfig();
        }
        return globalConfig;
    }

}
