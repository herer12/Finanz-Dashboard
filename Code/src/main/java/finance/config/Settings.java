package finance.config;

public class Settings {
    private static LoggerSettings loggerSettings;
    private static DatabaseSettings databaseSettings;

    public static void initializeSettings(){
        LoggerSettings.loggerSettings();
        DatabaseSettings.databaseSettings();
        Setting.logger.info("LoggerSettings initialized");
        Setting.logger.info("DatabaseSettings initialized");
    }
    public static String getURL() {
        return DatabaseSettings.getURL();
    }
}
