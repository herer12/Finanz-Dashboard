package finance.config;

public class Settings {
    private LoggerSettings loggerSettings = new LoggerSettings();
    private DatabaseSettings databaseSettings = new DatabaseSettings();

    public Settings() {
        loggerSettings.logger.info("LoggerSettings loaded");
        databaseSettings.logger.info("DatabaseSettings loaded");
    }
    public int getPort() {
        return databaseSettings.getPort();
    }
}
