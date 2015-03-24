import helpers.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

public class BaseTest {
    private static Logger LOGGER = Logger.getLogger(BaseTest.class.getName());


    protected static WebDriver driver = null;

    @BeforeSuite
    public static void beforeAll() throws Exception {
        driver = WebDriverHelper.get();
        LOGGER.info("WEbDriver created ");
    }

    @AfterSuite
    public static void afterAll() {
        driver.quit();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver.get("http://devck-cms.sourceforge.net/ecm/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
    }

}
