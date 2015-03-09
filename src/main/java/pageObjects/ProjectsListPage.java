package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProjectsListPage {
    private final WebDriver driver;

    @FindBy(css = ".table")
    private WebElement projectsTable;

    @FindBy(css = "span.lable")
    private List<WebElement> isActiveLables;

    public ProjectsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open() {
        this.driver.get("http://devck-cms.sourceforge.net/ecm/projects/project/projectlist");

    }

    public boolean IsLablesHasCorrectColors() {
        for (WebElement lable : isActiveLables) {
            if (lable.getAttribute("class").contains("lable-success")) {
                if (!lable.getCssValue("background-color").equalsIgnoreCase("rgba(92, 184, 92, 1)")) {
                    return false;
                }
            } else {
                if (!lable.getCssValue("background-color").equalsIgnoreCase("rgba(217, 83, 79, 1)")) {
                    return false;
                }
            }
        }
        return true;
    }
}
