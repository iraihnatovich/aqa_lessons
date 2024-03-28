//package pages.projects;
//
//import baseEntities.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class ProjectInfoPage extends BasePage {
//    // //tbody//a[text()='demo'] ?????
//    //    // //div[@class="content-header-title page_title"] .getText().trim()
//    @FindBy (css = ".content-header-title")
//    public WebElement projectTitle;
//
//    public ProjectInfoPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    protected WebElement getPageIdentifier() {
//        return projectTitle;
//    }
//
//    public String getProjectTitleText() {
//        return projectTitle.getText().trim();
//    }
//}
