package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // static block runs once before anything else
    static {
        // checked exception must be surrounded by try/catch block
        try {
            // relative path to open the config file
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            // read from config file
            properties.load(fileInputStream);
            // close after reading
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // getter method allows us to read the private properties
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
