package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void doSuccessfulLogin(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.chooseInpatientWard();
        loginPage.clickLoginButton();
    }
}
