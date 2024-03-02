import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaminateTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void laminateAmountTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(2000);
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");
        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.clear();
        panelLength.sendKeys("2000");
        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.clear();
        panelWidth.sendKeys("200");
        WebElement selectDropdown = driver.findElement(By.id("laying_method_laminate"));
        Select dropDirection = new Select(selectDropdown);
        dropDirection.selectByIndex(2); //с использованием отрезанного элемента
        WebElement directionFloor = driver.findElement(By.id("direction-laminate-id1"));
        directionFloor.sendKeys(Keys.ENTER); // click() , submit() не работает здесь , sendKeys(Keys.ENTER) не измен значение
        WebElement calculationBtn = driver.findElement(By.className("calc-btn"));
        calculationBtn.click();
//       driver.switchTo().frame(); // не могу найти элем, на который переключится при появл поп-апа
        WebElement calculatePlankAmount = driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]"));
        WebElement calculatePackAmount = driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]"));
        Assert.assertEquals(calculatePlankAmount.getText(), "Требуемое количество досок ламината: 53");
        Assert.assertEquals(calculatePackAmount.getText(), "Количество упаковок ламината: 7");
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
