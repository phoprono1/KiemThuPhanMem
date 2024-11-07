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
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //cho thoi gian may no nhap du lieu vao
        driver.manage().timeouts().implicitlyWait(20,   TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginButton\"]")));

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    public static void main(String[] args){
        BaseTests tests = new BaseTests();
        tests.setUp();
    }








}