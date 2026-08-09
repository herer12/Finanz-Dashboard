package finance.config;

import at.herer12_erik_van_haentjens.logging.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.BiConsumer;

abstract class Setting {

    protected static Logger logger = Logger.getLogger(Setting.class);

    /**
     * The data of the setting file.
     */
    protected static String[] settingFileData;

    static void setting(String fileName, BiConsumer<String, String> settingHandler) {
        loadFile(fileName);
        setSetting(settingHandler);
    }

    /**
     * Loads the contents of the specified file into the settingFileData field.
     * If the file cannot be read, a warning is logged.
     *
     * @param fileName the name of the file to be loaded, located in the "/config/" directory
     */
    private static void loadFile(String fileName) {
        Path path = Paths.get("config/" + fileName);

        try {
            settingFileData = Files.readAllLines(path).toArray(new String[0]);
        } catch (IOException e) {
            settingFileData = new String[0];
            logger.warn("Error reading setting file: " + fileName);
            logger.debug(e.getMessage());
        }
    }

    /**
     * Parses the settings from the settingFileData array and delegates them to the
     * provided setting handler. Each line is expected to be a key-value pair separated
     * by the first equals sign ('=').
     */
    private static void setSetting(BiConsumer<String, String> settingHandler) {
        try {
            for (String setting : settingFileData) {
                if (setting == null || setting.isBlank() || setting.trim().startsWith("#")) {
                    continue;
                }

                String[] keyValue = setting.split("=", 2);

                if (keyValue.length != 2) {
                    logger.warn("Invalid setting line: " + setting);
                    continue;
                }

                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace(";", "");

                String[] keySplit = key.split(" ");
                key = keySplit[keySplit.length - 1];

                settingHandler.accept(key, value);

                logger.debug(key + " = " + value);
            }
        } catch (Exception e) {
            logger.warn("Error setting variables from setting file: " + Arrays.toString(settingFileData));
            logger.debug(e.getMessage());
        }
    }
}
