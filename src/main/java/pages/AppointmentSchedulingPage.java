package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppointmentSchedulingPage {
    private final WebDriver driver;
    private final By manageProviderButton = By.id("appointmentschedulingui-scheduleProviders-app");
    private final By manageAppointmentsButton = By.id("appointmentschedulingui-manageAppointments-app");

    public AppointmentSchedulingPage(WebDriver driver) {
        this.driver = driver;
    }

    public ManageAppointmentsPage manageAppointmentsPage() {
        driver.findElement(manageAppointmentsButton).click();
        return new ManageAppointmentsPage(driver);
    }

    public void createDummyAppointmentSchedule() {
        driver.findElement(manageProviderButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LocalDateTime today = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<WebElement> listOfDates = driver.findElements(By.className("fc-day"));
        WebElement todayElement = null;
        for (WebElement we : listOfDates) {
            if (we.getAttribute("data-date").equals(today.format(formatter))) {
                todayElement = we;
                break;
            }
        }
        assert todayElement != null;
        todayElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[2]/input")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/selectmultipleappointmenttypes/div/div[1]/div[1]/div/input")).sendKeys("Gynecology");
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/selectmultipleappointmenttypes/div/div[1]/div[1]/div/ul/li[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[4]/button[2]")).click();
        driver.navigate().back();
    }
}
