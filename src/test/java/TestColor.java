import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProjectsListPage;

import static org.junit.Assert.assertTrue;

public class TestColor extends BaseTest {

    @Test
    public void colorElement() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-pm@example.com", "demo-pm");

        ProjectsListPage projectsListPage = new ProjectsListPage(driver);
        projectsListPage.open();
        assertTrue(projectsListPage.IsLablesHasCorrectColors());
    }


}

