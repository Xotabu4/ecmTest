import helpers.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver = null;

    @BeforeSuite
    public static void beforeAll() throws Exception {
        driver = WebDriverHelper.get();
        System.out.println("BEFORE ALL IS EXECUTED");

    }

    @AfterSuite
    public static void afterAll() {
        driver.quit();
        System.out.println("AFTER ALL TESTS EXECUTED");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver.get("http://devck-cms.sourceforge.net/ecm/");
        System.out.println("BEFORE TEST EXECUTED");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        System.out.println("AFTER TEST EXECUTED");
    }

}
