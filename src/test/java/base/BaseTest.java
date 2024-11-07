package base;


import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }



    public static void main(String[] args) {
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
