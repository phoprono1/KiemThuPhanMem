package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By formLoginLink = By.linkText("Form Authentication");

    public DashboardPage (WebDriver driver){
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public LoginPage clickForm(){
        driver.findElement(formLoginLink).click();
        return new LoginPage(driver);
    }
}