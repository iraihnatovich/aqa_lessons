package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class MyTest extends BaseTest {

    @Test
    public void test() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(
                dashboardPage
                        .clickAddProjectSideButton()
                        .addMinimalSetProject(testProject)
                        .isProjectInGrid(testProject));
    }

}
