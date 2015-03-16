import org.testng.annotations.Test;
import pageObjects.LoginPage;
import static org.junit.Assert.assertSame;


public class TestUserProfile extends BaseTest {
    @Test
    public void userProfileTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-pm@example.com", "demo-pm");
        UserProfileForAdmin userProfileForAdmin = new UserProfileForAdmin(driver);
        userProfileForAdmin.clickOnUserProfile();
        assertSame(driver.getCurrentUrl(),
                "http://devck-cms.sourceforge.net/ecm/users/user/profile");
    }


}

