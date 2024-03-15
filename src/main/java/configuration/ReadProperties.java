package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties;
    static {
        properties = new Properties();
        try{
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getUrl(){
        return properties.getProperty("url");
    }

    public static String getBrowser(){
        return properties.getProperty("browser").toLowerCase();
    }

    public static int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
    }
    public static boolean isHeadless(){
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}

