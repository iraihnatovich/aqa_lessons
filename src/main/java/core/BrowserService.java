package core;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.util.HashMap;

import static configuration.ReadProperties.getDownloadPath;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType;

    public BrowserService() {
        switch (ReadProperties.getBrowser()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "safari":
                driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new SafariDriver();
                break;
            default:
                System.out.println(ReadProperties.getBrowser() + " is not supported");
                break;
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        HashMap<String, Object> preference = new HashMap<>();
        preference.put("profile.default_content_settings.popups", 0);
//        preference.put("download.prompt_for_download", false);
//        preference.put("browser.set_download_behavior", "{ behavior: 'allow' , downloadPath: '"+getDownloadPath()+"'}");
        preference.put("download.default_directory", getDownloadPath());
        chromeOptions.setExperimentalOption("prefs", preference);
        return chromeOptions;
    }

    public WebDriver getDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }

}
