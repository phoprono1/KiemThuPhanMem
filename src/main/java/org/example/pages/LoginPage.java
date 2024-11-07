package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    private final By userNameTxt = By.id("username");
    private final By passwordTxt = By.id("password");
    private final By inpatientWardSelect = By.id("Inpatient Ward");
    private final By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName (String username){
        driver.findElement(userNameTxt).sendKeys(username);
    }

    public void setPassword (String password){ driver.findElement(passwordTxt).sendKeys(password); }

    public void chooseInpatientWard(){
        driver.findElement(inpatientWardSelect).click();
    }

    public void pressEnterKey() {
        driver.findElement(passwordTxt).sendKeys(Keys.ENTER);
    }

    public void pressBack() {
        driver.navigate().back();
    }

    public void pressTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage doSuccessfulLogin(){
        setUserName("Admin");
        setPassword("Admin123");
        chooseInpatientWard();
        return clickLoginButton();
    }
}
