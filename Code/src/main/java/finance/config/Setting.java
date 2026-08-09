package finance.config;

import at.herer12_erik_van_haentjens.logging.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

abstract class Setting {

    protected Logger logger = Logger.getLogger(this.getClass());
    /**
     * The data of the setting file.
     */
    protected String[] settingFileData;

    Setting(String fileName){
        loadFile(fileName);
        setSetting();
    }

    /**
     * Loads the contents of the specified file into the settingFileData field.
     * If the file cannot be read, a warning is logged.
     *
     * @param fileName the name of the file to be loaded, located in the "/config/" directory
     */
    private void loadFile(String fileName){
        Path path = Paths.get("config/"+fileName);

        try {
            settingFileData = Files.readAllLines(path).toArray(new String[0]);
        } catch (IOException e) {
            logger.warn("Error reading setting file: "+fileName);
        }
    }


    /**
     * Decides the appropriate action or configuration for a given key-value pair
     * parsed from a settings file. The implementation of this method is specific
     * to the subclass, which will handle the setting logic based on the provided
     * key and value.
     *
     * @param key   the name of the setting or configuration parameter to be processed
     * @param value the value to set for the given configuration key
     */
    protected abstract void decideSetting(String key, String value);

    /**
     * Parses the settings from the `settingFileData` array and delegates them to the
     * {@code decideSetting(String, String)} method for processing. Each line in
     * `settingFileData` is expected to be a key-value pair, separated by an equals sign ('=').
     * <p>
     * If an exception occurs during processing, the error is logged with a warning level.
     * The method also logs the parsed key-value pairs for debugging purposes..
     */
    private void setSetting(){
        try {
            for (String setting : settingFileData) {

                String[] keyValue = setting.split("=");

                String key = keyValue[0].trim();

                String value = keyValue[1].trim().replace(";", "");

                String[] keySplit = key.split(" ");
                key=keySplit[keySplit.length-1];

                decideSetting(key, value);


                logger.debug(key + " = " + value);
            }
        }catch(Exception e){
            logger.warn("Error setting variables from setting file: "+Arrays.toString(settingFileData));
            logger.debug(e.getMessage());
        }

    }


}
