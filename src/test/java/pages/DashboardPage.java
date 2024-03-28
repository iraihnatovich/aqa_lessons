package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.projects.AddProjectPage;

public class DashboardPage extends BasePage {
    @FindBy(id = "sidebar-projects-add")
    public WebElement addProjectSideButton;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return addProjectSideButton;
    }

    public AddProjectPage clickAddProjectSideButton() {
        addProjectSideButton.click();
        return new AddProjectPage(driver);
    }
}
