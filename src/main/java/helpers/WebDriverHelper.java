package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {
    static WebDriver driver = null;

    public static WebDriver get() throws Exception {
        if (driver == null) {
            if (null == System.getProperty("useBrowser")) {
                System.out.println("No property found. Using Firefox driver");
                driver = new FirefoxDriver();
            } else if (System.getProperty("useBrowser").contains("firefox")) {
                System.out.println("Property value: " + System.getProperty("useBrowser") + " - creating Firefox driver");
                driver = new FirefoxDriver();
            } else if (System.getProperty("useBrowser").contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                System.out.println("Property value: " + System.getProperty("useBrowser") + " - creating Chrome driver");
                driver = new ChromeDriver();
            } else if (System.getProperty("useBrowser").contains("htmlunit")) {
                System.out.println("Property value: " + System.getProperty("useBrowser") + " - creating HTMLUnit driver");
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
