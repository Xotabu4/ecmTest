import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://devck-cms.sourceforge.net/ecm/");
    }

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

    //author - VLAD
    @Test
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


    //New COMMENT! Git HUB change
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
