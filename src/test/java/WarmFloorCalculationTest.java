import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WarmFloorCalculationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
            driver = new BrowserService().getDriver();
    }

    @Test
    public void cablePowerCalculationTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        Thread.sleep(2000);
        WebElement floorWidth = driver.findElement(By.id("el_f_width"));
        floorWidth.sendKeys("4");
        WebElement floorLength = driver.findElement(By.id("el_f_lenght"));
        floorLength.sendKeys("5");
        WebElement roomDropdown = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(roomDropdown);
        selectRoom.selectByIndex(1); //Кухня или спальня
        WebElement heatingDropdown = driver.findElement(By.id("heating_type"));
        Select selectHeating = new Select(heatingDropdown);
        selectHeating.selectByIndex(2); //Подогрев для комфорта
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        heatLoss.sendKeys("1568");
        WebElement buttonCalculate = driver.findElement(By.className("buttHFcalc"));
        buttonCalculate.click();
        WebElement cablePowerField = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(cablePowerField.getAttribute("value"), "873");
//        Assert.assertEquals(cablePowerField.getText(), "873"); // Actual   :  null
    }
    @Test
    public void specifCablePowerCalculationTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        Thread.sleep(2000);
        WebElement floorWidth = driver.findElement(By.id("el_f_width"));
        floorWidth.sendKeys("4");
        WebElement floorLength = driver.findElement(By.id("el_f_lenght"));
        floorLength.sendKeys("5");
        WebElement roomDropdown = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(roomDropdown);
        selectRoom.selectByIndex(1); //Кухня или спальня
        WebElement heatingDropdown = driver.findElement(By.id("heating_type"));
        Select selectHeating = new Select(heatingDropdown);
        selectHeating.selectByIndex(2); //Подогрев для комфорта
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        heatLoss.sendKeys("1568");
        WebElement buttonCalculate = driver.findElement(By.className("buttHFcalc"));
        buttonCalculate.click();
        WebElement specifCablePowerField = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specifCablePowerField.getAttribute("value"), "44");
//        Assert.assertEquals(specifCablePowerField.getText(), 44); // Actual   :  null
    }
    @AfterMethod
    public void browserQuit(){
        driver.quit();
    }

}
