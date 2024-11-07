package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {
    public static Logger logger = LogManager.getLogger();

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static BaseElements ome;

    @BeforeClass
    public void InitialProcedure() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-websocket-over-http2");
        options.addArguments("--remote-allow-origins=*"); // Thử thêm tùy chọn này để kiểm tra quyền truy cập

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ome = new BaseElements();
        LoginTest();
    }

    @AfterClass
    public void CloseProcedure() {
        base.Tools.wait(2);
        driver.quit();
        logger.info("Driver Closed");
    }

    public void LoginTest() {
        logger.info("Login Page Procedure Started");
        driver.get(" https://demo.openmrs.org/openmrs/login.htm");
        logger.info("Login Page Procedure Finished");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Method started");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.info(result.getName() + " Method finished " + (result.getStatus() == 1 ? "Passed" : "failed"));
    }
}
