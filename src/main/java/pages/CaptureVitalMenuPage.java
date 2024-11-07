package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaptureVitalMenuPage {
    private final WebDriver driver;
    public CaptureVitalMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public CaptureVitalFormPage captureVitals(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("patient-search")).sendKeys("1001MH");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[1]"),"1001MH"));
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr")).click();
        return new CaptureVitalFormPage(driver);
    }
}

