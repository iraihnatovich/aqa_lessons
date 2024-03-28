package steps;

import baseEntities.BaseSteps;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class NavigationSteps extends BaseSteps {
    private LoginPage loginPage;
    public NavigationSteps(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(User user){
        loginPage = new LoginPage(driver);
        return loginPage.successfulLogin(user);
    }
}
