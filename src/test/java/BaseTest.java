import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("BEFORE CLASS IS EXECUTED");

        System.out.println(System.getProperty("use.Browser"));
        //mvn clean test -Duse.Browser=firefox
    }

    @AfterClass
    public static void afterAll() {
        driver.quit();
        System.out.println("AFTER ALL TESTS EXECUTED");
    }

    @Before
    public void setUp() throws Exception {
        driver.get("http://devck-cms.sourceforge.net/ecm/");
        System.out.println("BEFORE TEST EXECUTED");
    }

    @After
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        System.out.println("AFTER TEST EXECUTED");
    }

}
