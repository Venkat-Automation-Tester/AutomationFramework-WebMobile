package tests.Tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.BaseTestWeb;
import tests.Pages.Web.DashBoard;

public class Web_Dashbord_Functionality extends BaseTest
{
        @Test(priority = 1)
        public void Dashboard_Fun() {
         new DashBoard(driver).clickAdmin()
                 .clickPIM()
                 .clickLeave()
//        .clickTime()
                 .clickRecruitment()
                 .clickMyInfo();
//        .clickPerformance()
//        .clickDashboard()
//        .clickDirectory()
//        .clickMaintenance()
//        .clickClaim()
//        .clickBuzz();
        System.out.print("Dashboard functionality verified successfully");
        }
    }


