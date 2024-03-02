import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTestSkf {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();


    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys("38");
        WebElement sexSelectElem = driver.findElement(By.id("sex"));
        Select sexDropdown = new Select(sexSelectElem);
        sexDropdown.selectByIndex(1);
        WebElement creatinineField = driver.findElement(By.id("cr"));
        creatinineField.sendKeys("80");
        WebElement weightField = driver.findElement(By.id("mass"));
        weightField.sendKeys("55");
        WebElement heightField = driver.findElement(By.id("grow"));
        heightField.sendKeys("163");
//        WebElement calculBtn = driver.findElement(By.name("Рассчитать")); // not found
        WebElement calculBtn = driver.findElement(By.xpath("//*[@id=\"input-data\"]/p[7]/button"));
        calculBtn.click();
        WebElement mdrdNumberResult = driver.findElement(By.id("mdrd_res"));
        WebElement mdrdDescrResult = driver.findElement(By.xpath("//*[@id=\"mdrd\"]/p/i"));
        WebElement mdrdDiagnosis = driver.findElement(By.xpath("//*[@id=\"mdrd\"]/p/span"));
        String actualMdrdResult = mdrdNumberResult.getText() + " " + mdrdDescrResult.getText();
        WebElement cgeNumberResult = driver.findElement(By.id("cge_res"));
        WebElement cgeDescrResult = driver.findElement(By.xpath("//*[@id=\"cge\"]/p/i"));
        String actualCgeResult = cgeNumberResult.getText() + " " + cgeDescrResult.getText();
//        Assert.assertEquals(actualMdrdResult, "69.63 мл/мин/1.73м" + 2); // Positive , if +(char)178 isnt passed
        Assert.assertEquals(actualMdrdResult, "74 мл/мин/1.73м" + 2); //Negative - as in presentation
        Assert.assertEquals(mdrdDiagnosis.getText(), "Незначительно сниженный уровень СКФ (C2)");
        Assert.assertEquals(actualCgeResult, "73.18 мл/мин"); //Positive
        Assert.assertEquals(actualCgeResult, "70 мл/мин"); // Negative - as in presentation
//        Thread.sleep(3000);
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
