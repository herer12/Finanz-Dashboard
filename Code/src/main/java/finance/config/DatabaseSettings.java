package finance.config;

class DatabaseSettings extends Setting{

    private int port = 3000;
    DatabaseSettings() {
        super("DatabaseSettings.conf");

    }

    @Override
    protected void decideSetting(String key, String value) {

    }
    public int getPort() {
        return port;
    }
}
