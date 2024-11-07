package login;


import base.BaseTest;
import org.example.pages.SecureAreaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

    @Test
    @DisplayName("TC01-Login Successfully!")
    public void testLoginSucessfull() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("TC02-Login Failed!")
    public void testLoginFail1() {
        loginPage.setUserName("");
        loginPage.setPassword("");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }
    //
    @Test
    @DisplayName("TC03-Login Failed!")
    public void testLoginFail2() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("IncorrectPass");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    @Test
    @DisplayName("TC04-Login Failed!")
    public void testLoginFail3() {
        loginPage.setUserName("IncorrectUsn");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    @Test
    @DisplayName("TC05-Login Failed!")
    public void testLoginFail4() {
        loginPage.setUserName("");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }
    //
//
    @Test
    @DisplayName("TC06-Login Failed!")
    public void testLoginFail5() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Invalid username/password. Please try again."), "Alert text is incorrect");
    }

    //        Pressing 'Tab'
    @Test
    @DisplayName("TC07-Login Successfully!")
    public void testLoginSucessfull2() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.pressTab();
//      SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        loginPage.pressEnterKey();
    }


    //Pressing back
    @Test
    @DisplayName("TC08-Login Successfully!")
    public void testLoginSucessfull3() {

        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String textCheckS = secureAreaPage.getTextCheckS();
        Assertions.assertTrue(textCheckS.contains("Logged in as Super User (admin) at Inpatient Ward."), "Test check");
        loginPage.pressBack();
        Assertions.assertTrue(textCheckS.contains("Logged in as Super User (admin) at Inpatient Ward."), "Test check");
    }


    //pressing the 'Enter' key on the login page
    @Test
    @DisplayName("TC10-Login Successfully!")
    public void testLoginSucessfull4() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        loginPage.pressEnterKey();
    }
}
