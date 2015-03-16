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

    @FindBy(css = "[href*=profile]")
    private WebElement userProfile;


    public UserProfileForAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void clickOnProfileDrop() {
        userDropdownToggle.click();
    }

    public void clickOnUserProfile() {
        clickOnProfileDrop();
        userProfile.click();
    }

}
