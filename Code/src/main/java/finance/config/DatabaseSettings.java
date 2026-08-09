package finance.config;

class DatabaseSettings extends Setting {

    private static String url;

    static void databaseSettings() {
        setting("DatabaseSettings.conf", DatabaseSettings::decideSetting);
    }

    private static void decideSetting(String key, String value) {
        switch (key) {
            case "url":
                url = value;
                break;
            default:
                logger.warn("Unknown database setting: " + key);
                break;
        }
    }

    public static String getURL() {
        return url;
    }
}
