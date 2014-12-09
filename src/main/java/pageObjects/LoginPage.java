package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 01.12.2014.
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {

       this.driver = driver;
    }


    public void login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    private void clickLoginButton() {
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-success.btn-block")).click();
    }

    private void typePassword(String password) {
        type(password, "password");
    }

    private void typeEmail(String email) {
        type(email, "emailid");
    }

    private void type(String value, String idLocator) {
        driver.findElement(By.id(idLocator)).clear();
        driver.findElement(By.id(idLocator)).sendKeys(value);
    }



}
