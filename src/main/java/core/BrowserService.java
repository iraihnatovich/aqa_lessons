package core;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType  driverManagerType;

    public BrowserService(){
        switch (ReadProperties.getBrowser()){
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                 driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                System.out.println(ReadProperties.getBrowser()+" is not supported");
                break;
        }
    }

}
