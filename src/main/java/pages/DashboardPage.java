package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPage {
    private final WebDriver driver;
    private final By appointmentSchedulingButton = By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension");

    private final By captureVitalButton = By.id("referenceapplication-vitals-referenceapplication-vitals-extension");
    public DashboardPage (WebDriver driver){
        this.driver = driver;
    }
    public AppointmentSchedulingPage clickAppointmentScheduling(){
        driver.findElement(appointmentSchedulingButton).click();
        return new AppointmentSchedulingPage(driver);
    }

    public CaptureVitalMenuPage clickCaptureVitals(){
        driver.findElement(captureVitalButton).click();
        return new CaptureVitalMenuPage(driver);
    }


    public void addDummyPatientRequest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("patient-search")).sendKeys("1001MH");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[1]"),"1001MH"));
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[3]/div/ul[2]/li[4]/a/div/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("appointment-type")).sendKeys("Gynecology");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/form/p[1]/ul/li[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/form/div/input[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}