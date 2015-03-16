import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class TestUserProfile extends BaseTest {
    @Test(enabled=false)
    public void userProfileTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo-pm@example.com", "demo-pm");
        UserProfileForAdmin userProfileForAdmin = new UserProfileForAdmin(driver);
        userProfileForAdmin.open();
        assertSame("http://devck-cms.sourceforge.net/ecm/users/user/profile", "http://devck-cms.sourceforge.net/ecm/users/user/profile)");
    }


}

