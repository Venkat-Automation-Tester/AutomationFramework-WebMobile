package tests;

import org.testng.annotations.BeforeClass;
import tests.Pages.Web.DashBoard;
import tests.Pages.Web.LoginPage;

public class BaseTestWeb extends BaseTest{
    public DashBoard dashboard;
    public LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        dashboard =new DashBoard(driver);
        loginPage = new LoginPage(driver);
    }
}