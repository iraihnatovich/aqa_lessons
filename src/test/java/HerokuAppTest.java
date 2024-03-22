import core.BrowserService;
import core.WaitService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HerokuAppTest {
    protected WebDriver driver;
    protected WaitService driverWait;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driverWait = new WaitService(driver);
    }

    @Test
    //* Открыть iFrame
    //* Проверить, что текст внутри параграфа равен “Your content goes here.”
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driverWait.waitForVisibility(By.cssSelector("a[href='/iframe']")).click();
        WebElement frameUnderTest = driverWait.waitForVisibility(By.cssSelector("iframe[id='mce_0_ifr']"));
        driver.switchTo().frame(frameUnderTest);
        Assert.assertEquals(driverWait.waitForVisibility(By.cssSelector("p")).getText(), "Your content goes here.");
    }

    @Test
    //* Открыть Prompt Alert
    //* Ввести текст и нажать Accept кнопку
    //* Проверить, что введенный ранее текст отображается на странице в секции Result
    public void promptAlertTest() {
        String text = "Example text";
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driverWait.waitForVisibility(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        Assert.assertEquals(driverWait.waitForVisibility(By.cssSelector("#result")).getText(), ("You entered: " + text));
    }

    @Test
    //* Дважды нажать на ссылку “Click here”
    //* Проверить, что открыто 3 вкладки в браузере
    //* Закрыть последнюю вкладку
    //* Переключиться на основную вкладку
    //* Проверить что осталось 2 вкладки
    public void quantityOfTabsTest() {
        driver.get("http://the-internet.herokuapp.com/windows");
        String originalWindowHandler = driver.getWindowHandle();
        WebElement link = driverWait.waitForVisibility(By.cssSelector("[href='/windows/new']"));
        int amountOfTabsExpected = 1;
        while (amountOfTabsExpected < 3) {
            amountOfTabsExpected++;
            link.click();
        }
        Set<String> handlersSet = driver.getWindowHandles();
        List<String> handlersList = new ArrayList<>(handlersSet);
        Assert.assertEquals(handlersList.size(), amountOfTabsExpected);
        driver.switchTo().window(handlersList.get((handlersList.size() - 1)));
        driver.close();
        handlersList.remove((handlersList.size() - 1));
        driver.switchTo().window(originalWindowHandler);
        Assert.assertEquals(handlersList.size(), amountOfTabsExpected - 1);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
