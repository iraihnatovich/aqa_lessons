package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties;

    static{
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static String getBrowser(){
        return properties.getProperty("browser").toLowerCase();
   }
   public static String getUrl(){
        return properties.getProperty("url");
   }
   public static String getUsername(){
        return properties.getProperty("username");
   }
   public static String getPassword(){
        return properties.getProperty("password");
   }
   public static int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
   }
}
