package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "emailid")
    private WebElement emailField;

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
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
        type(passwordField, password);
    }

    private void typeEmail(String email) {
        type(emailField, email);
    }

    private void type(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }



}
