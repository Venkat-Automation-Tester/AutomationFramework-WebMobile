package tests.Pages.Android;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    SHAFT.GUI.WebDriver driver;

    /// / constructor ////
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    By getStarted = By.xpath("//android.widget.TextView[@text='Get Started']");
    By login = By.xpath("//android.widget.TextView[@text='Login']");
    By mobileTextField = By.xpath("//android.widget.EditText/android.view.View[3]");
    By getOTP_Button = By.xpath("//android.widget.TextView[@text='Get OTP']");
    By proceed_Button = By.xpath("//android.widget.TextView[@text='Proceed']");
    private By otp(String value) {return By.xpath("//android.widget.TextView[@text='" + value + "'");}
    By back_Button = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]");


    public LoginPage clickOnGetStarted(){

        return this;
}

    public LoginPage Mobilelogin(String mobileNumber, String otp, String executionDevie) {
        System.out.println("We will move on to further");
        System.out.println(mobileNumber);
        System.out.println(otp);

        return this;
    }
}
