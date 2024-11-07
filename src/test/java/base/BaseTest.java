package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AppointmentSchedulingPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected  LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public void prepareTests(){
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.doSuccessfulLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")));
        dashboardPage.addDummyPatientRequest();
        AppointmentSchedulingPage appointmentSchedulingPage = dashboardPage.clickAppointmentScheduling();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("appointmentschedulingui-scheduleProviders-app")));
        appointmentSchedulingPage.createDummyAppointmentSchedule();
        driver.quit();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.doSuccessfulLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args){
        BaseTest test = new BaseTest();
        test.prepareTests();
    }
}
