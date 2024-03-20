package core;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType;

    public BrowserService(){
        switch (ReadProperties.getBrowser()){
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.chromedriver().setup();
                ChromeDriver chromeDriver = new ChromeDriver(getChromeOPtions());
                break;
            case "safari":
                driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.safaridriver().setup();
                SafariDriver safariDriver = new SafariDriver();
                break;
            default:
                System.out.println(ReadProperties.getBrowser()+" isn't supported");
        }
    }

    static public ChromeOptions getChromeOPtions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito"); //???????
        return chromeOptions;
    }

    public WebDriver getDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }

}
