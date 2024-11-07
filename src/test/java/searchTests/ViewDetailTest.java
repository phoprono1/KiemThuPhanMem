package searchTests;
import base.BaseTests;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.HomePage;
import pages.PatientDetailPage;
import pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewDetailTest extends BaseTests {
    @Test
    @DisplayName("TC01-Verify the user can see detailed information about the patient.")
    public void TC01(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        PatientDetailPage patientDetailPage = searchPage.clickViewPatientDetail();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String result = patientDetailPage.getName();
        if(result.isEmpty()){
            Assertions.assertTrue(false, "View detail patient is incorrect!");
        }else {
            Assertions.assertTrue(true, "View detail patient is correct!");
        }

    }

}