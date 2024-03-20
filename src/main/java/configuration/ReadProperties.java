package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
private static Properties properties;
static {
    properties = new Properties();
    try {
        properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
static public String getBrowser(){
    return properties.getProperty("browser").toLowerCase();
}

static public int getTimeout(){
    return Integer.parseInt(properties.getProperty("timeout"));
}



}
