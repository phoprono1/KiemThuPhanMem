package searchTests;
import base.BaseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class SearchTest extends BaseTests {
    //private WebDriver driver;

    @Test
    @DisplayName("TC01-Verify that results are displayed correctly when entering a valid ID search term.")
    public void TC01(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("100");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String result = searchPage.getSearchId();
        Assertions.assertTrue(result.contains("100"), "Search text is incorrect!");
    }

    @Test
    @DisplayName("TC02-Verify that no results are displayed when the user enters the search term ID does not exist.")
    public void TC02(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("2323");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20,   TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td"))));
        String result = searchPage.getAlert();

        Assertions.assertTrue(result.contains("No matching records found"), "Search text is incorrect!");
    }

    @Test
    @DisplayName("TC03-Verify that the search function shows all listings when the search query is empty")
    public void TC03(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String result = searchPage.getSearchId();
        if(result.isEmpty()){
            Assertions.assertTrue(false, "Search text is incorrect!");
        }else {
            Assertions.assertTrue(true, "Search text is correct!");
        }

    }

    @Test
    @DisplayName("TC04-Verify that results are displayed correctly when entering an ID search term " +
            "with leading and trailing spaces")
    public void TC04(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt(" 100 ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String result = searchPage.getSearchId();
        Assertions.assertTrue(result.contains("100"), "Search text is incorrect!");
    }


    @Test
    @DisplayName("TC05-Verify that results are displayed correctly when entering a valid name search term.")
    public void TC05(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("John");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getSearchName();
        Assertions.assertTrue(result.contains("John"), "Search text is incorrect!");
    }

    @Test
    @DisplayName("TC06-Verify that no results are displayed when the user enters a search term for a name that does not exist.")
    public void TC06(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("wdfje");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getAlert();

        Assertions.assertTrue(result.contains("No matching records found"), "Search text is incorrect!");

    }

    @Test
    @DisplayName("TC07-Verify that results are displayed correctly when entering a name search " +
            "term with leading and trailing spaces.")
    public void TC07(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt(" John ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getSearchName();
        Assertions.assertTrue(result.contains("John"), "Search text is incorrect!");

    }

    @Test
    @DisplayName("TC08-Verify that results are displayed correctly when entering a lowercase name search term")
    public void TC08(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("john");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getSearchName();
        Assertions.assertTrue(result.contains("John"), "Search text is incorrect!");
    }

    @Test
    @DisplayName("TC09-Verify that results are displayed correctly when entering a uppercase name search term")
    public void TC09(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("JOHN");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getSearchName();
        Assertions.assertTrue(result.contains("John"), "Search text is incorrect!");
    }

    @Test
    @DisplayName("TC10-Verify that results are displayed correctly when entering a uppercase name search term")
    public void TC10(){
        LoginPage loginPagee = loginPage;
        loginPagee.setUserName("Admin");
        loginPagee.setPassword("Admin123");
        HomePage homePage = loginPagee.clickLoginButton();
        SearchPage searchPage = homePage.clickFindPatientRecord();
        searchPage.setSearchTxt("jOhN");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = searchPage.getSearchName();
        Assertions.assertTrue(result.contains("John"), "Search text is incorrect!");
    }


}