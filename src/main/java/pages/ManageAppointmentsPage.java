package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManageAppointmentsPage {
    private final WebDriver driver;
    private final By searchField = By.id("patient-search");
    private final By toastField = By.xpath("/html/body/div[2]/div/div/p");
    private final By noResultField = By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/div[5]");
    public ManageAppointmentsPage(WebDriver driver){
        this.driver = driver;
    }

    public void accessPatientAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("patient-search")).sendKeys("1001MH");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr[1]/td[1]"),"1001MH"));
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr")).click();
    }

    public void bookRequestedAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[3]/div[2]/div[1]/table/tbody/tr[2]/td[4]/span[1]")));
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[2]/div[1]/table/tbody/tr[2]/td[4]/span[1]")).click();
        bookAppointment();
    }

    public void bookNonRequestedAppointment(String key, int continueOrNot){
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(key);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/div[2]/div[1]/ul/li[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/div[3]/button[2]")).click();
        if (continueOrNot == 1) bookAppointment();
    }

    public void bookAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/table/div[2]/div/div")));
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/table/div[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[1]/div[7]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div[3]/div[4]/div[2]/div[2]/button[2]")).click();
    }

    public void cancelAppointment(){
        WebElement baseTable = driver.findElement(By.id("appointmentGridTable"));
        List<WebElement> tableRows = baseTable.findElements(By.cssSelector("#appointmentGridTable > div.ngViewport.ng-scope > div > div:nth-child()"));
    }

    public String getToastField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(toastField));
        return driver.findElement(toastField).getText();
    }

    public String getNoResultField(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultField));
        return driver.findElement(noResultField).getText();
    }
}
