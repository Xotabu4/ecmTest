package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WebDriverHelper {
    private static Logger LOGGER = Logger.getLogger(WebDriverHelper.class.getName());

    static WebDriver driver = null;

    public static WebDriver get() throws Exception {
        if (driver == null) {
            if (null == System.getProperty("useBrowser")) {
                LOGGER.info("No property found. Using Firefox driver");
                driver = new FirefoxDriver();
            } else if (System.getProperty("useBrowser").contains("firefox")) {
                LOGGER.info("Property value: " + System.getProperty("useBrowser") + " - creating Firefox driver");
                driver = new FirefoxDriver();
            } else if (System.getProperty("useBrowser").contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                LOGGER.info("Property value: " + System.getProperty("useBrowser") + " - creating Chrome driver");
                driver = new ChromeDriver();
            } else if (System.getProperty("useBrowser").contains("htmlunit")) {
                LOGGER.info("Property value: " + System.getProperty("useBrowser") + " - creating HTMLUnit driver");
                driver = new HtmlUnitDriver();
            } else {
                throw new Exception("Unsupported browser. " +
                        "Expected to be - chrome , firefox, htmlunit, but was - " + System.getProperty("useBrowser"));
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
}
