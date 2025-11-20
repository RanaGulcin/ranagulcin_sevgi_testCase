package utilties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        String fileLine = "src/configuration.properties";
        try {
            FileInputStream file = new FileInputStream(fileLine);
            properties = new Properties();
            properties.load(file);
        }catch (IOException e){
            System.out.println("configuration.properties can not read.");
        }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }

}
