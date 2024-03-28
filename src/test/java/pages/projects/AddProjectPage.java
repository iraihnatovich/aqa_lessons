package pages.projects;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddProjectPage extends BasePage {

    @FindBy(id = "name")
    public WebElement projectNameInput;
    @FindBy(id = "accept")
    public WebElement addProjectButton;

    @FindBy(id = "announcement_display")
    public WebElement announcementTextInput;

    @FindBy(id = "show_announcement")
    public WebElement showAnnouncementCheckbox;

    @FindBy(name = "suite_mode")
    public List<WebElement> modeRadioButtonsList;

    @FindBy(id = "case_statuses_enabled")
    public WebElement caseApprovalCheckbox;


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return projectNameInput;
    }


    public AddProjectPage enterProjectName(String name) {
        projectNameInput.sendKeys(name);
        return this;
    }

    public AddProjectPage enterProjectAnnouncement(String announcement) {
        announcementTextInput.sendKeys(announcement);
        return this;

    }

    public AddProjectPage setShowAnnouncement(Boolean isShown) {
        if (isShown) {
            showAnnouncementCheckbox.click();
        }
        return this;
    }

    public AddProjectPage setProjectType(int index) {
        modeRadioButtonsList.get(index).click();
        return this;
    }

    public AddProjectPage setCasesApproval(boolean isApprovalEnabled) {
        if (isApprovalEnabled) {
            caseApprovalCheckbox.click();
        }
        return this;
    }

    public ProjectsGridPage clickAddProjectButton() {
        addProjectButton.click();
        return new ProjectsGridPage(driver);
    }
    public ProjectsGridPage addMinimalSetProject(Project project) {
        enterProjectName(project.getName())
                .clickAddProjectButton();
        return new ProjectsGridPage(driver);
    }

    public ProjectsGridPage addFullySetProject(Project project) {
        this.enterProjectAnnouncement(project.getAnnouncement())
                .setShowAnnouncement(project.isAnnouncementShown())
                .setProjectType(project.getProjectType())
                .setCasesApproval(project.isApprovalEnabled())
                .addMinimalSetProject(project);
        return new ProjectsGridPage(driver);
    }




}
