package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    private By FindPatientRecord = By.xpath("//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage clickFindPatientRecord(){
        driver.findElement(FindPatientRecord).click();
        return new SearchPage(driver);
    }

}