import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 01.12.2014.
 */
public class TableTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://devck-cms.sourceforge.net/ecm/");
    }

    @Test
    public void disabledLinkTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-dev@example.com", "demo-dev");


        assertEquals("not-allowed", driver.findElement(By.cssSelector(".disabled>a")).getCssValue("cursor"));

    }

    @Test
    public void verifyNoErrorsInTable() {


        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-dev@example.com", "demo-dev");

        List<WebElement> list = driver.findElements(By.cssSelector(".panel-body tbody tr"));


        for (WebElement element : list) {

            System.out.println(element.getText());

            assertNotEquals("ERROR", element.findElement(By.cssSelector("td:nth-child(2)")).getText());

        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
