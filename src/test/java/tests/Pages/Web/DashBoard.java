package tests.Pages.Web;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import com.shaft.gui.element.TouchActions;
import org.openqa.selenium.By;

public class DashBoard {
    private final SHAFT.GUI.WebDriver driver;

    // 🔹 Constructor
    public DashBoard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Locators
    private final By SearchField   = By.xpath("//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')]");
    private final By Admin         = By.xpath("//a[@class='oxd-main-menu-item']//span[text()='Admin']");
    private final By PIM           = By.xpath("//a[@class='oxd-main-menu-item']//span[text()='PIM']");
    private final By Leave         = By.xpath("//a[@class='oxd-main-menu-item']//span[text()='Leave']");
    private final By Time          = By.xpath("//a[contains(@class,'oxd-main-menu-item')]//span[text()='Time']");
    private final By Recruitment   = By.xpath("//a[span[text()='Recruitment']]");
    private final By MyInfo        = By.xpath("//a[@class='oxd-main-menu-item']//span[text()='My Info']");
    private final By Performance   = By.xpath("//a[span[text()='Performance']]");
    private final By DashboardTab  = By.xpath("//a[span[text()='Dashboard']]");
    private final By Directory     = By.xpath("//a[span[text()='Directory']]");
    private final By Maintenance   = By.xpath("//a[span[text()='Maintenance']]");
    private final By Claim         = By.xpath("//a[span[text()='Claim']]");
    private final By Buzz          = By.xpath("//a[span[text()='Buzz']]");

    // 🔹 Actions
    public DashBoard enterSearchField(String text) {
        driver.element().typeAppend(SearchField, text);
        ReportManager.log("Entered text in Search Field: " + text);
        return this;
    }

    public DashBoard clickAdmin()       { return clickTab(Admin, "Admin"); }
    public DashBoard clickPIM()         { return clickTab(PIM, "PIM"); }
    public DashBoard clickLeave()       { return clickTab(Leave, "Leave"); }
    public DashBoard clickTime()        { return clickTab(Time, "Time"); }
    public DashBoard clickRecruitment() { return clickTab(Recruitment, "Recruitment"); }
    public DashBoard clickMyInfo()      { return clickTab(MyInfo, "My Info"); }
    public DashBoard clickPerformance() { return clickTab(Performance, "Performance"); }
    public DashBoard clickDashboard()   { return clickTab(DashboardTab, "Dashboard"); }
    public DashBoard clickDirectory()   { return clickTab(Directory, "Directory"); }

    public DashBoard clickMaintenance() {
        driver.touch().swipeElementIntoView("Maintenance", TouchActions.SwipeMovement.VERTICAL);
        return clickTab(Maintenance, "Maintenance");
    }

    public DashBoard clickClaim() {
        driver.touch().swipeElementIntoView("Claim", TouchActions.SwipeMovement.VERTICAL);
        return clickTab(Claim, "Claim");
    }

    public DashBoard clickBuzz() {
        driver.touch().swipeElementIntoView("Buzz", TouchActions.SwipeMovement.VERTICAL);
        return clickTab(Buzz, "Buzz");
    }

    // 🔹 Reusable private method
    private DashBoard clickTab(By locator, String tabName) {
        driver.element().click(locator);
        ReportManager.log("Clicked on " + tabName + " tab");
        return this;
    }
}
