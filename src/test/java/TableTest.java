import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TableTest extends BaseTest {

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
}
