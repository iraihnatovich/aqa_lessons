package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    private final By productItemLocator = By.cssSelector(".inventory_item");
    private final By addButtonLocator = By.cssSelector(".btn_inventory");
    private final By cartButtonLocator = By.cssSelector("#shopping_cart_container");
    private final int amountOfItemsPerPage = 6;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return productItemLocator;
    }


    public boolean isPageOpened() {
        return getAllProductsOnPage().size() == amountOfItemsPerPage;
    }

    public List<WebElement> getAllProductsOnPage() {
        return wait.waitForAllVisibleElementsLocatedBy(productItemLocator);
    }

    public WebElement getAddButtonOfSingleItem(int index) {
        return wait.waitForAllVisibleElementsLocatedBy(addButtonLocator).get(index);
    }

    public WebElement getCartButton() {
        return wait.waitForVisibilityLocatedBy(cartButtonLocator);
    }

}
