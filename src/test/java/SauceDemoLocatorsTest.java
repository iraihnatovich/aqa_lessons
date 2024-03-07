import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).sendKeys(ReadProperties.getUserName());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.getPassword());
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "Hamburger menu elements")
    public void burgerMenuTest() throws InterruptedException {
        driver.findElement(By.className("bm-burger-button")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.linkText("About")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Reset App")).isDisplayed());
    }

    @Test(testName = "Footer presence")
    public void hasFooterTest() { //or select dropdown??????
        Assert.assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

    @Test(testName = "Logo presence")
    public void hasLogoTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".app_logo")).isDisplayed());
    }

    @Test(testName = "Elements in Empty Cart")
    public void emptyCartTest() {
        driver.findElement(By.cssSelector(".primary_header .shopping_cart_container")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span")).getText(), "Your Cart");
        Assert.assertTrue(driver.findElement(By.cssSelector(".back.btn_medium")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.bm-burger-button")).isDisplayed());
    }

    @Test(testName = "Add item to cart")
    public void addCartTest() {
        driver.findElement(By.cssSelector("[name='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector("[id*='cart_cont']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$='cart_badge']")).getText(), "1");
        Assert.assertTrue(driver.findElement(By.cssSelector("[name|='remove']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='item_4_title']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='checkout_button']")).isDisplayed());
    }

    @Test (testName = "Item page view")
    public void singleItemPageTest(){
        driver.findElement(By.xpath("//a[@id='item_0_title_link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(), 'A red light')]")).getText(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'price')]")).getText(), "$9.99");
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::img[@class='bm-icon']")).isDisplayed());
    }

    @Test (testName = "DropDown presence")
    public void dropDownTest(){
        Assert.assertTrue(driver.findElement(By.xpath("//option/parent::select")).isDisplayed()); //maybe smth different?????
// //button[contains(@id, 'remove')]/ancestor::div[@class="inventory_item"]
    }

    @Test (testName = "Social links list")
    public void footerLinksTest(){ //different????
        Assert.assertTrue(driver.findElement(By.xpath("//a/ancestor::ul")).isDisplayed());
    }

    // //div[@class='cart_item']/following::button[contains(@id, 'remove')] remove one out of 2(!!!) from cart

    // //a[@id="about_sidebar_link"]/preceding::a    navig to product, burger - all items - click

    @AfterMethod()
    public void quitBrowser() {
        driver.quit();
    }

}

