import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;

public class TestColor extends BaseTest {

    @Test
    public void colorElement() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo-pm@example.com", "demo-pm");
        driver.get("http://devck-cms.sourceforge.net/ecm/projects/project/projectlist");

        assertEquals("rgba(92, 184, 92, 1)",
                driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/span"))
                .getCssValue("background-color"));

    }


}

