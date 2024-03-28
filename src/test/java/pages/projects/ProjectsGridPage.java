package pages.projects;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsGridPage extends BasePage {

    @FindBy(className = "grid")
    public WebElement projectsGrid;

    @FindBy(css = ".hoverSensitive")
    public List<WebElement> projectsInGrid;

    public ProjectsGridPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return projectsGrid;
    }

//    public String getNameFromGrid(int x){
//        return projectsInGrid.get(x).getText().trim();
//    }

    public boolean isProjectInGrid(Project project) {
        for (WebElement element :
                projectsInGrid) {
            if (element.getText().trim().equals(project.getName())) {
                return true;
            }
        }
        return false;
    }
//    public boolean isProjectInGrid(String project){
//        for (WebElement element:
//                projectsInGrid) {
//            if (element.getText().trim().equals(project)){
//                return true;
//            }
//        }
//        return false;
//    }
}
