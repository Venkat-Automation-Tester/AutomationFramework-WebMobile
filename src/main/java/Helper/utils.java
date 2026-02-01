package Helper;

//import io.appium.java_client.MobileElement;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class utils {
    public static boolean appState;



    public static WebElement waitForElementToPresent(SHAFT.GUI.WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            // WebDriverWait to wait for the element to be present/visible
            WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            // Element was not found within the timeout, return null to avoid exception
            System.out.println(locator + ": Element not found within timeout");
            return null;
        }
    }

    public static void verifyAndClick(SHAFT.GUI.WebDriver driver, By by) {
        driver.element().verifyThat(by).exists().perform();
        driver.element().click(by);
    }
}
