package finance.config;

import at.herer12_erik_van_haentjens.logging.Logger;

class LoggerSettings extends Setting {
    private static boolean asyncEnabled = false;
    private static boolean colorEnabled = true;
    private static int maxBackups = 1;
    private static int maxFileSizeMB = 1;
    private static String logDir = "/logs";
    private static boolean fileEnabled = true;

    private static void configure() {
        Logger.Config.setAsyncEnabled(asyncEnabled);
        Logger.Config.setColorEnabled(colorEnabled);
        Logger.Config.setMaxBackups(maxBackups);
        Logger.Config.setMaxFileSizeMB(maxFileSizeMB);
        Logger.Config.setLogDir(logDir);
        Logger.Config.setFileEnabled(fileEnabled);
    }

    /**
     * Activates the logger with the right Settings.
     * This Class does not have to be saved because it is not needed to change or use any Data.
     */
    static void loggerSettings() {
        Logger.Config.setFileEnabled(false);
        Logger.Config.setAsyncEnabled(false);
        setting("LoggerSettings.conf", LoggerSettings::decideSetting);
        configure();
    }

    protected static void decideSetting(String key, String value) {
        switch (key) {
            case "asyncEnabled":
                asyncEnabled = Boolean.parseBoolean(value);
                break;
            case "colorEnabled":
                colorEnabled = Boolean.parseBoolean(value);
                break;
            case "maxBackups":
                maxBackups = Integer.parseInt(value);
                break;
            case "maxFileSizeMB":
                maxFileSizeMB = Integer.parseInt(value);
                break;
            case "logDir":
                logDir = value;
                break;
            case "fileEnabled":
                fileEnabled = Boolean.parseBoolean(value);
                break;
        }
    }


}



