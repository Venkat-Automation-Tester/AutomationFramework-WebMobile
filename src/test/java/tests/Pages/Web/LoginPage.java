package tests.Pages.Web;

import Helper.utils;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class LoginPage {
    public static SHAFT.GUI.WebDriver driver;
//    private WebDriverWait wait;


    // 🔹 Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]");   // example

    // 🔹 High-level login method
    public LoginPage WebLogin(String userName, String password) throws InterruptedException {
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
        return this;
    }

    public LoginPage enterUsername(String username) throws InterruptedException {
        utils.waitForElementToPresent(driver,usernameField,5);
        driver.element().clear(usernameField).typeAppend(usernameField,username);
        return this;
    }

    public LoginPage enterPassword(String password) throws InterruptedException {
        utils.waitForElementToPresent(driver,passwordField,5);
        driver.element().clear(passwordField).typeAppend(passwordField,password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.element().click(loginButton);
        return this;
    }



    public LoginPage webLogin(String loginname, String password) throws InterruptedException {
//        need to create method
        WebLogin("Admin","admin123");
        return this;
    }
}

