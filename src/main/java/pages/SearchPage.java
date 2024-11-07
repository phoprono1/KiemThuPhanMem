package pages;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchPage {
    private WebDriver driver;

    private By searchTxt = By.xpath("//*[@id=\"patient-search\"]");
    private By SearchId = By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[1]");
    private By SearchName = By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[2]");
    private By empty = By.className("dataTables_empty");
    private By patientDetail = By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]");



    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchTxt(String userName){
        driver.findElement(searchTxt).sendKeys(userName);
    }

    public String getAlert(){
        return driver.findElement(empty).getText();
    }

    public String getSearchId(){
        return driver.findElement(SearchId).getText();
    }
    public String getSearchName(){
        return driver.findElement(SearchName).getText();
    }

    public PatientDetailPage clickViewPatientDetail(){
        driver.findElement(patientDetail).click();
        return new PatientDetailPage(driver);
    }
}