import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    // author - xotabu4
    @Test
    public void testLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-dev@example.com", "demo-dev");
        assertEquals("Demo Developer", driver.findElement(By.linkText("Demo Developer")).getText());
    }
    //author - VLAD
    @Test
    public void testFailLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-deve@example.com", "demo-dev");
        assertEquals("Provide Emailid is not correct!", driver.findElement(By.cssSelector("div.alert.alert-danger")).getText());
    }
    //author - VLAD
    @Test
    public void TestNoCredentials() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "demo-dev");
        assertEquals("Emailid and Password is required!", driver.findElement(By.id("jserror")).getText());
    }

    //author - VLAD. Test failed due to bug.
    @Test
    @Ignore
    public void testNoPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-dev@example.com", "");
        assertEquals("Emailid and Password is required!", driver.findElement(By.id("jserror")).getText());
    }
    //Autor - ASK
    @Test
    public void testLoginProjectManager() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-pm@example.com", "demo-pm");
        assertEquals("demo projectmanger", driver.findElement(By.linkText("demo projectmanger")).getText());
    }

}
