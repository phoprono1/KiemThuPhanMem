package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class LoginPage {
    private WebDriver driver;
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By inpatientWardSelect = By.id("Inpatient Ward");
    private final By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName (String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void chooseInpatientWard(){
        driver.findElement(inpatientWardSelect).click();
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }


}
