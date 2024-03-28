//package steps;
//
//import baseEntities.BaseSteps;
//import models.Project;
//import org.openqa.selenium.WebDriver;
//import pages.DashboardPage;
//import pages.projects.AddProjectPage;
//import pages.projects.ProjectsGridPage;
//
//public class ProjectSteps extends BaseSteps {
//    private DashboardPage dashboardPage;
//    private AddProjectPage addProjectPage;
//
//    public ProjectSteps(WebDriver driver) {
//        super(driver);
//    }
//
//    public ProjectsGridPage addMinimalSetProjectFromDashboard (Project project){
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.clickAddProjectSideButton();
//        addProjectPage = new AddProjectPage(driver);
//        return addProjectPage.addMinimalSetProject(project);
//    }
//}
