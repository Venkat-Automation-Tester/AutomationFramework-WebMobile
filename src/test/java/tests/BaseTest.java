package tests;

import Helper.utils;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import tests.Pages.Web.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

public class BaseTest {
    public static SHAFT.GUI.WebDriver driver;
    public static String executionLocation;
    public static String baseURL;
    public static String OSVersion;
    public static String BrowserType;
    public static String AppBuild;
    public static String device;


    @Parameters({"loginname", "mobileNumber", "otp", "password", "executionDevie", "newLogin"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String loginname,
                      String mobileNumber,
                      String otp,
                      String password,
                      String executionDevie,
                      String newLogin) throws Exception {

        Instant start = Instant.now();
        device = executionDevie;

//        System.out.println("Last Run Status is : " + executionStatus);
        System.out.println("device: " + device);
        System.out.println("driver: " + driver);

        if (newLogin.equalsIgnoreCase("Yes")) {
            System.out.println("newLogin is Yes");
            System.out.println("create with new session");

            configEnv(device); // unchanged
            if (device.equalsIgnoreCase("Web")) {
                new LoginPage(driver).webLogin(loginname, password);
            } else {
                new tests.Pages.Android.LoginPage(driver)
                        .Mobilelogin(mobileNumber, otp, executionDevie);
            }
        }
    }


    public static void configEnv(String executionDevie) throws IOException {

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        executionLocation = props.getProperty("executionLocation");
        baseURL = props.getProperty("baseURL");
        OSVersion = props.getProperty("OSVersion");
        BrowserType = props.getProperty("BrowserVersion");
        AppBuild = props.getProperty("appBuild"); // safe even if null

        if (executionLocation == null) {
            throw new RuntimeException("executionLocation is NULL. Check config.properties");
        }

        ///  close old session  ///
        if (driver != null) {
            driver.quit();
        }

        if (executionLocation.equalsIgnoreCase("local")) {
            localSetup(executionDevie);
        }

        driver = new SHAFT.GUI.WebDriver();

        if (executionDevie.equalsIgnoreCase("web")) {
            driver.browser().navigateToURL(baseURL);
        }
    }

    public static void localSetup(String device) throws IOException {

        if (device.equalsIgnoreCase("android")) {

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/config.properties"));

        // Platform
        SHAFT.Properties.platform.set()
                .executionAddress(prop.getProperty("executionAddress"))
                .targetPlatform(prop.getProperty("targetOperatingSystem"));

        // Mobile capabilities
        SHAFT.Properties.mobile.set()
                .automationName(prop.getProperty("mobile_automationName"))
                .deviceName(prop.getProperty("mobile_deviceName"))
                .udid(prop.getProperty("mobile_udid"))
                .appPackage(prop.getProperty("mobile_appPackage"))
                .appActivity(prop.getProperty("mobile_appActivity"));

        System.setProperty("mobile_noReset", prop.getProperty("mobile_noReset"));

        driver = new SHAFT.GUI.WebDriver();
        }

        else if (device.equalsIgnoreCase("web")) {

            SHAFT.Properties.platform.set()
                    .targetPlatform(OSVersion);

            SHAFT.Properties.web.set()
                    .targetBrowserName(BrowserType);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}