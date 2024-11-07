package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PatientDetailPage {
    private WebDriver driver;
    private By name = By.xpath("//*[@id=\"breadcrumbs\"]/li[2]");


    public PatientDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getName(){
        return driver.findElement(name).getText();
    }


}