package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductSteps extends BaseSteps {
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        super(driver);
        this.productsPage = new ProductsPage(driver);
    }

    public void addToCart(int productPosition) {
        productsPage.getAddButtonOfSingleItem(productPosition).click();
    }
}
