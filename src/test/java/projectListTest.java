import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by reflecti0n on 06.12.2014.
 */
public class projectListTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://devck-cms.sourceforge.net/ecm/");
    }

    @Test
    public void CheckNamesInProjectListTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-pm@example.com", "demo-pm");

        Thread.sleep(2000);

        driver.get("http://devck-cms.sourceforge.net/ecm/projects/project/projectlist");

        List<WebElement> list = driver.findElements(By.cssSelector(".table.table-striped.table-bordered.table-hover>tbody>tr td:nth-child(2)"));

        for (WebElement element : list) {

            System.out.println(element.getText());

            assertNotEquals("", element.getText());

        }

    }

    @Test
    public void ClickAndQuitTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-pm@example.com", "demo-pm");

        Thread.sleep(3000);

        driver.get("http://devck-cms.sourceforge.net/ecm/projects/project/projectlist");

        List<WebElement> list = driver.findElements(By.cssSelector(".glyphicon.glyphicon-info-sign"));

        for (WebElement element : list) {

            element.click();

            Thread.sleep(1500);

            driver.findElement(By.cssSelector(".close")).click();

            Thread.sleep(3000);


        }

    }
}
