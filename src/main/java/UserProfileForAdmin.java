import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfileForAdmin {
    private final WebDriver driver;

    @FindBy(css = ".dropdown-toggle")
    private WebElement userDropdownToggle;

    @FindBy(css = ".dropdown-menu.dropdown-user>li>a")
    private WebElement userProfile;


    public UserProfileForAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open() {
        this.driver.get("http://devck-cms.sourceforge.net/ecm/");
    }

    public void clickOnProfileDrop() {
        driver.findElement(By.cssSelector(".dropdown-toggle"));
    }

    public void clickOnUserProfile() {
        driver.findElement(By.cssSelector(".dropdown-menu.dropdown-user>li>a"));
    }

}
